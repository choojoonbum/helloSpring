package model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_log")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserLog {
    @Id
    private String userId;
    private LocalDateTime lastLoginDate;
    private String lastLoginIP;
    private int loginCnt;
}
