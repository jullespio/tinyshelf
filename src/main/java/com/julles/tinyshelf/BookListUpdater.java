/*
 * This software is free to use
 * @author julles
 */

package com.julles.tinyshelf;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class BookListUpdater {

    final String homeDir;

    public BookListUpdater(){
    
        homeDir = System.getProperty("user.home");

    }

    public List<Book> loadBookList(){

        List<Book> savedBooks = new ArrayList<Book>();
        
        try {
            // create object mapper instance
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        
            // convert JSON array to list of books
            savedBooks = new ArrayList<Book>(Arrays.asList(objectMapper.readValue(Paths.get(homeDir + "/.booklist.json").toFile(), Book[].class)));
        
        } catch (Exception ex) {
            //ex.printStackTrace();
            //if list is empty or doesn't exist, populate/create
            if (savedBooks.isEmpty()) {
                //savedBooks = new ArrayList<Book>();
                System.out.println("\nNote: Your book list was empty or not yet created.\nThe populated file can be found at /home/*local user*/.booklist.json.\n");
            }
            
        }

        return savedBooks;

    }

    public List<Book> retrieveBookList(){

        List<Book> savedBooks = new ArrayList<Book>();
        

        try {
            // create object mapper instance
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        
            // convert JSON array to list of books
            savedBooks = new ArrayList<Book>(Arrays.asList(objectMapper.readValue(Paths.get(homeDir + "/.booklist.json").toFile(), Book[].class)));
        
        } catch (Exception ex) {
            
            ex.printStackTrace();
            
        }

        return savedBooks;

    }


    public void AddNewBook(String title, String author, String publisher, int year, int numPages){

        try {

            List<Book> savedBooks = loadBookList();

            Book newBook = new Book(title, author, publisher, year, numPages); 

            // add book to list
            savedBooks.add(newBook);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        
            // convert books object to JSON file
            objectMapper.writeValue(Paths.get(homeDir + "/.booklist.json").toFile(), savedBooks);
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        

    }

    public void removeBook(){

        // remove a selected book from list

    }

    public void editBook(){

        // edit a selected book from list

    }

}
