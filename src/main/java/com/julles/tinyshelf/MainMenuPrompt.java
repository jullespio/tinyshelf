package com.julles.tinyshelf;

public class MainMenuPrompt extends Prompt {

    MainMenuPrompt(){
        super();
    }

    public void currentPrompt(){

        while (true) {

            System.out.println(
            "\nWhat do you wish to do?\n" + 

            "\nType:" + 
            "\n(a) to add new books" + 
            "\n(s) to use the search function" + 
            "\n(u) to update books" +
            "\n(r) to remove books\n" +
            "\n-or-" + 
            "\n(p) to print the full booklist" +
            "\n(h) for help" + 
            "\n(q) to quit\n");
            
            System.out.print("> ");
            String answer = scanner.nextLine();

            if (answer.equals("a") || answer.equals("A")) {
                NewBookPrompt newBook = new NewBookPrompt();
                newBook.currentPrompt();                
                continue;
    
            } else if (answer.equals("s") || answer.equals("S")) {
    
                //this.searchPrompt();
                continue;
    
            } else if (answer.equals("u") || answer.equals("U")) {

                //this.updatePrompt();
                continue;
    
            } else if (answer.equals("r") || answer.equals("R")) {
    
                //this.removePrompt();
                continue;
    
            } else if (answer.equals("p") || answer.equals("P")) {
    
                //this.printBookListPrompt();
                continue;
    
            } else if (answer.equals("h") || answer.equals("H")) {
                
                System.out.println("\nThis section is still under construction.\n");
                //this.showHelp();
                continue;
    
            } else if (answer.equals("q") || answer.equals("Q")) {
                
                System.out.print("\nExiting...\n");
                System.out.print("\nSee you next time!\n");
                break;
    
            } else {
                System.out.println("\nInvalid option. Please try again.\n");
                continue;
            }

        }

    }

}
