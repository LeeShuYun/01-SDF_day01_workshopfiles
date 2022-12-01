package src.shoppingcartapp;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;

public class ShoppingCart {
    public static void main(String[] args){

        //init the list we're going to use to contain user's items
        List<String> shoppingCart = new LinkedList<>();

        // get input and extract the first word out. first word will always be command to add, delete or list.
        Console cons = System.console();
        String userInput = cons.readLine("Please type 'add itemName', 'delete itemName', or 'list' to see all items: ");
        userInput = userInput.trim();
        String[] commandList = userInput.split(" ");
        String command = commandList[0];
        String commandItem = commandList[1];

        //now to differentiate between list delete and add so we can deal with data appropriately
        switch(command.trim().toLowerCase()){
        //add the user specified item
            case "add":
            shoppingCart.add(commandItem);
            System.out.printf("Added %s to your cart.", commandList[1]);


        //check for and delete the user specified item
            case "delete":
                Integer itemIndex = shoppingCart.indexOf(commandItem);
                //checking if item is inside the cart so we don't get errors
                if (itemIndex ==-1) {
                    //item isn't here we remind the user
                    System.out.printf("Sorry, you don't have %s in the cart.", commandItem);
                }else{
                    shoppingCart.remove(itemIndex);
                    System.out.printf("Removed %s from your cart.", commandItem);
                }

        //lists out all the items in shopping cart list
            case "list":
                for (Integer i = 0; i < shoppingCart.size(); i++){
                    System.out.printf("[%d]: %d\n" ,i, shoppingCart.get(i));
                }
        
        //default
            default:
                System.out.println("Type 'add itemName', 'delete itemName', or 'list' only: ");
        }
    }
}
