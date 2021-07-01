package homework.hibernate.service;

import homework.hibernate.entity.Lecturer;

import java.util.List;

public interface LecturerService {
    Lecturer create(String firstName, String secondName, String login, String password, String email, Double salary);

    List<Lecturer> findAllLecturers();
}
