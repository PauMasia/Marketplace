package proyecto.paumasia.apimarketplace.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
//Revisar si se quiere usar, es un cpaste de ResUser
@Entity
@Table(name ="res_users")
public class ResPartner {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int user_id;
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
            return user_id;
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

}
