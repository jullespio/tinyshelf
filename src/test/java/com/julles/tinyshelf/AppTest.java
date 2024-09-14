package com.julles.tinyshelf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import java.util.List;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {

        CreateEntries entries = new CreateEntries();
        BookList list = new BookList();
        List<Book> booklist = list.returnBookList();

        assertEquals( booklist.size(), 50 );
    }
   
}
