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

      //Implement:
      //try.. catch in inputs
      //equals method for books, to insoect the list for duplicates
      //DONE -- a method to print the full list of books (title, author and year);
      //validations for int fields;
      //flags for lent, read book;
      //option to change booklist location from the software itself;
      //the concept of shelves;

      Prompts prompt = new Prompts();
      prompt.displayGreetings();
      prompt.mainMenuPrompt();

    }
}
