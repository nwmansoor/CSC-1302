/*
*This program will print out the time of the location you are at
*@author Wasim Mansoor
*@Version 2/21/2022
*/
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
/**
   Part I: Implement a class Clock whose getHours, getMinutes and
   getTime methods return the current time at your location.
   Return the time as a string.

   There are two ways to retrieve the current time as a String:

   1) Before Java 8 use new Date().toString()
   2) With Java 8, you can use 3 classes in the java.time package:
      Instant, LocalDateTime and ZoneId. Here's how you do it:
      String timeString = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).toString()

   With either method, you'll need to extract the hours and
   minutes as a substring.
*/
class Clock{
//your code 

   public String currentTime(){
   //this method gets the time at the location   
      String clocktimeString = LocalDateTime.ofInstant(Instant.now(),ZoneId.systemDefault()).toString();
      return clocktimeString;
   }
   
   public String getTime(){
   //this method gets the total time of the clock from the getMinutes() and the getHours()
      return getHours() + ":" + getMinutes();

   }
   
   public String getMinutes(){
   //this method gets the minutes component of the time from CurrentTime()
      String currentMinutes = currentTime().substring(14, 16);
      return currentMinutes;
   }
   
   public String getHours(){
   //this method gets the hours component of the time from currentTime()
      String currentHours = currentTime().substring(11, 13);
      return currentHours;
   }
}

class WorldClock extends Clock{
//subclass of worldClock
   private int offset;
   public WorldClock(int offset){
      this.offset = offset;
   }
   
   public String getHours(){
      String hours = currentTime().substring(11, 13);
      int offsetTime = Integer.parseInt(hours) + offset; //converting to int
      if(offsetTime > 23){
         offsetTime = 23 - offsetTime;
      }
      if(offsetTime < 0){
         offsetTime = 23 + offsetTime;
      }
      String convertedString = Integer.toString(offsetTime);
      return convertedString;
   }
}

//Tester for the WorldClock and Clock class
class ClockDemo{
   public static void main(String[] args){
   //Testing clock
      System.out.println("Testing The Clock Class");
      Clock clock = new Clock();
      System.out.println("Hours: " + clock.getHours());
      System.out.println("Minutes: " + clock.getMinutes());
      System.out.println("Time: " + clock.getTime());
      
   //Testing WorldClock
   System.out.println("");
   System.out.println("Testing WorldClock class");
   int offset = 3;
   System.out.println("Offset: " + offset);
   WorldClock currentWclock = new WorldClock(offset);
   System.out.println("Hours: " + currentWclock.getHours());
   System.out.println("Minutes: " + currentWclock.getMinutes());
   System.out.println("Time: " + currentWclock.getTime());
   }
}