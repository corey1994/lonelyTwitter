/*
 * Copyright (c) 2016 Team 20, CMPUT301, University of Alberta - All Rights Reserved
 * You may use, distribute, and copy all or partsof this code under terms of the
 * University of Alberta and the Code of Student Behaviour.
 * You can find the copy of the licence at http://www.github.com/Team20/...
 * For further information, contact me at abc@abc.ca
 */

package ca.ualberta.cs.lonelytwitter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * This is the main view class of the LonelyTwitter application.  It handles all user
 * interactions, as well as file manipulations.
 * <p>
 * <pre> All of the files are ".json" format, and are stored in the emulator, accessible
 * from Android Device Monitor </pre>
 * <code> Pseudo code sample:
 * open some file ...
 * attach some text ...
 * close the file.</code>
 * <ul>
 * <li>an item</li>
 * <li>another item</li>
 * <li>yet another item</li>
 * </ul>
 *
 * @author Corey
 * @see NormalTweet
 * @see Tweet
 * @see ImportantTweet
 * @since 1.0
 */
public class LonelyTwitterActivity extends Activity {

    private Activity activity = this;

    /**
     * This is the file name that is being saved / loaded and contains all the tweets.
     * @see #loadFromFile()
     * @see #saveInFile()
     */
    private static final String FILENAME = "file.sav";
    private EditText bodyText;
    private ListView oldTweetsList;

    private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();

    private ArrayAdapter<Tweet> adapter;

    public ListView getOldTweetsList() {
        return oldTweetsList;
    }
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    /**
     * Called when the activity is first created.
     *
     * Sets up the UI, creates button listeners, etc.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bodyText = (EditText) findViewById(R.id.body);
        Button saveButton = (Button) findViewById(R.id.save);
        Button clearButton = (Button) findViewById(R.id.clear);
        oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                String text = bodyText.getText().toString();

                Tweet newTweet = new NormalTweet(text);

                tweetList.add(newTweet);
                adapter.notifyDataSetChanged();

                saveInFile();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                tweetList.clear();
                adapter.notifyDataSetChanged();
                saveInFile();
            }

        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();


        oldTweetsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(activity, EditTweetActivity.class);
                intent.putExtra("selectedTweet", tweetList.get(position));
                startActivity(intent);
            }
        });
    }


    /**
     * Run when the app starts.
     *
     * Loads from the file, sets the array adapter, etc.
     */
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        try {
            loadFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        adapter = new ArrayAdapter<Tweet>(this,
                R.layout.list_item, tweetList);
        oldTweetsList.setAdapter(adapter);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "LonelyTwitter Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://ca.ualberta.cs.lonelytwitter/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }


    /**
     * This methods loads from FILE_NAME (file.sav)
     *
     * @throws FileNotFoundException
     */
    private void loadFromFile() throws FileNotFoundException{
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            // Code from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            Type listType = new TypeToken<ArrayList<NormalTweet>>() {
            }.getType();

            tweetList = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            tweetList = new ArrayList<Tweet>();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

    /**
     * Uses a BufferedWriter and the Gson class to save the application state to file.
     *
     * @throws FileNotFoundException
     * @throws RuntimeException
     */
    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    0);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(tweetList, out);
            out.flush();

            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

    /**
     * Called when the app stops.  Takes care of cleaning things up.
     */
    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "LonelyTwitter Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://ca.ualberta.cs.lonelytwitter/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}