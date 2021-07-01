package homework.hibernate.service;

import homework.hibernate.entity.Lecturer;
import homework.hibernate.entity.Student;

import java.util.List;

public interface StudentService {
    Student create(String firstName, String secondName, String login, String password, String email);

    List<Student> findAllStudents();

    void addLecturerToStudent(Student student, Lecturer lecturer);

    Student getById(Long id);

    void update(Student student);

    void remove(Student student);
}
