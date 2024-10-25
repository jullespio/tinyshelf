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

    public Boolean askTitle(){

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

    public Boolean askAuthor(){

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

    public Boolean askPublisher(){

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

    public Boolean askYear(){

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
                    this.year = Integer.valueOf(year);
                } catch (Exception e) {
                    displayInfoPaddingFull("Please type a valid year (numbers only).");
                    continue;
                }
                break; 
            }
        }
        return current; 
    }

    public Boolean askNumPages(){

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

    public Boolean askIsbn(){

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

    public Boolean askRating(){

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
                    this.rating = Double.valueOf(rating);
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

    public Boolean askOtherInfo(){

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

            Boolean title = this.askTitle();
            if (title==false) {
                break;
            }

            Boolean author = this.askAuthor();
            if (author==false) {
                break;
            }

            Boolean publisher = this.askPublisher();
            if (publisher==false) {
                break;
            }

            Boolean year = this.askYear();
            if (year==false) {
                break;
            }

            Boolean pages = this.askNumPages();
            if (pages==false) {
                break;
            }
            Boolean isbn = this.askIsbn();
            if (isbn==false) {
                break;
            }
            Boolean rating = this.askRating();
            if (rating==false) {
                break;
            }
            Boolean otherInfo = this.askOtherInfo();
            if (otherInfo==false) {
                break;
            }

            BookList bookList = new BookList();
            bookList.AddNewBook(bookList.returnLargestId(bookList.returnBookList()), this.title, this.author, 
            this.publisher, this.year, this.numPages, this.isbn, this.rating, this.otherInfo);
                
            continue;
   
        }        
       

    }


}
