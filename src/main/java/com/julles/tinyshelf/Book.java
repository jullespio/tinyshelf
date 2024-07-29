/*
 * This software is free to use
 * @author julles
 */

package com.julles.tinyshelf;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

    // New optional fields to implement: 
    // rating (int, 0-10)
    // isbn (int, check size)

    // Create optional field for More Information, moreInfo (string? check best data type)

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
        this.dateCreated = LocalDate.now();
        this.dateModified = LocalDate.now();  
    };

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
    
    public int getNumPages(){
        return this.numPages;
    }
    
    public int getYear(){
        return this.year;
    }

    public LocalDate getDateCreated(){
        return this.dateCreated;
    }

    public LocalDate getDateModified(){
        return this.dateModified;
    }
    
    // update when new optional fields are created
    @Override
    public String toString() {
        return this.title + ", by " + this.author + 
        "\n    Published by " + this.publisher + ", " + this.numPages + " pages, " + this.year +
        "\n    Created " + this.dateCreated + ", last modified " + dateModified;
    }
    
}

