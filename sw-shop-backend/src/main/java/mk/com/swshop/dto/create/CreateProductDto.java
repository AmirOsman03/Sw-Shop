package mk.com.swshop.dto.create;

import mk.com.swshop.model.enums.Color;
import mk.com.swshop.model.enums.Size;

public record CreateProductDto(
        String name,
        String description,
        Integer price,
        Size size,
        Color color,
        String category,
        Integer quantity
) {

}
