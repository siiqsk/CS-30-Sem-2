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

	private JFrame frmTictactoe;
	JLabel catPic;
	private ImageIcon cat, catDance, cat2, hamster;
	private JPanel mainPanel, boardPanel, gamePanel;
	JButton playButton, humanButton, compButton, catMode, resetButton;
	JButton space[][] = new JButton[3][3];
	String player1, player2, gameMode, currPlayer, boxNum, humanSpot, computerSpot;
	int movesMade;
	String winner = " ";
	
	Boolean gameOn = false;
	Boolean catOn = false;
	
	private JLabel playerTurn, turnStat;
	Timer timer = new Timer();

	
	public void board() {
		
		for (int i = 0; i < space.length; i++) {
			
			for(int t = 0; t< space[0].length; t++) {
			
			space[i][t] = new JButton(" ");
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		cat2 = new ImageIcon("../Chapter10/src/Mastery/tofu.jpg");
		cat = new ImageIcon("../Chapter10/src/Mastery/cat1.jpg");
		catDance = new ImageIcon("../Chapter10/src/Mastery/catdance.gif");
		hamster = new ImageIcon("../Chapter10/src/Mastery/hamster.gif");
		
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
		playButton.setFont(new Font("Silom", Font.BOLD, 26));
		playButton.setFocusPainted(false);
		playButton.setBounds(379, 243, 205, 69);
		playButton.setActionCommand("play");
		playButton.addActionListener(this);
		mainPanel.add(playButton);
		
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
		
		compButton = new JButton("P VS Computer");
		compButton.setFont(new Font("Skia", Font.BOLD, 13));
		compButton.setFocusPainted(false);
		compButton.setForeground(new Color(247, 221, 237));
		compButton.setToolTipText("Player Vs Computer");
		compButton.setBounds(476, 200, 108, 39);
		compButton.setActionCommand("computer");
		compButton.addActionListener(this);
		mainPanel.add(compButton);
		
		catMode = new JButton("cat mode ⌞ x ⌝");
		catMode.setFont(new Font("Gurmukhi Sangam MN", Font.PLAIN, 14));
		catMode.setFocusPainted(false);
		catMode.setForeground(new Color(109, 67, 90));
		catMode.setToolTipText("Change the background of the board!");
		catMode.setBounds(420, 324, 128, 23);
		catMode.setActionCommand("catModeOn");
		catMode.addActionListener(this);
		mainPanel.add(catMode);
		
		catPic = new JLabel("");
		catPic.setIcon(hamster);
		catPic.setBounds(412, 24, 158, 172);
		mainPanel.add(catPic);
		
		gamePanel = new JPanel();
		gamePanel.setBorder(new LineBorder(new Color(199, 144, 173), 3, true));
		gamePanel.setBackground(new Color(254, 255, 255));
		gamePanel.setBounds(390, 152, 194, 99);
		gamePanel.setVisible(false);
		mainPanel.add(gamePanel);
		gamePanel.setLayout(null);
		
		playerTurn = new JLabel("current turn:");
		playerTurn.setForeground(new Color(128, 86, 106));
		playerTurn.setFont(new Font("Skia", Font.PLAIN, 17));
		playerTurn.setBounds(45, 6, 108, 39);
		playerTurn.setVisible(false);
		gamePanel.add(playerTurn);
		
		turnStat = new JLabel("");
		turnStat.setForeground(new Color(198, 144, 172));
		turnStat.setFont(new Font("Silom", Font.PLAIN, 29));
		turnStat.setBounds(22, 27, 166, 58);
		turnStat.setVisible(false);
		gamePanel.add(turnStat);
		
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
	
public void actionPerformed(ActionEvent e) {
		
		String eventName = e.getActionCommand();
		
		
		if(eventName.equals("reset")) {
			
			for (int i = 0; i < space.length; i++) {
				
				for(int t = 0; t< space[0].length; t++) {
					
					boardPanel.remove(space[i][t]);
					
				}
			}
			
			board();
			
			gameOn = false;
			
			playButton.setVisible(true);
			humanButton.setVisible(true);
			compButton.setVisible(true);
			catMode.setVisible(true);
			catPic.setVisible(true);
			
			playerTurn.setVisible(false);
			turnStat.setVisible(false);
			gamePanel.setVisible(false);
			resetButton.setVisible(false);
			
			winner = " ";
			
		}
		
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
				catPic.setIcon(hamster);
				catMode.setText("cat mode ⌞ x ⌝");
			}
			
			if(eventName.equals("play")) {
				gameOn=true;
				
				playButton.setVisible(false);
				humanButton.setVisible(false);
				compButton.setVisible(false);
				catMode.setVisible(false);
				catPic.setVisible(false);
				
				playerTurn.setVisible(true);
				turnStat.setVisible(true);
				gamePanel.setVisible(true);
				resetButton.setVisible(true);
				
				movesMade = 0 ;
				player1 = "x";
				player2 = "o";
				currPlayer = player1;
				turnStat.setText("player: " + currPlayer);
			}
		}	
		
		if (gameOn == true) {
			
			if (eventName.contains("box")) {
		
				
				if (gameMode.equals("human")){
					
					humanSpot = eventName;
					moves(humanSpot, humanSpot);
					
				}
				
				if(gameMode.equals("computer")) {
					
					humanSpot = eventName;
					moves(humanSpot, computerSpot);
					
					if (winner.equals(" ") && turnStat.getText().equals("player: " + player2)) {
						
						turnStat.setText("computer");
				    
					}
				}
			}
			
			if ((currPlayer == player2) && gameMode.equals("computer") && winner.equals(" ")){
				
				timer.schedule(new TimerTask() {
				    public void run() {
		
				    	computerTurn();
				    	moves(humanSpot, computerSpot);

				    }
				    
				}, 400);
				
				
				
			}
		}
	}

private void computerTurn() {
	
	while (currPlayer == player2) {
		
		int i = (int)(3*Math.random()); 
		int t = (int)(3*Math.random()); 
		
		computerSpot = "box" + i + t;
		
		if ((space[i][t]).getText() == (" ")) {
			
			break;
		}
	}
}

private void moves(String spotP1, String spotP2) {
	
	
	
	if ((movesMade <= 9) && (winner == " ")) {
		
		player1 = "x";
		player2 = "o";
		
		if (currPlayer == player1) {
			
			boxNum = spotP1;
		}
		else {
			
			boxNum = spotP2;
			
		}
		
		

        int i = boxNum.charAt(3) - '0';
        int t = boxNum.charAt(4) - '0';


        if ((space[i][t].getText().equals(" "))){
        	
        	movesMade++;
        	
        	if (catOn == false) {
        		
        		space[i][t].setFont(new Font("Yuanti SC", Font.BOLD, 45));
        		space[i][t].setText(currPlayer);
   
        		
            } else {
            	
            	if (currPlayer == player1) {
            		space[i][t].setText(currPlayer);
            		space[i][t].setIcon(cat);
            		
            	}else {
            		
            		space[i][t].setText(currPlayer);
            		space[i][t].setIcon(cat2);}
          
            }
        	
        
        	
            if (currPlayer.equals(player1)) {
            	
                currPlayer = player2;
                
            } else {
            	
                currPlayer = player1;
                
            }
            
            turnStat.setText("player: " + currPlayer);
        }
        
   

    }
	
	
	winner();
	
	
}
private void winner() {
	
	for (int i = 0; i < space.length; i ++) {
		
		if(((space[i][0]).getText()).equals((space[i][1]).getText()) &&
		(space[i][1].getText()).equals ((space[i][2]).getText()) &&
		!((space[i][0].getText().equals(" ")))) {
			
		winner = ((space[i][0]).getText()) + " WINS ! ";
		
		//return winner;
		}
		
		}
	
	for (int t = 0; t < space[0].length; t ++) {
		
		if(((space[0][t]).getText()).equals((space[1][t]).getText()) &&
		(space[1][t].getText()).equals ((space[2][t]).getText()) &&
		!((space[0][t].getText().equals(" ")))) {
			
		winner = ((space[0][t]).getText()) + " WINS ! ";}
		//return winner;

	}
		
	if	(((space[0][0]).getText()).equals((space[1][1]).getText()) &&
		(space[1][1].getText()).equals ((space[2][2]).getText()) &&
		!((space[0][0].getText().equals(" ")))) {
			
		winner = ((space[0][0]).getText()) + " WINS ! ";}
		//return winner;


	if	(((space[0][2]).getText()).equals((space[1][1]).getText()) &&
		(space[1][1].getText()).equals ((space[2][0]).getText()) &&
		!((space[0][2].getText().equals(" ")))) {
			
		winner = ((space[0][2]).getText()) + " WINS ! ";}
		//return winner;
	
	if ((movesMade == 9) && (winner.equals(" "))){
		
		winner = ("  DRAW !");
		
	}
	
	if ((winner.equals(player2 + " WINS ! ")) && gameMode.equals("computer")) {
		
		winner = "CP WINS !";
		
	}
	
	if (winner != " ") {
		
		playerTurn.setVisible(false);
		turnStat.setText(winner);
		turnStat.setFont(new Font("Silom", Font.PLAIN, 30));
							
	}
	
	
	
	}
}
	
	


