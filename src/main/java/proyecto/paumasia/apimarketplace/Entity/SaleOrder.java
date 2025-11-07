package proyecto.paumasia.apimarketplace.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.thymeleaf.expression.Lists;
import proyecto.paumasia.apimarketplace.BaseModel;

import java.util.List;
//Se aplican los impuestos a el envio o es antes
@Entity
@Table(name ="sale_order")
@Getter
@Setter
public class SaleOrder extends BaseModel {
    // Habria que ver como generar nombre como SO/p/fv~250004, deberia con un compute al crearse
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name; // PEJ: SO250020/ FV2600003
    @ManyToOne
    @JoinColumn(name = "partner_id", nullable = false)
    private ResPartner partner_id;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true) // Para que se borren cuando se suelten de este pedido
    private List<SaleOrderLine> line_ids;
    @Column(nullable = false)
    private String location_id;
    @Column(nullable = false)//total sin impuestos
    private Float amount_untaxed;
    @Column(nullable = false)//impuestoa
    private Float amount_tax;
    @Column(nullable = false) //Envio
    private Float amount_delivery;
    @Column(nullable = false)//Total con todo
    private Float amount_total;// hacer que solo pueda tener 2-3 tipos, payed, non-payed, canceled?
    private String state;

    public SaleOrder (){
        super(null);
        this.state = "not_payed";
        this.name = "SO25"+ "ultimopedido";
    }
    // cOmputar todos los valores precio no nullable, either 0
    // public
    public void compute_amount_total(){
        if( state == "not_payed") {
            this.compute_lines();
        }
    }

    public void order_payed(String delivery_location){
    // Aqui se comprobaria que el pago esta realizado realmente
    // no se van a añadir tablas para esto, por el momento
        if( state == "not_payed") {
            List<AccountMoveLine>  created_move_line = List.of();
            this.compute_lines();
            // Crear lineas
            for ( SaleOrderLine line : line_ids){
                line.create_account_line();
            }
            this.state = "payed";
        }
    }

    public void compute_lines(){
        for ( SaleOrderLine line : line_ids){
            line.compute_total_price();
        }
    }
}
