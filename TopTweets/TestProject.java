import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Gabriel on 4/16/2016.
 */
public class TestProject {
    private static final String CONSUMER_KEY = "2nxig9dVaZ91MIFQIZenRlSs1";
    private static final String CONSUMER_SECRET = "PrFp0fvkrgEfYqlC77fNLWeFi8Pnp4y20ffAyYgnRFJYl2UR5n";
    private static final String ACCESS_TOKEN = "2285648102-3Cfku8erEsTGcEmnzV7Dm6QkFCKwYRh8H5aBLNE";
    private static final String ACCESS_TOKEN_SECRET = "8smEFpagIs45ajckdKfI4khuNfeBmtvFiLqFX9KEJAlZn";

    public static void main(String[] args) throws IOException, TwitterException{
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(CONSUMER_KEY)
                .setOAuthConsumerSecret(CONSUMER_SECRET)
                .setOAuthAccessToken(ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        Paging p = new Paging();
        p.setCount(800);
        List<Status> timeline = twitter.getHomeTimeline(p);
        LinkedHashMap<Status, Integer> status = new LinkedHashMap<>();
        for (Status entry : timeline) {
            if(!entry.isRetweet()) {
                status.put(entry, entry.getFavoriteCount());
            }
        }
        Timeline tl = new Timeline(status);
        tl.ascendingSort();
        //tl.descendingSort();
        System.out.println(tl.print());
    }
}