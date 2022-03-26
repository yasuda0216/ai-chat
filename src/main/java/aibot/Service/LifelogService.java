package aibot.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.databind.JsonNode;

import aibot.HttpURLConnectionExample;
import aibot.Process.LifelogProcess;
import aibot.model.Lifelog;
import dev.morphia.Datastore;
import dev.morphia.query.FindOptions;
import dev.morphia.query.Query;
import dev.morphia.query.Sort;
import dev.morphia.query.experimental.filters.Filters;

public class LifelogService {


	LifelogProcess lifelogProcess = new LifelogProcess();
	HttpURLConnectionExample http = new HttpURLConnectionExample();


	/// Lifelogドキュメントの追加
	public void addLifelog(Datastore ds, String userText, JsonNode userUtterance, String userId, JsonNode polarity,long idNum) {

		Lifelog lifelog = new Lifelog();
		Date date = new Date();
		String polarityConf = "NIL";
		String polarityHow = "NIL";

		lifelog.setUsersSentence(userText);
		lifelog.setAspect(lifelogProcess.extractAspect(userUtterance));
		lifelog.setCreateDate(date);
		lifelog.setExperiencer(lifelogProcess.extractExperiencer(userUtterance));
		lifelog.setPolarity(lifelogProcess.estimatePolarity(polarity));
		lifelog.setPolarityConf(polarityConf);
		lifelog.setTarget(lifelogProcess.extractTarget(userUtterance));
		lifelog.setUpdateDate(date);
		lifelog.setUserID(userId);
		lifelog.setWhen(lifelogProcess.extractWhen(userUtterance));
		lifelog.setWhere(lifelogProcess.extractWhere(userUtterance));
		lifelog.setWhom(lifelogProcess.extractWhom(userUtterance));
		//lifelog.setResponse(lifelogProcess.chatbotResponse(userUtterance));
		lifelog.setStamp(lifelogProcess.chatbotStamp(userUtterance));
		lifelog.setIdNumber(idNum);
		lifelog.setPolarity_how(polarityHow);
		lifelog.setBotType("withStamp");

		ds.save(lifelog);

	}
    /// userIDと一致するライフログが存在するかどうか
	public long confirmUserId(Datastore ds, String userId) {
		final Query<Lifelog> query = ds.find(Lifelog.class).filter(Filters.eq("userID", userId));
		long count = query.count();

		return count;
	}

	public long countAll(Datastore ds,String userId) {
		long count = ds.find(Lifelog.class).filter(Filters.eq("userID", userId)).count();
		return count;
	}

	///  更新するLifelogドキュメントを検索
	public Lifelog getUpdateLifelog(Datastore ds, String userId) {

		// userIDで検索
		final Query<Lifelog> query = ds.find(Lifelog.class).filter(Filters.eq("userID", userId));

		// 更新時間でソート
		final var options = new FindOptions().limit(1).sort(Sort.descending("create_date"));
		Lifelog updateLifelog = query.first(options);
		return updateLifelog;
	}



	/*
	 * 各スロットの更新
	 */

	/// Targetスロットの更新
	public void updateTarget(Datastore ds, String updateTarget, String userId) {
		Date upDate = new Date();
		Lifelog updateLifelog = getUpdateLifelog(ds, userId);
		updateLifelog.setTarget(updateTarget);
		updateLifelog.setUpdateDate(upDate);
		ds.save(updateLifelog);
	}

	/// Aspectスロットの更新
	public void updateAspect(Datastore ds, String updateAspect, String userId) {
		Date upDate = new Date();
		Lifelog updateLifelog = getUpdateLifelog(ds, userId);
		updateLifelog.setAspect(updateAspect);
		updateLifelog.setUpdateDate(upDate);
		ds.save(updateLifelog);
	}

	/// Experiencerスロットの更新
	public void updateExperiencer(Datastore ds, String updateExperiencer, String userId) {
		Date upDate = new Date();
		Lifelog updateLifelog = getUpdateLifelog(ds, userId);
		updateLifelog.setExperiencer(updateExperiencer);
		updateLifelog.setUpdateDate(upDate);
		ds.save(updateLifelog);
	}

