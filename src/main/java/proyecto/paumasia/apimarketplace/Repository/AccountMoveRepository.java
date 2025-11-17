package proyecto.paumasia.apimarketplace.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proyecto.paumasia.apimarketplace.Entity.AccountMove;

import java.util.List;

@Repository
public interface AccountMoveRepository extends JpaRepository<AccountMove, Long> {
    // Revisar como buscar mediante un campoespecifico
    // Page<AccountMove> findAllByPartner_id(@Param("partner_id")Long partner_id, Pageable pageable);

    @Override
    List<AccountMove> findAll();
}
