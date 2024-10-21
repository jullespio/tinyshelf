package com.julles.tinyshelf;

public class newBookPrompt extends Prompt {

    public void currentPrompt(){

        while(true) {
        
            System.out.print(
                "\nPlease type information as asked. Fields are required unless stated otherwise." + 
                "\nPress (e) to exit.\n"
                );

            this.askTitle();
            if (this.fieldString.equals("e")) {
                break;
            }
            this.askAuthor();
            if (this.fieldString.equals("e")) {
                break;
            }
            this.askPublisher();
            if (this.fieldString.equals("e")) {
                break;
            }
            this.askYear();
            if (this.fieldString.equals("e")) {
                break;
            }
            this.askNumPages();
            if (this.fieldString.equals("e")) {
                break;
            }
            this.askIsbn();
            if (this.fieldString.equals("e")) {
                break;
            }
            this.askRating();
            if (this.fieldString.equals("e")) {
                break;
            }
            this.askOtherInfo();
            if (this.fieldString.equals("e")) {
                break;
            }

            BookList bookList = new BookList();
            bookList.AddNewBook(returnId(), returnTitle(), returnAuthor(), returnPublisher(), returnYear(), returnNumPages(), returnIsbn(), returnRating(), returnOtherInfo());
                
            continue;
   
        }        
       

    }


}
