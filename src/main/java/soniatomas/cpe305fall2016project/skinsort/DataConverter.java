package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Hashtable;

//import java.util
public class DataConverter {
  
  public List<Hashtable<String, String>> getListOfProductData(List<Product> productList) {
    List<Hashtable<String, String>> productData = new ArrayList<Hashtable<String, String>>();
    //List<Product> productList = SystemData.getInstance().getUser().getProductHistory().getProductHistory();
    
    for (Product product : productList) {
      Hashtable<String, String> productTable = new Hashtable<String, String>();
      productTable.put("CATEGORY", product.getCategory());
      productTable.put("TYPE", product.getType());
      productTable.put("BRAND", product.getBrand());
      productTable.put("NAME", product.getName());
      productTable.put("DATE", product.getDateUpdated());
      productData.add(productTable);
    }
    return productData;
  }
  
  public ObservableList<ProductTableViewElement> getObservableProductList(List<Product> productList) {
    ObservableList<ProductTableViewElement> list = FXCollections.observableArrayList();
    for (Product product : productList) {
      list.add(new ProductTableViewElement(product.getCategory(), product.getType(), product.getBrand(), product.getName(), product.getDateUpdated()));
    }
    return list;
  }
  
  public Hashtable<String, String> getProductData(Product product) {
    Hashtable<String, String> productTable = new Hashtable<String, String>();
    productTable.put("CATEGORY", product.getCategory());
    productTable.put("TYPE", product.getType());
    productTable.put("BRAND", product.getBrand());
    productTable.put("NAME", product.getName());
    productTable.put("DATE", product.getDateUpdated());
    productTable.put("USER_RATING",Double.toString(product.getRating().getUserRating()));
    productTable.put("SYSTEM_RATING",Double.toString(product.getRating().getSystemRating()));
    productTable.put("PRICE",Double.toString(product.getPrice()));
    List<Ingredient> ingredientList = product.getIngredients();
    int ingredientNumber = 1;
    for (Ingredient ingredient : ingredientList) {
      productTable.put("INGREDIENT_" + ingredientNumber, ingredient.getName());
      ingredientNumber++;
    }
    productTable.put("TOTAL_INGREDIENTS", "" + ingredientNumber);
    
    return productTable;
  }
  
  public Hashtable<String, String> getUserData(User user) {
    Hashtable<String, String> userTable = new Hashtable<String, String>();
    userTable.put("EMAIL", user.getEmail());
    userTable.put("FIRST_NAME", user.getFirstName());
    userTable.put("LAST_NAME", user.getLastName());
    
    return userTable;
  }
  
  
}
