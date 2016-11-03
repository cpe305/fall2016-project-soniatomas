package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.*;

/**
 * Rating class that represents the rating of a product or an ingredient.
 * contains Rating of the user, rating determined by the system, and maintains the name
 * of the products/ingredients that help determine the rating.
 * This class does not do any calculations or logic to determine the system rating of the 
 * ingredient or product, it only holds the rating values and returns them when called.
 * System rating determined by RatingLogic Class
 * @author Sonia
 *
 */
public class Rating {
  private double userRating; // User rating
  private double systemRating; // System rating 
  private ArrayList<String> references; 
  // Names of the ingredients or products that help determine the rating.
  // If this rating object is for an Ingredient, then references contains the names
  // of the products that affect the rating of the Ingredient.
  // If this rating object is for a Product, then references contains the names of
  // Ingredients that affect the rating of the Product.
  /**
   * Creates a new Rating object. Ingredient and Product have a rating.
   */
  public Rating()
  {
    references = new ArrayList<String>();
    userRating = 0;
    systemRating = 0;
  }
  /**
   * Sets User rating, the rating inputted by the user.
   * Rating ranges from 0 to 10
   * @param newRating - value of the new rating
   */
  public void setUserRating(double newRating)
  {
    this.userRating = newRating;
  }
  /**
   * Sets system rating, the rating calculated/determined by the system.
   * Rating ranges from 0 to 10
   * @param newRating - value of the new rating
   */
  public void setSystemRating(double newRating)
  {
    this.systemRating = newRating;
  }
  /**
   * Returns the values of the user rating
   * @return double value of the user rating
   */
  public double getUserRating()
  {
    return userRating;
  }
  /**
   * Returns the values of the system rating
   * @return double value of the system rating
   */
  public double getSystemRating()
  {
    return systemRating;
  }
  /**
   * Add the name of reference products or ingredients that help the system determine the
   * rating for the product or ingredient.
   * If this rating object belongs to an Ingredient, then references will contain the 
   * names of the Products that affect the rating of the Ingredient.
   * If this rating object belongs to a Product, then references contains the name of the 
   * Ingredients that affect the rating of the Product. 
   */
  public void addReference(String reference)
  {
    references.add(reference.toLowerCase());
  }
  /**
   * 
   * @param reference - the name of the reference Ingredient or Product to remove
   * @return true if the name of the reference Ingredient or Product has been removed,
   * false if it could not be removed.
   */
  public boolean removeReference(String reference)
  {
    return references.remove(reference.toLowerCase());
  }

}
