package main.java.soniatomas.cpe305fall2016project.skinsort;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProductTableViewElement {

  private StringProperty category;
  private StringProperty type;
  private StringProperty brand;
  private StringProperty name;
  private StringProperty date;
  
  public ProductTableViewElement() {

  }

  public ProductTableViewElement(String category, String type, String brand, String name, String date) {
    setCategory(category);
    setType(type);
    setBrand(brand);
    setName(name);
    setDate(date);
  }
  

  public void setCategory(String value) {
    categoryProperty().set(value);
  }

  public String getCategory() {
    return categoryProperty().get();
  }

  public StringProperty categoryProperty() {
    if (category == null)
      category = new SimpleStringProperty(this, "category");
    return category;
  }

  public void setType(String value) {
    typeProperty().set(value);
  }

  public String getType() {
    return typeProperty().get();
  }

  public StringProperty typeProperty() {
    if (type == null)
      type = new SimpleStringProperty(this, "type");
    return type;
  }

  public void setBrand(String value) {
    brandProperty().set(value);
  }

  public String getBrand() {
    return brandProperty().get();
  }

  public StringProperty brandProperty() {
    if (brand == null)
      brand = new SimpleStringProperty(this, "brand");
    return brand;
  }

  public void setName(String value) {
    nameProperty().set(value);
  }

  public String getName() {
    return nameProperty().get();
  }

  public StringProperty nameProperty() {
    if (name == null)
      name = new SimpleStringProperty(this, "name");
    return name;
  }
   
  
  public void setDate(String value) {
    dateProperty().set(value);
  }

  public String getDate() {
    return dateProperty().get();
  }

  public StringProperty dateProperty() {
    if (date == null)
      date = new SimpleStringProperty(this, "date");
    return date;
  }

  
}
