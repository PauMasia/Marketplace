package proyecto.paumasia.apimarketplace.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import proyecto.paumasia.apimarketplace.Entity.ResPartner;
import proyecto.paumasia.apimarketplace.Repository.ResPartnerRepository;

@RestController
@RequestMapping("/userList")
@CrossOrigin
public class ResPartnerController_internos {

    @Autowired
    private ResPartnerRepository resPartnerRepository;

    @GetMapping
    public Page<ResPartner> listUsers(
            @RequestParam(required = false) String username,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        if (username != null && !username.isEmpty()) {
            return resPartnerRepository.findByUsername((username.toLowerCase()), pageable);
        }
        return resPartnerRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResPartner> getUser(@PathVariable Long id) {
        return resPartnerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        if (!resPartnerRepository.existsById(id))
            return ResponseEntity.notFound().build();

        resPartnerRepository.deleteById(id);
        return ResponseEntity.ok("Usuario eliminado");
    }


}
