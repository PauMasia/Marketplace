package proyecto.paumasia.apimarketplace.Controller;

import jakarta.validation.ConstraintDeclarationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import proyecto.paumasia.apimarketplace.Entity.ResPartner;
import proyecto.paumasia.apimarketplace.Models.ResPartnerModel;
import proyecto.paumasia.apimarketplace.Models.ResponseResPartnerModel;
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

    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<ResponseResPartnerModel> resPartner(@RequestBody ResPartnerModel resPartnerModel){
        ResPartner resPartner = new ResPartner();
        try {
            resPartner.setMail(resPartnerModel.getMail());
            resPartner.setUsername(resPartnerModel.getUsername());
            resPartner.setPassword(passwordEncoder.encode(resPartnerModel.getPassword())); //Dios que calidad
            resPartnerRepository.save(resPartner);
        }catch (ConstraintDeclarationException a){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseResPartnerModel("Jaimito no va ♥",resPartner));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseResPartnerModel(e.getMessage(),resPartner));
        }
        return ResponseEntity.ok(new ResponseResPartnerModel("Usuario registrado con exito",resPartner));
    }

//    public boolean userCorrect(ResPartnerModel user){
//        if (user.getMail())
//    }
}
