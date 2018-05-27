package support.utils;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 * Created by lionelyarboi on 20/05/2017.
 */
public class MongoDbUser {

    private static Config config = ConfigurationFetcher.fetch();
    private MongoCollection<Document> userCollection;

    public MongoDbUser() {
        MongoSetup.connect(config);
        userCollection = MongoSetup.getCollection("_User");
    }

    public void deletePreferences(){

    }
}
