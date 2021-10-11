package cpen221.mp1.cryptanalysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        ArrayList<Character> superList = makeCharList(superposition);
        ArrayList<Character> src1List = makeCharList(src1);
        int j = 0;
        for(int i = 0; i < superList.size(); i++){
            if(superList.get(i).equals(src1List.get(j))){
                superList.remove(i);
                j++;
                i--;
                j = j % src1.length();
            }
        }
        return createRepetition(src2, superList.size()).equals(superList);
    }

    private static ArrayList<Character> makeCharList(String input){
        ArrayList<Character> charList = new ArrayList<Character>();
        char[] inArray = input.toCharArray();
        for(char i : inArray){
            charList.add(i);
        }
        return charList;
    }

    private static ArrayList<Character> createRepetition(String seed, int length){
        char[] repetition = new char[length];
        char[] seedSeq = seed.toCharArray();
        for(int i = 0; i < length; i++){
            repetition[i] = seedSeq[i % seed.length()];
        }
        return  makeCharList(new String(repetition));
    }
}