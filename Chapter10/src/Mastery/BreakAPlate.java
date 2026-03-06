/*

Program: BreakAPlate.java          Last Date of this Revision: March 5th, 2026

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

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BreakAPlate implements ActionListener {
	
	private ImageIcon plate, broken1, broken2, broken3, tiger, sticker;
	private JLabel plate1, plate2, plate3, status, prize;
	private JFrame frmBreakaplate;
	private JButton button;

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
		broken1 = new ImageIcon("../Chapter10/src/skillbuilder/die2.gif");
		broken2 = new ImageIcon("../Chapter10/src/skillbuilder/die3.gif");
		broken3 = new ImageIcon("../Chapter10/src/skillbuilder/die4.gif");
		tiger = new ImageIcon("../Chapter10/src/skillbuilder/die5.gif");
		sticker = new ImageIcon("../Chapter10/src/skillbuilder/die6.gif");
		
		frmBreakaplate = new JFrame();
		frmBreakaplate.setTitle("BreakAPlate");
		frmBreakaplate.setBounds(100, 100, 400, 299);
		frmBreakaplate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(254, 255, 255));
		frmBreakaplate.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		plate1 = new JLabel(plate);
		plate1.setBounds(37, 34, 80, 80);
		panel.add(plate1);
		
		plate2 = new JLabel(plate);
		plate2.setBounds(158, 34, 80, 80);
		panel.add(plate2);
		
		plate3 = new JLabel(plate);
		plate3.setBounds(279, 34, 80, 80);
		panel.add(plate3);
		
		status = new JLabel("New label");
		status.setBounds(165, 163, 61, 16);
		panel.add(status);
		
		prize = new JLabel("");
		prize.setBounds(158, 177, 80, 80);
		panel.add(prize);
		
		button = new JButton("Play");
		button.setBackground(new Color(254, 127, 125));
		button.setBounds(138, 126, 117, 29);
		
		button.setActionCommand("poll");
		button.addActionListener(this);
		panel.add(button);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String eventName = e.getActionCommand();
		if(eventName.equals("play")) {
			
			plate1.setIcon(plate);
			plate2.setIcon(plate);
			plate3.setIcon(plate);
			
			button.setText("Stop");
			
			
			
	}
		
	}

}
