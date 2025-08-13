package mk.com.swshop.service.application.impl;

import mk.com.swshop.dto.create.CreateUserDto;
import mk.com.swshop.dto.display.DisplayUserDto;
import mk.com.swshop.dto.login.LoginRequestDto;
import mk.com.swshop.dto.login.LoginResponseDto;
import mk.com.swshop.service.application.UserApplicationService;
import mk.com.swshop.service.domain.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserApplicationServiceImpl implements UserApplicationService {

    private final UserService userService;

    public UserApplicationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        return null;
    }

    @Override
    public DisplayUserDto register(CreateUserDto createUserDto) {
        return null;
    }

    @Override
    public DisplayUserDto getCurrentUser(String username) {
        return null;
    }
}
