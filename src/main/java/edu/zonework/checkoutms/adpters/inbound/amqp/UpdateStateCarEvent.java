package edu.zonework.checkoutms.adpters.inbound.amqp;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.zonework.checkoutms.domain.SaleState;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class UpdateStateCarEvent {

    @JsonProperty("car_id")
    private String carId;
    @JsonProperty("status")
    private SaleState status;
    @JsonProperty("event_date_time")
    private LocalDateTime eventDateTime;
}
