package homework.streamapi.task5.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String userName;
    private String firstName;
    private String secondName;
    private int age;
    private String email;
    private String password;
    private UserStatus userStatus;
    private boolean isActive;
}
