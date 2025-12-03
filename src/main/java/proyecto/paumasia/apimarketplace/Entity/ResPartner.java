package proyecto.paumasia.apimarketplace.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import proyecto.paumasia.apimarketplace.BaseModel;

import java.util.ArrayList;
import java.util.List;


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
    @Column(nullable = false)
    private Boolean shared; // Default true a menos que lo ponga algun interno

//    @OneToMany(mappedBy = "partner", fetch = FetchType.LAZY)
//    private List<Token> tokens = new ArrayList<>();

    public ResPartner(){
        super(null);
    }


}
