package cpen221.mp1;

import cpen221.mp1.exceptions.NoSuitableSentenceException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Task3Tests {

    private static Document testDocument1;

    @BeforeAll
    public static void setupTests() throws MalformedURLException {
        testDocument1 = new Document("The Ant and The Cricket", "resources/antcrick.txt");
    }

    @Test
    public void testSentimentPositive() {
        try {
            System.out.println(testDocument1.getMostPositiveSentence());
        } catch (NoSuitableSentenceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSentimentNegative() {
        try {
            System.out.println(testDocument1.getMostNegativeSentence());
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
    @Test
    public void test2(){
        String[] test = {"A", "b"};
        String a = test[0];
        a = a.toLowerCase();
        System.out.println(test[0]);
    }

}
