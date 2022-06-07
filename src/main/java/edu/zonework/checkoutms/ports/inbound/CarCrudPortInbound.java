package edu.zonework.checkoutms.ports.inbound;

import edu.zonework.checkoutms.domain.Car;

public interface CarCrudPortInbound {
    Car create(Car car);

    void buy(String carId);
}
