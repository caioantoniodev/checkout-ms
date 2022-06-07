package edu.zonework.checkoutms.ports.outbound;

import edu.zonework.checkoutms.domain.Car;

public interface DbOperationsPorOutbound {
    Car create(Car car);
    Car getCar(String carId);
    void update(Car car);
}
