package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.HashMap;

public class RemoveProductOperation implements Operation {
  private HashMap<String, Object> operationVariables;

  public RemoveProductOperation() {
    operationVariables = new HashMap<String, Object>();
  }

  public HashMap<String, Object> getVariables() {
    return operationVariables;
  }

  public HashMap<String, Object> execute(HashMap<String, String> parameters) {
    String productBrand = parameters.get("PRODUCT_BRAND");
    String productName = parameters.get("PRODUCT_NAME");
    Product product = SystemData.getInstance().getUser().getProductHistory()
        .getProduct(productBrand, productName);

    RatingUpdater ratingUpdater = new RatingUpdater();

    ratingUpdater.updateIngredientRatingsAfterRemovingProduct(product);

    boolean operationSuccess = SystemData.getInstance().getUser().getProductHistory()
        .removeProduct(productBrand, productName);

    if (operationSuccess) {
      operationVariables.put("status", "SUCCESS");
    } else
      operationVariables.put("status", "FAILURE");
    if (!DatabaseManager.getInstance().saveUpdatesToDatabase()) {
      operationVariables.put("status", "DATABASE_ERROR");
    }
    return operationVariables;

  }
}
