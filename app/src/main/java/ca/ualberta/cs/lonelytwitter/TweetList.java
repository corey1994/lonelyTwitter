package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Corey on 2016-09-27.
 */
public class TweetList  {
    List<Tweet> tweets = new ArrayList<Tweet>();

    public void addTweet (Tweet tweet) {
        if (this.hasTweet(tweet)){
            throw new IllegalArgumentException("Tried to add a duplicate tweet");
        }
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    public void removeTweet(Tweet a) {
        tweets.remove(a);
    }

    public List<Tweet> getTweets() {
        Collections.sort(tweets);
        return tweets;
    }

    public int getCount() {
        return tweets.size();
    }
}
