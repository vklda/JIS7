package homework.optional.service;

import homework.optional.exceptions.NullFieldException;
import homework.optional.repository.LecturerRepository;
import homework.optional.repository.StudentRepository;
import org.junit.jupiter.api.*;

import static homework.optional.repository.LecturerRepository.lecturerList;
import static homework.optional.repository.StudentRepository.studentList;
import static org.junit.jupiter.api.Assertions.*;

class LecturerServiceImplTest {
    LecturerServiceImpl lecturerService;
    StudentServiceImpl studentService;

    @BeforeEach
    void setUp() {
        StudentRepository.initialize();
        LecturerRepository.initialize();
        lecturerService = new LecturerServiceImpl();
        studentService = new StudentServiceImpl();
    }

    @AfterEach
    void clean() {
        studentList.clear();
        lecturerList.clear();
    }

    @Test
    void addStudentToLecturerPositive() {
        lecturerService.addStudentToLecturer(studentList.get(3), lecturerList.get(0));
        Assertions.assertEquals(1, lecturerList.get(0).getStudents().size());
    }

    @Test
    void addStudentToLecturerThrowsException() {
        Assertions.assertThrows(NullFieldException.class, () -> {
            lecturerService.addStudentToLecturer(studentList.get(0), lecturerList.get(0));
        });

    }

    @Test
    void cleanStudents() {
        lecturerService.addStudentsToLecturer(studentList, lecturerList.get(0));
        Assertions.assertEquals(3,lecturerList.get(0).getStudents().size());
        lecturerService.cleanStudents(lecturerList.get(0));
        Assertions.assertEquals(0,lecturerList.get(0).getStudents().size());
    }

    @Test
    void addStudentsToLecturer() {
        lecturerService.addStudentsToLecturer(studentList, lecturerList.get(0));
        Assertions.assertEquals(3,lecturerList.get(0).getStudents().size());
    }

    @Test
    void findBySecondName() {
    }

    @Test
    void findByName() {
    }

    @Test
    void findByFullName() {
    }

    @Test
    void updateInfo() {
    }
}