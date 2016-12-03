package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class RatingUpdater {

  public void updateRatingbyProduct(Product product) {
    List<Ingredient> ingredients = product.getIngredients();
    IngredientLogger ingredientLogger = SystemData.getInstance().getUser().getIngredientLogger();
//    for (Ingredient ingredient : ingredients) {
//     if (!ingredientLogger.containsIngredient(ingredient)) {
//       
//     }
//    }
  }
}
