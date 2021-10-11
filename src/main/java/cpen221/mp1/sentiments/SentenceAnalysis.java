package cpen221.mp1.sentiments;

import com.google.cloud.language.v1.Sentiment;

public class SentenceAnalysis {
    private String sentence;
    private Sentiment analysis;

    public SentenceAnalysis(String inputSentence, Sentiment inputSentiment){
        sentence = inputSentence;
        analysis = inputSentiment;
    }
    public String getSentence(){
        return sentence;
    }
    public Sentiment getSentiment(){
        return analysis;
    }
}
