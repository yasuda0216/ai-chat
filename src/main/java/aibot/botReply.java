package aibot;
import org.goldrenard.jb.configuration.BotConfiguration;
import org.goldrenard.jb.configuration.LanguageConfiguration;
import org.goldrenard.jb.core.Bot;
import org.goldrenard.jb.core.Chat;

public class botReply{

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

	void chatText(String text, Chat chat) {

	            final var answer = chat.multisentenceRespond(text);
	            String[] answers = answer.split(",");

	            for (int i = 0; i < answers.length; i++) {
	              System.out.println("Bot:"  + answers[i]);
	            }
	 }
}
