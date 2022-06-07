package edu.zonework.checkoutms.adpters.outbound.database.document;

import edu.zonework.checkoutms.domain.SaleState;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("cars")
public class CarDocument {

    @Id
    private String id;
    private String model;
    private String make;
    private String warehouse;
    private SaleState state;
}
