/*
 * This software is free to use
 * @author julles
 */

package com.julles.tinyshelf;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDateTime;
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


    public ObjectMapper mapper(){

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        return objectMapper;
    }


    public List<Book> returnBookList(){

        List<Book> bookList = new ArrayList<Book>();
        
        try {
            // create object mapper instance
            ObjectMapper objectMapper = this.mapper();
        
            // convert JSON array to list of books
            bookList = new ArrayList<Book>(Arrays.asList(objectMapper.readValue(Paths.get(homeDir + "/.booklist.json").toFile(), Book[].class)));
        
        } catch (Exception ex) {


            File bookListFile = new File(homeDir + "/.booklist.json");
            
            if (!(bookListFile.isFile())) {

                ObjectMapper objectMapper = this.mapper();
                List<Book> savedBooks = bookList;

                try {
                    objectMapper.writeValue(Paths.get(homeDir + "/.booklist.json").toFile(), savedBooks);
                    System.out.println("\nWarning: Unavailable booklist file. A fresh empty file was created at /home/*local user*/.booklist.json. \n");
                } catch (Exception e) {
                    System.out.println("\nSomething went wrong when creating the file. Please contact the developer.\n");
                }
    
            }
            
        }

        return bookList;

    }


    public void AddNewBook(String title, String author, String publisher, int year, int numPages, String isbn, double rating, String moreInfo){

        try {

            List<Book> bookList = returnBookList();

            Book newBook = new Book(title, author, publisher, year, numPages, isbn, rating, moreInfo); 

            // add book to list
            bookList.add(0, newBook);

            ObjectMapper objectMapper = this.mapper();;
        
            // convert books object to JSON file
            objectMapper.writeValue(Paths.get(homeDir + "/.booklist.json").toFile(), bookList);
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    public List<Book> findBook(String searchTerm){

        //  list
        List<Book> bookList = returnBookList();
        List<Book> searchFinds = new ArrayList<Book>();

        if (bookList.isEmpty()) {
            System.out.println("\nWarning: Empty booklist file.\n");
        }

        for (Book book : bookList) {
            
            if (book.getTitle().contains(searchTerm) || book.getAuthor().contains(searchTerm)) {
                searchFinds.add(book);
            }
            
        }

        return searchFinds;

    }


    public void updateBook(Book book, String newData, int field){


            List<Book> bookList = this.returnBookList();
            Book toRemove = book;

            for (Book item : bookList) {
                if (item.toString().equals(book.toString())) {
                    toRemove = item;
                }
            }

            bookList.remove(toRemove);

            Book updatedBook = book;

            switch (field) {
                case 0:
                    updatedBook.setTitle(newData);
                    break;
                case 1:
                    updatedBook.setAuthor(newData);
                    break;
                case 2:
                    updatedBook.setPublisher(newData);
                    break;
                case 3:
                    updatedBook.setYear(Integer.valueOf(newData));
                    break;
                case 4:
                    updatedBook.setNumPages(Integer.valueOf(newData));
                    break;
                case 5:
                    updatedBook.setIsbn(newData);
                    break;
                case 6:
                    updatedBook.setRating(Double.valueOf(newData));
                    break;
                case 7:
                    updatedBook.setOtherInfo(newData);
                    break;     

                default:
                    break;
            }

            updatedBook.setDateModified(LocalDateTime.now());

            bookList.add(0, updatedBook);

                
        try {

            ObjectMapper objectMapper = this.mapper();;
        
            // convert books object to JSON file
            objectMapper.writeValue(Paths.get(homeDir + "/.booklist.json").toFile(), bookList);
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }


    public void removeBook(Book book, List<Book> booklist){

        // remove a preselected book from list

        //if (booklist.contains(book)) {
            booklist.remove(book);
            this.updatedBookList = booklist;
        //}
                
        try {

            // add book to list
            ObjectMapper objectMapper = this.mapper();;
        
            // convert books object to JSON file
            objectMapper.writeValue(Paths.get(homeDir + "/.booklist.json").toFile(), updatedBookList);
        
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }

    public void printBookList(){
        List<Book> bookList = this.returnBookList();

        int numEntries = bookList.size();
        System.out.println();
        if (numEntries>1) {
            System.out.println(numEntries + " entries have been found.\n");
        } 
        
        if (numEntries==1) {
            System.out.println("One entry has been found.\n");
        } 

        if (numEntries==0) {
            System.out.println("No entries have been found.\n");

        }

        int index = 1;

        for (Book book : bookList) {
            System.out.println(index + " => " + book.getTitle() + ", by " + book.getAuthor() + " (" + book.getYear() + ")");
            index++;
        }

    }

    // ONLY FOR TESTING PURPOSES
    public void generateTestEntries(){
        for (int e = 1; e <= 50; e++) {
            String publisher = "Odd Publishing House";
            String author = "Author McTesty";
            int year = 1999;
            if (e%2==0) {
                publisher = "Even Publishing House";
                year = 1993;
                author = "Writer T. Smith";
            }
            this.AddNewBook("Test Book " + e, author, publisher, year, 99, "<add ISBN number>", 0, "<add relevant information about the book>");
        }
    }

    // public void removeRepeatEntry(){
    //     List<Book> list = this.returnBookList();

    //     for (Book book1 : list) {
    //         for (Book book2 : list) {
    //             if (book1.getTitle().equals(book2.getTitle())) {
    //                 removeBook(book1, list);
    //             }
    //         }
    //     }

    // }


}
