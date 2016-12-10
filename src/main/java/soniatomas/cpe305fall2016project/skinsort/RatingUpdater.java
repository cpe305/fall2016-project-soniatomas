package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class RatingUpdater {

  public double findAddedProductSystemRating(Product product) {
    double userRating = product.getRating().getUserRating();
    IngredientLogger ingredientLogger = SystemData.getInstance().getUser().getIngredientLogger();
    for (Ingredient ingredient : product.getIngredients()) {
      if (ingredientLogger.containsIngredient(ingredient)) {
        Ingredient loggedIngredient = ingredientLogger.getIngredient(ingredient);
        loggedIngredient.getRating().addReference(product.getBrand(), product.getName());
        double newRating = updateIngredientSystemRating(loggedIngredient);
        loggedIngredient.getRating().setSystemRating(newRating);
      } else {
        Ingredient newLoggedIngredient = new Ingredient(ingredient.getName());
        newLoggedIngredient.getRating().addReference(product.getBrand(), product.getName());
        newLoggedIngredient.getRating().setSystemRating(userRating);
        ingredientLogger.addIngredient(newLoggedIngredient);
      }
    }
    return updateProductSystemRating(product);
  }

  public void setProductsUserRating(Product product, Double userRating) {
    product.getRating().setUserRating(userRating);
    updateProductSystemRating(product);
  }

  public void updateIngredientRatingsAfterRemovingProduct(Product product) {
    IngredientLogger ingredientLogger = SystemData.getInstance().getUser().getIngredientLogger();
    for (Ingredient ingredient : product.getIngredients()) {
      Ingredient ingredientToUpdate = ingredientLogger.getIngredient(ingredient);
      try {
        ingredientToUpdate.getRating().removeReference(product.getBrand(), product.getName());
        double newRating = updateIngredientSystemRating(ingredientToUpdate);
        ingredient.getRating().setSystemRating(newRating);
      } catch (NullPointerException e) {

      }
    }
  }

  public double updateIngredientSystemRating(Ingredient ingredient) {
    Ingredient ingredientToUpdate = ingredient;
    ProductHistory productHistory = SystemData.getInstance().getUser().getProductHistory();
    List<String> references = ingredientToUpdate.getRating().getReferences();
    double ratingsTotal = 0;
    int totalProducts = 0;
    for (String reference : references) {
      String data[] = reference.split(",");
      String brand = data[0].trim();
      String name = data[1].trim();
      Product product = productHistory.getProduct(brand, name);
      if (product != null) {
        double productUserRatingValue = product.getRating().getUserRating();
        ratingsTotal += productUserRatingValue;
        totalProducts++;
      }
    }
    double newRating = 0.0;
    if (totalProducts != 0) {
    newRating = ratingsTotal / totalProducts;
    }
    ingredientToUpdate.getRating().setSystemRating(newRating);
    return newRating;
  }

  public double updateProductSystemRating(Product product) {
    IngredientLogger ingredientLogger = SystemData.getInstance().getUser().getIngredientLogger();
    double ratingsTotal = 0;
    int totalIngredients = 0;
    for (Ingredient ingredient : product.getIngredients()) {
      Ingredient loggedIngredient = ingredientLogger.getIngredient(ingredient.getName());

      if (loggedIngredient != null) {
        if (loggedIngredient.getRating().getUserRating() > 0) {
          ratingsTotal += loggedIngredient.getRating().getUserRating();
        } else
          ratingsTotal += loggedIngredient.getRating().getSystemRating();
        totalIngredients++;
      }
    }

    double newRating = 0.0;
    if (totalIngredients != 0) {
      newRating = ratingsTotal / totalIngredients;
    }
    return newRating;
  }

}
