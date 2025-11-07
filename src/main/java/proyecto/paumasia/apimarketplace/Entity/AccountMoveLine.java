package proyecto.paumasia.apimarketplace.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import proyecto.paumasia.apimarketplace.BaseModel;

@Entity
@Table(name ="account_move_line")
@Getter
@Setter
public class AccountMoveLine extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    public ProductProduct product_id;
    @ManyToOne
    @JoinColumn(name = "move_id", nullable = false)
    public AccountMove move_id;
    public Float quantity;
    public Float line_discount; // %
    public Float total_price;

    public AccountMoveLine(ResPartner create_uid) {
        super(create_uid);
    }

    public AccountMoveLine() {
        super(null);
    }
    // Se deberi de añadir tasas extra por linea, por si el envio tiene un coste extra en aduanas o algo
    // public Integer extra_tax, eso o una linea extra en el pedido dependiendo de el coste extra :v
    // realmente deberia de ser una lista de tasas y luego sacar el %, por si hay varias, no se va a tener el cuenta por ahora

    public void compute_total_price(){
        this.total_price = this.quantity * (this.product_id.getPrice() * (1 - (this.line_discount / 100f)));
    }

    public AccountMoveLine(SaleOrderLine sale_order_line){
        super(null);
        try{
            if(sale_order_line.order_id.getState().equals("not_payed")) {
                this.quantity = sale_order_line.quantity;
                this.line_discount = sale_order_line.line_discount;
                this.product_id = sale_order_line.product_id;
                this.compute_total_price();
//                this.move_id = // crear luego de la factura?, o coger el que coincida con el mismo order id con un repository, no lo tengo claro
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
