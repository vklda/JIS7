package homework.classesAndObjects.encoder;

import org.apache.log4j.Logger;

public class EncoderDemo {
    private static final Logger logger = Logger.getLogger(EncoderDemo.class);

    public static void main(String[] args) {
        String string = "Java!";
        int[] mas = new int[string.length()];
        logger.info("Encoding string /*" + string + "*/ to ASCII:");
        for (int i = 0; i < string.length(); i++) {
            int k = string.charAt(i);
            Encoder.encode((char) k);
            mas[i] = (char) k;
        }
        logger.info("Encoding ASCII values of string /*" + string + "*/ to chars");
        for (int i = 0; i < mas.length; i++) {
            Encoder.encode((short) mas[i]);
        }
    }
}
