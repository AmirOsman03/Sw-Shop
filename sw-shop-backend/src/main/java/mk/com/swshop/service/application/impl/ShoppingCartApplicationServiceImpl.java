package mk.com.swshop.service.application.impl;

import mk.com.swshop.dto.display.DisplayShoppingCartDto;
import mk.com.swshop.model.enums.Size;
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

    @Override
    public DisplayShoppingCartDto removeProduct(String email, String name, Long productId) {
        return DisplayShoppingCartDto.from(shoppingCartService.removeProduct(email, name, productId));
    }

    @Override
    public DisplayShoppingCartDto addProductWithSize(String email, String name, Long productId, String size, int qty) {
        return DisplayShoppingCartDto.from(shoppingCartService.addProductWithSize(email, name, productId, size, qty));
    }

    @Override
    public DisplayShoppingCartDto removeProductWithSize(String email, String name, Long productId, Size size, int qty) {
        return DisplayShoppingCartDto.from(shoppingCartService.removeProductWithSize(email, name, productId, size, qty));
    }

}


