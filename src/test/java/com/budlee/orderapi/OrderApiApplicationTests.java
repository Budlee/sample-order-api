package com.budlee.orderapi;

//import org.junit.Test;

import com.budlee.orderapi.datastore.OrdersRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@RunWith(SpringRunner.class)
//@DataMongoTest


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OrderApiApplicationTests {

    @MockBean
//    @Autowired
    public OrdersRepository repository;
//
//    @Autowired
//    MongoTemplate mongoTemplate;

    @Test
    public void contextLoads() {
        System.out.println("THIS EWAS CALLLLLLEDDDDDD");
    }

    @Test
    public void mytest(){
        System.out.println(repository);
    }
}

