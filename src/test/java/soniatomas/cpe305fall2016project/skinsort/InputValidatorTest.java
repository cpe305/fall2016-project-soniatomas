package test.java.soniatomas.cpe305fall2016project.skinsort;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import main.java.soniatomas.cpe305fall2016project.skinsort.*;
public class InputValidatorTest {
  
  @Test
  public void TestIngredientInput() {
    InputValidator inputValidator = new InputValidator();
    List<String> ingredList = inputValidator.ingredientInputStringToList("aqua, cetycyl, alcohol");
    assertEquals("aqua", ingredList.get(0));
    assertEquals("cetycyl", ingredList.get(1));
    assertEquals("alcohol", ingredList.get(2));
  }

  @Test
  public void TestIsValidDoubleValue() {
    InputValidator inputValidator = new InputValidator();
    assertEquals(false, inputValidator.isValidDoubleValue("asbc"));
    assertEquals(false, inputValidator.isValidDoubleValue("-7.6"));
    assertEquals(true, inputValidator.isValidDoubleValue("7.6"));
    
  }

  @Test
  public void TestGetDoubleValue() {
    InputValidator inputValidator = new InputValidator();
    assertEquals(false, inputValidator.isValidDoubleValue("asbb"));
    assertEquals(false, inputValidator.isValidDoubleValue("-7.6"));
    assertEquals(true, inputValidator.isValidDoubleValue("4.4"));
    
  }

}
