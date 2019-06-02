package com.budlee.orderapi.model;

import com.budlee.orderapi.annotation.ValidTelephoneNumber;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPOJO {


    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY, readOnly = true)
    @Id
    public String id;

    @NotNull
    private AddressPOJO address;

    @ValidTelephoneNumber
    @NotEmpty
    private String telephoneNumber;

    @NotEmpty
    String email;

    @Min(0)
    private double totalPrice;

    @Min(1)
    private int quantity;

    @ApiModelProperty(required = true)
    @NotNull
    private PaymentStatus paymentStatus;

    private String notes;

    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY, readOnly = true)
    private LocalDate createdDate;



}
