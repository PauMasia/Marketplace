package proyecto.paumasia.apimarketplace.Controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyecto.paumasia.apimarketplace.Entity.ProductProduct;
import proyecto.paumasia.apimarketplace.Repository.ProductProductRepository;

@Controller
@RestController
@RequestMapping("/shop")
public class ProductProductController {
    private final ProductProductRepository productProductRepository = ;
    public Page<ProductProduct> getProducts(String category, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        if (category != null && !category.isEmpty()) {
            return productProductRepository.findByCategory(category, pageable);
        } else {
            return productProductRepository.findAll(pageable);
        }
    }
}
