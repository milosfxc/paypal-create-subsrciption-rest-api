package paypal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationContext {
    private String brand_name;
    private String locale;
    private String shipping_preference;
    private String user_action;
    private PaymentMethod payment_method;
    private String return_url;
    private String cancel_url;

    public ApplicationContext(String brand_name, String locale, String shipping_preference, String user_action, PaymentMethod payment_method, String return_url, String cancel_url) {
        this.brand_name = brand_name;
        this.locale = locale;
        this.shipping_preference = shipping_preference;
        this.user_action = user_action;
        this.payment_method = payment_method;
        this.return_url = return_url;
        this.cancel_url = cancel_url;
    }
}
/*


"plan_id": "P-4MP38534VY088135KMH42U3I",
  "start_time": "2022-02-12T10:00:00Z",
  "quantity": "1",
  "subscriber": {
    "name": {
      "given_name": "John",
      "surname": "Doe"
    },
    "email_address": "sb-o11hw12339160@business.example.com"

  },
  "application_context": {
    "brand_name": "walmart",
    "locale": "en-US",
    "shipping_preference": "NO_SHIPPING",
    "user_action": "SUBSCRIBE_NOW",
    "payment_method": {
      "payer_selected": "PAYPAL",
      "payee_preferred": "IMMEDIATE_PAYMENT_REQUIRED"
    },
    "return_url": "https://www.b92.net/",
    "cancel_url": "https://example.com/cancelUrl"
  }
}'

* */
