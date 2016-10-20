package controllers;

import models.*;
import java.util.*;

public class ProductComparator 
{
	/**
	 * Finds the Ingredients that are common amoung the two Products. Returns the Ingredients are found in both
	 * productOne and productTwo. Only Products of the same type can be compared. 
	 * For example, a user can only compare a SkincareProduct against another SkincareProduct.
	 * If the Products are not of the same type, then a ProductException is thrown.
	 * Returns null if there are no common Ingredients.
	 * @param productOne - Product
	 * @param productTwo - Product to compare
	 * @return Linked list containing ingredients that are only common among the two products.
	 * 
	 */
	public LinkedList<Ingredient> getCommonIngredients(Product productOne, Product productTwo) throws ProductException
	{
		return null;
	}

	/**
	 * Finds and returns the Ingredients are unique to productOne compared to productTwo, in others words it returns
	 * only the Ingredients that can be found in productOne.
	 * Only Products of the same type can be compared. 
	 * For example, a user can only compare a SkincareProduct against another SkincareProduct.
	 * If the Products are not of the same type, then a ProductException is thrown.
	 * Returns null if there are no unique Ingredients in productOne
	 * @param productOne - Product 
	 * @param productTwo - Product to compare against
	 * @return Linked list containing ingredients that are only common among the two products.
	 * 
	 */
	public LinkedList<Ingredient> getUniqueIngredients(Product productOne, Product productTwo) throws ProductException
	{
		return null;
	}
	
	
	
	
}
