package cpen221.mp1;

import cpen221.mp1.cryptanalysis.ComplexNumber;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static cpen221.mp1.cryptanalysis.DFT.dft;
import static cpen221.mp1.cryptanalysis.Cryptography.decrypt;
import static cpen221.mp1.cryptanalysis.Cryptography.encrypt;
import static cpen221.mp1.cryptanalysis.Untangler.areTangled;

public class UntanglerTest {

    @Test
    public void testUntangler(){
        String seq1 = "hi!";
        String seq2 = "bye!";
        Assertions.assertTrue(areTangled("hi!bye!hi!", seq1, seq2));
        Assertions.assertFalse(areTangled("hi!bye!hi!a", seq1, seq2));
    }

    @Test
    public void exampleTest(){
        String seq1 = "110";
        String seq2 = "111";
        Assertions.assertTrue(areTangled("111011111110", seq1, seq2));
        Assertions.assertFalse(areTangled("11101111111z0", seq1, seq2));
    }

    @Test
    public void testLongString(){
        String seq1 = "TheQuickBrownFox";
        String seq2 = "JumpedOverTheLazyDog";
        Assertions.assertTrue(areTangled("TheQuickJumpedOverTheLazyDogBrownFox", seq1, seq2));
        Assertions.assertTrue(areTangled("TheJumpedOverTheLazyDogQuickJumpedOverTheLazyDogBrownFoJumpedOverTh", seq1, seq2));
    }

}
