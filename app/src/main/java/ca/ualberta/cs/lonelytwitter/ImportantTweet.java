package ca.ualberta.cs.lonelytwitter;

/**
 * Created by watts1 on 9/13/16.
 */
public class ImportantTweet extends Tweet {

    /**
     * Instantiates a new Important tweet.
     *
     * @param message message used for the tweet
     */
    public ImportantTweet(String message){
        super(message);
    }

    /**
     *Overrides the isImportant method from the Tweet class.
     * Because this is an ImportantTweet, it always returns TRUE
     *
     * @return Boolean.TRUE
     */
    @Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }

}
