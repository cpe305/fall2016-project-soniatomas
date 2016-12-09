package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class RatingUpdater {

  // these might not work since java is pass by value;

  // sets and added products user ratings
  // adds a reference of it to its ingredients and then find the system ratings
  // of those ingredients
  // find the system rating of the product.
  // public void setAddedProductUserRating(Product product, Rating rating) {
  // public void setAddedProductUserRating(Product product, double userRating) {
  // product.getRating().setUserRating(userRating);
  // IngredientLogger ingredientLogger =
  // SystemData.getInstance().getUser().getIngredientLogger();
  // for (Ingredient ingredient : product.getIngredients()) {
  // if (ingredientLogger.containsIngredient(ingredient)) {
  // Ingredient loggedIngredient = ingredientLogger.getIngredient(ingredient);
  // loggedIngredient.getRating().addReference(product.getBrand(),
  // product.getName());
  // updateIngredientSystemRating(loggedIngredient);
  // } else {
  // Ingredient newLoggedIngredient = new Ingredient(ingredient.getName());
  // newLoggedIngredient.getRating().addReference(product.getBrand(),
  // product.getType());
  // newLoggedIngredient.getRating().setSystemRating(userRating);
  // }
  // updateProductSystemRating(product);
  // }
  //
  // }

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
        newLoggedIngredient.getRating().addReference(product.getBrand(), product.getType());
        newLoggedIngredient.getRating().setSystemRating(userRating);
        ingredientLogger.addIngredient(newLoggedIngredient);
      }
    }
    return updateProductSystemRating(product);
  }

  // sets a products user rating
  // finds its system rating whithout addding a refenrence of it its
  // ingredients
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

  // the user can update a product user rating
  // the user can also update the user rating of an ingredient.

  // involved objects:
  /// products not in database
  // - for these just find the system rating
  // products in database

  // ingredients in database;

  // when comparing products, the only thing that is being calculated are the
  // system ratings of the products
  // when comparing with saved products, no need to update their system ratings
  // since they should have been calculated

  // when do ingredient user ratings change:
  // - when the user updates the userRating;

  // when do ingredient system ratings change (this is most important):
  // - when the user adds a new product to the history (multiple ingredients)
  // - when the user updates the user rating of a product (multiple ingredients)
  // - when the user deletes a product (multiple ingredinents)

  // when do product user ratings change:
  // - when the user adds a product to the history
  // - when the user updates the user rating for a saved product

  // when do product system ratings change:
  // - when the user is adding the product to the history (one product)
  // - when the user updates the user rating for a saved product (on product)
  // - when the user is viewing information about a product (one product)
  // - when the user is comparing product (2 products)
  //

  // when is the rating important:
  // when the product information is being viewed (updated product system rating
  // when products are compared (update product system rating)
  // when a product is added (update all of its ingredients system ratings,
  // update products system rating)
  // when a product is removed (update all of its ingredients system ratings)
  // when a product has been edited (updated prodcut user rating, update
  // ingredients system ratings, update product system rating)

  // when you remove a product, first deleta all references of if from all its
  // ingredients.
  // the update the sytem ratings of all fof those ingrdients.
  // alternative would be to to as you add add there referecne of the product to
  // the ingredient, just immediately
  // immediately calculated the system rating fo that ingredient.
  // when

  // had a seperate method, where you just updated an ingredient from all of its
  // references.
  // have a seprate methods, where you just update a products system rating
  // based on their ingredients
  // when you remove a product, you delete its refrecen to all the ingredinets,
  // and then you calculate a new system rating for taht ingrdient
  // go this.

  public double updateIngredientSystemRating(Ingredient ingredient) {
    // Ingredient ingredientToUpdate =
    // SystemData.getInstance().getUser().getIngredientLogger()
    // .getIngredient(ingredient);
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

  // public void addReferenceToIngredient(Product product, Ingredient
  // ingredient) {
  // Ingredient ingredientToUpdate =
  // SystemData.getInstance().getUser().getIngredientLogger()
  // .getIngredient(ingredient);
  // ingredientToUpdate.getRating().addReference(product.getBrand(),
  // product.getName());
  // //updateIngredient(ingredient);
  // }

  // public void removeReferenceFromIngredient(Product product, Ingredient
  // ingredient) {
  // Ingredient ingredientToUpdate =
  // SystemData.getInstance().getUser().getIngredientLogger()
  // .getIngredient(ingredient);
  // ingredientToUpdate.getRating().addReference(product.getBrand(),
  // product.getName());
  // // updateSystemRatingforIngredient(ingredient);
  // }

  // public void updateProductUserRating(String productBrand, String
  // productName, double rating) {
  // Product product = SystemData.getInstance().getUser().getProductHistory()
  // .getProduct(productBrand, productName);
  // product.getRating().setUserRating(rating);
  // }

}
