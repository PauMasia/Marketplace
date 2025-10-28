package proyecto.paumasia.apimarketplace.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import proyecto.paumasia.apimarketplace.BaseModel;

import java.util.List;

public class AccountMove extends BaseModel {

    @Column(nullable = false)
    private String name;
    @JoinColumn(referencedColumnName = "id",nullable = false)
    @OneToOne
    private ResPartner partner_id;
    @Column(nullable = false)
    private String shipping_location;
    private SaleOrder order_id; // No hace falta que sea nullable false porque se crearan apartir de las sale order, si no no
    private List<AccountMoveLine> line_ids;
    @Column(nullable = false)//total sin impuestos
    private Float amount_untaxed;
    @Column(nullable = false)//impuestoa
    private Float amount_tax;
    @Column(nullable = false) //Envio
    private Float amount_delivery;
    @Column(nullable = false)//Total con todo
    private Float amount_total;
//


//    private String state; // Esta no hara falta, no es una mayorista payed, waiting
//    public AccountMove(ResPartner create_uid) {
//        super(create_uid);
//    }
}
