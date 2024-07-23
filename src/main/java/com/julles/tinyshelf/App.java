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

      while(true) {
        
         prompt.askTitle();
         prompt.askAuthor();
         prompt.askPublisher();
         prompt.askYear();
         prompt.askNumPages();

         prompt.continueOrNot();

         String continuePrompt = prompt.returnContinueOrNot();

         if (continuePrompt.equals("y") || continuePrompt.equals("Y")) {

            prompt.sendToUpdater();
            continue;

         } else if (continuePrompt.equals("n") || continuePrompt.equals("N")) {

            System.out.print("\nSee you next time!\n");
            prompt.sendToUpdater();
            break;

         } else {

            System.out.print("\nInvalid answer. Saving data and closing program.\n");
            prompt.sendToUpdater();
            break;

         }
         
      }
      
    }
}
