package proyecto.paumasia.apimarketplace.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import proyecto.paumasia.apimarketplace.Entity.ResPartner;
import proyecto.paumasia.apimarketplace.Repository.ResPartner_repository;

@Controller
@RestController
@RequestMapping("/web")
public class ResPartner_controller {
    private final ResPartner_repository resPartnerRepository;
    private final PasswordEncoder passwordEncoder;

    public ResPartner_controller(ResPartner_repository resPartnerRepository, PasswordEncoder passwordEncoder) {
        this.resPartnerRepository = resPartnerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public void resPartner(@RequestBody ResPartner resPartner){
        resPartner.setPassword(passwordEncoder.encode(resPartner.getPassword())); //Dios que calidad
        resPartnerRepository.save(resPartner);
    }

}
