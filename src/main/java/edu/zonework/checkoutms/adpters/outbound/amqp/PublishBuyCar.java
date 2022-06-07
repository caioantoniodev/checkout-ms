package edu.zonework.checkoutms.adpters.outbound.amqp;

import edu.zonework.checkoutms.ports.outbound.SendBuyCarPorOutbound;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(BuyCarBrokerOutput.class)
@RequiredArgsConstructor
public class PublishBuyCar implements SendBuyCarPorOutbound {

    private Logger logger = LoggerFactory.getLogger(PublishBuyCar.class);

    private final BuyCarBrokerOutput buyCarBrokerOutput;

    @Override
    public void sendBuy(String carId) {

        var payload = new BuyCarEvent(carId);

        logger.info("Send Event: {}", payload);

        buyCarBrokerOutput.subscribeChangeStatusProduct().send(
                MessageBuilder.withPayload(payload).build()
        );
    }
}
