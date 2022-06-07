package edu.zonework.checkoutms.adpters.outbound.amqp;

import edu.zonework.checkoutms.ports.outbound.SendBuyCarPorOutbound;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(BuyCarBrokerOutput.class)
@RequiredArgsConstructor
public class PublishBuyCar implements SendBuyCarPorOutbound {

    private final BuyCarBrokerOutput buyCarBrokerOutput;

    @Override
    public void sendBuy(String carId) {
        buyCarBrokerOutput.subscribeChangeStatusProduct().send(
                MessageBuilder.withPayload(new BuyCarEvent(carId)).build()
        );
    }
}
