/*
 * This software is free to use
 * @author julles
 */

package com.julles.tinyshelf;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException
    {

      Prompts prompt = new Prompts();

      prompt.displayGreetings();

      prompt.newBookPrompt();
      
    }
}
