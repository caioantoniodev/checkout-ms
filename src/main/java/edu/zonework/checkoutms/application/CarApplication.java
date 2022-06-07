package edu.zonework.checkoutms.application;

import edu.zonework.checkoutms.domain.Car;
import edu.zonework.checkoutms.ports.inbound.CarCrudPortInbound;
import edu.zonework.checkoutms.ports.outbound.DbOperationsPorOutbound;
import edu.zonework.checkoutms.ports.outbound.SendBuyCarPorOutbound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class CarApplication implements CarCrudPortInbound {

    private final DbOperationsPorOutbound dbOperationsPorOutbound;
    private final SendBuyCarPorOutbound sendBuyCarPorOutbound;

    @Override
    public Car create(Car car) {
        return dbOperationsPorOutbound.create(car);
    }

    @Override
    public void buy(String carId) {
        sendBuyCarPorOutbound.sendBuy(carId);
    }
}
