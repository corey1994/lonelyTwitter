package ca.ualberta.cs.lonelytwitter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by watts1 on 9/13/16.
 *
 * This is our base class for the different types of tweets.
 *
 * Overrides the compareTo method, to compare tweets based on date.
 *
 * @see ImportantTweet
 * @see NormalTweet
 */
public abstract class Tweet implements Comparable<Tweet>, Serializable {
    private String message;
    private Date date;

    /**
     * Instantiates a new Tweet.
     *
     * @param message message to store in the tweet
     */
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    /**
     * Instantiates a new Tweet.
     *
     * @param message message to store in the tweet
     * @param date    the date the tweet was created
     */
    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }


    /**
     * This method tells the caller whether the tweet is important or not.
     * Each extending class should specify whether it is important.
     *
     * @return Boolean
     */
    public abstract Boolean isImportant();


    /**
     * Stores a new message in the tweet.
     *
     * @param message the message
     * @throws TweetTooLongException if the tweet is longer than 140 characters
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            //Do something
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * Stores a new date in the tweet in case the previous date was incorrect.
     *
     * @param date the new date for the tweet
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    @Override
    public String toString(){
        return  date.toString() + " | " + message;
    }


    //Idea for CompareTo taken from "Yura Vasylenko" http://stackoverflow.com/questions/16252269/how-to-sort-a-list-arraylist-in-java
    //Learned how to compare dates from "Bart Kiers" http://stackoverflow.com/questions/2592501/how-to-compare-dates-in-java

    /**
     * Specifies that Tweets are to be compared based on their stored date.
     * @param anotherTweet
     * @return
     */
    public int compareTo(Tweet anotherTweet) {
        return this.getDate().compareTo(anotherTweet.getDate());
    }
}
