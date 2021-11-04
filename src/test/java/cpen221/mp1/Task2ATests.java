package cpen221.mp1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Timeout(20)
public class Task2ATests {

    @ParameterizedTest
    @MethodSource("avgWordLengthProvider")
    public void testAvgWordLength(String fileName, String id, double awl, double delta) {
        Document document = new Document(id, fileName);
        assertEquals(awl, document.averageWordLength(), delta);
    }

    private static Stream<Arguments> avgWordLengthProvider() {
        return Stream.of(
                Arguments.of("resources/Gettysburg.txt", "Gettysburg Address", 4.32, 0.15),
                Arguments.of("resources/Kennedy.txt", "Kennedy on the Cuban Missile Crisis", 4.81, 0.15)
        );
    }

    @ParameterizedTest
    @MethodSource("uniqueWordRatioProvider")
    public void testUniqueWordRatio(String fileName, String id, double uwr, double delta) {
        Document document = new Document(id, fileName);
        assertEquals(uwr, document.uniqueWordRatio(), delta);
    }

    private static Stream<Arguments> uniqueWordRatioProvider() {
        return Stream.of(
                Arguments.of("resources/Gettysburg.txt", "Gettysburg Address", 0.515, 0.15),
                Arguments.of("resources/Kennedy.txt", "Kennedy on the Cuban Missile Crisis", 0.328, 0.15)
        );
    }

    @ParameterizedTest
    @MethodSource("hlRProvider")
    public void testHLR(String fileName, String id, double hlr, double delta) {
        Document document = new Document(id, fileName);
        assertEquals(hlr, document.hapaxLegomanaRatio(), delta);
    }

    private static Stream<Arguments> hlRProvider() {
        return Stream.of(
                Arguments.of("resources/Gettysburg.txt", "Gettysburg Address", 0.334, 0.15),
                Arguments.of("resources/Kennedy.txt", "Kennedy on the Cuban Missile Crisis", 0.210, 0.10)
        );
    }

    @Test
    public void testEmptyDocument() {
        Document empty = new Document("Empty Document", "resources/Empty.txt");
        assertEquals(0, empty.averageWordLength());
        assertEquals(0, empty.hapaxLegomanaRatio());
        assertEquals(0, empty.uniqueWordRatio());
    }

}
