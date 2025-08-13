package mk.com.swshop.service.impl;



import mk.com.swshop.model.domain.User;
import mk.com.swshop.model.enums.Role;
import mk.com.swshop.repository.UserRepository;
import mk.com.swshop.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                username));
    }

    @Override
    public User register(
            String username,
            String password,
            String repeatPassword,
            Role userRole
    ) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new NullPointerException();
        if (!password.equals(repeatPassword)) throw new NullPointerException(username);
        if (userRepository.findByUsername(username).isPresent())
            throw new NullPointerException(username);
        User user = new User(username, passwordEncoder.encode(password), userRole);
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new NullPointerException();
        User user = userRepository.findByUsername(username)
                .orElse(null);
        assert user != null;
        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new NullPointerException();
        return user;
    }

}
