package homework.optional.service;

import java.util.List;

public interface Service<T> {
    T findBySecondName(String secondName);

    List<T> findByName(String firstName);

    T findByFullName(String firstName, String secondName);

    void updateInfo(T t, String firstName, String secondName, Integer age);
}
