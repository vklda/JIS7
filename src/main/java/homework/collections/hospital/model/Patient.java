package homework.collections.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Patient {
    private String firstName;
    private String secondName;
    private Integer age;
    private boolean isPaid;
}
