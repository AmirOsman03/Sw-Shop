package mk.com.swshop.web.controller;

import mk.com.swshop.model.domain.ProductImage;
import mk.com.swshop.service.domain.ProductImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/images")
public class ProductImageController {

    private final ProductImageService productImageService;

    public ProductImageController(ProductImageService productImageService) {
        this.productImageService = productImageService;
    }

    // Додај слика за продукт
    @PostMapping("/{productId}")
    public ResponseEntity<ProductImage> addImage(@PathVariable Long productId,
                                                 @RequestParam String url) {
        ProductImage image = productImageService.addProductImage(productId, url);
        return ResponseEntity.ok(image);
    }

    // Земи сите слики за продукт
    @GetMapping("/{productId}")
    public ResponseEntity<List<ProductImage>> getAllImages(@PathVariable Long productId) {
        List<ProductImage> images = productImageService.getAllProductImages(productId);
        return ResponseEntity.ok(images);
    }

    // Земи главна слика за продукт
    @GetMapping("/{productId}/main")
    public ResponseEntity<ProductImage> getMainImage(@PathVariable Long productId) {
        ProductImage image = productImageService.getMainImage(productId);
        return ResponseEntity.ok(image);
    }

    // Избриши слика по id
    @DeleteMapping("/{imageId}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long imageId) {
        productImageService.deleteProductImage(imageId);
        return ResponseEntity.noContent().build();
    }
}
