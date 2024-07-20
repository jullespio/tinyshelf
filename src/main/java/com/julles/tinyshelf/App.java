/*
 * This software is free to use
 * @author julles
 */

package com.julles.tinyshelf;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException
    {

      Prompts prompt = new Prompts();

      System.out.println("\nGreetings!\n>>>> Welcome to tinyShelf <<<<");
      System.out.print("\nPlease type information as asked. All fields are required.\n");

      while(true) {
        
         prompt.askTitle();
         prompt.askAuthor();
         prompt.askPublisher();
         prompt.askYear();
         prompt.askNumPages();

         prompt.continueOrNot();

         String continuePrompt = prompt.returnContinueOrNot();

         if (continuePrompt.equals("y") || continuePrompt.equals("Y")) {

            BookListUpdater bookList = new BookListUpdater();
            bookList.AddNewBook(prompt.returnTitle(), prompt.returnAuthor(), prompt.returnPublisher(), prompt.returnYear(), prompt.returnNumPages());
            continue;

         } else if (continuePrompt.equals("n") || continuePrompt.equals("N")) {

            System.out.print("\nSee you next time!\n");
            BookListUpdater bookList = new BookListUpdater();
            bookList.AddNewBook(prompt.returnTitle(), prompt.returnAuthor(), prompt.returnPublisher(), prompt.returnYear(), prompt.returnNumPages());
            break;

         } else {

            System.out.print("\nInvalid answer. Saving data and closing program.\n");
            BookListUpdater bookList = new BookListUpdater();
            bookList.AddNewBook(prompt.returnTitle(), prompt.returnAuthor(), prompt.returnPublisher(), prompt.returnYear(), prompt.returnNumPages());
            break;

         }
         
      }
      
    }
}
