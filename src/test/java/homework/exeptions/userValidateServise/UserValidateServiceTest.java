package homework.exeptions.userValidateServise;

import homework.exeptions.userValidateServise.exceptions.UserValidationException;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class UserValidateServiceTest {
    private static final Logger logger = Logger.getLogger(UserValidateServiceTest.class);
    User user;
    UserValidateService userValidateService;

    @BeforeEach
    public void setup() {
        userValidateService = new UserValidateService();
        user = new User("Vladzimir","Ivanov",15);
    }

    @Test
    public void validate() {
        try{

            user.setFirstName("11111111111111111111111111111111111111111111111");
            user.setSecondName("11111111111111111111111111111111111111111111111");
            user.setAge(130);
            userValidateService.validate(user);
        }catch (UserValidationException e){
            logger.info(e.getMessage());
        }

    }
}