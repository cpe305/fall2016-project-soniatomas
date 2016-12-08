package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Sonia
 */
public class StartUpSceneController implements Initializable {

  @FXML
  Label statusLabel;
  
  @FXML
  private void handleLoginAction(ActionEvent event) throws IOException {
    // need to perform login here
    Parent homeParent = FXMLLoader.load(getClass().
        getResource("/HomeScene.fxml"));
    Scene homeScene = new Scene(homeParent);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.hide();
    stage.setScene(homeScene);
    stage.show();
  }

  @FXML
  private void handleCreateNewUserAction(ActionEvent event) throws IOException {
    Parent parent = FXMLLoader.load(getClass().getResource(
        "/CreateNewUserScene.fxml"));
    Scene createNewUserScene = new Scene(parent);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.hide();
    stage.setScene(createNewUserScene);
    stage.show();
  }

  //@Override
  public void initialize(URL url, ResourceBundle rb) {
  }

}
