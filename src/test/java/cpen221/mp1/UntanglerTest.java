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
        //Assertions.assertTrue(areTangled("aabbb", seq1, seq2));
        Assertions.assertTrue(areTangled("hi!bye!hi!bye!", seq1, seq2));
        //Assertions.assertTrue(areTangled("bbbaabbbaa", seq1, seq2));
        //Assertions.assertFalse(areTangled("bbbaabbbzz", seq1, seq2));
    }

}
