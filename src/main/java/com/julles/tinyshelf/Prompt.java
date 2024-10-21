package com.julles.tinyshelf;

import java.util.Scanner;

abstract class Prompt {

    Scanner scanner;

    Prompt(){

        scanner = new Scanner(System.in);

    }

    public void displayGreetings(){

        System.out.println("\nGreetings!\n>>>> Welcome to tinyShelf <<<<");
        
    }

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


}
