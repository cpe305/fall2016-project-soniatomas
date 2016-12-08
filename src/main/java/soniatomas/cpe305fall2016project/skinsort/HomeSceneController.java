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
 *
 * @author Sonia
 */
public class HomeSceneController implements Initializable {

    @FXML
    private void handleViewUserAction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/ViewUserInfoScene.fxml"));
        Scene viewUserInfoScene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(viewUserInfoScene);
        stage.show();
    }
    
    @FXML
    private void handleViewProductHistoyrAction(ActionEvent event) throws IOException{
        Parent parent = FXMLLoader.load(getClass().getResource("/ViewProductHistoryScene.fxml"));
        Scene viewProductHistoryScene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(viewProductHistoryScene);
        stage.show();
    }
    @FXML
    private void handleAddProductAction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/AddProductScene.fxml"));
        Scene addProductScene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(addProductScene );
        stage.show();

    }
    @FXML
    private void handleRemoveProductAction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/RemoveProductScene.fxml"));
        Scene removeProductScene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(removeProductScene);
        stage.show();
    }
    @FXML
    private void handleCompareProductsAction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/CompareProductsScene.fxml"));
        Scene compareProductsScene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(compareProductsScene);
        stage.show();
    }
    @FXML
    private void handleAssessProductAction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/AssessProductScene.fxml"));
        Scene assessProductScene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(assessProductScene);
        stage.show();
        
    }

    //@Override
    public void initialize(URL url, ResourceBundle rb) {
        // This initializes the screen with content.
        //label.setText("Hello World!");
        // TODO
    }

}
