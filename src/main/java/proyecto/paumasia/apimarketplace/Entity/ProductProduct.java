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

    public ResPartner getResponsible_id() {
        return responsible_id;
    }

    public void setResponsible_id(ResPartner responsible_id) {
        this.responsible_id = responsible_id;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getIs_published() {
        return is_published;
    }

    public void setIs_published(Boolean is_published) {
        this.is_published = is_published;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
