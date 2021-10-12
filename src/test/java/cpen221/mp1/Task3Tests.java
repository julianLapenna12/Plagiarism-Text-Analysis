package cpen221.mp1;

import cpen221.mp1.exceptions.NoSuitableSentenceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Task3Tests {

    private static Document testDocument1;

    @BeforeAll
    public static void setupTests() throws MalformedURLException {
        testDocument1 = new Document("SentimentTest", "resources/PositiveNegativeSentence.txt");
    }

    @Test
    public void testSentimentPositive() {
        try {
            Assertions.assertEquals(testDocument1.getMostPositiveSentence(), "i love coding so much, my favorite programming language is java because it is the best");
        } catch (NoSuitableSentenceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSentimentNegative() {
        try {
            Assertions.assertEquals(testDocument1.getMostNegativeSentence(), "i hate coding, its the absolute worst");
        } catch (NoSuitableSentenceException e) {
            e.printStackTrace();
            System.out.println("No suitable sentence");
        }
    }

    @Test
    public void testSentimentPositiveException() {
        Assertions.assertThrows(NoSuitableSentenceException.class, ()->{
            new Document("Test String", "resources/NeutralStatement.txt").getMostPositiveSentence();
        } );
    }


    @Test
    public void testSentimentNegativeException() {
        Assertions.assertThrows(NoSuitableSentenceException.class, ()->{
            new Document("Test String", "resources/NeutralStatement.txt").getMostNegativeSentence();
        } );

    }
}
