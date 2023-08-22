package command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterCommand {
    private String userId;
    private String password;
    private String confirmPassword;
    private String email;
    private String name;

    public boolean isPasswordEqualToConfirmPassword() {
        return password.equals(confirmPassword);
    }
}
