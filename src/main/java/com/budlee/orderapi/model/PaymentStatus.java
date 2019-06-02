package com.budlee.orderapi.model;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentStatus {

    @NotBlank
    Boolean paid;

    PaymentMethod paymentMethod;
}
