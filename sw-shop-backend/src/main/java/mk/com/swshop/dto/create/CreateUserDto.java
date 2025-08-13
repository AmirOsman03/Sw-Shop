package mk.com.swshop.dto.create;

public record CreateUserDto(
        String username,
        String password,
        String repeatPassword
) {

}
