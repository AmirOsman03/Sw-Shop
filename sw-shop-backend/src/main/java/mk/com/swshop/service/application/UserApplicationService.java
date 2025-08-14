package mk.com.swshop.service.application;

import mk.com.swshop.dto.create.CreateUserDto;
import mk.com.swshop.dto.display.DisplayUserDto;
import mk.com.swshop.dto.login.LoginRequestDto;
import mk.com.swshop.dto.login.LoginResponseDto;

public interface UserApplicationService {

    DisplayUserDto login(LoginRequestDto loginRequestDto);

    DisplayUserDto register(CreateUserDto createUserDto);

    DisplayUserDto getCurrentUser(String username);

}
