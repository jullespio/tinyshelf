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

    private String continueOrNot;

    private Scanner scanner = new Scanner(System.in);

    public Prompts(){
        
    }

    //add validations, so that typing invalid info (like string instead of int) on prompts
    //restarts them instead of throwing an error;
    //this step is necessary for the implementation of searches, 
    //updating specific fields (simple CRUD in general)

    // Greetings
    public void displayGreetings(){

        System.out.println("\nGreetings!\n>>>> Welcome to tinyShelf <<<<");
        System.out.print("\nPlease type information as asked. All fields are required.\n");

    }

    // Title
    public void askTitle(){

        while (true) {
            System.out.print("\nTitle: ");
            String title = scanner.nextLine();
            if (title.isEmpty()) {
                System.out.print("All fields are required.\n");
                continue;
            }
            this.title = title;
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
                System.out.println("All fields are required.\n");
                continue;
            }
            this.author = author;
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
                System.out.println("All fields are required.\n");
                continue;
            }
            this.publisher = publisher;
            break;   
        }
        
    }

    public String returnPublisher(){

        return this.publisher;

    }


    //year
    public void askYear(){

        while (true) {
            System.out.print("Publication year: ");
            String year = scanner.nextLine();
            if (year.isEmpty()) {
                System.out.print("All fields are required!\n");
                System.out.println();
                continue;
            }
            this.year = Integer.valueOf(year);
            break;   
        }
        
    }

    public int returnYear(){

        return this.year;

    }


    //pages
    public void askNumPages(){

        while (true) {
            System.out.print("Number of pages: ");
            String pages = scanner.nextLine();
            if (pages.isEmpty()) {
                System.out.print("All fields are required!\n");
                System.out.println();
                continue;
            }
            this.numPages = Integer.valueOf(pages);
            break;   
        }
        
    }

    public int returnNumPages(){

        return this.numPages;

    }


    //continue prompt
    public void continueOrNot(){

        while (true) {
            System.out.println("\nContinue? y/n");
            String answer = scanner.nextLine();
            System.out.println();
            if (answer.isEmpty()) {
                continue;
            }
            this.continueOrNot = answer;
            break;
        }

    }

    public String returnContinueOrNot(){
        return this.continueOrNot;
    }


    // Send new book to list
    public void sendToList(){

        BookList bookList = new BookList();
        bookList.AddNewBook(returnTitle(), returnAuthor(), returnPublisher(), returnYear(), returnNumPages());
    
    }

    public void newBookPrompt(){

        while(true) {
        
            this.askTitle();
            this.askAuthor();
            this.askPublisher();
            this.askYear();
            this.askNumPages();
   
            this.continueOrNot();
   
            String continuePrompt = this.returnContinueOrNot();
   
            if (continuePrompt.equals("y") || continuePrompt.equals("Y")) {
   
                this.sendToList();
               continue;
   
            } else if (continuePrompt.equals("n") || continuePrompt.equals("N")) {
   
               System.out.print("\nSee you next time!\n");
               this.sendToList();
               break;
   
            } else {
   
               System.out.print("\nInvalid answer. Saving data and closing program.\n");
               this.sendToList();
               break;
   
            }
            
        }        

    }

    public void searchPrompt(){

        System.out.println("\nType name of the book. Note: search is case sensitive.\n");
        String searchTerm = scanner.nextLine();
        
        BookList bookList = new BookList();
        List<Book> searchResult = bookList.findBook(searchTerm);
        int numOfResults = searchResult.size();

        if (numOfResults == 1) {
            System.out.println("1 entry has been found containing '" + searchTerm + "'':\n");
        } else if (numOfResults > 1) {
            System.out.println("\n" + numOfResults + " entries have been found containing '" + searchTerm + "':\n");
        } else if (numOfResults == 0) {
            System.out.println("\nNo entries have been found containing '" + searchTerm + "''.\n");
        }
        
        for (Book book : searchResult) {
            System.out.println(book);
        }
        
    }

    public void menuPrompt(){
        // Ask user what they wish to do (add new book, find book, update book, delete book)
    }

}
