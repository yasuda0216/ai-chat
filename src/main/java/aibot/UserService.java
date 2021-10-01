package aibot;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class UserService {

	MongoClient client = MongoClients.create();
	// DBオブジェクトを取得する
    MongoDatabase db = client.getDatabase("morphia_example");
    // ユーザーコレクションを取得する
    MongoCollection<Document> users = db.getCollection("users");

}
