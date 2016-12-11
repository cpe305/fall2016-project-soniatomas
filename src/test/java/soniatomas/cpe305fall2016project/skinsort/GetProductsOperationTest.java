package test.java.soniatomas.cpe305fall2016project.skinsort;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import main.java.soniatomas.cpe305fall2016project.skinsort.GetProductsOperation;
import main.java.soniatomas.cpe305fall2016project.skinsort.Ingredient;
import main.java.soniatomas.cpe305fall2016project.skinsort.InputValidator;
import main.java.soniatomas.cpe305fall2016project.skinsort.Product;
import main.java.soniatomas.cpe305fall2016project.skinsort.RatingUpdater;
import main.java.soniatomas.cpe305fall2016project.skinsort.SystemData;
import main.java.soniatomas.cpe305fall2016project.skinsort.User;

public class GetProductsOperationTest {

  @Test
  public void GetProductOperationTestOne() {
    User user = new User("exampleOne@example.com", "password", "Sonia", "Tomas");
    SystemData.getInstance().setUser(user);

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

    user.getProductHistory().addProduct(productOne);

    RatingUpdater ratingUpdater = new RatingUpdater();
    double systemRating = ratingUpdater.findAddedProductSystemRating(productOne);
    productOne.getRating().setSystemRating(systemRating);

    Product productTwo = new Product();
    productTwo.setCatergory("Skin Care");
    productTwo.setType("Moisturizer");
    productTwo.setBrand("First Aid Beauty");
    productTwo.setName("Ultra Repair Cream Intense Therapy");
    productTwo.setPrice(30.00);

    String ingredientsStringTwo = "Water, Stearic Acid, Glycerin, C12-15 Alkyl Benzoate, "
        + "Caprylic/Capric Triglyceride,Glyceryl Stearate, Glyceryl Stearate SE, "
        + "Cetearyl Alcohol, Caprylyl Glycol, Phenoxyethanol, Butyrospermum Parkii (Shea Butter), "
        + "Squalane, Allantoin, Sodium Hydroxide, Dimethicone, Xanthan Gum, Disodium EDTA";

    List<String> ingredientsTwo = new InputValidator()
        .ingredientInputStringToList(ingredientsStringTwo);
    for (String ingredString : ingredientsTwo) {
      productTwo.addIngredient(new Ingredient(ingredString));
    }

    user.getProductHistory().addProduct(productTwo);

    double systemRatingTwo = ratingUpdater.findAddedProductSystemRating(productTwo);
    productTwo.getRating().setSystemRating(systemRatingTwo);
    
    HashMap<String, String> parameters = new HashMap<String, String>();
    parameters.put("product_name", "ultra repair cream intense therapy");
    parameters.put("product_brand", "first aid beauty");;
    
    parameters.put("product_two_name", "dramatically different lotion plus");
    parameters.put("product_two_brand", "clinique");
    
    GetProductsOperation op = new GetProductsOperation();
    op.execute(parameters);
    Product retrievedProduct = (Product)op.getVariables().get("product");
    assertEquals("skin care", retrievedProduct.getCategory());
    
    
  }
}
