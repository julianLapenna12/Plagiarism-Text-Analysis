package cpen221.mp1.cryptanalysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static cpen221.mp1.cryptanalysis.DFT.dft;

/**
 * Untangler contains methods to analyze signals in the form of strings,
 * and determine if they are superpositions of other signals.
 * @Author Joel Tsuchitori
 */
public class Untangler {

    /**
     * Determine if {@code superposition} is a result of
     * a tangling of {@code src1} and {@code src2}.
     * Being a superposition means it is some sequence of characters which can be decomposed
     * to two sequences, each of which respectively is a prefix of repetitions of src1 and src2
     * and contains at least 1 character of each sequence.
     *
     * @param superposition the possibly tangled signal
     * @param src1 the first signal, non-empty string
     * @param src2 the second signal, non-empty string
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
        return createRepetition(src2, superList.size()).equals(superList) && superList.size() != 0;
    }

    /**
     * Creates a List of characters from an input string
     * which contains all the characters of the string in the order they appear.
     * @param input
     * @return an array laist of characters with the same ordering as the input string.
     */
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