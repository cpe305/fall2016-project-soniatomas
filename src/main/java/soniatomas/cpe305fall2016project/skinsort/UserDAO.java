package main.java.soniatomas.cpe305fall2016project.skinsort;

import org.mongodb.morphia.*;

import org.mongodb.morphia.dao.BasicDAO;
import com.mongodb.MongoClient;
 
public class UserDAO extends BasicDAO<User, String> {
  
  public UserDAO(Morphia morphia, MongoClient mongo, String dbName) {       
      super(mongo, morphia, dbName);   
   }
}
