package homework.streamapi.task5.service;

import homework.streamapi.task5.model.User;
import homework.streamapi.task5.model.UserStatus;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    private Service() {
    }

    public static void setBetterUserStatusForGuestsAndActiveUsers(List<User> userList) {
        userList.forEach(it -> {
            if (isGuest(it)) {
                it.setUserStatus(UserStatus.USER);
                it.setActive(true);
            } else if (isActiveUser(it)) {
                it.setUserStatus(UserStatus.VIP);
            }
        });
    }

    public static List<User> sortByNameAndDeactivateNonAdultUsers(List<User> userList) {
        return userList.stream()
                .sorted(Comparator.comparing(User::getUserName))
                .peek(Service::deactivateIfNonAdult)
                .collect(Collectors.toList());
    }

    private static boolean isGuest(User it) {
        return it.getUserStatus().equals(UserStatus.GUEST);
    }

    private static boolean isActiveUser(User it) {
        return it.getUserStatus().equals(UserStatus.USER) && it.isActive();
    }

    private static void deactivateIfNonAdult(User it) {
        final var EIGHTEEN = 18;
        if (it.getAge() < EIGHTEEN) {
            it.setUserStatus(UserStatus.GUEST);
            it.setActive(false);
        }
    }
}

