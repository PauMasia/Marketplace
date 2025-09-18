package proyecto.paumasia.apimarketplace.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import proyecto.paumasia.apimarketplace.BaseModel;

@Entity
@Table(name ="res_partner")
@Getter
@Setter
public class ResPartner extends BaseModel {
    @Column(nullable = false)
    @NotBlank
    private String username;
    @Column(nullable = false,unique=true)
    @Email(message = "Email format is not correct")
    private String mail;
    //Cifrar
    @Column(nullable = false)
    @NotBlank
    private String password;
    private String country;
    private String address;

    public ResPartner(){
        super(null);
        this.country=null;
    }


}
