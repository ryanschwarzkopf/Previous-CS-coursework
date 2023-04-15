// CS 172 
// Clock.java 
// PA 7
// Written by: Ryan Schwarzkopf 
// 06/20/2022 
// Practice making classes

public class Clock {

   private int hour;
   private int minute;
   private int second;
   
   public Clock() {
      setHour(1);
      setMinute(0);
      setSecond(0);
   } // end constructor
  
   public int getHour() {
      return hour;
   } // end getHour
   
   public int getMinute() {
      return minute;
   } // end getMinute
   
   public int getSecond() {
      return second;
   } // end getSecond
   
   public void setHour(int hour) {
      if(hour > 12 || hour < 1)
         System.out.print("Invalid");
      else
         this.hour = hour;
   } // end setHour
   
   public void setMinute(int minute) {
      if(minute > 59 || minute < 0)
         System.out.print("Invalid");
      else
         this.minute = minute;
   } // end setMinute
   
   public void setSecond(int second) {
      if(second > 59 || second < 0)
         System.out.print("Invalid");
      else
         this.second = second;
   } // end setSecond
   
   public String toString() {
      String hour = String.valueOf(this.hour);
      String minute = String.valueOf(this.minute);
      String second = String.valueOf(this.second);
      
      if(this.hour < 10)
         hour = "0" + hour;
      if(this.minute < 10)
         minute = "0" + minute;
      if(this.second < 10)
         second = "0" + second;

      return hour + " : " + minute + " : " + second;
   } // end toString
   
   public void tick() {
      second++;
      if(second > 59) {
         ++minute;
         second = 0;
         if(minute > 59) {
            ++hour;
            minute = 0;
            if (hour > 12) {
               hour = 1;
            } // end if
         } // end if
      } // end if
   } // end tick
   
   public boolean equals(int hour, int minute, int second) {
      if(this.hour == hour && this.minute == minute && this.second == second)
         return true;
      else
         return false;
   } // end equals
   
} // end class