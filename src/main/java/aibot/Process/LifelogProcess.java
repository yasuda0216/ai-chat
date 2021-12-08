package aibot.Process;

import java.util.ArrayList;
import java.util.List;

public class LifelogProcess {

	// 仮データの設定
	String when = "今日";
	String whom = null;
	String where = "学校";
	String target = "なにか";
	String experiencer = "私";
	String aspect = "なにかのなにか";
	String action = "勉強する";
	Double polarity = 0.0;
	Double polarityConf = 0.0;
	List<String> polarityTerms = new ArrayList<String>();


	// Whenスロットの抽出
	public String extractWhen(String uesrUtterance) {

		/*
		 * ここに処理を書く
		 */
		return when;
	}

	// Targetスロットの抽出
	public String extractTarget(String uesrUtterance) {

		/*
		 * ここに処理を書く
		 */
		return target;
	}

	// Whereスロットの抽出
	public String extractWhere(String uesrUtterance) {

		/*
		 * ここに処理を書く
		 */
		return where;
	}

	// Whomスロットの抽出
	public String extractWhom(String uesrUtterance) {

		/*
		 * ここに処理を書く
		 */
		return whom;
	}

	// Experiencerスロットの抽出
	public String extractExperiencer(String uesrUtterance) {

		/*
		 * ここに処理を書く
		 */
		return experiencer;
	}

	// Aspectスロットの抽出
	public String extractAspect(String userUtterance) {

		/*
		 * ここに処理を書く
		 */
		return aspect;
	}

	// Actionスロットの抽出
	public String extractAction(String userUtterance) {

		/*
		 * ここに処理を書く
		 */
		return action;
	}

	// Polarityスロットの推定
	public Double estimatePolarity(String uesrUtterance) {

		/*
		 * ここに処理を書く
		 */
		return polarity;
	}

	// PolarityConfスロットの推定
	public Double estimatePolarityConf(String uesrUtterance) {

		/*
		 * ここに処理を書く
		 */
		return polarityConf;
	}

	// PolarityTermsスロットの抽出
	public List<String> extractPolarityTerms(String userUtterance){

		/*
		 * ここに処理を書く
		 */
		return polarityTerms;
	}
}
