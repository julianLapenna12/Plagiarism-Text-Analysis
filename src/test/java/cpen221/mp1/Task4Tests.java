package cpen221.mp1;

import cpen221.mp1.exceptions.NoSuitableSentenceException;
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
        Assertions.assertEquals(60.68995286, docSimTest.documentDivergence(testDoc1,testDoc2),0.05);
    }

    @Test
    public void testDivergence13() {
        Assertions.assertEquals(49.75416181, docSimTest.documentDivergence(testDoc1,testDoc3),0.05);
    }

    @Test
    public void testDivergence14() {
        Assertions.assertEquals(50.99783841, docSimTest.documentDivergence(testDoc1,testDoc4),0.05);
    }

    @Test
    public void testDivergence15() {
        Assertions.assertEquals(47.57688591, docSimTest.documentDivergence(testDoc1,testDoc5),0.05);
    }

    @Test
    public void testDivergence16() {
        Assertions.assertEquals(46.47232498, docSimTest.documentDivergence(testDoc1,testDoc6),0.05);
    }

    @Test
    public void testDivergence23() {
        Assertions.assertEquals(54.05216097, docSimTest.documentDivergence(testDoc2,testDoc3),0.05);
    }

    @Test
    public void testDivergence24() {
        Assertions.assertEquals(50.45192672, docSimTest.documentDivergence(testDoc2,testDoc4),0.05);
    }

    @Test
    public void testDivergence25() {
        Assertions.assertEquals(59.41476828, docSimTest.documentDivergence(testDoc2,testDoc5),0.05);
    }

    @Test
    public void testDivergence26() {
        Assertions.assertEquals(60.85068688, docSimTest.documentDivergence(testDoc2,testDoc6),0.05);
    }

    @Test
    public void testDivergence34() {
        Assertions.assertEquals(62.0566864, docSimTest.documentDivergence(testDoc3,testDoc4),0.05);
    }

    @Test
    public void testDivergence35() {
        Assertions.assertEquals(52.0106789, docSimTest.documentDivergence(testDoc3,testDoc5),0.05);
    }

    @Test
    public void testDivergence36() {
        Assertions.assertEquals(49.52928367, docSimTest.documentDivergence(testDoc3,testDoc6),0.05);
    }

    @Test
    public void testDivergence45() {
        Assertions.assertEquals(50.09802033, docSimTest.documentDivergence(testDoc4,testDoc5),0.05);
    }

    @Test
    public void testDivergence46() {
        Assertions.assertEquals(57.75086168, docSimTest.documentDivergence(testDoc4,testDoc6),0.05);
    }

    @Test
    public void testDivergence56() {
        Assertions.assertEquals(52.19144172, docSimTest.documentDivergence(testDoc5,testDoc6),0.05);
    }
}
