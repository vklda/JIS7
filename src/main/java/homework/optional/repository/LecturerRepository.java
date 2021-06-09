package homework.optional.repository;

import homework.optional.model.Lecturer;

import java.util.ArrayList;
import java.util.List;

public class LecturerRepository {

    public static final List<Lecturer> lecturerList = new ArrayList<>();

    public static void initialize() {
        lecturerList.add(new Lecturer("Artsemi", "Stankevich", 26, new ArrayList<>()));
        lecturerList.add(new Lecturer("Maxim", "Shelkovich", 35, new ArrayList<>()));
        lecturerList.add(new Lecturer("Anton", "Kupreichik", 21, new ArrayList<>()));
        lecturerList.add(new Lecturer("Aleksei", "Kashliak", 23, new ArrayList<>()));
    }
}
