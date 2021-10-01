package cpen221.mp1.sentiments;
import com.google.cloud.language.v1.*;
import com.google.cloud.language.v1.Document.Type;

public class SentimentSortable  implements Comparable<SentimentSortable>{

    private Sentiment sentiment;

    public SentimentSortable(Sentiment sentiment){
        this.sentiment = sentiment;
    }

    public Sentiment getSentiment(){
        return sentiment;
    }

    @Override
    public int compareTo(SentimentSortable o) {
        return (int)Math.signum(sentiment.getScore() - o.getSentiment().getScore());
    }
}
