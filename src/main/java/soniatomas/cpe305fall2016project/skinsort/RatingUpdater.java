package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class RatingUpdater {

  public void updateRatingsAfterAddingNewProduct(Product product) {
    List<Ingredient> ingredients = product.getIngredients();
    IngredientLogger ingredientLogger = SystemData.getInstance().getUser().getIngredientLogger();
    for (Ingredient ingredient : ingredients) {
      if (ingredientLogger.containsIngredient(ingredient)) {
      }
    }
  }
  // the user can update a product user rating
  // the user can also update the user rating of an ingredient.
  
  // involved objects: 
  /// products not in database
  // - for these just find the system rating 
  // products in database
  
  // ingredients in database;
  
  
  // when comparing products, the only thing that is being calculated are the system ratings of the products
  // when comparing with saved products, no need to update their system ratings since they should have been calculated 
  
  // when do ingredient user ratings change:
  // - when the user updates the userRating;
  
  // when do ingredient system ratings change (this is most important):
  // - when the user adds a new product to the history (multiple ingredients)
  // - when the user updates the user rating of a product (multiple ingredients)
  // - when the user deletes a product (multiple ingredinents)
  
  // when do product user ratings change:
  //  - when the user adds a product to the history
  //  - when the user updates the user rating for a saved product
  
  // when do product system ratings change:
  //  - when the user is adding the product to the history (one product)
  //  - when the user updates the user rating for a saved product (on product)
  //  - when the user is viewing information about a product (one product)
  // - when the user is comparing product (2 products)
  // 

  
  // when is the rating important:
  // when the product information is being viewed (updated product system rating
  // when products are compared (update product system rating)
  // when a product is added (update its ingredient system rating, update products system rating)
  // when a product is removed (update all of its ingredients system ratings)
  // when a product has been edited (updated prodcut user rating, update ingredients system ratings, update product system rating)

  
  
  



  public void updateIngredientSystemRating(Ingredient ingredient) {
    Ingredient ingredientToUpdate = SystemData.getInstance().getUser().getIngredientLogger()
        .getIngredient(ingredient);
    ProductHistory productHistory = SystemData.getInstance().getUser().getProductHistory();
    List<String> references = ingredientToUpdate.getRating().getReferences();
    double ratingsTotal = 0;
    double totalProducts = 0;
    for (String reference : references) {
      String data[] = reference.split(",");
      String brand = data[0];
      String name = data[1];
      double productUserRatingValue = productHistory.getProduct(brand, name).getRating()
          .getUserRating();
      ratingsTotal += productUserRatingValue;
      totalProducts++;
    }
    double newRating = ratingsTotal / totalProducts;
    ingredientToUpdate.getRating().setSystemRating(newRating);
  }

  public void updateProductUserRating(String productBrand, String productName, double rating) {
    Product product = SystemData.getInstance().getUser().getProductHistory()
        .getProduct(productBrand, productName);
    product.getRating().setUserRating(rating);
  }

  public void updateProductSystemRating(Product product) {
    IngredientLogger ingredientLogger = SystemData.getInstance().getUser().getIngredientLogger();
    double ratingsTotal = 0;
    int totalIngredients = 0;
    for (Ingredient ingredient : product.getIngredients()) {
      Ingredient loggedIngredient = ingredientLogger.getIngredient(ingredient.getName());
      if (ingredient != null) {
        if (loggedIngredient.getRating().getUserRating() > 0) {
          ratingsTotal += loggedIngredient.getRating().getUserRating();
        } else
          ratingsTotal += loggedIngredient.getRating().getSystemRating();
        totalIngredients++;
      }
    }
    double newRating = ratingsTotal / totalIngredients;
    product.getRating().setSystemRating(newRating);
  }
  
  public void addReferenceToIngredient(Product product, Ingredient ingredient) {
    Ingredient ingredientToUpdate = SystemData.getInstance().getUser().getIngredientLogger()
        .getIngredient(ingredient);
    ingredientToUpdate.getRating().addReference(product.getBrand(), product.getName());
    //updateIngredient(ingredient);
  }

  public void removeReferenceFromIngredient(Product product, Ingredient ingredient) {
    Ingredient ingredientToUpdate = SystemData.getInstance().getUser().getIngredientLogger()
        .getIngredient(ingredient);
    ingredientToUpdate.getRating().addReference(product.getBrand(), product.getName());
  //  updateSystemRatingforIngredient(ingredient);
  }
  

}
