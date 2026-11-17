package com.example.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentServiceTest {

    private PaymentService paymentService;
    private PaymentDetails validDetails;

    @BeforeEach
    void setUp() {
        paymentService = new PaymentService();
        validDetails = new PaymentDetails("TXN101", "Sriya", "UPI");
    }

    @Test
    void shouldProcessValidPayment() {
        String result = paymentService.processPayment(500.00, validDetails);

        assertThat(result).isEqualTo("Payment successful");
    }

    @Test
    void shouldRejectInvalidAmount() {
        String result = paymentService.processPayment(-100.00, validDetails);

        assertThat(result).isEqualTo("Invalid amount");
    }

    @Test
    void shouldRejectMissingPaymentDetails() {
        PaymentDetails missingDetails =
                new PaymentDetails("TXN102", "", "UPI");

        String result = paymentService.processPayment(500.00, missingDetails);

        assertThat(result).isEqualTo("Missing payment details");
    }

    @Test
    void shouldRejectNullPaymentDetails() {
        String result = paymentService.processPayment(500.00, null);

        assertThat(result).isEqualTo("Missing payment details");
    }

    @Test
    void shouldValidateCompletePaymentDetails() {
        assertThat(paymentService.validatePaymentDetails(validDetails)).isTrue();
    }
}
