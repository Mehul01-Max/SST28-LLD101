package com.example.payments;

public class SafeCashAdapter extends SafeCashClient implements PaymentGateway {

    @Override
    public String charge(String customerId, int amountCents) {
        return super.createPayment(amountCents, customerId).confirm();
    }

}
