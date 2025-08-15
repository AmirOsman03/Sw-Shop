package mk.com.swshop.web.controller;

import mk.com.swshop.dto.create.CreateProductDto;
import mk.com.swshop.dto.display.DisplayProductDto;
import mk.com.swshop.model.domain.Product;
import mk.com.swshop.model.enums.Category;
import mk.com.swshop.service.application.ProductApplicationService;
import mk.com.swshop.service.domain.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductApplicationService productApplicationService;
    private final ProductService productService;

    public ProductController(ProductApplicationService productApplicationService, ProductService productService) {
        this.productApplicationService = productApplicationService;
        this.productService = productService;
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

    // ✅ Нов метод за креирање продукт со слики
    @PostMapping(value = "/create-with-images", consumes = {"multipart/form-data"})
    public ResponseEntity<Product> createProductWithImages(
            @RequestPart("product") CreateProductDto createProductDto,
            @RequestPart(value = "images", required = false) List<MultipartFile> images
    ) throws IOException {

        // Креирање на Product објект од DTO
        Product product = new Product(
                createProductDto.name(),
                createProductDto.description(),
                createProductDto.price(),
                createProductDto.sizes(),
                createProductDto.color(),
                createProductDto.category(),
                createProductDto.quantityBySize(),
                null // images ќе се сетираат по upload
        );

        // Upload на слики ако има
        if (images != null && !images.isEmpty()) {
            product = productService.saveWithImages(product, images);
        } else {
            product = productService.save(product);
        }

        return ResponseEntity.ok(product);
    }

}


