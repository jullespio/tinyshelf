/*
 * This software is free to use
 * @author julles
 */

package com.julles.tinyshelf;

import java.io.IOException;
import java.util.List;

public class App 
{
    public static void main( String[] args ) throws IOException
    {

      //Implement:

      //flags for lent, read book;
      //option to change booklist location from the software itself;
      //the concept of shelves;
      
      //DONE -- custom equals() method for books, to inspect the list for duplicates
      //DONE -- try.. catch in relevant inputs
      //DONE -- a method to print the full list of books (title, author and year);
      //DONE -- validations for int fields;

      //Improve:
      //Method to check for duplicates 

      BookList startList = new BookList();
      List<Book> updatedList = startList.returnBookList();

      if (updatedList.isEmpty()) {
        startList.generateTestEntries(10);
      }

      Prompts prompt = new Prompts();
      prompt.displayGreetings();
      prompt.mainMenuPrompt();


    }
}
