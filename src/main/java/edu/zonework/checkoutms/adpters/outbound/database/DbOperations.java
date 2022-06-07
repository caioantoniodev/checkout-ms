package edu.zonework.checkoutms.adpters.outbound.database;

import edu.zonework.checkoutms.adpters.outbound.database.document.CarDocument;
import edu.zonework.checkoutms.domain.Car;
import edu.zonework.checkoutms.domain.SaleState;
import edu.zonework.checkoutms.ports.outbound.DbOperationsPorOutbound;
import edu.zonework.checkoutms.ports.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class DbOperations implements DbOperationsPorOutbound {

    private final CarRepository carRepository;

    @Override
    public Car create(Car car) {

        var document = CarDocument.builder()
                .model(car.getModel())
                .make(car.getMake())
                .warehouse(car.getWarehouse())
                .state(SaleState.AVAILABLE)
                .build();

        carRepository.save(document);

        return Car.builder()
                    .id(document.getId())
                    .make(document.getMake())
                    .warehouse(document.getWarehouse())
                    .model(document.getModel())
                    .state(document.getState())
                    .build();
    }
}
