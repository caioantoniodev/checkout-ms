package edu.zonework.checkoutms.adpters.outbound.amqp;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface BuyCarBrokerOutput {

    @Output("publishChangeStatusProduct")
    MessageChannel subscribeChangeStatusProduct();
}
