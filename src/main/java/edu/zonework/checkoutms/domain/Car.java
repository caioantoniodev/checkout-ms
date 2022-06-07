package edu.zonework.checkoutms.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Car {

    private String id;
    private String model;
    private String make;
    private String warehouse;
    private SaleState state;
}
