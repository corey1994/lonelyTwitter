package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Corey on 2016-09-27.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {


    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testGetTweets() {
        TweetList list = new TweetList();
        List<Tweet> returnedList = list.getTweets();
        assertFalse(returnedList.size()>0);

        Tweet a = new NormalTweet("Hello!", new Date("January 10, 2016"));
        Tweet b = new NormalTweet("Hi!", new Date("January 11, 2016"));

        list.addTweet(b);
        list.addTweet(a);

        returnedList = list.getTweets();
        assertTrue(returnedList.size()>0);
        assertEquals(a,returnedList.get(0));
    }

    public void testGetCount() {
        TweetList list = new TweetList();
        assertEquals(0,list.getCount());

        Tweet a = new NormalTweet("Hello!");
        Tweet b = new NormalTweet("Hi!");

        list.addTweet(a);
        list.addTweet(b);
        assertEquals(2,list.getCount());
    }


    public void testAddTweet() {
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hello!");
        list.addTweet(tweet);
        assertTrue(list.hasTweet(tweet));

        try {
            list.addTweet(tweet);
            fail();
        }
        catch (IllegalArgumentException e) {
            //The test passed!
        }

    }

    public void testHasTweet(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("Hello!");
        assertFalse(list.hasTweet(tweet));

        list.addTweet(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testGetTweet() {
        TweetList list = new TweetList();
        Tweet a = new NormalTweet("Hello!");
        Tweet b = new NormalTweet("Hi!");

        list.addTweet(a);
        list.addTweet(b);

        assertEquals(a, list.getTweet(0));
        assertEquals(b, list.getTweet(1));
    }

    public void testRemoveTweet() {
        TweetList list = new TweetList();
        Tweet a = new NormalTweet("Hello!");

        list.addTweet(a);
        assertTrue(list.hasTweet(a));

        list.removeTweet(a);
        assertFalse(list.hasTweet(a));
    }
}
