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
        String userInput = "";
        String[] commandList = {};
        String command = "";
        
        while (true){
            //get input
            userInput = cons.readLine("Please type 'add itemName', 'delete itemName', or 'list' to see all items: ");
            userInput = userInput.trim();
            
            //a break of the infinite loop
            if ("stop".equals(userInput))
                break;

            //picking out the command from item name
            commandList = userInput.split(" ");
            //command should be list, add or delete  
            command = commandList[0];         

            //now to differentiate between list, delete and add so we can deal with data appropriately
            switch(command.trim().toLowerCase()){
                //lists out all the items in shopping cart list
                case "list":
                    if (shoppingCart.size() != 0){    
                        for (Integer index = 0; index < shoppingCart.size(); index++){
                            System.out.printf("%d : %s\n", index, shoppingCart.get(index));
                    }
                    }else{
                        System.out.println("There's nothing in your cart.");
                    }             
                    break;

                //add the user specified item
                case "add":
                    shoppingCart.add(commandList[1]);
                    System.out.printf("Added %s to your cart.\n", commandList[1]);
                    break;

                //check for and delete the user specified item
                case "delete":
                    String item = shoppingCart.get(Integer.parseInt(commandList[1]));
                    
                    //checks for bad inputs
                    if (shoppingCart.size() == 0){
                        System.out.println("There's nothing in your cart.\n");
                        break;
                    }else if (shoppingCart.size() < Integer.parseInt(commandList[1])) {
                        System.out.println("Incorrect item index.\n");
                    }

                    //item removal once all bad input checks passed
                    shoppingCart.remove(Integer.parseInt(commandList[1]));
                    System.out.printf("Removed %s from your cart.\n", item);
                    break;
            
                default:
                    System.out.println("Type 'add itemName', 'delete itemName', or 'list' only: ");
            }
        }
    }
}
