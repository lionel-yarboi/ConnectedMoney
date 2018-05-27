package support.utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class MongoSetup {

    private static MongoClient mongoClient;
    private static String db;

    public static MongoClient connect(Config config){
        db = config.getMongoDbName();
        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
        mongoClient = new MongoClient(new MongoClientURI(config.getMongoUrl(), builder));
        return mongoClient;
    }

    public static MongoCollection<Document> getCollection(String collectionName){
        return mongoClient.getDatabase(db).getCollection(collectionName);
    }

}
