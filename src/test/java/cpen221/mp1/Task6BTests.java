package cpen221.mp1;

import cpen221.mp1.cryptanalysis.ComplexNumber;
import cpen221.mp1.cryptanalysis.DFT;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6BTests {

    public static void assertComplexArrayEquals(ComplexNumber[] cna1, ComplexNumber[] cna2, double delta) {
        assertEquals(cna1.length, cna2.length);
        for (int idx = 0; idx < cna1.length; idx++) {
            assertEquals(cna1[idx].re(), cna2[idx].re(), delta);
            assertEquals(cna1[idx].im(), cna2[idx].im(), delta);
        }
    }

    @ParameterizedTest
    @MethodSource("basicDFTTestProvider")
    @Timeout(10)
    public void testBasicDFT(ComplexNumber[] signal, ComplexNumber[] expDFT, double delta) {
        ComplexNumber[] output = DFT.dft(signal);
        assertComplexArrayEquals(expDFT, output, delta);
    }

    private static Stream<Arguments> basicDFTTestProvider() {
        return Stream.of(
                Arguments.of(
                        new ComplexNumber[0],
                        new ComplexNumber[0],
                        0.05
                ),
                Arguments.of(
                        new ComplexNumber[] {
                                new ComplexNumber(5, 5)
                        },
                        new ComplexNumber[] {
                                new ComplexNumber(5, 5)
                        },
                        0.05
                ),
                Arguments.of(
                        new ComplexNumber[] {
                                new ComplexNumber(1, 1),
                                new ComplexNumber(2, -2),
                                new ComplexNumber(3, 3)
                        },
                        new ComplexNumber[] {
                                new ComplexNumber(6, 2),
                                new ComplexNumber(-5.83, 1.36),
                                new ComplexNumber(2.83, -0.36)
                        },
                        0.05
                )
        );
    }

    @ParameterizedTest
    @MethodSource("intDFTTestProvider")
    @Timeout(10)
    public void testIntDFT(int[] signal, ComplexNumber[] expDFT, double delta) {
        ComplexNumber[] output = DFT.dft(signal);
        assertComplexArrayEquals(expDFT, output, delta);
    }

    private static Stream<Arguments> intDFTTestProvider() {
        return Stream.of(
                Arguments.of(
                        new int[] {
                                3, 4, 3, 5, 3, 6
                        },
                        new ComplexNumber[] {
                                new ComplexNumber(24, 0),
                                new ComplexNumber(0, 1.73),
                                new ComplexNumber(0, 1.73),
                                new ComplexNumber(-5.99, 0),
                                new ComplexNumber(0, -1.73),
                                new ComplexNumber(0, -1.73)
                        },
                        0.05
                )
        );
    }

}
