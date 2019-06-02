package com.budlee.orderapi.annotation.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
//@DataMongoTest(properties = "spring.data.mongodb.port=0")
@SpringBootTest
class TelephoneNumberValidatorTest {

    //    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @Autowired
//    @MockBean
//    public OrdersRepository repository;

    @Autowired
    Validator validator;

    @Test
    public void contextLoads() {
    }

    @Test
    @DisplayName("A valid phone number passes the validation test")
    public void validNumberPasses() {
        final Set<ConstraintViolation<TelephoneNumberTestSample>> constraintViolations = validator.validate(new TelephoneNumberTestSample("01753123456"));
        assertEquals(0, constraintViolations.size());
    }

    @Test
    @DisplayName("An invalid phone number fails the validation test")
    public void invalidNumberfailes() {
        final Set<ConstraintViolation<TelephoneNumberTestSample>> constraintViolations = validator.validate(new TelephoneNumberTestSample("101123123123123753123456123"));
        assertEquals(1, constraintViolations.size());
    }

}