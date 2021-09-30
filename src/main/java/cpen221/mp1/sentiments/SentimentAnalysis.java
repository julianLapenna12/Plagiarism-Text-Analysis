package cpen221.mp1.sentiments;

import com.google.cloud.language.v1.*;
import com.google.cloud.language.v1.Document.Type;
import cpen221.mp1.exceptions.NoSuitableSentenceException;
import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SentimentAnalysis {

    public static Sentiment getMostPositiveSentence()
        throws NoSuitableSentenceException {
            String text = "The Quick brown fox jumped over the lazy dog. I like men."; //TODO implement document get text method
            try(LanguageServiceClient language = LanguageServiceClient.create()){
                Document doc = Document.newBuilder().setType(Type.PLAIN_TEXT).build();
                List<Sentence> sentences = getSentenceSentiment(text, doc, language);
                Sentence mostPositive = sentences.get(0);
                for(Sentence sentence : sentences){
                    if(mostPositive.getSentiment().getScore() >= sentence.getSentiment().getScore()){
                        mostPositive = sentence;
                    }
                }
                System.out.println(mostPositive.getText());
                return mostPositive.getSentiment();
            }
            catch (IOException ioe){
                System.out.println(ioe);
                throw new RuntimeException("Unable to communicate with Sentiment Analysis");
            }
    }

    public static Sentiment getMostNegativeSentence(Document document)
        throws NoSuitableSentenceException {
        // TODO: Implement this method
        return null;
    }

    private static List<Sentence> getSentenceSentiment(String text, Document doc, LanguageServiceClient language){
        ArrayList<Sentiment> sentimentList = new ArrayList<Sentiment>();
        doc.toBuilder().clearContent().setContent(text).build();
        AnalyzeSentimentResponse response = language.analyzeSentiment(doc);
        return response.getSentencesList();
    }

}
