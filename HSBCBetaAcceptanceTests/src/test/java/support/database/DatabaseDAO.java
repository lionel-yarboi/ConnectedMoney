package support.database;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public abstract class DatabaseDAO {

    @Autowired
    MongoTemplate mongoTemplate;

    public DatabaseDAO(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void dropDatabase(String collectName) {
        mongoTemplate.getCollection(collectName).drop();
    }

    public void insert(final List<Document> documents) {
        mongoTemplate.insert(documents);
    }

    public int updateField(String collectionName, Object id, String fieldName, Object fieldValue) {
        WriteResult writeResult = mongoTemplate.getCollection(collectionName).update(
                new BasicDBObject().append("_id", id),
                new BasicDBObject().append("$set", new BasicDBObject(fieldName, fieldValue)));
        return writeResult.getN();
    }

    public void deleteByCustomerId(String customerId, String collectionName) {
        mongoTemplate.getCollection(collectionName).findAndRemove((DBObject) eq("customer", customerId));
    }

}
