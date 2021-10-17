package cpen221.mp1.cryptanalysis;

import java.util.ArrayList;

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
        ArrayList<Character> src2List = makeCharList(src2);
        int j = 0;
        int k = 0;
        for(int i = 0; i < superList.size(); i++){
            if(superList.get(i).equals(src1List.get(j)) && !superList.get(i).equals(src2List.get(k))){
                superList.remove(i);
                j++;
                i--;
                j = j % src1.length();
            }
            else if(superList.get(i).equals(src2List.get(k)) && !superList.get(i).equals(src1List.get(j))){
                superList.remove(i);
                k++;
                i--;
                k = k % src2.length();
            }
            //If the letter is shared by the two sequences, then checks down the the next characters until there is no tie, and then takes the letter from that one.
            else if(superList.get(i).equals(src2List.get(k)) && superList.get(i).equals(src1List.get(j))){
                superList.remove(i);
                i--;
                for(Character compare : superList){
                    if(compare.equals(src1List.get((j + 1) % src1.length()))){
                        j++;
                        j = j % src1.length();
                        break;
                    }
                    else if (compare.equals(src2List.get((k + 1) % src2.length()))){
                        k++;
                        k = k % src2.length();
                        break;
                    }
                }
            }
        }
        return superList.size() == 0;
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
}