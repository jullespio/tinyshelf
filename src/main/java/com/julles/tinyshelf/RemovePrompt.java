package com.julles.tinyshelf;

import java.util.List;

class RemovePrompt extends AbstractPrompt {

    private Book bookToRemove;

    RemovePrompt(){
        super();
    }

    void currentPrompt() {
        
        while (true) {

            System.out.println("\nWhich book do you wish to remove? Search is case sensitive.\nEnter a blank search term to exit.");
            System.out.print("> ");
            String searchTerm = scanner.nextLine();
    
            if (searchTerm.isEmpty()) {
                System.out.println("Exiting...\n");
                break;
            }
    
            BookList bookList = new BookList();

            List<Book> currentList = bookList.returnBookList();
            List<Book> searchResult = bookList.findBook(searchTerm);

            int numOfResults = searchResult.size();
    
            if (numOfResults == 1) {
    
                System.out.println("\n1 entry has been found containing '" + searchTerm + "':\n");
                System.out.println("==> " + searchResult.get(0));
                this.bookToRemove = searchResult.get(0);
                System.out.println("Selected book ready to be removed.");
                    
            } else if (numOfResults > 1) {
                System.out.println("\n" + numOfResults + " entries have been found containing '" + searchTerm + "':\n");
                         
                for (int count = 0; count < numOfResults; count++) {
                    System.out.println("key " + count + "==> " + searchResult.get(count) + "\n");
                }
  
                System.out.println("\nType key corresponding to book you wish to remove:");
                System.out.print("> ");
                int key = Integer.valueOf(scanner.nextLine());
                if (key>numOfResults-1) {
                    System.out.println("\nNo such key found.\n");
                    continue;
                }
                this.bookToRemove = searchResult.get(key);
                System.out.println("\n--\"" + this.bookToRemove.getTitle() + "\" selected.\nBook ready to be removed.");

    
            } else if (numOfResults == 0) {
                System.out.println("\nNo entries have been found containing '" + searchTerm + "''.\n");
                continue;
            }
            
            if (this.continueOrNot() == true) {
                bookList.removeBook(bookToRemove, currentList);
                displayInfoPaddingBottom("Book removed.");
            } else {
                continue;
            } 
        }
        
    }
}
