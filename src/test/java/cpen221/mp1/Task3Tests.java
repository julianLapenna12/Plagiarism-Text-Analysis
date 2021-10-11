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
            Assertions.assertEquals(testDocument1.getMostPositiveSentence(), "I love Coding so much. my favorite programming language is Java because it is the best.");
        } catch (NoSuitableSentenceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSentimentNegative() {
        try {
            Assertions.assertEquals(testDocument1.getMostNegativeSentence(), "I hate coding, its the absolute worst.");
        } catch (NoSuitableSentenceException e) {
            e.printStackTrace();
            System.out.println("No suitable sentence");
        }
    }

    @Test
    public void testSentimentPositiveException() {
        try {
            System.out.println(new Document("Test String", "resources/NeutralStatement.txt").getMostPositiveSentence());
        } catch (NoSuitableSentenceException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testSentimentNegativeException() {
        try {
            System.out.println(new Document("Test String", "resources/NeutralStatement.txt").getMostNegativeSentence());
        } catch (NoSuitableSentenceException e) {
            e.printStackTrace();
        }

    }
}
