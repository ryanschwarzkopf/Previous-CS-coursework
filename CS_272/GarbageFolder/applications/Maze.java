// FILE: Maze.java
// This program illustrates the use of the traverseMaze method that uses
// recursion to guide a user into a maze and back out again.

import java.io.IOException;

/******************************************************************************
* The <CODE>Maze</CODE> Java application illustrates the use of
* the <CODE>traverseMaze</CODE> method that uses recursion to guide a user
* into a maze and back out again.
* <p><b>Java Source Code for this class:</b>
*   <A HREF="../applications/Maze.java">
*   http://www.cs.colorado.edu/~main/applications/Maze.java
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version Feb 10, 2016
******************************************************************************/
public class Maze
{
   /**
   * The main method activates <CODE>traverseMaze</CODE> and prints a message
   * indicating whether the tapestry was found. 
   * @param args
   *   not used in this implementation
   **/
   public static void main(String[ ] args)
   {
      if (traverseMaze( ))
         System.out.println("The tapestry was found.");
      else
         System.out.println("The tapestry was not found.");
   }
    

   /**
   * Determines whether the person traversing the maze has reached a dead end.
   * @return
   *   <CODE>true</CODE> if the direction directly in front of the user
   *   is a dead end (that is, a direction that cannot contain the tapestry).
   **/
   public static boolean deadend( )
   {
      return inquire("Are you facing a wall?")
             ||
             inquire("Is your name written in front of you?");
   }
   
   
   /**
   * Asks a yes/no question and reads the answer.
   * @param query
   *   a question to ask
   * <b>Postcondition:</b>
   *   The <CODE>query</CODE> has been printed to <CODE>System.out</CODE>, and
   *   a one-character response read from <CODE>System.in</CODE> (skipping any
   *   whitespace characters. 
   * @return
   *   The method returns <CODE>true</CODE> if the 
   *   user�s response was �Y� or �y�, and returns <CODE>false</CODE> if the 
   *   user�s response was �N� or �n�.
   *   (If the response is some other character, then the query is repeated and 
   *   a new answer is read.)
   **/
   public static boolean inquire(String query)
   {
      char answer = 'N';
      
      do
      { 
         System.out.println(query + " [Y or N]");
         try
         { 
            do
               answer = (char) System.in.read( );
            while (Character.isWhitespace(answer));
         } 
         catch (IOException e)
         { 
            System.err.println("Standard input error: " + e);
            System.exit(0);
         } 
         answer = Character.toUpperCase(answer);
      }  while ((answer != 'Y') && (answer != 'N'));

      return (answer == 'Y');
   }
   
       
   /**
   * Provides interactive help to guide a user through a maze and back out.
   * <b>Precondition:</b>
   *   The user of the program is facing an unblocked spot in the maze, and
   *   this spot has not previously been visited by the user.
   * <b>Postcondition:</b>
   *   The method has asked a series of queries, and provided various
   *   directions to the user. The queries and directions have led the user
   *   through the maze and back to the exact same position where the user
   *   started. 
   * @return
   *   If there was a magic tapestry that could be reached in
   *   the maze, then the user has picked up this tapestry and the method
   *   returns <CODE>true</CODE>; otherwise the method returns 
   *   <CODE>false</CODE>.
   **/
   public static boolean traverseMaze( )
   {
      int direction;  // Counts 1, 2, 3 for the three directions to explore
      boolean found;  // Will be set to true if we find the tapestry

      System.out.println("Step forward & write your name on the ground.");
      found = inquire("Have you found the tapestry?");

      if (found)
      {  // Pick up the tapestry and step back from whence you came.
         System.out.println("Pick up the tapestry and take a step backward.");
      }
      else
      {  // Explore the three directions (not counting the one that you just came from). Start 
         // with the direction on your left, and then turn through each of the other directions.
         System.out.println("Please turn left 90 degrees.");
         for (direction = 1; direction <= 3; direction++)
         { 
            if ( !found && !deadend( ) )
                  found = traverseMaze( );
            System.out.println("Please turn right 90 degrees.");
         } 
         // You�re now facing the direction from whence you came, so step forward and turn
         // around. This will put you in the same spot when the method was activated.
         System.out.println("Please step forward, then turn 180 degrees.");
      }
      return found;
   }
    
}
