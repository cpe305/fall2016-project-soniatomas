package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class IngredientLogger {
    private HashMap<String, Ingredient> logger;
    
    public IngredientLogger() {
      logger = new HashMap<String, Ingredient>();
    }
    
    public boolean addIngredient(String name) {
      if (!logger.containsKey(name))
      {
        logger.put(name, new Ingredient(name));
        return true;
      }
      else return false;
    }
    public boolean addIngrediet(Ingredient ingredient) {
      if (!logger.containsKey(ingredient.getName())) {
        logger.put(ingredient.getName(), ingredient);
        return true;
      }
      else return false;
    }
    public boolean removeIngredient(Ingredient ingredient) {
      if(!logger.containsKey(ingredient.getName())) {
        logger.remove(ingredient.getName());
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
    public boolean containsIngredient(String ingredient) {
      return logger.containsKey(ingredient);
    }
    public boolean containsIngredient(Ingredient ingredient) {
      return logger.containsKey(ingredient.getName());
    } 
    
    
}