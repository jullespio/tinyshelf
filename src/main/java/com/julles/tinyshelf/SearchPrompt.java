package com.julles.tinyshelf;

import java.util.List;

public class SearchPrompt extends Prompt {

    SearchPrompt(){
        super();
    }
    
    void currentPrompt(){
        while (true) {

            displayInfoPaddingTop("Type complete or partial name of the book or author. Search is case sensitive.");
            displayInfoPaddingFull("Enter a blank search term to exit.");
            System.out.print("> ");
            String searchTerm = scanner.nextLine();

            if (searchTerm.isEmpty()) {
                displayInfoPaddingBottom("Exiting...");
                break;
            }

            BookList bookList = new BookList();

            List<Book> searchResult = bookList.findBook(searchTerm);
            int numOfResults = searchResult.size();
    
            if (numOfResults == 1) {
                displayInfoPaddingFull("1 entry has been found containing " + searchTerm + ":");
            } else if (numOfResults > 1) {
                displayInfoPaddingFull(numOfResults + " entries have been found containing " + searchTerm + ":");
            } else if (numOfResults == 0) {
                displayInfoPaddingFull("No entries have been found containing " + searchTerm + ".");
            }
            
            for (Book book : searchResult) {
                displayInfoPaddingBottom("==> " + book);
            }

            continue;

        }

    }

}
