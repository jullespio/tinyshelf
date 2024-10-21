/*
 * This software is free to use
 * @author julles
 */

package com.julles.tinyshelf;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class BookList {

    private String homeDir;

    public BookList(){
    
        homeDir = System.getProperty("user.home");

    }

    private final static ObjectMapper mapper(){

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        return objectMapper;
    }

    public int returnLargestId(List<Book> booklist){

        ArrayList<Integer> ids = new ArrayList<Integer>(); 

        for (Book book : booklist) {
            ids.add(book.getId());
        }

        int id = 0;

        if (ids.isEmpty()) {
            return id;
        } else {
            return ids.size();
        }

    }

    public List<Book> returnBookList(){

        List<Book> bookList = new ArrayList<Book>();
        
        try {
 
            ObjectMapper objectMapper = mapper();
            bookList = new ArrayList<Book>(Arrays.asList(objectMapper.readValue(Paths.get(homeDir + "/.booklist.json").toFile(), Book[].class)));
        
        } catch (Exception ex) {

            File bookListFile = new File(homeDir + "/.booklist.json");
            
            if (!(bookListFile.isFile())) {

                ObjectMapper objectMapper = mapper();
                //List<Book> savedBooks = bookList;

                try {
                    objectMapper.writeValue(Paths.get(homeDir + "/.booklist.json").toFile(), bookList);
                    System.out.println("\nWarning: Unavailable booklist file. A fresh one has been created at /home/*local user*/.booklist.json. \n");
                } catch (Exception e) {
                    System.out.println("\nWarning: Something went wrong when creating the file! Please inform the developer.\n");
                }
    
            }
            
        }

        return bookList;

    }


    public Boolean areThereDupes(Book newBook, List<Book> booklist){

        ArrayList<Book> duplicates = new ArrayList<>();

        for (Book book : booklist) {
            if (newBook.equals(book)) {
                duplicates.add(book);
            }
        }

        if (duplicates.isEmpty()) {
            return false;
        }

        return true;

    }


    public void AddNewBook(int id, String title, String author, String publisher, int year, int numPages, String isbn, double rating, String moreInfo){

        List<Book> bookList = returnBookList();

        id = returnLargestId(bookList);
        
        Book newBook = new Book(id, title, author, publisher, year, numPages, isbn, rating, moreInfo); 

        if (this.areThereDupes(newBook, bookList)==false) {

            bookList.add(0, newBook);
            
            try {

                ObjectMapper objectMapper = mapper();
                objectMapper.writeValue(Paths.get(homeDir + "/.booklist.json").toFile(), bookList);
                System.out.println("\nNew entry -" + title + "- has been added.");
            
            } catch (Exception ex) {
                //ex.printStackTrace();
                System.out.println("\nSomething went wrong! Book not saved. Please contact the developer.\n");

            }            
        } else {
            System.out.println("\nDuplicate entry! Book not saved, please try again.\n");
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

        Book bookToUpdate = book;

        switch (field) {
            case 0:
                bookToUpdate.setTitle(newData);
                break;
            case 1:
                bookToUpdate.setAuthor(newData);
                break;
            case 2:
                bookToUpdate.setPublisher(newData);
                break;
            case 3:
                bookToUpdate.setYear(Integer.valueOf(newData));
                break;
            case 4:
                bookToUpdate.setNumPages(Integer.valueOf(newData));
                break;
            case 5:
                bookToUpdate.setIsbn(newData);
                break;
            case 6:
                bookToUpdate.setRating(Double.valueOf(newData));
                break;
            case 7:
                bookToUpdate.setOtherInfo(newData);
                break;     

            default:
                break;
        }


        if (this.areThereDupes(bookToUpdate, bookList)==false) {
            
            bookList.remove(book);
            bookToUpdate.setDateModified(LocalDateTime.now());
            bookList.add(0, bookToUpdate);
            
            try {

                ObjectMapper objectMapper = mapper();
                objectMapper.writeValue(Paths.get(homeDir + "/.booklist.json").toFile(), bookList);
                System.out.println("\nEntry -" + bookToUpdate.getTitle() + "- has been updated.");
            
            } catch (Exception ex) {
                //ex.printStackTrace();
                System.out.println("\nSomething went wrong! Book not updated. Please contact the developer.\n");

            }            
        } else {
            System.out.println("\nThis action will create a duplicate entry! Book not updated, please try again.\n");
        }

    }    


    public void removeBook(Book book, List<Book> booklist){

        booklist.remove(book);
        List<Book> updatedBookList = booklist;
                
        try {

            ObjectMapper objectMapper = mapper();
            objectMapper.writeValue(Paths.get(homeDir + "/.booklist.json").toFile(), updatedBookList);
        
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }

    public void printBookList(){
        List<Book> bookList = this.returnBookList();
        DateTimeFormatter formatedDate = DateTimeFormatter.ofPattern("MMM dd yyyy 'at' KK:mm:ss a");        
        int numEntries = bookList.size();

        System.out.println();
        if (numEntries>1) {
            System.out.println(numEntries + " entries have been found (ordered by last modified):\n");
        } 
        
        if (numEntries==1) {
            System.out.println("One entry has been found.\n");
        } 

        if (numEntries==0) {
            System.out.println("No entries have been found.\n");

        }

        int index = 1;

        for (Book book : bookList) {
            System.out.println(index + " - " + book.getTitle() + ", by " + book.getAuthor() + " (" + book.getYear() + ") => Modified " + book.getDateModified().format(formatedDate));
            index++;
        }

    }

    // ONLY FOR TESTING PURPOSES
    public void generateTestEntries(int amount){
        for (int e = 1; e <= amount; e++) {
            String publisher = "Odd Publishing House";
            String author = "Author McTesty";
            int year = 1999;
            int pages = 99;
            double rating = 4.0;

            if (e%2==0) {
                publisher = "Even Publishing House";
                year = 1993;
                author = "Writer T. Smith";
                pages = 246;
                rating = 3.8;
    
            }

            if (e%2==0 && e%4==0) {
                publisher = "Offbeat Publishing House";
                year = 1976;
                author = "Harry \"Crazy Horse\" Flannagan";
                pages = 468;
                rating = 5.0;
            }

            int id = returnLargestId(returnBookList());
            this.AddNewBook(id, "Test Book " + e, author, publisher, year, pages, "<add ISBN number>", rating, "<add relevant information about the book>");
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
