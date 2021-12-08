package aibot.Service;

import java.util.Date;
import java.util.List;

import aibot.Process.LifelogProcess;
import aibot.model.Lifelog;
import dev.morphia.Datastore;
import dev.morphia.query.FindOptions;
import dev.morphia.query.Query;
import dev.morphia.query.Sort;
import dev.morphia.query.experimental.filters.Filters;

public class LifelogService {


	LifelogProcess lifelogProcess = new LifelogProcess();


	/// Lifelogドキュメントの追加
	public void addLifelog(Datastore ds, String userUtterance, String userId) {

		Lifelog lifelog = new Lifelog();
		Date date = new Date();

		lifelog.setAction(lifelogProcess.extractAction(userUtterance));
		lifelog.setAspect(lifelogProcess.extractAspect(userUtterance));
		lifelog.setCreateDate(date);
		lifelog.setExperiencer(lifelogProcess.extractExperiencer(userUtterance));
		lifelog.setPolarity(lifelogProcess.estimatePolarity(userUtterance));
		lifelog.setPolarityConf(lifelogProcess.estimatePolarityConf(userUtterance));
		lifelog.setTarget(lifelogProcess.extractTarget(userUtterance));
		lifelog.setUpdateDate(date);
		lifelog.setUserID(userId);
		lifelog.setWhen(lifelogProcess.extractWhen(userUtterance));
		lifelog.setWhere(lifelogProcess.extractWhere(userUtterance));
		lifelog.setWhom(lifelogProcess.extractWhom(userUtterance));

		ds.save(lifelog);

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
	public void updatePolarity(Datastore ds, Double updatePolarity, String userId) {
		Date upDate = new Date();
		Lifelog updateLifelog = getUpdateLifelog(ds, userId);
		updateLifelog.setPolarity(updatePolarity);
		updateLifelog.setUpdateDate(upDate);
		ds.save(updateLifelog);
	}

	/// PolarityTermsスロットの更新
	public void updatePolarityTerms(Datastore ds, List<String> updatePolarityTerms, String userId) {
		Date upDate = new Date();
		Lifelog updateLifelog = getUpdateLifelog(ds, userId);
		updateLifelog.setPolarityTerms(updatePolarityTerms);
		updateLifelog.setUpdateDate(upDate);
		ds.save(updateLifelog);
	}

	/// PolarityConfスロットの更新
	public void updatePolarityConf(Datastore ds, Double updatePolarityConf, String userId) {
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
		updateLifelog.setWhen(updateWhen);
		updateLifelog.setUpdateDate(upDate);
		ds.save(updateLifelog);
	}

	/// Whomスロットの更新
	public void updateWhom(Datastore ds, String updateWhom, String userId) {
		Date upDate = new Date();
		Lifelog updateLifelog = getUpdateLifelog(ds, userId);
		updateLifelog.setWhom(updateWhom);
		updateLifelog.setUpdateDate(upDate);
		ds.save(updateLifelog);
	}

	/// Whereスロットの更新
	public void updateWhere(Datastore ds, String updateWhere, String userId) {
		Date upDate = new Date();
		Lifelog updateLifelog = getUpdateLifelog(ds, userId);
		updateLifelog.setWhere(updateWhere);
		updateLifelog.setUpdateDate(upDate);
		ds.save(updateLifelog);
	}

	/// Actionスロットの更新
	public void updateAction(Datastore ds, String updateAction, String userId) {
		Date upDate = new Date();
		Lifelog updateLifelog = getUpdateLifelog(ds, userId);
		updateLifelog.setAction(updateAction);
		updateLifelog.setUpdateDate(upDate);
		ds.save(updateLifelog);
	}

	/*
	 * 空のスロットを検索
	 */

	/// Experiencerスロットが空かどうか確認する
	public String checkExperiencer(Datastore ds, String userId) {
		if (getUpdateLifelog(ds, userId).getExperiencer() == null) {
			return "#Ask_Experiencer";
		} else {
			return checkWhen(ds, userId);
		}
	}

	/// Whenスロットが空かどうか確認する
	public String checkWhen(Datastore ds, String userId) {
		if (getUpdateLifelog(ds, userId).getWhen() == null) {
			return "#Ask_When";
		} else {
			return checkWhere(ds, userId);
		}
	}

	/// Whereスロットが空かどうか確認する
	public String checkWhere(Datastore ds, String userId) {
		if (getUpdateLifelog(ds, userId).getWhere() == null) {
			return "#Ask_Where";
		} else {
			return checkAction(ds, userId);
		}
	}

	/// Actionスロットが空かどうか確認する
	public String checkAction(Datastore ds, String userId) {
		if (getUpdateLifelog(ds, userId).getAction() == null) {
			return "#Ask_Action";
		} else {
			return checkWhom(ds, userId);
		}
	}

	/// Polarityスロットが空かどうか確認する
		public String checkPolarity(Datastore ds, String userId) {
			if (getUpdateLifelog(ds, userId).getPolarity() == null) {
				return "#Ask_Polarity";
			} else {
				return checkWhom(ds,userId);
			}
		}

	/// Whomスロットが空かどうか確認する
	public String checkWhom(Datastore ds, String userId) {
		if (getUpdateLifelog(ds, userId).getWhom() == null) {
			return "#Ask_Whom";
		} else {
			return "Not_Action";
		}
	}
}
