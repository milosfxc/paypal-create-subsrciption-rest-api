package paypal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentMethod {
    private String payer_selected;
    private String payee_preferred;

    public PaymentMethod(String payer_selected, String payee_preferred) {
        this.payer_selected = payer_selected;
        this.payee_preferred = payee_preferred;
    }
}
