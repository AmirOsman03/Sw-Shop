package mk.com.swshop.service.application;

import mk.com.swshop.dto.display.DisplayShoppingCartDto;
import mk.com.swshop.model.domain.ShoppingCart;
import mk.com.swshop.model.domain.User;

public interface ShoppingCartApplicationService {

    DisplayShoppingCartDto addProduct(String email, String name, Long productId);

    DisplayShoppingCartDto getOrCreateCart(String email, String name);

    DisplayShoppingCartDto removeProduct(String email, String name, Long productId);

}


