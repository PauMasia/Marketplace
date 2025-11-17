package proyecto.paumasia.apimarketplace.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyecto.paumasia.apimarketplace.Entity.ProductProduct;
import proyecto.paumasia.apimarketplace.Repository.ProductProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Controller
@RequestMapping("/shop")
public class ProductProductController {
    @Autowired
    private ProductProductRepository productProductRepository;
    public Page<ProductProduct> getProducts(String category, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        if (category != null && !category.isEmpty()) {
            return productProductRepository.findByCategory(category, pageable);
        } else {
            return productProductRepository.findAll(pageable);
        }
    }
}
