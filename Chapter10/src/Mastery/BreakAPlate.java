/*

Program: BreakAPlate.java          Last Date of this Revision: March 6th, 2026

Purpose: The Break-A-Plate game allows a player to try to break all plates. 
		 If all three plates are broken, a first prize is awarded, otherwise,
		 a consolation prize is awarded.

Author: Sophia Chen 
School: CHHS
Course: CompSci-30
 

*/

package Mastery;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Font;

public class BreakAPlate implements ActionListener 

{
	
	// Initialize variables and GUI components
	private ImageIcon plate, broken1, broken2, broken3, tiger, sticker ;
	private JButton plate1, plate2, plate3, button; 
	private JLabel status, prize, p1Stat, p2Stat, p3Stat;
	private JFrame frmBreakaplate;
	private String gameStat = "off";
	private Boolean win;
	private int shoot, shape, counter;
	List<ImageIcon> plates = new ArrayList<>();
	Timer timer = new Timer();
	
	//Method to determine hit outcome & output winner if found
	public void hit(JButton a, JLabel b)
	{
		
		//If the game status is equal to on
		if (gameStat.equals("on")) 
		{
		
		//Add 1 throw to the counter
		counter++;
		
		//Generate a random number from 1-2 to determine hit outcome
		shoot = (int)(2*Math.random() + 1);
			
			// If random number is equal to 1
			if (shoot == 1) 
			{
				
				//Generate a random number 1-3 to select broken plate icon
				shape = (int)(3*Math.random());
				
				//Set plate's icon to chosen icon
				a.setIcon(plates.get(shape));
				
				//Change hit status color to green
				b.setForeground(new Color(44, 150, 104));
				
				//Set text to reflect outcome
				b.setText(" HIT!");
				
				//After 0.5 seconds, clear status label
				timer.schedule(new TimerTask() 
				{
				    public void run() 
				    {
				        b.setText(" ");
				    }
				}, 500);	
				
			// If random number is equal to 2
			}
			else 
			{
				
				// Set hit status color to red
				b.setForeground(Color.red);
				
				// Set text to reflect outcome
				b.setText("MISS!");
				
				// After 0.5 seconds, clear status label
				timer.schedule(new TimerTask() 
				{
				    public void run() 
				    {
				        b.setText(" ");
				    }
				}, 500);
				
				// If plate is not successfully hit, change win stat to false
				win = false;
			}
		}
			
			// If all 3 plates are attempted 
			if(counter == 3) 
			{
				
				// If all plates are successfully hit
				if(win == true) 
				{
					
					// Change button text color + change text to reflect win
					button.setForeground(new Color(44, 150, 104));
					button.setText("YOU WIN!");
					
					// Change prize text
					status.setText("             prize: tiger");
					
					// After 1.2 seconds, change button text and color
					timer.schedule(new TimerTask() 
					{
					    public void run() 
					    {
					    	button.setForeground(Color.black);
					    	button.setText("Reset");
					    	
					    }
					}, 1200);
					
					// Change prize icon to reflect outcome
					prize.setIcon(tiger);
				
				// If one or more plates are not successfully hit
				}
				else 
				{
					
					// Change button text color + change text to reflect loss
					button.setText("YOU LOOSE!");
					status.setText("           prize: sticker");
					
					// After 1.2 seconds, change button text and color
					timer.schedule(new TimerTask() 
					{
					    public void run() 
					    {
					    	button.setForeground(Color.black);
					        button.setText("Reset");
					        
					    }
					}, 1200);
					
					// Change prize icon to reflect outcome
					prize.setIcon(sticker);
				}
			
			}
			
			// Change button commands to stop game
			button.setActionCommand("stop");
			a.setActionCommand("end");	
    }
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					BreakAPlate window = new BreakAPlate();
					window.frmBreakaplate.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BreakAPlate() 
	{
		initialize(); // Initialize application
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		
		// Initialize image icons
		plate = new ImageIcon("../Chapter10/src/Mastery/plate.jpg");
		broken1 = new ImageIcon("../Chapter10/src/Mastery/broken1.jpg");
		broken2 = new ImageIcon("../Chapter10/src/Mastery/broken2.jpg");
		broken3 = new ImageIcon("../Chapter10/src/Mastery/broken3.jpg");
		tiger = new ImageIcon("../Chapter10/src/Mastery/tiger.gif");
		sticker = new ImageIcon("../Chapter10/src/Mastery/sticker.gif");
		
		//Main JFrame
		frmBreakaplate = new JFrame();
		frmBreakaplate.setTitle("BreakAPlate");
		frmBreakaplate.setBounds(100, 100, 400, 379);
		frmBreakaplate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JPanels
		JPanel panel = new JPanel();
		panel.setBackground(new Color(232, 247, 255));
		frmBreakaplate.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//JPanels
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(152, 185, 214), null, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(35, 31, 327, 118);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		// Plates to be broken
		plate2 = new JButton(plate);
		plate2.setBounds(119, 17, 80, 80);
		panel_1.add(plate2);
		plate2.setFocusPainted(false);
		plate2.setBorderPainted(false);
		
		plate3 = new JButton(plate);
		plate3.setBounds(226, 17, 80, 80);
		panel_1.add(plate3);
		plate3.setFocusPainted(false);
		plate3.setBorderPainted(false);
		
		plate1 = new JButton(plate);
		plate1.setBounds(17, 17, 80, 80);
		panel_1.add(plate1);
		plate1.setFocusPainted(false);
		plate1.setBorderPainted(false);
		
		// Plate hit status labels
		p1Stat = new JLabel(" ");
		p1Stat.setFont(new Font("Wawati SC", Font.PLAIN, 13));
		p1Stat.setBounds(42, 96, 47, 16);
		panel_1.add(p1Stat);
		
		p2Stat = new JLabel(" ");
		p2Stat.setFont(new Font("Wawati SC", Font.PLAIN, 13));
		p2Stat.setBounds(141, 96, 61, 16);
		panel_1.add(p2Stat);
		
		p3Stat = new JLabel(" ");
		p3Stat.setFont(new Font("Wawati SC", Font.PLAIN, 13));
		p3Stat.setBounds(248, 96, 61, 16);
		panel_1.add(p3Stat);
		
		plate1.addActionListener(this);
		plate3.addActionListener(this);
		plate2.addActionListener(this);
		
		// Game instruction label
		status = new JLabel("      Press: [Play] to start!");
		status.setFont(new Font("Wawati SC", Font.PLAIN, 13));
		status.setBounds(116, 195, 207, 16);
		panel.add(status);
		
		// Prize status label
		prize = new JLabel("");
		prize.setForeground(Color.WHITE);
		prize.setBounds(147, 223, 108, 99);
		panel.add(prize);
		
		// Play button
		button = new JButton("Play");
		button.setFont(new Font("Wawati SC", Font.BOLD, 14));
		button.setForeground(new Color(44, 150, 104));
		button.setBounds(138, 161, 117, 29);
		button.setActionCommand("play");
		button.addActionListener(this);
		panel.add(button);
		
		plates.add(broken1);
		plates.add(broken2);
		plates.add(broken3);
		
							
	}
	
