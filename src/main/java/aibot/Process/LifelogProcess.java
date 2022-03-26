package aibot.Process;

import com.fasterxml.jackson.databind.JsonNode;


public class LifelogProcess {

	// 仮データの設定
	/*
	String when = "今日";
	String whom = null;
	String where = "学校";
	String target = "なにか";
	String experiencer = "私";
	String aspect = "なにかのなにか";
	String action = "勉強する";
	Double polarity = 0.0;

	List<String> polarityTerms = new ArrayList<String>();
	*/

	// Whenスロットの抽出
	public String extractWhen(JsonNode userUtterance) {

		int len = userUtterance.get("when").toString().length();
		var when = userUtterance.get("when").toString().substring(1,len-1);
		return when;
	}

	// Targetスロットの抽出
	public String extractTarget(JsonNode userUtterance) {

		int len = userUtterance.get("target").toString().length();
		var target = userUtterance.get("target").toString().substring(1,len-1);
		return target;
	}

	// Whereスロットの抽出
	public String extractWhere(JsonNode userUtterance) {

		int len = userUtterance.get("where").toString().length();
		var where = userUtterance.get("where").toString().substring(1,len-1);
		return where;
	}

	// Whomスロットの抽出
	public String extractWhom(JsonNode userUtterance) {

		int len = userUtterance.get("whom").toString().length();
		var whom = userUtterance.get("whom").toString().substring(1,len-1);
		return whom;
	}

	// Experiencerスロットの抽出
	public String extractExperiencer(JsonNode userUtterance) {

		int len = userUtterance.get("experiencer").toString().length();
		var experiencer = userUtterance.get("experiencer").toString().substring(1,len-1);
		return experiencer;
	}

	// Aspectスロットの抽出
	public String extractAspect(JsonNode userUtterance) {

		int len = userUtterance.get("aspect").toString().length();
		var aspect = userUtterance.get("aspect").toString().substring(1,len-1);
		return aspect;
	}


	// Polarityスロットの推定
	public String estimatePolarity(JsonNode userUtterance) {

		/*
		 * ここに処理を書く
		 */
		int len = userUtterance.get("polarity").toString().length();
		var polarity = userUtterance.get("polarity").toString().substring(1,len-1);
		return polarity;
	}

	// PolarityConfスロットの推定

	/*
	public Double estimatePolarityConf(JsonNode userUtterance) {


		return polarityConf;
	}
    */

	// PolarityTermsスロットの抽出
	public String extractPolarityTerms(JsonNode userUtterance){

		int len = userUtterance.get("polarityTerm").toString().length();
		var polarityTerm = userUtterance.get("polarityTerm").toString().substring(1,len-1);
		return polarityTerm;

	}

	// チャットボットの返答
	public String chatbotResponse(JsonNode userUtterance){

		int len = userUtterance.get("response").toString().length();
		var response = userUtterance.get("response").toString().substring(1,len-1);
		return response;
	}

	// スタンプの推定
	public String chatbotStamp(JsonNode userUtterance){

		int len = userUtterance.get("stamp").toString().length();
		var stamp = userUtterance.get("stamp").toString().substring(1,len-1);
		return stamp;
	}



}
