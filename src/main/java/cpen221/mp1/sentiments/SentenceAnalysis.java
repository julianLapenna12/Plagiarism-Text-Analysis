package cpen221.mp1.sentiments;

import com.google.cloud.language.v1.Sentiment;

/**
 * SentenceAnalysis stores a pair of text and its corresponding sentiment,
 * @Author Joel Tsuchitori
 */
class SentenceAnalysis {
    private String sentence;
    private Sentiment analysis;

    public SentenceAnalysis(String inputSentence, Sentiment inputSentiment){
        sentence = inputSentence;
        analysis = inputSentiment;
    }

    /**
     * @return the string of text which this class represents..
     */
    public String getSentence(){
        return sentence;
    }

    /**
     * @return the sentiment analysis of the sentence this class represents.
     */
    public Sentiment getSentiment(){
        return analysis;
    }
}
