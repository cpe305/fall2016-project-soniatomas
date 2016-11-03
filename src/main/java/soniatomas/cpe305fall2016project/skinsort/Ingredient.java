package main.java.soniatomas.cpe305fall2016project.skinsort;

public class Ingredient {
  private String name;
  public Rating rating;

  public Ingredient(String name) {
    this.name = new String(name.toLowerCase());
    this.rating = new Rating();
  }

  public String getName() {
    return new String(name);
  }

  public boolean isEqualTo(Ingredient ingredient) {
    return name.equals(ingredient.getName());
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
