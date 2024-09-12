package com.julles.tinyshelf;

import java.util.ArrayList;

public class CreateEntries {
                
    ArrayList<Book> books = new ArrayList<>();
    BookList bookList = new BookList();

    public CreateEntries(){
        
    }

    public void createTestEntries(){
        for (int e = 1; e <= 50; e++) {
            bookList.AddNewBook("Test " + e, "Test", "Test Publishing House", 1999, 99, null, e, null);
        }
    }

}
