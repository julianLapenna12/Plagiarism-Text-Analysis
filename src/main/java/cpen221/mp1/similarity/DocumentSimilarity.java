package cpen221.mp1.similarity;

import cpen221.mp1.Document;

import java.text.BreakIterator;
import java.util.*;

public class DocumentSimilarity {

    /* DO NOT CHANGE THESE WEIGHTS */
    private final int WT_AVG_WORD_LENGTH = 5;
    private final int WT_UNIQUE_WORD_RATIO = 15;
    private final int WT_HAPAX_LEGOMANA_RATIO = 25;
    private final int WT_AVG_SENTENCE_LENGTH = 1;
    private final int WT_AVG_SENTENCE_CPLXTY = 4;
    private final int WT_JS_DIVERGENCE = 50;
    /* ---- END OF WEIGHTS ------ */

    private Set<String> allWords = new HashSet<>();
    private final int DIV_COMPARISONS = 5;
    private final char[] specialChars = {' ', '!', '"', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/',
            ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_', '`', '{', '|', '}','~'};
    private HashMap<Document, TreeMap<String, Integer>> wordCounts = new HashMap<>();
    private HashMap<Document, String[]> docWords = new HashMap<>();
    private String[] doc1Words;
    private String[] doc2Words;

    /* ------- Task 4 ------- */

    /**
     * Compute the Jensen-Shannon Divergence between the given documents
     *
     * @param doc1 the first document, is not null
     * @param doc2 the second document, is not null
     * @return the Jensen-Shannon Divergence between the given documents
     */
    public double jsDivergence(Document doc1, Document doc2) {
        allWords.removeAll(allWords); // redundant for now
        collectWords(doc1);
        collectWords(doc2);

        double p_i, q_i, m_i, div_p, div_q, divergenceSum = 0;

        for (String word : allWords) {

            p_i = wordProbability(doc1, word);
            q_i = wordProbability(doc2, word);
            m_i = (p_i + q_i) / 2;

            div_p = divergenceLog(p_i, m_i);
            div_q = divergenceLog(q_i, m_i);

            divergenceSum += (div_p + div_q);

        }
        return divergenceSum / 2;
    }

    /**
     * Compute the Document Divergence between the given documents
     *
     * @param doc1 the first document, is not null
     * @param doc2 the second document, is not null
     * @return the Document Divergence between the given documents
     */

    public double documentDivergence(Document doc1, Document doc2) {
        double totalDivergence = 0.0;

        // Use the provided weights in computing the document divergence
        int[] weights = {WT_AVG_SENTENCE_LENGTH, WT_AVG_SENTENCE_CPLXTY, WT_AVG_WORD_LENGTH,
                WT_UNIQUE_WORD_RATIO, WT_HAPAX_LEGOMANA_RATIO};

        double[] doc1_metrics = getDocumentMetrics(doc1);
        double[] doc2_metrics = getDocumentMetrics(doc2);

        wordCounts.put(doc1, new TreeMap<>());
        wordCounts.put(doc2, new TreeMap<>());

        doc1Words = splitWord(doc1, createDocContent(doc1));
        doc2Words = splitWord(doc2, createDocContent(doc2));

        docWords.put(doc1, doc1Words);
        docWords.put(doc2, doc2Words);

        for (int i = 0; i < DIV_COMPARISONS; i++) {
            totalDivergence += weights[i] * Math.abs(doc1_metrics[i] - doc2_metrics[i]);
        }

        totalDivergence += WT_JS_DIVERGENCE * jsDivergence(doc1, doc2);

        return totalDivergence;
    }

    /**
     * Add all words from a document into a set for a collection of all words
     * appearing across multiple documents
     *
     * @param doc the document from which to add words
     */
    private void collectWords(Document doc) {
        for (String word : docWords.get(doc)) {
            if (!allWords.contains(word)) {
                allWords.add(word);
            }
        }
    }

    /**
     * The probability of a given word appearing in a document where probability is expressed
     * as the word's occurrences divided by the total word count
     *
     * @param doc  the document to check
     * @param word the word for which we want the probability of appearing
     * @return the probability of a word appearing in a document, if it does not appear returns 0
     */
    private double wordProbability(Document doc, String word) {

        if (Arrays.asList(docWords.get(doc)).contains(word)) {
            int occurances = wordCounts.get(doc).get(word);
            return (double) occurances / totalWords(doc);
        }
        return 0.0;
    }

    /**
     * Intermediary calculation for the JS Divergence
     *
     * @param word_probability    probability of a word appear in a document
     * @param average_probability average probability of a word appearing in two different documents
     * @return the internal value to be summed to calculate the divergence
     */
    private double divergenceLog(double word_probability, double average_probability) {
        if (word_probability == 0) {
            return 0;
        }

        return word_probability * (log2(word_probability / average_probability));
    }

    /**
     * Putting the document metrics into an array for easy sorting
     *
     * @param doc the given document to get the metrics from
     * @return the metrics calculated in tasks 1 and 2 for given document
     */
    private double[] getDocumentMetrics(Document doc) {
        return new double[]{doc.averageSentenceLength(), doc.averageSentenceComplexity(),
                doc.averageWordLength(), doc.uniqueWordRatio(), doc.hapaxLegomanaRatio()};
    }

    /**
     *
     * @param number the number for which the log base 2 value is computed, must be greater than 0
     * @return double such that 2 raised to the exponent of the return equals the input
     */
    private double log2(double number) {
        return Math.log(number)/Math.log(2);
    }

    /**
     * Splits the content of the document at spaces and periods (and backticks apparently) into words
     *
     * @param content the String containing all the content of the document
     * @return a String array with each word as an element
     */
    private String[] splitWord(Document doc, String content) {

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
                classifyWord(doc, trimWord(word));
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
     * Adds words to a treemap where the key is the unique string and the value is the occurrences
     *
     * @param word string key to classify in the treemap
     */
    private void classifyWord(Document doc, String word) {
        if (wordCounts.get(doc).containsKey(word)) {
            wordCounts.get(doc).put(word, wordCounts.get(doc).get(word) + 1);
        } else {
            wordCounts.get(doc).put(word, 1);
        }
    }

    /**
     * Creates a string of the whole document from an instance of Document.
     * @param doc is a document with at least 1 sentence.
     * @return a string containing every sentence of the doc concatenated with spaces in between each sentence.
     */
    private static String createDocContent(Document doc){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= doc.numSentences(); i++){
            sb.append(doc.getSentence(i) + " ");
        }
        return sb.toString();
    }

    /**
     * Used to access total words in the document
     *
     * @return double value of word count in the doc
     */
    private double totalWords(Document doc) {
        double totalWords = docWords.get(doc).length;
        return totalWords;
    }
}
