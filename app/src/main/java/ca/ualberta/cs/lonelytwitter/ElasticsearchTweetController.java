package ca.ualberta.cs.lonelytwitter;

/**
 * Created by Corey on 2016-10-18.
 */

public class ElasticsearchTweetController {
    private static JestDroidClient client;

    public static class AddTweetsTask extends AsyncTask<NormalTweet, Void, Void> {

    }

    private static void verifySettings() {
        if(client==null) {
            DroidClientConfig.Builder builder = new DroidClientConfig.Builder("http://cmput301.softwarepfocess.es:8080");
            DroidClientConfig config = builder.build();

            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig();
        }
    }
}
