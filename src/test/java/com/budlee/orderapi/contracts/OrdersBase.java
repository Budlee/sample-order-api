package com.budlee.orderapi.contracts;

import com.budlee.orderapi.controller.OrdersController;
import com.budlee.orderapi.datastore.OrdersRepository;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.testcontainers.containers.GenericContainer;

//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@Testcontainers
@ActiveProfiles(profiles = {"test"})
//@ExtendWith(SpringExtension.class)
//@DataMongoTest(properties = "spring.data.mongodb.port=0")
//@EnableAutoConfiguration
//@EnableConfigurationProperties(value = )
//@ContextConfiguration(
//        classes = {OrdersController.class}
////        classes = {OrdersController.class, OrdersRepository.class}
//)
//@SpringBootTest(classes = OrdersController.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public abstract class OrdersBase {

    @LocalServerPort
    protected int localServerPort;

    static {
        GenericContainer container = new GenericContainer("mongo:latest")
                .withExposedPorts(27017);
        container.start();
        System.setProperty("spring.data.mongodb.host", container.getContainerIpAddress());
        System.setProperty("spring.data.mongodb.port", container.getFirstMappedPort().toString());
    }

//    @Container


    @Autowired
    OrdersController ordersController;

    //    @MockBean
    @Autowired
    OrdersRepository repository;

    @Before
    public void setup() {
//        final MouthguardPOJO mouthguardPOJO = new MouthguardPOJO("12345", "Zeus", MouthguardBuildStatus.IMPRESSION_SENT, true, LocalDate.now() );
//        final MouthguardPOJO mouthguardPOJO2 = new MouthguardPOJO("54321", "Zeus", MouthguardBuildStatus.IMPRESSION_SENT, true, LocalDate.now() );
//        when(repository.findById("12345")).thenReturn(Optional.of(mouthguardPOJO));
//        when(repository.findById("54321")).thenReturn(Optional.of(mouthguardPOJO2));
//        RestAssuredMockMvc.standaloneSetup(new StoutController(), new BuyController());
//        RestAssuredMockMvc.standaloneSetup(new OrdersController());
        StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(ordersController);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }


}
