import edu.colorado.games.Connect4;

public class PlayConnect4
{
   public static void main(String args)
   {
      final int DEPTH = 4;       
      Connect4 instance = new Connect4( );
      int winner;

      winner = instance.play(DEPTH);
      switch (winner)
      {
      case Connect4.HUMAN: 
         System.out.println("You win"); break;
      case Connect4.COMPUTER: 
         System.out.println("I win"); break;
      case Connect4.NEUTRAL:
         System.out.println("A draw"); break;
      }
   }
}     
