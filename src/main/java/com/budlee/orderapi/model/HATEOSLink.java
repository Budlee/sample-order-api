package com.budlee.orderapi.model;

import lombok.Data;

@Data
public class HATEOSLink {
    private final String href = "http://localhost/order/12345";
    private final String rel = "self";
    private final String method = "GET";
}