package cpen221.mp1;

import cpen221.mp1.cryptanalysis.Untangler;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

public class Task6DTests {
    @ParameterizedTest
    @MethodSource("tangledTestProvider")
    @Timeout(10)
    public void testUntangler(String signal, String src1, String src2, boolean answer) {
        assertEquals(answer, Untangler.areTangled(signal, src1, src2));
    }

    private static Stream<Arguments> tangledTestProvider() {
        return Stream.of(
                Arguments.of(
                        "111000",
                        "111", "000",
                        true
                ),
                Arguments.of(
                        "ABABAB",
                        "AAA", "BBB",
                        true
                ),
                Arguments.of(
                        "111011111110",
                        "110", "111",
                        true
                ),
                Arguments.of(
                        "1A101B1A11B01",
                        "1A0", "B1",
                        false
                ),
                Arguments.of(
                        "ABABXYABXAY",
                        "X", "Y",
                        false
                ),
                Arguments.of(
                        "BAABBBABBABBBAABBABBBABABBBABBBAABBBABBABBBABBAABBABBBBAABBABBBB",
                        "ABB", "BAB", true
                ),
                Arguments.of(
                        "BAABBBABBABBBAABBABBBABABBBABBBAABBBABBABBBABBAABBABBBBAABBABBBB",
                        "ABBA", "BABA", false
                ),
                Arguments.of(
                        "BABABBCABBCABACBBBABABCACBBBABACBCBBAABBACBACBBACABBBBAACABBBCACABBBBAACABBBACBBCAABCBBABCBAABBCBBBABCBABABCCBBABBACAABBBACACBBB",
                        "ABBAC", "BABCB", true
                ),
                Arguments.of(
                        "BABABBCABBCABACBBBABABCACBBBABACBCBBAABBACBACBBACABBBBAACABBBCACABBBBAACABBBACBBCAABCBBABCBAABBCBBBABCBABABCCBBABBACAABBBACACBBB",
                        "ABBAC", "BABCBA", false
                )
        );
    }
}
