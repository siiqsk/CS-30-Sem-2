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

public class BreakAPlate implements ActionListener {
	
	private ImageIcon plate, broken1, broken2, broken3, tiger, sticker ;
	private JButton plate1, plate2, plate3, button; 
	private JLabel status, prize, p1Stat, p2Stat, p3Stat, timerTask;
	private JFrame frmBreakaplate;
	private String gameStat = "off";
	private Boolean win;
	private int shoot, shape;
	List<ImageIcon> plates = new ArrayList<>();
	Timer timer = new Timer();
	
	
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
		tiger = new ImageIcon("../Chapter10/src/Mastery/tiger.jpg");
		sticker = new ImageIcon("../Chapter10/src/Mastery/sticker.jpg");
		
		frmBreakaplate = new JFrame();
		frmBreakaplate.setTitle("BreakAPlate");
		frmBreakaplate.setBounds(100, 100, 400, 299);
		frmBreakaplate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(254, 255, 255));
		frmBreakaplate.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		plate1 = new JButton(plate);
		plate1.setBounds(37, 34, 80, 80);
		plate1.setFocusPainted(false);
		plate1.setBorderPainted(false);
		plate1.addActionListener(this);
		
		panel.add(plate1);
		
		plate2 = new JButton(plate);
		plate2.setBounds(158, 34, 80, 80);
		plate2.setFocusPainted(false);
		plate2.setBorderPainted(false);
		plate2.addActionListener(this);
		
		panel.add(plate2);
		
		plate3 = new JButton(plate);
		plate3.setBounds(279, 34, 80, 80);
		plate3.setFocusPainted(false);
		plate3.setBorderPainted(false);
		plate3.addActionListener(this);
		
		panel.add(plate3);
		
		status = new JLabel("       Press: Play to start!");
		status.setBounds(110, 170, 207, 16);
		panel.add(status);
		
		prize = new JLabel("");
		prize.setBounds(158, 177, 80, 80);
		panel.add(prize);
		
		button = new JButton("Play");
		button.setForeground(new Color(44, 150, 104));
		button.setBounds(138, 136, 117, 29);
		
		button.setActionCommand("play");
		button.addActionListener(this);
		panel.add(button);
		
		p1Stat = new JLabel(" ");
		p1Stat.setBounds(59, 115, 47, 16);
		panel.add(p1Stat);
		
		p2Stat = new JLabel(" ");
		p2Stat.setBounds(184, 115, 61, 16);
		panel.add(p2Stat);
		
		p3Stat = new JLabel(" ");
		p3Stat.setBounds(301, 115, 61, 16);
		panel.add(p3Stat);
		
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
			
			status.setText("Click the plates to shoot!");
			
		}
		
		if(eventName.equals("stop")) {
			
			button.setForeground(new Color(44, 150, 104));
			button.setActionCommand("play");
			button.setText("Play");
			
			plate1.setIcon(plate);
			plate2.setIcon(plate);
			plate3.setIcon(plate);
			
			status.setText("       Press: Play to start!");
			
		}
		
			
			if(eventName.equals("shoot1")) {
				
				if (gameStat.equals("on")) {
					
					shoot = (int)(2*Math.random() + 1);
						
						if (shoot == 1) {
							
							shape = (int)(3*Math.random());
							plate1.setIcon(plates.get(shape));
							
							p1Stat.setForeground(new Color(44, 150, 104));
							p1Stat.setText(" HIT!");
							
							timer.schedule(new TimerTask() {
							    public void run() {
							        p1Stat.setText(" ");
							    }
							}, 500);}
							
						else {
							
							p1Stat.setForeground(Color.red);
							p1Stat.setText("MISS!");
							
							timer.schedule(new TimerTask() {
							    public void run() {
							        p1Stat.setText(" ");
							    }
							}, 500);
							
							win = false;
						}
						
						plate1.setActionCommand("end1");
						
				}
			}else if(eventName.equals("shoot2")){
				
				if (gameStat.equals("on")) {
					
					shoot = (int)(2*Math.random() + 1);
						
						if (shoot == 1) {
							
							shape = (int)(3*Math.random());
							plate2.setIcon(plates.get(shape));
							
							p2Stat.setForeground(new Color(44, 150, 104));
							p2Stat.setText(" HIT!");
							
							timer.schedule(new TimerTask() {
							    public void run() {
							        p2Stat.setText(" ");
							    }
							}, 500);}
							
						else {
							
							p2Stat.setForeground(Color.red);
							p2Stat.setText("MISS!");
							
							timer.schedule(new TimerTask() {
							    public void run() {
							        p2Stat.setText(" ");
							    }
							}, 500);
							
							win = false;
						}
						
						plate2.setActionCommand("end2");
				}
			}else if (eventName.equals("shoot3")){
				
				if (gameStat.equals("on")) {
					
					shoot = (int)(2*Math.random() + 1);
						
						if (shoot == 1) {
							
							shape = (int)(3*Math.random());
							plate3.setIcon(plates.get(shape));
							
							p3Stat.setForeground(new Color(44, 150, 104));
							p3Stat.setText(" HIT!");
							
							timer.schedule(new TimerTask() {
							    public void run() {
							        p3Stat.setText(" ");
							    }
							}, 500);}
							
						else {
							
							p3Stat.setForeground(Color.red);
							p3Stat.setText("MISS!");
							
							timer.schedule(new TimerTask() {
							    public void run() {
							        p3Stat.setText(" ");
							    }
							}, 500);
							
							win = false;
						}
						
						plate3.setActionCommand("end3");
			}}
	
	}}
