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
    public static Sentiment getMostPositiveSentence(String[] text)
        throws NoSuitableSentenceException{
        List<Sentiment> sentences = getSentenceSentiment(text);
        Sentiment mostPositive = sentences.get(0);
        for(Sentiment sentence : sentences){
            if (sentence.getScore() >= mostPositive.getScore()){
                mostPositive = sentence;
            }
        }
        if(mostPositive.getScore() <= 0){throw new NoSuitableSentenceException();}
        return mostPositive;
    }

    /**
     * @param text is a non-empty array of strings to be analyzed by the sentiment analyzer
     * @return a Sentiment object with the most negative scores of all the analyzed sentences, contains the score and magnitude and the original sentence
     * @throws NoSuitableSentenceException when there is no sentence with negative sentiment
     */
    public static Sentiment getMostNegativeSentence(String[] text)
        throws NoSuitableSentenceException {
        List<Sentiment> sentences = getSentenceSentiment(text);
        Sentiment mostNegative = sentences.get(0);
        for(Sentiment sentence : sentences){
            if (sentence.getScore() >= mostNegative.getScore()){
                mostNegative = sentence;
            }
        }
        if(mostNegative.getScore() <= 0){throw new NoSuitableSentenceException();}
        return mostNegative;
    }

    //Analyzes the sentiment of each of the sentences in the list, sorts the list based on the score of each setence, then returns the list
    private static List<Sentiment> getSentenceSentiment(String[] text){
        LanguageServiceClient language = createLanguageClient();
        Document doc = Document.newBuilder().setType(Type.PLAIN_TEXT).build();
        ArrayList<Sentiment> sentimentList = new ArrayList<Sentiment>();
        for(String sentence: text){
            doc.toBuilder().clearContent().setContent(sentence).build();
            AnalyzeSentimentResponse response = language.analyzeSentiment(doc);
            sentimentList.add(response.getDocumentSentiment());
        }
        return sentimentList;
    }

    //Attempts to access the natural language API and returns the language client if successfull
    private static LanguageServiceClient createLanguageClient(){
        try (LanguageServiceClient language = LanguageServiceClient.create()){
            return language;
        }
        catch (IOException ioe){
            System.out.println(ioe);
            throw new RuntimeException("Unable to communicate with Sentiment Analysis");
        }
    }
    public static void Main(String[] args){}
}
