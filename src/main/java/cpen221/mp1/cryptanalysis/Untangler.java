package cpen221.mp1.cryptanalysis;

import static cpen221.mp1.cryptanalysis.DFT.dft;

public class Untangler {

    /**
     * Determine if {@code superposition} is a result of
     * a tangling of {@code src1} and {@code src2}.
     *
     * @param superposition the possibly tangled signal
     * @param src1 the first signal
     * @param src2 the second signal
     * @return true is {@code superposition} is a
     * tangling of {@code src1} and {@code src2} and false otherwise.
     */
    public static boolean areTangled(String superposition, String src1, String src2) {
        ComplexNumber[] src1Fourier = dft(createRepetition(src1, superposition.length()));
        ComplexNumber[] src2Fourier = dft(createRepetition(src2, superposition.length()));
        ComplexNumber[] superPositionFourier = dft(createRepetition(superposition, superposition.length()));
        for(int i = 0; i < superposition.length(); i++){
            src1Fourier[i].add(src2Fourier[i]);
            System.out.println((int)superPositionFourier[i].amp());
            if((int)((src1Fourier[i].amp() / 2) - superPositionFourier[i].amp()) == 0){
                //return false;
            }
        }
        return true;
    }

    private static int[] createRepetition(String seed, int length){
        int[] repetition = new int[length];
        char[] seedSeq = seed.toCharArray();
        for(int i = 0; i < length; i++){
            repetition[i] = (int) seedSeq[i % seed.length()];
        }
        return  repetition;
    }
}