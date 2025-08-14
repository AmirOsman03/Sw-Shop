package mk.com.swshop.dto.display;

import mk.com.swshop.model.domain.Product;
import mk.com.swshop.model.domain.ShoppingCart;

import java.util.List;

public record DisplayShoppingCartDto(
        Long id,
        String username,
        List<Product> products
) {

    public static DisplayShoppingCartDto from(ShoppingCart shoppingCart) {
        return new DisplayShoppingCartDto(
                shoppingCart.getId(),
                shoppingCart.getUser().getUsername(),
                shoppingCart.getProducts()
        );
    }
}
