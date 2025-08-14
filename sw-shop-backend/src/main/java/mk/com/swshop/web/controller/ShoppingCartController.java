package mk.com.swshop.web.controller;

import mk.com.swshop.dto.display.DisplayShoppingCartDto;
import mk.com.swshop.service.application.ShoppingCartApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartApplicationService shoppingCartService;

    public ShoppingCartController(ShoppingCartApplicationService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public ResponseEntity<DisplayShoppingCartDto> getCart(
            @AuthenticationPrincipal OAuth2User principal
    ) {
        if (principal == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        String name = principal.getAttribute("name");
        String email = principal.getAttribute("email");

        return ResponseEntity.ok(shoppingCartService.getOrCreateCart(email, name));
    }

    @PostMapping("/add-product/{productId}")
    public ResponseEntity<DisplayShoppingCartDto> addProduct(
            @PathVariable Long productId,
            @AuthenticationPrincipal OAuth2User principal
    ) {
        if (principal == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String name = principal.getAttribute("name");
        String email = principal.getAttribute("email");

        return ResponseEntity.ok(shoppingCartService.addProduct(email, name, productId));
    }

}

