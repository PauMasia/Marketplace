package proyecto.paumasia.apimarketplace.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import proyecto.paumasia.apimarketplace.Entity.ResPartner;

import java.util.Optional;

@Repository
public interface ResPartnerRepository extends JpaRepository<ResPartner,Long> {
    @Override
    Optional<ResPartner> findById(Long aLong);

    ResPartner findByMail(String mail);

    @Override // revisar funcionamiento
    Page<ResPartner> findAll(Pageable pageable);

    Page<ResPartner> findByUsername(String username,
                                    Pageable pageable);

//    Page<ResPartner> findAll(String username, Pageable pageable);

//    Page<ResPartner> findByNameContainingIgnoreCase(String username, Pageable pageable);
}
