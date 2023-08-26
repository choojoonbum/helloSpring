package service.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.user.Role;

@AllArgsConstructor
@Getter
public class AuthInfo {
    private Long userNo;
    private String userId;
    private Role role;
}
