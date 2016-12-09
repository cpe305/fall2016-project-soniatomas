package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sonia
 */
public class ViewProductSceneController implements Initializable { 
   @FXML
   Label categoryLabel;
   @FXML
   Label typeLabel;
   @FXML
   Label brandLabel;
   @FXML
   Label nameLabel;
   @FXML
   Label priceLabel;
   @FXML
   ListView<String> ingredientsListView;
   @FXML
   Label userRatingLabel;
   @FXML
   Label systemRatingLabel;
   @FXML
   Label recommendationLabel;
    /**
     * Initializes the controller class.
     */
    //@Override
    public void initialize(URL url, ResourceBundle rb) {
      ViewProductDataOperation viewProductData = new ViewProductDataOperation();
      viewProductData.execute(null);
      @SuppressWarnings("unchecked")
      Hashtable<String, String> productData = (Hashtable<String, String>)viewProductData.getVariables().get("product_data");
      @SuppressWarnings("unchecked")
      ObservableList<String> ingredientList = (ObservableList<String>)viewProductData.getVariables().get("ingredient_list");
      categoryLabel.setText(productData.get("CATEGORY"));
      typeLabel.setText(productData.get("TYPE"));
      brandLabel.setText(productData.get("BRAND"));
      nameLabel.setText(productData.get("NAME"));
      priceLabel.setText(productData.get("PRICE"));
      userRatingLabel.setText(productData.get("USER_RATING"));
      systemRatingLabel.setText(productData.get("SYSTEM_RATING"));
      recommendationLabel.setText(productData.get("RECOMMENDATION"));
      ingredientsListView.setItems(ingredientList);
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
    
    
    
}
