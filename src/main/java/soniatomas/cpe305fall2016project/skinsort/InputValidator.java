package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.*;

public class InputValidator {

  public List<String> ingredientInputStringToList(String input) {
    String ingredientStrings[] = input.split(".*\\W+.*");
    for (int index = 0; index < ingredientStrings.length; index++) {
      ingredientStrings[index] = ingredientStrings[index].trim().toLowerCase();
    }
    return Arrays.asList(ingredientStrings);
  }

  public boolean isValidDoubleValue(String value) {
    boolean isValid = false;
    double rating = 0;
    try {
      rating = Double.parseDouble(value);
      if (rating >= 0) {
        isValid = true;
      }
    } catch (Exception e) {
      isValid = false;
    }
    return isValid;
  }

  public double getDoubleValue(String value) {
    double double_value;
    try {
      double_value = Double.parseDouble(value);

    } catch (Exception e) {
      double_value = 0;
    }
    return double_value;
  }

}
