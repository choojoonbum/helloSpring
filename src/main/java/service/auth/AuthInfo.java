package service.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.user.Role;

@AllArgsConstructor
@Getter
public class AuthInfo {
    private String userId;
    private String email;
    private String name;
    private Role role;
}
