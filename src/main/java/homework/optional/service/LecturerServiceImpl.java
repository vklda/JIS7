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

public class LecturerServiceImpl implements Service<Lecturer> {

    public void addStudentToLecturer(Student student, Lecturer lecturer) {
        if (isItHasNullField(student)) {
            throw new NullFieldException("Student has NULL field");
        }
        if (!lecturer.getStudents().contains(student)) {
            lecturer.getStudents().add(student);
        }
    }

    public void addStudentsToLecturer(List<Student> students, Lecturer lecturer) {
        List<Student> collect = students.stream()
                .filter(Objects::nonNull)
                .filter(student -> !isItHasNullField(student) && !lecturer.getStudents().contains(student))
                .collect(Collectors.toList());
        lecturer.getStudents().addAll(collect);
    }

    public void cleanStudents(Lecturer lecturer) {
        if (Objects.nonNull(lecturer)) {
            Optional.ofNullable(lecturer.getStudents()).ifPresent(List::clear);
        }
    }

    private boolean isItHasNullField(Student student) {
        return Objects.isNull(student.getAge()) || Objects.isNull(student.getFirstName()) || Objects.isNull(student.getSecondName());
    }

    @Override
    public Lecturer findBySecondName(String secondName) {
        return lecturerList.stream()
                .filter(Objects::nonNull)
                .filter(it -> Objects.nonNull(it.getSecondName()) && it.getSecondName().equals(secondName))
                .findFirst()
                .orElseThrow(() -> new LecturerNotFoundException(String.format("Lecturer %s not found", secondName)));
    }

    @Override
    public List<Lecturer> findByName(String firstName) {
        return lecturerList.stream()
                .filter(it -> Objects.nonNull(it.getFirstName()) && it.getFirstName().equals(firstName))
                .collect(Collectors.toList());
    }

    @Override
    public Lecturer findByFullName(String firstName, String secondName) {
        return lecturerList.stream()
                .filter(it -> Objects.nonNull(it.getSecondName()) && Objects.nonNull(it.getFirstName()))
                .filter(it -> it.getFirstName().equals(firstName) && it.getSecondName().equals(secondName))
                .findFirst()
                .orElseThrow(() -> new LecturerNotFoundException(String.format("Lecturer %s %s not found", firstName, secondName)));
    }

    @Override
    public void updateInfo(Lecturer lecturer, String firstName, String secondName, Integer age) {
        Optional.ofNullable(lecturer).ifPresent(it -> {
            if (Objects.nonNull(firstName) && Objects.nonNull(secondName) && Objects.nonNull(age)) {
                it.setFirstName(firstName);
                it.setSecondName(secondName);
                it.setAge(age);
            }
        });
    }
}
