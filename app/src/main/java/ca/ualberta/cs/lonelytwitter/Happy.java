package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Corey on 2016-09-13.
 */
public class Happy extends Mood {

    public Happy() {
        super();
        this.moodMessage = "I'm happy!";

    }

    public Happy(Date date) {
        super(date);
        this.moodMessage = "I'm happy!";
        this.date = date;
    }


    public String currentMood() {
        return this.moodMessage + " :)";
    }

}
