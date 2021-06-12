package homework.streamapi.task5;

import homework.streamapi.task5.model.User;
import homework.streamapi.task5.model.UserStatus;
import homework.streamapi.task5.service.UserService;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class App {
    public static final Logger log = Logger.getLogger(App.class);

    public static void main(String[] args) {
        var userService = new UserService();
        var userList = initialize();
        userList.forEach(log::info);
        log.info("setting better statuses");
        userService.setBetterUserStatusForGuestsAndActiveUsers(userList);
        userList.forEach(log::info);
        userList = initialize();
        log.info("initializing again");
        log.info("sorting and deactivate non adult users");
        userService.increaseUserStatus(userList).forEach(log::info);
    }

    private static List<User> initialize() {
        var userList = new ArrayList<User>();
        userList.add(
                new User(2L,
                        "username2", "Nikita", "Kozlov", 17, "222@gmail.com", "222",
                        UserStatus.USER,
                        true));
        userList.add(
                new User(1L,
                        "username1", "Artsiom", "Ivanov", 18, "111@gmail.com", "111",
                        UserStatus.GUEST,
                        false));
        userList.add(new User(6L, "username6", "Inessa", "Ivanova", 19, "666@gmail.com", "666",
                UserStatus.VIP,
                false));
        userList.add(
                new User(3L, "username3", "Anna", "Bykovskaya", 22, "333@gmail.com", "333",
                        UserStatus.VIP,
                        true));
        userList.add(
                new User(4L, "username4", "Eugenia", "Petrova", 15, "444@gmail.com", "444",
                        UserStatus.USER,
                        false));
        userList.add(
                new User(5L, "username5", "Alexandr", "Grib", 31, "555@gmail.com", "555",
                        UserStatus.VIP,
                        true));
        return userList;
    }
}
