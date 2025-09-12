package proyecto.paumasia.apimarketplace.Entity;

import jakarta.persistence.*;
import proyecto.paumasia.apimarketplace.Models;

import java.util.Date;

@Entity
@Table(name="product_product")
public class ProductProduct extends Models {
    private String name;
    private Boolean is_published; //Por logica este no deberia de estar en esta clase, deberia ser en ptemplate



    @ManyToOne
    @JoinColumn(name = "responsible_id")
    private ResUser responsible_id;





    public ResUser getResponsible_id() {
        return responsible_id;
    }

    public void setResponsible_id(ResUser responsible_id) {
        this.responsible_id = responsible_id;
    }
}
