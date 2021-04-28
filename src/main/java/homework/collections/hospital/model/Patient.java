package homework.collections.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Patient {
    private String firstName;
    private String secondName;
    private Integer age;
    private boolean isPaid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return isPaid == patient.isPaid && Objects.equals(firstName, patient.firstName) && Objects.equals(secondName, patient.secondName) && Objects.equals(age, patient.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, age, isPaid);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", isPaid=" + isPaid +
                '}';
    }
}
