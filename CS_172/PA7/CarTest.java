// CS 172 
// CarTest.java 
// PA 7
// Written by: Ryan Schwarzkopf 
// 06/20/2022 
// Practice making classes


public class CarTest {
   
   public static void main(String[] args) {
   
      // test constructor
      Car Tesla = new Car("Tesla", "Model S", 2020);
      Car Ford = new Car("Ford", "Falcon", 1969);
      Car Mitsubishi = new Car("Mistubishi", "3000gt", 1995);
      
      // test toString
      System.out.println(Tesla.toString());      
      System.out.println(Ford.toString());      
      System.out.println(Mitsubishi.toString());
      
      // test getters
      System.out.println(Tesla.getMake() + " " + Tesla.getModel() + " " + Tesla.getYear());
      System.out.println(Ford.getMake() + " " + Ford.getModel() + " " + Ford.getYear());
      System.out.println(Mitsubishi.getMake() + " " + Mitsubishi.getModel() + " " + Mitsubishi.getYear());
      
      // test setters
      Tesla.setMake("a");
      Tesla.setModel("b");
      Tesla.setYear(1);
      
      Ford.setMake("c");
      Ford.setModel("d");
      Ford.setYear(2);
      
      Mitsubishi.setMake("e");
      Mitsubishi.setModel("f");
      Mitsubishi.setYear(3);
      
      System.out.println("\n" + Tesla.toString());
      System.out.println(Ford.toString());
      System.out.println(Mitsubishi.toString());
     
   } // end main

} // end class