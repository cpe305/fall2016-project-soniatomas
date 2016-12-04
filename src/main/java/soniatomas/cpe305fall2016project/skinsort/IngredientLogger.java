package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.HashMap;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;

import java.util.ArrayList;
import java.util.Collection;

@Embedded
public class IngredientLogger {
    @Embedded
    private HashMap<String, Ingredient> logger;
    
    public IngredientLogger() {
      logger = new HashMap<String, Ingredient>();
    }
    public void addIngredient(Ingredient ingredient) {
      if (!logger.containsKey(ingredient.getName())) {
        logger.put(ingredient.getName(), ingredient);
      }
    }
    public boolean removeIngredient(Ingredient ingredient) {
      if (logger.containsKey(ingredient.getName())) {
        logger.remove(ingredient.getName());
        return true;
      }
      else return false;
    }
    public boolean removeIngredient(String ingredient) {
      ingredient = ingredient.toLowerCase();
      if(logger.containsKey(ingredient)) {
        logger.remove(ingredient);
        return true;
      }
      else return false;
    }
    public Ingredient getIngredient(String ingredient) {
      if (logger.containsKey(ingredient)) {
        return logger.get(ingredient);
      }
      else return null;
    }
    public Ingredient getIngredient(Ingredient ingredient) {
      if (logger.containsKey(ingredient.getName())) {
        return logger.get(ingredient.getName());
      }
      else return null;
    }
    public boolean containsIngredient(String ingredient) {
      return logger.containsKey(ingredient);
    }
    public boolean containsIngredient(Ingredient ingredient) {
      return logger.containsKey(ingredient.getName());
    } 
    public List<Ingredient> getIngredients() {
      Collection<Ingredient> ingredientCollection = logger.values();
      ArrayList<Ingredient> listOfIngredients = new ArrayList<Ingredient>(ingredientCollection);
      return listOfIngredients;
    }
    
    
}