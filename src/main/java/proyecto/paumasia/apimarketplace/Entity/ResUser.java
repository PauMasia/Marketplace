//Descartado, por ahora
//package proyecto.paumasia.apimarketplace.Entity;
//
//import jakarta.persistence.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import proyecto.paumasia.apimarketplace.Models;
//import proyecto.paumasia.apimarketplace.Repository.ResUser_repository;
//import proyecto.paumasia.apimarketplace.Tools;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name ="res_users")
//public class ResUser extends Models {
//    @Column(nullable = false)
//    private String username;
//    //Cifrar
//    @Column(nullable = false)
//    private String password;
//    private String country;
//
//    public ResUser(){
//        super(null);
//    }
//
//    // Cambiarpor patron builder
////    public ResUser(String username, String password, String country) {
////        this.username = username;
////        this.password = password;
////        this.country = country;
////        super(null);
////    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//}
