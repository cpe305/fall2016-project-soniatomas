package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Product {

  private String name;
  @Embedded
  private List<Ingredient> ingredients;
  @Embedded
  private Rating rating;
  private double price;
  private String dateUpdated;

  public Product(String name) {
    this.name = new String(name.toLowerCase());
    //this.ingredients = new LinkedList<Ingredient>();
    this.ingredients = new ArrayList<Ingredient>();
    this.rating = new Rating();
    this.price = 0.0;
    UpdateDateUpdated();
    
  }
  
  public Product() {
    this.name = " ";
    //this.ingredients = new LinkedList<Ingredient>();
    this.ingredients = new ArrayList<Ingredient>();
    this.rating = new Rating();
    this.price = 0.0;
    UpdateDateUpdated();
  }

  public String getName() {
    return new String(name);
  }

  public void setName(String name) {
    name = name.toLowerCase();
    this.name = name;
  }
  
  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public boolean containsIngredient(Ingredient ingredient) {
    for (Ingredient ingredientInList : ingredients) {
      if (ingredientInList.equals(ingredient))
        return true;
    }
    return false;
  }

  public void addIngredient(Ingredient ingredient) {
    ingredients.add(ingredient);
    UpdateDateUpdated();
  }

  public void addIngredient(String ingredientName) {
    Ingredient newIngredient = new Ingredient(ingredientName);
    ingredients.add(newIngredient);
    UpdateDateUpdated();
  }
  
  public void setIngredients(List<Ingredient> ingredients)
  {
    this.ingredients = ingredients;
    UpdateDateUpdated();
  }
  public void setRating(Rating rating)
  {
    this.rating = rating;
  }
  public Rating getRating()
  {
    return this.rating;
  }
  
  public double getPrice() {
    return price;
  }
  
  public void setPrice(double price) {
    this.price = price;
    
  }
  
  public String getDateUpdated() {
    return dateUpdated;
  }
  
  public void setDateUpdated(String newDate)
  {
    this.dateUpdated = newDate;
  }
  private void UpdateDateUpdated()
  {
    String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", 
        "Oct", "Nov", "Dec"};
    GregorianCalendar calendar = new GregorianCalendar();
    this.dateUpdated = new String(months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE)
      + ", " + calendar.get(Calendar.YEAR) + ", " + calendar.get(Calendar.HOUR)
      + ":" + calendar.get(Calendar.MINUTE) );
  }
  /*
   * private String name; private LinkedList<Ingredient> ingredients;
   * 
   * public MakeupProduct(String name, LinkedList<Ingredient> ingredients) {
   * this.name = new String(name.toLowerCase()); this.ingredients = new
   * LinkedList<Ingredient>(ingredients); } public String getName() { return new
   * String(name); } public LinkedList<Ingredient> getIngredients() {
   * LinkedList<Ingredient> ingredientsToReturn = new
   * LinkedList<Ingredient>(ingredients); return ingredientsToReturn; } public
   * boolean containsIngredient(Ingredient ingredient) { return
   * ingredients.contains(ingredient); } public boolean isSameType(Product
   * product) { return this.getClass().equals(product.getClass()); }
   */

}
