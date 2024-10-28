/*
 * This software is free to use
 * @author julles
 */

package com.julles.tinyshelf;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonProperty;

class Book {

    @JsonProperty("ID")
    private int id;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Author(s)")
    private String author;

    @JsonProperty("Publisher")
    private String publisher;

    @JsonProperty("Publication Year")
    private int year;

    @JsonProperty("Pages")
    private int numPages;

    @JsonProperty("ISBN")
    private String isbn;

    @JsonProperty("Rating")
    private double rating;

    @JsonProperty("Other information")
    private String otherInfo;

    @JsonProperty("Read")
    private Boolean read;

    @JsonProperty("Lent")
    private Boolean lent;

    @JsonProperty("Created")
    private LocalDateTime dateCreated;

    @JsonProperty("Last Modified")
    private LocalDateTime dateModified;

    Book(){};

    Book(int id, String title, String author, String publisher, int year, int numPages, String isbn, double rating, String otherInfo){
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.numPages = numPages;
        this.isbn = isbn;
        this.rating = rating;
        this.otherInfo = otherInfo;
        this.read = true;
        this.lent = false;
        this.dateCreated = LocalDateTime.now();
        this.dateModified = LocalDateTime.now();  
    };

    /*  Getters */

    int getId(){
        return this.id;
    }
    
    String getTitle(){
        return this.title;
    }
    
    String getAuthor(){
        return this.author;
    }
    
    String getPublisher(){
        return this.publisher;
    }
        
    int getYear(){
        return this.year;
    }
    
    int getNumPages(){
        return this.numPages;
    }

    String getIsbn() {
        return this.isbn;
    }

    double getRating() {
        return rating;
    }

    String getOtherInfo() {
        return otherInfo;
    }

    //@JsonFormat(pattern = "MM.dd.yyyy 'at' KK:mm:ss a")
    LocalDateTime getDateCreated(){
        return this.dateCreated;
    }

    //@JsonFormat(pattern = "MM.dd.yyyy 'at' KK:mm:ss a")
    LocalDateTime getDateModified(){
        return this.dateModified;
    }

    /*  Setters */

    void setId(int id) {
        this.id = id;
        this.dateModified = LocalDateTime.now();
    }

    void setTitle(String title){
        this.title = title;
        this.dateModified = LocalDateTime.now();
    }

    void setAuthor(String author) {
        this.author = author;
        this.dateModified = LocalDateTime.now();
    }

    void setPublisher(String publisher) {
        this.publisher = publisher;
        this.dateModified = LocalDateTime.now();
    }

    void setYear(int year) {
        this.year = year;
        this.dateModified = LocalDateTime.now();
    }

    void setNumPages(int numPages) {
        this.numPages = numPages;
        this.dateModified = LocalDateTime.now();
    }

    void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    void setRating(double rating) {
        this.rating = rating;
    }

    void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    void setDateModified(LocalDateTime dateModified) {
        this.dateModified = dateModified;
    }

    public boolean equals(Object compared) {
        // if the variables are located in the same position, they are equal
        if (this == compared) {
            return true;
        }

        // if the type of the compared object is not Book, the objects are not equal
        if (!(compared instanceof Book)) {
            return false;
        }

        // convert the Object type compared object
        // into a SimpleDate type object called comparedSimpleDate
        Book comparedBook = (Book) compared;

        // if the values of the object variables are the same, the objects are equal
        if (this.title.equals(comparedBook.getTitle()) &&
            this.author.equals(comparedBook.getAuthor()) &&
            this.publisher.equals(comparedBook.getPublisher()) &&
            this.year == comparedBook.getYear() &&
            this.numPages == comparedBook.getNumPages() && 
            this.isbn.equals(comparedBook.getIsbn()) &&
            this.rating == comparedBook.getRating() &&
            this.otherInfo.equals(comparedBook.getOtherInfo())) 
            {
            return true;
        }

        // otherwise the objects are not equal
        return false;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatedDate = DateTimeFormatter.ofPattern("MMM dd yyyy 'at' KK:mm:ss a");

        return this.title + ", by " + this.author + 
        "\n    Published by " + this.publisher + ", " + this.numPages + " pages, " + this.year + "." +
        "\n    ISBN: " + this.isbn +
        "\n    Rated " + this.rating + " out of 5 " + 
        "\n    Other information: " + 
        "\n    -- " + this.otherInfo + 
        "\n    Read? " + this.read + " | Lent? " + this.lent + 
        "\n    Created: " + this.dateCreated.format(formatedDate) + 
        "\n    Last modified: " + dateModified.format(formatedDate);
    }
}

