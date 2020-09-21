package entities;

import java.util.Date;

public abstract class Payment {
    private int amount;
    private String currency;
    private Date date;

    public Payment() {
    }

    public Payment(int amount, String currency, Date date) {
        this.amount = amount;
        this.currency = currency;
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
