package edu.zonework.checkoutms.adpters.inbound.rest;

import edu.zonework.checkoutms.adpters.inbound.dto.CarRequest;
import edu.zonework.checkoutms.domain.Car;
import edu.zonework.checkoutms.ports.inbound.CarCrudPortInbound;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarCrudPortInbound carCrudPortInbound;

    @PostMapping
    ResponseEntity<Car> createCar(@RequestBody CarRequest carRequest) {

        var car = Car.builder()
                .warehouse(carRequest.getWarehouse())
                .make(carRequest.getMake())
                .model(carRequest.getModel())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(carCrudPortInbound.create(car));
    }

    @PostMapping("/{carId}/buy")
    ResponseEntity<Void> buyCar(@PathVariable String carId) {

        carCrudPortInbound.buy(carId);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
