package skillbuilder;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Roll implements ActionListener{

	private JFrame frame;
	JButton rollButton;
	JLabel Dice1;
	JLabel Dice2;
	ImageIcon D1;
	ImageIcon D2;
	ImageIcon D3;
	ImageIcon D4;
	ImageIcon D5;
	ImageIcon D6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Roll window = new Roll();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Roll() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setForeground(new Color(255, 227, 250));
		frame.setBounds(100, 100, 323, 220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 227, 250));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		Dice1 = new JLabel("");
		Dice1.setBounds(56, 28, 98, 98);
		panel.add(Dice1);
		
		Dice2 = new JLabel("");
		Dice2.setBounds(177, 28, 98, 98);
		panel.add(Dice2);
		
		rollButton = new JButton("Roll Die");
		rollButton.setBackground(new Color(222, 228, 250));
		rollButton.setFont(new Font("PT Serif", Font.PLAIN, 13));
		
		rollButton.setActionCommand("roll");
		rollButton.addActionListener(this);
		
		rollButton.setBounds(103, 138, 117, 29);
		panel.add(rollButton);
		
		D1 = new ImageIcon("../Chapter10/src/skillbuilder/die1.gif");
		D2 = new ImageIcon("../Chapter10/src/skillbuilder/die2.gif");
		D3 = new ImageIcon("../Chapter10/src/skillbuilder/die3.gif");
		D4 = new ImageIcon("../Chapter10/src/skillbuilder/die4.gif");
		D5 = new ImageIcon("../Chapter10/src/skillbuilder/die5.gif");
		D6 = new ImageIcon("../Chapter10/src/skillbuilder/die6.gif");
		
		}	
		
		public void actionPerformed(ActionEvent e) {
			
			String eventName = e.getActionCommand();
			if(eventName.equals("roll")) {
			
				int Roll1 = (int)(6*Math.random() + 1);
				int Roll2 = (int)(6*Math.random() + 1);
				
				switch (Roll1) {
				
				case 1: Dice1.setIcon(D1);break;
				case 2: Dice1.setIcon(D2);break;
				case 3: Dice1.setIcon(D3);break;
				case 4: Dice1.setIcon(D4);break;
				case 5: Dice1.setIcon(D5);break;
				case 6: Dice1.setIcon(D6);break;
					
				}
				
				switch (Roll2) {
				
				case 1: Dice2.setIcon(D1);break;
				case 2: Dice2.setIcon(D2);break;
				case 3: Dice2.setIcon(D3);break;
				case 4: Dice2.setIcon(D4);break;
				case 5: Dice2.setIcon(D5);break;
				case 6: Dice2.setIcon(D6);break;
					
				}
				
		}
	
		
		
		
		
	}
}
