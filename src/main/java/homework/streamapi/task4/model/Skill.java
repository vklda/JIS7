package homework.streamapi.task4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Skill {
    String skillName;
    Integer level;
}
