package entities;

import java.util.Date;

public class BankTransferPayment extends Payment{
    private String bankName;
    private int accountNumber;
    private String beneficiaryName;
    private int IBAN;

    public BankTransferPayment(String bankName, int accountNumber, String beneficiaryName, int IBAN) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.beneficiaryName = beneficiaryName;
        this.IBAN = IBAN;
    }

    public BankTransferPayment(int amount, String currency, Date date, String bankName, int accountNumber, String beneficiaryName, int IBAN) {
        super(amount, currency, date);
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.beneficiaryName = beneficiaryName;
        this.IBAN = IBAN;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public int getIBAN() {
        return IBAN;
    }

    public void setIBAN(int IBAN) {
        this.IBAN = IBAN;
    }
}
