/*
*Button component is created in another screen and the number of times that is clicked is shown in JGrasp Output screen
*@author Noorul Wasim Mansoor
*@version 4/18/2022
*/


import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonProgram{//class is declared

   public static void main(String[] args){// main method is declared

      JFrame frame = new ButtonFrame1();// ButtonFrame1 is created
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Close operation set
      frame.setVisible(true);//frame is visible through boolean operation
   }
}

class ButtonFrame1 extends JFrame{//no public
private int button1Clicks;//private variables
private int button2Clicks;//private variables

private static final int BUTTONFRAME_WIDTH = 100;//Width is instantiated
private static final int BUTTONFRAME_HEIGHT = 60;//Height is instantiated

   private void buttonCreations(){//button is created
      JButton button1 = new JButton("Button1");
      JButton button2 = new JButton("Button2");

   JPanel panel = new JPanel();

   panel.add(button1);
   panel.add(button2);

   add(panel);
   
   ActionListener listener = new ClickListener();
      button1.addActionListener(listener);

   ActionListener listener01 = new ClickListener01();
      button2.addActionListener(listener01);
   }

   public ButtonFrame1(){
      button1Clicks = 0;//starting value
      button2Clicks = 0;//starting value
      buttonCreations();
      setSize(BUTTONFRAME_WIDTH, BUTTONFRAME_HEIGHT);//size is set
   }

   class ClickListener implements ActionListener{//@override
      public void actionPerformed(ActionEvent event){//ActionEvent is passed in
         button1Clicks++;//counter for the first button
         String output = String.format("Button1 was clicked %d times", button1Clicks);//statement on how many times clicked
         System.out.println(output);//output is passed in, eventhough it is a println
      }
   }

   class ClickListener01 implements ActionListener{
      public void actionPerformed(ActionEvent event){//ActionEvent is passed in
         button2Clicks++;//counter for the second button
         String output = String.format("Button2 was clicked %d times", button2Clicks);//statement on how many times clicked
         System.out.println(output);//output is passed in, eventhough it is a println
      }
   }
}