package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sonia
 */
public class ViewProductHistorySceneController implements Initializable {

  
  @FXML
  Label statusLabel;

  @FXML
  private TableView<ProductTableViewElement> productTableView;

  @FXML
  private TableColumn<ProductTableViewElement, String> categoryCol;
  @FXML
  private TableColumn<ProductTableViewElement, String> typeCol;
  @FXML
  private TableColumn<ProductTableViewElement, String> brandCol;
  @FXML
  private TableColumn<ProductTableViewElement, String> nameCol;
  @FXML
  private TableColumn<ProductTableViewElement, String> dateCol;

  private ViewHistoryOperation viewHistory;
  private ObservableList<ProductTableViewElement> productList;
  
  @FXML
  private void handleViewProductAction(ActionEvent event) throws IOException {
    Parent parent = FXMLLoader.load(getClass().getResource("/ViewProductScene.fxml"));
    Scene scene = new Scene(parent);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.hide();
    stage.setScene(scene);
    stage.show();
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

  /**
   * Initializes the controller class.
   */
  // @Override
  public void initialize(URL url, ResourceBundle rb) {
    
//    titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
//    idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
//    authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
//    publisherCol.setCellValueFactory(new PropertyValueFactory<>("publisher"));
//    availabilityCol.setCellValueFactory(new PropertyValueFactory<>("availabilty"));

//    TableColumn<Person,String> firstNameCol = new TableColumn<Person,String>("First Name");
//    firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));
//    TableColumn<Person,String> lastNameCol = new TableColumn<Person,String>("Last Name");
//    lastNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));
    categoryCol.setCellValueFactory(new PropertyValueFactory<ProductTableViewElement, String>("category"));
    typeCol.setCellValueFactory(new PropertyValueFactory<ProductTableViewElement, String>("type"));
    brandCol.setCellValueFactory(new PropertyValueFactory<ProductTableViewElement, String>("brand"));
    nameCol.setCellValueFactory(new PropertyValueFactory<ProductTableViewElement, String>("name"));
    dateCol.setCellValueFactory(new PropertyValueFactory<ProductTableViewElement, String>("date"));
    
    this.viewHistory = new ViewHistoryOperation();
    viewHistory.execute(null);
    @SuppressWarnings("unchecked")
    List<Product> listOfProducts = (List<Product>) viewHistory.getVariables().get("products");
    this.productList = new DataConverter().getObservableProductList(listOfProducts);
    
    
    productTableView.getItems().setAll(productList);

    // TODO
  }

}
