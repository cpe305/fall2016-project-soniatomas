package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sonia
 */
public class ViewUserInfoSceneController implements Initializable {

  @FXML
  Label firstNameLabel;
  @FXML
  Label lastNameLabel;
  @FXML
  Label emailLabel;
  /**
   * Initializes the controller class.
   */
  // @Override
  public void initialize(URL url, ResourceBundle rb) {
    ViewUserAccountOperation viewUserAccount = new ViewUserAccountOperation();
    viewUserAccount.execute(null);
    String status = viewUserAccount.getStatus();
    if (status.equals("SUCCESS")) {
      String firstName = (String)viewUserAccount.getVariables().get("FIRST_NAME");
      String lastName = (String)viewUserAccount.getVariables().get("LAST_NAME");
      String email = (String)viewUserAccount.getVariables().get("EMAIL");
      firstNameLabel.setText(firstName);
      lastNameLabel.setText(lastName);
      emailLabel.setText(email);
    }
    else {
      firstNameLabel.setText("ERROR");
      lastNameLabel.setText("ERROR");
      emailLabel.setText("ERROR");
    }
    
  }

  @FXML
  private void handleGoToHomeAction(ActionEvent event) throws IOException {
    Parent parent = FXMLLoader.load(getClass().getResource("/HomeScene.fxml"));
    Scene scene = new Scene(parent);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.hide();
    stage.setScene(scene);
    stage.show();
  }
}
