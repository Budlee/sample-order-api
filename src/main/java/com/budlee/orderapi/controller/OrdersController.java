package com.budlee.orderapi.controller;


import com.budlee.orderapi.datastore.OrdersRepository;
import com.budlee.orderapi.model.CreatedEntityPOJO;
import com.budlee.orderapi.model.CreatedEntityResponse;
import com.budlee.orderapi.model.OrderPOJO;
import com.budlee.orderapi.model.OrdersPOJO;
import com.budlee.orderapi.model.error.microsoft.ClientError;
import com.budlee.orderapi.model.error.microsoft.ClientErrorResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Optional;

@RestController("/api/orders")
public class OrdersController {

    @Autowired
    OrdersRepository ordersRepository;

    @GetMapping("/orders")
    @ApiOperation(value = "Get all orders")
    public OrdersPOJO getOrders() {
        return new OrdersPOJO(ordersRepository.findAll());
    }


    @GetMapping("/orders/{id}")
    @ApiOperation(value = "Get all orders")
    public ResponseEntity<OrderPOJO> getOrder(@PathVariable(value = "id") String id) {
        final Optional<OrderPOJO> optionalOrder = ordersRepository.findOrderPOJOById(id);
        return optionalOrder.isPresent() ? ResponseEntity.of(optionalOrder) : ResponseEntity.notFound().build();
    }


    @PostMapping("/orders")
    @ApiOperation(value = "Create an order")
    @ApiResponses({
            @ApiResponse(
                    code = 201,
                    message = "Created a new order",
                    responseHeaders = {
                            @ResponseHeader(name = "Location",
                                    description = "The Location of the created object",
                                    response = String.class
                            )
                    },
                    response = CreatedEntityResponse.class

            ), @ApiResponse(
            code = 400,
            response = ClientErrorResponse.class,
            message = "A client Error"
    )
    })
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createOrder(@Validated @RequestBody OrderPOJO order, @ApiIgnore Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity
                    .badRequest()
                    .body(new ClientErrorResponse(
                                    new ClientError("400",
                                            errors.getFieldError().getDefaultMessage(),
                                            null,
                                            null,
                                            null)
                            )
                    );
        }
        val savedOrder = ordersRepository.save(order);
        val uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedOrder.getId()).toUri();
        ResponseEntity postResponse = ResponseEntity.created(uri)
                .body(new CreatedEntityResponse(new CreatedEntityPOJO(savedOrder.getId())));
        return postResponse;
    }
}
