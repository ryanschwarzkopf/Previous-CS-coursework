// File: BagApplet.java
// This applet is a small example to illustrate how to write an interactive 
// Applet to test the methods of another class. This first version tests
// three of the IntArrayBag methods.
// -- Michael Main (main@colorado.edu)

import edu.colorado.collections.IntArrayBag;
import java.applet.Applet;
import java.awt.*;          // Imports Button, Canvas, TextArea, TextField
import java.awt.event.*;    // Imports ActionEvent, ActionListener


public class BagApplet extends Applet
{  
   // An IntArrayBag for this Applet to manipulate:
   private IntArrayBag b = new IntArrayBag( );


   // These are the interactive Components that will appear in the Applet.
   // We declare one Button for each IntArrayBag method that we want to be able to
   // test. If the method has an argument, then there is also a TextField
   // where the user can enter the value of the argument.
   // At the bottom, there is a TextArea to write messages.
   private Button    sizeButton             = new Button("size( )");
   private Button    addButton              = new Button("add( )");
   private TextField elementText            = new TextField(10);
   private Button    countOccurrencesButton = new Button("countOccurrences( )");
   private TextField targetText             = new TextField(10);
   private TextArea  feedback               = new TextArea(7, 60);
   

   public void init( )
   {      
      // Some messages for the top of the Applet:   
      add(new Label("This test program has created a bag."));
      add(new Label("Press buttons to activate the bag's methods."));
      addHorizontalLine(Color.blue);
       
      // The Button for testing the size method:
      add(sizeButton);
      addNewLine( );
      
      // The Button and TextField for testing the add method:
      add(addButton);
      add(elementText);
      addNewLine( );
      
      // The Button and TextField for testing the countOccurrences method:
      add(countOccurrencesButton);
      add(targetText);
      addNewLine( );

      // A TextArea at the bottom to write messages:
      addHorizontalLine(Color.blue);
      addNewLine( );
      feedback.setEditable(false);
      feedback.append("I am ready for your first action.\n");
      add(feedback);
      
      // Tell the Buttons what they should do when they are clicked:
      sizeButton.addActionListener(new SizeListener( ));
      addButton.addActionListener(new AddListener( ));
      countOccurrencesButton.addActionListener(new CountOccurrencesListener( ));
   }


   class SizeListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
	   feedback.append("The bag has size " + b.size( ) + ".\n");
      }
   }
   
    
   class AddListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         try
         {
            String userInput = elementText.getText( );
            int element = Integer.parseInt(userInput);
            b.add(element);
            feedback.append(element + " has been added to the bag.\n");
         }
         catch (NumberFormatException e)
         {
            feedback.append("Type an integer before clicking button.\n");
            elementText.requestFocus( );
            elementText.selectAll( );
         }
      }                   
   }

   
   class CountOccurrencesListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         try
         {
            String userInput = targetText.getText( );
            int target = Integer.parseInt(userInput);
            feedback.append(target + " occurs ");
            feedback.append(b.countOccurrences(target) + " times.\n");
         }
         catch (NumberFormatException e)
         {
            feedback.append("Type a target before clicking button.\n");
            targetText.requestFocus( );
            targetText.selectAll( );
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

