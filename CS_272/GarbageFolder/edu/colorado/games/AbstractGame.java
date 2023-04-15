package edu.colorado.games;
import java.util.Vector;
import java.util.Scanner;

public abstract class AbstractGame implements Cloneable
{
   // THREE CONSTANTS (for a possible game outcome):
   enum Player { human, nobody, computer };  

   // TWO PUBLIC METHODS (to play games):
   // The play method plays one game, with the human player moving
   // first and the computer second. The computer uses an alpha-beta
   // look ahead algorithm to select its moves. The return value 
   // is the winner of the game (or Player.nobody for a tie).
   // If play is called a second time, then it displays the final status of
   // the game that was already played and returns its winner.
   public final Player play(int depth)
   {
      while (!isGameOver( ))
      {
         displayStatus( );
         if (nextMover( ) == Player.human)
            makeHumanMove( );
         else
            makeComputerMove(depth);
      }
      displayStatus( );
      return winning( );
   }

   @SuppressWarnings("unchecked")
   public static final double repeatPlay(String name, int depth)
   {
      java.lang.Class myClass;
      java.lang.reflect.Constructor myConstructor;
      AbstractGame round;
      int humanPoints = 0; // 2 for a win; 1 for a tie.
      int gamesPlayed = 0;
      String a;
      
      try
      {
         myClass = java.lang.Class.forName(name); 
         myConstructor = myClass.getConstructor(new Class[ ] { });

         do
         {
            round = (AbstractGame) myConstructor.newInstance(new Object[ ] { });

            switch(round.play(depth))
            {
            case human: System.out.println("You win"); humanPoints += 2; break;
            case nobody: System.out.println("A draw"); humanPoints++; break;
            case computer: System.out.println("I win"); break;
            }
	    gamesPlayed++;
	    System.out.print("Do you want to play again? Y/N");
	    a = stdin.nextLine( );    
         }  while (a.length( ) > 0 && a.charAt(0) == 'Y' || a.charAt(0) == 'y');
      }
      catch (Exception e)
      {
	 throw new IllegalArgumentException("Could not play " + name);
      }
      return humanPoints/gamesPlayed;
   }


     
   // FOUR FINAL PROTECTED FUNCTIONS (for extended classes to use if they wish):
   // The movesCompleted method returns the number of moves done so far.
   protected final int movesCompleted( )
   {
      return moveNumber;
   }

   // The nextMover method returns the next mover (human or computer).
   protected final Player nextMover( )
   {
      return (moveNumber % 2 == 0 ? Player.human : Player.computer);
   }

     
   // FIVE METHODS THAT MAY BE OVERRIDDEN BY AN EXTENDED CLASS:
   // The clone method makes a copy of this game.  If the extended class
   // uses any arrays or other objects, then this method must be overridden
   // so that the cloned object does not share objects with the original.      
   protected AbstractGame clone( )
   {
      AbstractGame answer;

      try
      {
         answer = (AbstractGame) super.clone( );
      }
      catch (Exception e)
      {
         throw new RuntimeException
         ("This class does not implement Cloneable.");
      }
      return answer;
   }

   // The displayMessage method writes a message to the user.  This version
   // just writes that message to the screen, but an extended class may 
   // override for a fancier output.
   protected void displayMessage(String message)
   {
      System.out.println(message);
   }

   // The getUserMove method asks the user to type his or her move and
   // returns the answer as a string.  An extended class may override to
   // achieve a fancier interaction.
   protected String getUserMove( )
   {
      System.out.print("Your move, please: ");       
      return stdin.nextLine( );
   }

   // The makeMove method is called to make a move in the game.  Almost every
   // extended class will override this method so that it can update its own
   // variables that are keeping track of the game status.  Note: The last
   // statement of any overriding makeMove must be to call this version of
   // makeMove (using super.makeMove).  
   protected void makeMove(String move)
   {
      if (!isLegal(move))
	 throw new IllegalArgumentException("Illegal move: " + move);     
      moveNumber++;
   }

