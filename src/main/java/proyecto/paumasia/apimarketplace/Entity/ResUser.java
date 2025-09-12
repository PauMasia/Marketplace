package proyecto.paumasia.apimarketplace.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name ="res_users")
public class ResUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String username;
    //Cifrar
    private String password;
    private String country;
    private LocalDateTime creation_date;

    public ResUser(){}

    public ResUser(LocalDateTime creation_date, String password, String username) {
        this.creation_date = creation_date;
        this.password = password;
        this.username = username;
    }

    public int getUser_id() {
        return id;
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

    public LocalDateTime getCreation_date() {
        return creation_date;
    }
}
