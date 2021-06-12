package homework.streamapi.task5.model;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum UserStatus {
    GUEST("GUEST"),
    USER("USER"),
    VIP("VIP");

    private final String userType;
}
