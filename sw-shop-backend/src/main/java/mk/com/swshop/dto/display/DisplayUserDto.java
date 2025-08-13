package mk.com.swshop.dto.display;

import mk.com.swshop.model.enums.Role;

public record DisplayUserDto(
        String email,
        String username,
        Role role
) {

}
