package edu.zonework.checkoutms.adpters.inbound.amqp;

import edu.zonework.checkoutms.domain.Car;
import edu.zonework.checkoutms.domain.SaleState;
import edu.zonework.checkoutms.ports.outbound.DbOperationsPorOutbound;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(UpdateStatusCarBrokerInput.class)
@RequiredArgsConstructor
public class UpdateStatusCarSubscriber {

    Logger logger = LoggerFactory.getLogger(UpdateStatusCarSubscriber.class);

    private final UpdateStatusCarBrokerInput updateStatusCarBrokerInput;
    private final DbOperationsPorOutbound dbOperationsPorOutbound;

    @StreamListener("subscribeChangeStatusProduct")
    public void  processEvent(UpdateStateCarEvent updateStateCarEvent) {
        var carId = updateStateCarEvent.getCarId();
        logger.info("Updating state car with car_id = {} ",
                carId
        );

        Car car = dbOperationsPorOutbound.getCar(carId);

        car.setState(SaleState.SOLD);

        dbOperationsPorOutbound.update(car);
    }
}
