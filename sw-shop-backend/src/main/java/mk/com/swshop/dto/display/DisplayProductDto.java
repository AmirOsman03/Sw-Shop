package mk.com.swshop.dto.display;

import mk.com.swshop.model.domain.Product;
import mk.com.swshop.model.enums.Color;
import mk.com.swshop.model.enums.Size;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public record DisplayProductDto(
        Long id,
        String name,
        String description,
        Integer price,
        List<Size> sizes,
        Color color,
        String category,
        Map<Size, Integer> quantityBySize,
        List<String> images
) {
    public static DisplayProductDto from(Product product) {
        return new DisplayProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getSizes(),
                product.getColor(),
                product.getCategory().name(),
                product.getQuantityBySize(),
                product.getImages()
        );
    }

    public static List<DisplayProductDto> from(List<Product> products) {
        return products.stream().map(DisplayProductDto::from).toList();
    }
}
