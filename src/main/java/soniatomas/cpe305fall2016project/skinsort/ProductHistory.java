package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Hashtable;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class ProductHistory {
  @Embedded
  private List<Product> productHistory;
  @Embedded
  private Hashtable<String, String> categories;
  @Embedded
  private Hashtable<String, String> brands;
  @Embedded
  private Hashtable<String, String> types;

  /**
   * Constructor for ProductHistory Initializes class variable productHistory.
   */
  public ProductHistory() {
    this.productHistory = new ArrayList<Product>();
    this.categories = new Hashtable<String, String>();
    this.brands = new Hashtable<String, String>();
    this.types = new Hashtable<String, String>();

  }

  /**
   * Adds a product to productHistory.
   * 
   * @param product
   */
  public void addProduct(Product product) {
    if (!brands.containsKey(product.getBrand())) {
      brands.put(product.getBrand(), product.getBrand());
    }
    if (!categories.containsKey(product.getCategory())) {
      categories.put(product.getCategory(), product.getCategory());
    }
    if (!types.containsKey(product.getType())) {
      brands.put(product.getType(), product.getType());
    }
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
      if (productHistory.size() == 0) {
        this.categories = new Hashtable<String, String>();
        this.brands = new Hashtable<String, String>();
        this.types = new Hashtable<String, String>();
      }
    }

    return false;
  }

  public List<Product> getProductHistory() {
    return productHistory;
  }

  public List<Product> getProducts() {
    return productHistory;
  }

  public List<String> getBrands() {
    return new ArrayList<String>(brands.values());
  }

  public List<String> getTypes() {
    return new ArrayList<String>(types.values());
  }

  public List<String> getCategories() {
    return new ArrayList<String>(categories.values());
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
