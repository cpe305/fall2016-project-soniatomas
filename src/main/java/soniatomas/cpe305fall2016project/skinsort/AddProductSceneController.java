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
public class AddProductSceneController implements Initializable {

    
    /**
     * Initializes the controller class.
     */
    //@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handleSubmitAction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/ViewProductScene.fxml"));
        Scene viewUserInfoScene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(viewUserInfoScene);
        stage.show();
    }
    
    @FXML
    private void handleGoToHomeAction(ActionEvent event) throws IOException{
        Parent parent = FXMLLoader.load(getClass().getResource("/HomeScene.fxml"));
        Scene viewProductHistoryScene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(viewProductHistoryScene);
        stage.show();
    }
    
}
