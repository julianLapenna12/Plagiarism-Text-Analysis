package cpen221.mp1;

import cpen221.mp1.cryptanalysis.ComplexNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6ATests {

    @ParameterizedTest
    @MethodSource("complexNumberBasicTestProvider")
    @Timeout(2)
    public void testComplexNumbersBasic(ComplexNumber c, double re, double im) {
        assertEquals(re, c.re());
        assertEquals(im, c.im());
    }

    private static Stream<Arguments> complexNumberBasicTestProvider() {
        return Stream.of(
                Arguments.of(new ComplexNumber(4, 6), 4, 6),
                Arguments.of(new ComplexNumber(0, 1), 0, 1),
                Arguments.of(new ComplexNumber(-1.5, 0), -1.5, 0),
                Arguments.of(new ComplexNumber(), 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("complexNumberAddTestProvider")
    @Timeout(2)
    public void testComplexNumberAdd(ComplexNumber c1, ComplexNumber c2, ComplexNumber sum) {
        c1.add(c2);
        assertEquals(sum, c1);
    }

    private static Stream<Arguments> complexNumberAddTestProvider() {
        return Stream.of(
                Arguments.of(
                        new ComplexNumber(4, 6),
                        new ComplexNumber(2, -3.5),
                        new ComplexNumber(6, 2.5)
                ),
                Arguments.of(
                        new ComplexNumber(),
                        new ComplexNumber(-10, -10),
                        new ComplexNumber(-10, -10)
                ),
                Arguments.of(
                        new ComplexNumber(),
                        new ComplexNumber(0, 0),
                        new ComplexNumber()
                )
        );
    }

    @ParameterizedTest
    @MethodSource("complexNumberProductTestProvider")
    @Timeout(2)
    public void testComplexNumberProduct(ComplexNumber c1, ComplexNumber c2, ComplexNumber product) {
        c1.multiply(c2);
        assertEquals(product, c1);
    }

    private static Stream<Arguments> complexNumberProductTestProvider() {
        return Stream.of(
                Arguments.of(
                        new ComplexNumber(4, 6),
                        new ComplexNumber(2, 3),
                        new ComplexNumber(-10, 24)
                ),
                Arguments.of(
                        new ComplexNumber(),
                        new ComplexNumber(-10, -10),
                        new ComplexNumber(0, 0)
                ),
                Arguments.of(
                        new ComplexNumber(),
                        new ComplexNumber(0, 0),
                        new ComplexNumber()
                )
        );
    }

    @Test
    public void testCopyConstructor() {
        ComplexNumber c1 = new ComplexNumber(10.5, -5.6);
        ComplexNumber c2 = new ComplexNumber(c1);
        assertEquals(c1, c2);
    }

    @Test
    public void testHashCode() {
        ComplexNumber c1 = new ComplexNumber(10.5, -5.6);
        ComplexNumber c2 = new ComplexNumber(10.5, -5.6);
        assertEquals(c1.hashCode(), c2.hashCode());
    }

}
