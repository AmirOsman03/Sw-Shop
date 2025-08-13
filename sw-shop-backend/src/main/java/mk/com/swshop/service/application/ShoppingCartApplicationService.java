package mk.com.swshop.service.application;


import mk.com.swshop.dto.display.DisplayProductDto;
import mk.com.swshop.dto.display.ShoppingCartDto;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartApplicationService {
    List<DisplayProductDto> listAllProductsInShoppingCart(Long cartId);

    Optional<ShoppingCartDto> getActiveShoppingCart(String username);

    Optional<ShoppingCartDto> addProductToShoppingCart(String username, Long productId);

}


