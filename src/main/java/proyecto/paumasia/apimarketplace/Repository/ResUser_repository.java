package proyecto.paumasia.apimarketplace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.paumasia.apimarketplace.Entity.ResUser;

import java.util.List;
import java.util.Optional;

public interface ResUser_repository extends JpaRepository<ResUser,Long> {
    @Override
    Optional<ResUser> findById(Long aLong);
}
