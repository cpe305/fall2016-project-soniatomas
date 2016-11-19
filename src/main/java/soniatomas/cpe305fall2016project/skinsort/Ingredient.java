package main.java.soniatomas.cpe305fall2016project.skinsort;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

@Embedded
public class Ingredient {
  private String name;
  @Embedded
  public Rating rating;

  public Ingredient(String name) {
    this.name = new String(name.toLowerCase());
    this.rating = new Rating();
  }

  public Ingredient() {
    this.name = " ";
    this.rating = new Rating();
  }

  public String getName() {
    return new String(name);
  }

  public void setName(String name) {
    name = name.toLowerCase();
    this.name = name;
  }

  public boolean isEqualTo(Ingredient ingredient) {
    return name.equals(ingredient.getName());
  }

  public void setRating(Rating rating) {
    this.rating = rating;
  }

  public Rating getRating() {
    return this.rating;
  }

  @Override
  public boolean equals(Object object) {
    Ingredient otherIngredient = (Ingredient) object;
    return name.equals(otherIngredient.getName());
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }

}
