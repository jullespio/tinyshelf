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
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

class BookList {

    private String homeDir;
    private List<Book> duplicates;

    BookList(){
    
        homeDir = System.getProperty("user.home");

    }

    private final static ObjectMapper mapper(){

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        return objectMapper;
    }

    int returnLargestId(List<Book> booklist){
        ArrayList<Integer> ids = new ArrayList<Integer>(); 

        for (Book book : booklist) {
            ids.add(book.getId());
        }

        if (ids.isEmpty()) {
            return 0;
        } else if (ids.size()==1) {
            return 1;
        } else {
            Collections.sort(ids);
            int max = ids.get(ids.size()-1);    
            return max+1;
        }
    }

    List<Book> returnBookList(){

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

    private Boolean areThereDupes(Book newBook, List<Book> booklist){

        this.duplicates = new ArrayList<>();

        for (Book book : booklist) {
            if (newBook.equals(book)) {
                duplicates.add(book);
            }
        }

        if (duplicates.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    List<Book> returnDupes(){
        return this.duplicates;
    }

    void AddNewBook(int id, String title, String author, String publisher, int year, int numPages, String isbn, double rating, String moreInfo){

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

    List<Book> findBook(String searchTerm){
        List<Book> bookList = this.returnBookList();
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

    Book returnCopy(Book book){
        Book copy = new Book();
        copy.setId(book.getId());
        copy.setTitle(book.getTitle());
        copy.setAuthor(book.getAuthor());
        copy.setPublisher(book.getPublisher());
        copy.setYear(book.getYear());
        copy.setNumPages(book.getNumPages());
        copy.setIsbn(book.getIsbn());
        copy.setRating(book.getRating());
        copy.setOtherInfo(book.getOtherInfo());
        copy.setDateCreated(book.getDateCreated());
        copy.setDateModified(book.getDateModified());

        return copy;
    }

    void updateBook(Book book, String newData, int field){
        List<Book> bookList = this.returnBookList();
        Book updatedBook = this.returnCopy(book);

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
            case 5:
                updatedBook.setIsbn(newData);
                break;
            case 7:
                updatedBook.setOtherInfo(newData);
                break;     

            default:
                break;
        }

        this.checkAndUpdate(book, updatedBook, bookList);
    } 

    void updateBook(Book book, int newData, int field){
        List<Book> bookList = this.returnBookList();

        Book updatedBook = this.returnCopy(book);

        switch (field) {
            case 3:
                updatedBook.setYear(Integer.valueOf(newData));
                break;
            case 4:
                updatedBook.setNumPages(Integer.valueOf(newData));
                break;
            default:
                break;
        }

        this.checkAndUpdate(book, updatedBook, bookList);
    }

    void updateBook(Book book, Double newData, int field){
        List<Book> bookList = this.returnBookList();

        Book updatedBook = this.returnCopy(book);

        switch (field) {
            case 6:
                updatedBook.setRating(Double.valueOf(newData));
                break;
            default:
                break;
        }

        this.checkAndUpdate(book, updatedBook, bookList);
    }
    
    void checkAndUpdate(Book oldBook, Book updatedBook, List<Book> bookList){
        if (this.areThereDupes(updatedBook, bookList)==false) {
            this.removeBook(oldBook, bookList);
            updatedBook.setDateModified(LocalDateTime.now());
            bookList.add(0, updatedBook);
            
            try {

                ObjectMapper objectMapper = mapper();
                objectMapper.writeValue(Paths.get(homeDir + "/.booklist.json").toFile(), bookList);
                System.out.println("\nEntry -" + updatedBook.getTitle() + "- has been updated.");
            
            } catch (Exception ex) {
                //ex.printStackTrace();
                System.out.println("\nSomething went wrong! Book not updated. Please contact the developer.\n");

            }            
        } else {
            System.out.println("\nWarning: duplicate(s) found: ");
            for (Book book : this.duplicates) {
                System.out.println("\n" + book);
            }
            System.out.println("\nBook not updated, please try again.\n");
        }
    }

    void removeBook(Book book, List<Book> booklist){

        booklist.remove(book);
        List<Book> updatedBookList = booklist;
                
        try {

            ObjectMapper objectMapper = mapper();
            objectMapper.writeValue(Paths.get(homeDir + "/.booklist.json").toFile(), updatedBookList);
        
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }

    void printBookList(){
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
    void generateTestEntries(int amount){

        List<Book> updatedList = this.returnBookList();

        if (updatedList.isEmpty()) {
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
                this.AddNewBook(id, "Test Book " + (e-1), author, publisher, year, pages, "<add ISBN number>", rating, "<add relevant information about the book>");
            }
        }  

    }
}
