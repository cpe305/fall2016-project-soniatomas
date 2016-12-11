package test.java.soniatomas.cpe305fall2016project.skinsort;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import main.java.soniatomas.cpe305fall2016project.skinsort.User;
import main.java.soniatomas.cpe305fall2016project.skinsort.SystemData;
import main.java.soniatomas.cpe305fall2016project.skinsort.CreateProductsOperation;
import main.java.soniatomas.cpe305fall2016project.skinsort.Product;

public class CreateProductsOperationTest {

  @Test
  public void TestCreateProductOperationTestFailure() {
     CreateProductsOperation op = new CreateProductsOperation();
     op.execute(null);
     String status = (String)op.getVariables().get("status");
     assertEquals("FAILURE", status);
  }

  @Test
  public void TestCreateProductOperationTestSuccess() {
    User exampleUser = new User("exampleOne@example.com", "password", "Sonia", "Tomas");
    SystemData.getInstance().setUser(exampleUser);
    HashMap<String, String> parameters = new HashMap<String, String>();
    
    String productOneIngredients = "Water, Stearic Acid, Glycerin, C12-15 Alkyl Benzoate, "
        + "Caprylic/Capric Triglyceride,Glyceryl Stearate, Glyceryl Stearate SE, "
        + "Cetearyl Alcohol, Caprylyl Glycol, Phenoxyethanol, Butyrospermum Parkii (Shea Butter), "
        + "Squalane, Allantoin, Sodium Hydroxide, Dimethicone, Xanthan Gum, Disodium EDTA, "
        + "Chrysanthemum Parthenium (Feverfew) Extract, Camellia Sinensis (White Tea) Leaf Extract, "
        + "Butylene Glycol, Glycyrrhiza Glabra (Licorice) Root Extract, Eucalyptus Globulus";
    parameters.put("product_name", "Dramatically Different Lotion Plus");
    parameters.put("product_brand", "Clinique");
    parameters.put("product_category", "Skin Care");
    parameters.put("product_type", "Moisturizer");
    parameters.put("product_ingredients", productOneIngredients);
    
    String productTwoIngredients = "Water, Stearic Acid, Glycerin, C12-15 Alkyl Benzoate, "
        + "Caprylic/Capric Triglyceride,Glyceryl Stearate, Glyceryl Stearate SE, "
        + "Cetearyl Alcohol, Caprylyl Glycol, Phenoxyethanol, Butyrospermum Parkii (Shea Butter), "
        + "Squalane, Allantoin, Sodium Hydroxide, Dimethicone, Xanthan Gum, Disodium EDTA";  
    parameters.put("product_two_name", "Dramatically Different Lotion Plus");
    parameters.put("product_two_brand", "Clinique");
    parameters.put("product_two_category", "Skin Care");
    parameters.put("product_two_type", "Moisturizer");
    parameters.put("product_two_ingredients", productTwoIngredients);
    
    CreateProductsOperation op = new CreateProductsOperation();
    op.execute(parameters);
    String status = (String)op.getVariables().get("status");
    assertEquals("SUCCESS", status);
  }
}
