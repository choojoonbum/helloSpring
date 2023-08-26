package command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
public class BoardCommand {
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
}
