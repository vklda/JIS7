package homework.collections.uniquewordcounter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UniqueWordCounter {
    private static final Map<String, Integer> vocabulary = new HashMap<>();
    private static final int ONE = 1;


    void addWord(String word) {
        if (isDuplicatedWord(word)) {
            String key = word;
            Integer value = vocabulary.get(key) + 1;
            vocabulary.put(key, value);
            return;
        }
        vocabulary.put(word, ONE);
    }

    String getMostFrequentWord() {
        String mostFrequentWord = null;
        Integer mostFrequency = 0;
        for (Map.Entry<String, Integer> entry : vocabulary.entrySet()) {
            if (mostFrequency < entry.getValue()) {
                mostFrequency = entry.getValue();
                mostFrequentWord = entry.getKey();
            }
        }
        return mostFrequentWord;
    }

    void printWordsFrequency() {
        for (Map.Entry<String, Integer> entry : vocabulary.entrySet()) {
            System.out.println(entry.getKey() + " added " + entry.getValue() + " time(s)");
        }
    }

    private boolean isDuplicatedWord(String word) {
        return vocabulary.containsKey(word);
    }
}