	/// Polarityスロットの更新
	public void updatePolarity(Datastore ds, String updatePolarity, String userId) {
		Date upDate = new Date();
		Lifelog updateLifelog = getUpdateLifelog(ds, userId);
		updateLifelog.setPolarity(updatePolarity);
		updateLifelog.setUpdateDate(upDate);
		ds.save(updateLifelog);
	}

	/// Polarity_howスロットの更新
		public void updatePolarityHow(Datastore ds, String updatePolarityHow, String userId) {
			Date upDate = new Date();
			Lifelog updateLifelog = getUpdateLifelog(ds, userId);
			updateLifelog.setPolarity_how(updatePolarityHow);
			updateLifelog.setUpdateDate(upDate);
			ds.save(updateLifelog);
		}

	/// PolarityTermsスロットの更新
	public void updatePolarityTerms(Datastore ds, String updatePolarityTerms, String userId) {
		Date upDate = new Date();
		Lifelog updateLifelog = getUpdateLifelog(ds, userId);
		updateLifelog.setPolarityTerms(updatePolarityTerms);
		updateLifelog.setUpdateDate(upDate);
		ds.save(updateLifelog);
	}

	/// PolarityConfスロットの更新
	public void updatePolarityConf(Datastore ds, String updatePolarityConf, String userId) {
		Date upDate = new Date();
		Lifelog updateLifelog = getUpdateLifelog(ds, userId);
		updateLifelog.setPolarityConf(updatePolarityConf);
		updateLifelog.setUpdateDate(upDate);
		ds.save(updateLifelog);
	}

	/// Whenスロットの更新
	public void updateWhen(Datastore ds, String updateWhen, String userId) {
		Date upDate = new Date();
		Lifelog updateLifelog = getUpdateLifelog(ds, userId);
		int len = updateWhen.length();
		var when = updateWhen.substring(1, len-1);
		updateLifelog.setWhen(when);
		updateLifelog.setUpdateDate(upDate);
		ds.save(updateLifelog);
	}

	/// Whomスロットの更新
	public void updateWhom(Datastore ds, String updateWhom, String userId) {
		Date upDate = new Date();
		Lifelog updateLifelog = getUpdateLifelog(ds, userId);
		int len = updateWhom.length();
		var whom = updateWhom.substring(1, len-1);
		updateLifelog.setWhom(whom);
		updateLifelog.setUpdateDate(upDate);
		ds.save(updateLifelog);
	}

	/// Whereスロットの更新
	public void updateWhere(Datastore ds, String updateWhere, String userId) {
		Date upDate = new Date();
		Lifelog updateLifelog = getUpdateLifelog(ds, userId);
		int len = updateWhere.length();
		var where = updateWhere.substring(1, len-1);
		updateLifelog.setWhere(where);
		updateLifelog.setUpdateDate(upDate);
		ds.save(updateLifelog);
	}


	/*
	 * 空のスロットを検索
	 */

	/// Experiencerスロットが空かどうか確認する
	public void checkExperiencer(Datastore ds, String userId, List<String> list, String text, int[] flag) {
		String str=getUpdateLifelog(ds, userId).getExperiencer();
		if (str.equals("NIL")) {
			//list.add("それは誰が体験した出来事なの？");
			var res = http.getResponse("User:" + text +",Qtype:who");
			int len_res = res.get("question").toString().length();
			var result = res.get("question").toString().substring(1, len_res-1);
			list.add(result);

		} else {
			checkWhen(ds, userId,list,text,flag);
		}
	}

	/// Whenスロットが空かどうか確認する
	public void checkWhen(Datastore ds, String userId, List<String> list, String text, int[] flag) {
		String str=getUpdateLifelog(ds, userId).getWhen();
		if (str.equals("NIL") && flag[0] == 0){
			//list.add("それはいつの出来事なの？");
			flag[0] = 1;
			var res = http.getResponse("User:" + text +",Qtype:when");
			int len_res = res.get("question").toString().length();
			var result = res.get("question").toString().substring(1, len_res-1);
			list.add(result);
		} else{
			checkWhere(ds,userId,list,text,flag);
		}
	}

