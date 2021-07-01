package homework.hibernate.service;

import homework.hibernate.entity.Lecturer;
import homework.hibernate.entity.Student;

import java.util.List;

public interface StudentService {
    Student create(String firstName, String secondName, String login, String password, String email);

    List<Student> findAllStudents();

    void addStudentToLecturer(Student student, Lecturer lecturer);
}
