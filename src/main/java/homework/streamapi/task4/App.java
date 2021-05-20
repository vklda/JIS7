package homework.streamapi.task4;

import homework.streamapi.task4.service.Service;
import org.apache.log4j.Logger;

public class App {
    public static final Logger log = Logger.getLogger(App.class);

    public static void main(String[] args) {
        var service = new Service();
        log.info(service.findBestMatchingPerson("English"));

        log.info(service.findBestMatchingPerson("Kannada"));
    }
}
