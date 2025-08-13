package mk.com.swshop.web.controller;

import mk.com.swshop.dto.create.CreateProductDto;
import mk.com.swshop.dto.display.DisplayProductDto;
import mk.com.swshop.model.domain.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductApplicationService productApplicationService;

    public ProductController(ProductApplicationService productApplicationService) {
        this.productApplicationService = productApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<DisplayProductDto>> getAllProducts() {
        return ResponseEntity.ok(productApplicationService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<DisplayProductDto> createProduct(
            @RequestBody CreateProductDto createProductDto
    ) {
        return ResponseEntity.ok(productApplicationService.create(createProductDto));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayProductDto> editProduct(
            @PathVariable Long id,
            @RequestBody CreateProductDto createProductDto
    ) {
        return ResponseEntity.ok(productApplicationService.edit(id, createProductDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DisplayProductDto> deleteProduct(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(productApplicationService.delete(id));
    }

}
