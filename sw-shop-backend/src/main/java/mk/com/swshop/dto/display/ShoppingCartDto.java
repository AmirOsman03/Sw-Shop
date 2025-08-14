//package mk.com.swshop.dto.display;
//
//import mk.com.swshop.model.domain.ShoppingCart;
//import mk.com.swshop.model.enums.ShoppingCartStatus;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//public record ShoppingCartDto(
//        Long id,
//        LocalDateTime dateCreated,
//        DisplayUserDto user,
//        List<DisplayProductDto> products,
//        ShoppingCartStatus status
//) {
//
//    public static ShoppingCartDto from(ShoppingCart shoppingCart) {
//        return new ShoppingCartDto(
//                shoppingCart.getId(),
//                shoppingCart.getDateCreated(),
//                DisplayUserDto.from(shoppingCart.getUser()),
//                DisplayProductDto.from(shoppingCart.getProducts()),
//                shoppingCart.getStatus()
//        );
//    }
//}
//
