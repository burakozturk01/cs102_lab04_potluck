import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Scanner;

/**
 * NxN board game
 */
public class Potluck extends JFrame
{
   // properties
   JPanel but_grid;
   GridLayout grid;
   JTextField t_box;
      
   int n, attempts;
   JButton[] buttons;

   // constructors
   public Potluck(int n) {
      // Setting class' n variable and attempts counter
      this.n = n;
      attempts = 0;
      
      // button holding array
      buttons = new JButton[n*n];
      
      // Creating and labeling button objects
      for (int i = 0; i < n*n; i++)
         buttons[i] = new JButton("Pot " + (i+1));
      
      // Creating textbox
      t_box = new JTextField("Attempts :" + attempts);
      
      // Creating button grid, adding buttons and setting layout
      but_grid = new JPanel();
      
      for (int i = 0; i < n*n; i++)
         but_grid.add(buttons[i]);
      
      grid = new GridLayout(n, n);
      but_grid.setLayout(grid);
      
      // Adding components to this(JFrame)
      this.add(t_box, BorderLayout.NORTH);
      this.add(but_grid, BorderLayout.CENTER);
      
      this.setSize(400,400);
   }
   
   // methods
   public void addListener(int i, ActionListener lis)
   {
      buttons[i].addActionListener(lis);
   } // To add listener to the button with index i
   
   public void prize()
   {
      for (int i = 0; i < n*n; i++)
         buttons[i].setEnabled(false);
      t_box.setText("You got it in " + attempts + " attempts!");
   } // Method to call when prize button is pressed
   
   public void bomb()
   {
      for (int i = 0; i < n*n; i++)
         buttons[i].setEnabled(false);
      t_box.setText("Sorry! You are blown up at attempt " + attempts + "!");
   } // Method to call when one of the bomb buttons are pressed
   
   public void attempt()
   {
      attempts++;
      t_box.setText("Attempts: " + attempts);
   } // Method to call when any button is pressed

}