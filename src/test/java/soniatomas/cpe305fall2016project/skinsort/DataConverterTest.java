package test.java.soniatomas.cpe305fall2016project.skinsort;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.junit.Test;

import javafx.collections.ObservableList;
import main.java.soniatomas.cpe305fall2016project.skinsort.DataConverter;
import main.java.soniatomas.cpe305fall2016project.skinsort.Ingredient;
import main.java.soniatomas.cpe305fall2016project.skinsort.Product;
import main.java.soniatomas.cpe305fall2016project.skinsort.ProductTableViewElement;
import main.java.soniatomas.cpe305fall2016project.skinsort.Rating;
import main.java.soniatomas.cpe305fall2016project.skinsort.User;

public class DataConverterTest {

  @Test
  public void TestDataCoverterGetUserData() {
    User user = new User("exampleEmail@fake.com", "password", "mary", "poppins");
    Hashtable<String, String> convertedUser = new DataConverter().getUserData(user);
    assertEquals(convertedUser.get("EMAIL"), "exampleEmail@fake.com");
    assertEquals(convertedUser.get("FIRST_NAME"), "mary");
    assertEquals(convertedUser.get("LAST_NAME"), "poppins");

  }

  @Test
  public void TestGetProductData() {
    Hashtable<String, String> productTable = new Hashtable<String, String>();
    DataConverter dataConverter = new DataConverter();

    Product productOne = new Product("Skin Care", "Lotion", "Jergen's", "Coconut Oil body lotion");
    Ingredient ingredientOne = new Ingredient("Aloe Barbadensis Leaf Juice");
    Ingredient ingredientTwo = new Ingredient("Zea Mays (Corn) Starch");
    productOne.addIngredient(ingredientOne);
    productOne.addIngredient(ingredientTwo);
    productOne.addIngredient("Propanediol");
    productOne.addIngredient("Sodium Stearate");
    productOne.setPrice(30.00);
    Rating rating = new Rating();
    rating.setSystemRating(5.3);
    rating.setUserRating(6.6);
    productOne.setRating(rating);

    productTable = dataConverter.getProductData(productOne);

    assertEquals("skin care", productTable.get("CATEGORY"));
    assertEquals("lotion", productTable.get("TYPE"));
    assertEquals("jergen's", productTable.get("BRAND"));
    assertEquals("coconut oil body lotion", productTable.get("NAME"));
    assertEquals(Double.toString(30.00), productTable.get("PRICE"));
    assertEquals("5.3", productTable.get("SYSTEM_RATING"));
    assertEquals("6.6", productTable.get("USER_RATING"));
    assertEquals("neutral", productTable.get("RECOMMENDATION"));
    assertEquals(productTable.get("DATE"), productTable.get("DATE"));

    productOne.getRating().setSystemRating(1.2);
    productTable = dataConverter.getProductData(productOne);
    assertEquals("bad", productTable.get("RECOMMENDATION"));

    productOne.getRating().setSystemRating(7.7);
    productTable = dataConverter.getProductData(productOne);
    assertEquals("good", productTable.get("RECOMMENDATION"));
  }

  @Test
  public void TestGetObservableProductList() {
    DataConverter dataConverter = new DataConverter();
    List<Product> productList = new ArrayList<Product>();
    productList.add(new Product("Skin care", "Lotion", "St.Ives", "Naturally soothing lotion"));
    productList.add(
        new Product("Skin Care", "Moisturizer", "Clinique", "Dramatically diffent lition plus"));
    productList.add(new Product("Makeup", "Mascara", "Maybelline", "The Collosal"));
    ObservableList<ProductTableViewElement> obList = dataConverter
        .getObservableProductList(productList);
    assertEquals("skin care", obList.get(0).getCategory());
    assertEquals("maybelline", obList.get(2).getBrand());
  }
  
  @Test
  public void TestGetObservableIngredientList() {
    DataConverter dataConverter = new DataConverter();
    List<Ingredient> ingredList= new ArrayList<Ingredient>();
    ingredList.add(new Ingredient("aqua"));
    ingredList.add(new Ingredient("glycerin"));
    ingredList.add(new Ingredient("trygliceride"));
    ObservableList<String> obList = dataConverter.getObservableIngredientList(ingredList);
    assertEquals("aqua", obList.get(0));
    assertEquals("glycerin", obList.get(1));
    
  }

}
