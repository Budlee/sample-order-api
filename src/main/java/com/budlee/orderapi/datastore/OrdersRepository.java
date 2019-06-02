package com.budlee.orderapi.datastore;

import com.budlee.orderapi.model.OrderPOJO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OrdersRepository extends MongoRepository<OrderPOJO, String> {
//    public MouthguardPOJO findBySchoolName(String schoolName);
//    public OrderPOJO findByCreatedDate(LocalDate createdDate);
//    public OrderPOJO findByOrderID(String orderI)
    public Optional<OrderPOJO> findOrderPOJOById(String id);

}
