package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by watts1 on 9/13/16.
 */
public class NormalTweet extends Tweet implements Tweetable {

    /**
     * This constructor makes a NormalTweet with the given string parameter
     *
     * @param message this parameter is the given string for the tweet.
     */
    public NormalTweet(String message){
        super(message);
    }

    /**
     * Instantiates a new Normal tweet.
     *
     * @param message to use for the tweet
     * @param date    the tweet date
     */
    public NormalTweet(String message, Date date) {
       super(message, date);
    }

    /**
     * This class is never important, so this method always returns FALSE.
     *
     * @return Boolean.FALSE
     */
    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
