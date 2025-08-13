package mk.com.swshop.service.application.impl;

import mk.com.swshop.dto.display.DisplayProductDto;
import mk.com.swshop.dto.display.ShoppingCartDto;
import mk.com.swshop.service.application.ShoppingCartApplicationService;
import mk.com.swshop.service.domain.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartApplicationServiceImpl implements ShoppingCartApplicationService {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartApplicationServiceImpl(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public List<DisplayProductDto> listAllProductsInShoppingCart(Long cartId) {
        return DisplayProductDto.from(shoppingCartService.listAllProductsInShoppingCart(cartId));
    }

    @Override
    public Optional<ShoppingCartDto> getActiveShoppingCart(String username) {
        return shoppingCartService.getActiveShoppingCart(username).map(ShoppingCartDto::from);
    }

    @Override
    public Optional<ShoppingCartDto> addProductToShoppingCart(String username, Long productId) {
        return shoppingCartService.addProductToShoppingCart(username, productId).map(ShoppingCartDto::from);
    }
}


