package com.example.payment;

public class PaymentService {

    public boolean validatePaymentDetails(PaymentDetails details) {
        return details != null
                && isNotBlank(details.getTransactionId())
                && isNotBlank(details.getPayerName())
                && isNotBlank(details.getPaymentMethod());
    }

    public String processPayment(double amount, PaymentDetails details) {
        if (amount <= 0) {
            return "Invalid amount";
        }

        if (!validatePaymentDetails(details)) {
            return "Missing payment details";
        }

        return "Payment successful";
    }

    private boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
