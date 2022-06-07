package edu.zonework.checkoutms.ports.repository;

import edu.zonework.checkoutms.adpters.outbound.database.document.CarDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<CarDocument, String> {
}
