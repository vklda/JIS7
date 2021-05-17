package homework.task1;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class App {
    private static final Logger log = Logger.getLogger(App.class);

    public static void main(String[] args) {
        var randomNumbersList = getRandomNumbersList(50);
        log.info(getFilteredList(randomNumbersList));
    }

    private static List<Integer> getFilteredList(List<Integer> randomNumbersList) {
        return randomNumbersList.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
    }

    private static List<Integer> getRandomNumbersList(int amount) {
        var randomNumbersList = new ArrayList<Integer>();
        var random = new Random(System.currentTimeMillis());
        for (var i = 0; i < amount; i++) {
            randomNumbersList.add(random.nextInt(100) + 1);
        }
        return randomNumbersList;
    }
}
