package homework.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private Status status;
    private String email;

    public User(String firstName, String lastName, String username, Status status, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.status = status;
        this.email = email;
    }
}
