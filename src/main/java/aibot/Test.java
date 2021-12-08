package aibot;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {



		/*
		final Datastore datastore = Morphia.createDatastore( "morphia_example");
        // tell morphia where to find your classes
        // can be called multiple times with different packages or classes
        datastore.getMapper().mapPackage("aibot");
        // create the Datastore connecting to the database running on the default port on the local host
        //datastore.getDatabase().drop();
        datastore.ensureIndexes();

		Date date = new Date();
		LifelogService lifelogServ = new LifelogService();
		int i = 0;

		final Users users = new Users();
		users.setFirstname("kento");
		users.setLastname("yasuda");
		users.setUserID("000");
		datastore.save(users);

		final Employee elmer = new Employee();
		elmer.setName("kento");
		elmer.setSalary(10.0);
		elmer.setUser(users);
		datastore.save(elmer);
		*/

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
	}
}
