package proyecto.paumasia.apimarketplace.Needed;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import proyecto.paumasia.apimarketplace.Entity.ResUser;
import proyecto.paumasia.apimarketplace.Repository.ResUser_repository;

@Configuration

public class ResUser_init {

    @Bean
    CommandLineRunner initAdmin(ResUser_repository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Verificamos si existe el admin
            if (userRepository.findById(1L).isEmpty()) {
                ResUser admin = new ResUser("");
                userRepository.save(admin);
                System.out.println("OdooBot de pacotilla :v");
            }
        };
    }
}
