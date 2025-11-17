package proyecto.paumasia.apimarketplace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.paumasia.apimarketplace.Entity.SaleOrder;

import java.util.List;

@Repository
public interface SaleOrderRepository extends JpaRepository<SaleOrder, Long> {
    @Override
    List<SaleOrder> findAll();
}
