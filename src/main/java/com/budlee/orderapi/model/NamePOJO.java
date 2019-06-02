package com.budlee.orderapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NamePOJO {

    @NotEmpty
    String firstName;
    String middleName = "";
    @NotEmpty
    String lastName;
}
