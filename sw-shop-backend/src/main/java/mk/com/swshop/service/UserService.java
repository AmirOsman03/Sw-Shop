package mk.com.swshop.service;

import mk.com.swshop.model.domain.User;
import mk.com.swshop.model.enums.Role;

public interface UserService {

    User register(String username, String password, String repeatPassword, Role role);

    User login(String username, String password);

    User findByUsername(String username);

}