	public void checkWhere(Datastore ds, String userId, List<String> list, String text, int[] flag) {
		String str=getUpdateLifelog(ds, userId).getWhere();
		if (str.equals("NIL") && flag[1] == 0) {
			//list.add("それはどこで体験した出来事なの？");
			flag[1] = 1;
			var res = http.getResponse("User:" + text +",Qtype:where");
			int len_res = res.get("question").toString().length();
			var result = res.get("question").toString().substring(1, len_res-1);
			list.add(result);
		} else {
			checkWhom(ds, userId,list,text,flag);
		}
	}

	/// Whomスロットが空かどうか確認する
	public void checkWhom(Datastore ds, String userId, List<String> list, String text, int[] flag) {
		String str=getUpdateLifelog(ds, userId).getWhom();
		if (str.equals("NIL") && flag[2] == 0){
			flag[2] = 1;
			var res = http.getResponse("User:" + text +",Qtype:whom");
			int len_res = res.get("question").toString().length();
			var result = res.get("question").toString().substring(1, len_res-1);
			list.add(result);
		} else {
			checkPolarityConf(ds,userId,list,text,flag);
		}
	}

	public void checkPolarityConf(Datastore ds, String userId,List<String> list, String text, int[] flag) {
		String str = getUpdateLifelog(ds, userId).getPolarityConf();

		// 自己開示をするかを制御する変数
		int selfOpen = 1;

		if(str.equals("NIL")) {
			var res = http.getResponse("User:" + text +",Qtype:how");
			int len_res = res.get("question").toString().length();
			var result = res.get("question").toString().substring(1, len_res-1);
			list.add(result);
		} else {
			selfopenRes(list, selfOpen,flag);
		}
	}

	// 自己開示を返答する
	public void selfopenRes(List<String> list, int selfopen_flag, int[] flag) {

		for(int i=0; i<flag.length; i++) {
			flag[i] =0;
		}

		if(selfopen_flag == 0) {
			List<String> selfopen = new ArrayList<String>();
			String br = System.getProperty("line.separator");
			//selfopen.add("他に何か出来事があったら教えてほしいな！");
			selfopen.add("そういえば最近、星に帰りたくて寂しくなることがあるんだよね。"+br+"君は寂しく思ったこととか最近あったりした？");
			selfopen.add("そういえば今日、僕の宇宙船が隕石にぶつかりかけて死ぬかと思ったよ！" +br+ "君も最近びっくりしたことあったりした？");
			selfopen.add("そういえば最近、学校からの宿題が多すぎてしんどすぎるんだよね。" +br+ "君は最近、学校で何かあったりした？");
			selfopen.add("そういえば僕の国では1年に一度みんなでお祭りをするんだ！" +br+ "君の周りでも何か楽しい事あったりするの？");
			selfopen.add("地球ではいまコロナが流行ってるんだってね" +br+ "最近，体の調子は大丈夫かい？");
			Random rand = new Random();
		    String selfopen_res = selfopen.get(rand.nextInt(selfopen.size()));
			list.add(selfopen_res);
		} else {
			list.add("話を聞かせてくれてありがとう！");
			list.add("よかったら他にもあったこと教えてほしいな！");
		}
	}

	public void generateLifelogAizuti(List<String> list, String polarity, String text) {
		double polarity_val = Double.parseDouble(polarity);
		String[] aizuti_low = {"sympathy", "repeat", "simple"};
		String[] aizuti_high = {"sympathy"}; //sympathy,simple
		if(-0.20 < polarity_val && polarity_val < 0.20) {
			Random rand = new Random();
			String aizuti_res1 = aizuti_low[rand.nextInt(aizuti_low.length)];
			var res = http.getAizuti("User:" + text + ",Type:" + aizuti_res1 + ",Polarity:" + polarity);
			if(res == null) {
				System.out.println("aizutiAPIでエラー");
			}
			int len_res = res.get("aizuti").toString().length();
			var result = res.get("aizuti").toString().substring(1, len_res-1);
			list.add(result);
		}else {
			Random rand = new Random();
			String aizuti_res2 = aizuti_high[rand.nextInt(aizuti_high.length)];
			var res = http.getAizuti("User:" + text + ",Type:" + aizuti_res2 + ",Polarity:" + polarity);
			if(res == null) {
				System.out.println("aizutiAPIでエラー");
			}
			int len_res = res.get("aizuti").toString().length();
			var result = res.get("aizuti").toString().substring(1, len_res-1);
			list.add(result);
		}
	}

