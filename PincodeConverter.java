/*
* This program produces every possible combination of words from a pincode entered.
* @Author Wasim Mansoor
* @Version 3/7/2022
*/

import java.util.Scanner;

public class PincodeConverter {

   public static void main(String[] args) {//where the actual recursion is done
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter the pincode: ");
      String pincode = scan.nextLine();
      System.out.println();
      System.out.println("The word combinations for " + pincode + " are: ");
      getItemizingWords(pincode);
   }

   public static char[] getButtonKeys(int letters) {//method for all possible letters on keypad
      switch (letters) {
         case 0:
            return new char[] {' '};//space
         case 1:
            return new char[] {'.'};//dot
         case 2:
            return new char[] { 'A', 'B', 'C' };//letters A-C
         case 3:
            return new char[] { 'D', 'E', 'F' };//letters D-F
         case 4:
            return new char[] { 'G', 'H', 'I' };//letters G-I
         case 5:
            return new char[] { 'J', 'K', 'L' };//letters J-L
         case 6:
            return new char[] { 'M', 'N', 'O' };//letters M-O
         case 7:
            return new char[] { 'P', 'Q', 'R', 'S' };//letters P-S
         case 8:
            return new char[] { 'T', 'U', 'V' };//letters T-V
         case 9:
            return new char[] { 'W', 'X', 'Y', 'Z' };//letters W-Z
      }
      return null;
   }

   public static void getItemizingWords(String pincode) {//method call to the recursive method in the main methos
  
      if (pincode != null){
         itemizingWords(pincode, "");
      }
   }

   public static void itemizingWords(String pincode, String word) {
      if (pincode.length() == 0) {//base case
         System.out.println(word);
      }else{//num at index 0
         int num = pincode.charAt(0) - '0';
         char letters[] = getButtonKeys(num);
      if (letters != null) {
         for (int i = 0; i < letters.length; i++) {//traversing through and putting together all combinations
            itemizingWords(pincode.substring(1), word + letters[i]);
            }
         }
      }
   }

}