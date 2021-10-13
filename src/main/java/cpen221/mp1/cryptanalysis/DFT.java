package cpen221.mp1.cryptanalysis;

import org.checkerframework.checker.units.qual.C;

/**
 * DFT has methods for doing fourier transforms on various sets of data, allowing for frequency analysis.
 * @Author Joel Tsuchitori
 */
public class DFT {

    /**
     * dft runs a discrete fourier transform on a array of complex numbers, breaking down the array to its component frequencies.
     * @param inSignal is an array of complex numbers which the discrete fourier transform is run on
     * @return an array of complex values with same size as inSignal, corresponding to inSignal's equivalent fourier series
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

    /**
     * dft runs a discrete fourier transform on a array of integers, breaking down the array to its component frequencies.
     * @param inSignal is an array of integers which the discrete fourier transform is run on
     * @return an array of complex values with same size as inSignal, corresponding to inSignal's equivalent fourier series
     */
    public static ComplexNumber[] dft(int[] inSignal) {
        ComplexNumber[] inSignalComplex  = new ComplexNumber[inSignal.length];
        for(int i = 0; i < inSignal.length; i++){
            inSignalComplex[i] = new ComplexNumber(inSignal[i], 0);
        }
        return dft(inSignalComplex);
    }


}