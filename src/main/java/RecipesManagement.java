/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luise
 */
import java.util.ArrayList;

public class RecipesManagement {
    private ArrayList<Recipe> recipes;
    
    public RecipesManagement(){
        this.recipes = new ArrayList<>();
    }
    
    public void addRecipe(Recipe recipe){
        this.recipes.add(recipe);
    }

    public void listRecipes(){
        System.out.println("");
        System.out.println("Recipes: ");
        for(Recipe recipe: this.recipes){
            System.out.println(recipe);
        }
    }
    
    public void searchedRecipe(String word){
        System.out.println("");
        System.out.println("Recipes");
        for (Recipe recipe : recipes) {
            if(recipe.getName().contains(word)){
                System.out.println(recipe);
            }
        }
    }
    
    public void findCookingTime(int maxCookingTime){
        System.out.println("");
        System.out.println("Recipes: ");
        for (Recipe recipe : recipes) {
            if(recipe.getCookingTime() <= maxCookingTime){
                System.out.println(recipe);
            }
        }
 
    }
    
    public void findIngredient(String searchedIngredient){
        System.out.println("");
        System.out.println("Recipes: ");
        for (Recipe recipe : this.recipes) {            
            for (String ingredient : recipe.getIngredients()) {                
                if(ingredient.equals(searchedIngredient)){
                    System.out.println(recipe);
                    break;
                }
            }
        }
    }
          
}
