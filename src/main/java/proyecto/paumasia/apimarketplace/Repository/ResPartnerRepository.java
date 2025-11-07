package proyecto.paumasia.apimarketplace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import proyecto.paumasia.apimarketplace.Entity.ResPartner;

import java.util.Optional;

@Component
public interface ResPartnerRepository extends JpaRepository<ResPartner,Long> {
    @Override
    Optional<ResPartner> findById(Long aLong);


    ResPartner findByMail(String mail);
}
