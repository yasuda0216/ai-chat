package aibot;

import java.util.Date;
import java.util.Scanner;

import aibot.Service.LifelogService;
import dev.morphia.Datastore;
import dev.morphia.Morphia;

public class Test {

	public static void main(String[] args) {



		// Morphiaの宣言
		final Datastore datastore = Morphia.createDatastore( "morphia_example");
        datastore.getMapper().mapPackage("aibot");
        datastore.ensureIndexes();

		Date date = new Date();
		LifelogService lifelogServ = new LifelogService();
		int i = 0;





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
