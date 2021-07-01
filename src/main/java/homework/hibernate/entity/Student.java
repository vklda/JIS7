package homework.hibernate.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Student extends User {

    @ManyToOne
    private Lecturer lecturer;
}
