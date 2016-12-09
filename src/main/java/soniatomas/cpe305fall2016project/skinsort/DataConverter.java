package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Hashtable;

//import java.util
public class DataConverter {
  
//  public List<Hashtable<String, String>> getListOfProductData(List<Product> productList) {
//    List<Hashtable<String, String>> productData = new ArrayList<Hashtable<String, String>>();
//    for (Product product : productList) {
//      Hashtable<String, String> productTable = new Hashtable<String, String>();
//      productTable.put("CATEGORY", product.getCategory());
//      productTable.put("TYPE", product.getType());
//      productTable.put("BRAND", product.getBrand());
//      productTable.put("NAME", product.getName());
//      productTable.put("DATE", product.getDateUpdated());
//      productData.add(productTable);
//    }
//    return productData;
//  }
  
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
    double systemRating = product.getRating().getSystemRating();
    productTable.put("SYSTEM_RATING",Double.toString(systemRating));
    productTable.put("PRICE", Double.toString(product.getPrice()));
    if (systemRating <= 3.2) {
      productTable.put("RECOMMENDATION", "bad" );
    }
    else if (systemRating <= 7.4) {
      productTable.put("RECOMMENDATION", "neutral" );
    }
    else 
      productTable.put("RECOMMENDATION", "good" );
    return productTable;
  }
  
  public Hashtable<String, String> getUserData(User user) {
    Hashtable<String, String> userTable = new Hashtable<String, String>();
    userTable.put("EMAIL", user.getEmail());
    userTable.put("FIRST_NAME", user.getFirstName());
    userTable.put("LAST_NAME", user.getLastName()); 
    return userTable;
  }
  
  public ObservableList<String> getObservableIngredientList(List<Ingredient> ingredientList) {
    ObservableList<String> list = FXCollections.observableArrayList();
    for (Ingredient ingredient : ingredientList) {
      list.add(ingredient.getName());
    }
    return list;
  } 
  
  public ObservableList<String> getObservableStringList(List<String> listOfStrings) {
    //ObservableList<String> list = FXCollections.observableArrayList();
//    for (Ingredient ingredient : ingredientList) {
//      list.add(ingredient.getName());
////    }
//    return list;
    return FXCollections.observableArrayList(listOfStrings);
  } 
  
}
