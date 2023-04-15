// File: Fractal.java
// This applet is a small example to illustrate the randomFractal method. 
// -- Michael Main (main@colorado.edu)

import java.applet.Applet;
import java.awt.*;          // Provides Graphics, Image

public class Fractal extends Applet
{  
   private Image display;
   private Graphics drawingArea;
   
   public void init( )
   {  
      int height = getSize( ).height;
      int width = getSize( ).width;
      display = createImage(width, height);
      drawingArea = display.getGraphics( );
      
      randomFractal(0, height/2, width, height/2, drawingArea);
   }
      
   public void paint(Graphics g)
   {
      g.drawImage(display, 0, 0, null);
   }
      
   public static void randomFractal(
      int leftX,
      int leftY,
      int rightX,
      int rightY,
      Graphics drawingArea
   )
   {
      final int STOP = 4;  // When length < EPSILON, draw a line segment
      int midX, midY;      // Midpoints in the x and y dimensions
      int delta;           // Amount to shift the line's midpoint up or down
      
      if ((rightX - leftX) <= STOP)
         drawingArea.drawLine(leftX, leftY, rightX, rightY);
      else
      {
         midX = (leftX + rightX) / 2;
         midY = (leftY + rightY) / 2;
         delta = (int)((Math.random( ) - 0.5) * (rightX - leftX));
         midY += delta;
         randomFractal(leftX, leftY, midX,   midY,   drawingArea);
         randomFractal(midX,  midY,  rightX, rightY, drawingArea);
      }
   }

}


