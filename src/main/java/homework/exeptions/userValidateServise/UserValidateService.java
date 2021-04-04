package homework.exeptions.userValidateServise;


import homework.exeptions.userValidateServise.exceptions.UserValidationException;
import org.apache.log4j.Logger;

public class UserValidateService {
    private static final Logger logger = Logger.getLogger(UserValidateService.class);

    public UserValidateService() {
    }

    public void validate(User user) throws UserValidationException {
        boolean resultFirstNameValidation = validateFirstNameLength(user);
        boolean resultSecondNameValidation = validateSecondNameLength(user);
        boolean resultAgeValidation = validateAge(user);
        if (resultFirstNameValidation && resultSecondNameValidation && resultAgeValidation) {
            logger.info("Валидация прошла успешно");
        } else if (!(resultFirstNameValidation)) {
            throw new UserValidationException("Length of First Name should be >=3 and <=15");
        } else if (!(resultSecondNameValidation)) {
            throw new UserValidationException("Length of Second Name should be >=3 and <=15");
        } else if (!(resultAgeValidation)) {
            throw new UserValidationException("Age should be >0 and <=120");
        }
    }

    private boolean validateFirstNameLength(User user) {
        boolean result;
        int length = user.getFirstName().length();
        if (length >= 3 && length <= 15) {
            result = true;
        } else result = false;
        return result;
    }

    private boolean validateSecondNameLength(User user) {
        boolean result;
        int length = user.getSecondName().length();
        if (length >= 3 && length <= 15) {
            result = true;
        } else result = false;
        return result;
    }

    private boolean validateAge(User user) {
        boolean result;
        int age = user.getAge();
        if (age > 0 && age <= 120) {
            result = true;
        } else result = false;
        return result;
    }
}
