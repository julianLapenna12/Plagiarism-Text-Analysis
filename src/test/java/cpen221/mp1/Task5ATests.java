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

public class Task5ATests {
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
    @MethodSource("groupingTestProvider")
    @Timeout(30)
    public void testGrouping(Set<Document> documentSet, int numGroups, Set<Set<Document>> expectedGroups) {
        assertEquals(
                expectedGroups,
                GroupingDocuments.groupBySimilarity(documentSet, numGroups)
        );
    }

    private static Stream<Arguments> groupingTestProvider() {
        return Stream.of(
                Arguments.of(
                        Set.of(emmaWatson, malala),
                        2,
                        Set.of(Set.of(malala), Set.of(emmaWatson))
                ),

                Arguments.of(
                        Set.of(emmaWatson, malala),
                        1,
                        Set.of(Set.of(malala, emmaWatson))
                ),

                Arguments.of(
                        Set.of(emmaWatson, malala, empty),
                        2,
                        Set.of(Set.of(malala, emmaWatson), Set.of(empty))
                ),

                Arguments.of(
                        Set.of(emmaWatson, malala, empty, lincoln, kennedy),
                        5,
                        Set.of(Set.of(malala), Set.of(kennedy), Set.of(emmaWatson), Set.of(lincoln), Set.of(empty))
                ),

                Arguments.of(
                        Set.of(emmaWatson, malala, empty, lincoln, kennedy),
                        3,
                        Set.of(Set.of(malala, emmaWatson), Set.of(kennedy, lincoln), Set.of(empty))
                ),

                Arguments.of(
                        Set.of(emmaWatson, malala, empty, lincoln, kennedy),
                        4,
                        Set.of(Set.of(malala, emmaWatson), Set.of(kennedy), Set.of(lincoln), Set.of(empty))
                )

        );
    }

}
