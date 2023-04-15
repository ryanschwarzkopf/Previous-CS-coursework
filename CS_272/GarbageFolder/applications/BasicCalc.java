// FILE: BasicCalc.java
// This program reads a reads and evaluates a fully parenthesized arithmetic expression.
// The purpose is to illustrate a fundamental use of stacks.

import edu.colorado.collections.CharStack;
import edu.colorado.collections.DoubleStack;
import edu.colorado.io.EasyReader;  // From Appendix B

public class BasicCalc
{                                                                                  
   public static void main(String[ ] args)
   {   
      EasyReader stdin = new EasyReader(System.in);
      double answer;
      
      System.out.println("Type a fully parenthesized arithmetic expression:");
      answer = readAndEvaluate(stdin);
      System.out.println("That evaluates to " + answer);
   }
   
   
   public static double readAndEvaluate(EasyReader input)   
   // Precondition: The next line of characters in the EasyReader is a fully
   // parenthesized arithmetic expression formed from non-negative numbers,
   // parentheses, and the four operations +, -, *, and /.
   // Postcondition: A line has been read from the EasyReader, including the
   // newline character. This line has been evaluated and the value returned.
   // Exceptions: Can throw an IllegalArgumentException if the input line is an
   // illegal expression, such as unbalanced parentheses or a division by zero.
   // However, some illegal expressions are not caught by this implementation. 
   {
      final char DECIMAL           = '.';
      final char RIGHT_PARENTHESIS = ')';
      final String SYMBOLS         = "+-*/";
      
      DoubleStack numbers = new DoubleStack( );
      CharStack operations = new CharStack( );
    
      while (!input.isEOLN( ))
      {
         if (Character.isDigit(input.peek( )) || (input.peek( ) == DECIMAL))
         {  // Read a number and push it on the numbers stack.
            numbers.push(input.doubleInput( ));
         }
         else if (SYMBOLS.indexOf(input.peek( )) >= 0)
         {  // Read the + - * or / symbol and push it on the operations stack.
            operations.push(input.charInput( ));
         }
         else if (input.peek( ) == RIGHT_PARENTHESIS)
         {  // Evaluate the stuff on top of the stacks.
            input.ignore( );
            evaluateStackTops(numbers, operations);
         }
         else
         {  // Just read and ignore all other characters.
            input.ignore( );
         }
      } 
      input.skipLine( ); // Read and ignore the newline character.

      if (numbers.size( ) != 1)
         throw new IllegalArgumentException("Illegal input expression");    
      return numbers.pop( );
   }
   
   
   public static void evaluateStackTops(DoubleStack numbers, CharStack operations)     
   // Precondition: The top of the operations stack contains +, -, *, or /, and
   // the numbers stack contains at least two numbers. 
   // Postcondition: The top two numbers have been popped from the numbers stack, and the
   // top operation has been popped from the operations stack. The two numbers have been
   // combined using the operation (with the second number popped as the left operand). 
   // The result of the operation has then been pushed back onto the numbers stack.
   // Exceptions: Throws an IllegalArgumentException if the stacks are illegal or if the 
   // operation results in a division by zero.
   {
      double operand1, operand2;
      
      // Check that the stacks have enough items, and get the two operands.
      if ((numbers.size( ) < 2) || (operations.isEmpty( )))
         throw new IllegalArgumentException("Illegal expression");        
      operand2 = numbers.pop( );
      operand1 = numbers.pop( );
      
      // Carry out an action based on the operation on the top of the stack.
      switch (operations.pop( ))
      {
         case '+': numbers.push(operand1 + operand2);
                   break;
         case '-': numbers.push(operand1 - operand2);
                   break;
         case '*': numbers.push(operand1 * operand2);
                   break;
         case '/': if (operand2 == 0)
                      throw new IllegalArgumentException("Division by zero");
                   numbers.push(operand1 / operand2);
                   break;
         default:  throw new IllegalArgumentException("Illegal operation");
      }
   }
}
