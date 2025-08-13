package mk.com.swshop.service.domain.impl;

import jakarta.transaction.Transactional;
import mk.com.swshop.model.domain.Product;
import mk.com.swshop.model.domain.ProductImage;
import mk.com.swshop.repository.ProductImageRepository;
import mk.com.swshop.repository.ProductRepository;
import mk.com.swshop.service.domain.ProductImageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductImageServiceImpl implements ProductImageService {

    private final ProductImageRepository productImageRepository;
    private final ProductRepository productRepository;

    public ProductImageServiceImpl(ProductImageRepository productImageRepository,
                                   ProductRepository productRepository) {
        this.productImageRepository = productImageRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ProductImage addProductImage(Long productId, String imageUrl) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        ProductImage image = new ProductImage(imageUrl, product);
        return productImageRepository.save(image);
    }

    @Override
    public List<ProductImage> getAllProductImages(Long productId) {
        return productImageRepository.findAllByProductId(productId);
    }

    @Override
    public void deleteProductImage(Long imageId) {
        productImageRepository.deleteById(imageId);
    }

}
