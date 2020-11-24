import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

public class Game
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);

      // constants

      // variables
      Potluck p;
      int n;
      int prize, b1, b2;
      
      ActionListener l1, l2, l3;

      // program code
      System.out.println( "Start...");
      
      // Scanning number n
      n = scan.nextInt();
      
      // Creating Potluck object
      p = new Potluck(n);
      
      // Setting prize button's index
      prize = rand(0, n*n - 1);
      b1 = prize; b2 = prize;
      
      // Setting first bomb button's index
      while (b1 == prize)
      {
         b1 = rand(0, n*n - 1);
      }
      
      // Setting second bomb button's index
      while (b2 == prize || b2 == b1)
      {
         b2 = rand(0, n*n - 1);
      }
      
      // Adding listeners to special buttons
      p.addListener(prize, new ActionListener() { 
         public void actionPerformed(ActionEvent e)
         { 
            p.prize();
         } 
      }
      );
      
      p.addListener(b1, new ActionListener() { 
         public void actionPerformed(ActionEvent e)
         { 
            p.bomb();
         } 
      }
      );
      
      p.addListener(b2, new ActionListener() { 
         public void actionPerformed(ActionEvent e)
         { 
            p.bomb();
         } 
      }
      );
      
      // Adding listeners to the rest of the buttons
      for (int i = 0; i < n*n; i++)
      {
         if (i != prize || i != b1 || i != b2)
         {
            p.addListener(i, new ActionListener() { 
               public void actionPerformed(ActionEvent e)
               { 
                  p.attempt();
               } 
            }
            );
         }
      }
      
      p.setVisible(true);
      
      System.out.println( "End.");
   }
   
   // Random integer method
   public static int rand(int min, int max)
   { return (int) ((Math.random() * (max - min)) + min); }

}