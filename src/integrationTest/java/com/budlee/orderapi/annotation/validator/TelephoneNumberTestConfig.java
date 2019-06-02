package com.budlee.orderapi.annotation.validator;

import com.budlee.orderapi.datastore.OrdersRepository;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TelephoneNumberTestConfig {
    @MockBean
    public OrdersRepository repository;
}
