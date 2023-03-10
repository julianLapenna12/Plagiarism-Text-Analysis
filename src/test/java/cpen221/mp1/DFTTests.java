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

public class DFTTests {
    @Test
    public void testDFTSize(){
        int[] testSignal = {2,-2,2,-2,2,-2};
        Assertions.assertEquals(dft(testSignal).length, testSignal.length);
    }
    @Test
    public void testDFTConst(){
        int[] testSignal = {2,2,2,2,2,2};
        Assertions.assertEquals(dft(testSignal)[0].re(), 12);
    }
}
