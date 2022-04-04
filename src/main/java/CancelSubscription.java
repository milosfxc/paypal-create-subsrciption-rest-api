import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class CancelSubscription {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        //credentials
        String clientId = "ENTER_CLIENT_ID_HERE";
        String clientSecret = "ENTER_CLIENT_SECRET_HERE";
        String formatted = java.util.Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes(StandardCharsets.UTF_8));

        HttpClient httpClient = HttpClient.newHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("reason", "Not satisfied with the service");
        HttpRequest httpRequestCancelSubscription = HttpRequest.newBuilder()
                .uri(new URI("https://api-m.sandbox.paypal.com/v1/billing/subscriptions/I-RWMGEXP9BWSB/cancel"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic " + formatted)
                .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(requestBody)))
                .build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequestCancelSubscription, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.body());
    }
}
