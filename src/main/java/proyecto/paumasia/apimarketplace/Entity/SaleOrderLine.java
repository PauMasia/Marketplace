package proyecto.paumasia.apimarketplace.Entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import proyecto.paumasia.apimarketplace.BaseModel;

@Entity
@Table(name ="sale_order_line")
@Getter
@Setter
public class SaleOrderLine extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    public ProductProduct product_id;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    public SaleOrder order_id;
    public Float quantity;
    public Float line_discount; // %
    public Float total_price;

    public SaleOrderLine(ResPartner create_uid) {
        super(create_uid);
    }

    public SaleOrderLine() {
        super(null);
    }

    public void compute_total_price(){
        this.total_price = this.quantity * (this.product_id.getPrice() * (1 - (this.line_discount / 100f)));
    }

    public AccountMoveLine create_account_line(){
        return new AccountMoveLine(this);

    }
}
