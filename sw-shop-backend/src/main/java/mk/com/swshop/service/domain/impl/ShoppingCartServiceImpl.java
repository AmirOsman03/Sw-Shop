package mk.com.swshop.service.domain.impl;

import mk.com.swshop.model.domain.Product;
import mk.com.swshop.model.domain.ShoppingCart;
import mk.com.swshop.model.domain.User;
import mk.com.swshop.model.enums.Role;
import mk.com.swshop.repository.ProductRepository;
import mk.com.swshop.repository.ShoppingCartRepository;
import mk.com.swshop.repository.UserRepository;
import mk.com.swshop.service.domain.ShoppingCartService;

import org.springframework.stereotype.Service;


@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository cartRepo;
    private final UserRepository userRepo;
    private final ProductRepository productRepo;

    public ShoppingCartServiceImpl(ShoppingCartRepository cartRepo,
                                   UserRepository userRepo,
                                   ProductRepository productRepo) {
        this.cartRepo = cartRepo;
        this.userRepo = userRepo;
        this.productRepo = productRepo;
    }

    @Override
    public ShoppingCart addProduct(String email, String username, Long productId) {
        ShoppingCart cart = getOrCreateCart(email, username);

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        cart.getProducts().add(product);
        return cartRepo.save(cart);
    }

    public ShoppingCart getOrCreateCart(String email, String name) {
        User user = userRepo.findByUsername(name)
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setUsername(name);
                    newUser.setEmail(email);
                    newUser.setRole(Role.ROLE_USER);
                    return userRepo.save(newUser);
                });

        return cartRepo.findByUser(user).orElseGet(() -> {
            ShoppingCart cart = new ShoppingCart();
            cart.setUser(user);
            return cartRepo.save(cart);
        });
    }

}