   // The winning method uses a simple technique to figure out who is winning
   // the game (human, computer, or nobody).  An extended class may override
   // this method to provide a more sophisticated analysis.
   protected Player winning( )
   {
      double value = evaluate( );

      // Evaluate returns positive if things favor the computer:
      if (value > 0)
         return Player.computer;
      else if (value < 0)
         return Player.human;
      else
         return Player.nobody;
   }


     
   // FIVE ABSTRACT METHODS THAT EVERY EXTENDED CLASS MUST PROVIDE:
   // The return value of computerMoves is a Vector that contains all the   
   // legal moves that can currently be made in the game.  It is called only 
   // if the game is not over, so the Vector that it returns must contain
   // at least one move.  These moves are all Java strings.  The displayStatus
   // method shows the current status of the game to the user (perhaps by
   // printing to the screen).  The evaluate function evaluates the current
   // status of the game, returning a negative number if the status seems to
   // favor the computer and a positive number for a human advantage.  Zero
   // indicates no advantage to either player; values closer to zero indicate
   // smaller advantages than values far away.  The last two methods indicate
   // whether the game is over and whether a given string is currently a legal
   // move.  
   protected abstract Vector<String> computeMoves( );
   protected abstract void displayStatus( );
   protected abstract double evaluate( );
   protected abstract boolean isGameOver( );
   protected abstract boolean isLegal(String move);


     
   // THREE PRIVATE VARIABLES and THREE PRIVATE METHODS:
   private static final Scanner stdin = new Scanner(System.in);
   private int moveNumber = 0;

   private double evalWithLookahead(int lookAhead, double beatThis)
   // Evaluate current board position with lookahead.
   // --int lookAhead:  How deep the lookahead should go to evaluate
   // the current board position.
   // --int beatThis: Value of another board position that we're considering.
   // If the current board position can't beat this, then cut it short.
   // The return value is large if the position is good for the player who just
   // moved. 
   {
      Vector<String> moves;  // All possible opponent moves
      double value;          // Value of a board position after opponent moves
      double bestValue;      // Evaluation of best opponent move
      AbstractGame future;   // Ref to a future version of this game

      // Base case:
      if (lookAhead <= 0 || isGameOver( ))
      {
         if (nextMover( ) == Player.human)
            return evaluate( );
         else
            return -evaluate( );
      }

      // Recursive case:
      // The level is above 0, so try all possible opponent moves. Keep the
      // value of the best of these moves from the opponent's perspective.
      moves = computeMoves( );
      bestValue = Double.NEGATIVE_INFINITY;
      do
      {
         future = clone( );
         future.makeMove(moves.lastElement( ));
         value = future.evalWithLookahead(lookAhead-1, bestValue);
         if (value > bestValue)
         {
            if (-value <= beatThis)
               return Double.NEGATIVE_INFINITY; // Alpha-beta pruning
            bestValue = value;
         }
         moves.removeElementAt(moves.size( )-1);
      }  while (!moves.isEmpty( ));

      // The value was calculated from the opponent's perspective.
      // The answer we return should be from player's perspective, so multiply times -1:
      return -bestValue;
   }

   private void makeComputerMove(int depth)
   {
      Vector<String> moves;
      double value;
      double bestValue;
      String bestMove = null;
      AbstractGame future;
	
      // Compute all legal moves that the computer could make.
      moves = computeMoves( );
	
      // Evaluate each possible legal move, saving its value in bestValue.
      bestValue = Double.NEGATIVE_INFINITY;
      do
      {
         future = clone( );
         future.makeMove(moves.lastElement( ));
         value = future.evalWithLookahead(depth, bestValue);
         if (value >= bestValue)
         {
            bestValue = value;
            bestMove = moves.lastElement( );
         }
         moves.removeElementAt(moves.size( )-1);
      }  while (!moves.isEmpty( ));
	    
      // Make the best move.
      makeMove(bestMove);
   }

   private void makeHumanMove( )
   {
      String move;

      move = getUserMove( );
      while (!isLegal(move))
      {
         displayMessage("Illegal move.\n");
         move = getUserMove( );
      }
      makeMove(move);
   }

}
