package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.HashMap;
import java.util.Hashtable;

import javafx.collections.ObservableList;

public class ViewProductDataOperation implements Operation {

  private HashMap<String, Object> operationVariables;

  public ViewProductDataOperation() {
    operationVariables = new HashMap<String, Object>();
  }
  
  public HashMap<String, Object> getVariables() {
    return operationVariables;
  }

  public HashMap<String, Object> execute(HashMap<String, String> parameters) {
    Product product = SystemData.getInstance().getProductOne();
    RatingUpdater updater = new RatingUpdater();
    double systemRating = updater.updateProductSystemRating(product);
    try {
      product.getRating().setSystemRating(systemRating);
    } catch (Exception e) {
      
    }
    DataConverter dataConverter = new DataConverter();
    Hashtable<String, String> productData= dataConverter.getProductData(product);
    operationVariables.put("product_data", productData);
    ObservableList<String> ingredientList = dataConverter.getObservableIngredientList(product.getIngredients());
    operationVariables.put("ingredient_list", ingredientList);
    return operationVariables;
  }
}
