package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.LinkedList;

public interface Product {
  public String getName();
  
  public void addIngredient(Ingredient ingredient);

  public void addIngredient(String ingredientName);

  public LinkedList<Ingredient> getIngredients();
  
  public boolean containsIngredient(Ingredient ingredient);

  public boolean isSameType(Product product);

}
