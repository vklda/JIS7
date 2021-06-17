package homework.optional;

import homework.optional.repository.LecturerRepository;
import homework.optional.repository.StudentRepository;
import homework.optional.service.LecturerServiceImpl;
import homework.optional.service.StudentServiceImpl;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

import static homework.optional.repository.StudentRepository.studentList;

@Log4j2
public class App {
    public static void main(String[] args) {
        LecturerRepository.initialize();
        StudentRepository.initialize();
        var studentService = new StudentServiceImpl();
        var lecturerService = new LecturerServiceImpl();
        var lecturer = lecturerService.findByFullName("Artsemi", "Stankevich");
        log.info(lecturer);
        var lecturers = lecturerService.findByName("");
        log.info(lecturers);
        var lecturer2 = lecturerService.findBySecondName("Stankevich");
        log.info(lecturer2.equals(lecturer));
        var student1 = studentService.findByFullName("Vlad", "Kolyada");
        var student2 = studentService.findByFullName("Alexandr", "Tulai");
        lecturerService.addStudentToLecturer(student1, lecturer);
        lecturerService.addStudentToLecturer(student2, lecturer2);
        log.info(lecturer);
        var student3 = studentService.findBySecondName("Bumax");
        lecturerService.addStudentToLecturer(student3, lecturer);
        log.info(lecturer);
        lecturerService.addStudentsToLecturer(studentList, lecturer);
        log.info(lecturer);
        lecturerService.cleanStudents(lecturer);
        log.info(lecturer);
    }
}
