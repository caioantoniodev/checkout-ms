package edu.zonework.checkoutms.adpters.outbound.amqp;

import edu.zonework.checkoutms.domain.SaleState;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@ToString
public class BuyCarEvent {

    private String carId;
    private SaleState status;
    private LocalDateTime eventDateTime;

    public BuyCarEvent(String carId) {
        this.carId = carId;
        this.status = SaleState.SOLD;
        this.eventDateTime = LocalDateTime.now(ZoneId.of("UTC"));
    }
}
