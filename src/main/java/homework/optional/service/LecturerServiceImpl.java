package homework.optional.service;

import homework.optional.exceptions.LecturerNotFoundException;
import homework.optional.exceptions.NullFieldException;
import homework.optional.model.Lecturer;
import homework.optional.model.Student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static homework.optional.repository.LecturerRepository.lecturerList;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class LecturerServiceImpl implements Service<Lecturer> {

    public void addStudentToLecturer(Student student, Lecturer lecturer) {
        if (hasNullField(student)) {
            throw new NullFieldException("Student has NULL field");
        }
        if (!isStudentExist(student, lecturer)) {
            lecturer.getStudents().add(student);
        }
    }

    public void addStudentsToLecturer(List<Student> students, Lecturer lecturer) {
        List<Student> collect = students.stream()
                .filter(student -> nonNull(student) && !hasNullField(student) && !isStudentExist(student, lecturer))
                .collect(Collectors.toList());
        lecturer.getStudents().addAll(collect);
    }

    @Override
    public Lecturer findBySecondName(String secondName) {
        return lecturerList.stream()
                .filter(lecturer -> isEqualsBySecondName(secondName, lecturer))
                .findFirst()
                .orElseThrow(() -> new LecturerNotFoundException(String.format("Lecturer %s not found", secondName)));
    }

    private boolean isEqualsBySecondName(String secondName, Lecturer lecturer) {
        return nonNull(lecturer) && nonNull(lecturer.getSecondName()) && Objects.equals(lecturer.getSecondName(), secondName);
    }

    @Override
    public List<Lecturer> findByName(String firstName) {
        return lecturerList.stream()
                .filter(lecturer -> isEqualsByFirstName(firstName, lecturer))
                .collect(Collectors.toList());
    }

    private boolean isEqualsByFirstName(String firstName, Lecturer lecturer) {
        return nonNull(lecturer.getFirstName()) && lecturer.getFirstName().equals(firstName);
    }

    @Override
    public Lecturer findByFullName(String firstName, String secondName) {
        return lecturerList.stream()
                .filter(lecturer -> isEqualsByFullName(firstName, secondName, lecturer))
                .findFirst()
                .orElseThrow(() -> new LecturerNotFoundException(String.format("Lecturer %s %s not found", firstName, secondName)));
    }

    private boolean isEqualsByFullName(String firstName, String secondName, Lecturer lecturer) {
        return hasNonNullFields(lecturer) && lecturer.getFirstName().equals(firstName) && lecturer.getSecondName().equals(secondName);
    }

    @Override
    public void updateInfo(Lecturer lecturer, String firstName, String secondName, Integer age) {
        Optional.ofNullable(lecturer).ifPresent(it -> {
            if (isNotNull(firstName, secondName, age)) {
                it.setFirstName(firstName);
                it.setSecondName(secondName);
                it.setAge(age);
            }
        });
    }

    public void cleanStudents(Lecturer lecturer) {
        if (nonNull(lecturer)) {
            Optional.ofNullable(lecturer.getStudents()).ifPresent(List::clear);
        }
    }

    private boolean hasNonNullFields(Lecturer lecturer) {
        return nonNull(lecturer.getSecondName()) && nonNull(lecturer.getFirstName()) || nonNull(lecturer.getAge()) || nonNull(lecturer.getStudents());
    }

    private boolean hasNullField(Student student) {
        return isNull(student.getAge()) || isNull(student.getFirstName()) || isNull(student.getSecondName());
    }

    private boolean isNotNull(String firstName, String secondName, Integer age) {
        return nonNull(firstName) && nonNull(secondName) && nonNull(age);
    }

    private boolean isStudentExist(Student student, Lecturer lecturer) {
        return lecturer.getStudents().contains(student);
    }
}
