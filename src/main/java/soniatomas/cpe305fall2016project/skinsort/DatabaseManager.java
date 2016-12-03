package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import org.mongodb.*;

import java.net.UnknownHostException;
import com.mongodb.MongoException;
import org.mongodb.morphia.*;

import com.mongodb.MongoClient;
import com.mongodb.Mongo;

import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;
import org.mongodb.morphia.dao.BasicDAO;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class DatabaseManager {

  private static DatabaseManager dbManager;
  private boolean errorInDatabase;
  private Morphia morphia;
  private String dbName;
  private MongoClient mongoClient;
  private Datastore datastore;
  private UserDAO userDAO;

  private DatabaseManager() {
    try {
      dbName = new String("users");
      mongoClient = new MongoClient();
      morphia = new Morphia();
      morphia.mapPackage("soniatomas.cpe305fall2016project.skinsort");
      datastore = morphia.createDatastore(mongoClient, dbName);
      datastore.ensureIndexes();
      userDAO = new UserDAO(morphia, mongoClient, dbName);
      errorInDatabase = false;

    } catch (Exception e) {
      errorInDatabase = true;
      //System.out.println("ERROR IN DATABASE!! MADE IT HERE!!");
      //SystemData systemData = SystemData.getInstance();
      //systemData.setErrorInDatabase(true);
    }

  }

  public static DatabaseManager getInstance() {
    if (dbManager == null) {
      dbManager = new DatabaseManager();
    }
    return dbManager;
  }

  public boolean userExistWithEmail(String email) {
    if (!errorInDatabase) {
      Query<User> query = datastore.createQuery(User.class);
      query.and(query.criteria("email").contains(email));
      QueryResults<User> retrievedUsers = userDAO.find(query);
      User queriedUser = null;
      if (retrievedUsers != null) {
        queriedUser = retrievedUsers.get();
      }
      if (queriedUser != null && queriedUser.getEmail().equals(email)) {
        return true;
      }
    }
    return false;
  }

  public boolean saveNewUserToDatabase(User user) { 
    if (!errorInDatabase && !userExistWithEmail(user.getEmail())) {
      Key<User> savedUser = datastore.save(user);
      if (savedUser.getId() != null) {
        SystemData.getInstance().setUser(user);
        return true;
      }
    }
    return false;
  }
  
  public boolean saveUpdatesToDatabae() {
    if (!errorInDatabase) {
      User user = SystemData.getInstance().getUser();
      Key<User> savedUser = datastore.save(user);
      if (savedUser.getId() != null) {
        SystemData.getInstance().setUser(user);
        return true;
      }
    }
    return false;
  }

  public boolean queryUser(String email, String password) {
    if (!errorInDatabase) {
      Query<User> query = datastore.createQuery(User.class);
      query.and(query.criteria("email").contains(email));
      QueryResults<User> retrievedUsers = userDAO.find(query);
      User queriedUser = null;
      if (retrievedUsers != null) {
        queriedUser = retrievedUsers.get();
      }
      if (queriedUser != null && queriedUser.getEmail().equals(email)
          && queriedUser.isPasswordEqualTo(password)) {
        SystemData.getInstance().setUser(queriedUser);
        return true;
      }
    }
    return false;
  }

  public boolean errorInDatabase() {
    return errorInDatabase;
  }

}
