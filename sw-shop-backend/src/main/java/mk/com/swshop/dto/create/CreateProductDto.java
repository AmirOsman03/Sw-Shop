package mk.com.swshop.dto.create;

import mk.com.swshop.model.domain.Product;
import mk.com.swshop.model.enums.Category;
import mk.com.swshop.model.enums.Color;
import mk.com.swshop.model.enums.Size;

import java.util.List;
import java.util.Map;

public record CreateProductDto(
        String name,
        String description,
        Integer price,
        List<Size> sizes,
        Color color,
        Category category,
        Map<Size, Integer> quantityBySize,
        List<String> images,
        Integer quantity
) {
    public Product toProduct() {
        return new Product(
                name,
                description,
                price,
                sizes,
                color,
                category,
                quantityBySize,
                images
        );
    }
}
