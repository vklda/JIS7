package homework.hibernate.service;

import homework.hibernate.dao.HibernateUtil;
import homework.hibernate.entity.Lecturer;
import homework.hibernate.entity.Student;
import org.hibernate.Hibernate;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {

    @Override
    public Student create(String firstName, String secondName, String login, String password, String email) {
        var session = new HibernateUtil().getSessionFactory().openSession();
        session.beginTransaction();

        var student = buildStudent(firstName, secondName, login, password, email);

        session.save(student);

        session.getTransaction().commit();
        session.close();
        return student;
    }
    @Override
    public void addStudentToLecturer(Student student, Lecturer lecturer) {
        var session = new HibernateUtil().getSessionFactory().openSession();
        session.beginTransaction();

        student.setLecturer(lecturer);

        session.update(student);
        session.update(lecturer);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Student> findAllStudents() {
        var session = new HibernateUtil().getSessionFactory().openSession();
        session.beginTransaction();

        //List<Student> resultList = session.createQuery("SELECT s FROM Student s left join s.lecturer", Student.class).getResultList(); // - the same
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
