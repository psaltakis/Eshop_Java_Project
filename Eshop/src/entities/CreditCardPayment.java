package entities;

import java.util.Date;

public class CreditCardPayment extends Payment{
    private int cardNumber;
    private String holderName;
    private int securityCode;

    public CreditCardPayment() {
        super();
    }

    public CreditCardPayment(int cardNumber, String holderName, int securityCode) {
        this.cardNumber = cardNumber;
        this.holderName = holderName;
        this.securityCode = securityCode;
    }

    public CreditCardPayment(int amount, String currency, Date date, int cardNumber, String holderName, int securityCode) {
        super(amount, currency, date);
        this.cardNumber = cardNumber;
        this.holderName = holderName;
        this.securityCode = securityCode;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }
}
