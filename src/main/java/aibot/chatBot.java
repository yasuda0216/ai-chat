package aibot;

import org.goldrenard.jb.configuration.BotConfiguration;
import org.goldrenard.jb.configuration.LanguageConfiguration;
import org.goldrenard.jb.core.Bot;
import org.goldrenard.jb.core.Chat;

public class chatBot {

	final String defaultResponse = "私にはその答えがありません。";
	final String errorResponse = "私の脳に何か問題があります。";
	final String scheduleError = "そのイベントをスケジュールできません。";
	final String systemFailed = "システムコマンドの実行に失敗しました。";
	final String templateFailed = "テンプレートが失敗しました。";
	final String tooMuchRecursion = "AIMLの再帰が多すぎます。";
	final String tooMuchLooping = "AIMLのループが多すぎます。";

	final LanguageConfiguration language = LanguageConfiguration.builder()
			.defaultResponse(defaultResponse)
			.errorResponse(errorResponse)
			.scheduleError(scheduleError)
			.systemFailed(systemFailed)
			.templateFailed(templateFailed)
			.tooMuchRecursion(tooMuchRecursion)
			.tooMuchLooping(tooMuchLooping).build();

	final Bot bot = new Bot(BotConfiguration.builder()
			.name("alice")
			.path("src/main/resources")
			.jpTokenize(true)
			.language(language)
			.build());

	public final Chat chatSession = new Chat(bot);

	public String[] reply_chatText(String text, Chat chat) {
    	final var answer = chat.multisentenceRespond(text);
        String[] answers = answer.split(",");
    	return answers;
    }

	void chatText(String text, Chat chat) {

		final var answer = chatSession.multisentenceRespond(text);
		String[] answers = answer.split(",");

		for (int i = 0; i < answers.length; i++) {
			System.out.println("Bot:" + answers[i]);
		}
	}
}
