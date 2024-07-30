/*
 * This software is free to use
 * @author julles
 */

package com.julles.tinyshelf;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

    // New optional fields to implement: 
    // rating (double, 0-5)
    // isbn (string)
    // field for More Information, moreInfo (string)

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Author")
    private String author;

    @JsonProperty("Publisher")
    private String publisher;

    @JsonProperty("Year")
    private int year;

    @JsonProperty("Pages")
    private int numPages;

    @JsonProperty("ISBN")
    private String isbn;

    @JsonProperty("Rating")
    private double rating;

    @JsonProperty("Other information")
    private String otherInfo;

    @JsonProperty("Created")
    private LocalDate dateCreated;

    @JsonProperty("Last Modified")
    private LocalDate dateModified;


    public Book(){

    };


    public Book(String title, String author, String publisher, int year, int numPages){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.numPages = numPages;
        this.isbn = "<add ISBN number>";
        this.rating = 0.0;
        this.otherInfo = "<add other relevant information about the book>";
        this.dateCreated = LocalDate.now();
        this.dateModified = LocalDate.now();  
    };

    public Book(String title, String author, String publisher, int year, int numPages, String isbn, double rating, String otherInfo, LocalDate dateModified){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.numPages = numPages;
        this.isbn = "<add ISBN number>";
        this.rating = 0.0;
        this.otherInfo = "<add other relevant information about the book>";
        this.dateCreated = LocalDate.now();
        this.dateModified = LocalDate.now();  
    };
    

    /*  Getters */

    public String getTitle(){
        return this.title;
    }
    
    public String getAuthor(){
        return this.author;
    }
    
    public String getPublisher(){
        return this.publisher;
    }
        
    public int getYear(){
        return this.year;
    }
    
    public int getNumPages(){
        return this.numPages;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public double getRating() {
        return rating;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public LocalDate getDateCreated(){
        return this.dateCreated;
    }

    public LocalDate getDateModified(){
        return this.dateModified;
    }


    /*  Setters */

    public void setTitle(String title){
        this.title = title;
        this.dateModified = LocalDate.now();
    }

    public void setAuthor(String author) {
        this.author = author;
        this.dateModified = LocalDate.now();
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
        this.dateModified = LocalDate.now();
    }

    public void setYear(int year) {
        this.year = year;
        this.dateModified = LocalDate.now();
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
        this.dateModified = LocalDate.now();
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }


    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public void setDateModified(LocalDate dateModified) {
        this.dateModified = dateModified;
    }

    
    // update when new optional fields are created
    @Override
    public String toString() {
        return this.title + ", by " + this.author + 
        "\n    Published by " + this.publisher + ", " + this.numPages + " pages, " + this.year + "." +
        "\n    Rated " + this.rating + "/5.0. ISBN " + this.isbn + "." +
        "\n    Other information: \n    " + this.otherInfo + 
        "\n    Created " + this.dateCreated + ", last modified " + dateModified;
    }
    
}

