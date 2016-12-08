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
public class RemoveProductSceneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    //@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML 
    Label statusLabel;
    
    @FXML
    private void handleRemoveProductAction(ActionEvent event) throws IOException {
       
    }
    
    @FXML
    private void handleGoToHomeAction(ActionEvent event) throws IOException{
        Parent parent = FXMLLoader.load(getClass().getResource("/HomeScene.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();
    }
}
