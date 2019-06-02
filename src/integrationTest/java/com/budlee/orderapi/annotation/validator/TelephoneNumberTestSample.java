package com.budlee.orderapi.annotation.validator;

import com.budlee.orderapi.annotation.ValidTelephoneNumber;

public class TelephoneNumberTestSample {

    public TelephoneNumberTestSample(String testTelephoneNumber) {
        this.testTelephoneNumber = testTelephoneNumber;
    }

    @ValidTelephoneNumber
    String testTelephoneNumber;
}
