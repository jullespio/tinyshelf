/*
 * This software is free to use
 * @author julles
 */

package com.julles.tinyshelf;

import java.io.IOException;
import java.util.Scanner;


public class App 
{
    public static void main( String[] args ) throws IOException
    {

      Scanner scanner = new Scanner(System.in);

      System.out.println("\nGreetings!\n>>>> Welcome to tinyShelf <<<<");
      System.out.print("\nPlease type information as asked. All fields are required.\n");

      while(true) {
        
         Prompts prompt = new Prompts();

         prompt.askTitle();
         prompt.askAuthor();
         prompt.askPublisher();
         prompt.askYear();
         prompt.askNumPages();

         // System.out.print("\nTitle: ");
         // String title = scanner.nextLine();
         // if (title.isEmpty()) {
         //    System.out.println("All fields are required!\n");
         //    continue;
         // }

         // System.out.print("Author: ");
         // String author = scanner.nextLine();
         // if (author.isEmpty()) {
         //    System.out.println("All fields are required!\n");
         //    continue;
         // }

         // System.out.print("Publisher: ");
         // String publisher = scanner.nextLine();
         // if (publisher.isEmpty()) {
         //    System.out.println("All fields are required!\n");
         //    break;
         // }

         // System.out.print("Publication year: ");
         // String year = scanner.nextLine();
         // int yearNum = Integer.valueOf(year);
         // if (year.isEmpty()) {
         //    System.out.print("All fields are required!\n");
         //    break;
         // }

         // System.out.print("Number of pages: ");
         // String pages = scanner.nextLine();
         // System.out.println();
         // int pagesNum = Integer.valueOf(pages);;
         // if (year.isEmpty()) {
         //    System.out.print("All fields are required!\n");
         //    break;
         // }

         System.out.println("Continue? y/n");
         String continuePrompt = scanner.nextLine();
         System.out.println();


         if (continuePrompt.equals("y") || continuePrompt.equals("Y")) {

            BookListUpdater bookList = new BookListUpdater();
            bookList.AddNewBook(prompt.returnTitle(), prompt.returnAuthor(), prompt.returnPublisher(), prompt.returnYear(), prompt.returnNumPages());
            continue;

         } else if (continuePrompt.equals("n") || continuePrompt.equals("N")) {

            System.out.print("\nSee you next time!\n");
            scanner.close();
            BookListUpdater bookList = new BookListUpdater();
            bookList.AddNewBook(prompt.returnTitle(), prompt.returnAuthor(), prompt.returnPublisher(), prompt.returnYear(), prompt.returnNumPages());
            break;

         } else {

            System.out.print("\nInvalid answer. Saving data and closing program.\n");
            scanner.close();
            BookListUpdater bookList = new BookListUpdater();
            bookList.AddNewBook(prompt.returnTitle(), prompt.returnAuthor(), prompt.returnPublisher(), prompt.returnYear(), prompt.returnNumPages());
            break;

         }
         
      }

    }
}
