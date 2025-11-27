package proyecto.paumasia.apimarketplace.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import proyecto.paumasia.apimarketplace.BaseModel;

@Entity
@Table(name="product_product")
@Getter
@Setter
public class ProductProduct extends BaseModel {
    @Column(nullable = false)
    private String name;
    private Boolean is_published; //Por logica este no deberia de estar en esta clase, deberia ser en ptemplate
    @Column(nullable = false)
    private Float price;
    private Integer discount;
    @Column(nullable = false)
    private String category;

    @ManyToOne
    @JoinColumn(name = "responsible_id")
    private ResPartner responsible_id;

    public ProductProduct() {
        super(null);
        this.is_published=false;
        this.price=0f;
        this.discount=0;
    }

}
