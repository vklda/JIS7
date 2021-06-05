package homework.streamapi.task5.service;

import homework.streamapi.task5.model.User;
import homework.streamapi.task5.model.UserStatus;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    public void setBetterUserStatusForGuestsAndActiveUsers(List<User> userList) {
        userList.forEach(it -> {
            if (isGuest(it)) {
                it.setUserStatus(UserStatus.USER);
                it.setActive(true);
            } else if (isActiveUser(it)) {
                it.setUserStatus(UserStatus.VIP);
            }
        });
    }

    public List<User> sortByNameAndDeactivateNonAdultUsers(List<User> userList) {
        return userList.stream()
                .sorted(Comparator.comparing(User::getUserName))
                .peek(this::deactivateIfNonAdult)
                .collect(Collectors.toList());
    }

    private boolean isGuest(User user) {
        return user.getUserStatus().equals(UserStatus.GUEST);
    }

    private boolean isActiveUser(User user) {
        return user.getUserStatus().equals(UserStatus.USER) && user.isActive();
    }

    private void deactivateIfNonAdult(User user) {
        final var EIGHTEEN = 18;
        if (user.getAge() < EIGHTEEN) {
            user.setUserStatus(UserStatus.GUEST);
            user.setActive(false);
        }
    }
}

