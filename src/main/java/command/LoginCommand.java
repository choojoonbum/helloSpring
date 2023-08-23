package command;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class LoginCommand {
    @NotBlank
    @Size(min = 6, max = 10)
    private String userId;
    @NotBlank
    @Size(min = 6, max = 10)
    private String password;
    private boolean rememberUserId;
}
