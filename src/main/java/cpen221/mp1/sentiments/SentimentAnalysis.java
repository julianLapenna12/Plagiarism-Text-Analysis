package cpen221.mp1.sentiments;

import com.google.cloud.language.v1.*;
import com.google.cloud.language.v1.Document.Type;
import cpen221.mp1.exceptions.NoSuitableSentenceException;
import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SentimentAnalysis {
    /**
     * @param text is a non-empty array of strings to be analyzed by the sentiment analyzer
     * @return a Sentiment object with the most positive scores of all the analyzed sentences, contains the score and magnitude and the original sentence
     * @throws NoSuitableSentenceException when there is no sentence with positive sentiment
     */
    public static String getMostPositiveSentence(String[] text)
        throws NoSuitableSentenceException{
        List<SentenceAnalysis> sentences = getSentenceSentiment(text);
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
     * @param text is a non-empty array of strings to be analyzed by the sentiment analyzer
     * @return a Sentiment object with the most negative scores of all the analyzed sentences, contains the score and magnitude and the original sentence
     * @throws NoSuitableSentenceException when there is no sentence with negative sentiment
     */
    public static String getMostNegativeSentence(String[] text)
        throws NoSuitableSentenceException {
        List<SentenceAnalysis> sentences = getSentenceSentiment(text);
        SentenceAnalysis mostNegative = sentences.get(0);
        for(SentenceAnalysis sentence : sentences){
            if (sentence.getSentiment().getScore() <= mostNegative.getSentiment().getScore()){
                mostNegative = sentence;
            }
        }
        if(mostNegative.getSentiment().getScore() >= -0.3){throw new NoSuitableSentenceException();}
        return mostNegative.getSentence();
    }

    //Analyzes the sentiment of each of the sentences in the list, sorts the list based on the score of each setence, then returns the list
    private static List<SentenceAnalysis> getSentenceSentiment(String[] text){
        try (LanguageServiceClient language = LanguageServiceClient.create()){
            Document doc = Document.newBuilder().setType(Type.PLAIN_TEXT).build();
            ArrayList<SentenceAnalysis> sentimentList = new ArrayList<SentenceAnalysis>();
            for(String sentence: text){
                doc = doc.toBuilder().clearContent().setContent(sentence).setType(Type.PLAIN_TEXT).build();
                AnalyzeSentimentResponse response = language.analyzeSentiment(doc);
                sentimentList.add(new SentenceAnalysis(sentence, response.getDocumentSentiment()));
            }
            return sentimentList;
        }
        catch (IOException ioe){
            System.out.println(ioe);
            throw new RuntimeException("Unable to communicate with Sentiment Analysis");
        }
    }
}
