package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Corey on 2016-09-27.
 *
 * Wrapper for List<Tweet>
 */
public class TweetList  {
    /**
     * The Tweets.
     */
    List<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * Add tweet.
     *
     * @param tweet the tweet
     */
    public void addTweet (Tweet tweet) {
        if (this.hasTweet(tweet)){
            throw new IllegalArgumentException("Tried to add a duplicate tweet");
        }
        tweets.add(tweet);
    }

    /**
     * Has tweet boolean.
     *
     * @param tweet the tweet
     * @return the boolean
     */
    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    /**
     * Gets tweet.
     *
     * @param i the
     * @return the tweet
     */
    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    /**
     * Remove tweet.
     *
     * @param a the a
     */
    public void removeTweet(Tweet a) {
        tweets.remove(a);
    }

    /**
     * Gets tweets.
     *
     * @return the tweets
     */
    public List<Tweet> getTweets() {
        Collections.sort(tweets);
        return tweets;
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    public int getCount() {
        return tweets.size();
    }
}
