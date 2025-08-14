package mk.com.swshop.service.domain.impl;

import jakarta.transaction.Transactional;
import mk.com.swshop.model.domain.Product;
import mk.com.swshop.model.domain.ShoppingCart;
import mk.com.swshop.model.domain.User;
import mk.com.swshop.model.enums.Role;
import mk.com.swshop.model.enums.Size;
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

    public ShoppingCart removeProduct(String email, String name, Long productId) {
        ShoppingCart cart = getOrCreateCart(email, name);
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        cart.getProducts().remove(product); // вади само еден
        return cartRepo.save(cart);
    }


    @Transactional
    public ShoppingCart addProductWithSize(String email, String name, Long productId, String size, int qty) {
        ShoppingCart cart = getOrCreateCart(email, name);
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Конверзија од String во Size enum
        Size sizeEnum;
        try {
            sizeEnum = Size.valueOf(size.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid size: " + size);
        }

        // Проверка за количина
        Integer stock = product.getQuantityBySize().get(sizeEnum);
        if (stock == null || stock < qty) {
            throw new RuntimeException("Not enough stock for size " + sizeEnum);
        }

        // Намалување од залиха
        product.getQuantityBySize().put(sizeEnum, stock - qty);
        productRepo.save(product);

        // Додавање во кошничка
        cart.getProducts().add(product);
        return cartRepo.save(cart);
    }


    @Transactional
    public ShoppingCart removeProductWithSize(String email, String name, Long productId, Size size, int qty) {
        ShoppingCart cart = getOrCreateCart(email, name);
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Враќање на количина во залиха
        Integer stock = product.getQuantityBySize().get(size);
        if (stock == null) stock = 0;
        product.getQuantityBySize().put(size, stock + qty);
        productRepo.save(product);

        // Отстранување од кошничката (ќе ги отстрани сите референци од истиот производ)
        cart.getProducts().remove(product);
        return cartRepo.save(cart);
    }


}
