package com.julles.tinyshelf;

import java.util.Scanner;

public class Prompts {

    private String title;
    private String author;

    public Prompts(){
        
    }

    public void askTitle(){

        while (true) {
            System.out.print("\nTitle: ");
            Scanner scanner = new Scanner(System.in);
            String title = scanner.nextLine();
            if (title.isEmpty()) {
                continue;
            }
            this.title = title;
            scanner.close();
            break;   
        }
        
    }

    public String returnTitle(){

        return this.title;

    }

    public void askAuthor(){

        while (true) {
            System.out.print("\nAuthor ");
            Scanner scanner = new Scanner(System.in);
            String author = scanner.nextLine();
            if (author.isEmpty()) {
                System.out.print("All fields are required.");
                continue;
            }
            this.author = author;
            scanner.close();
            break;   
        }
        
    }

    public String returnAuthor(){

        return this.author;

    }

}
