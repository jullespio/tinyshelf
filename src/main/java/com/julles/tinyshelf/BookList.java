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

public class BookList {

    final String homeDir;
    private List<Book> updatedBookList;

    public BookList(){
    
        homeDir = System.getProperty("user.home");

    }

    public List<Book> returnBookList(){

        List<Book> bookList = new ArrayList<Book>();
        
        try {
            // create object mapper instance
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        
            // convert JSON array to list of books
            bookList = new ArrayList<Book>(Arrays.asList(objectMapper.readValue(Paths.get(homeDir + "/.booklist.json").toFile(), Book[].class)));
        
        } catch (Exception ex) {
            //ex.printStackTrace();
            //if list is empty or doesn't exist, populate/create
            if (bookList.isEmpty()) {
                //savedBooks = new ArrayList<Book>();
                System.out.println("\nNote: Your book list was empty or not yet created.\nThe populated hidden file can be found at /home/*local user*/.booklist.json.\n");
            }
            
        }

        return bookList;

    }

    public void AddNewBook(String title, String author, String publisher, int year, int numPages){

        try {

            List<Book> savedBooks = returnBookList();

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

    public List<Book> findBook(String searchTerm){

        //  list
        List<Book> bookList = returnBookList();
        List<Book> searchFinds = new ArrayList<Book>();

        for (Book book : bookList) {
            
            if (book.getTitle().contains(searchTerm) || book.getAuthor().contains(searchTerm)) {
                searchFinds.add(book);
            }
            
        }

        return searchFinds;

    }

    public void updateBookFieldString(Book book, int field, String updatedData){
        // edit a selected string field from a book 
        
        List<Book> bookList = this.returnBookList();
        Book updatedBook = book;
        
        // set new value for field
        switch (field) {
            case 0:
                updatedBook.setTitle(updatedData);
                break;
        
            default:
                break;
        }
        
        try {

            // Remove selected book from booklist before updating field
            bookList.remove(book); //this isn't working, find out why
            bookList.add(updatedBook);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        
            // convert books object to JSON file
            objectMapper.writeValue(Paths.get(homeDir + "/.booklist.json").toFile(), bookList);
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        
        // send to this.updateBook();

    }

    public void updateBookFieldInt(Book book, int field, int updatedData){

        

        // edit a selected string field from a book 

    }

    public void removeBook(Book book, List<Book> booklist){

        // remove a preselected book from list

        if (booklist.contains(book)) {
            booklist.remove(book);
            this.updatedBookList = booklist;
        }
                
        try {

            // add book to list
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        
            // convert books object to JSON file
            objectMapper.writeValue(Paths.get(homeDir + "/.booklist.json").toFile(), updatedBookList);
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        
    }

}
