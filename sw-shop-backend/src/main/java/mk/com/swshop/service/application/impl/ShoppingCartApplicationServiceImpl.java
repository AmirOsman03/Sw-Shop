package mk.com.swshop.service.application.impl;

import mk.com.swshop.dto.display.DisplayShoppingCartDto;
import mk.com.swshop.model.domain.User;
import mk.com.swshop.service.application.ShoppingCartApplicationService;
import mk.com.swshop.service.domain.ShoppingCartService;
import org.springframework.stereotype.Service;


@Service
public class ShoppingCartApplicationServiceImpl implements ShoppingCartApplicationService {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartApplicationServiceImpl(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public DisplayShoppingCartDto addProduct(String email, String name, Long productId) {
        return DisplayShoppingCartDto.from(shoppingCartService.addProduct(email, name, productId));
    }

    @Override
    public DisplayShoppingCartDto getOrCreateCart(String email, String name) {
        return DisplayShoppingCartDto.from(shoppingCartService.getOrCreateCart(email, name));
    }

}


