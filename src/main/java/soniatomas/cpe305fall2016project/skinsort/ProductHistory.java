package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.LinkedList;
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
  public Product getProduct(String name) {
    Product retrievedProduct = null;
    for (Product product : productHistory) {
      if (product.getName().equals(name)) {
        retrievedProduct = product;
        return retrievedProduct;
      }
    }
    return retrievedProduct;
  }

  /**
   * removes a Product form ProductHistory returns Product.
   * 
   * @param productName
   * @return Product that has been removed or null if Product cannot be found in
   *         ProductHistory
   */
  public boolean removeProduct(String productName) {
    productName = productName.toLowerCase();
    for (Product productInList : productHistory) {
      if (productInList.getName().equals(productName)) {
        return productHistory.remove(productInList);
      }
    }
    return false;
  }

  public List<Product> getProductHistory() {
    return productHistory;
  }

}
