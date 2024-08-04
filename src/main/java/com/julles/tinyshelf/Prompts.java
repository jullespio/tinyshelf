/*
 * This software is free to use
 * @author julles
 */

package com.julles.tinyshelf;

import java.util.Scanner;
import java.util.List;

public class Prompts {

    private String title;
    private String author;
    private String publisher;
    private int year;
    private int numPages;
    private String isbn;
    private double rating;
    private String otherInfo;
    
    private String continueOrNot;
    private String fieldString;
    private Book bookToUpdate;
    private Scanner scanner = new Scanner(System.in);
    

    public Prompts(){
        
    }

    //add validations, so that typing invalid info (like string instead of int) on prompts
    //restarts them instead of throwing an error;

    // Greetings
    public void displayGreetings(){

        System.out.println("\nGreetings!\n>>>> Welcome to tinyShelf <<<<");
        
    }

    public String returnExit(){
        return this.fieldString;
    }
    

    // Title
    public void askTitle(){

        while (true) {
            System.out.print("\nTitle: ");
            String title = scanner.nextLine();
            if (title.isEmpty()) {
                System.out.print("Field required.\n");
                continue;
            } 
            this.title = title;
            this.fieldString = title;
            break;   
        }
        
    }

    public String returnTitle(){

        return this.title;

    }


    //Author
    public void askAuthor(){

        while (true) {
            System.out.print("Author: ");
            String author = scanner.nextLine();
            if (author.isEmpty()) {
                System.out.print("Field required.\n");
                continue;
            }
            this.author = author;
            this.fieldString = author;
            break;   
        }
        
    }

    public String returnAuthor(){

        return this.author;

    }


    //Publisher
    public void askPublisher(){

        while (true) {
            System.out.print("Publisher: ");
            String publisher = scanner.nextLine();
            if (publisher.isEmpty()) {
                System.out.print("Field required.\n");
                continue;
            }
            this.publisher = publisher;
            this.fieldString = publisher;
            break;   
        }
        
    }

    public String returnPublisher(){

        return this.publisher;

    }


    //year
    public void askYear(){

        while (true) {
            //add validation to ensure the field is an int
            System.out.print("Publication year: ");
            String year = scanner.nextLine();

            if (year.isEmpty()) {
                System.out.print("Field required.\n");
                System.out.println();
                continue;
            } else if (year.equals("e")) {
                this.fieldString = year;
                break;
            } else {
                this.year = Integer.valueOf(year);
                this.fieldString = year;
                break; 
            }
              
        }
        
    }

    public int returnYear(){

        return this.year;

    }


    //pages
    public void askNumPages(){

        while (true) {
            //add validation to ensure the field is an int
            System.out.print("Number of pages: ");
            String pages = scanner.nextLine();
            if (pages.isEmpty()) {
                System.out.print("Field required.\n");
                System.out.println();
                continue;
            } else if (pages.equals("e")) {
                this.fieldString = pages;
                break;
            } else {
                this.numPages = Integer.valueOf(pages);
                this.fieldString = pages;
                break; 
            }
        }
        
    }

    public int returnNumPages(){

        return this.numPages;

    }


    //ISBN
    public void askIsbn(){

        while (true) {
            //add validation to ensure the field is only 10 or 13 characters long
            //and all inputs are numbers;
            System.out.print("-optional- ISBN: ");
            String isbn = scanner.nextLine();
            if (isbn.isEmpty()) {
                this.isbn = "<add ISBN number>";
                this.fieldString = "<add ISBN number>";
                break;   
                }
            this.isbn = isbn;
            this.fieldString = isbn;
            break;   
        }
        
    }

    public String returnIsbn(){

        return this.isbn;

    }


    //rating
    public void askRating(){
        //add validation to ensure the field is at least an int
        while (true) {
            System.out.print("-optional- Rating: ");
            String rating = scanner.nextLine();
            if (rating.isEmpty()) {
                this.rating = 0.0;
                this.fieldString = "0";
                break;
            } else if (rating.equals("e")) {
                this.fieldString = rating;
                break;
            } else {
                this.rating = Double.valueOf(rating);
                this.fieldString = rating;
                break; 
            }

        }
        
    }

    public double returnRating(){

        return this.rating;

    }


    //ISBN
    public void askOtherInfo(){

        while (true) {
            System.out.print("-optional- Other info: ");
            String otherInfo = scanner.nextLine();
            if (otherInfo.isEmpty()) {
                this.otherInfo = "<add relevant information about the book>";
                this.fieldString = "<add relevant information about the book>";
                break;   
            }
            this.otherInfo = otherInfo;
            this.fieldString = otherInfo;
            break;   
        }
        
    }

