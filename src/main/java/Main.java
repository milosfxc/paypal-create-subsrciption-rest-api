import com.fasterxml.jackson.databind.ObjectMapper;
import paypal.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        String clientId = "ENTER_CLIENT_ID_HERE";
        String clientSecret = "ENTER_CLIENT_SECRET_HERE";
        //login example
        String formatted = java.util.Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes(StandardCharsets.UTF_8));
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api-m.sandbox.paypal.com/v1/oauth2/token"))
                .header("Accept", "application/json")
                .header("Accept-Language", "en_US")
                .header("Authorization", "Basic " + formatted)
                .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials"))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        //example of converting java class to json
        Map<String, String> bodyRequestMap = new HashMap<>();
        bodyRequestMap.put("plan_id", "P-4MP38534VY088135KMH42U3I");
        bodyRequestMap.put("start_time", "2022-02-12T10:00:00Z");//todo enter valid date here
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBodyTest = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(bodyRequestMap);

        System.out.println(requestBodyTest);

        //create subscription example
        Name name = new Name("John", "Doe");
        Subscriber subscriber = new Subscriber(name, "sb-o11hw12339160@business.example.com");
        PaymentMethod payment_method = new PaymentMethod("PAYPAL", "IMMEDIATE_PAYMENT_REQUIRED");
        ApplicationContext application_context = new ApplicationContext("walmart", "en-US", "NO_SHIPPING", "SUBSCRIBE_NOW", payment_method, "https://www.b92.net/", "https://example.com/cancelUrl");
        CreateSubscription createSubscription = new CreateSubscription("P-4MP38534VY088135KMH42U3I","2022-02-12T20:00:00Z", "1", subscriber, application_context);

        String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(createSubscription);
        HttpRequest httpRequestCreateSubscription = HttpRequest.newBuilder()
                .uri(new URI("https://api-m.sandbox.paypal.com/v1/billing/subscriptions"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic " + formatted)
                .header("PayPal-Request-Id", "SUBSCRIPTION-02022022-002")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequestCreateSubscription, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.body());

    }
}
