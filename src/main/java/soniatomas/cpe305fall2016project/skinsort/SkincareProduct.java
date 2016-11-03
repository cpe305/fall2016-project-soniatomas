package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.HashMap;
import java.util.LinkedList;

public class SkincareProduct implements Product {
  private String name;
  private HashMap<Ingredient, Ingredient> ingredients;
  public Rating rating;

  public SkincareProduct(String name) {
    this.name = new String(name.toLowerCase());
    this.ingredients = new HashMap<Ingredient, Ingredient>();
    this.rating = new Rating();
  }

  public String getName() {
    return new String(name);
  }

  public void addIngredient(Ingredient ingredient) {
    ingredients.put(ingredient, ingredient);
  }

  public void addIngredient(String ingredientName) {
    Ingredient newIngredient = new Ingredient(ingredientName);
    ingredients.put(newIngredient, newIngredient);
  }

  public LinkedList<Ingredient> getIngredients() {
    LinkedList<Ingredient> ingredientsToReturn = new LinkedList<Ingredient>(ingredients.values());
    return ingredientsToReturn;
  }

  public boolean containsIngredient(Ingredient ingredient) {
    return ingredients.containsKey(ingredient);
  }

  public boolean isSameType(Product product) {
    return this.getClass().equals(product.getClass());
  }

}
