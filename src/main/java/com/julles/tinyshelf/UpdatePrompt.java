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
                        e.printStackTrace();
                        //System.out.println("\nWarning: Please type a valid numeric key. Try again.");
                        //continue;
                    } 
                }

            } else if (numOfResults == 0) {
                System.out.println("\nNo entries have been found containing '" + searchTerm + "''.\n");
                continue;

            }
             
            if (this.continueOrNot() == true) {

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
                            // Maybe inform users that they can exit by pressing (e), review exiting system in this class 
                            switch (numKey) {
                                case 0:
                                    if (newBook.askTitle()==true) {
                                        bookList.updateBook(bookToUpdate, newBook.getTitle(), numKey);
                                        break;    
                                    } else {
                                        break;
                                    }
                                case 1:
                                    if (newBook.askAuthor()==true) {
                                        bookList.updateBook(bookToUpdate, newBook.getAuthor(), numKey);
                                        break;    
                                    } else {
                                        break;
                                    }
                                case 2:
                                    if (newBook.askPublisher()==true) {
                                        bookList.updateBook(bookToUpdate, newBook.getPublisher(), numKey);
                                        break;    
                                    } else {
                                        break;
                                    }
                                case 3:
                                    if (newBook.askYear()==true) {
                                        bookList.updateBook(bookToUpdate, newBook.getYear(), numKey);
                                        break;    
                                    } else {
                                        break;
                                    }
                                case 4:
                                    if (newBook.askNumPages()==true) {
                                        bookList.updateBook(bookToUpdate, newBook.getNumPages(), numKey);
                                        break;    
                                    } else {
                                        break;
                                    }
                                case 5:
                                    if (newBook.askIsbn()==true) {
                                        bookList.updateBook(bookToUpdate, newBook.getIsbn(), numKey);
                                        break;    
                                    } else {
                                        break;
                                    }
                                case 6:
                                    if (newBook.askRating()==true) {
                                        bookList.updateBook(bookToUpdate, newBook.getRating(), numKey);
                                        break;    
                                    } else {
                                        break;
                                    }
                                case 7:
                                if (newBook.askOtherInfo()==true) {
                                    bookList.updateBook(bookToUpdate, newBook.getOtherInfo(), numKey);
                                    break;    
                                } else {
                                    break;
                                }
            
                                default:
                                    break;
                                }
                            
                            } else {
                                System.out.println("\nNo such key found.");
                                continue;
                            } 
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("\nWarning: Please type a valid numeric key. Try again.");
                        continue;
                    }
                }

            } else {
                continue;
            } 
        }
    }
}
