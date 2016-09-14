package ca.ualberta.cs.lonelytwitter;

/**
 * Created by Corey on 2016-09-13.
 */
public class ImportantTweet extends Tweet{
    public ImportantTweet(String message){
        super(message);
    }

    @Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }
}
