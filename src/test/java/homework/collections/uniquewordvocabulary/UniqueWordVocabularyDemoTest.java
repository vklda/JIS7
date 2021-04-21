package homework.collections.uniquewordvocabulary;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UniqueWordVocabularyDemoTest {
    UniqueWordVocabulary vocabulary;

    @Before
    public void setup() {
    vocabulary = new UniqueWordVocabulary();
    vocabulary.addWord("one");
    vocabulary.addWord("three");
    vocabulary.addWord("four");
    }

    @Test
    public void addingWordsToVocabulary() {
        vocabulary.addWord("word");
        vocabulary.addWord("two");
        Assert.assertEquals(5,vocabulary.getWordsCount());
    }

    @Test
    public  void addingWrongWords() {
        vocabulary.addWord("one");
        System.out.println(vocabulary.getWordsCount());
    }
    @Test
    public void printVocabulary() {
        vocabulary.printVocabulary();
    }

}