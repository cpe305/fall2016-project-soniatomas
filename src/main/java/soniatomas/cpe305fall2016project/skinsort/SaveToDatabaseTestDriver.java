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
    
    Product product1 = new Product("Skin Care", "Deoderant", "lavanilla", "The Healthy Deoderant - Vanilla Coconut");
    Rating product1Rating = new Rating();
    product1Rating.setSystemRating(4.5);
    product1Rating.setUserRating(3.6);
    product1.setRating(product1Rating);
    product1.setPrice(16.00);
    Ingredient ingredientOne = new Ingredient("Aloe Barbadensis Leaf Juice");
    Ingredient ingredientTwo = new Ingredient("Zea Mays (Corn) Starch");
    product1.addIngredient(ingredientOne);
    product1.addIngredient(ingredientTwo);
    product1.addIngredient("Propanediol");
    product1.addIngredient("Sodium Stearate");
    
    Product productTwo = new Product();
    productTwo.setCatergory("Skin Care");
    productTwo.setType("Moisturizer");
    productTwo.setBrand("First Aid Beauty");
    productTwo.setName("Ultra Repair Cream Intense Therapy");
    productTwo.setPrice(30.00);
    productTwo.addIngredient(new Ingredient("water"));
    productTwo.addIngredient(new Ingredient("jajobaoil"));
    productTwo.addIngredient(new Ingredient("lotion"));
    Rating product2Rating = new Rating();
    product2Rating.setSystemRating(6.5);
    product2Rating.setUserRating(9.3);
    productTwo.setRating(product2Rating);
    
    Product product3 = new Product("test category", "test type", "test brand", "product3");
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
    
    Product product4 = new Product("test category", "test type", "test brand", "product4");
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
    user2.getProductHistory().addProduct(productTwo);
    user2.getProductHistory().addProduct(product3);
    user2.getProductHistory().addProduct(product4);
    
    Ingredient ingredient1 = new Ingredient("Aloe Barbadensis Leaf Juice");
    Ingredient ingredient2 = new Ingredient("Zea Mays (Corn) Starch");
    Ingredient ingredient3 = new Ingredient("Propanediol");
    Ingredient ingredient4 = new Ingredient("Sodium Stearate");
    
    Rating ratingOne = new Rating();
    ratingOne.setSystemRating(0.0);
    ratingOne.setUserRating(7.7);
    Rating ratingTwo = new Rating();
    ratingTwo.setSystemRating(4.4);
    ratingTwo.setUserRating(5.7);
    Rating ratingThree = new Rating();
    ratingThree.setSystemRating(3.3);
    ratingThree.setUserRating(2.2);
    Rating ratingFour = new Rating();
    ratingFour.setSystemRating(8.7);
    ratingFour.setUserRating(7.6);
    
    ingredient1.setRating(ratingOne);
    ingredient2.setRating(ratingTwo);
    ingredient3.setRating(ratingThree);
    ingredient4.setRating(ratingFour);
    
    IngredientLogger ingredientLoggerOne = user1.getIngredientLogger();
    IngredientLogger ingredientLoggerTwo = user2.getIngredientLogger();
    

    ingredientLoggerOne.addIngredient(ingredient1);
    ingredientLoggerOne.addIngredient(ingredient2);
    ingredientLoggerOne.addIngredient(ingredient3);
    ingredientLoggerOne.addIngredient(ingredient4);
    
    ingredientLoggerTwo.addIngredient(ingredient1);
    ingredientLoggerTwo.addIngredient(ingredient2);
    ingredientLoggerTwo.addIngredient(ingredient3);
    ingredientLoggerTwo.addIngredient(ingredient4);
    
    Key<User> savedUser1 = datastore.save(user1);   
    System.out.println(savedUser1.getId());
    
    Key<User> savedUser2 = datastore.save(user2);   
    System.out.println(savedUser2.getId());
    
    
  }

}
