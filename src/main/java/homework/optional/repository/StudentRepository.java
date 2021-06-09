package homework.optional.repository;

import homework.optional.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    public static final List<Student> studentList = new ArrayList<>();

    public static void initialize() {
        studentList.add(new Student("Alexandr", "Mackevich", null));
        studentList.add(null);
        studentList.add(new Student(null,null,1));
        studentList.add(new Student("Vlad", "Kolyada", 25));
        studentList.add(new Student("Alexandr", "Tulai", 25));
        studentList.add(new Student("Denis", null, 28));
        studentList.add(new Student("Maxim", "Bumax", 30));
        studentList.add(new Student(null, "Abramov", 24));

    }
}
