package mk.com.swshop.dto.display;

import mk.com.swshop.model.domain.Product;
import mk.com.swshop.model.enums.Color;
import mk.com.swshop.model.enums.Size;

import java.util.List;

public record DisplayProductDto(
        String name,
        String description,
        Integer price,
        Size size,
        Color color,
        String category,
        Integer quantity
) {
    public static DisplayProductDto from(Product product) {
        return new DisplayProductDto(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getSize(),
                product.getColor(),
                product.getCategory().name(),
                product.getQuantity()
        );
    }

    public static List<DisplayProductDto> from(List<Product> products) {
        return products.stream().map(DisplayProductDto::from).toList();
    }
}
