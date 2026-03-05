package com.example.payments;

public class FastPayAdapter extends FastPayClient implements PaymentGateway {

    @Override
    public String charge(String customerId, int amountCents) {
        return super.payNow(customerId, amountCents);
    }

}
