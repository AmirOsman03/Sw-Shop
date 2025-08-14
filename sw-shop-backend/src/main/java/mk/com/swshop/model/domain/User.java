package mk.com.swshop.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.com.swshop.model.enums.Role;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;


    public User(String email, String username) {
        this.username = username;
        this.email = email;
        this.role= Role.ROLE_USER;
    }

    public User(String username, String encode, Role userRole) {
        this.username = username;
        this.password = encode;
        this.role = userRole;
    }
}
