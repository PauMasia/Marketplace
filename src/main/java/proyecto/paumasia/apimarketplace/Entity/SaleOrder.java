package proyecto.paumasia.apimarketplace.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import proyecto.paumasia.apimarketplace.BaseModel;

import java.util.List;
//Se aplican los impuestos a el envio o es antes
@Entity
@Table(name ="sale_order")
@Getter
@Setter
public class SaleOrder extends BaseModel {
    @Column(nullable = false)
    private String name;
    @JoinColumn(referencedColumnName = "id",nullable = false)
    @OneToOne
    private ResPartner partner_id;
    @Column(nullable = false)
    private String location_id;
    @Column(nullable = false)//total sin impuestos
    private Float amount_untaxed;
    @Column(nullable = false)//impuestoa
    private Float amount_tax;
    @Column(nullable = false) //Envio
    private Float amount_delivery;
    @Column(nullable = false)//Total con todo
    private Float amount_total;
//    @OneToMany
//    private List<SaleOrderLine> line_ids;

    public SaleOrder (){
        super(null);
    }
    // cOmputar todos los valores precio no nullable, either 0
    // public
}
