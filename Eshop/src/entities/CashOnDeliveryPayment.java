package entities;

import java.util.Date;

public class CashOnDeliveryPayment extends Payment {
    private int extraCharge;

    public CashOnDeliveryPayment(int extraCharge) {
        this.extraCharge = extraCharge;
    }

    public CashOnDeliveryPayment(int amount, String currency, Date date, int extraCharge) {
        super(amount, currency, date);
        this.extraCharge = extraCharge;
    }

    public int getExtraCharge() {
        return extraCharge;
    }

    public void setExtraCharge(int extraCharge) {
        this.extraCharge = extraCharge;
    }
}
