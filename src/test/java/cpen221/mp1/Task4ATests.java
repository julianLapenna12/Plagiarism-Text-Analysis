package cpen221.mp1;

import cpen221.mp1.similarity.DocumentSimilarity;
import cpen221.mp1.similarity.GroupingDocuments;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class Task4ATests {
    private static Document malala, kennedy, lincoln, emmaWatson, empty;

    private static final int FLOW_CONTROL = 1 * 1000;

    @BeforeAll
    private static void createDocuments() throws InterruptedException {
        try {
            malala = new Document("Empty", "resources/Malala.txt");
        }
        catch (Exception e) { }
        try {
            kennedy = new Document("Kennedy", "resources/Kennedy.txt");
        }
        catch (Exception e) { }
        try {
            lincoln = new Document("Lincoln", "resources/Gettysburg.txt");
        }
        catch (Exception e) { }
        try {
            emmaWatson = new Document("Emma Watson", "resources/EmmaWatson.txt");
        }
        catch (Exception e) { }
        try {
            empty = new Document("Empty", "resources/Empty.txt");
        }
        catch (Exception e) { }
    }

    @ParameterizedTest
    @MethodSource("divergenceTestProvider")
    @Timeout(30)
    public void testDivergence(Document doc1, Document doc2, double expDivergence, double delta) {
        assertEquals(
                expDivergence,
                (new DocumentSimilarity()).documentDivergence(doc1, doc2),
                delta
        );
    }

    private static Stream<Arguments> divergenceTestProvider() {
        return Stream.of(
                Arguments.of(
                        malala,
                        kennedy,
                        46.97,
                        0.50),

                Arguments.of(
                        malala,
                        emmaWatson,
                        23.37,
                        0.50
                ),

                Arguments.of(
                        emmaWatson,
                        malala,
                        23.37,
                        0.50
                ),

                Arguments.of(
                        malala,
                        malala,
                        0.00,
                        0.005
                ),

                Arguments.of(
                        lincoln,
                        malala,
                        48.57,
                        0.40
                ),

                Arguments.of(
                        kennedy,
                        empty,
                        99.94,
                        0.50
                ),

                Arguments.of(
                        empty,
                        empty,
                        0.00,
                        0.05
                )
        );
    }

}
