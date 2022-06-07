package edu.zonework.checkoutms.adpters.inbound.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarRequest {

    private String model;
    private String make;
    private String warehouse;
}
