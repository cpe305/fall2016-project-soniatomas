package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sonia
 */
public class AddProductSceneController implements Initializable {

  @FXML
  ChoiceBox<String> categorySelect;
  @FXML
  ChoiceBox<String> typeSelect;
  @FXML
  ChoiceBox<String> brandSelect;
  @FXML
  Label statusLabel;

  @FXML
  TextField categoryField;
  @FXML
  TextField typeField;
  @FXML
  TextField brandField;

  @FXML
  TextField nameField;
  @FXML
  TextArea ingredientsTextArea;
  @FXML
  TextField priceField;
  @FXML
  TextField userRatingField;

  /**
   * Initializes the controller class.
   */
  // @Override
  public void initialize(URL url, ResourceBundle rb) {
    SceneInitializer sceneInit = new SceneInitializer();
    categorySelect.setItems(sceneInit.getCategories());
    brandSelect.setItems(sceneInit.getBrands());
    typeSelect.setItems(sceneInit.getTypes());
    statusLabel.setText("");
  }

  @FXML
  private void handleSubmitAction(ActionEvent event) throws IOException {
    //String category = categorySelect.getSelectionModel().getSelectedItem().trim();
    String category = null;
    String type = null;
    String brand = null;
    try {
      category = categorySelect.getValue().trim();
    } catch(NullPointerException e) {
      category = categoryField.getText().trim();

    }
    
    try {
      type = typeSelect.getValue().trim();
    } catch(NullPointerException e) {
      type = typeField.getText().trim();

    }
    
    try {
      brand = brandSelect.getValue().trim();
    } catch(NullPointerException e) {
      brand = brandField.getText().trim();

    }
    
    String name = nameField.getText().trim();
    String rating = userRatingField.getText().trim();
    String price = priceField.getText().trim();
    String ingredients = ingredientsTextArea.getText().trim();
    if (!category.equals("") && !type.equals("") && !brand.equals("") && !name.equals("")
        && !rating.equals("") && !price.equals("") && !ingredients.equals("")) {
      HashMap<String, String> parameters = new HashMap<String, String>();
      parameters.put("name", name);
      parameters.put("brand", brand);
      parameters.put("category", category);
      parameters.put("type", type);
      parameters.put("price", price);
      parameters.put("user_rating", rating);
      parameters.put("ingredients", ingredients);
      AddProductOperation addProduct = new AddProductOperation();
      addProduct.execute(parameters);
      String operationStatus = (String)addProduct.getVariables().get("status");
      if (operationStatus.equals("SUCCESS")) {
        Parent parent = FXMLLoader.load(getClass().getResource("/ViewProductScene.fxml"));
        Scene viewUserInfoScene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(viewUserInfoScene);
        stage.show();
      }
      else if (operationStatus.equals("DATABASE_ERROR")) {
        statusLabel.setText("Error: Could not add new product to database");
      }
      else statusLabel.setText("Error: Invalid inputted values");
    }
    else statusLabel.setText("Error: Invalid inputted values");

  }

  @FXML
  private void handleGoToHomeAction(ActionEvent event) throws IOException {
    Parent parent = FXMLLoader.load(getClass().getResource("/HomeScene.fxml"));
    Scene viewProductHistoryScene = new Scene(parent);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.hide();
    stage.setScene(viewProductHistoryScene);
    stage.show();
  }

}
