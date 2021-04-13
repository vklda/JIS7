package homework.classesAndObjects.encoder;

import homework.exeptions.userValidateServise.UserValidateService;
import org.apache.log4j.Logger;

public class Encoder {
    private static final Logger logger = Logger.getLogger(Encoder.class);

    public static void encode(final short code) {
        logger.info((char) code);
    }

    public static void encode(final char symbol) {
        logger.info((int)symbol);
    }
}
