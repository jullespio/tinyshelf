package com.julles.tinyshelf;

public class NewBookPrompt extends Prompt {

    private String title;
    private String author;
    private String publisher;
    private int year;
    private int numPages;
    private String isbn;
    private double rating;
    private String otherInfo;
    private String fieldString;

    NewBookPrompt(){
        super();
    }

    public void askTitle(){
        while (true) {
            displayInfoPaddingTop("Title: ");
            this.title = scanner.nextLine();
            if (title.isEmpty()) {
                displayInfoPaddingFull("- Field required. -");
                continue;
            } 
            break;
        }
    }

    public void askAuthor(){
        while (true) {
            displayInfoPaddingTop("Author: ");
            this.author = scanner.nextLine();
            if (author.isEmpty()) {
                displayInfoPaddingFull("- Field required. -");
                continue;
            }
            break;   
        }   
    }

    public void askPublisher(){

        while (true) {
            displayInfoPaddingTop("Publisher: ");
            this.publisher = scanner.nextLine();
            if (publisher.isEmpty()) {
                displayInfoPaddingFull("- Field required. -");
                continue;
            }
            break;   
        }
    }

    public void askYear(){
        while (true) {
            displayInfoPaddingTop("Publication year: ");
            String year = scanner.nextLine();

            if (year.isEmpty()) {
                displayInfoPaddingFull("- Field required. -");
                continue;
            } else if (year.equals("e")) {
                this.fieldString = year;
                break;
            } else {
                try {
                    this.year = Integer.valueOf(year);
                    //this.fieldString = year;
                } catch (Exception e) {
                    displayInfoPaddingFull("Please type a valid year (numbers only).");
                    continue;
                }
                break; 
            }
        }
    }

    public void askNumPages(){
        while (true) {
            displayInfoPaddingTop("Number of pages: ");
            String pages = scanner.nextLine();

            if (pages.isEmpty()) {
                displayInfoPaddingFull("- Field required. -");
                continue;
            } else if (pages.equals("e")) {
                this.fieldString = pages;
                break;
            } else {
                try {
                    this.numPages = Integer.valueOf(pages);
                    //this.fieldString = pages;
                } catch (Exception e) {
                    displayInfoPaddingFull("Please type a valid number (integer).");
                    continue;
                }
                break; 
            }
        }
        
    }

    public void askIsbn(){
        while (true) {
            //add validation to ensure the field is only 10 or 13 characters long
            //and all inputs are numbers;
            displayInfoPaddingTop("-optional- ISBN: ");
            String isbn = scanner.nextLine();
            if (isbn.isEmpty()) {
                this.isbn = "<add ISBN number>";
                break;   
            }
            this.isbn = isbn;
            break;   
        }
        
    }

    public void askRating(){
        while (true) {
            System.out.print("-optional- Rating (between 0 and 5): ");
            String rating = scanner.nextLine();

            if (rating.isEmpty()) {
                this.rating = 0.0;
                break;
            } else if (rating.equals("e")) {
                this.fieldString = rating;
                break;
            } else {
                try {
                    this.rating = Double.valueOf(rating);
                    //this.fieldString = rating;

                } catch (Exception e) {
                    displayInfoPaddingFull("Please type a valid rating from zero to five (e.g.: 5, 4.3, 2.6).");
                    continue;
                }

                if (!(this.rating>=0 && this.rating<=5)) {
                    displayInfoPaddingFull("Please type a valid rating from zero to five (e.g.: 5, 4.3, 2.6).");
                    continue;
                } 

                break; 
            }

        }
        
    }

    public void askOtherInfo(){

        while (true) {
            displayInfoPaddingTop("-optional- Other info: ");
            String otherInfo = scanner.nextLine();
            if (otherInfo.isEmpty()) {
                this.otherInfo = "<add relevant information about the book>";
                break;   
            }
            this.otherInfo = otherInfo;
            break;   
        }
        
    }
    
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public int getNumPages() {
        return numPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getRating() {
        return rating;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public String getFieldString() {
        return fieldString;
    }


    public void currentPrompt(){

        while(true) {
        
            displayInfoPaddingTop("Please type information as asked. All fields are required unless stated otherwise.");
            displayInfoPaddingFull("Answer (e) to exit.");

            this.askTitle();
            if (this.title.equalsIgnoreCase("e")) {
                break;
            }

            this.askAuthor();
            if (this.author.equalsIgnoreCase("e")) {
                break;
            }

            this.askPublisher();
            if (this.publisher.equalsIgnoreCase("e")) {
                break;
            }

            this.askYear();
            if (this.fieldString.equalsIgnoreCase("e")) {
                break;
            }

            this.askNumPages();
            if (this.fieldString.equalsIgnoreCase("e")) {
                break;
            }
            this.askIsbn();
            if (this.isbn.equalsIgnoreCase("e")) {
                break;
            }
            this.askRating();
            if (this.fieldString.equalsIgnoreCase("e")) {
                break;
            }
            this.askOtherInfo();
            if (this.fieldString.equalsIgnoreCase("e")) {
                break;
            }

            BookList bookList = new BookList();
            bookList.AddNewBook(bookList.returnLargestId(bookList.returnBookList()), this.title, this.author, 
            this.publisher, this.year, this.numPages, this.isbn, this.rating, this.otherInfo);
                
            continue;
   
        }        
       

    }


}
