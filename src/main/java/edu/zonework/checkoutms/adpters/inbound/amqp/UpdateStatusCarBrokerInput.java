package edu.zonework.checkoutms.adpters.inbound.amqp;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface UpdateStatusCarBrokerInput {
    @Input("subscribeChangeStatusProduct")
    SubscribableChannel subscribeChangeStatusProduct();
}
