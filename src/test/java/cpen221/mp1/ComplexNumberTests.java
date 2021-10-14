package cpen221.mp1;

import cpen221.mp1.cryptanalysis.ComplexNumber;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.security.KeyStore;

public class ComplexNumberTests {
    //TODO Add more test Cases for 100% Coverage
    @Test
    public void testAddition(){
        for (int i = -10; i <= 10; i++){
            for(int j = -10; j <= 10; j ++){
                ComplexNumber a = new  ComplexNumber(i, j);
                ComplexNumber b = new ComplexNumber(j, i);
                a.add(b);
                Assertions.assertEquals(a.re(), i + j);
                Assertions.assertEquals(a.im(), j + i);
            }
        }
    }

    @Test
    public void testEquality(){
        for (int i = -10; i <= 10; i++){
            for(int j = -10; j <= 10; j ++){
                ComplexNumber a = new  ComplexNumber(i, j);
                ComplexNumber b = new ComplexNumber(i, j);
                ComplexNumber c = new ComplexNumber(11, -11);
                Assertions.assertEquals(a.equals(b), true);
                Assertions.assertEquals(a.hashCode() == b.hashCode(), true);
                Assertions.assertEquals(a.equals(c), false);
            }
        }
    }

    @Test
    public void testMult(){
        for (int i = -10; i <= 10; i++){
            for(int j = -10; j <= 10; j ++){
                ComplexNumber a = new  ComplexNumber(i, 0);
                ComplexNumber b = new ComplexNumber(j, 0);
                ComplexNumber c = new  ComplexNumber(0, i);
                ComplexNumber d = new ComplexNumber(0, j);
                ComplexNumber g = new ComplexNumber(i,i);
                g.multiply(g);
                a.multiply(b);
                c.multiply(d);
                Assertions.assertTrue(a.re() == i * j);
                Assertions.assertEquals(Math.abs(a.im()), 0);
                Assertions.assertEquals(c.re(), -i * j);
                Assertions.assertEquals(Math.abs(c.im()), 0);
                Assertions.assertTrue(g.im() == 2 * i * i);
                Assertions.assertTrue(g.re() == 0);
            }
        }
    }

    @Test
    public void testSeed(){
        ComplexNumber a = new ComplexNumber(1,1);
        Assertions.assertEquals(new ComplexNumber(a), a);
    }

    @Test
    public void testHash(){
        for(int i = -10; i < 10; i++){
            ComplexNumber a = new ComplexNumber(i,i);
            ComplexNumber b = new ComplexNumber(i,i);
            Assertions.assertEquals(a.hashCode(), b.hashCode());

        }
    }

}
