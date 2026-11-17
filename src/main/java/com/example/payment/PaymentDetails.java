package com.example.payment;

public class PaymentDetails {
    private final String transactionId;
    private final String payerName;
    private final String paymentMethod;

    public PaymentDetails(String transactionId, String payerName, String paymentMethod) {
        this.transactionId = transactionId;
        this.payerName = payerName;
        this.paymentMethod = paymentMethod;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getPayerName() {
        return payerName;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
