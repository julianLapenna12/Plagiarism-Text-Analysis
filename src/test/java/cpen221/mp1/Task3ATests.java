package cpen221.mp1;

import cpen221.mp1.exceptions.NoSuitableSentenceException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class Task3ATests {

    private final int FLOW_CONTROL = 10 * 1000; // 24 seconds

    @ParameterizedTest
    @MethodSource("sentimentTestProvider")
    public void testSentimentAnalysis(String fileName, String id, String positiveSentence, String negativeSentence) throws InterruptedException {
        Thread.sleep(FLOW_CONTROL);
        Document document = new Document(id, fileName);
        try {
            assertEquals(positiveSentence, document.getMostPositiveSentence().replaceAll("\\s*\\p{Punct}+\\s*$", ""));
            assertEquals(negativeSentence, document.getMostNegativeSentence().replaceAll("\\s*\\p{Punct}+\\s*$", ""));
        }
        catch (NoSuitableSentenceException nse) {
            fail(); // we should not have an exception
        }
    }

    private static Stream<Arguments> sentimentTestProvider() {
        return Stream.of(
                Arguments.of("resources/Gettysburg.txt",
                        "Gettysburg Address",
                        "It is altogether fitting and proper that we should do this",
                        "But in a larger sense, we cannot dedicate, we cannot consecrate, we cannot hallow this ground"),

                Arguments.of("resources/EmmaWatson.txt",
                        "Emma Watson at the UN",
                        "Thank you very, very much",
                        "Sadly, many of the things that she wanted to change are still true today"),

                Arguments.of("resources/Malala.txt",
                        "Malala Yousafzai at the UN",
                        "We will continue our journey to our destination of peace and education for everyone",
                        "They think that God is a tiny, little conservative being who would send girls to the hell just because of going to school"),

                Arguments.of("resources/Kennedy.txt",
                        "Kennedy on the Cuban Missile Crisis",
                        "Thank you and good night",
                        "But this country has no wish to cause you to suffer or to impose any system upon you")
        );
    }

    public void testSentimentAnalysisNothingPositive() {
        Document document = new Document("Sad Text", "Sad.txt");
        try {
            document.getMostPositiveSentence();
            fail(); // should not reach this statement
        }
        catch (NoSuitableSentenceException nse) {
            // OK!
        }
        try {
            assertEquals("I have scars on my hand from touching certain people", document.getMostNegativeSentence().replaceAll("[\\p{Punct}$]", ""));
        }
        catch (NoSuitableSentenceException nse) {
            fail(); // no exception expected!
        }
    }

    public void testSentimentAnalysisNothingNegative() {
        Document document = new Document("Happy Text", "Happy.txt");
        try {
            document.getMostNegativeSentence();
            fail(); // should not reach this statement
        }
        catch (NoSuitableSentenceException nse) {
            // OK!
        }
        try {
            assertEquals("You are your best thing", document.getMostPositiveSentence().replaceAll("[\\p{Punct}$]", ""));
        }
        catch (NoSuitableSentenceException nse) {
            fail(); // no exception expected!
        }
    }

}
