package command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BoardCommand {
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    List<MultipartFile> multiFileList;
}
