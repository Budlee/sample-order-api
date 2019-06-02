package com.budlee.orderapi.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class SuccessfulOrder {

    private final String id;

    private final List<HATEOSLink> links;


}
