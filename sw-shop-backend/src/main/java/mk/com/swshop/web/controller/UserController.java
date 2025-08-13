//package mk.com.swshop.web.controller;
//
//import mk.com.swshop.dto.create.CreateUserDto;
//import mk.com.swshop.dto.display.DisplayUserDto;
//import mk.com.swshop.dto.login.LoginRequestDto;
//import mk.com.swshop.dto.login.LoginResponseDto;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//
//    private final UserApplicationService userApplicationService;
//
//    public UserController(UserApplicationService userApplicationService) {
//        this.userApplicationService = userApplicationService;
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<LoginResponseDto> login(
//            @RequestBody LoginRequestDto loginRequestDto
//    ) {
//        return ResponseEntity.ok(userApplicationService.login(loginRequestDto));
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<DisplayUserDto> register(
//            @RequestBody CreateUserDto createUserDto
//    ) {
//        return ResponseEntity.ok(userApplicationService.register(createUserDto));
//    }
//
//    @GetMapping("/me")
//    public ResponseEntity<DisplayUserDto> getMe(
//            @AuthenticationPrincipal UserDetails userDetails
//    ) {
//        String username = userDetails.getUsername();
//        return ResponseEntity.ok(userApplicationService.getCurrentUser(username));
//    }
//
//}
