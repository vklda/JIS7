package homework.hibernate.service;

import homework.hibernate.dao.HibernateSessionFactoryUtil;
import homework.hibernate.entity.Lecturer;

import java.util.List;

public class LecturerServiceImpl implements LecturerService {

    @Override
    public Lecturer create(String firstName, String secondName, String login, String password, String email, Double salary) {
        var session = new HibernateSessionFactoryUtil().getSessionFactory().openSession();
        session.beginTransaction();

        var lecturer = buildLecturer(firstName, secondName, login, password, email, salary);

        session.save(lecturer);

        session.getTransaction().commit();
        session.close();
        return lecturer;
    }


    @Override
    public List<Lecturer> findAllLecturers() {
        var session = new HibernateSessionFactoryUtil().getSessionFactory().openSession();
        session.beginTransaction();

        List<Lecturer> resultList = session.createQuery("from Lecturer ").getResultList();

        session.getTransaction().commit();
        session.close();
        return resultList;
    }

    @Override
    public Lecturer getById(Long id) {
        var session = new HibernateSessionFactoryUtil().getSessionFactory().openSession();
        session.beginTransaction();

        var lecturer = session.get(Lecturer.class, id);

        session.getTransaction().commit();
        session.close();

        return lecturer;
    }

    @Override
    public Lecturer update(Lecturer lecturer) {
        var session = new HibernateSessionFactoryUtil().getSessionFactory().openSession();
        session.beginTransaction();

        session.update(lecturer);

        session.getTransaction().commit();
        session.close();

        return lecturer;
    }

    @Override
    public void remove(Lecturer lecturer) {
        var session = new HibernateSessionFactoryUtil().getSessionFactory().openSession();
        session.beginTransaction();

        session.remove(lecturer);

        session.getTransaction().commit();
        session.close();
    }

    private Lecturer buildLecturer(String firstName, String secondName, String login, String password, String email, Double salary) {
        var lecturer = new Lecturer();

        lecturer.setFirstName(firstName);
        lecturer.setSecondName(secondName);
        lecturer.setLogin(login);
        lecturer.setPassword(password);
        lecturer.setEmail(email);
        lecturer.setSalary(salary);

        return lecturer;
    }
}
