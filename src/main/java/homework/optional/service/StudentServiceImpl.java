package homework.optional.service;

import homework.optional.exceptions.StudentNotFoundException;
import homework.optional.model.Student;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static homework.optional.repository.StudentRepository.studentList;

public class StudentServiceImpl implements Service<Student> {

    @Override
    public Student findBySecondName(String secondName) {
        return studentList.stream()
                .filter(Objects::nonNull)
                .filter(it -> Objects.nonNull(it.getSecondName()) && it.getSecondName().equals(secondName))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException(String.format("Student %s not found", secondName)));
    }

    @Override
    public List<Student> findByName(String firstName) {
        return studentList.stream()
                .filter(Objects::nonNull)
                .filter(it -> Objects.nonNull(it.getFirstName()) && it.getFirstName().equals(firstName))
                .collect(Collectors.toList());
    }

    @Override
    public Student findByFullName(String firstName, String secondName) {
        return studentList.stream()
                .filter(Objects::nonNull)
                .filter(it -> Objects.nonNull(it.getFirstName()) && Objects.nonNull(it.getSecondName()))
                .filter(it -> it.getFirstName().equals(firstName) && it.getSecondName().equals(secondName))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException(String.format("Lecturer %s %s", firstName, secondName)));
    }

    @Override
    public void updateInfo(Student student, String firstName, String secondName, Integer age) {

    }


}
