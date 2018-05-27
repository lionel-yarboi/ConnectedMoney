package support.utils;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

/**
 * Created by lionelyarboi on 24/04/2017.
 */
public class MongoDbAccount {

    private static Config config = ConfigurationFetcher.fetch();
    private MongoCollection<Document> accountCollection;

    public MongoDbAccount() {
        MongoSetup.connect(config);
        accountCollection = MongoSetup.getCollection("Account");
    }

    public void deleteAccount(String userId, boolean deleteAll) {
        if(deleteAll){
            accountCollection.deleteMany(eq("_p_user", "_User$"+userId));
        }
    }
}
