package homework.streamapi.task4.service;

import homework.streamapi.task4.exception.DontFindRequiredPersonException;
import homework.streamapi.task4.model.Person;
import homework.streamapi.task4.model.Skill;
import homework.streamapi.task4.repository.Repository;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static homework.streamapi.task4.repository.Repository.personList;

public class Service {
    static {
        Repository.initialize();
    }

    public Person findBestMatchingPerson(String skillName) {
        var collectByRequiredLevel = personList.stream()
                .collect(Collectors.toMap(Function.identity(), it -> Arrays.stream(it.getSkill())
                        .filter(skill -> skill.getSkillName().equals(skillName))
                        .max((p1, p2) -> p2.getLevel().compareTo(p1.getLevel()))));

        var person = collectByRequiredLevel.entrySet().stream()
                .filter(entry -> entry.getValue().isPresent())
                .max(Comparator.comparing(p -> p.getValue().get().getLevel()))
                .map(Map.Entry::getKey);
        if (person.isPresent()) {
            return person.get();
        }
        throw new DontFindRequiredPersonException("dont find required programmer");
    }
}