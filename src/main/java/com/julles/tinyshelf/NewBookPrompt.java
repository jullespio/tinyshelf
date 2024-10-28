package com.julles.tinyshelf;

import java.util.List;

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

    Boolean askTitle(){

        Boolean current = true;
        String answer;

        while (true) {
            displayInfoPaddingTop("Title: ");
            answer = scanner.nextLine();
            if (answer.isEmpty()) {
                displayInfoPaddingFull("- Field required. -");
                continue;
            } else if (answer.equalsIgnoreCase("e")) {
                current = false;
                break; 
            } else {
                this.title = answer;
                break;
            }  
        }
        return current; 
    }

    Boolean askAuthor(){

        Boolean current = true;
        String answer;

        while (true) {
            displayInfoPaddingTop("Author: ");
            answer = scanner.nextLine();
            if (answer.isEmpty()) {
                displayInfoPaddingFull("- Field required. -");
                continue;
            } else if (answer.equalsIgnoreCase("e")) {
                current = false;
                break;   
            } else {
                this.author = answer;
                break;
            }
        }
        return current;   
    }

    Boolean askPublisher(){

        Boolean current = true;
        String answer;

        while (true) {
            displayInfoPaddingTop("Publisher: ");
            answer = scanner.nextLine();
            if (answer.isEmpty()) {
                displayInfoPaddingFull("- Field required. -");
                continue;
            } else if (answer.equalsIgnoreCase("e")) {
                current = false;
                break; 
            } else {
                this.publisher = answer;
                break;
            }  
        }
        return current; 
    }

    Boolean askYear(){

        Boolean current = true;
        String answer;

        while (true) {
            displayInfoPaddingTop("Publication year: ");
            answer = scanner.nextLine();

            if (answer.isEmpty()) {
                displayInfoPaddingFull("- Field required. -");
                continue;
            } else if (answer.equals("e")) {
                current = false;
                break;
            } else {
                try {
                    this.year = Integer.valueOf(answer);
                } catch (Exception e) {
                    displayInfoPaddingFull("Please type a valid year (numbers only).");
                    continue;
                }
                break; 
            }
        }
        return current; 
    }

    Boolean askNumPages(){

        Boolean current = true;
        String answer;
        
        while (true) {
            displayInfoPaddingTop("Number of pages: ");
            answer = scanner.nextLine();

            if (answer.isEmpty()) {
                displayInfoPaddingFull("- Field required. -");
                continue;
            } else if (answer.equals("e")) {
                current = false;
                break;
            } else {
                try {
                    this.numPages = Integer.valueOf(answer);
                } catch (Exception e) {
                    displayInfoPaddingFull("Please type a valid number (integer).");
                    continue;
                }
                break; 
            }
        }
        return current;
    }

    Boolean askIsbn(){

        Boolean current = true;
        String answer;

        while (true) {
            //add validation to ensure the field is only 10 or 13 characters long
            //and all inputs are numbers;
            displayInfoPaddingTop("-optional- ISBN: ");
            answer = scanner.nextLine();
            if (answer.isEmpty()) {
                this.isbn = "<add ISBN number>";
                break;   
            } else if (answer.equalsIgnoreCase("e")) {
                current = false;
                break; 
            } else {
                this.isbn = answer;
                break;
            }  
        }
        return current; 
    }

    Boolean askRating(){

        Boolean current = true;
        String answer;

        while (true) {
            System.out.print("-optional- Rating (between 0 and 5): ");
            answer = scanner.nextLine();

            if (answer.isEmpty()) {
                this.rating = 0.0;
                break;
            } else if (answer.equalsIgnoreCase("e")) {
                current = false;
                break;
            } else {
                try {
                    this.rating = Double.valueOf(answer);
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
        return current; 
    }

    Boolean askOtherInfo(){

        Boolean current = true;
        String answer;

        while (true) {
            displayInfoPaddingTop("-optional- Other info: ");
            answer = scanner.nextLine();
            if (answer.isEmpty()) {
                this.otherInfo = "<add relevant information about the book>";
                break;   
            } else if (answer.equalsIgnoreCase("e")) {
                current = false;
                break; 
            } else {
                this.otherInfo = answer;
                break;
            }  
        }
        return current; 
    }
    
    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }

    String getPublisher() {
        return publisher;
    }

    int getYear() {
        return year;
    }

    int getNumPages() {
        return numPages;
    }

    String getIsbn() {
        return isbn;
    }

    double getRating() {
        return rating;
    }

    String getOtherInfo() {
        return otherInfo;
    }

    String getFieldString() {
        return fieldString;
    }


    void currentPrompt(){

        while(true) {
        
            displayInfoPaddingTop("Please type information as asked. All fields are required unless stated otherwise.");
            displayInfoPaddingFull("Answer (e) to exit.");

            if (this.askTitle()==false) {
                break;
            }
            if (this.askAuthor()==false) {
                break;
            }
            if (this.askPublisher()==false) {
                break;
            }
            if (this.askYear()==false) {
                break;
            }
            if (this.askNumPages()==false) {
                break;
            }
            if (this.askIsbn()==false) {
                break;
            }
            if (this.askRating()==false) {
                break;
            }
            if (this.askOtherInfo()==false) {
                break;
            }

            BookList bookList = new BookList();
            List<Book> currentList = bookList.returnBookList();
            int id = bookList.returnLargestId(currentList);

            bookList.AddNewBook(id, this.title, this.author, this.publisher, 
            this.year, this.numPages, this.isbn, this.rating, this.otherInfo);
            
            if (this.continueOrNot()==true) {
                continue;
            }
            break;
   
        }        
       

    }


}
