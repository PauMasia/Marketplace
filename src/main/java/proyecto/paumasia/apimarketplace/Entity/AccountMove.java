package proyecto.paumasia.apimarketplace.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import proyecto.paumasia.apimarketplace.BaseModel;

import java.util.List;

@Entity
@Table(name ="account_move")
@Getter
@Setter
public class AccountMove extends BaseModel {

    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "partner_id", nullable = false)
    private ResPartner partner_id;
    @Column(nullable = false)
    private String shipping_location;
    @OneToOne
    @JoinColumn(name = "order_id")
    private SaleOrder order_id; // No hace falta que sea nullable false porque se crearan apartir de las sale order, si no no
    @OneToMany()
    private List<AccountMoveLine> line_ids;
    @Column(nullable = false)//total sin impuestos
    private Float amount_untaxed;
    @Column(nullable = false)//impuestoa
    private Float amount_tax;
    @Column(nullable = false) //Envio
    private Float amount_delivery;
    @Column(nullable = false) //Total con todo
    private Float amount_total;
//    private String state; // Esta no hara falta, no es una mayorista payed, waiting, lo he puesto en pedidos para saber cuando crear factura o no
    public AccountMove(ResPartner create_uid) {
        super(create_uid);
    }

    public AccountMove() {
        super(null);
    }

    // Cuando pregunte por el precio de las facturas el metodo de llamar tiene que llamar a este tambien, antes
    public void compute_amount_total(){
        for (AccountMoveLine line :line_ids){
            line.compute_total_price();
        }
    }
}
