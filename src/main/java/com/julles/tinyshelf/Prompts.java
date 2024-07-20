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

    // Title
    public void askTitle(){

        while (true) {
            System.out.print("\nTitle: ");
            Scanner scanner = new Scanner(System.in);
            String title = scanner.nextLine();
            if (title.isEmpty()) {
                System.out.print("All fields are required.");
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
                System.out.print("All fields are required.");
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
                System.out.print("All fields are required.");
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
