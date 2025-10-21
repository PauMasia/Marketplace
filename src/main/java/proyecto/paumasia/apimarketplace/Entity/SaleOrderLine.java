package proyecto.paumasia.apimarketplace.Entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import proyecto.paumasia.apimarketplace.BaseModel;

//@Entity
//@Table(name ="sale_order_line")
//@Getter
//@Setter
public class SaleOrderLine extends BaseModel {

    public SaleOrderLine(ResPartner create_uid) {
        super(create_uid);
    }
}
