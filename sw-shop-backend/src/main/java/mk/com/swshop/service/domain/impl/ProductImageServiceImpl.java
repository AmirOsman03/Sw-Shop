package mk.com.swshop.service.domain.impl;

import mk.com.swshop.model.domain.Product;
import mk.com.swshop.model.domain.ProductImage;
import mk.com.swshop.repository.ProductImageRepository;
import mk.com.swshop.repository.ProductRepository;
import mk.com.swshop.service.domain.ProductImageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImageServiceImpl implements ProductImageService {

    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;

    public ProductImageServiceImpl(ProductRepository productRepository, ProductImageRepository productImageRepository) {
        this.productRepository = productRepository;
        this.productImageRepository = productImageRepository;
    }

    @Override
    public ProductImage addProductImage(Long productId, String imageUrl) {
        Optional<Product> productOpt = productRepository.findById(productId);
        if (productOpt.isEmpty()) {
            throw new RuntimeException("Product not found");
        }

        ProductImage image = new ProductImage();
        image.setUrl(imageUrl);
        image.setProduct(productOpt.get());

        return productImageRepository.save(image);
    }

    @Override
    public List<ProductImage> getAllProductImages(Long productId) {
        return productImageRepository.findByProductId(productId);
    }

    @Override
    public void deleteProductImage(Long imageId) {
        productImageRepository.deleteById(imageId);
    }

    @Override
    public ProductImage getMainImage(Long productId) {
        List<ProductImage> images = productImageRepository.findByProductId(productId);
        if (images.isEmpty()) return null;
        return images.get(0); // прва слика како главна
    }

}
