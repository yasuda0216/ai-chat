package aibot.Service;

import java.util.List;

import aibot.model.Users;
import dev.morphia.Datastore;

public class UserService {

	/// Lifelogドキュメントの追加
		public void addlog(Datastore ds, String userText, List<String> botRes, String userId, List<String> imageRes, long idNum) {

			Users user = new Users();
			//Date date = new Date();
			//String polarityConf = "NIL";

			user.setBotRes(botRes);
			user.setUserRes(userText);
			user.setUserID(userId);
			user.setImageRes(imageRes);
			user.setIdNum(idNum);
			user.setBotType("withStamp");

			ds.save(user);
		}
}
