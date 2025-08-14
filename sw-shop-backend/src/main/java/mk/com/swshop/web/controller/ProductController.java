package mk.com.swshop.web.controller;

import mk.com.swshop.dto.create.CreateProductDto;
import mk.com.swshop.dto.display.DisplayProductDto;
import mk.com.swshop.model.enums.Category;
import mk.com.swshop.service.application.ProductApplicationService;
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

    @GetMapping("/{id}")
    public ResponseEntity<DisplayProductDto> getProductDetails(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(productApplicationService.findById(id));
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
        return productApplicationService.edit(id, createProductDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DisplayProductDto> deleteProduct(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(productApplicationService.delete(id));
    }

    @GetMapping("/bras")
    public ResponseEntity<List<DisplayProductDto>> getBras() {
        return ResponseEntity.ok(productApplicationService.findByCategoryId(Category.BRAS));
    }

    @GetMapping("/panties")
    public ResponseEntity<List<DisplayProductDto>> getPanties() {
        return ResponseEntity.ok(productApplicationService.findByCategoryId(Category.PANTIES));
    }

    @GetMapping("/lingerie")
    public ResponseEntity<List<DisplayProductDto>> getLingerie() {
        return ResponseEntity.ok(productApplicationService.findByCategoryId(Category.LINGERIE));
    }

    @GetMapping("/knitwear")
    public ResponseEntity<List<DisplayProductDto>> getKnitwear() {
        return ResponseEntity.ok(productApplicationService.findByCategoryId(Category.KNITWEAR));
    }

    @GetMapping("/pajamas")
    public ResponseEntity<List<DisplayProductDto>> getPajamas() {
        return ResponseEntity.ok(productApplicationService.findByCategoryId(Category.PAJAMAS));

    }
}


