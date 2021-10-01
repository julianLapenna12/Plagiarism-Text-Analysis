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
     * @param text is an array of strings to be analyzed by the sentiment analyzer
     * @return a Sentiment object with the most positive scores of all the analyzed sentences, contains the score and magnitude and the original sentence
     * @throws NoSuitableSentenceException when there is no sentence which can be analyzed I.E. the text array is empty
     */
    public static Sentiment getMostPositiveSentence(String[] text)
        throws NoSuitableSentenceException{
        List<SentimentSortable> sentences = getSentenceSentiment(text);
        if(text.length == 0 ||sentences.get(0) == null){throw new NoSuitableSentenceException();}
        return sentences.get(0).getSentiment();

    }

    /**
     * @param text is an array of strings to be analyzed by the sentiment analyzer
     * @return a Sentiment object with the most negative scores of all the analyzed sentences, contains the score and magnitude and the original sentence
     * @throws NoSuitableSentenceException when there is no sentence which can be analyzed I.E. the text array is empty
     */
    public static Sentiment getMostNegativeSentence(String[] text)
        throws NoSuitableSentenceException {
        List<SentimentSortable> sentences = getSentenceSentiment(text);
        if(text.length == 0 ||sentences.get(0) == null){throw new NoSuitableSentenceException();}
        return sentences.get(sentences.size() - 1).getSentiment();
    }

    //Analyzes the sentiment of each of the sentences in the list, sorts the list based on the score of each setence, then returns the list
    private static List<SentimentSortable> getSentenceSentiment(String[] text){
        LanguageServiceClient language = createLanguageClient();
        Document doc = Document.newBuilder().setType(Type.PLAIN_TEXT).build();
        ArrayList<SentimentSortable> sentimentList = new ArrayList<SentimentSortable>();
        for(String sentence: text){
            doc.toBuilder().clearContent().setContent(sentence).build();
            AnalyzeSentimentResponse response = language.analyzeSentiment(doc);
            sentimentList.add(new SentimentSortable(response.getDocumentSentiment()));
        }
        sentimentList.sort(null);
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
}
