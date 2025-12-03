package proyecto.paumasia.apimarketplace.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.thymeleaf.expression.Lists;
import proyecto.paumasia.apimarketplace.BaseModel;

import java.util.List;
//Se aplican los impuestos a el envio o es antes, croe que antes
@Entity
@Table(name ="sale_order")
@Getter
@Setter
public class SaleOrder extends BaseModel {
    // Habria que ver como generar nombre como SO/p/fv~250004, deberia con un compute al crearse
    @Column(unique = true, nullable = false)
    private String name; // PEJ: SO250020/ FV2600003
    @ManyToOne
    @JoinColumn(name = "partner_id", nullable = false)
    private ResPartner partner_id;
    @OneToMany(mappedBy = "order_id", cascade = CascadeType.ALL, orphanRemoval = true) // Para que se borren cuando se suelten de este pedido
    private List<SaleOrderLine> line_ids;
    @Column(nullable = false)
    private String location_id; // delivery_location
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
        this.name = "SO25"+ "00001"; //lo cambiare mas adelante
    }
    // cOmputar todos los valores precio no nullable, either 0
    // public
    public void compute_amount_total(){
        if( this.state.equals("not_payed")) {
            this.compute_lines();
        }
    }

    public void order_payed(String delivery_location){
    // Aqui se comprobaria que el pago esta realizado realmente
    // no se van a añadir tablas para esto, por el momento
        if( this.state.equals("not_payed")) {
            List<AccountMoveLine>  created_move_lines = List.of();
            this.compute_lines();
            // Crear lineas
            for ( SaleOrderLine line : line_ids){
                created_move_lines.add(line.create_account_line());
            }
            this.createAccountMove(created_move_lines);

            this.state = "payed";
            // aqui ahora tendremos que
        }
    }

    public void compute_lines(){
        for ( SaleOrderLine line : line_ids){
            line.compute_total_price();
        }
    }

    public void createAccountMove(List<AccountMoveLine> moveLines){
        AccountMove move = new AccountMove(
                null,
                this.name,
                this.partner_id,
                this.location_id,
                this,
                moveLines,
                this.amount_untaxed,
                this.amount_tax,
                this.amount_delivery,
                this.amount_total
        );
        //no hara falta retornarlo por ahora
    }
}
