package proyecto.paumasia.apimarketplace.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import proyecto.paumasia.apimarketplace.Models;
import proyecto.paumasia.apimarketplace.Repository.ResUser_repository;
import proyecto.paumasia.apimarketplace.Tools;

import java.time.LocalDateTime;

@Entity
@Table(name ="res_users")
public class ResPartner extends Models {
    @Column(nullable = false)
    private String username;
    //Cifrar
    @Column(nullable = false)
    private String password;
    private String country;

    // Mandatory ones
    public ResPartner(String password, String username, ResUser_repository resUserRepository){
        this.username = username;
        this.password = password;
        super(Tools.setDateNow(),resUserRepository.findById(1L).orElse(null));
    }
    // Cambiarpor patron builder
    public ResPartner(String password, String username, String country) {
        this.password = password;
        this.username = username;
        this.country = country;
        super(Tools.setDateNow(),1);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

}
