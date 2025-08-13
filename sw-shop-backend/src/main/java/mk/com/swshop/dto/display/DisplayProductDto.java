package mk.com.swshop.dto.display;

import mk.com.swshop.model.enums.Color;
import mk.com.swshop.model.enums.Size;

public record DisplayProductDto(
        String name,
        String description,
        Integer price,
        Size size,
        Color color,
        String category,
        Integer quantity
) {
}
