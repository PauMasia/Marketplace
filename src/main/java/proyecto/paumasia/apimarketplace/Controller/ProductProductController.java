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

@RestController
@RequestMapping("/shop")
public class ProductProductController {

    @Autowired
    private ProductProductRepository productProductRepository;

    @GetMapping
    public Page<ProductProduct> getProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        if (category != null && name != null && name.isEmpty() && !category.isEmpty())
            return productProductRepository.findByCategoryAndNameContainingIgnoreCase(category, name, pageable);


        if (name != null && name.isEmpty())
            return productProductRepository.findByNameContainingIgnoreCase(name, pageable);

        if (category != null && !category.isEmpty()) {
            return productProductRepository.findByCategory(category, pageable);
        }

        return productProductRepository.findAll(pageable);
    }

    @PostMapping
    public ProductProduct createProduct(@RequestBody ProductProduct product) {
        return productProductRepository.save(product);
    }
    @GetMapping("/{id}")
    public ProductProduct getProduct(@PathVariable Long id) {
        return productProductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    // para subir multiples mediante postman
    @PostMapping("/multiple_upload")
    @ResponseBody
    public List<ProductProduct> createBulk(@RequestBody List<ProductProduct> products) {
        return productProductRepository.saveAll(products);
    }

}
