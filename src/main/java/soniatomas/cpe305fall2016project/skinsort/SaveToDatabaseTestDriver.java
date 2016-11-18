package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.LinkedList;
import java.util.List;
import org.mongodb.*;

import java.net.UnknownHostException;
import com.mongodb.MongoException;
import org.mongodb.morphia.*;

import com.mongodb.MongoClient;
import com.mongodb.Mongo;

public class SaveToDatabaseTestDriver {

  public static void main(String[] args) throws UnknownHostException, MongoException{
    String dbName = new String("users");
    Morphia morphia = new Morphia();
    morphia.mapPackage("soniatomas.cpe305fall2016project.skinsort");
    Datastore datastore = morphia.createDatastore(new MongoClient(), dbName);
    datastore.ensureIndexes();
    
    User user1 = new User("user1@example.com", "password", "John", "Smith");
    User user2 = new User("user2@example.com", "password", "Jane", "Doe");
    
    Product product1 = new Product("product1");
    product1.addIngredient(new Ingredient("water"));
    product1.addIngredient(new Ingredient("oil"));
    product1.addIngredient(new Ingredient("rice"));
    Rating product1Rating = new Rating();
    product1Rating.setSystemRating(4.5);
    product1Rating.setUserRating(3.6);
    product1.setRating(product1Rating);
    product1.setPrice(1.00);
    
    Product product2 = new Product("product2");
    product2.addIngredient(new Ingredient("water"));
    product2.addIngredient(new Ingredient("jajobaoil"));
    product2.addIngredient(new Ingredient("lotion"));
    product2.addIngredient(new Ingredient("coke"));
    Rating product2Rating = new Rating();
    product2Rating.setSystemRating(6.5);
    product2Rating.setUserRating(9.3);
    product2.setRating(product2Rating);
    product2.setPrice(2.00);
    
    Product product3 = new Product("product3");
    product3.addIngredient(new Ingredient("water"));
    product3.addIngredient(new Ingredient("oil"));
    product3.addIngredient(new Ingredient("rice"));
    product3.addIngredient(new Ingredient("wine"));
    product3.addIngredient(new Ingredient("grain"));
    product3.addIngredient(new Ingredient("oat"));
    Rating product3Rating = new Rating();
    product3Rating.setSystemRating(2.3);
    product3Rating.setUserRating(4.6);
    product3.setRating(product3Rating);
    product3.setPrice(3.00);
    
    Product product4 = new Product("product4");
    product4.addIngredient(new Ingredient("water"));
    product4.addIngredient(new Ingredient("oil"));
    product4.addIngredient(new Ingredient("rice"));
    Rating product4Rating = new Rating();
    product4Rating.setSystemRating(9.5);
    product4Rating.setUserRating(8.7);
    product4.setRating(product4Rating);
    product4.setPrice(4.00);
    
    user1.getProductHistory().addProduct(product1);
    user1.getProductHistory().addProduct(product3);
    user2.getProductHistory().addProduct(product2);
    user2.getProductHistory().addProduct(product3);
    user2.getProductHistory().addProduct(product4);
    
    Key<User> savedUser1 = datastore.save(user1);   
    System.out.println(savedUser1.getId());
    
    Key<User> savedUser2 = datastore.save(user2);   
    System.out.println(savedUser2.getId());
    
    
  }

}
