package model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_info")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInfo {
    @Id
    private String userId;
    private String appFl;
    private LocalDateTime birthDate;
    private String sex;
    private String zipcode;
    private String address;
    private String addressSub;
    private String phone;
    private String mailFl;
    private String smsFl;
}