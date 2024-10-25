package com.julles.tinyshelf;

import java.util.List;

public class UpdatePrompt extends Prompt {

    private Book bookToUpdate;

    UpdatePrompt(){
        super();
    }

    public void currentPrompt(){

        while (true) {

            System.out.println("\nWhich book do you wish to update? Search is case sensitive.\nEnter a blank search term to exit.");
            System.out.print("> ");
            String searchTerm = scanner.nextLine();
    
            if (searchTerm.isEmpty()) {
                System.out.println("Exiting...\n");
                break;
            }
    
            BookList bookList = new BookList();
            List<Book> searchResult = bookList.findBook(searchTerm);
            int numOfResults = searchResult.size();
    
            if (numOfResults == 1) {  
                System.out.println("\n1 entry has been found containing '" + searchTerm + "':\n");
                System.out.println("==> " + searchResult.get(0));
                this.bookToUpdate = searchResult.get(0);
                System.out.println("\nSelected book ready to be updated.");
                    
            } else if (numOfResults > 1) {
                System.out.println("\n" + numOfResults + " entries have been found containing '" + searchTerm + "':\n");
                         
                for (int count = 0; count < numOfResults; count++) {
                    System.out.println("key " + count + "==> " + searchResult.get(count) + "\n");

                }
  
                System.out.println("\nType key corresponding to book you wish to update. Leave blank to cancel.");
                System.out.print("> ");
                String key = scanner.nextLine();

                if (key.isEmpty()) {
                    System.out.println("Exiting...\n");
                    break;
                } else {
                    
                    try {
                        int numKey = Integer.valueOf(key);
                        if (numKey>=0 && numKey<=numOfResults) {
                            this.bookToUpdate = searchResult.get(numKey);
                            System.out.println("\n--\"" + this.bookToUpdate.getTitle() + "\" selected.\nBook ready to be updated.");
    
                        } else {
                            System.out.println("\nNo such key found.");
                            continue;
                        }
                    } catch (Exception e) {
                        System.out.println("\nWarning: Please type a valid numeric key. Try again.");
                        continue;
                    } 
                }

            } else if (numOfResults == 0) {
                System.out.println("\nNo entries have been found containing '" + searchTerm + "''.\n");
                continue;

            }
             
            Boolean answerCont = this.continueOrNot();

            if (answerCont == true) {

                System.out.println("Type key corresponding to field you wish to update. Leave blank to cancel.");
                System.out.println("\n0 - Title\n1 - Author\n2 - Publisher\n3 - Year\n4 - Number of pages\n5 - ISBN\n6 - Rating\n7 - Other Information\n");
                System.out.print("> ");
                String key = scanner.nextLine();

                if (key.isEmpty()) {
                    System.out.println("Exiting...\n");
                    break;
                } else {

                    try {
                        if (Integer.valueOf(key)>=0 && Integer.valueOf(key)<=7) {
                            int numKey = Integer.valueOf(key);
                            NewBookPrompt newBook = new NewBookPrompt();
    
                            switch (numKey) {
                                case 0:
                                    newBook.askTitle();
                                    bookList.updateBook(bookToUpdate, newBook.getTitle(), numKey);    
                                    break;
                                case 1:
                                    newBook.askAuthor();
                                    bookList.updateBook(bookToUpdate, newBook.getAuthor(), numKey);    
                                    break;
                                case 2:
                                    newBook.askPublisher();
                                    bookList.updateBook(bookToUpdate, newBook.getPublisher(), numKey);    
                                    break;
                                case 3:
                                    newBook.askYear();
                                    bookList.updateBook(bookToUpdate, newBook.getYear(), numKey);
                                    break;    
                                case 4:
                                    newBook.askNumPages();
                                    bookList.updateBook(bookToUpdate, newBook.getNumPages(), numKey);
                                    break;    
                                case 5:
                                    newBook.askIsbn();
                                    bookList.updateBook(bookToUpdate, newBook.getIsbn(), numKey);
                                    break;    
                                case 6:
                                    newBook.askRating();
                                    bookList.updateBook(bookToUpdate, newBook.getRating(), numKey);
                                    break;    
                                case 7:
                                    newBook.askOtherInfo();
                                    bookList.updateBook(bookToUpdate, newBook.getOtherInfo(), numKey);
                                    break;
            
                                default:
                                    break;
                                }
                            
                            } else {
                                System.out.println("\nNo such key found.");
                                continue;
                            } 
                    } catch (Exception e) {
                        System.out.println("\nWarning: Please type a valid numeric key. Try again.");
                        continue;
                    }
                }

            } else if (answerCont == false) {
                continue;
            } 
    
        }

    }


}
