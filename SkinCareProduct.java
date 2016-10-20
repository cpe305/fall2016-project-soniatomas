public class SkinCareProduct {
   private String name;
   private LinkedList<Ingredient> ingredients;

   public SkinCareProduct(String name, LinkedList<Ingredient> ingredients) {      this.name = name; 
      this.ingredients = ingredients;
   }

   public SkinCareProduct(String name, String ingredients) { 
      this.name = name; 
      //this.ingredients = ingredients;
      //does this mean i parse ingredients out from th string into a linked       list?
   }

   public boolean containsIngredient(Ingredient ingredient) {
      
   }

   public String getName() {
      return this.name;
   }

   public boolean isSameType(Product product) {
      
   }

   public String getType() {
      return "SkinCareProduct";
   }

   public LinkedList<Ingredient> getDifferentIngredients() {

   }

   public LinkedList<Ingredient> getSimilarIngredients() {

   }

}
