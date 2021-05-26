package homework.streamapi.task4.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {
    Long id;
    String name;
    Skill[] skill;

    public Person(Long id, String name, Skill... skill) {
        this.id = id;
        this.name = name;
        this.skill = skill;
    }
}
