package command;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserRegisterCommand {
    @NotBlank
    @Size(min = 6, max = 10)
    private String userId;
    @NotBlank
    @Size(min = 6, max = 10)
    private String password;
    @NotBlank
    private String confirmPassword;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String name;

    public boolean isPasswordEqualToConfirmPassword() {
        return password.equals(confirmPassword);
    }
}
