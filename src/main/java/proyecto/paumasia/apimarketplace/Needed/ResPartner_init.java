package proyecto.paumasia.apimarketplace.Needed;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import proyecto.paumasia.apimarketplace.Entity.ResPartner;
import proyecto.paumasia.apimarketplace.Repository.ResPartner_repository;

@Configuration

public class ResPartner_init {

    @Bean
    CommandLineRunner initAdmin(ResPartner_repository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Verificamos si existe el admin
            if (userRepository.findById(1L).isEmpty()) {
                ResPartner adminUser = new ResPartner();
                adminUser.setUsername("OdooBot 2.0");
                adminUser.setPassword(passwordEncoder.encode("OdooEsMejor123"));
                adminUser.setMail("default@empresa.com");
                userRepository.save(adminUser);
                System.out.println("OdooBot de pacotilla :v");
            }
        };
    }
}
