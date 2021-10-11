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

public class CryptographyTest {

    private static Document testDocument1;
    private static char[] padding;

    @BeforeAll
    public static void setupTests() throws MalformedURLException {
        testDocument1 = new Document("The Ant and The Cricket", new URL("http://textfiles.com/stories/antcrick.txt"));
        padding = new char[5000 - testDocument1.getDocContent().length()];
        for(int i = 0; i < padding.length; i++){
            padding[i] = 'a';
        }
    }

    @Test
    public void testCrypto(){
        Assertions.assertEquals(decrypt(encrypt(testDocument1, 100, 5, 64)), testDocument1.getDocContent().substring(0, 100));
        Assertions.assertEquals(decrypt(encrypt(testDocument1, 100, 5, 128)), testDocument1.getDocContent().substring(0, 100));
        Assertions.assertEquals(decrypt(encrypt(testDocument1, 100, 5, 256)), testDocument1.getDocContent().substring(0, 100));
        Assertions.assertEquals(decrypt(encrypt(testDocument1, 100, 5, 512)), testDocument1.getDocContent().substring(0, 100));
        Assertions.assertEquals(decrypt(encrypt(testDocument1, 100, 10, 64)), testDocument1.getDocContent().substring(0, 100));
        Assertions.assertEquals(decrypt(encrypt(testDocument1, 100, 20, 128)), testDocument1.getDocContent().substring(0, 100));
        Assertions.assertEquals(decrypt(encrypt(testDocument1, 100, 50, 256)), testDocument1.getDocContent().substring(0, 100));
    }

    @Test
    public void testPeriod2(){
        Assertions.assertEquals(decrypt(encrypt(testDocument1, 100, 2, 64)), testDocument1.getDocContent().substring(0, 100));
        Assertions.assertEquals(decrypt(encrypt(testDocument1, 100, 2, 128)), testDocument1.getDocContent().substring(0, 100));
        Assertions.assertEquals(decrypt(encrypt(testDocument1, 100, 2, 256)), testDocument1.getDocContent().substring(0, 100));
        Assertions.assertEquals(decrypt(encrypt(testDocument1, 100, 2, 512)), testDocument1.getDocContent().substring(0, 100));
    }

    @Test
    public void testPadding(){
        Assertions.assertEquals(decrypt(encrypt(testDocument1, 5000, 20, 64)), testDocument1.getDocContent().concat(new String(padding)));
        Assertions.assertEquals(decrypt(encrypt(testDocument1, 5000, 20, 128)), testDocument1.getDocContent().concat(new String(padding)));
        Assertions.assertEquals(decrypt(encrypt(testDocument1, 5000, 20, 256)), testDocument1.getDocContent().concat(new String(padding)));
        Assertions.assertEquals(decrypt(encrypt(testDocument1, 5000, 20, 512)), testDocument1.getDocContent().concat(new String(padding)));
    }
}
