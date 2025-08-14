package mk.com.swshop.service.domain;

import mk.com.swshop.model.domain.ShoppingCart;
import mk.com.swshop.model.domain.User;

public interface ShoppingCartService {

    ShoppingCart getOrCreateCart(String email, String name);

    ShoppingCart addProduct(String email, String name, Long productId);

    ShoppingCart removeProduct(String email, String name, Long productId);

}
