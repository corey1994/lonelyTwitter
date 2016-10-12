package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class EditTweetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);

        Intent intent = getIntent();
        Tweet selectedTweet = (Tweet) intent.getSerializableExtra("selectedTweet");

        TextView editTweetEditText = (TextView) findViewById(R.id.editTweetEditText);
        editTweetEditText.setText(selectedTweet.getMessage());
    }
}
