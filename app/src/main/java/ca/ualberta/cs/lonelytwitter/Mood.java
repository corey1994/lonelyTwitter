package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Corey on 2016-09-13.
 */
public abstract class Mood {
    protected Date date;
    protected String moodMessage;

    public Mood() {
        this.date = new Date(); // According to Java docs (https://docs.oracle.com/javase/7/docs/api/java/util/Date.html)
                                // this initializes date objecct with the current date
    }

    public Mood(Date date) {
        this.date = date;       // Use the user-supplied date
    }

    public abstract String currentMood();

    public Date getDate() {

        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
