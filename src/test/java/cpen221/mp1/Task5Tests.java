package cpen221.mp1;

import cpen221.mp1.exceptions.NoSuitableSentenceException;
import cpen221.mp1.sentiments.SentimentAnalysis;
import cpen221.mp1.similarity.DocumentSimilarity;
import cpen221.mp1.similarity.GroupingDocuments;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class Task5Tests {

    private static Document testDocument1;
    private static Document testDocument2;
    private static Document testDocument3;
    private static Document testDocument4;
    private static Document testDocument5;
    private static Document testDocument6;

    private static GroupingDocuments docSimTest;

    @BeforeAll
    public static void setupTests() throws MalformedURLException {
        testDocument1 = new Document("test1", "resources/test_doc1.txt");
        testDocument2 = new Document("test2", "resources/test_doc2.txt");
        testDocument3 = new Document("test3", "resources/test_doc3.txt");
        testDocument4 = new Document("test4", "resources/test_doc4.txt");
        testDocument5 = new Document("test5", "resources/test_doc5.txt");
        testDocument6 = new Document("test6", "resources/test_doc6.txt");

        GroupingDocuments docSimTest = new GroupingDocuments();
    }

    @Test
    public void testGroupingDocuments6Documents1Group (){
        Set<Document> testSet = new HashSet<Document>();

        Set<Set<Document>> realGroups = new HashSet<Set<Document>>();

        testSet.add(testDocument1);
        testSet.add(testDocument2);
        testSet.add(testDocument3);
        testSet.add(testDocument4);
        testSet.add(testDocument5);
        testSet.add(testDocument6);

        realGroups.add(testSet);

        Assertions.assertEquals(realGroups, docSimTest.groupBySimilarity(testSet, 1));
    }

    @Test
    public void testGroupingDocuments6Documents2Groups (){
        Set<Document> testSet = new HashSet<Document>();

        Set<Set<Document>> realGroups = new HashSet<Set<Document>>();
        Set<Document> group1 = new HashSet<Document>();
        Set<Document> group2 = new HashSet<Document>();

        testSet.add(testDocument1);
        testSet.add(testDocument2);
        testSet.add(testDocument3);
        testSet.add(testDocument4);
        testSet.add(testDocument5);
        testSet.add(testDocument6);


        group1.add(testDocument1);
        group1.add(testDocument3);
        group1.add(testDocument5);
        group1.add(testDocument6);
        group1.add(testDocument4);

        group2.add(testDocument2);

        realGroups.add(group1);
        realGroups.add(group2);

        Assertions.assertEquals(realGroups, docSimTest.groupBySimilarity(testSet, 2));
    }

    @Test
    public void testGroupingDocuments6Documents3Groups (){
        Set<Document> testSet = new HashSet<Document>();

        Set<Set<Document>> realGroups = new HashSet<Set<Document>>();
        Set<Document> group1 = new HashSet<Document>();
        Set<Document> group2 = new HashSet<Document>();
        Set<Document> group3 = new HashSet<Document>();

        testSet.add(testDocument1);
        testSet.add(testDocument2);
        testSet.add(testDocument3);
        testSet.add(testDocument4);
        testSet.add(testDocument5);
        testSet.add(testDocument6);


        group1.add(testDocument1);
        group1.add(testDocument3);
        group1.add(testDocument5);
        group1.add(testDocument6);

        group2.add(testDocument2);

        group3.add(testDocument4);

        realGroups.add(group1);
        realGroups.add(group2);
        realGroups.add(group3);

        Assertions.assertEquals(realGroups, docSimTest.groupBySimilarity(testSet, 3));
    }

    @Test
    public void testGroupingDocuments6Documents4Groups (){
        Set<Document> testSet = new HashSet<Document>();

        Set<Set<Document>> realGroups = new HashSet<Set<Document>>();
        Set<Document> group1 = new HashSet<Document>();
        Set<Document> group2 = new HashSet<Document>();
        Set<Document> group3 = new HashSet<Document>();
        Set<Document> group4 = new HashSet<Document>();

        testSet.add(testDocument1);
        testSet.add(testDocument2);
        testSet.add(testDocument3);
        testSet.add(testDocument4);
        testSet.add(testDocument5);
        testSet.add(testDocument6);


        group1.add(testDocument1);
        group1.add(testDocument5);
        group1.add(testDocument6);

        group2.add(testDocument2);

        group3.add(testDocument3);

        group4.add(testDocument4);

        realGroups.add(group1);
        realGroups.add(group2);
        realGroups.add(group3);
        realGroups.add(group4);

        Assertions.assertEquals(realGroups, docSimTest.groupBySimilarity(testSet, 4));
    }

    @Test
    public void testGroupingDocuments6Documents5Groups (){
        Set<Document> testSet = new HashSet<Document>();

        Set<Set<Document>> realGroups = new HashSet<Set<Document>>();
        Set<Document> group1 = new HashSet<Document>();
        Set<Document> group2 = new HashSet<Document>();
        Set<Document> group3 = new HashSet<Document>();
        Set<Document> group4 = new HashSet<Document>();
        Set<Document> group5 = new HashSet<Document>();

        testSet.add(testDocument1);
        testSet.add(testDocument2);
        testSet.add(testDocument3);
        testSet.add(testDocument4);
        testSet.add(testDocument5);
        testSet.add(testDocument6);


        group1.add(testDocument1);
        group1.add(testDocument6);

        group2.add(testDocument2);

        group3.add(testDocument3);

        group4.add(testDocument4);

        group5.add(testDocument5);

        realGroups.add(group1);
        realGroups.add(group2);
        realGroups.add(group3);
        realGroups.add(group4);
        realGroups.add(group5);

        Assertions.assertEquals(realGroups, docSimTest.groupBySimilarity(testSet, 5));
    }

    @Test
    public void testGroupingDocuments6Documents6Groups (){
        Set<Document> testSet = new HashSet<Document>();

        Set<Set<Document>> realGroups = new HashSet<Set<Document>>();
        Set<Document> group1 = new HashSet<Document>();
        Set<Document> group2 = new HashSet<Document>();
        Set<Document> group3 = new HashSet<Document>();
        Set<Document> group4 = new HashSet<Document>();
        Set<Document> group5 = new HashSet<Document>();
        Set<Document> group6 = new HashSet<Document>();

        testSet.add(testDocument1);
        testSet.add(testDocument2);
        testSet.add(testDocument3);
        testSet.add(testDocument4);
        testSet.add(testDocument5);
        testSet.add(testDocument6);


        group1.add(testDocument1);

        group2.add(testDocument2);

        group3.add(testDocument3);

        group4.add(testDocument4);

        group5.add(testDocument5);

        group6.add(testDocument6);

        realGroups.add(group1);
        realGroups.add(group2);
        realGroups.add(group3);
        realGroups.add(group4);
        realGroups.add(group5);
        realGroups.add(group6);

        Assertions.assertEquals(realGroups, docSimTest.groupBySimilarity(testSet, 6));
    }

    @Test
    public void testGroupingDocuments5Documents1Group () {
        Set<Document> testSet = new HashSet<Document>();

        Set<Set<Document>> realGroups = new HashSet<Set<Document>>();

        testSet.add(testDocument2);
        testSet.add(testDocument3);
        testSet.add(testDocument4);
        testSet.add(testDocument5);
        testSet.add(testDocument6);

        realGroups.add(testSet);

        Assertions.assertEquals(realGroups, docSimTest.groupBySimilarity(testSet, 1));
    }

    @Test
    public void testGroupingDocuments5Documents2Groups () {
        Set<Document> testSet = new HashSet<Document>();

        Set<Set<Document>> realGroups = new HashSet<Set<Document>>();
        Set<Document> group1 = new HashSet<Document>();
        Set<Document> group2 = new HashSet<Document>();

        testSet.add(testDocument2);
        testSet.add(testDocument3);
        testSet.add(testDocument4);
        testSet.add(testDocument5);
        testSet.add(testDocument6);

        group1.add(testDocument3);
        group1.add(testDocument6);

        group2.add(testDocument4);
        group2.add(testDocument5);
        group2.add(testDocument2);

        realGroups.add(group1);
        realGroups.add(group2);

        Assertions.assertEquals(realGroups, docSimTest.groupBySimilarity(testSet, 2));
    }

    @Test
    public void testGroupingDocuments5Documents3Groups () {
        Set<Document> testSet = new HashSet<Document>();

        Set<Set<Document>> realGroups = new HashSet<Set<Document>>();
        Set<Document> group1 = new HashSet<Document>();
        Set<Document> group2 = new HashSet<Document>();
        Set<Document> group3 = new HashSet<Document>();

        testSet.add(testDocument2);
        testSet.add(testDocument3);
        testSet.add(testDocument4);
        testSet.add(testDocument5);
        testSet.add(testDocument6);

        group1.add(testDocument3);
        group1.add(testDocument6);

        group2.add(testDocument4);
        group2.add(testDocument5);

        group3.add(testDocument2);

        realGroups.add(group1);
        realGroups.add(group2);
        realGroups.add(group3);

        Assertions.assertEquals(realGroups, docSimTest.groupBySimilarity(testSet, 3));
    }

    @Test
    public void testGroupingDocuments5Documents4Groups () {
        Set<Document> testSet = new HashSet<Document>();

        Set<Set<Document>> realGroups = new HashSet<Set<Document>>();
        Set<Document> group1 = new HashSet<Document>();
        Set<Document> group2 = new HashSet<Document>();
        Set<Document> group3 = new HashSet<Document>();
        Set<Document> group4 = new HashSet<Document>();

        testSet.add(testDocument2);
        testSet.add(testDocument3);
        testSet.add(testDocument4);
        testSet.add(testDocument5);
        testSet.add(testDocument6);

        group1.add(testDocument3);
        group1.add(testDocument6);

        group2.add(testDocument4);

        group3.add(testDocument5);

        group4.add(testDocument2);

        realGroups.add(group1);
        realGroups.add(group2);
        realGroups.add(group3);
        realGroups.add(group4);

        Assertions.assertEquals(realGroups, docSimTest.groupBySimilarity(testSet, 4));
    }

    @Test
    public void testGroupingDocuments5Documents5Groups () {
        Set<Document> testSet = new HashSet<Document>();

        Set<Set<Document>> realGroups = new HashSet<Set<Document>>();
        Set<Document> group1 = new HashSet<Document>();
        Set<Document> group2 = new HashSet<Document>();
        Set<Document> group3 = new HashSet<Document>();
        Set<Document> group4 = new HashSet<Document>();
        Set<Document> group5 = new HashSet<Document>();

        testSet.add(testDocument2);
        testSet.add(testDocument3);
        testSet.add(testDocument4);
        testSet.add(testDocument5);
        testSet.add(testDocument6);

        group1.add(testDocument3);

        group2.add(testDocument6);

        group3.add(testDocument4);

        group4.add(testDocument5);

        group5.add(testDocument2);

        realGroups.add(group1);
        realGroups.add(group2);
        realGroups.add(group3);
        realGroups.add(group4);
        realGroups.add(group5);

        Assertions.assertEquals(realGroups, docSimTest.groupBySimilarity(testSet, 5));
    }

    @Test
    public void testGroupingDocuments2Documents2Groups () {
        Set<Document> testSet = new HashSet<Document>();

        Set<Set<Document>> realGroups = new HashSet<Set<Document>>();
        Set<Document> group1 = new HashSet<Document>();
        Set<Document> group2 = new HashSet<Document>();

        testSet.add(testDocument2);
        testSet.add(testDocument3);

        group1.add(testDocument3);

        group2.add(testDocument2);

        realGroups.add(group1);
        realGroups.add(group2);

        Assertions.assertEquals(realGroups, docSimTest.groupBySimilarity(testSet, 2));
    }

    @Test
    public void testGroupingDocuments1Document1Groups () {
        Set<Document> testSet = new HashSet<Document>();

        Set<Set<Document>> realGroups = new HashSet<Set<Document>>();
        Set<Document> group1 = new HashSet<Document>();

        testSet.add(testDocument2);

        group1.add(testDocument2);

        realGroups.add(group1);

        Assertions.assertEquals(realGroups, docSimTest.groupBySimilarity(testSet, 1));
    }

    @Test
    public void testGroupingDocuments0Document1Groups () {
        Set<Document> testSet = new HashSet<Document>();

        Set<Set<Document>> realGroups = new HashSet<Set<Document>>();

        Assertions.assertEquals(realGroups, docSimTest.groupBySimilarity(testSet, 1));
    }
}