package cpen221.mp1.sentiments;

import com.google.cloud.language.v1.*;
import com.google.cloud.language.v1.Document.Type;
import cpen221.mp1.exceptions.NoSuitableSentenceException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Sentiment analysis connects with the Google cloud natural language API and uses it to analyze the sentiment of a document.
 * @Author Joel Tsuchitori
 */
public class SentimentAnalysis {
    /**
     * getMostPositiveSentence connects to the Google natural language API on the cloud and uses it to find the most positive sentence determined from Google's algorithm.
     * @param doc is a non-empty document object whose sentences are analyzed
     * @return a Sentiment object with the most positive scores of all the analyzed sentences, contains the score and magnitude and the original sentence
     * @throws NoSuitableSentenceException when there is no sentence with positive sentiment
     */
    public static String getMostPositiveSentence(cpen221.mp1.Document doc)
        throws NoSuitableSentenceException{
        List<SentenceAnalysis> sentences = getSentenceSentiment(doc);
        SentenceAnalysis mostPositive = sentences.get(0);
        for(SentenceAnalysis sentence : sentences){
            if (sentence.getSentiment().getScore() >= mostPositive.getSentiment().getScore()){
                mostPositive = sentence;
            }
        }
        if(mostPositive.getSentiment().getScore() <= 0.3){throw new NoSuitableSentenceException();}
        return mostPositive.getSentence();
    }

    /**
     * getMostNegativeSentence connects to the Google natural language API on the cloud and uses it to find the most negative sentence determined from Google's algorithm.
     * @param doc is a non empty document object whose sentences are analyzed
     * @return a Sentiment object with the most negative scores of all the analyzed sentences, contains the score and magnitude and the original sentence
     * @throws NoSuitableSentenceException when there is no sentence with negative sentiment
     */
    public static String getMostNegativeSentence(cpen221.mp1.Document doc)
        throws NoSuitableSentenceException {
        List<SentenceAnalysis> sentences = getSentenceSentiment(doc);
        SentenceAnalysis mostNegative = sentences.get(0);
        for(SentenceAnalysis sentence : sentences){
            if (sentence.getSentiment().getScore() <= mostNegative.getSentiment().getScore()){
                mostNegative = sentence;
            }
        }
        if(mostNegative.getSentiment().getScore() >= -0.3){throw new NoSuitableSentenceException();}
        return mostNegative.getSentence();
    }

    /**
     * getSentenceSentiment attempts to connect to the Google Natural Language API and then analyzes every sentence in a given document if successful.
     * @param doc is a Document with at least one sentence from which each sentence will be analyzed.
     * @return a list of SentenceAnalysis, each of which contains a score and magnitude corresponding to the emotional content of the sentence, and the text of the sentence.
     * The score represents how positive or how negative the sentiment of the sentence is, while the magnitude corresponds to the strength of that feeling.
     */
    private static List<SentenceAnalysis> getSentenceSentiment(cpen221.mp1.Document doc){
        try (LanguageServiceClient language = LanguageServiceClient.create()){
            Document sentence = Document.newBuilder().setType(Type.PLAIN_TEXT).build();
            ArrayList<SentenceAnalysis> sentimentList = new ArrayList<>();
            for(int i = 1; i <= doc.numSentences(); i++){
                sentence = sentence.toBuilder().clearContent().setContent(doc.getSentence(i)).setType(Type.PLAIN_TEXT).build();
                AnalyzeSentimentResponse response = language.analyzeSentiment(sentence);
                sentimentList.add(new SentenceAnalysis(doc.getSentence(i), response.getDocumentSentiment()));
            }
            return sentimentList;
        }
        catch (IOException ioe){
            System.out.println(ioe);
            throw new RuntimeException("Unable to communicate with Sentiment Analysis");
        }
    }
}
