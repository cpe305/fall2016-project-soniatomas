package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.HashMap;
import java.util.List;

public class AddProductOperation implements Operation {
  private HashMap<String, Object> operationVariables;

  public AddProductOperation() {
    operationVariables = new HashMap<String, Object>();
  }

  public HashMap<String, Object> getVariables() {
    return operationVariables;
  }

  public HashMap<String, Object> execute(HashMap<String, String> parameters) {
    operationVariables.put("status", "FAILURE");
    User user = SystemData.getInstance().getUser();
    if (user != null) {
      String name = parameters.get("name");
      String brand = parameters.get("brand");
      String category = parameters.get("category");
      String type = parameters.get("type");
      String priceString = parameters.get("price");
      String userRatingStr = parameters.get("user_rating");
      double user_rating = Double.parseDouble(userRatingStr);
      double price = Double.parseDouble(priceString);
      Product product = new Product(category, type, brand, name);
      product.setPrice(price);
      Rating rating = new Rating();
      rating.setSystemRating(0);
      rating.setUserRating(user_rating);
      product.setRating(rating);
      String ingredients = parameters.get("ingredients");
      InputValidator inputValidator = new InputValidator();
      List<String> ingredientList = inputValidator.ingredientInputStringToList(ingredients);
      for (String ingredient : ingredientList) {
        Ingredient newIngredient = new Ingredient(ingredient);
        product.addIngredient(newIngredient);
      }
      user.getProductHistory().addProduct(product);
      if (DatabaseManager.getInstance().saveUpdatesToDatabae()) {
        operationVariables.put("status", "SUCCESS");
      }
      else {
        operationVariables.put("status", "DATABASE_ERROR");
      }
    }
    return operationVariables;
  }

}
