package Mastery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class LocalBank {

	private JFrame frmLocalbank;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocalBank window = new LocalBank();
					window.frmLocalbank.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LocalBank() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLocalbank = new JFrame();
		frmLocalbank.setTitle("LocalBank");
		frmLocalbank.setBounds(100, 100, 450, 300);
		frmLocalbank.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(243, 248, 255));
		frmLocalbank.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("welcome to:");
		lblNewLabel.setFont(new Font("Devanagari MT", Font.PLAIN, 15));
		lblNewLabel.setBounds(186, 21, 83, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Your Local Bank.");
		lblNewLabel_1.setFont(new Font("Snell Roundhand", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(106, 82, 277, 41);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LocalBank.class.getResource("/Mastery/lace.png")));
		lblNewLabel_2.setBounds(40, 43, 366, 126);
		panel.add(lblNewLabel_2);
	}
}
