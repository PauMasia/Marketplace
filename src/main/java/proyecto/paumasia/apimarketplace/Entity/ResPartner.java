package proyecto.paumasia.apimarketplace.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import proyecto.paumasia.apimarketplace.BaseModel;

@Entity
@Table(name ="res_partner")
public class ResPartner extends BaseModel {
    @Column(nullable = false)
    private String username;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Column(nullable = false)
    private String mail;
    //Cifrar
    @Column(nullable = false)
    private String password;
    private String country;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ResPartner(){
        super(null);
        this.country=null;
    }


}
