package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by watts1 on 9/13/16.
 */
public abstract class Tweet implements Comparable<Tweet> {
    private String message;
    private Date date;

    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }


    public abstract Boolean isImportant();




    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            //Do something
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString(){
        return  date.toString() + " | " + message;
    }


    //Idea for CompareTo taken from "Yura Vasylenko" http://stackoverflow.com/questions/16252269/how-to-sort-a-list-arraylist-in-java
    //Learned how to compare dates from "Bart Kiers" http://stackoverflow.com/questions/2592501/how-to-compare-dates-in-java
    public int compareTo(Tweet anotherTweet) {
        return this.getDate().compareTo(anotherTweet.getDate());
    }
}
