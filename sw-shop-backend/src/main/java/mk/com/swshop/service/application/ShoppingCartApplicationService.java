package mk.com.swshop.service.application;

import mk.com.swshop.dto.display.DisplayShoppingCartDto;
import mk.com.swshop.model.domain.ShoppingCart;
import mk.com.swshop.model.domain.User;
import mk.com.swshop.model.enums.Size;

public interface ShoppingCartApplicationService {

    DisplayShoppingCartDto addProduct(String email, String name, Long productId);

    DisplayShoppingCartDto getOrCreateCart(String email, String name);

    DisplayShoppingCartDto removeProduct(String email, String name, Long productId);

    DisplayShoppingCartDto addProductWithSize(String email, String name, Long productId, String size, int qty);

    DisplayShoppingCartDto removeProductWithSize(String email, String name, Long productId, Size size, int qty);

    }


