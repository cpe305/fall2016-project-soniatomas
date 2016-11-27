package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class ProductHistory {
  @Embedded
  private List<Product> productHistory;

  /**
   * Constructor for ProductHistory Initializes class variable productHistory.
   */
  public ProductHistory() {
    productHistory = new ArrayList<Product>();
  }

  /**
   * Adds a product to productHistory.
   * 
   * @param product
   */
  public void addProduct(Product product) {
    productHistory.add(product);
  }

  /**
   * gets a product from ProductHistory.
   * 
   * @param productName
   * @return Product or null if Product cannot be found in ProductHistory
   */
  public Product getProduct(String brand, String name) {
    brand = brand.toLowerCase();
    name = name.toLowerCase();
    for (Product product : productHistory) {
      if (product.getName().equals(name) && product.getBrand().equals(brand)) {
        return product;
      }
    }
    return null;
  }

  /**
   * removes a Product form ProductHistory returns Product.
   * 
   * @param productName
   * @return Product that has been removed or null if Product cannot be found in
   *         ProductHistory
   */
  public boolean removeProduct(String brand, String name) {
    name = name.toLowerCase();
    brand = brand.toLowerCase();
    for (Product productInList : productHistory) {
      if (productInList.getBrand().equals(brand) && productInList.getName().equals(name)) {
        return productHistory.remove(productInList);
      }
    }
    return false;
  }

  public List<Product> getProductHistory() {
    return productHistory;
  }

  public boolean containsProduct(String brand, String name) {
    name = name.toLowerCase();
    brand = brand.toLowerCase();
    for (Product product : productHistory) {
      if (product.getBrand().equals(brand) && product.getName().equals(name)) {
        return true;
      }
    }
    return false;
  }
}
