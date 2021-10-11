package cpen221.mp1.cryptanalysis;

import org.checkerframework.checker.units.qual.C;

public class DFT {
    /*
     * Calculates the Discrete Fourier transform of a sequence of complex number
     */
    public static ComplexNumber[] dft(ComplexNumber[] inSignal) {
        ComplexNumber[] transform  = new ComplexNumber[inSignal.length];
        int N = inSignal.length;
        for (int k = 0; k < transform.length; k++){
            transform[k] = new ComplexNumber();
            for(int j = 0; j < inSignal.length; j++){
                ComplexNumber part = (new ComplexNumber(Math.cos(2 * Math.PI * k * j / N), -Math.sin(2 * Math.PI * k * j / N)));
                part.multiply(inSignal[j]);
                transform[k].add(part);
            }
        }
        return transform;
    }

    public static ComplexNumber[] dft(int[] inSignal) {
        ComplexNumber[] inSignalComplex  = new ComplexNumber[inSignal.length];
        for(int i = 0; i < inSignal.length; i++){
            inSignalComplex[i] = new ComplexNumber(inSignal[i], 0);
        }
        return dft(inSignalComplex);
    }


}