package test.java.soniatomas.cpe305fall2016project.skinsort;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import main.java.soniatomas.cpe305fall2016project.skinsort.SystemData;
import main.java.soniatomas.cpe305fall2016project.skinsort.User;
import main.java.soniatomas.cpe305fall2016project.skinsort.Product;
import main.java.soniatomas.cpe305fall2016project.skinsort.*;

public class SystemDataTest {

  @Test
  public void TestSetAndGetUser() {
    User exampleUser = new User("exampleOne@example.com", "password", "James", "Blake");
    SystemData.getInstance().setUser(exampleUser);
    User retrievedUser = SystemData.getInstance().getUser();
    assertEquals("exampleOne@example.com", retrievedUser.getEmail());
    assertEquals("James", retrievedUser.getFirstName());
    assertEquals("Blake", retrievedUser.getLastName());
    assertTrue(retrievedUser.isPasswordEqualTo("password"));
    retrievedUser.setFirstName("Sonia");
    retrievedUser.setLastName("Tomas");
    retrievedUser.setEmail("soniatomas@example.com");
    retrievedUser.setPassword("newPassword");
    User retrievedUserAgain = SystemData.getInstance().getUser();
    assertEquals("Sonia", retrievedUserAgain.getFirstName());
    assertEquals("Tomas", retrievedUserAgain.getLastName());
    assertEquals("soniatomas@example.com", retrievedUserAgain.getEmail());
    assertTrue(retrievedUserAgain.isPasswordEqualTo("newPassword"));
  }

  @Test
  public void TestSetAndGetProductOne() {
    Product productOne = new Product("Skin Care", "Moisturizer", "Clinique",
        "Dramatically Different Lotion Plus");
    String ingredientsString = "Water, Stearic Acid, Glycerin, C12-15 Alkyl Benzoate, "
        + "Caprylic/Capric Triglyceride,Glyceryl Stearate, Glyceryl Stearate SE, "
        + "Cetearyl Alcohol, Caprylyl Glycol, Phenoxyethanol, Butyrospermum Parkii (Shea Butter), "
        + "Squalane, Allantoin, Sodium Hydroxide, Dimethicone, Xanthan Gum, Disodium EDTA, "
        + "Chrysanthemum Parthenium (Feverfew) Extract, Camellia Sinensis (White Tea) Leaf Extract, "
        + "Butylene Glycol, Glycyrrhiza Glabra (Licorice) Root Extract, Eucalyptus Globulus";

    List<String> ingredients = new InputValidator().ingredientInputStringToList(ingredientsString);
    for (String ingredString : ingredients) {
      productOne.addIngredient(new Ingredient(ingredString));
    }

    SystemData.getInstance().setProductOne(productOne);
    Product retrievedProductOne = SystemData.getInstance().getProductOne();
    assertEquals("skin care", retrievedProductOne.getCategory());
    assertEquals("moisturizer", retrievedProductOne.getType());
    assertEquals("clinique", retrievedProductOne.getBrand());
    assertEquals("dramatically different lotion plus", retrievedProductOne.getName());

  }

  @Test
  public void TestSetAndGetProductTwo() {
    Product productTwo = new Product();
    productTwo.setCatergory("Skin Care");
    productTwo.setType("Moisturizer");
    productTwo.setBrand("First Aid Beauty");
    productTwo.setName("Ultra Repair Cream Intense Therapy");
    productTwo.setPrice(30.00);
    
    String ingredientsString = "Water, Stearic Acid, Glycerin, C12-15 Alkyl Benzoate, "
        + "Caprylic/Capric Triglyceride,Glyceryl Stearate, Glyceryl Stearate SE, "
        + "Cetearyl Alcohol, Caprylyl Glycol, Phenoxyethanol, Butyrospermum Parkii (Shea Butter), "
        + "Squalane, Allantoin, Sodium Hydroxide, Dimethicone, Xanthan Gum, Disodium EDTA";
       
    List<String> ingredients = new InputValidator().ingredientInputStringToList(ingredientsString);
    for (String ingredString : ingredients) {
      productTwo.addIngredient(new Ingredient(ingredString));
    }
    
    SystemData.getInstance().setProductTwo(productTwo);

    Product retrievedProductTwo = SystemData.getInstance().getProductTwo();

    assertEquals("skin care", retrievedProductTwo.getCategory());
    assertEquals("moisturizer", retrievedProductTwo.getType());
    assertEquals("first aid beauty", retrievedProductTwo.getBrand());
    assertEquals("ultra repair cream intense therapy", retrievedProductTwo.getName());
    assertEquals(30.00, retrievedProductTwo.getPrice(), 0.00);
  }

}
