package test.java.soniatomas.cpe305fall2016project.skinsort;

import static org.junit.Assert.*;
import org.junit.Test;

import main.java.soniatomas.cpe305fall2016project.skinsort.ProductHistory;
import main.java.soniatomas.cpe305fall2016project.skinsort.Product;
import main.java.soniatomas.cpe305fall2016project.skinsort.Ingredient;
import main.java.soniatomas.cpe305fall2016project.skinsort.Rating;

public class ProductHistoryTest {

  @Test
  public void TestAddProductTrue() {
    ProductHistory productHistory = new ProductHistory();
    Product productOne = new Product("Skin Care", "Deoderant", "lavanilla", "The Healthy Deoderant - Vanilla Coconut");
    Product productTwo = new Product();
    productTwo.setCatergory("Skin Care");
    productTwo.setType("Moisturizer");
    productTwo.setBrand("First Aid Beauty");
    productTwo.setName("Ultra Repair Cream");
    productTwo.setPrice(30.00);
    productHistory.addProduct(productOne);
    productHistory.addProduct(productTwo);
    assertTrue(productHistory.containsProduct("first aid beauty", "ultra repair cream"));
    assertTrue(productHistory.containsProduct("lavanilla", "the healthy deoderant - vanilla coconut"));
  }
  
  @Test
  public void TestAddProductFalse() {
    ProductHistory productHistory = new ProductHistory();
    Product productOne = new Product("Skin Care", "Deoderant", "lavanilla", "The Healthy Deoderant - Vanilla Coconut");
    Product productTwo = new Product();
    productTwo.setCatergory("Skin Care");
    productTwo.setType("Moisturizer");
    productTwo.setBrand("First Aid Beauty");
    productTwo.setName("Ultra Repair Cream");
    productTwo.setPrice(30.00);
    productHistory.addProduct(productOne);
    productHistory.addProduct(productTwo);

    boolean productInProductHistory = productHistory.containsProduct("paula's choice", "C Booster serum");
    assertEquals(false, productInProductHistory);
  }
  
  @Test
  public void TestRemoveProduct() {
    ProductHistory productHistory = new ProductHistory();
    Product productOne = new Product("Skin Care", "Deoderant", "lavanilla", "The Healthy Deoderant - Vanilla Coconut");
    Product productTwo = new Product();
    productTwo.setCatergory("Skin Care");
    productTwo.setType("Moisturizer");
    productTwo.setBrand("First Aid Beauty");
    productTwo.setName("Ultra Repair Cream");
    productTwo.setPrice(30.00);
    productHistory.addProduct(productOne);
    productHistory.addProduct(productTwo);
    productHistory.removeProduct("first aid beauty", "ultra repair cream");
    
    boolean removedProductFromHistory = productHistory.removeProduct("first aid beauty", "ultra repair cream");
    assertEquals(false, removedProductFromHistory);
    removedProductFromHistory = productHistory.removeProduct("lavanilla", "the healthy deoderant - vanilla coconut");
    assertEquals(true, removedProductFromHistory);
    removedProductFromHistory = productHistory.removeProduct("first aid beauty", "ultra repair cream");
    assertEquals(false, removedProductFromHistory);
    
  }
  
  @Test
  public void TestGetProductTrue() {
    ProductHistory productHistory = new ProductHistory();
    Product productOne = new Product("Skin Care", "Deoderant", "lavanilla", "The Healthy Deoderant - Vanilla Coconut");
    Product productTwo = new Product();
    productTwo.setCatergory("Skin Care");
    productTwo.setType("Moisturizer");
    productTwo.setBrand("First Aid Beauty");
    productTwo.setName("Ultra Repair Cream");
    productTwo.setPrice(30.00);
    productHistory.addProduct(productOne);
    productHistory.addProduct(productTwo);
    
    Product retrievedProduct = productHistory.getProduct("first aid beauty", "ultra repair cream");
    assertEquals("skin care", retrievedProduct.getCategory());
    assertEquals("moisturizer", retrievedProduct.getType());
    assertEquals("first aid beauty", retrievedProduct.getBrand());
    assertEquals("ultra repair cream", retrievedProduct.getName());
    assertEquals(30.00, retrievedProduct.getPrice(), 0.00);
    
    retrievedProduct = productHistory.getProduct("paula's choice", "C Booster serum");
    assertEquals(null, retrievedProduct);
    
    
    retrievedProduct = productHistory.getProduct("lavanilla", "the healthy deoderant - vanilla coconut");
    retrievedProduct.setPrice(16.00);
    Rating rating = new Rating();
    rating.setSystemRating(0.0);
    rating.setUserRating(7.5);
    retrievedProduct.setRating(rating);
    Product retrievedProductAgain = productHistory.getProduct("lavanilla", "the healthy deoderant - vanilla coconut");
    assertEquals("skin care", retrievedProduct.getCategory());
    assertEquals("deoderant", retrievedProduct.getType());
    assertEquals("lavanilla", retrievedProduct.getBrand());
    assertEquals("the healthy deoderant - vanilla coconut", retrievedProduct.getName());
    assertEquals(16.00, retrievedProductAgain.getPrice(), 0.00);
    assertEquals(0.0, retrievedProductAgain.getRating().getSystemRating(), 0.00);
    assertEquals(7.5, retrievedProductAgain.getRating().getUserRating(), 0.00);
    
    
    
    
  }
  
  

}
