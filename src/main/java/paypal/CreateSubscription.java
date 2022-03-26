package paypal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSubscription {
    private String plan_id;
    private String start_time;
    private String quantity;
    private Subscriber subscriber;
    private ApplicationContext application_context;

    public CreateSubscription(String plan_id, String start_time, String quantity, Subscriber subscriber, ApplicationContext application_context) {
        this.plan_id = plan_id;
        this.start_time = start_time;
        this.quantity = quantity;
        this.subscriber = subscriber;
        this.application_context = application_context;
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