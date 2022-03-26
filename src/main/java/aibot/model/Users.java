package aibot.model;

import java.util.List;

import org.bson.types.ObjectId;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;

@Entity("log")
public class Users {
	@Id
	ObjectId id;
	List<String> botRes;
	List<String> imageRes;
	String userRes;
	String userID;
	String botType;
	long idNum;

	public String getBotType() {
		return botType;
	}

	public void setBotType(String botType) {
		this.botType = botType;
	}

	public long getIdNum() {
		return idNum;
	}

	public void setIdNum(long idNum) {
		this.idNum = idNum;
	}

	public List<String> getImageRes() {
		return imageRes;
	}

	public void setImageRes(List<String> imageRes) {
		this.imageRes = imageRes;
	}


	public List<String> getBotRes() {
		return botRes;
	}

	public void setBotRes(List<String> botRes) {
		this.botRes = botRes;
	}

	public String getUserRes() {
		return userRes;
	}

	public void setUserRes(String userRes) {
		this.userRes = userRes;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

}
