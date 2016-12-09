package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SceneInitializer {
  
   private List<String> categories;
   private List<String> types;
   private List<String> brands;
   
   public SceneInitializer() {
     ProductHistory productHistory = SystemData.getInstance().getUser().getProductHistory();
     this.categories = productHistory.getCategories();
     this.types = productHistory.getTypes();
     this.brands = productHistory.getBrands();
   }
   public ObservableList<String> getCategories() {
//     ObservableList<String> list = FXCollections.observableArrayList();
//     
//     for (Ingredient ingredient : ingredientList) {
//       list.add(ingredient.getName());
//     }
//     List<String> categoriesList = new ArrayList<String>();
//     categoriesList.add(" ");
//     categoriesList.addAll(categories);
//     return FXCollections.observableArrayList(categoriesList);
     
     ObservableList<String> list = FXCollections.observableArrayList();
     list.add(" ");
     for (String str : categories) {
       list.add(str);
     }
     return list;
   }
   public ObservableList<String> getBrands() {
//     //return FXCollections.observableArrayList(brands);
//     List<String> brandList = new ArrayList<String>();
//     brandList.add(" ");
//     brandList.addAll(brands);
//     return FXCollections.observableArrayList(brandList);
     ObservableList<String> listBrands = FXCollections.observableArrayList();
     listBrands.add(" ");
     for (String str : brands) {
       listBrands.add(str);
     }
     return listBrands;
   }
   public ObservableList<String> getTypes() {
     //return FXCollections.observableArrayList(types);
//     List<String> typesList = new ArrayList<String>();
//     typesList.add(" ");
//     typesList.addAll(types);
//     return FXCollections.observableArrayList(typesList);
     ObservableList<String> listTypes = FXCollections.observableArrayList();
     listTypes.add(" ");
     for (String str : types) {
       listTypes.add(str);
     }
     return listTypes;
   }

}
