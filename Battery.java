/*
*In this program the battery is able to be charged, drained and also gives the remaining capacity of the battery.
*@author Noorul Wasim Mansoor
*@version 2/5/2022
*/

public class Battery{
   private double totalCharge;
   private double totalCapacity;
   
   public Battery(double capacity){
      totalCapacity = capacity;
      totalCharge = capacity;
   }
   public void drain(double charge){
      totalCapacity = totalCapacity - charge;
   }
   public void charge(){
      totalCapacity = totalCharge;
   }
   public double getRemainingCapacity(){
      return totalCapacity;
   }

public static void main(String[] args){
   Battery battery = new Battery(100.0);

   System.out.println(battery.getRemainingCapacity());
   System.out.println("Expected: 100.0");

   battery.drain(23.4);
   battery.drain(9.7);
   System.out.println(battery.getRemainingCapacity());
   System.out.println("Expected: 66.9");

   battery.charge();
   System.out.println(battery.getRemainingCapacity());
   System.out.println("Expected: 100.0");
   }
}
