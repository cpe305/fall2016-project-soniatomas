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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sonia
 */
public class ViewProductSceneController implements Initializable {
  
   private String previousScene = "/HomeScene.fxml";
   private String buttonTitle = "Go to Home";
   
   @FXML
   Button goBackButton;
    /**
     * Initializes the controller class.
     */
    //@Override
    public void initialize(URL url, ResourceBundle rb) {
      this.previousScene = "/HomeScene.fxml";
      this.buttonTitle = "Go to Home";
        // TODO
    }    
    
    
    @FXML
    private void handleGoToPreviousAction(ActionEvent event) throws IOException{
        Parent parent = FXMLLoader.load(getClass().getResource("/HomeScene.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();
    }
    
    public void setPreviousScene(String sceneLocation, String buttonTitle) {
      this.previousScene = sceneLocation;
      this.buttonTitle = buttonTitle;
    }
    
    
    
    
}
