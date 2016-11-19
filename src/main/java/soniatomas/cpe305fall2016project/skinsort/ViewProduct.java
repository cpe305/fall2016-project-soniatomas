package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.ArrayList;

public class ViewProduct implements Operation {
  public boolean execute(ArrayList<String> parameters) {
    String name = parameters.get(0);
    String productInfo = "";
    if (SystemData.getInstance().getUser() != null) {
      User user = SystemData.getInstance().getUser();
      Product product = user.getProductHistory().getProduct(name);
      productInfo += "Product Name : " + product.getName() + "\n";
      productInfo += "Date updated : " + product.getDateUpdated() + "\n";
      productInfo += "Price : " + product.getPrice();
      productInfo += "Ratings\n";
      productInfo += "\tUser rating: " + product.getRating().getUserRating() + "\n";
      productInfo += "\tSystem rating: " + product.getRating().getSystemRating() + "\n";
      productInfo += "Ingredeints \n";
      for (Ingredient ingredient : product.getIngredients()) {
        productInfo += "\t" + ingredient.getName() + "\n";
      }
      return true;
    }
    return false;
  }
}
