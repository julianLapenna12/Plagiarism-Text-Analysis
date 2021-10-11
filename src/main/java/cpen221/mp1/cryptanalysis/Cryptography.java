package cpen221.mp1.cryptanalysis;

import cpen221.mp1.Document;

import java.util.Random;

import static cpen221.mp1.cryptanalysis.DFT.dft;

public class Cryptography {

    private static final char paddingChar = 'a';

    /**
     * Encrypt a document by replacing the i-th character, c_i, with
     * c_i + A \times \sin{(i \times 2\pi / P + \pi/4)}
     * where A is the amplitude and P is the period for the sine wave.
     *
     * @param doc the document to encrypt
     * @param length the number of characters to encrypt.
     *               If {@code length} is less than the number of
     *               characters in the document then only that many
     *               characters are encrypted.
     *               If {@code length} is greater than the number
     *               of characters in the document then additional
     *               ' ' are added at the end and encrypted.
     * @param period is the period of the sine wave used for encryption
     *               and {@code period} must be a factor of
     *               {@code length} other than 1 and {@code length} itself.
     * @param amplitude is the amplitude of the encrypting sine wave
     *                  and can be 64, 128, 256 or 512.
     * @return the encrypted array.
     */
    public static int[] encrypt(Document doc, int length, int period, int amplitude) {
        int [] encrypted = new int[length];
        char[] encryptSeq = createEncryptSeq(doc, length);
        for (int i = 0; i < length; i++){
            encrypted[i] =  (int) encryptSeq[i] + (int)(amplitude * Math.sin((double) i * 2 * Math.PI / (double)period + Math.PI / 4));
        }
        return encrypted;
    }

    private static char[] createEncryptSeq(Document doc, int length){
        String content = doc.getDocContent();
        if(content.length() < length){
            char[] padding = new char[length - content.length()];
            for (int i  = 0; i < padding.length; i++) {
                padding[i] = paddingChar;
            }
            return content.concat(new String(padding)).toCharArray();
        }
        else{
            return content.substring(0, length).toCharArray();
        }
    }

    /**
     * Decrypt a text that has been encrypted using {@code Cryptography#encrypt}.
     * @param codedText the data to decrypt.
     * @return the decrypted text.
     */
    public static String decrypt(int[] codedText) {
        char[] output = new char[codedText.length];
        ComplexNumber[] fourier = dft(codedText);
        int amp = 0;
        int freq = 0;
        for(int i = 1; i < fourier.length; i++){
            if (fourier[i].re() > amp){
                amp = (int)fourier[i].amp();
                freq = i;
            }
        }
        //Calculate Amp and Round it to the nearest value, 64, 128, 256, 512
        double ampDouble = ((amp * 2.0 / fourier.length) / 64.0);
        if(ampDouble < 1.5){
            amp = 64;
        }
        else if(ampDouble >= 1.5 && ampDouble < 3){
            amp = 128;
        }
        else if(ampDouble >= 3 && ampDouble < 6){
            amp = 256;
        }
        else {amp = 512;}

        int period = codedText.length / freq;
        for(int j = 0; j < codedText.length; j++){
            codedText[j] -= (int)(amp * Math.sin(j * 2 * Math.PI / (period) + Math.PI / 4));
            output[j] = (char) codedText[j];
        }
        return new String(output);
    }

}