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
  private String brand;
  private String category;
  private String type;
  private double price;
  private String dateUpdated;
  
  @Embedded
  private List<Ingredient> ingredients;
  @Embedded
  private Rating rating;

  public Product(String category, String type, String brand, String name) {
    this.name = new String(name.toLowerCase());
    this.category = new String(category.toLowerCase());
    this.brand = new String(brand.toLowerCase());
    this.type = new String(type.toLowerCase());
    this.ingredients = new ArrayList<Ingredient>();
    this.rating = new Rating();
    this.price = 0.0;
    UpdateDateUpdated();

  }

  public Product() {
    this.name = "";
    this.category = "";
    this.brand = "";
    this.type = "";
    this.ingredients = new ArrayList<Ingredient>();
    this.rating = new Rating();
    this.price = 0.0;
    UpdateDateUpdated();
  }

  public String getName() {
    return new String(name);
  }

  public void setName(String name) {
    this.name = name.toLowerCase();
  }
  
  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand.toLowerCase();
  }
  
  public String getCategory() {
    return new String(category);
  }

  public void setCatergory(String category) {
    this.category = category.toLowerCase();
  }
  
  public String getType() {
    return new String(type);
  }

  public void setType(String type) {
    this.type = type.toLowerCase();
  }
  public void setRating(Rating rating) {
    this.rating = rating;
  }

  public Rating getRating() {
    return this.rating;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
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

  public boolean containsIngredient(String ingredient) {
    for (Ingredient ingredientInList : ingredients) {
      if (ingredientInList.getName().equals(ingredient))
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

  public void setIngredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
    UpdateDateUpdated();
  }

  public String getDateUpdated() {
    return dateUpdated;
  }

  public void setDateUpdated(String newDate) {
    this.dateUpdated = newDate;
  }

  private void UpdateDateUpdated() {
    String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
        "Dec" };
    GregorianCalendar calendar = new GregorianCalendar();
    this.dateUpdated = new String(months[calendar.get(Calendar.MONTH)] + " "
        + calendar.get(Calendar.DATE) + ", " + calendar.get(Calendar.YEAR) + ", "
        + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE));
  }

}
