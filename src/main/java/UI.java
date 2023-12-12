/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luise
 */
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class UI {
    private Scanner scanner;
    private Scanner fileScanner;
    
    public UI(Scanner scanner){
        this.scanner = scanner;        
    }
    
    public void start(){
        String command = "";
        String fileHandle = "";
        String name = "";
        int cookingTime = 0;
        ArrayList<String>ingredients = new ArrayList<>();
        RecipesManagement recipes = new RecipesManagement();
        
        System.out.println("File to read: ");
        String fileToRead = scanner.nextLine();
                               
        try {
            this.fileScanner = new Scanner(Paths.get(fileToRead));
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }

        while(this.fileScanner.hasNext()){
            name = fileScanner.nextLine();
            cookingTime = Integer.valueOf(fileScanner.nextLine());                                
            
            while(fileScanner.hasNext()){                
                String line = fileScanner.nextLine();                
                if(line.length() == 0){
                    break;
                }
                ingredients.add(line);
            }            
            recipes.addRecipe(new Recipe(name,cookingTime,ingredients));
            ingredients = new ArrayList<>();
        }                        
        
        System.out.println("");
        System.out.println("Commands: ");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");
        
        while(true){
            System.out.println("");
            System.out.println("Enter command: ");
            command = this.scanner.nextLine();
            
            if(command.equals("stop")){
                break;
            }                
            if(command.equals("list")){
                recipes.listRecipes();
            }
            if(command.equals("find name")){
                System.out.println("Searched word: ");                
                recipes.searchedRecipe(scanner.nextLine());
            }
            if(command.equals("find cooking time")){
                System.out.println("Max cooking time: ");
                recipes.findCookingTime(Integer.valueOf(scanner.nextLine()));                      
            }
            if(command.equals("find ingredient")){
                System.out.println("Ingredient: ");
                recipes.findIngredient(scanner.nextLine());
            }
        }
    }
}
