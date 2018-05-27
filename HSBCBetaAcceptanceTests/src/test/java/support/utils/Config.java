package support.utils;

/**
 * Created by 44022795 on 28/03/2017.
 */
public class Config {
    private String mongoUrl;
    private String mongoDbName;

    public Config(String mongoUrl, String mongoDbName) {
        this.mongoUrl = mongoUrl;
        this.mongoDbName = mongoDbName;
    }

    public String getMongoUrl() {
        return mongoUrl;
    }

    public String getMongoDbName() {
        return mongoDbName;
    }
}