    public String returnOtherInfo(){

        return this.otherInfo;

    }


    //continue prompt
    public void continueOrNot(){

        while (true) {
            System.out.println("\nContinue? y/n");
            System.out.print("> ");
            String answer = scanner.nextLine();
            System.out.println();
            if (answer.isEmpty()) {
                continue;
            }
            this.continueOrNot = answer;
            break;
        }

    }

    //return continue prompt answer
    public String returnContinueOrNot(){
        return this.continueOrNot;
    }


    // Send new book to list
    public void sendToList(){

        BookList bookList = new BookList();
        bookList.AddNewBook(returnTitle(), returnAuthor(), returnPublisher(), returnYear(), returnNumPages(), returnIsbn(), returnRating(), returnOtherInfo());
    
    }


    //Main Prompts
    public void newBookPrompt(){

        while(true) {
        
            System.out.print(
                "\nPlease type information as asked. Fields are required unless stated otherwise." + 
                "\nPress (e) to exit.\n"
                );

            this.askTitle();
            if (this.fieldString.equals("e")) {
                break;
            }
            this.askAuthor();
            if (this.fieldString.equals("e")) {
                break;
            }
            this.askPublisher();
            if (this.fieldString.equals("e")) {
                break;
            }
            this.askYear();
            if (this.fieldString.equals("e")) {
                break;
            }
            this.askNumPages();
            if (this.fieldString.equals("e")) {
                break;
            }
            this.askIsbn();
            if (this.fieldString.equals("e")) {
                break;
            }
            this.askRating();
            if (this.fieldString.equals("e")) {
                break;
            }
            this.askOtherInfo();
            if (this.fieldString.equals("e")) {
                break;
            }
   
            this.continueOrNot();
   
            String continuePrompt = this.returnContinueOrNot();
   
            if (continuePrompt.equals("y") || continuePrompt.equals("Y")) {
   
                this.sendToList();
                System.out.println("New entry -" + this.title + "- has been added.");
                continue;
   
            } else if (continuePrompt.equals("n") || continuePrompt.equals("N")) {
   
                this.sendToList();
                System.out.println("New entry -" + this.title + "- has been added.");
                break;
   
            } else {
   
                this.sendToList();
                System.out.println("Invalid answer. New entry -" + this.title + "- has been added.\nExiting...");
                break;
   
            }
            
        }        

    }


