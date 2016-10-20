package models;

import java.util.*;

public interface Product {
	public String getName();
	public void addIngredient(Ingredient ingredient);
	public LinkedList<Ingredient> getIngredients();
	public boolean containsIngredient(Ingredient ingredient);
	public boolean isSameType(Product product);

}
