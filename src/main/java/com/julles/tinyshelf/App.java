/*
 * This software is free to use
 * @author julles
 */

package com.julles.tinyshelf;

import java.io.IOException;
//import java.util.List;

public class App 
{
    public static void main( String[] args ) throws IOException
    {

      Prompts prompt = new Prompts();
      // prompt.displayGreetings();
      // prompt.mainMenuPrompt();
      // prompt.updatePrompt();
      // BookList bookList = new BookList();
      // List<Book> savedBooks = bookList.returnBookList();
      // Book book = savedBooks.get(0);

      // bookList.removeBook(book, savedBooks);

      prompt.removePrompt();

    }
}
