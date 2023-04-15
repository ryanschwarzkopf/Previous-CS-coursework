// CS 172 
// Car.java 
// PA 7
// Written by: Ryan Schwarzkopf 
// 06/20/2022 
// Practice making classes

public class Car {
   
   private String make;
   private String model;
   private int year;
   
   public Car(String make, String model, int year) {
      this.make = make;
      this.model = model;
      this.year = year;
   } // end constructor
   
   public String getMake() {
      return make;
   } // end getMake
   
   public String getModel() {
      return model;
   } // end getModel
   
   public int getYear() {
      return year;
   } // end getYear
   
   public void setMake(String make) {
      this.make = make;
   } // end setMake
   
   public void setModel(String model) {
      this.model = model;
   } // end setModel

   public void setYear(int year) {
      this.year = year;
   } // end setYear
   
   public String toString() {
      String phrase = String.valueOf(year) + " " + make + " " + model;
      return phrase;
   } // end toString

} // end class