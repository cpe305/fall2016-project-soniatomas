package test.java.soniatomas.cpe305fall2016project.skinsort;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import main.java.soniatomas.cpe305fall2016project.skinsort.Product;
import main.java.soniatomas.cpe305fall2016project.skinsort.ProductHistory;
import main.java.soniatomas.cpe305fall2016project.skinsort.SystemData;
import main.java.soniatomas.cpe305fall2016project.skinsort.User;
import main.java.soniatomas.cpe305fall2016project.skinsort.ViewHistoryOperation;

public class ViewHistoryOperationTest {

  @Test
  public void TestViewHistoryOperationSuccess() {
    User user = new User("soniatomas@example.com", "password", "Sonia", "Tomas");
    ProductHistory productHistory = user.getProductHistory();
    Product productOne = new Product("Skin Care", "Deoderant", "lavanilla", "The Healthy Deoderant - Vanilla Coconut");
    Product productTwo = new Product();
    productTwo.setCatergory("Skin Care");
    productTwo.setType("Moisturizer");
    productTwo.setBrand("First Aid Beauty");
    productTwo.setName("Ultra Repair Cream");
    productTwo.setPrice(30.00);
    productHistory.addProduct(productOne);
    productHistory.addProduct(productTwo);
    user.setProductHistory(productHistory);
    Product productThree = new Product("Makeup", "Lipstick", "Nars", "Audacious Lipstick - Mona");
    productThree.setPrice(32.00);
    user.getProductHistory().addProduct(productThree);
    SystemData.getInstance().setUser(user);
    
    ViewHistoryOperation viewHistory = new ViewHistoryOperation();
    viewHistory.execute(null);
    @SuppressWarnings("unchecked")
    List<Product> listOfProducts = (List<Product>) viewHistory.getVariables().get("products");
    assertEquals(3, listOfProducts.size());
    String status  = (String) viewHistory.getVariables().get("status");
    assertEquals("SUCCESS", status);
  }
   
  @Test
  public void TestViewHistoryOperationFailure() {
    SystemData.getInstance().setUser(null);
    ViewHistoryOperation viewHistory = new ViewHistoryOperation();
    viewHistory.execute(null);
    Object history = viewHistory.getVariables().get("products");
    assertTrue(history == null);
    String status  = (String) viewHistory.getVariables().get("status");
    assertEquals("FAILURE", status);
  }
  
}
