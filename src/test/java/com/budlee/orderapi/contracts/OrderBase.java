package com.budlee.orderapi.contracts;

import com.budlee.orderapi.controller.OrdersController;
import com.budlee.orderapi.datastore.OrdersRepository;
import com.budlee.orderapi.model.*;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.testcontainers.containers.GenericContainer;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public abstract class OrderBase {

    static {
        GenericContainer container = new GenericContainer("mongo:latest")
                .withExposedPorts(27017);
        container.start();
        System.setProperty("spring.data.mongodb.host", container.getContainerIpAddress());
        System.setProperty("spring.data.mongodb.port", container.getFirstMappedPort().toString());
    }


    @Autowired
    OrdersController ordersController;

    @Autowired
    OrdersRepository repository;

    @BeforeEach
    public void setup() {
        repository.save(new OrderPOJO(
                "12345",
                new AddressPOJO(
                        new NamePOJO(
                                "Boss",
                                "I would say",
                                "DJ"
                        ),
                        "20B",
                        "Frummpy village",
                        "London Town",
                        "Greater London",
                        "United Kingdom",
                        "SW21 2JK"
                ),
                "07912302938",
                "brah.stickum@reel.com",
                0.99,
                1,
                new PaymentStatus(
                        true,
                        PaymentMethod.ONLINE
                ),
                "I think I'll have myself a beer",
                LocalDate.now()
        ));
        StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(ordersController);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }


}
