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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sonia
 */
public class CreateNewUserSceneController implements Initializable {

  @FXML
  TextField emailField;
  @FXML
  TextField firstNameField;
  @FXML
  TextField lastNameField;
  @FXML
  PasswordField passwordField;
  @FXML
  PasswordField passwordConfirmationField;
  @FXML
  Label statusLabel;
  /**
   * Initializes the controller class.
   */
  // @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }

  @FXML
  private void handleCreateNewUserAction(ActionEvent event) throws IOException {
    String email = emailField.getText().trim();
    String firstName = firstNameField.getText().trim();
    String lastName = lastNameField.getText().trim();
    String password = passwordField.getText().trim();
    String passwordConfirmation = passwordConfirmationField.getText().trim();
    if (!email.equals("") && !firstName.equals("") && !lastName.equals("") && !password.equals("")
        && !passwordConfirmation.equals("")) {
      if (password.equals(passwordConfirmation)) {
        HashMap<String, String> parameters = new HashMap<String, String>();
        parameters.put("email", email);
        parameters.put("first_name", firstName);
        parameters.put("last_name", lastName);
        parameters.put("password", password);
        CreateNewUserOperation newUser = new CreateNewUserOperation();
        newUser.execute(parameters);
        String operationStatus = (String) newUser.getVariables().get("status");
        if (operationStatus.equals("SUCCESS")) {
          statusLabel.setText("New User Account Created");
        } else if (operationStatus.equals("DATABASE_ERROR")) {
          statusLabel.setText("Error: Database not connected");
        } else
          statusLabel.setText("Error: User Account with Email already exists");
      } else
        statusLabel.setText("Error: Passwords do not match");
    } else {
      statusLabel.setText("Error: Invalid inputted values");
    }

  }

  @FXML
  private void handleBackToLoginAction(ActionEvent event) throws IOException {
    Parent parent = FXMLLoader.load(getClass().getResource("/StartUpScene.fxml"));
    Scene startUpScene = new Scene(parent);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.hide();
    stage.setScene(startUpScene);
    stage.show();
  }

}
