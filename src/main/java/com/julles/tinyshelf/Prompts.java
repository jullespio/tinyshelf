package com.julles.tinyshelf;

import java.util.Scanner;

public class Prompts {

    private String title;
    private String author;
    private String publisher;
    private int year;
    private int numPages;


    public Prompts(){
        
    }

    //add validations, so that typing wrong info on prompts
    //restarts them instead of throwing an error;
    //this step is necessary for the implementation of searches, 
    //updating specific fields (simple CRUD in general)

    // Title
    public void askTitle(){

        while (true) {
            System.out.print("\nTitle: ");
            Scanner scanner = new Scanner(System.in);
            String title = scanner.nextLine();
            if (title.isEmpty()) {
                System.out.print("All fields are required.\n");
                continue;
            }
            this.title = title;
            break;   
        }
        
    }

    public String returnTitle(){

        return this.title;

    }

    //Author
    public void askAuthor(){

        while (true) {
            System.out.print("Author: ");
            Scanner scanner = new Scanner(System.in);
            String author = scanner.nextLine();
            if (author.isEmpty()) {
                System.out.println("All fields are required.\n");
                continue;
            }
            this.author = author;
            break;   
        }
        
    }

    public String returnAuthor(){

        return this.author;

    }

    //Publisher
    public void askPublisher(){

        while (true) {
            System.out.print("Publisher: ");
            Scanner scanner = new Scanner(System.in);
            String publisher = scanner.nextLine();
            if (publisher.isEmpty()) {
                System.out.println("All fields are required.\n");
                continue;
            }
            this.publisher = publisher;
            break;   
        }
        
    }

    public String returnPublisher(){

        return this.publisher;

    }

    //year


    //pages

}
