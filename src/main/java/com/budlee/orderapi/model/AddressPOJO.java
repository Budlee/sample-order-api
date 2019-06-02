package com.budlee.orderapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressPOJO {

    @NotEmpty
    NamePOJO name;

    @NotEmpty
    String firstLine;

    String secondLine = "";

    @NotEmpty
    String city;

    String county = "";

    @NotEmpty
    String country;

    @NotEmpty
    String postCode;

}