    public void searchPrompt(){

        while (true) {

            System.out.println("\nType complete or partial name of the book or author. Search is case sensitive.\nEnter a blank search term to exit.");
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
            } else if (numOfResults > 1) {
                System.out.println("\n" + numOfResults + " entries have been found containing '" + searchTerm + "':\n");
            } else if (numOfResults == 0) {
                System.out.println("\nNo entries have been found containing '" + searchTerm + "''.\n");
            }
            
            for (Book book : searchResult) {
                System.out.println("==> " + book + "\n");
            }

            continue;

        }

    }


    public void updatePrompt(){
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
  
                System.out.println("\nType key corresponding to book you wish to update. Leave blank to exit.");
                System.out.print("> ");
                String key = scanner.nextLine();

                if (key.isEmpty()) {
                    System.out.println("Exiting...\n");
                    break;
                } else {
                    int numKey = Integer.valueOf(key);
                    if (numKey>=0 && numKey<=numOfResults) {
                        this.bookToUpdate = searchResult.get(numKey);
                        System.out.println("\nSelected book ready to be updated.");

                    } else {
                        System.out.println("No such key found.");
                        continue;
                    }
                }
                    
                    // ADD VALIDATION TO CHECK IF KEY IS NUMERIC OF NOT-- use a method with try...catch to test
                    // At the moment, typing a non-numeric character returns an error

                    // else if (){
                    //     System.out.println("No such key found.\n");
                    //     continue;
                    // }
                
                
            } else if (numOfResults == 0) {
                System.out.println("\nNo entries have been found containing '" + searchTerm + "''.\n");
                continue;

            }
            
            this.continueOrNot();
            String answerCont = this.returnContinueOrNot();

            if (answerCont.equals("y") || answerCont.equals("Y")) {

                System.out.println("Type key corresponding to field you wish to update. Leave blank to exit.");
                System.out.println("\n0 - Title\n1 - Author\n2 - Publisher\n3 - Year\n4 - Number of pages\n5 - ISBN\n6 - Rating\n7 - Other Information\n");
                System.out.print("> ");
                String key = scanner.nextLine();

                if (key.isEmpty()) {
                    System.out.println("Exiting...\n");
                    break;
                } else {
                    if (Integer.valueOf(key)>=0 && Integer.valueOf(key)<=7) {
                        int numKey = Integer.valueOf(key);

                        switch (numKey) {
                            case 0:
                                this.askTitle();
                                bookList.updateBook(bookToUpdate, this.title, numKey);    
                                break;
                            case 1:
                                this.askAuthor();
                                bookList.updateBook(bookToUpdate, this.author, numKey);    
                                break;
                            case 2:
                                this.askPublisher();
                                bookList.updateBook(bookToUpdate, this.publisher, numKey);    
                                break;
                            case 3:
                                this.askYear();
                                bookList.updateBook(bookToUpdate, this.fieldString, numKey);
                                break;    
                            case 4:
                                this.askNumPages();
                                bookList.updateBook(bookToUpdate, this.fieldString, numKey);
                                break;    
                            case 5:
                                this.askIsbn();
                                bookList.updateBook(bookToUpdate, this.isbn, numKey);
                                break;    
                            case 6:
                                this.askRating();
                                bookList.updateBook(bookToUpdate, this.fieldString, numKey);
                                break;    
                            case 7:
                                this.askOtherInfo();
                                bookList.updateBook(bookToUpdate, this.otherInfo, numKey);
                                break;
        
                            default:
                                break;
                            }
                        
                            System.out.println("\nBook has been updated.");
                        } else {
                            System.out.println("No such key found.");
                            continue;
                        } 
                    
                    // ADD VALIDATION TO CHECK IF KEY IS NUMERIC OF NOT-- use a method with try...catch to test
                    // At the moment, typing a non-numeric character returns an error
                }


            } else if (answerCont.equals("n") || answerCont.equals("N")) {
                continue;
            } else {
                System.out.print("\nInvalid answer. Please try again.\n");
                continue;

            }
    
        }

    }


    public void removePrompt(){

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
                this.bookToUpdate = searchResult.get(0);
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
                    System.out.println("No such key found.\n");
                    continue;
                }
                this.bookToUpdate = searchResult.get(key);
                System.out.println("\nSelected book ready to be removed.");

    
            } else if (numOfResults == 0) {
                System.out.println("\nNo entries have been found containing '" + searchTerm + "''.\n");
                continue;
            }
            
            this.continueOrNot();
            String answerCont = this.returnContinueOrNot();

            if (answerCont.equals("y") || answerCont.equals("Y")) {
                
                bookList.removeBook(bookToUpdate, currentList);

                for (Book book : currentList) {
                    if (book.toString().equals(bookToUpdate.toString())) {
                        bookList.removeBook(book, currentList);
                        break;
                    }
                }

                System.out.println("Book removed.\n");

            } else if (answerCont.equals("n") || answerCont.equals("N")) {
                continue;
            } else {
                System.out.print("\nInvalid answer. Please try again.\n");
                continue;

            }
    
        }
    }


    public void mainMenuPrompt(){
        // Ask user what they wish to do (add new book, find book, update book, delete book)
   
        while (true) {

            System.out.println(
            "\nWhat do you wish to do?\n" + 

            "\nType:" + 
            "\n(a) to add a new book" + 
            "\n(s) to use the search function" + 
            "\n(u) to update a book" +
            "\n(r) to remove a book" +
            "\n-or-" + 
            "\n(h) for help" + 
            "\n(e) to exit program\n");
            
            System.out.print("> ");
            String answer = scanner.nextLine();

            //substitute if-sequence below for a switch
            if (answer.equals("a") || answer.equals("A")) {

                this.newBookPrompt();
                continue;
    
            } else if (answer.equals("s") || answer.equals("S")) {
    
                this.searchPrompt();
                continue;
    
            } else if (answer.equals("u") || answer.equals("U")) {

                this.updatePrompt();
                continue;
    
            } else if (answer.equals("r") || answer.equals("R")) {
    
                this.removePrompt();
                continue;
    
            } else if (answer.equals("h") || answer.equals("H")) {
                
                System.out.println("\nThis section is still under construction.\n");
                //this.showHelp();
                continue;
    
            } else if (answer.equals("e") || answer.equals("E")) {
                
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
