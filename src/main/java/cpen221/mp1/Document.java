package cpen221.mp1;

import cpen221.mp1.exceptions.NoSuitableSentenceException;
import cpen221.mp1.sentiments.SentimentAnalysis;

import java.io.*;
import java.util.*;
import java.text.BreakIterator;

import java.io.IOException;
import java.net.URL;

public class Document {

    /* ------- Task 0 ------- */
    /*  all the basic things  */

    private String docID;
    private String docContent;
    private String[] docSentences;
    private String[] docWords;
    //private Map<Integer, Integer> phrasesInSentence = new HashMap<>();
    private TreeMap<String, Integer> catalogueWords = new TreeMap<>();
    private final char[] specialChars = {' ', '!', '"', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/',
             ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_', '`', '{', '|', '}','~'};
    private final int LETTERA = 64;
    private final int LETTERZ = 123;



    /**
     * Create a new document using a URL
     *
     * @param docId  the document identifier
     * @param docURL the URL with the contents of the document
     */
    public Document(String docId, URL docURL) {

        try {
            StringBuilder str = new StringBuilder();
            String documentURL = docURL.toExternalForm();
            Scanner urlScanner = new Scanner(new URL(documentURL).openStream());

            while (urlScanner.hasNext()) {
                str.append(formatLineEnd(urlScanner.nextLine()));
            }

            docID = docId;
            docContent = str.toString();
        } catch (IOException ioe) {
            System.out.println("Problem reading from URL!");
        }


        splitSentence(docContent);
        docContent = docContent.toLowerCase();
        docWords = splitWord(docContent);
    }

    /**
     * Create a new document using a file and the filename
     *
     * @param docId    the document identifier
     * @param fileName the name of the file with the contents of
     *                 the document
     */
    public Document(String docId, String fileName) {
        // TODO: Implement this constructor

        try {

            StringBuilder doc = new StringBuilder();

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            for (String fileLine = reader.readLine(); fileLine != null; fileLine = reader.readLine()) {
                //adding in the space if last character in the line is a letter
                if (fileLine.length() != 0) {
                    if (((int) fileLine.charAt(fileLine.length() - 1)) > LETTERA && ((int) fileLine.charAt(fileLine.length() - 1)) < LETTERZ) {
                        fileLine = fileLine + " ";
                    }
                }
                doc.append(fileLine);
            }
            reader.close();
            docContent = doc.toString();
            docID = docId;
        } catch (IOException ioe) {
            System.out.println("Problem reading file!");
        }

        splitSentence(docContent);

        docContent = docContent.toLowerCase();
        docWords = splitWord(docContent);

    }

    /**
     * Formats the end of a line with a space if it doesn't end with a space or hyphen
     *
     * @param line the String to be formatted
     * @return the line ending with a space or hyphen
     */
    private String formatLineEnd(String line) {
        if (line.length() != 0) {
            if ((line.charAt(line.length() - 1)) != ' ' && (line.charAt(line.length() - 1)) != '-') {
                line = line + " ";
            }
        }
        return line;
    }

    /**
     * Split the given string by sentence
     *
     * @return the sentences as an array of strings
     */
    private String[] splitSentence(String content) {
        List<String> sentences = new ArrayList();
        String nextSentence;

        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        iterator.setText(content);
        int start = iterator.first();

        for (int end = iterator.next(); end != BreakIterator.DONE; start = end, end = iterator.next()) {
            nextSentence = content.substring(start, end);
            nextSentence = trimSentence(nextSentence);
            sentences.add(nextSentence.toLowerCase());
        }

        docSentences = new String[sentences.size()];

        for (int i = 0; i < sentences.size(); i++) {
            docSentences[i] = sentences.get(i);
        }

        return docSentences;
    }

    /**
     * Splits the content of the document at spaces and periods (and backticks apparently) into words
     *
     * @param content the String containing all the content of the document
     * @return a String array with each word as an element
     */
    private String[] splitWord(String content) {

        String text = content; // the text to split into sentences
        BreakIterator iterator = BreakIterator.getWordInstance(Locale.US);
        iterator.setText(text);
        int start = iterator.first();
        ArrayList<String> docWords = new ArrayList<>();

        for (int end = iterator.next();
             end != BreakIterator.DONE;
             start = end, end = iterator.next()) {

            String word = text.substring(start, end);
            //word = trimWord(word);

            if (trimWord(word) != "") {
                docWords.add(trimWord(word));
                classifyWord(trimWord(word));
                //System.out.println(trimWord(word));
            }

        }

        String[] arrayOfWords = new String[docWords.size()];

        for (int i = 0; i < docWords.size(); i++) {
            arrayOfWords[i] = docWords.get(i);
        }

        return arrayOfWords;
    }

    /**
     * Assumes it is called using the string of a sentence, trims off whitespace from both ends and .!?
     * characters from the end
     *
     * @return trimmed sentence
     */
    private String trimSentence(String input) {
        String output = input; // is this okay, or should it be a new string? just wanna double check

        if (output.charAt(0) == ' ') {
            output = output.substring(1);
            output = trimSentence(output);

        } else if (output.charAt(output.length() - 1) == ' ' ||
                output.charAt(output.length() - 1) == '!' ||
                output.charAt(output.length() - 1) == '?' ||
                output.charAt(output.length() - 1) == '.') {

            output = output.substring(0, output.length() - 1);
            output = trimSentence(output);
        }
        return output;
    }

    /**
     * Assumes it is called with a word in a String that still has special characters and punctuation
     *
     * @param input the String to be trimmed of special characters and formatting
     * @return a word with no special characters or punctuation
     */
    private String trimWord(String input) {
        String output = input;

        if (output.length() == 0) {
            return "";
        } else if (checkChar(output.charAt(0))) {
            output = output.substring(1);
            output = trimWord(output);
        } else if (checkChar(output.charAt(output.length() - 1))) {
            output = output.substring(0, output.length() - 1);
            output = trimWord(output);
        }

        return output;
    }

    /**
     * Checks if a character is a special character
     *
     * @param c the character to check
     * @return true if the character is a special character or a space, false otherwise
     */
    private boolean checkChar(char c) {
        for (int i = 0; i < specialChars.length; i++) {
            if (c == specialChars[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Used to access total words in the document
     *
     * @return double value of word count in the doc
     */
    private double totalWords() {
        return docWords.length;
    }

    /**
     * Adds words to a treemap where the key is the unique string and the value is the occurances
     *
     * @param word string key to classify in the treemap
     */
    private void classifyWord(String word) {
        if (catalogueWords.containsKey(word)) {
            catalogueWords.put(word, catalogueWords.get(word) + 1);
        } else {
            catalogueWords.put(word, 1);
        }
    }

    /**
     * @return amount of unique words that appear in the document
     */
    private int uniqueWordsCount() {
        return catalogueWords.size();
    }

    /**
     * @return amount of words that appear exactly once in the document
     */
    private int hapaxWordsCount() {
        int count = 0;

        for (Map.Entry<String, Integer> entry : catalogueWords.entrySet()) {
            if (entry.getValue() == 1) count++;
        }

        return count;
    }

    /**
     * Obtain the identifier for this document
     *
     * @return the identifier for this document
     */
    public String getDocId() {
        return docID;
    }

    /* ------- Task 1 ------- */

    /**
     * Used to calculate the average length of a word
     *
     * @return the average number of letters in a word
     */
    public double averageWordLength() {
        double totalLength = 0;
        for (int i = 0; i < docWords.length; i++) {
            totalLength += docWords[i].length();
        }

        return totalLength / docWords.length;
    }

    /**
     * @return the ratio of unique words to total words in the document
     */
    public double uniqueWordRatio() {
        double uniqueRatio;

        uniqueRatio = (double) uniqueWordsCount() / totalWords();
        return uniqueRatio;
    }

    /**
     * @return the ratio of words that appear once to the total words in the document
     */
    public double hapaxLegomanaRatio() {
        double hapaxRatio;
        hapaxRatio = (double) hapaxWordsCount() / totalWords();
        return hapaxRatio;
    }

    public TreeMap<String, Integer> getCatalogueWords() {
        return catalogueWords;
    }

    /* ------- Task 2 ------- */

    /**
     * Obtain the number of sentences in the document
     *
     * @return the number of sentences in the document
     */
    public int numSentences() {
        return docSentences.length;
    }

    /**
     * Obtain a specific sentence from the document.
     * Sentences are numbered starting from 1.
     *
     * @param sentence_number the position of the sentence to retrieve,
     *                        {@code 1 <= sentence_number <= this.getSentenceCount()}
     * @return the sentence indexed by {@code sentence_number}
     */
    public String getSentence(int sentence_number) {
        return docSentences[sentence_number - 1];
    }

    public double averageSentenceLength() {
        return ((double) docWords.length) / docSentences.length;
    }

    public double averageSentenceComplexity() {
        double total = 0;
        for (int i = 0; i < docSentences.length; i++) {
            total += getNumPhrases(docSentences[i]);
        }
        return total / docSentences.length;
    }


    private int getNumPhrases(String sentence) {
        int count = 1;

        for (int i = 1; i < sentence.length() - 1; i++) {
            if ((sentence.charAt(i) == ',') || (sentence.charAt(i) == ':') || (sentence.charAt(i) == ';')) {
                count++;
            }
        }

        return count;
    }

    /* ------- Task 3 ------- */

//    To implement these methods while keeping the class
//    small in terms of number of lines of code,
//    implement the methods fully in sentiments.SentimentAnalysis
//    and call those methods here. Use the getSentence() method
//    implemented in this class when you implement the methods
//    in the SentimentAnalysis class.

//    Further, avoid using the Google Cloud AI multiple times for
//    the same document. Save the results (cache them) for
//    reuse in this class.

//    This approach illustrates how to keep classes small and yet
//    highly functional.

    /**
     * Obtain the sentence with the most positive sentiment in the document
     *
     * @return the sentence with the most positive sentiment in the
     * document; when multiple sentences share the same sentiment value
     * returns the sentence that appears later in the document
     * @throws NoSuitableSentenceException if there is no sentence that
     *                                     expresses a positive sentiment
     */
    public String getMostPositiveSentence() throws NoSuitableSentenceException {
        return SentimentAnalysis.getMostPositiveSentence(this);
    }

    /**
     * Obtain the sentence with the most negative sentiment in the document
     *
     * @return the sentence with the most negative sentiment in the document;
     * when multiple sentences share the same sentiment value, returns the
     * sentence that appears later in the document
     * @throws NoSuitableSentenceException if there is no sentence that
     *                                     expresses a negative sentiment
     */
    public String getMostNegativeSentence() throws NoSuitableSentenceException {
        return SentimentAnalysis.getMostNegativeSentence(this);
    }
}
