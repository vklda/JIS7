package homework.exeptions.userValidateServise;

public class UserValidateService {

    public void validate(User user) {
    }

    private boolean validateFirstNameLength(User user) {
        boolean result;
        if (user.getFirstName().length() < 3 && user.getFirstName().length() > 15) {
            return result = true;
        } else result = false;
        return result;
    }

    private boolean validateSecondNameLength(User user) {
        boolean result;
        if (user.getSecondName().length() < 3 && user.getSecondName().length() > 15) {
            return result = true;
        } else result = false;
        return result;
    }

    private boolean validateAge(User user) {
        boolean result;
        if (user.getAge() > 0 && user.getAge() <= 120) {
            return result = true;
        } else result = false;
        return result;
    }
}
