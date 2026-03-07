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

public class BreakAPlate implements ActionListener {
	
	private ImageIcon plate, broken1, broken2, broken3, tiger, sticker ;
	private JButton plate1, plate2, plate3, button; 
	private JLabel status, prize, p1Stat, p2Stat, p3Stat;
	private JFrame frmBreakaplate;
	private String gameStat = "off";
	private Boolean win;
	private int shoot, shape, counter;
	List<ImageIcon> plates = new ArrayList<>();
	Timer timer = new Timer();
	
	public void hit(JButton a, JLabel b){
		
		if (gameStat.equals("on")) {
		
		counter++;
		
		shoot = (int)(2*Math.random() + 1);
			
			if (shoot == 1) {
				
				shape = (int)(3*Math.random());
				a.setIcon(plates.get(shape));
				
				b.setForeground(new Color(44, 150, 104));
				b.setText(" HIT!");
				
				timer.schedule(new TimerTask() {
				    public void run() {
				        b.setText(" ");
				    }
				}, 500);	
			}else {
				
				b.setForeground(Color.red);
				b.setText("MISS!");
				
				timer.schedule(new TimerTask() {
				    public void run() {
				        b.setText(" ");
				    }
				}, 500);
				
				win = false;
			}}
			
			if(counter == 3) {
			
				if(win == true) {
					
					button.setForeground(new Color(44, 150, 104));
					button.setText("YOU WIN!");
					status.setText("             prize: tiger");
					timer.schedule(new TimerTask() {
					    public void run() {
					    	button.setForeground(Color.black);
					    	button.setText("Reset");
					    	
					    }
					}, 1200);
					
					prize.setIcon(tiger);
				
				} else {
					
					button.setText("YOU LOOSE!");
					status.setText("           prize: sticker");
					timer.schedule(new TimerTask() {
					    public void run() {
					    	button.setForeground(Color.black);
					        button.setText("Reset");
					        
					    }
					}, 1200);
					
					prize.setIcon(sticker);}
			
			}
			
			button.setActionCommand("stop");
			a.setActionCommand("end");	
			
		
    }
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BreakAPlate window = new BreakAPlate();
					window.frmBreakaplate.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BreakAPlate() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		plate = new ImageIcon("../Chapter10/src/Mastery/plate.jpg");
		broken1 = new ImageIcon("../Chapter10/src/Mastery/broken1.jpg");
		broken2 = new ImageIcon("../Chapter10/src/Mastery/broken2.jpg");
		broken3 = new ImageIcon("../Chapter10/src/Mastery/broken3.jpg");
		tiger = new ImageIcon("../Chapter10/src/Mastery/tiger.gif");
		sticker = new ImageIcon("../Chapter10/src/Mastery/sticker.gif");
		
		frmBreakaplate = new JFrame();
		frmBreakaplate.setTitle("BreakAPlate");
		frmBreakaplate.setBounds(100, 100, 400, 379);
		frmBreakaplate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(232, 247, 255));
		frmBreakaplate.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(152, 185, 214), null, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(35, 31, 327, 118);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
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
		p3Stat.setBounds(245, 96, 61, 16);
		panel_1.add(p3Stat);
		plate1.addActionListener(this);
		plate3.addActionListener(this);
		plate2.addActionListener(this);
		
		status = new JLabel("      Press: [Play] to start!");
		status.setFont(new Font("Wawati SC", Font.PLAIN, 13));
		status.setBounds(116, 195, 207, 16);
		panel.add(status);
		
		prize = new JLabel("");
		prize.setForeground(Color.WHITE);
		prize.setBounds(147, 223, 108, 99);
		panel.add(prize);
		
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
	
	public void actionPerformed(ActionEvent e) {
		
		String eventName = e.getActionCommand();
		
		if(eventName.equals("play")) {
			
			plate1.setIcon(plate);
			plate1.setActionCommand("shoot1");
			
			plate2.setIcon(plate);
			plate2.setActionCommand("shoot2");
			
			plate3.setIcon(plate);
			plate3.setActionCommand("shoot3");
			
			button.setText("Stop");
			button.setForeground(Color.red);
			
			button.setActionCommand("stop");
			gameStat = "on";
			
			counter = 0;
			win = true;
			
			status.setText("  Click the plates to shoot!");
			
		}
		
		
		if(eventName.equals("stop")) {
			
			button.setForeground(new Color(44, 150, 104));
			button.setActionCommand("play");
			button.setText("Play");
			
			plate1.setIcon(plate);
			plate2.setIcon(plate);
			plate3.setIcon(plate);
			
			prize.setIcon(null);
			
			counter = 0;
			win = true;
			status.setText("       Press: [Play] to start!");
			
		}
		
			if(eventName.equals("shoot1")) {
				
				hit(plate1, p1Stat);
				
				
			} else if (eventName.equals("shoot2")){
				
				hit(plate2, p2Stat);
				
			} else if (eventName.equals("shoot3")){
				
				hit(plate3, p3Stat);
				
			}
			
	
	}	
}
