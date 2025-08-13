package mk.com.swshop.dto.display;

import mk.com.swshop.model.domain.Product;
import mk.com.swshop.model.enums.Color;
import mk.com.swshop.model.enums.Size;

import java.util.List;
import java.util.Map;

public record DisplayProductDto(
        String name,
        String description,
        Integer price,
        List<Size> sizes,
        Color color,
        String category,
        Map<Size, Integer> quantityBySize
) {
    public static DisplayProductDto from(Product product) {
        return new DisplayProductDto(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getSizes(),
                product.getColor(),
                product.getCategory().name(),
                product.getQuantityBySize()
        );
    }

    public static List<DisplayProductDto> from(List<Product> products) {
        return products.stream().map(DisplayProductDto::from).toList();
    }
}
