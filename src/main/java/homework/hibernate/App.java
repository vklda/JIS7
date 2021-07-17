package homework.hibernate;

import homework.hibernate.service.LecturerServiceImpl;
import homework.hibernate.service.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    public static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        var lecturerService = new LecturerServiceImpl();
        var studentService = new StudentServiceImpl();
        var lecturer = lecturerService.create("firstName",
                "secondName",
                "login",
                "password",
                "firstemail@email.by",
                100D);

        var student = studentService.create("Vlad",
                "Kolyada",
                "student1",
                "1111",
                "student1@gmail.com");

        studentService.addLecturerToStudent(student, lecturer);

        lecturerService.create("Artsemi",
                "Stankevich",
                "artik",
                "qwerty",
                "lecturer2@gmail.com",
                250D);

        var allLecturers = lecturerService.findAllLecturers();
        allLecturers.forEach(System.out::println);

        var allStudents = studentService.findAllStudents();
        allStudents.forEach(System.out::println);
    }
}
