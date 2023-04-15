// File: Combine.java
// This applet is a small example to illustrate how to write an interactive 
// Applet. The applet combines two strings to produce two new strings.
// -- Michael Main (main@colorado.edu)

import java.applet.Applet;
import java.awt.*;          // Imports Button, Canvas, TextArea, TextField
import java.awt.event.*;    // Imports ActionEvent, ActionListener
import java.security.*;     // Imports MessageDigest


public class Combine extends Applet
{  
   // These are the interactive Components that will appear in the Applet.
   private Button    sizeButton    = new Button("GO!");
   private TextField input1        = new TextField(20);
   private TextField input2        = new TextField(20);
   private TextArea  feedback      = new TextArea(4, 60);

   public void init( )
   {      
      // Some messages for the top of the Applet:   
      add(new Label("Please type your two favorite strings in the boxes and press GO!"));
      add(new Label("I will then show you my two favorite strings."));
      addHorizontalLine(Color.blue);
       
      // The Input:
      add(input1);
      add(input2);
      add(sizeButton);
      addNewLine( );
      
      // A TextArea at the bottom to write messages:
      addHorizontalLine(Color.blue);
      addNewLine( );
      feedback.setEditable(false);
      feedback.append("I am ready for your strings.\n");
      add(feedback);
      
      // Tell the Buttons what they should do when they are clicked:
      sizeButton.addActionListener(new GoListener( ));
   }


   class GoListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
          String in1 = input1.getText( );
          String in2 = input2.getText( );
          String joint = interleave(in1, in2, 20);
          String encrypted;
	  StringBuffer out1 = new StringBuffer( );
	  StringBuffer out2 = new StringBuffer( );
          int i;

          try {
             MessageDigest md1 = MessageDigest.getInstance("MD5");
             md1.update(joint.getBytes());
             encrypted = new String(md1.digest());
                          
          }
          catch (java.security.NoSuchAlgorithmException e)
	  {
              encrypted = "0000000000000000";
          }

          for (i = 0; i < 8; ++i)
	  {
              out1.append(readable(encrypted.charAt(2*i)));
              out2.append(readable(encrypted.charAt(2*i+1)));
          }
          // feedback.append(joint + "\n");
          // feedback.append(encrypted + "\n" + encrypted.length());
	  // feedback.append("Those are nice, but I prefer these:\n");
          feedback.append("main" + out1.toString( ) + "\n");
          feedback.append("feliz" + out2.toString( ) + "\n");
      }

      private String interleave(String s1, String s2, int length)
      {
          StringBuffer joint = new StringBuffer( );
          int i1 = 0, i2 = 0, j;

          if (s1.length() == 0) s1 = "-";
          if (s2.length() == 0) s1 = "-";
          for (j = 0; j < length; j++)
	  {
	     if (j % 2 == 0)
	     {
	        joint.append(s1.charAt(i1 % s1.length( )));
                i1++;
             }
             else
	     {
                joint.append(s2.charAt(i2 % s2.length( )));
                i2++;
             }
         }
         return joint.toString( );
      }

      private char readable(char c)
      {
	 int value = ((int)c) % 62;
         char answer;

         if (value < 26)
             answer = (char)((int)('a') + value);
         else if (value < 52)
             answer = (char)((int)('A') + value - 26);
         else     
             answer = (char)((int)('0') + value - 52);

         switch (answer)
	 {
	 case '0': return '8';
	 case '1': return '9';
	 case 'O': return 'P';
	 case 'l': return 'q';
	 case 'I': return 'X';
	 default: return answer;
         }
      }
   }
   
    
   private void addHorizontalLine(Color c)
   {  
      // Add a Canvas 10000 pixels wide but only 1 pixel high, which acts as
      // a horizontal line to separate one group of components from the next.
      Canvas line = new Canvas( );
      line.setSize(10000,1);
      line.setBackground(c);
      add(line);
   }

   
   private void addNewLine( ) 
   {  
      // Add a horizontal line in the background color. The line itself is
      // invisible, but it serves to force the next Component onto a new line.
      addHorizontalLine(getBackground( ));
   }

      
}

