package homework.hibernate.service;

import homework.hibernate.dao.HibernateUtil;
import homework.hibernate.entity.Lecturer;
import homework.hibernate.entity.Student;

import java.util.List;

public class LecturerServiceImpl implements LecturerService {

    @Override
    public Lecturer create(String firstName, String secondName, String login, String password, String email, Double salary) {
        var session = new HibernateUtil().getSessionFactory().openSession();
        session.beginTransaction();

        var lecturer = buildLecturer(firstName, secondName, login, password, email, salary);

        session.save(lecturer);

        session.getTransaction().commit();
        session.close();
        return lecturer;
    }


    @Override
    public List<Lecturer> findAllLecturers() {
        var session = new HibernateUtil().getSessionFactory().openSession();
        session.beginTransaction();

        List<Lecturer> resultList = session.createQuery("from Lecturer ").getResultList();

        session.getTransaction().commit();
        session.close();
        return resultList;
    }

    private Lecturer buildLecturer(String firstName, String secondName, String login, String password, String email, Double salary) {
        var lecturer = new Lecturer();
        lecturer.setFirstName(firstName);
        lecturer.setSecondName(secondName);
        lecturer.setLogin(login);
        lecturer.setPassword(password);
        lecturer.setEmail(email);
        return lecturer;
    }
}
