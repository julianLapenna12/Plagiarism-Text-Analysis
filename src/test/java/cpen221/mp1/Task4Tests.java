package cpen221.mp1;

import cpen221.mp1.exceptions.NoSuitableSentenceException;
import cpen221.mp1.sentiments.SentenceAnalysis;
import cpen221.mp1.sentiments.SentimentAnalysis;
import cpen221.mp1.similarity.DocumentSimilarity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Task4Tests {

    private static Document testDoc1;
    private static Document testDoc2;
    private static Document testDoc3;
    private static Document testDoc4;
    private static Document testDoc5;
    private static Document testDoc6;

    private static DocumentSimilarity docSimTest;

    @BeforeAll
    public static void setupTests() throws MalformedURLException {
        testDoc1 = new Document("test1", "resources/test_doc1.txt");
        testDoc2 = new Document("test2", "resources/test_doc2.txt");
        testDoc3 = new Document("test3", "resources/test_doc3.txt");
        testDoc4 = new Document("test4", "resources/test_doc4.txt");
        testDoc5 = new Document("test5", "resources/test_doc5.txt");
        testDoc6 = new Document("test6", "resources/test_doc6.txt");

        docSimTest = new DocumentSimilarity();
    }

    @Test
    public void testDivergence12() {
        Assertions.assertEquals(60.68995, docSimTest.documentDivergence(testDoc1,testDoc2),0.05);
    }

    @Test
    public void testDivergence13() {

    }

    @Test
    public void testDivergence14() {

    }

    @Test
    public void testDivergence15() {

    }

    @Test
    public void testDivergence16() {

    }

    @Test
    public void testDivergence23() {

    }

    @Test
    public void testDivergence24() {

    }

    @Test
    public void testDivergence25() {

    }

    @Test
    public void testDivergence26() {

    }

    @Test
    public void testDivergence34() {

    }

    @Test
    public void testDivergence35() {

    }

    @Test
    public void testDivergence36() {

    }

    @Test
    public void testDivergence45() {

    }

    @Test
    public void testDivergence46() {

    }

    @Test
    public void testDivergence56() {

    }
}
