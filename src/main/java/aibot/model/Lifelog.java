package aibot.model;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Indexed;
import dev.morphia.annotations.Property;

@Entity(value="lifelog",useDiscriminator = false)
public class Lifelog {

	@Id
	ObjectId id;

	String experiencer;

	String target;

	String aspect;

	@Property("polarity")
	Double polarity;

	@Property("polarity_terms")
	List<String> polarityTerms;

	@Property("polarity_conf")
	Double polarityConf;

	String when;

	String whom;

	String where;

	String action;

	@Indexed
	String userID;

	@Property ("create_date")
    @Indexed
    Date     createDate;


    /**  */
    @Property ("update_date")
    @Indexed
    Date     updateDate;


	public ObjectId getId() {
		return id;
	}


	public void setId(ObjectId id) {
		this.id = id;
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


	public Double getPolarity() {
		return polarity;
	}


	public void setPolarity(Double polarity) {
		this.polarity = polarity;
	}


	public List<String> getPolarityTerms() {
		return polarityTerms;
	}


	public void setPolarityTerms(List<String> polarityTerms) {
		this.polarityTerms = polarityTerms;
	}


	public Double getPolarityConf() {
		return polarityConf;
	}


	public void setPolarityConf(Double polarityConf) {
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


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
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


}
