package mk.com.swshop.service.domain;

import mk.com.swshop.model.domain.ShoppingCart;
import mk.com.swshop.model.domain.User;
import mk.com.swshop.model.enums.Size;

public interface ShoppingCartService {

    ShoppingCart getOrCreateCart(String email, String name);

    ShoppingCart addProduct(String email, String name, Long productId);

    ShoppingCart removeProduct(String email, String name, Long productId);

    ShoppingCart addProductWithSize(String email, String name, Long productId, String size, int qty);

    ShoppingCart removeProductWithSize(String email, String name, Long productId, Size size, int qty);

}
