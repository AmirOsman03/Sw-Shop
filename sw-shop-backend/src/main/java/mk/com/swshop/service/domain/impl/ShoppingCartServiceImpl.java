package mk.com.swshop.service.domain.impl;

import mk.com.swshop.model.domain.Product;
import mk.com.swshop.model.domain.ShoppingCart;
import mk.com.swshop.model.domain.User;
import mk.com.swshop.model.enums.ShoppingCartStatus;
import mk.com.swshop.repository.ShoppingCartRepository;
import mk.com.swshop.service.domain.ProductService;
import mk.com.swshop.service.domain.ShoppingCartService;
import mk.com.swshop.service.domain.UserService;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final UserService userService;
    private final ProductService productService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, UserService userService, ProductService productService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public List<Product> listAllProductsInShoppingCart(Long cartId) {
        if (shoppingCartRepository.findById(cartId).isEmpty())
            throw new NullPointerException();
        return shoppingCartRepository.findById(cartId).get().getProducts();
    }

    @Override
    public Optional<ShoppingCart> getActiveShoppingCart(String username) {
        User user = userService.findByUsername(username);

        return Optional.of(shoppingCartRepository.findByUserAndStatus(
                user,
                ShoppingCartStatus.CREATED
        ).orElseGet(() -> shoppingCartRepository.save(new ShoppingCart(user))));
    }

    @Override
    public Optional<ShoppingCart> addProductToShoppingCart(String username, Long productId) {
        if (getActiveShoppingCart(username).isPresent()) {
            ShoppingCart shoppingCart = getActiveShoppingCart(username).get();

            Product product = productService.findById(productId)
                    .orElseThrow(() -> new ExpressionException("Product not found"));
            if (!shoppingCart.getProducts().stream().filter(i -> i.getId().equals(productId)).toList().isEmpty())
                throw new NullPointerException();
            shoppingCart.getProducts().add(product);
            return Optional.of(shoppingCartRepository.save(shoppingCart));
        }
        return Optional.empty();
    }

}
