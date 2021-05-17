package homework.streamapi.task2;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    private static final Logger log = Logger.getLogger(App.class);

    public static void main(String[] args) {
        var stringList = getStringList();
        log.info(filterByString("hello", stringList));
    }

    private static List<String> filterByString(String string, List<String> list) {
        return list.stream()
                .filter(it -> it.toLowerCase().startsWith(string) || it.toLowerCase().endsWith(string))
                .collect(Collectors.toList());
    }

    private static List<String> getStringList() {
        var list = new ArrayList<String>();
        list.add("Hello World");
        list.add("Java");
        list.add("StreamApi");
        list.add("Access_Denied");
        list.add("This is my first program in Java. World Hello");
        return list;
    }
}
