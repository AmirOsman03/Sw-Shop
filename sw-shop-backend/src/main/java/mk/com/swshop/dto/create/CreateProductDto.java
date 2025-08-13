package mk.com.swshop.dto.create;

import mk.com.swshop.model.domain.Product;
import mk.com.swshop.model.enums.Category;
import mk.com.swshop.model.enums.Color;
import mk.com.swshop.model.enums.Size;

public record CreateProductDto(
        String name,
        String description,
        Integer price,
        Size size,
        Color color,
        Category category,
        Integer quantity
) {
    public Product toProduct() {
        return new Product(
                name,
                description,
                price,
                size,
                color,
                category,
                quantity
        );
    }
}
