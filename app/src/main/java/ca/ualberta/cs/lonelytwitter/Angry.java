package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Corey on 2016-09-13.
 */
public class Angry extends Mood {
    public Angry() {
        super();
        this.moodMessage = "I'm angry!!!";
    }

    public Angry(Date date) {
        super(date);
        this.moodMessage = "I'm angry!!!";
    }

    public String currentMood(){
        return this.moodMessage + " >:(";
    }

}
