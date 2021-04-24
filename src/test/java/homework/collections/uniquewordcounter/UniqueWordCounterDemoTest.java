package homework.collections.uniquewordcounter;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UniqueWordCounterDemoTest {
    private static final Logger logger = Logger.getLogger(UniqueWordCounterDemoTest.class);

    UniqueWordCounter uniqueWordCounter;

    @Before
    public void setup() {
        uniqueWordCounter = new UniqueWordCounter();
        uniqueWordCounter.addWord("one");
        uniqueWordCounter.addWord("two");
        uniqueWordCounter.addWord("three");
    }

    @Test
    public void addingWords() {
        uniqueWordCounter.addWord("four");
        uniqueWordCounter.printWordsFrequency();
    }

    @Test
    public void addingDuplicateWords() {
        uniqueWordCounter.addWord("two");
        uniqueWordCounter.addWord("three");
        uniqueWordCounter.addWord("three");
        uniqueWordCounter.printWordsFrequency();
    }

    @Test
    public void takingMostFrequentWords() {
        uniqueWordCounter.addWord("two");
        uniqueWordCounter.addWord("three");
        uniqueWordCounter.addWord("three");
        logger.info(uniqueWordCounter.getMostFrequentWord());
        Assert.assertEquals("three", uniqueWordCounter.getMostFrequentWord());
    }

}