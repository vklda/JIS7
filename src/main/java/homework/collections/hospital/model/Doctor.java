package homework.collections.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Doctor {
    private String firstName;
    private String secondName;
    private DoctorTypes doctorType;
}
