package homework.collections.uniquewordvocabulary;

import java.util.HashSet;
import java.util.Set;

public class UniqueWordVocabulary {
    private static final Set<String> vocabulary = new HashSet<>();

    void addWord(String word) {
        if (validateDuplicateOrEmptyWord(word)) {
            return;
        }
        vocabulary.add(word);
    }


    int getWordsCount() {
        return vocabulary.size();
    }

    void printVocabulary() {
        System.out.println(vocabulary);
    }

    private boolean validateDuplicateOrEmptyWord(String word) {
        return word.equals("") || word.equals(null) || vocabulary.contains(word);
    }
}
