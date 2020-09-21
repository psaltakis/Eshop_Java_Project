package entities;

import java.util.Date;

public class PaypalPayment extends Payment{
    private String paypalAccount;

    public PaypalPayment(String paypalAccount) {
        this.paypalAccount = paypalAccount;
    }

    public PaypalPayment(int amount, String currency, Date date, String paypalAccount) {
        super(amount, currency, date);
        this.paypalAccount = paypalAccount;
    }

    public String getPaypalAccount() {
        return paypalAccount;
    }

    public void setPaypalAccount(String paypalAccount) {
        this.paypalAccount = paypalAccount;
    }
}
