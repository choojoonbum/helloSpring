package model.board;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Attach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String uploadPath;
    @Column(name = "oriFileName")
    private String originFile;
    @Column(name = "newFileName")
    private String changeFile;
    private String fileType;
    private String size;
    private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "boardNo")
    private Board board;

    @Builder
    public Attach(String uploadPath, String originFile, String changeFile, String fileType, String size, LocalDateTime createDate, Board board) {
        this.uploadPath = uploadPath;
        this.originFile = originFile;
        this.changeFile = changeFile;
        this.fileType = fileType;
        this.size = size;
        this.createDate = createDate;
        this.board = board;
    }
}
