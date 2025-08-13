package mk.com.swshop.dto.display;

import mk.com.swshop.model.domain.User;
import mk.com.swshop.model.enums.Role;

public record DisplayUserDto(
        String email,
        String username,
        Role role
) {


    public static DisplayUserDto from(User user) {
        return new DisplayUserDto(
                user.getEmail(),
                user.getUsername(),
                user.getRole()
        );
    }
    public User toUser() {
        return new User(email,username, role);
    }


}
