package cpen221.mp1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Timeout(20)
public class Task1ATests {

    @ParameterizedTest
    @MethodSource("avgSentenceLengthProvider")
    public void testAvgSentenceLength(String fileName, String id, double asl, double delta) {
        Document document = new Document(id, fileName);
        assertEquals(asl, document.averageSentenceLength(), delta);
    }

    private static Stream<Arguments> avgSentenceLengthProvider() {
        return Stream.of(
                Arguments.of("resources/Gettysburg.txt", "Gettysburg Address", 26.6, 0.1),
                Arguments.of("resources/Kennedy.txt", "Kennedy on the Cuban Missile Crisis", 29.71, 0.1)
        );
    }

    @ParameterizedTest
    @MethodSource("sentenceComplexityProvider")
    public void testSentenceComplexity(String fileName, String id, double ac, double delta) {
        Document document = new Document(id, fileName);
        assertEquals(ac, document.averageSentenceComplexity(), delta);
    }

    private static Stream<Arguments> sentenceComplexityProvider() {
        return Stream.of(
                Arguments.of("resources/Gettysburg.txt", "Gettysburg Address", 2.10, 0.1),
                Arguments.of("resources/Kennedy.txt", "Kennedy on the Cuban Missile Crisis", 2.74, 0.1)
        );
    }

    @Test
    public void testEmptyDocument() {
        Document empty = new Document("Empty Document", "resources/Empty.txt");
        assertEquals(0, empty.averageSentenceLength());
        assertEquals(1, empty.averageSentenceComplexity());
    }

}
