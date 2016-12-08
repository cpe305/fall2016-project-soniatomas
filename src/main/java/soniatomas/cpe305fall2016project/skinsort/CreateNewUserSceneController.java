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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sonia
 */
public class CreateNewUserSceneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    //@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    private void handleCreateNewUserAction(ActionEvent event) throws IOException {
        // here you would create a new user and output the status of it onto the scene
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
