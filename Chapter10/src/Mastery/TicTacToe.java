package Mastery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class TicTacToe implements ActionListener {

	private JFrame frmTictactoe;
	JLabel catPic;
	private ImageIcon cat, catDance, cat2;
	private JPanel mainPanel, boardPanel, gamePanel;
	JButton playButton, humanButton, compButton, catMode;
	JButton space[][] = new JButton[3][3];
	String player1, player2, gameMode, currPlayer, boxNum;
	int movesMade;
	String winner = " ";
	
	Boolean gameOn = false;
	Boolean catOn = false;
	
	private JLabel playerTurn, turnStat;

	
	public void board() {
		
		for (int i = 0; i < space.length; i++) {
			
			for(int t = 0; t< space[0].length; t++) {
			
			space[i][t] = new JButton(" ");
			//space[i][t].setIcon(cat);
			space[i][t].setFocusPainted(false);
			space[i][t].setForeground(new Color(109, 68, 90));
			space[i][t].setActionCommand("box" + i+t);
			space[i][t].addActionListener(this);
			
			boardPanel.add(space[i][t]);
			
			}
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToe window = new TicTacToe();
					window.frmTictactoe.setVisible(true);
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
		board();
		
		while (gameOn == true) {
			winner();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		cat2 = new ImageIcon("../Chapter10/src/Mastery/tofu (1).jpeg");
		cat = new ImageIcon("../Chapter10/src/Mastery/cat1.jpeg");
		catDance = new ImageIcon("../Chapter10/src/Mastery/catdance.gif");
		
		frmTictactoe = new JFrame();
		frmTictactoe.setTitle("TicTacToe");
		frmTictactoe.setBounds(100, 100, 603, 419);
		frmTictactoe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 247, 251));
		frmTictactoe.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
		
		boardPanel = new JPanel();
		boardPanel.setBackground(new Color(250, 207, 225));
		boardPanel.setBounds(29, 24, 338, 338);
		mainPanel.add(boardPanel);
		boardPanel.setLayout(new GridLayout(3, 3, 3, 3));
		boardPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		playButton = new JButton("⟡ PLAY ⟡");
		playButton.setForeground(new Color(109, 68, 90));
		playButton.setFont(new Font("Yuanti SC", Font.BOLD, 26));
		playButton.setFocusPainted(false);
		playButton.setBounds(379, 243, 205, 69);
		playButton.setActionCommand("play");
		playButton.addActionListener(this);
		mainPanel.add(playButton);
		
		humanButton = new JButton("P VS P");
		humanButton.setFont(new Font("Skia", Font.BOLD, 16));
		humanButton.setFocusPainted(false);
		humanButton.setForeground(new Color(180, 102, 139));
		humanButton.setBounds(379, 200, 100, 39);
		humanButton.setActionCommand("human");
		gameMode = ("human");
		humanButton.addActionListener(this);
		mainPanel.add(humanButton);
		
		compButton = new JButton("P VS Computer");
		compButton.setFont(new Font("Skia", Font.BOLD, 13));
		compButton.setFocusPainted(false);
		compButton.setForeground(new Color(247, 221, 237));
		compButton.setBounds(476, 200, 108, 39);
		compButton.setActionCommand("computer");
		compButton.addActionListener(this);
		mainPanel.add(compButton);
		
		catMode = new JButton("cat mode ⌞ x ⌝");
		catMode.setFont(new Font("LingWai TC", Font.PLAIN, 16));
		catMode.setFocusPainted(false);
		catMode.setForeground(new Color(109, 67, 90));
		catMode.setToolTipText("Change the background of the board!");
		catMode.setBounds(420, 324, 128, 23);
		catMode.setActionCommand("catModeOn");
		catMode.addActionListener(this);
		mainPanel.add(catMode);
		
		catPic = new JLabel("");
		catPic.setBounds(403, 24, 154, 172);
		mainPanel.add(catPic);
		
		gamePanel = new JPanel();
		gamePanel.setBorder(new LineBorder(new Color(199, 144, 173), 3, true));
		gamePanel.setBackground(new Color(254, 255, 255));
		gamePanel.setBounds(390, 152, 194, 120);
		gamePanel.setVisible(false);
		mainPanel.add(gamePanel);
		gamePanel.setLayout(null);
		
		playerTurn = new JLabel("current turn:");
		playerTurn.setForeground(new Color(128, 86, 106));
		playerTurn.setFont(new Font("Yuanti SC", Font.PLAIN, 19));
		playerTurn.setBounds(45, 6, 108, 39);
		playerTurn.setVisible(false);
		gamePanel.add(playerTurn);
		
		turnStat = new JLabel("");
		turnStat.setBounds(19, 46, 156, 55);
		turnStat.setVisible(false);
		gamePanel.add(turnStat);
	
	}
	
public void actionPerformed(ActionEvent e) {
		
		String eventName = e.getActionCommand();
		
		System.out.println(eventName);
		
		if (gameOn == false) {
			
			if (eventName.equals("human")) {
				gameMode = ("human");
				humanButton.setForeground(new Color(180, 102, 139));
				compButton.setForeground(new Color(247, 221, 237));
			}
			else if (eventName.equals("computer")){
				gameMode = ("computer");
				compButton.setForeground(new Color(180, 102, 139));
				humanButton.setForeground(new Color(247, 221, 237));
			}
			
			if (eventName.equals("catModeOn")) {
				catOn = true;
				catMode.setActionCommand("catModeOff");
				catPic.setIcon(catDance);
				catMode.setText("cat mode ⌞✓⌝");
			}
			else if (eventName.equals("catModeOff")) {
				catOn = false;
				catMode.setActionCommand("catModeOn");
				catPic.setIcon(null);
				catMode.setText("cat mode ⌞ x ⌝");
			}
			
			if(eventName.equals("play")) {
				playButton.setActionCommand("stop");
				gameOn=true;
				
				playButton.setVisible(false);
				humanButton.setVisible(false);
				compButton.setVisible(false);
				catMode.setVisible(false);
				catPic.setVisible(false);
				
				playerTurn.setVisible(true);
				turnStat.setVisible(true);
				gamePanel.setVisible(true);
				//mainPanel.revalidate();
				//mainPanel.repaint();
				
				movesMade = 0 ;
				player1 = "x";
				player2 = "o";
				currPlayer = player1;
			}
		}	
		
		if (gameOn == true && eventName.contains("box")) {
			
			if (gameMode.equals("human")){
				
				boxNum = eventName;
				moves("x","o");
				
			}

			    /* (movesMade <= 9 /*&& winner()==" ") {

			        int row = eventName.charAt(3) - '0';
			        int col = eventName.charAt(4) - '0';

			        System.out.println(row);
			        System.out.println(col);
			        System.out.println("hi");

			        if (space[row][col].getText().equals(" ")) {

			            space[row][col].setText(currPlayer);
			            movesMade++;

			            if (currPlayer.equals(player1)) {
			            	
			                currPlayer = player2;
			                
			            } else {
			            	
			                currPlayer = player1;
			                
			            }
			        }
		
			    } */
			
			    }}


private void moves(String p1, String p2) {
	
	movesMade++;
	winner();
	System.out.println(winner);
	
	
	if ((movesMade <= 9) && (winner == " ")) {
		
		player1 = p1;
		player2 = p2;

        int row = boxNum.charAt(3) - '0';
        int col = boxNum.charAt(4) - '0';

        System.out.println(row);
        System.out.println(col);
        System.out.println("hi");

        if ((space[row][col].getText().equals(" "))) /*&& (space[row][col].getIcon().equals(null)))*/ {
        	
        	if (catOn == false) {
        		
        		space[row][col].setFont(new Font("Yuanti SC", Font.BOLD, 45));
        		space[row][col].setText(currPlayer);
   
        		
            } else {
            	
            	if (currPlayer == player1) {
            		space[row][col].setText(currPlayer);
            		space[row][col].setIcon(cat);
            		
            	}else {
            		
            		space[row][col].setText(currPlayer);
            		space[row][col].setIcon(cat2);}
          
            }
        	
        	
        	System.out.println(movesMade);
        	
            if (currPlayer.equals(player1)) {
            	
                currPlayer = player2;
                
            } else {
            	
                currPlayer = player1;
                
            }
        }
        
   

    }
}
private void winner() {
	
	/*if (movesMade == 9) {
		System.out.println("yay");
		winner = "play";
	}*/
	
	for (int i = 0; i < space.length; i ++) {
		
		if(((space[i][0]).getText()).equals((space[i][1]).getText()) &&
		(space[i][1].getText()).equals ((space[i][2]).getText()) &&
		!((space[i][0].getText().equals(" ")))) {
			
		winner = ((space[i][0]).getText()) + "Is WINNER";
		//return winner;
		}
		
		}
	}
	
	
}

