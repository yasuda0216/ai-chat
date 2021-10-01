package aibot;

import java.util.List;

import org.bson.types.ObjectId;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Property;

@Entity("lifelogging")
public class Lifelog {

	@Id
	ObjectId id;

    String experiencer;

    String target;

    String aspect;

    @Property("polarity")
    Double polarity;

    @Property("polarity_terms")
    List<String> polarity_terms;

    @Property("polarity_conf")
    Double polarity_conf;

    String when;

    String whom;

    String where;

    String action;



    void setExperiencer(String experiencer) {
    	this.experiencer = experiencer;
    }

    void setTarget(String target) {
    	this.target = target;
    }

    void setAspect(String aspect) {
    	this.aspect = aspect;
    }

    void setPolarity(Double polarity) {
    	this.polarity = polarity;
    }

    void setPolarityTerms(List<String> polarity_terms) {
    	this.polarity_terms = polarity_terms;
    }

    void setPolarityConf(Double polarity_conf) {
    	this.polarity_conf = polarity_conf;
    }

    void setWhen(String when) {
    	this.when = when;
    }

    void setWhom(String whom) {
    	this.whom = whom;
    }

    void setWhere(String where) {
    	this.where = where;
    }

    void setAction(String action) {
    	this.action = action;
    }

    String getExperiencer() {
    	return experiencer;
    }

    String getTarget() {
    	return target;
    }

    String getAspect() {
    	return aspect;
    }

    Double getPolarity() {
    	return polarity;
    }

    List<String> getPolarityTerms(){
    	return polarity_terms;
    }

    Double getPolarityConf() {
    	return polarity_conf;
    }

    String getWhen() {
    	return when;
    }

    String getWhom() {
    	return whom;
    }

    String getWhrer() {
    	return where;
    }

    String getAction() {
    	return action;
    }

}
