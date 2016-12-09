package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.HashMap;
import java.util.List;
import java.util.Observable;

public class GetProductsOperation implements Operation {

  private HashMap<String, Object> operationVariables;

  public GetProductsOperation() {
    operationVariables = new HashMap<String, Object>();
  }
  
  public HashMap<String, Object> getVariables() {
    return operationVariables;
  }

  public HashMap<String, Object> execute(HashMap<String, String> parameters) {
    
    operationVariables.put("status", "FAILURE");
    User user = SystemData.getInstance().getUser();
    String productName = parameters.get("product_name");
    String productBrand = parameters.get("product_brand");
    String productTwoName = parameters.get("product_two_name");
    String productTwoBrand = parameters.get("product_two_brand");
    if (productName != null) {
      operationVariables.put("status", "SUCCESS");
      Product product = user.getProductHistory().getProduct(productBrand, productName);
      
      RatingUpdater ratingUpdater = new RatingUpdater();
      double systemRating = ratingUpdater.findAddedProductSystemRating(product);
      product.getRating().setSystemRating(systemRating);
      
      operationVariables.put("product", product);
      SystemData.getInstance().setProductOne(product);
    }
    if (productTwoName != null) {
      operationVariables.put("status", "SUCCESS");
      Product productTwo = user.getProductHistory().getProduct(productTwoBrand, productTwoName);
      operationVariables.put("productTwo", productTwo);
      SystemData.getInstance().setProductTwo(productTwo);
    }
    return operationVariables;
  }
}
