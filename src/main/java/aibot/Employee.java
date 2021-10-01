package aibot;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Field;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Index;
import dev.morphia.annotations.IndexOptions;
import dev.morphia.annotations.Indexes;
import dev.morphia.annotations.Property;
import dev.morphia.annotations.Reference;

@Entity("employees")
@Indexes(@Index(options = @IndexOptions(name = "salary"), fields = @Field("salary")))
public class Employee {
	@Id
	ObjectId id;
    String name;
    @Property("wage")
    Double salary;
    @Reference
    Users user;


    public String getUserID() {
        return user.getUserID();
    }

    public String getFirstname() {
        return user.firstname;
    }

    public String getLastname() {
        return user.lastname;
    }

    boolean researchName(MongoCollection<Document> emps, String name, String user) {
    	List<Document> emp = emps.find(Filters.in('"'+name+'"', '"'+user+'"')).into(new ArrayList<Document>());
    	if(emp == null || emp.size() == 0) {
        	return false;
        }else {
        	return true;
        }
    }
}
