package mk.com.swshop.service.domain;

import mk.com.swshop.model.domain.ProductImage;

import java.util.List;

public interface ProductImageService {


    ProductImage addProductImage(Long productId, String imageUrl);

    List<ProductImage> getAllProductImages(Long productId);

    void deleteProductImage(Long imageId);

}
