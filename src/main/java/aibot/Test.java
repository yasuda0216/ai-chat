package aibot;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import dev.morphia.Datastore;
import dev.morphia.Morphia;
import dev.morphia.query.Query;

public class Test {

	public static void main(String[] args) {
		/*
		chatBot chat = new chatBot();
		var chatSession = chat.chatSession;

		final var scanner = new Scanner(System.in); // Scannerで初期化
		System.out.println("Bot:「きっくんとおしゃべりする」　「きっくんに相談する」　「相談窓口につなぐ」の中から選んでね！");
		while (true) {

		    final var text = scanner.next(); // 文字列の入力の受け取り
		    System.out.println("貴方:" + text);
		    if (text.contains("バイバイ")) {
		        scanner.close();
		        return;
		    }

		    chat.chatText(text,chatSession);
		}
		*/

		final Datastore datastore = Morphia.createDatastore("morphia_example");
		datastore.getMapper().mapPackage("aibot");

		// create the Datastore connecting to the database running on the default port on the local host
		datastore.getDatabase().drop();
		datastore.ensureIndexes();

		MongoClient client = MongoClients.create();
		// DBオブジェクトを取得する
		MongoDatabase db = client.getDatabase("morphia_example");
		// ユーザーコレクションを取得する
		MongoCollection<Document> emps = db.getCollection("employees");

		UserService usersServ = new UserService();

		Document user = new Document();
		user.append("name", "tanaka");
		user.append("waga", 10);

		emps.insertOne(user);

		final Lifelog logging = new Lifelog();
		logging.setExperiencer("kento");
		logging.setPolarity(2.0);
		logging.setTarget("ピザ");
		logging.setWhen("今日");
		datastore.save(logging);

		final Users users = new Users();
		users.setFirstname("kento");
		users.setLastname("yasuda");
		users.setUserID("000");
		datastore.save(users);

		final Employee elmer = new Employee();
		elmer.name = "kento";
		elmer.salary = 10.0;
		elmer.user = users;

		datastore.save(elmer);

		List<Document> emp = emps.find(Filters.in("name", "kento")).into(new ArrayList<Document>());
		if (emp == null || emp.size() == 0) {
			System.out.println("ないよ");
		} else {
			System.out.println("あるよ");
		}

		System.out.println(emp);
		final Query<Employee> query = datastore.find(Employee.class);

		final Employee employees = query.first();
		/*
		final Query<Employee> query = datastore.find(Employee.class);
		for (Employee employee : query.asList()) {
		    System.out.println("oid      :" + employee.id);
		    System.out.println("personid :" + employee.salary);
		    System.out.println("name     :" + employee.name);
		  }
		*/
		client.close();
	}
}
