package homework.collections.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Doctor {
    private String firstName;
    private String secondName;
    private DoctorTypes doctorType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(firstName, doctor.firstName) && Objects.equals(secondName, doctor.secondName) && doctorType == doctor.doctorType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, doctorType);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", doctorType=" + doctorType +
                '}';
    }
}
