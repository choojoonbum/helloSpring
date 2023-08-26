package model.user;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;
    private String userId;
    private String password;
    private String email;
    private String name;
    @Enumerated(EnumType.STRING)
    private Role role;
    private LocalDateTime createDate;

    public User(String userId, String password, String email, String name) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.name = name;
        role = Role.MEMBER;
        createDate = LocalDateTime.now();
    }

    public boolean matchPassword(String password) {
        return this.password.equals(password);
    }
}
