/*
This program reads a list of 1,000 names and telephone numbers from an imported text file that contains the numbers in random order.
Then using the data it searches for contacts by either the name or the phone number.
* @Author Wasim Mansoor
* @Version 3/21/2022
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.Collections;
import java.io.IOException;


class ContactSearchProgram
{
   public static void main(String[] args) throws IOException
   {
      Scanner scan = new Scanner(System.in);
      System.out.println("Name of the phonebook file: ");
      String phoneBook = scan.nextLine();

      TableSearch table = new TableSearch();
      FileReader reader = new FileReader(phoneBook);
      table.scaning(new Scanner(reader));
    
      boolean options = true;//boolean operator
      while (options)//passes in the boolean operator
      {
         System.out.println("Select one of the options to Search:\nN)ame\nP)hone number\nE)nd");
         String finder = scan.nextLine();
         
         if (finder.equalsIgnoreCase("E")){
            options = false;
         }else if (finder.equalsIgnoreCase("N")){
            System.out.println("Enter name:");
            String var = scan.nextLine();
            System.out.println("Phone number: " + table.search(var));
         }else if (finder.equalsIgnoreCase("P")){
            System.out.println("Enter phone number:");
            String var = scan.nextLine();
            System.out.println("Name: " + table.reverseSearch(var));
         }
      }
   }
}


class TableSearch{//arraylist class where it creates a table for searching and reverse searching
   private ArrayList<Item> individual;

   public TableSearch(){//the object for table search is created
       individual = new ArrayList<Item>();//definining each person in the array list
   }

   public void scaning(Scanner scan){//reading in the value "scan"
      while(scan.hasNext()){
          String personName = scan.nextLine();
          String phNumber = scan.nextLine();
          individual.add(new Item(personName, phNumber));
      }
   }
   
   class Item{//searches an element in the arraylist and returns the value or "null" when there is nothing found
   
      private String name, number;
     
      public Item(String aName, String aNum){//aName and aNum is derived from just name and number
          name = aName;
          number = aNum;
      }
     
      public String getName(){//returns name from the Item class
          return name;
      }
     
      public String getNum(){//returns number from the Item class
          return number;
      }
   }
   
   public String search(String var){
      String status = null;//boolean operator
      for(Item item: individual){//for each loop
          if(var.equals(item.getName())){
              status = item.getNum();
          }
      }
      return status;//returns the boolean operator
   }

   public String reverseSearch(String var){//searches an element in the arraylist and returns the value or "null" when there is nothing found
       String status = null;//boolean operator
          for(Item item: individual){//for each loop
              if(var.equals(item.getNum())){
                  status = item.getName();
              }
          }
          return status;//returns the boolean operator
   }
}