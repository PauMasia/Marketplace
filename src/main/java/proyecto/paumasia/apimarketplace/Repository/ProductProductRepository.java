package proyecto.paumasia.apimarketplace.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.paumasia.apimarketplace.Entity.ProductProduct;

import java.util.List;
@Repository
public interface ProductProductRepository extends JpaRepository<ProductProduct, Long> {
    Page<ProductProduct> findByCategory(String category, Pageable pageable);

    @Override
    List<ProductProduct> findAll();
}
