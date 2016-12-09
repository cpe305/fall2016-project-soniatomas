package test.java.soniatomas.cpe305fall2016project.skinsort;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.soniatomas.cpe305fall2016project.skinsort.*;

public class ProductTableViewElementTest {

  @Test
  public void TestProductTableViewElement() {
    ProductTableViewElement tableElement = new ProductTableViewElement("Skin care", "lotion", "Jergen's", "Coconut body lotion", "july 04, 2016");
    assertEquals("Skin care", tableElement.getCategory());
    assertEquals("lotion", tableElement.getType());
    assertEquals("Jergen's", tableElement.getBrand());
    assertEquals("Coconut body lotion", tableElement.getName());
    assertEquals("july 04, 2016", tableElement.getDate());
  }
  
  @Test
  public void TestProductTableViewElementDifferentInstantiation() {
    ProductTableViewElement tableElement = new ProductTableViewElement();
    tableElement.setBrand("Jergen's");
    assertEquals("Jergen's", tableElement.getBrand());
  }

}
