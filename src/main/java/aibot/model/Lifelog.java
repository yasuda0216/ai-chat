package aibot.model;

import java.util.Date;

import org.bson.types.ObjectId;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Indexed;
import dev.morphia.annotations.Property;

@Entity(value="lifelog",useDiscriminator = false)
public class Lifelog {

	@Id
	ObjectId id;

	String usersSentence;

	String experiencer;

	String target;

	String aspect;

	@Property("polarity")
	String polarity;

	@Property("polarity_how")
	String polarity_how;

	@Property("polarity_terms")
	String polarityTerms;

	@Property("polarity_conf")
	String polarityConf;

	String when;

	String whom;

	String where;

	String response;

	String stamp;

	@Indexed
	String userID;

	String botType;


	@Property ("create_date")
    @Indexed
    Date     createDate;


    /**  */
    @Property ("update_date")
    @Indexed
    Date     updateDate;

    long idNumber;


    public String getBotType() {
		return botType;
	}


	public void setBotType(String botType) {
		this.botType = botType;
	}

    public String getPolarity_how() {
		return polarity_how;
	}


	public void setPolarity_how(String polarity_how) {
		this.polarity_how = polarity_how;
	}

	public long getIdNumber() {
		return idNumber;
	}


	public void setIdNumber(long idNumber) {
		this.idNumber = idNumber;
	}


	public ObjectId getId() {
		return id;
	}


	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getUsersSentence() {
		return usersSentence;
	}


	public void setUsersSentence(String usersSentence) {
		this.usersSentence = usersSentence;
	}


	public String getExperiencer() {
		return experiencer;
	}


	public void setExperiencer(String experiencer) {
		this.experiencer = experiencer;
	}


	public String getTarget() {
		return target;
	}


	public void setTarget(String target) {
		this.target = target;
	}


	public String getAspect() {
		return aspect;
	}


	public void setAspect(String aspect) {
		this.aspect = aspect;
	}


	public String getPolarity() {
		return polarity;
	}


	public void setPolarity(String polarity) {
		this.polarity = polarity;
	}


	public String getPolarityTerms() {
		return polarityTerms;
	}


	public void setPolarityTerms(String polarityTerms) {
		this.polarityTerms = polarityTerms;
	}


	public String getPolarityConf() {
		return polarityConf;
	}


	public void setPolarityConf(String polarityConf) {
		this.polarityConf = polarityConf;
	}


	public String getWhen() {
		return when;
	}


	public void setWhen(String when) {
		this.when = when;
	}


	public String getWhom() {
		return whom;
	}


	public void setWhom(String whom) {
		this.whom = whom;
	}


	public String getWhere() {
		return where;
	}


	public void setWhere(String where) {
		this.where = where;
	}

	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Date getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getResponse() {
		return response;
	}


	public void setResponse(String response) {
		this.response = response;
	}


	public String getStamp() {
		return stamp;
	}


	public void setStamp(String stamp) {
		this.stamp = stamp;
	}




}
