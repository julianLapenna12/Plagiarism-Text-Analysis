package cpen221.mp1;

import cpen221.mp1.cryptanalysis.Cryptography;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6CTests {
    private static Document malala, lincoln;

    @BeforeAll
    private static void createDocuments() {
        malala = new Document("Malala", "resources/Malala.txt");
        lincoln = new Document("Lincoln", "resources/Gettysburg.txt");
    }

    @ParameterizedTest
    @MethodSource("basicEncryptionTestProvider")
    @Timeout(10)
    public void testBasicEncryption(Document document, int length, int period, int amplitude, int[] expectedText) {
        int[] codedText = Cryptography.encrypt(document, length, period, amplitude);
        assertArrayEquals(expectedText, codedText);
    }

    private static Stream<Arguments> basicEncryptionTestProvider() {
        return Stream.of(
                Arguments.of(
                        malala,
                        32,
                        8,
                        16,
                        new int[] {95, 127, 111, 97, 109, 28, 20, 105, 127, 48, 116, 115, 20, 81, 98, 31, 115, 127, 121, 111, 105, 98, 20, 101, 122, 130, 43, 109, 89, 16, 104, 110}
                ),
                Arguments.of(
                        lincoln,
                        32,
                        8,
                        16,
                        new int[] {81, 127, 128, 114, 103, 83, 99, 114, 112, 48, 108, 110, 88, 16, 103, 100, 129, 117, 121, 32, 109, 85, 85, 113, 126, 48, 108, 103, 99, 16, 99, 116}
                )
        );
    }

    @Test
    public void testDecryption() {
        int numSentences = malala.numSentences();
        StringBuilder sb = new StringBuilder();
        for (int idx = 1; idx <= numSentences; idx++) {
            sb.append(malala.getSentence(idx));
            sb.append(" ");
        }
        String text = sb.substring(0, 8000);
        int[] codedText = Cryptography.encrypt(malala, 8000, 32, 256);
        String clearText = Cryptography.decrypt(codedText);
        assertEquals(text, clearText);

        while (sb.length() < 10000) {
            sb.append(" ");
        }
        text = sb.toString();
        codedText = Cryptography.encrypt(malala, 10000, 40, 64);
        clearText = Cryptography.decrypt(codedText);
        assertEquals(text, clearText);
    }

}
