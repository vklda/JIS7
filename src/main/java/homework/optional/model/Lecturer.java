package homework.optional.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lecturer {
    private String firstName;
    private String secondName;
    private Integer age;
    private List<Student> students;
}
