package edu.zonework.checkoutms.adpters.outbound.database;

import edu.zonework.checkoutms.adpters.outbound.database.document.CarDocument;
import edu.zonework.checkoutms.domain.Car;
import edu.zonework.checkoutms.domain.SaleState;
import edu.zonework.checkoutms.ports.outbound.DbOperationsPorOutbound;
import edu.zonework.checkoutms.ports.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

        return getCar(document);
    }

    @Override
    public Car getCar(String carId) {

        Optional<CarDocument> carDocument = carRepository.findById(carId);

        if (Boolean.TRUE.equals(carDocument.isEmpty()))
            throw new RuntimeException("Car not found");

        return getCar(carDocument.get());
    }

    @Override
    public void update(Car car) {
        var document = CarDocument.builder()
                .id(car.getId())
                .model(car.getModel())
                .make(car.getMake())
                .warehouse(car.getWarehouse())
                .state(car.getState())
                .build();

        carRepository.save(document);
    }

    private Car getCar(CarDocument document) {
        return Car.builder()
                .id(document.getId())
                .make(document.getMake())
                .warehouse(document.getWarehouse())
                .model(document.getModel())
                .state(document.getState())
                .build();
    }
}
