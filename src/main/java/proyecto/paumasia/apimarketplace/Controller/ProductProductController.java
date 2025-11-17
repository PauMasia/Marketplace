package proyecto.paumasia.apimarketplace.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    @ResponseBody
    public Page<ProductProduct> getProducts(
            @RequestParam(required = false) String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);

        if (category != null && !category.isEmpty()) {
            return productProductRepository.findByCategory(category, pageable);
        }

        return productProductRepository.findAll(pageable);
    }

    @PostMapping
    public ProductProduct createProduct(@RequestBody ProductProduct product) {
        return productProductRepository.save(product);
    }

}