	//When a button is pressed
	public void actionPerformed(ActionEvent e) 
	{
		
		//Set button's action command to variable "eventName"
		String eventName = e.getActionCommand();
		
		// If button's event name is equal to "play"
		if(eventName.equals("play")) 
		{
			
			// Set all plates an action commands to unbroken plates
			plate1.setIcon(plate);
			plate1.setActionCommand("shoot1");
			
			plate2.setIcon(plate);
			plate2.setActionCommand("shoot2");
			
			plate3.setIcon(plate);
			plate3.setActionCommand("shoot3");
			
			// Change button text + action command to stop
			button.setText("Stop");
			button.setForeground(Color.red);
			
			button.setActionCommand("stop");
			
			// Turn game on
			gameStat = "on";
			
			// Set counter to 0
			counter = 0;
			
			// Set winner to true
			win = true;
			
			// Change status text
			status.setText("  Click the plates to shoot!");
			
		}
		
		
		// If button's event name is equal to "stop"
		if(eventName.equals("stop")) 
		{
			
			// Reset button visuals
			button.setForeground(new Color(44, 150, 104));
			button.setActionCommand("play");
			button.setText("Play");
			
			// Reset plate icons
			plate1.setIcon(plate);
			plate2.setIcon(plate);
			plate3.setIcon(plate);
			
			prize.setIcon(null);
			
			// Reset game counters / win stat
			counter = 0;
			win = true;
			status.setText("       Press: [Play] to start!");
			
		}
		
			// If first plate is clicked
			if(eventName.equals("shoot1")) 
				
			{
				
				// Perform method "hit" with the corresponding plate 
				hit(plate1, p1Stat);
				
			} 
			
			else if (eventName.equals("shoot2"))
				
			{
				
				hit(plate2, p2Stat);
				
			} 
			
			else if (eventName.equals("shoot3"))
				
			{
				
				hit(plate3, p3Stat);
				
			}
			
	
	}	
}
