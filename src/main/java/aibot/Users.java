package aibot;

import org.bson.types.ObjectId;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;


	@Entity("uesrs")
	public class Users {
		@Id
		ObjectId id;
	    String lastname;
	    String firstname;
	    String userID;


	    void setLastname(String lastname) {
	    	this.lastname = lastname;
	    }

	    void setFirstname(String firstname) {
	    	this.firstname = firstname;
	    }

	    void setUserID(String usrid) {
	    	this.userID = usrid;
	    }


	    public String getUserID() {
	        return userID;
	    }

	    public String getFirstname() {
	        return firstname;
	    }

	    public String getLastname() {
	        return lastname;
	    }



	}
