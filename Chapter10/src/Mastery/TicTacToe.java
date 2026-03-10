package Mastery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;

public class TicTacToe {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToe window = new TicTacToe();
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
	public TicTacToe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 590, 419);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 247, 251));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel boardPanel = new JPanel();
		boardPanel.setBackground(new Color(250, 207, 225));
		boardPanel.setBounds(29, 24, 338, 338);
		panel.add(boardPanel);
		boardPanel.setLayout(new GridLayout(3, 3, 3, 3));
		boardPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
		
		
		JButton btnNewButton = new JButton("New button");
		boardPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		boardPanel.add(btnNewButton_1);
		
		JButton btnNewButton_6 = new JButton("New button");
		boardPanel.add(btnNewButton_6);
		
		JButton btnNewButton_2 = new JButton("New button");
		boardPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		boardPanel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		boardPanel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		boardPanel.add(btnNewButton_5);
		
		JButton btnNewButton_7 = new JButton("New button");
		boardPanel.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("New button");
		boardPanel.add(btnNewButton_8);
	}
}
