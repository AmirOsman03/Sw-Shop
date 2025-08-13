package mk.com.swshop.config.init;

import jakarta.annotation.PostConstruct;
import mk.com.swshop.model.domain.Product;
import mk.com.swshop.model.domain.ProductImage;
import mk.com.swshop.model.domain.User;
import mk.com.swshop.model.enums.Category;
import mk.com.swshop.model.enums.Color;
import mk.com.swshop.model.enums.Role;
import mk.com.swshop.model.enums.Size;
import mk.com.swshop.repository.ProductImageRepository;
import mk.com.swshop.repository.ProductRepository;
import mk.com.swshop.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DataInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;

    public DataInitializer(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           ProductRepository productRepository,
                           ProductImageRepository productImageRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.productRepository = productRepository;
        this.productImageRepository = productImageRepository;
    }

    @PostConstruct
    public void init() {
        initUsers();
        initProducts();
    }

    private void initUsers() {
        if (userRepository.count() == 0) {
            List<User> users = List.of(
                    new User("admin", passwordEncoder.encode("admin"), Role.ROLE_ADMIN),
                    new User("isen", passwordEncoder.encode("isen"), Role.ROLE_USER),
                    new User("user", passwordEncoder.encode("user"), Role.ROLE_USER)
            );
            userRepository.saveAll(users);
        }
    }

    private void initProducts() {
        if (productRepository.count() == 0) {
            Product product1 = new Product(
                    "Blue T-Shirt",
                    "Cotton T-shirt, soft and comfortable",
                    450,
                    List.of(Size.S, Size.M, Size.L),
                    Color.BLUE,
                    Category.KNITWEAR,
                    Map.of(Size.S, 10, Size.M, 5, Size.L, 8)
            );

            Product product2 = new Product(
                    "Black Hoodie",
                    "Warm hoodie for cold days",
                    1200,
                    List.of(Size.M, Size.L, Size.XL),
                    Color.BLACK,
                    Category.LINGERIE,
                    Map.of(Size.M, 7, Size.L, 3, Size.XL, 0)
            );

            Product product3 = new Product(
                    "Red Dress",
                    "Elegant dress for special occasions",
                    2500,
                    List.of(Size.S, Size.M),
                    Color.RED,
                    Category.PAJAMAS,
                    Map.of(Size.S, 2, Size.M, 0)
            );

            Product product4 = new Product(
                    "White Sneakers",
                    "Comfortable everyday sneakers",
                    3000,
                    List.of(Size.M, Size.L, Size.XL),
                    Color.WHITE,
                    Category.BRAS,
                    Map.of(Size.M, 12, Size.L, 6, Size.XL, 4)
            );

            productRepository.saveAll(List.of(product1, product2, product3, product4));

            // Додавање ProductImages
            productImageRepository.saveAll(List.of(
                    new ProductImage("https://example.com/blue_tshirt_1.jpg", product1),
                    new ProductImage("https://example.com/blue_tshirt_2.jpg", product1),

                    new ProductImage("https://example.com/black_hoodie_1.jpg", product2),
                    new ProductImage("https://example.com/black_hoodie_2.jpg", product2),

                    new ProductImage("https://example.com/red_dress_1.jpg", product3),
                    new ProductImage("https://example.com/red_dress_2.jpg", product3),

                    new ProductImage("https://example.com/white_sneakers_1.jpg", product4),
                    new ProductImage("https://example.com/white_sneakers_2.jpg", product4)
            ));
        }
    }
}
