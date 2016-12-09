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
    // query.and(
    // query.criteria("email").contains("user2@example.com")
    // );

    // QueryResults<User> retrievedUsers = userDAO.find(query);

    QueryResults<User> retrievedUsers = userDAO.find();
    
    Product product5 = new Product("Skin Care", "Body Lotion", "St. Ives", "Oatmeal and Shea Butter lotion");
    Rating rating5 = new Rating();
    rating5.setSystemRating(5.5);
    rating5.setUserRating(5.0);
    product5.setRating(rating5);
    product5.setPrice(3.99);
    product5.addIngredient(new Ingredient("aqua"));
    product5.addIngredient(new Ingredient("caprylic triglyceride"));
    product5.addIngredient(new Ingredient("glycine soja oil"));
    product5.addIngredient(new Ingredient("stearic acid"));
    product5.addIngredient(new Ingredient("cetyl alcohol"));
    
    for (User retrievedUser : retrievedUsers) {
      System.out.println("USER RECORD");
      System.out.println("Key: " + retrievedUser.getId());
      System.out.println("First Name: " + retrievedUser.getFirstName());
      System.out.println("Last Name: " + retrievedUser.getLastName());
      System.out.println("Email: " + retrievedUser.getEmail());
      System.out.println("" + retrievedUser.isPasswordEqualTo("password"));
      ArrayList<Product> productHistory = (ArrayList<Product>) retrievedUser.getProductHistory()
          .getProductHistory();
      for (Product product : productHistory) {
        System.out.println("\nPRODUCT INFORMATION");
        System.out.println("Category: " + product.getCategory());
        System.out.println("type: " + product.getType());
        System.out.println("brand: " + product.getBrand()); 
        System.out.println("name: " + product.getName());
        System.out.println("price: " + product.getPrice());
        System.out.println("ratings: " + product.getRating().getSystemRating() + "  "
            + product.getRating().getUserRating());
        System.out.println("ingredients");
        for (Ingredient ingredient : product.getIngredients()) {
          System.out.println("\tIngredient Name: " + ingredient.getName());
        }
        System.out.println();

      }
      productHistory.add(product5);
      datastore.save(retrievedUser);
    }
      
          
      Query<User> queryAgain = datastore.createQuery(User.class);
      // query.and(
      // query.criteria("email").contains("user2@example.com")
      // );

      // QueryResults<User> retrievedUsers = userDAO.find(query);

      QueryResults<User> retrievedUsersAgain = userDAO.find();
      
      
      for (User retrievedUserAgain : retrievedUsersAgain) {
        System.out.println("USER RECORD");
        System.out.println("Key: " + retrievedUserAgain.getId());
        System.out.println("First Name: " + retrievedUserAgain.getFirstName());
        System.out.println("Last Name: " + retrievedUserAgain.getLastName());
        System.out.println("Email: " + retrievedUserAgain.getEmail());
        System.out.println("" + retrievedUserAgain.isPasswordEqualTo("password"));
        ArrayList<Product> productHistory = (ArrayList<Product>) retrievedUserAgain.getProductHistory()
            .getProductHistory();
        for (Product product : productHistory) {
          System.out.println("\nPRODUCT INFORMATION");
          System.out.println("Category: " + product.getCategory());
          System.out.println("type: " + product.getType());
          System.out.println("brand: " + product.getBrand()); 
          System.out.println("name: " + product.getName());
          System.out.println("price: " + product.getPrice());
          System.out.println("ratings: " + product.getRating().getSystemRating() + "  "
              + product.getRating().getUserRating());
          System.out.println("ingredients");
          for (Ingredient ingredient : product.getIngredients()) {
            System.out.println("\tIngredient Name: " + ingredient.getName());
          }
          System.out.println();

        }
      
      

    }
  }

}
