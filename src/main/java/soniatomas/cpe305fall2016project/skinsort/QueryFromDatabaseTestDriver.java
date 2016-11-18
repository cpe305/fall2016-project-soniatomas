package main.java.soniatomas.cpe305fall2016project.skinsort;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;
import org.mongodb.morphia.dao.BasicDAO;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import java.util.LinkedList;
import java.util.ArrayList;

public class QueryFromDatabaseTestDriver {

  public static void main(String[] args) {
    String dbName = new String("users");
    Morphia morphia = new Morphia();
    MongoClient mongoClient = new MongoClient();
    morphia.mapPackage("soniatomas.cpe305fall2016project.skinsort");
    Datastore datastore = morphia.createDatastore(mongoClient, dbName);
    datastore.ensureIndexes();

    UserDAO userDAO = new UserDAO(morphia, mongoClient, dbName);

    Query<User> query = datastore.createQuery(User.class);
//    query.and(      
//     query.criteria("email").contains("user2@example.com")
//    );      

//    QueryResults<User> retrievedUsers =  userDAO.find(query);  

    QueryResults<User> retrievedUsers =  userDAO.find();  

    
    for (User retrievedUser : retrievedUsers) {
        System.out.println("USER RECORD");
        System.out.println("Key: " + retrievedUser.getId());
        System.out.println("First Name: " + retrievedUser.getFirstName());
        System.out.println("Last Name: " + retrievedUser.getLastName());
        System.out.println("Email: " + retrievedUser.getEmail());
        System.out.println("" + retrievedUser.isPasswordEqualTo("password"));
        ArrayList<Product> productHistory = (ArrayList<Product>)retrievedUser.getProductHistory().getProductHistory();
        for (Product product : productHistory)
        {
          System.out.println("\nPRODUCT INFORMATION");
          System.out.println("name: " + product.getName());
          System.out.println("price: " + product.getPrice());
          System.out.println("ratings: " + product.getRating().getSystemRating() + "  " + product.getRating().getUserRating());
          System.out.println("ingredients");
          for (Ingredient ingredient : product.getIngredients())
          {
            System.out.println("\tIngredient Name: " + ingredient.getName());
          }
          System.out.println();
          
        }
        
    } 
  }

}
