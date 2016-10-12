package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    //Class that robotium uses for testing.
    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    //Runs before and after each test case
    public void setUp() throws Exception {
        Log.d("TAG1", "setUp()");
        solo = new Solo(getInstrumentation(),getActivity());
    }

    public void testTweet() {
        //REMEMBER THAT THE TESTS SHOULD CLEAN UP AFTER THEMSELVES, SO OUR TEST DATA ISN'T SHOWING
        //UP IN FINAL SUBMISSIONS

        solo.assertCurrentActivity("Wrong activity", LonelyTwitterActivity.class);

        //Clear any previous test data
        solo.clickOnButton("Clear");

        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet!");
        //Uses the text that's written on the button
        solo.clickOnButton("Save");

        solo.clearEditText((EditText) solo.getView(R.id.body));
        //Waits to see if that text shows up somewhere on the screen
        assertTrue(solo.waitForText("Test Tweet!"));


        solo.clickOnButton("Clear");
        assertFalse(solo.waitForText("Test Tweet!"));
    }


    public void testClickTweetList() {
        String message0 = "Test Tweet!";
        String message1 = "Testing another tweet";

        LonelyTwitterActivity activity = (LonelyTwitterActivity) solo.getCurrentActivity();

        solo.assertCurrentActivity("Wrong activity", LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");

        //Enter two new tweets
        solo.enterText((EditText) solo.getView(R.id.body), message0);
        solo.clickOnButton("Save");
        solo.clearEditText((EditText) solo.getView(R.id.body));
        solo.enterText((EditText) solo.getView(R.id.body), message1);
        solo.clickOnButton("Save");
        //wait for a moment before running other code
        solo.waitForText(message1);


        final ListView oldTweetsList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetsList.getItemAtPosition(0);
        assertEquals(message0, tweet.getMessage());

        solo.clickInList(1);
        solo.assertCurrentActivity("Wrong activity", EditTweetActivity.class);
        //Test whether we have sent the tweet to the new activity
        assertTrue(solo.waitForText(message0));
        solo.goBack();
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);

        solo.clickInList(2);
        solo.assertCurrentActivity("Wrong activity", EditTweetActivity.class);
        assertTrue(solo.waitForText(message1));
        solo.goBack();
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);

    }
}