	public void generateQuestionAizuti(List<String> list, String polarity, String text) {
		double polarity_val = Double.parseDouble(polarity);
		String[] aizuti_low = {"repeat", "simple"};
		String[] aizuti_high = {"sympathy"}; //sympathy,simple
		if(-0.20 < polarity_val && polarity_val < 0.20) {
			Random rand = new Random();
			String aizuti_res1 = aizuti_low[rand.nextInt(aizuti_low.length)];
			var res = http.getAizuti("User:" + text + ",Type:" + aizuti_res1 + ",Polarity:" + polarity);
			if(res == null) {
				System.out.println("aizutiAPIでエラー");
			}
			int len_res = res.get("aizuti").toString().length();
			var result = res.get("aizuti").toString().substring(1, len_res-1);
			list.add(result);
		}else {
			Random rand = new Random();
			String aizuti_res2 = aizuti_high[rand.nextInt(aizuti_high.length)];
			var res = http.getAizuti("User:" + text + ",Type:" + aizuti_res2 + ",Polarity:" + polarity);
			if(res == null) {
				System.out.println("aizutiAPIでエラー");
			}
			int len_res = res.get("aizuti").toString().length();
			var result = res.get("aizuti").toString().substring(1, len_res-1);
			list.add(result);
		}
	}


	public String checkExperiencer(Datastore ds, String userId) {

		String str=getUpdateLifelog(ds, userId).getExperiencer();
		if (str.equals("NIL")) {
			return "No_experiencer";
		} else {
			return checkWhen(ds, userId);
		}
	}

	/// Whenスロットが空かどうか確認する
	public String checkWhen(Datastore ds, String userId) {
		String str=getUpdateLifelog(ds, userId).getWhen();
		if (str.equals("NIL")){
			return "No_when";
		} else {
			return checkWhere(ds,userId);

		}
	}


	/// Whereスロットが空かどうか確認する
	public String checkWhere(Datastore ds, String userId) {
		String str=getUpdateLifelog(ds, userId).getWhere();
		if (str.equals("NIL")) {
			return "No_where";
		} else {
			return checkWhom(ds, userId);
		}
	}

	/// Whomスロットが空かどうか確認する
	public String checkWhom(Datastore ds, String userId) {
		String str=getUpdateLifelog(ds, userId).getWhom();
		if (str.equals("NIL")) {
			return "No_whom";
		} else {
			return checkPolarityConf(ds,userId);
		}
	}

	// PolarityConfが0.00かどうか確認する
	public String checkPolarityConf(Datastore ds, String userId) {
		String str=getUpdateLifelog(ds, userId).getPolarityConf();
		if (str.equals("NIL")) {
			return "No_polarity";
		} else {
			return "full";
		}
	}

    // スタンプの候補の中からランダムで1つ選択する
	public String stampSelect(String result) {
		String stamp;
		System.out.println(result);
		String[] stampList = result.split(",");
		String[] stampCandi = {"aizuti4","homeru2","gimon1","gimon2","sinpai","yobikake3","homeru1","hakken1","nadameru","aizuti3","yobikake1","aisatu1","aizuti1","hakken2","aizuti2"};
		List<String> stampTop = new ArrayList<String>();

		for(int i=0; i<stampList.length; i++) {
			for(int j=0; j<stampCandi.length; j++) {
				if(stampList[i].equals(stampCandi[j]) && stampTop.size()<4) {
					stampTop.add(stampList[i]);
				}
			}
		}
		if(stampTop.size() != 0) {
			Random rand = new Random();
		    stamp = stampTop.get(rand.nextInt(stampTop.size()));
		}else {
			stamp = "aizuti4";
		}

		return stamp;
	}
}
