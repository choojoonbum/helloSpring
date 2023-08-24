package model.board;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private int visitCount;
    @ManyToOne
    @JoinColumn(name = "userNo")
    private User user;

    @Builder
    public Board(String title, String content, LocalDateTime createDate, int visitCount) {
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.visitCount = visitCount;
    }
}
