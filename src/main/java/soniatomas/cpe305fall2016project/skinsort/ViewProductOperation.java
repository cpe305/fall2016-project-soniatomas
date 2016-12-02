package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;

public class ViewProductOperation implements Operation {

  private HashMap<String, Object> operationVariables;

  public ViewProductOperation() {
    operationVariables = new HashMap<String, Object>();
  }
  
  public HashMap<String, Object> getVariables() {
    return operationVariables;
  }

  public HashMap<String, Object> execute(HashMap<String, String> parameters) {
    String name = parameters.get("name");
    String brand = parameters.get("brand");
    operationVariables.put("status", "FAILURE");
    if (SystemData.getInstance().getUser() != null) {
      User user = SystemData.getInstance().getUser();
      operationVariables.put("status", "SUCCESS");
      Product product = user.getProductHistory().getProduct(brand, name);
      operationVariables.put("product", product);
//      Product product = user.getProductHistory().getProduct(name);
//      productInfo += "Product Name : " + product.getName() + "\n";
//      productInfo += "Date updated : " + product.getDateUpdated() + "\n";
//      productInfo += "Price : " + product.getPrice();
//      productInfo += "Ratings\n";
//      productInfo += "\tUser rating: " + product.getRating().getUserRating() + "\n";
//      productInfo += "\tSystem rating: " + product.getRating().getSystemRating() + "\n";
//      productInfo += "Ingredeints \n";
//      for (Ingredient ingredient : product.getIngredients()) {
//        productInfo += "\t" + ingredient.getName() + "\n";
//      }
    }
    return operationVariables;
  }
}
