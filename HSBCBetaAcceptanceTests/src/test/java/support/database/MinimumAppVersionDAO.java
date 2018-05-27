package support.database;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MinimumAppVersionDAO extends DatabaseDAO {

    private static final String MINIMUM_APP_VERSION = "minAppVersion";

    public MinimumAppVersionDAO(MongoTemplate mongoTemplate) {
        super(mongoTemplate);
    }

    public int updateMinimumAppVersion(String appVersion) {
        return updateField(MINIMUM_APP_VERSION,new ObjectId("59e76449f11bb805fb00041b"),"version",appVersion);
    }
}
