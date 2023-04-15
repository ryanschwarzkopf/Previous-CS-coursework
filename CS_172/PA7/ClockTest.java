// CS 172 
// ClockTest.java 
// PA 7
// Written by: Ryan Schwarzkopf 
// 06/20/2022 
// Practice making classes

public class ClockTest {

   public static void main(String[] args) {
   
      // test constructor
      Clock a = new Clock();
      System.out.println(a.toString());
      
      // test getters
      System.out.println(a.getHour());
      System.out.println(a.getMinute());
      System.out.println(a.getSecond());
      
      // test setters
      a.setHour(12);
      a.setMinute(59);
      a.setSecond(59);  
      System.out.println(a.toString());
      
      // test tick method
      a.tick();
      System.out.println(a.toString());
      
      // test equals method
      if(a.equals(1, 0, 0))
         System.out.println("Equal");
      if(a.equals(12, 59, 59))
         System.out.println("Not equal");
         
   } // end main
} // end class