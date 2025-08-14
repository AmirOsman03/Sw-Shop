package mk.com.swshop.repository;

import mk.com.swshop.model.domain.ShoppingCart;
import mk.com.swshop.model.domain.User;
import mk.com.swshop.model.enums.ShoppingCartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findByUser(User user);
}
