/*

Program: TicTacToe.java          Last Date of this Revision: March 20th, 2026

Purpose: The TicTacToe application allows two players to play a computerized game of tic-tac-toe. 
(Added game mode to play against computer.)


Author: Sophia Chen 
School: CHHS
Course: CompSci-30

*/
package Mastery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class TicTacToe implements ActionListener {

	// Initialize variables + GUI components
	private JFrame frmTictactoe;
	private JLabel catPic;
	private ImageIcon cat, catDance, cat2, hamster;
	private JPanel mainPanel, boardPanel, gamePanel;
	private JButton playButton, humanButton, compButton, catMode, resetButton;
	JButton space[][] = new JButton[3][3];
	String player1, player2, gameMode, currPlayer, boxNum, humanSpot, computerSpot;
	int movesMade;
	String winner = " ";
	
	Boolean gameOn = false;
	Boolean catOn = false;
	
	private JLabel playerTurn, turnStat;
	Timer timer = new Timer();

	// Method to initialize TicTacToe Board
	public void board() {
		
		// for every element of i (row)
		for (int i = 0; i < space.length; i++) {
			
			// for every element of t (column)
			for(int t = 0; t< space[0].length; t++) {
			
			// Create new J Button + set action command to box + #
			space[i][t] = new JButton(" ");
			space[i][t].setFocusPainted(false);
			space[i][t].setForeground(new Color(109, 68, 90));
			space[i][t].setActionCommand("box" + i+t);
			space[i][t].addActionListener(this);
			
			// Add button to board panel
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
		initialize(); //Create program
		board(); // Initialize board
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// Initialize image icons 
		cat2 = new ImageIcon("../Chapter10/src/Mastery/tofu.jpg");
		cat = new ImageIcon("../Chapter10/src/Mastery/cat1.jpg");
		catDance = new ImageIcon("../Chapter10/src/Mastery/catdance.gif");
		hamster = new ImageIcon("../Chapter10/src/Mastery/hamster.gif");
		
		// Create J Frame to hold all contents
		frmTictactoe = new JFrame();
		frmTictactoe.setTitle("TicTacToe");
		frmTictactoe.setBounds(100, 100, 603, 419);
		frmTictactoe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Main panel
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 247, 251));
		frmTictactoe.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
		
		// Board panel to hold squares
		boardPanel = new JPanel();
		boardPanel.setBackground(new Color(250, 207, 225));
		boardPanel.setBounds(29, 24, 338, 338);
		mainPanel.add(boardPanel);
		boardPanel.setLayout(new GridLayout(3, 3, 3, 3));
		boardPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		// Play button
		playButton = new JButton("⟡ PLAY ⟡");
		playButton.setForeground(new Color(109, 68, 90));
		playButton.setFont(new Font("Silom", Font.BOLD, 26));
		playButton.setFocusPainted(false);
		playButton.setBounds(379, 243, 205, 69);
		playButton.setActionCommand("play");
		playButton.addActionListener(this);
		mainPanel.add(playButton);
		
		// Play with 2 people button
		humanButton = new JButton("P VS P");
		humanButton.setFont(new Font("Skia", Font.BOLD, 16));
		humanButton.setFocusPainted(false);
		humanButton.setForeground(new Color(180, 102, 139));
		humanButton.setToolTipText("Player Vs Player");
		humanButton.setBounds(379, 200, 100, 39);
		humanButton.setActionCommand("human");
		gameMode = ("human");
		humanButton.addActionListener(this);
		mainPanel.add(humanButton);
		
		// Play against computer button
		compButton = new JButton("P VS Computer");
		compButton.setFont(new Font("Skia", Font.BOLD, 13));
		compButton.setFocusPainted(false);
		compButton.setForeground(new Color(247, 221, 237));
		compButton.setToolTipText("Player Vs Computer");
		compButton.setBounds(476, 200, 108, 39);
		compButton.setActionCommand("computer");
		compButton.addActionListener(this);
		mainPanel.add(compButton);
		
		// Toggle the cat theme in the game button
		catMode = new JButton("cat mode ⌞ x ⌝");
		catMode.setFont(new Font("Gurmukhi Sangam MN", Font.PLAIN, 14));
		catMode.setFocusPainted(false);
		catMode.setForeground(new Color(109, 67, 90));
		catMode.setToolTipText("Change the background of the board!");
		catMode.setBounds(420, 324, 128, 23);
		catMode.setActionCommand("catModeOn");
		catMode.addActionListener(this);
		mainPanel.add(catMode);
		
		// Image icons + decorative 
		catPic = new JLabel("");
		catPic.setIcon(hamster);
		catPic.setBounds(412, 24, 158, 172);
		mainPanel.add(catPic);
		
		// Game panel
		gamePanel = new JPanel();
		gamePanel.setBorder(new LineBorder(new Color(199, 144, 173), 3, true));
		gamePanel.setBackground(new Color(254, 255, 255));
		gamePanel.setBounds(390, 152, 194, 99);
		gamePanel.setVisible(false);
		mainPanel.add(gamePanel);
		gamePanel.setLayout(null);
		
		// Turn header
		playerTurn = new JLabel("current turn:");
		playerTurn.setForeground(new Color(128, 86, 106));
		playerTurn.setFont(new Font("Skia", Font.PLAIN, 17));
		playerTurn.setBounds(45, 6, 108, 39);
		playerTurn.setVisible(false);
		gamePanel.add(playerTurn);
		
		// Turn label
		turnStat = new JLabel("");
		turnStat.setForeground(new Color(198, 144, 172));
		turnStat.setFont(new Font("Silom", Font.PLAIN, 29));
		turnStat.setBounds(22, 27, 166, 58);
		turnStat.setVisible(false);
		gamePanel.add(turnStat);
		
		// Reset game button
		resetButton = new JButton("reset");
		resetButton.setFont(new Font("Monaco", Font.PLAIN, 13));
		resetButton.setForeground(new Color(198, 144, 172));
		resetButton.setBounds(448, 108, 88, 32);
		resetButton.setVisible(false);
		resetButton.setFocusPainted(false);
		resetButton.setActionCommand("reset");
		resetButton.addActionListener(this);
		mainPanel.add(resetButton);
	
	}
	
//When a button is pressed
public void actionPerformed(ActionEvent e) {
		
	//Set button's action command to variable "eventName"
		String eventName = e.getActionCommand();
		
		// If button event name is equal to reset:
		if(eventName.equals("reset")) {
			
			// Remove all buttons on the board
			for (int i = 0; i < space.length; i++) {
				
				for(int t = 0; t< space[0].length; t++) {
					
					boardPanel.remove(space[i][t]);
					
				}
			}
			
			// Create the board again. (create buttons)
			board();
			
			// Turn game on to false
			gameOn = false;
			
			// Toggle button visibility
			playButton.setVisible(true);
			humanButton.setVisible(true);
			compButton.setVisible(true);
			catMode.setVisible(true);
			catPic.setVisible(true);
			
			playerTurn.setVisible(false);
			turnStat.setVisible(false);
			gamePanel.setVisible(false);
			resetButton.setVisible(false);
			
			// Reset winner to none
			winner = " ";
			
		}
		
		// If game is not active:
		if (gameOn == false) {
			
			// If button event name is equal to human
			if (eventName.equals("human")) {
				
				// Set game mode to human
				gameMode = ("human");
				
				// Adjust button shading
				humanButton.setForeground(new Color(180, 102, 139));
				compButton.setForeground(new Color(247, 221, 237));
			}
			
			// Else if button event name is equal to computer:
			else if (eventName.equals("computer")){
				
				//Set game mode to computer
				gameMode = ("computer");
				
				//Adjust button shading
				compButton.setForeground(new Color(180, 102, 139));
				humanButton.setForeground(new Color(247, 221, 237));
			}
			
			//If button event name is equal to cat mode
			if (eventName.equals("catModeOn")) {
				
				// Set cat mode to on
				catOn = true;
				
				// Change action command to prep for future button click
				catMode.setActionCommand("catModeOff");
				
				// Perform decorative changes
				catPic.setIcon(catDance);
				catMode.setText("cat mode ⌞✓⌝");
			}
			
			// If button event name is equal to cat mode off
			else if (eventName.equals("catModeOff")) {
				
				// Set cat mode to off
				catOn = false;
				
				// Change action command to prep for future button click
				catMode.setActionCommand("catModeOn");
				
				//Perform decorative changes
				catPic.setIcon(hamster);
				catMode.setText("cat mode ⌞ x ⌝");
			}
			
			// If button event name is equal to play
			if(eventName.equals("play")) {
				
				//Set game to active
				gameOn=true;
				
				
				// Hide main menu buttons
				playButton.setVisible(false);
				humanButton.setVisible(false);
				compButton.setVisible(false);
				catMode.setVisible(false);
				catPic.setVisible(false);
				
				// Show game state information
				playerTurn.setVisible(true);
				turnStat.setVisible(true);
				gamePanel.setVisible(true);
				resetButton.setVisible(true);
				
				// Reset game moves + initialize player pieces
				movesMade = 0 ;
				player1 = "x";
				player2 = "o";
				currPlayer = player1;
				turnStat.setText("player: " + currPlayer);
			}
		}	
		// If game is active
		if (gameOn == true) {
			
			// If button event name includes "box" (representing any button clicked)
			if (eventName.contains("box")) {
		
				// If the game mode is set to human
				if (gameMode.equals("human")){
					
					// Set human spot equal to button event name
					humanSpot = eventName;
					
					// Perform moves method using two human players
					moves(humanSpot, humanSpot);
					
				}
				
				//If the game mode is set to computer
				if(gameMode.equals("computer")) {
					
					// Set human spot equal to button event name
					humanSpot = eventName;
					
					//Perform moves method using one human player, and computer
					moves(humanSpot, computerSpot);
					
					// If winner is not determined, and turn is set to player 2
					if (winner.equals(" ") && turnStat.getText().equals("player: " + player2)) {
						
						// Change player turn label to computer
						turnStat.setText("computer");
				    
					}
				}
			}
			
			// In computer mode, if current player is equal to 2, and winner is not determined,
			if ((currPlayer == player2) && gameMode.equals("computer") && winner.equals(" ")){
				
				// After 0.4 second, perform computer turn method, and perform moves method
				timer.schedule(new TimerTask() {
				    public void run() {
		
				    	computerTurn();
				    	moves(humanSpot, computerSpot);

				    }
				    
				}, 400);
				
				
				
			}
		}
	}

//Method to determine computer spot in computer game mode
private void computerTurn() {
	
	// While current player is equal to 2
	while (currPlayer == player2) {
		
		// Choose random row + column (spot on board)
		int i = (int)(3*Math.random()); 
		int t = (int)(3*Math.random()); 
		
		// Set computer spot to box + #
		computerSpot = "box" + i + t;
		
		// Only when spot is empty (no text is in chosen box),
		if ((space[i][t]).getText() == (" ")) {
			
			// Stop method
			break;
		}
	}
}

// Method to prompt user for a move until a valid move has been made.
// Creates a mark in the player's chosen square
private void moves(String spotP1, String spotP2) {
	
	
	// If total moves are less than or equal to 9, and winner is not determined
	if ((movesMade <= 9) && (winner == " ")) {
		
		// Set player marks
		player1 = "x";
		player2 = "o";
		
		// If current player is player 1
		if (currPlayer == player1) {
			
			// Set variable to player button event name
			boxNum = spotP1;
		}
		
		// Else if current player is player 2
		else {
			
			// Set variable to player2 button event name
			boxNum = spotP2;
			
		}
		
		// for the row, take the 3rd character of variable "boxNum"
        int i = boxNum.charAt(3) - '0';
        
        // for the column, take the 3rd character of variable "boxNum"
        int t = boxNum.charAt(4) - '0';

        // If chosen space is empty
        if ((space[i][t].getText().equals(" "))){
        	
        	// + 1 to moves made
        	movesMade++;
        	
        	// If cat mode is off,
        	if (catOn == false) {
        		
        		// Set the button's text to the mark of the current player
        		space[i][t].setFont(new Font("Yuanti SC", Font.BOLD, 45));
        		space[i][t].setText(currPlayer);
   
        	// Else, if cat mode is on,
            } else {
            	
            	// If the current player is 1
            	if (currPlayer == player1) {
            		
            		// Set button text to mark of current player, and set icon to cat1
            		space[i][t].setText(currPlayer);
            		space[i][t].setIcon(cat);
            	
            	// else if the current player is 2
            	}else {
            		
            		// Set button text to mark of current player, and set icon to cat2
            		space[i][t].setText(currPlayer);
            		space[i][t].setIcon(cat2);}
          
            }
        	
        	// If the current player is 1
            if (currPlayer.equals(player1)) {
            	
            	// After move is made, set current player to 2
                currPlayer = player2;
               
            // Else, do the opposite
            } else {
            	
                currPlayer = player1;
                
            }
            
            // Update turn stat label to reflect current player
            turnStat.setText("player: " + currPlayer);
        }
    }
	
	// Check if there is a winner after every turn using method
	winner();
}

// Method to determine winner
private void winner() {
	
	//Test rows of board to see if any match up
	for (int i = 0; i < space.length; i ++) {
		
		if(((space[i][0]).getText()).equals((space[i][1]).getText()) &&
		(space[i][1].getText()).equals ((space[i][2]).getText()) &&
		!((space[i][0].getText().equals(" ")))) {
			
		winner = ((space[i][0]).getText()) + " WINS ! ";
		
		}
		
	}
	
	//Test columns of board to see if any match up
	for (int t = 0; t < space[0].length; t ++) {
		
		if(((space[0][t]).getText()).equals((space[1][t]).getText()) &&
		(space[1][t].getText()).equals ((space[2][t]).getText()) &&
		!((space[0][t].getText().equals(" ")))) {
			
		winner = ((space[0][t]).getText()) + " WINS ! ";}
	}
		
	//Test diagonal of board to see if any match up
	if	(((space[0][0]).getText()).equals((space[1][1]).getText()) &&
		(space[1][1].getText()).equals ((space[2][2]).getText()) &&
		!((space[0][0].getText().equals(" ")))) {
			
		winner = ((space[0][0]).getText()) + " WINS ! ";}

	//Test other diagonal of board to see if any match up
	if	(((space[0][2]).getText()).equals((space[1][1]).getText()) &&
		(space[1][1].getText()).equals ((space[2][0]).getText()) &&
		!((space[0][2].getText().equals(" ")))) {
			
		winner = ((space[0][2]).getText()) + " WINS ! ";}
	
	// If 9 moves are made, and winner is undetermined
	if ((movesMade == 9) && (winner.equals(" "))){
		
		// Set winner to draw
		winner = ("  DRAW !");
		
	}
	
	// In computer mode, if winner is player 2, 
	if ((winner.equals(player2 + " WINS ! ")) && gameMode.equals("computer")) {
		
		// Change winner output to "computer"
		winner = "CP WINS !";
		
	}
	
	// If a winner is determined
	if (winner != " ") {
		
		// Display result to user
		playerTurn.setVisible(false);
		turnStat.setText(winner);
		turnStat.setFont(new Font("Silom", Font.PLAIN, 30));
							
	}
	}
}
	
	


