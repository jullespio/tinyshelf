package com.julles.tinyshelf;

import java.util.Scanner;

abstract class Prompt {

    Scanner scanner;

    Prompt(){
        scanner = new Scanner(System.in);
    }

    static void displayInfoPaddingFull(String infoToDisplay){
        System.out.println("\n" + infoToDisplay + "\n");
    };

    static void displayInfoPaddingTop(String infoToDisplay){
        System.out.println("\n" + infoToDisplay);
    };

    static void displayInfoPaddingBottom(String infoToDisplay){
        System.out.println(infoToDisplay + "\n");
    };

    Boolean continueOrNot(){
        while (true) {
            
            System.out.println("\nContinue? [y/n]");
            System.out.print("> ");
            String answer = scanner.nextLine();
            System.out.println();
            
            if (answer.equalsIgnoreCase("y")) {
                return true;
            } 
            
            if (answer.equalsIgnoreCase("n")) {
                return false;
            } 

            if (!(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n"))) {
                System.out.println("\nPlease provide a valid answer.\n");
                continue;
            }

            break;

        }
        
        return false;
    }

    abstract void currentPrompt();

}
