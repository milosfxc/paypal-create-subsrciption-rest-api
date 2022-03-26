package paypal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Name {
    private String given_name;
    private String surname;

    public Name(String given_name, String surname) {
        this.given_name = given_name;
        this.surname = surname;
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