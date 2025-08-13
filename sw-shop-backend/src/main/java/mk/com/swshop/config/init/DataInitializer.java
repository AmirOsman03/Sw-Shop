package mk.com.swshop.config.init;

import jakarta.annotation.PostConstruct;
import mk.com.swshop.model.domain.Product;
import mk.com.swshop.model.domain.User;
import mk.com.swshop.model.enums.Category;
import mk.com.swshop.model.enums.Color;
import mk.com.swshop.model.enums.Role;
import mk.com.swshop.model.enums.Size;
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

    public DataInitializer(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.productRepository = productRepository;
    }

//    @PostConstruct
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
            List<Product> products = List.of(
                    new Product(
                            "Lace Push-Up Bra",
                            "Elegant push-up bra made from soft lace, perfect for everyday wear",
                            1200,
                            List.of(Size.S, Size.M, Size.L),
                            Color.BEIGE,
                            Category.BRAS,
                            Map.of(Size.S, 10, Size.M, 8, Size.L, 5),
                            List.of(
                                    "https://example.com/bra1.jpg",
                                    "https://example.com/bra2.jpg"
                            )
                    ),
                    new Product(
                            "Cotton Panties Set",
                            "3-pack of comfortable cotton panties in assorted colors",
                            500,
                            List.of(Size.S, Size.M, Size.L),
                            Color.WHITE,
                            Category.PANTIES,
                            Map.of(Size.S, 20, Size.M, 15, Size.L, 12),
                            List.of(
                                    "https://example.com/panties1.jpg",
                                    "https://example.com/panties2.jpg"
                            )
                    ),
                    new Product(
                            "Silk Lingerie Nightgown",
                            "Soft silk nightgown with adjustable straps, luxurious and comfortable",
                            2500,
                            List.of(Size.S, Size.M, Size.L),
                            Color.RED,
                            Category.LINGERIE,
                            Map.of(Size.S, 5, Size.M, 3, Size.L, 2),
                            List.of(
                                    "https://example.com/nightgown1.jpg",
                                    "https://example.com/nightgown2.jpg"
                            )
                    ),
                    new Product(
                            "Thermal Knit Pajamas",
                            "Warm and cozy knit pajamas, ideal for winter nights",
                            1800,
                            List.of(Size.M, Size.L, Size.XL),
                            Color.BLUE,
                            Category.PAJAMAS,
                            Map.of(Size.M, 7, Size.L, 4, Size.XL, 3),
                            List.of(
                                    "https://example.com/pajamas1.jpg",
                                    "https://example.com/pajamas2.jpg"
                            )
                    ),
                    new Product(
                            "Seamless Sports Bra",
                            "Breathable seamless sports bra for active women",
                            1500,
                            List.of(Size.S, Size.M, Size.L),
                            Color.BLACK,
                            Category.BRAS,
                            Map.of(Size.S, 12, Size.M, 9, Size.L, 6),
                            List.of(
                                    "https://example.com/sportsbra1.jpg",
                                    "https://example.com/sportsbra2.jpg"
                            )
                    )
            );

            productRepository.saveAll(products);
        }
    }
}
