package com.julles.tinyshelf;

class MainMenuPrompt extends AbstractPrompt {

    MainMenuPrompt(){
        super();
    }

    void displayGreeting(){
        displayInfoPaddingTop("Greetings!\n>>>> Welcome to tinyShelf <<<<");
    }

    void currentPrompt(){

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

            if (answer.equalsIgnoreCase("a")) {
                NewBookPrompt newBook = new NewBookPrompt();
                newBook.currentPrompt();                
                continue;
            } else if (answer.equalsIgnoreCase("s")) {
                SearchPrompt search = new SearchPrompt();
                search.currentPrompt();
                continue;
            } else if (answer.equalsIgnoreCase("u")) {
                UpdatePrompt update = new UpdatePrompt();
                update.currentPrompt();
                continue;
            } else if (answer.equalsIgnoreCase("r")) {
                RemovePrompt remove = new RemovePrompt();
                remove.currentPrompt();
                continue;
            } else if (answer.equalsIgnoreCase("p")) {
                displayInfoPaddingFull("This section is still under construction.");
                continue;
            } else if (answer.equalsIgnoreCase("h")) {
                displayInfoPaddingFull("This section is still under construction.");
                continue;
            } else if (answer.equalsIgnoreCase("q")) {  
                displayInfoPaddingFull("Exiting...");
                displayInfoPaddingFull("See you next time!");
                break;
            } else {
                displayInfoPaddingFull("Invalid option. Please try again.");
                continue;
            }

        }
        scanner.close();
    }

}
