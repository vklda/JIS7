package homework.hibernate.service;

import homework.hibernate.dao.HibernateSessionFactoryUtil;
import homework.hibernate.entity.Lecturer;
import homework.hibernate.entity.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Override
    public Student create(String firstName, String secondName, String login, String password, String email) {
        var session = new HibernateSessionFactoryUtil().getSessionFactory().openSession();
        session.beginTransaction();

        var student = buildStudent(firstName, secondName, login, password, email);

        session.save(student);

        session.getTransaction().commit();
        session.close();

        return student;
    }

    @Override
    public void addLecturerToStudent(Student student, Lecturer lecturer) {
        var session = new HibernateSessionFactoryUtil().getSessionFactory().openSession();
        session.beginTransaction();

        student.setLecturer(lecturer);

        session.update(student);
        session.update(lecturer);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Student getById(Long id) {
        var session = new HibernateSessionFactoryUtil().getSessionFactory().openSession();
        session.beginTransaction();

        var student = session.get(Student.class, id);

        session.getTransaction().commit();
        session.close();

        return student;
    }

    @Override
    public Student update(Student student) {
        var session = new HibernateSessionFactoryUtil().getSessionFactory().openSession();
        session.beginTransaction();

        session.update(student);

        session.getTransaction().commit();
        session.close();

        return student;
    }

    @Override
    public void remove(Student student) {
        var session = new HibernateSessionFactoryUtil().getSessionFactory().openSession();
        session.beginTransaction();

        session.remove(student);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Student> findAllStudents() {
        var session = new HibernateSessionFactoryUtil().getSessionFactory().openSession();
        session.beginTransaction();

        List<Student> resultList = session.createQuery("from Student").getResultList();

        session.getTransaction().commit();
        session.close();

        return resultList;
    }

    private Student buildStudent(String firstName, String secondName, String login, String password, String email) {
        var student = new Student();

        student.setFirstName(firstName);
        student.setSecondName(secondName);
        student.setLogin(login);
        student.setPassword(password);
        student.setEmail(email);

        return student;
    }

}
