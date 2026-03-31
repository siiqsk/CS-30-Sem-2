/*

Program: LocalBank.java          Last Date of this Revision: March 31th, 2026

Purpose: The LocalBank application will be created. A bank can open new accounts, modify existing accounts,
and close accounts. An account has a number associated with it, and transactions, such as deposits and with-
drawals, require the account number.

Author: Sophia Chen 
School: CHHS
Course: CompSci-30

*/

package Mastery;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

//Main class for the Local Bank application
public class LocalBank implements ActionListener{

	// Initialize the following:
	
	//Variables used for transactions
	String ID; // Stores account ID entered by the user
	Double amt;  // Stores deposit or withdrawal amount
	
	// Main window frame
	JFrame frmLocalbank;
	
	// Panels used for different screens in the program
	JPanel mainPanel, buttonPanel, newAccountPanel, accountPanel, deletePanel, 
	depositAccountPanel,deleteAccountPanel, depositPanel, withdrawalAccountPanel,
	withdrawalPanel, balanceAccountPanel, balanceInfoPanel,balancePanel ;

	// Buttons for bank actions
	JButton withdrawalButton,addAccountButton, depositButton, removeAccountButton,
	balanceButton, createAccountButton, returnButton, returnButton2, depositAccountButton,
	returnButton3, deleteAccountButton, withdrawalAccountButton, returnButton4,
	balanceAccountButton, returnButton_1;
	
	// Labels used to display text and information to the user
	JLabel welcomeHeader, bankHeader, laceBacking, selectionHeader, pearl1, pearl2,
	lastNameLabel, balanceLabel, accountLabel, firstNameLabel, addAccountHeader, errorLabel,
	successLabel, accountIDLabel, depositHeader, depositAccountHeader, accountLabel3, 
	accountIDHeader, errorLabel2, successDepositLabel, withdrawalAccountHeader, accountLabel4,
	accountIDHeader2, withdrawalHeader, errorLabel3, successWithdrawalLabel, title12,title22,
	title32, accountLabel_1_1, successBalanceLabel,title1,title2,title3,balanceAccountHeader, 
	accountIDLabel2,title12_1, title22_1, title32_1, deleteAccountHeader,accountLabel2,
	accountDeletedText, accountIDheader; 
	
	// Text fields where the user inputs information
	JTextField firstNameBox, lastNameBox, balanceBox, accountIDBox2, withdrawalBox, accountIDBox, 
	depositBox, accountBalanceBox, deleteAccountBox;
	
	// Bank object that stores and manages accounts
	Bank easySave = new Bank();
	
	// Timer used in program to manage pauses
	Timer timer = new Timer();
	
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
		initialize(); //Runs program
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//---------------------------------------------------------------------------------------
		//MAIN WINDOW CONTENTS:
		
		// Create the main window frame
		frmLocalbank = new JFrame();
		frmLocalbank.setTitle("LocalBankGUI");
		frmLocalbank.setBounds(100, 100, 450, 435);
		frmLocalbank.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Main panel that holds everything
		mainPanel = new JPanel();
		mainPanel.setForeground(new Color(0, 0, 0));
		mainPanel.setBackground(new Color(243, 248, 255));
		frmLocalbank.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
		
		// Welcome message at the top of the screen
		welcomeHeader = new JLabel("welcome to:");
		welcomeHeader.setForeground(new Color(58, 71, 96));
		welcomeHeader.setFont(new Font("Devanagari MT", Font.PLAIN, 16));
		welcomeHeader.setBounds(186, 21, 83, 16);
		mainPanel.add(welcomeHeader);
		
		// Bank title
		bankHeader = new JLabel("Your Local Bank.");
		bankHeader.setFont(new Font("Snell Roundhand", Font.PLAIN, 35));
		bankHeader.setBounds(106, 82, 277, 41);
		mainPanel.add(bankHeader);
		
		// Decorative background image
		laceBacking = new JLabel("");
		laceBacking.setIcon(new ImageIcon(LocalBank.class.getResource("/Mastery/lace.png")));
		laceBacking.setBounds(40, 43, 366, 126);
		mainPanel.add(laceBacking);
		
		// Decorative text
		selectionHeader = new JLabel("Please select an option to get started:");
		selectionHeader.setForeground(new Color(86, 97, 140));
		selectionHeader.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		selectionHeader.setBounds(102, 181, 255, 26);
		mainPanel.add(selectionHeader);
		
		// Panel that contains the main menu buttons
		buttonPanel = new JPanel();
		buttonPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		buttonPanel.setBackground(new Color(193, 205, 217));
		buttonPanel.setBounds(40, 212, 366, 148);
		mainPanel.add(buttonPanel);
		buttonPanel.setLayout(null);
		
		// Withdrawal button
		withdrawalButton = new JButton("Withdrawal");
		withdrawalButton.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		withdrawalButton.setFocusPainted(false);
		withdrawalButton.setBounds(6, 6, 117, 64);
		withdrawalButton.setActionCommand("withdrawal");
		withdrawalButton.addActionListener(this);
		buttonPanel.add(withdrawalButton);
		
		// Add account button
		addAccountButton = new JButton("Add Account");
		addAccountButton.setFont(new Font("Devanagari MT", Font.ITALIC, 14));
		addAccountButton.setFocusPainted(false);
		addAccountButton.setBounds(66, 71, 117, 71);
		addAccountButton.setActionCommand("addAccount");
		addAccountButton.addActionListener(this);
		buttonPanel.add(addAccountButton);
		
		// Deposit button
		depositButton = new JButton("Deposit");
		depositButton.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		depositButton.setFocusPainted(false);
		depositButton.setBounds(124, 6, 117, 64);
		depositButton.setActionCommand("deposit");
		depositButton.addActionListener(this);
		buttonPanel.add(depositButton);
		
		// Remove account button
		removeAccountButton = new JButton("Remove Account");
		removeAccountButton.setFont(new Font("Devanagari MT", Font.ITALIC, 13));
		removeAccountButton.setFocusPainted(false);
		removeAccountButton.setBounds(184, 71, 117, 71);
		removeAccountButton.setActionCommand("removeAccount");
		removeAccountButton.addActionListener(this);
		buttonPanel.add(removeAccountButton);
		
		// Check balance button
		balanceButton = new JButton("Check Balance");
		balanceButton.setFont(new Font("Devanagari MT", Font.ITALIC, 14));
		balanceButton.setFocusPainted(false);
		balanceButton.setBounds(243, 6, 117, 64);
		balanceButton.setActionCommand("balance");
		balanceButton.addActionListener(this);
		buttonPanel.add(balanceButton);
		
		// Decorative elements
		pearl1 = new JLabel("");
		pearl1.setIcon(new ImageIcon(LocalBank.class.getResource("/Mastery/pearl.png")));
		pearl1.setBounds(6, 71, 61, 60);
		buttonPanel.add(pearl1);
		
		// Decorative elements
		pearl2 = new JLabel("");
		pearl2.setIcon(new ImageIcon(LocalBank.class.getResource("/Mastery/pearl.png")));
		pearl2.setBounds(305, 71, 61, 60);
		buttonPanel.add(pearl2);
		
		//---------------------------------------------------------------------------------------
		// NEW ACCOUNT WINDOW CONTENTS:
		
		// Panel used to create new bank account
		newAccountPanel = new JPanel();
		newAccountPanel.setBorder(new LineBorder(new Color(97, 106, 138), 1, true));
		newAccountPanel.setBackground(new Color(254, 255, 255));
		newAccountPanel.setBounds(20, 17, 410, 368);
		mainPanel.add(newAccountPanel);
		newAccountPanel.setLayout(null);
		newAccountPanel.setVisible(false);
		
		// Header text for create account screen
		addAccountHeader = new JLabel("────୨ৎ Create New Account: ୨ৎ────");
		addAccountHeader.setForeground(new Color(88, 102, 129));
		addAccountHeader.setFont(new Font("Snell Roundhand", Font.PLAIN, 23));
		addAccountHeader.setBounds(34, 16, 353, 22);
		newAccountPanel.add(addAccountHeader);
		
		// Inner account panel
		accountPanel = new JPanel();
		accountPanel.setBackground(new Color(240, 245, 252));
		accountPanel.setBounds(23, 56, 364, 238);
		newAccountPanel.add(accountPanel);
		accountPanel.setLayout(null);
		
		// Label for account info section
		accountLabel = new JLabel("Account Information:");
		accountLabel.setForeground(new Color(121, 136, 153));
		accountLabel.setFont(new Font("Devanagari MT", Font.PLAIN, 15));
		accountLabel.setBounds(18, 6, 137, 26);
		accountPanel.add(accountLabel);
		
		// First name label
		firstNameLabel = new JLabel("First name:");
		firstNameLabel.setForeground(new Color(54, 59, 67));
		firstNameLabel.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		firstNameLabel.setBounds(18, 32, 76, 26);
		accountPanel.add(firstNameLabel);
		
		// Input box for first name
		firstNameBox = new JTextField();
		firstNameBox.setFont(new Font("Devanagari MT", Font.PLAIN, 13));
		firstNameBox.setBounds(18, 56, 327, 36);
		accountPanel.add(firstNameBox);
		firstNameBox.setColumns(10);
		
		// Input box for last name
		lastNameBox = new JTextField();
		lastNameBox.setFont(new Font("Devanagari MT", Font.PLAIN, 13));
		lastNameBox.setColumns(10);
		lastNameBox.setBounds(18, 125, 327, 36);
		accountPanel.add(lastNameBox);
		
		// Last name label
		lastNameLabel = new JLabel("Last name:");
		lastNameLabel.setForeground(new Color(54, 59, 67));
		lastNameLabel.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		lastNameLabel.setBounds(18, 100, 76, 26);
		accountPanel.add(lastNameLabel);
		
		// Beginning balance input
		balanceBox = new JTextField();
		balanceBox.setFont(new Font("Devanagari MT", Font.PLAIN, 13));
		balanceBox.setColumns(10);
		balanceBox.setBounds(18, 188, 327, 36);
		accountPanel.add(balanceBox);
		
		// balance label
		balanceLabel = new JLabel("Beginning Balance ($):");
		balanceLabel.setForeground(new Color(54, 59, 67));
		balanceLabel.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		balanceLabel.setBounds(18, 164, 178, 26);
		accountPanel.add(balanceLabel);
		
		// Error message label
		errorLabel = new JLabel("Information is invalid.");
		errorLabel.setFont(new Font("Devanagari MT", Font.PLAIN, 13));
		errorLabel.setBounds(180, 8, 178, 16);
		errorLabel.setForeground(new Color(201, 133, 153));
		accountPanel.add(errorLabel);
		errorLabel.setVisible(false);
		
		// Success message after account creation
		successLabel = new JLabel("୨ৎ Account successfully created! ୨ৎ");
		successLabel.setForeground(new Color(88, 102, 129));
		successLabel.setFont(new Font("Snell Roundhand", Font.PLAIN, 23));
		successLabel.setBounds(28, 44, 353, 44);
		accountPanel.add(successLabel);
		successLabel.setVisible(false);
		
		// Shows generated account ID
		accountIDLabel = new JLabel("");
		accountIDLabel.setForeground(new Color(65, 75, 98));
		accountIDLabel.setFont(new Font("Devanagari MT", Font.PLAIN, 28));
		accountIDLabel.setBounds(56, 88, 252, 94);
		accountPanel.add(accountIDLabel);
		accountIDLabel.setVisible(false);
		
		// Button to create account
		createAccountButton = new JButton("Create Account");
		createAccountButton.setForeground(new Color(46, 51, 64));
		createAccountButton.setFont(new Font("Devanagari MT", Font.ITALIC, 19));
		createAccountButton.setFocusPainted(false);
		createAccountButton.setBounds(23, 300, 197, 50);
		createAccountButton.setActionCommand("createAccount");
		createAccountButton.addActionListener(this);
		newAccountPanel.add(createAccountButton);
		
		// Button to return to main menu
		returnButton = new JButton("Main Menu");
		returnButton.setForeground(new Color(91, 105, 130));
		returnButton.setFont(new Font("Devanagari MT", Font.ITALIC, 19));
		returnButton.setFocusPainted(false);
		returnButton.setBounds(224, 300, 163, 50);
		returnButton.setActionCommand("return");
		returnButton.addActionListener(this);
		newAccountPanel.add(returnButton);
		
		//---------------------------------------------------------------------------------------
		// DELETE ACCOUNT WINDOW CONTENTS:
		
		//Panel used to delete bank account
		deleteAccountPanel = new JPanel();
		deleteAccountPanel.setBorder(new LineBorder(new Color(97, 106, 138), 1, true));
		deleteAccountPanel.setBackground(new Color(254, 255, 255));
		deleteAccountPanel.setBounds(20, 17, 410, 368);
		mainPanel.add(deleteAccountPanel);
		deleteAccountPanel.setLayout(null);
		deleteAccountPanel.setVisible(false);
		
		// Header text for delete account screen
		deleteAccountHeader = new JLabel("────୨ৎ Delete Exisiting Account: ୨ৎ────");
		deleteAccountHeader.setForeground(new Color(88, 102, 129));
		deleteAccountHeader.setFont(new Font("Snell Roundhand", Font.PLAIN, 23));
		deleteAccountHeader.setBounds(19, 17, 373, 33);
		deleteAccountPanel.add(deleteAccountHeader);
		
		// Inner delete panel
		deletePanel = new JPanel();
		deletePanel.setBackground(new Color(240, 245, 252));
		deletePanel.setBounds(29, 62, 353, 192);
		deleteAccountPanel.add(deletePanel);
		deletePanel.setLayout(null);
		
		// Account info label
		accountLabel2 = new JLabel("Account Information:");
		accountLabel2.setForeground(new Color(121, 136, 153));
		accountLabel2.setFont(new Font("Devanagari MT", Font.PLAIN, 15));
		accountLabel2.setBounds(103, 6, 137, 26);
		deletePanel.add(accountLabel2);
		
		// Account ID label
		accountIDheader = new JLabel("Enter Account ID:");
		accountIDheader.setForeground(new Color(54, 59, 67));
		accountIDheader.setFont(new Font("Devanagari MT", Font.ITALIC, 19));
		accountIDheader.setBounds(20, 41, 176, 26);
		deletePanel.add(accountIDheader);
		
		// Input box for account ID
		deleteAccountBox = new JTextField();
		deleteAccountBox.setFont(new Font("Devanagari MT", Font.PLAIN, 20));
		deleteAccountBox.setColumns(10);
		deleteAccountBox.setBounds(20, 79, 309, 62);
		deletePanel.add(deleteAccountBox);
		
		// Shows successful deletion text
		accountDeletedText = new JLabel("");
		accountDeletedText.setForeground(new Color(54, 59, 67));
		accountDeletedText.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		accountDeletedText.setBounds(91, 153, 167, 26);
		deletePanel.add(accountDeletedText);
		
		// Button to delete account 
		deleteAccountButton = new JButton("Delete Account");
		deleteAccountButton.setFont(new Font("Devanagari MT", Font.ITALIC, 20));
		deleteAccountButton.setFocusPainted(false);
		deleteAccountButton.setActionCommand("deleteAccount");
		deleteAccountButton.addActionListener(this);
		deleteAccountButton.setBounds(28, 266, 213, 71);
		deleteAccountPanel.add(deleteAccountButton);
		
		// Button to return to main menu
		returnButton2 = new JButton("Main Menu");
		returnButton2.setForeground(new Color(91, 105, 130));
		returnButton2.setFont(new Font("Devanagari MT", Font.ITALIC, 19));
		returnButton2.setFocusPainted(false);
		returnButton2.setBounds(247, 266, 144, 71);
		returnButton2.setActionCommand("return");
		returnButton2.addActionListener(this);
		deleteAccountPanel.add(returnButton2);
		
		//---------------------------------------------------------------------------------------
		//DEPOSIT TO ACCOUNT WINDOW CONTENTS:
		
		// Panel used to deposit to bank account
		depositAccountPanel = new JPanel();
		depositAccountPanel.setBorder(new LineBorder(new Color(97, 106, 138), 1, true));
		depositAccountPanel.setBackground(new Color(254, 255, 255));
		depositAccountPanel.setBounds(20, 17, 410, 368);
		mainPanel.add(depositAccountPanel);
		depositAccountPanel.setLayout(null);
		depositAccountPanel.setVisible(false);
		
		// Header text for deposit account screen
		depositAccountHeader = new JLabel("────୨ৎ Deposit To Account: ୨ৎ────");
		depositAccountHeader.setForeground(new Color(88, 102, 129));
		depositAccountHeader.setFont(new Font("Snell Roundhand", Font.PLAIN, 23));
		depositAccountHeader.setBounds(31, 21, 353, 22);
		depositAccountPanel.add(depositAccountHeader);
		
		// Inner deposit panel
		depositPanel = new JPanel();
		depositPanel.setBackground(new Color(240, 245, 252));
		depositPanel.setBounds(31, 70, 353, 216);
		depositAccountPanel.add(depositPanel);
		depositPanel.setLayout(null);
		
		// Account info header
		accountLabel3 = new JLabel("Account Information:");
		accountLabel3.setForeground(new Color(121, 136, 153));
		accountLabel3.setFont(new Font("Devanagari MT", Font.PLAIN, 15));
		accountLabel3.setBounds(103, 6, 137, 26);
		depositPanel.add(accountLabel3);
		
		// Account ID header
		accountIDHeader = new JLabel("Account ID:");
		accountIDHeader.setForeground(new Color(54, 59, 67));
		accountIDHeader.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		accountIDHeader.setBounds(20, 38, 103, 26);
		depositPanel.add(accountIDHeader);
		
		// Input box for account ID
		accountIDBox = new JTextField();
		accountIDBox.setFont(new Font("Devanagari MT", Font.PLAIN, 13));
		accountIDBox.setColumns(10);
		accountIDBox.setBounds(20, 63, 311, 36);
		depositPanel.add(accountIDBox);
		
		// Input box for deposit amount
		depositBox = new JTextField();
		depositBox.setFont(new Font("Devanagari MT", Font.PLAIN, 13));
		depositBox.setColumns(10);
		depositBox.setBounds(20, 142, 311, 36);
		depositPanel.add(depositBox);
		
		// Deposit header
		depositHeader = new JLabel("Deposit Amount ($):");
		depositHeader.setForeground(new Color(54, 59, 67));
		depositHeader.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		depositHeader.setBounds(20, 117, 176, 26);
		depositPanel.add(depositHeader);
		
		// Error label for invalid inputs
		errorLabel2 = new JLabel("Information provided is invalid.");
		errorLabel2.setFont(new Font("Devanagari MT", Font.PLAIN, 13));
		errorLabel2.setBounds(83, 190, 204, 16);
		depositPanel.add(errorLabel2);
		errorLabel2.setForeground(new Color(201, 133, 153));
		errorLabel2.setVisible(false);
		
		// Success label for successful transaction
		successDepositLabel = new JLabel("");
		successDepositLabel.setForeground(new Color(66, 70, 79));
		successDepositLabel.setFont(new Font("Devanagari MT", Font.PLAIN, 17));
		successDepositLabel.setBounds(124, 32, 250, 146);
		depositPanel.add(successDepositLabel);
		
		// Info label
		title1 = new JLabel("Account ID:");
		title1.setForeground(new Color(115, 121, 136));
		title1.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		title1.setBounds(33, 67, 93, 26);
		depositPanel.add(title1);
		
		// Info label
		title2 = new JLabel("Name:");
		title2.setForeground(new Color(115, 121, 136));
		title2.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		title2.setBounds(70, 95, 51, 26);
		depositPanel.add(title2);
		
		// Info label
		title3 = new JLabel("Balance:");
		title3.setForeground(new Color(115, 121, 136));
		title3.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		title3.setBounds(58, 120, 93, 26);
		depositPanel.add(title3);
		
		// Button to deposit to account
		depositAccountButton = new JButton("Deposit to Account");
		depositAccountButton.setForeground(new Color(46, 51, 64));
		depositAccountButton.setFont(new Font("Devanagari MT", Font.ITALIC, 19));
		depositAccountButton.setFocusPainted(false);
		depositAccountButton.setActionCommand("depositAccount");
		depositAccountButton.addActionListener(this);
		depositAccountButton.setBounds(30, 298, 190, 50);
		depositAccountPanel.add(depositAccountButton);
		
		// Button to return to main menu
		returnButton3 = new JButton("Main Menu");
		returnButton3.setForeground(new Color(91, 105, 130));
		returnButton3.setFont(new Font("Devanagari MT", Font.ITALIC, 19));
		returnButton3.setFocusPainted(false);
		returnButton3.setActionCommand("return");
		returnButton3.addActionListener(this);
		returnButton3.setBounds(221, 298, 163, 50);
		depositAccountPanel.add(returnButton3);
		
		//---------------------------------------------------------------------------------------
		//WITHDRAWAL FROM ACCOUNT WINDOW CONTENTS:
		
		// Panel used to withdrawal from bank account
		withdrawalAccountPanel = new JPanel();
		withdrawalAccountPanel.setBorder(new LineBorder(new Color(97, 106, 138), 1, true));
		withdrawalAccountPanel.setBackground(new Color(254, 255, 255));
		withdrawalAccountPanel.setBounds(20, 17, 410, 368);
		mainPanel.add(withdrawalAccountPanel);
		withdrawalAccountPanel.setLayout(null);
		withdrawalAccountPanel.setVisible(false);
		
		// Header text for withdrawal account screen
		withdrawalAccountHeader = new JLabel("────୨ৎ Withdrawal from Account: ୨ৎ────");
		withdrawalAccountHeader.setForeground(new Color(88, 102, 129));
		withdrawalAccountHeader.setFont(new Font("Snell Roundhand", Font.PLAIN, 23));
		withdrawalAccountHeader.setBounds(31, 21, 353, 22);
		withdrawalAccountPanel.add(withdrawalAccountHeader);
		
		// Inner withdrawal panel
		withdrawalPanel = new JPanel();
		withdrawalPanel.setBackground(new Color(240, 245, 252));
		withdrawalPanel.setBounds(31, 70, 353, 216);
		withdrawalAccountPanel.add(withdrawalPanel);
		withdrawalPanel.setLayout(null);
		
		// Account info header
		accountLabel4 = new JLabel("Account Information:");
		accountLabel4.setForeground(new Color(121, 136, 153));
		accountLabel4.setFont(new Font("Devanagari MT", Font.PLAIN, 15));
		accountLabel4.setBounds(103, 6, 137, 26);
		withdrawalPanel.add(accountLabel4);
		
		// Account ID header
		accountIDHeader2 = new JLabel("Account ID:");
		accountIDHeader2.setForeground(new Color(54, 59, 67));
		accountIDHeader2.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		accountIDHeader2.setBounds(20, 38, 103, 26);
		withdrawalPanel.add(accountIDHeader2);
		
		// Input box for account ID
		accountIDBox2 = new JTextField();
		accountIDBox2.setFont(new Font("Devanagari MT", Font.PLAIN, 13));
		accountIDBox2.setColumns(10);
		accountIDBox2.setBounds(20, 63, 311, 36);
		withdrawalPanel.add(accountIDBox2);
		
		// Input box for withdrawal amount
		withdrawalBox = new JTextField();
		withdrawalBox.setFont(new Font("Devanagari MT", Font.PLAIN, 13));
		withdrawalBox.setColumns(10);
		withdrawalBox.setBounds(20, 142, 311, 36);
		withdrawalPanel.add(withdrawalBox);
		
		// Withdrawal header
		withdrawalHeader = new JLabel("Withdrawal Amount ($):");
		withdrawalHeader.setForeground(new Color(54, 59, 67));
		withdrawalHeader.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		withdrawalHeader.setBounds(20, 117, 176, 26);
		withdrawalPanel.add(withdrawalHeader);
		
		// Error label for invalid info
		errorLabel3 = new JLabel("Information provided is invalid.");
		errorLabel3.setFont(new Font("Devanagari MT", Font.PLAIN, 13));
		errorLabel3.setBounds(83, 190, 204, 16);
		withdrawalPanel.add(errorLabel3);
		errorLabel3.setForeground(new Color(201, 133, 153));
		errorLabel3.setVisible(false);
		
		// Success label
		successWithdrawalLabel = new JLabel("");
		successWithdrawalLabel.setForeground(new Color(66, 70, 79));
		successWithdrawalLabel.setFont(new Font("Devanagari MT", Font.PLAIN, 17));
		successWithdrawalLabel.setBounds(124, 32, 250, 146);
		withdrawalPanel.add(successWithdrawalLabel);
		
		// Info label
		title12 = new JLabel("Account ID:");
		title12.setForeground(new Color(115, 121, 136));
		title12.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		title12.setBounds(33, 67, 93, 26);
		withdrawalPanel.add(title12);
		
		// Info label
		title22 = new JLabel("Name:");
		title22.setForeground(new Color(115, 121, 136));
		title22.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		title22.setBounds(70, 95, 51, 26);
		withdrawalPanel.add(title22);
		
		// Info label
		title32 = new JLabel("Balance:");
		title32.setForeground(new Color(115, 121, 136));
		title32.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		title32.setBounds(58, 120, 93, 26);
		withdrawalPanel.add(title32);
		
		// Button to withdrawal from account
		withdrawalAccountButton = new JButton("Withdrawal From Account");
		withdrawalAccountButton.setForeground(new Color(46, 51, 64));
		withdrawalAccountButton.setFont(new Font("Devanagari MT", Font.ITALIC, 15));
		withdrawalAccountButton.setFocusPainted(false);
		withdrawalAccountButton.setActionCommand("withdrawalAccount");
		withdrawalAccountButton.addActionListener(this);
		withdrawalAccountButton.setBounds(30, 298, 190, 50);
		withdrawalAccountPanel.add(withdrawalAccountButton);
		
		// Button to return to main menu
		returnButton4 = new JButton("Main Menu");
		returnButton4.setForeground(new Color(91, 105, 130));
		returnButton4.setFont(new Font("Devanagari MT", Font.ITALIC, 19));
		returnButton4.setFocusPainted(false);
		returnButton4.setActionCommand("return");
		returnButton4.addActionListener(this);
		returnButton4.setBounds(221, 298, 163, 50);
		withdrawalAccountPanel.add(returnButton4);
		
		//---------------------------------------------------------------------------------------
		// BALANCE ACCOUNT WINDOW CONTENTS
		
		// Panel used to check account balance
		balanceAccountPanel = new JPanel();
		balanceAccountPanel.setBorder(new LineBorder(new Color(97, 106, 138), 1, true));
		balanceAccountPanel.setBackground(new Color(254, 255, 255));
		balanceAccountPanel.setBounds(20, 17, 410, 368);
		mainPanel.add(balanceAccountPanel);
		balanceAccountPanel.setLayout(null);
		
		// Header text for balance screen
		balanceAccountHeader = new JLabel("───୨ৎ Check Account Balance: ୨ৎ────");
		balanceAccountHeader.setForeground(new Color(88, 102, 129));
		balanceAccountHeader.setFont(new Font("Snell Roundhand", Font.PLAIN, 23));
		balanceAccountHeader.setBounds(31, 21, 353, 22);
		balanceAccountPanel.add(balanceAccountHeader);
		
		// Inner balance panel
		balancePanel = new JPanel();
		balancePanel.setBackground(new Color(240, 245, 252));
		balancePanel.setBounds(31, 66, 353, 219);
		balanceAccountPanel.add(balancePanel);
		balancePanel.setLayout(null);
		
		// Account ID header
		accountIDLabel2 = new JLabel("Account ID:");
		accountIDLabel2.setForeground(new Color(54, 59, 67));
		accountIDLabel2.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		accountIDLabel2.setBounds(16, 31, 311, 26);
		balancePanel.add(accountIDLabel2);
		
		// Input box for account ID
		accountBalanceBox = new JTextField();
		accountBalanceBox.setFont(new Font("Devanagari MT", Font.PLAIN, 13));
		accountBalanceBox.setColumns(10);
		accountBalanceBox.setBounds(16, 58, 311, 37);
		balancePanel.add(accountBalanceBox);
		
		// Account info header
		accountLabel_1_1 = new JLabel("Account Information:");
		accountLabel_1_1.setForeground(new Color(121, 136, 153));
		accountLabel_1_1.setFont(new Font("Devanagari MT", Font.PLAIN, 15));
		accountLabel_1_1.setBounds(98, 6, 137, 26);
		balancePanel.add(accountLabel_1_1);
		
		// Most inner balance panel
		balanceInfoPanel = new JPanel();
		balanceInfoPanel.setBackground(new Color(255, 255, 255));
		balanceInfoPanel.setBounds(23, 107, 300, 94);
		balancePanel.add(balanceInfoPanel);
		balanceInfoPanel.setLayout(null);
		
		// Successful balance message
		successBalanceLabel = new JLabel("");
		successBalanceLabel.setForeground(new Color(66, 70, 79));
		successBalanceLabel.setFont(new Font("Devanagari MT", Font.PLAIN, 16));
		successBalanceLabel.setBounds(83, 8, 211, 77);
		balanceInfoPanel.add(successBalanceLabel);
		
		// Info label
		title12_1 = new JLabel("Account ID:");
		title12_1.setForeground(new Color(115, 121, 136));
		title12_1.setFont(new Font("Devanagari MT", Font.ITALIC, 14));
		title12_1.setBounds(6, 11, 93, 26);
		balanceInfoPanel.add(title12_1);
		
		// Info label
		title22_1 = new JLabel("Name:");
		title22_1.setForeground(new Color(115, 121, 136));
		title22_1.setFont(new Font("Devanagari MT", Font.ITALIC, 14));
		title22_1.setBounds(38, 35, 51, 26);
		balanceInfoPanel.add(title22_1);
		
		// Info label
		title32_1 = new JLabel("Balance:");
		title32_1.setForeground(new Color(115, 121, 136));
		title32_1.setFont(new Font("Devanagari MT", Font.ITALIC, 14));
		title32_1.setBounds(27, 62, 93, 26);
		balanceInfoPanel.add(title32_1);
		
		// Button to check account balance
		balanceAccountButton = new JButton("Check Balance");
		balanceAccountButton.setForeground(new Color(46, 51, 64));
		balanceAccountButton.setFont(new Font("Devanagari MT", Font.ITALIC, 19));
		balanceAccountButton.setFocusPainted(false);
		balanceAccountButton.setActionCommand("checkBalance");
		balanceAccountButton.addActionListener(this);
		balanceAccountButton.setBounds(31, 293, 197, 50);
		balanceAccountPanel.add(balanceAccountButton);
		
		// Button to return to main menu
		returnButton_1 = new JButton("Main Menu");
		returnButton_1.setForeground(new Color(91, 105, 130));
		returnButton_1.setFont(new Font("Devanagari MT", Font.ITALIC, 19));
		returnButton_1.setFocusPainted(false);
		returnButton_1.setActionCommand("return");
		returnButton_1.addActionListener(this);
		returnButton_1.setBounds(229, 293, 155, 50);
		balanceAccountPanel.add(returnButton_1);
		balanceAccountPanel.setVisible(false);
		
	}
	
	//---------------------------------------------------------------------------------------
	
	// Method to control visibility of main menu components
		// - When "stat" = true, shows menu
		// - When "stat" = false, hides menu
	private void mainVisibility(boolean stat) {
		
		buttonPanel.setVisible(stat);
		withdrawalButton.setVisible(stat);
		addAccountButton.setVisible(stat);
		depositButton.setVisible(stat);
		removeAccountButton.setVisible(stat);
		balanceButton.setVisible(stat);
		welcomeHeader.setVisible(stat);
		bankHeader.setVisible(stat);
		laceBacking.setVisible(stat);
		selectionHeader.setVisible(stat);
		pearl1.setVisible(stat);
		pearl2.setVisible(stat);
		
	}
	
	//---------------------------------------------------------------------------------------
	
	// Button click events:
	public void actionPerformed(ActionEvent e) {
		
		// Assigns click's action command to "event name"
		String eventName = e.getActionCommand();
		
		//---------------------------------------------------------------------------------------
		// ADD ACCOUNT PANEL ACTIONS:
		
		// If button event name equals add account
		if (eventName.equals("addAccount")) {
			
			// Hide main menu
			mainVisibility(false);
			
			// Show create account panel
			newAccountPanel.setVisible(true);
			
			//Set button's command back to original
			createAccountButton.setActionCommand("createAccount");
			
			// Ensure elements are visible
			accountLabel.setVisible(true);
			firstNameLabel.setVisible(true);
			lastNameLabel.setVisible(true);
			balanceLabel.setVisible(true);
			firstNameBox.setVisible(true);
			lastNameBox.setVisible(true);
			balanceBox.setVisible(true);
			errorLabel.setVisible(false);
			
			// Clear text fields to prep for user input
			firstNameBox.setText("");
			lastNameBox.setText("");
			balanceBox.setText(""); 
			
			// Ensure post event text is hidden
			successLabel.setVisible(false);
			accountIDLabel.setVisible(false);
		}
		
		// If button event name equals create account
		if (eventName.equals("createAccount")) {
			
			// Try to perform action
			try {
				errorLabel.setVisible(false);
				
				// Get input from user
				String firstName = firstNameBox.getText();
				String lastName = lastNameBox.getText();
				double balance = (Double.parseDouble(balanceBox.getText()));
				
				// Create account + call bank class
				// Display created ID to user
				accountIDLabel.setText("Account ID: " + (easySave.addAccount(firstName, lastName, balance)));
				
				// Hide input components after success
				accountLabel.setVisible(false);
				firstNameLabel.setVisible(false);
				lastNameLabel.setVisible(false);
				balanceLabel.setVisible(false);
				firstNameBox.setVisible(false);
				lastNameBox.setVisible(false);
				balanceBox.setVisible(false);
				
				// Display success labels
				successLabel.setVisible(true);
				accountIDLabel.setVisible(true);
				
				// change the button's action command to ensure
				// user does not repeat + create duplicate account
				createAccountButton.setActionCommand("stop");
				
			}
			// Catch errors (such as incorrect format/ info provided)
			catch(Exception e1){ 
				
				// Display error message
				errorLabel.setVisible(true);	
				
				// After 2 seconds, revert error label visibility
				timer.schedule(new TimerTask() {
				    public void run() {
				    	errorLabel.setVisible(false);
				    }
				    
				}, 2000);
			}
		}
		//---------------------------------------------------------------------------------------
		// RETURN BUTTON ACTIONS:
		
		// If button name is equal to return
		if (eventName.equals("return")) {
			
			// Show main menu
			mainVisibility(true);
			
			// Hide all other panels
			newAccountPanel.setVisible(false);
			deleteAccountPanel.setVisible(false);
			depositAccountPanel.setVisible(false);
			withdrawalAccountPanel.setVisible(false);
			balanceAccountPanel.setVisible(false);
			
		}
		//---------------------------------------------------------------------------------------
		//REMOVE ACCOUNT PANEL ACTIONS:
		
		// If button event name is equal to remove account
		if (eventName.equals("removeAccount")) {
			
			// Hide main menu
			mainVisibility(false);
			
			// Show delete account panel
			deleteAccountPanel.setVisible(true);
			
			// Clear text box to prep for user input
			deleteAccountBox.setText("");
		}
		
		// If button event name is equal to delete account
		if (eventName.equals("deleteAccount")) {
			
			// Get input from user
			ID = deleteAccountBox.getText();
			
			// Delete account in object
			// Set result message + display to user
			accountDeletedText.setText(easySave.deleteAccount(ID));
			
			// Clear text box
			deleteAccountBox.setText("");
			
			// Remove result message after 1 second
			timer.schedule(new TimerTask() {
			    public void run() {
			    	accountDeletedText.setText("");
			    }
			    
			}, 1000);
			
		}
		//---------------------------------------------------------------------------------------
		// DEPOSIT ACCOUNT PANEL ACTIONS:
		
		//If button event name is equal to deposit
		if (eventName.equals("deposit")) {
			
			// Set button's command back to original
			depositAccountButton.setActionCommand("depositAccount");
			
			// Hide main menu
			mainVisibility(false);
			
			// Show deposit account panel
			depositAccountPanel.setVisible(true);
			
			// Clear text box to prepare for user input
			accountIDBox.setText("");
			depositBox.setText("");
			accountLabel3.setText("Account information:");
			
			// Ensure correct elements are visible
			errorLabel2.setVisible(false);
			accountLabel3.setVisible(true);
			accountIDHeader.setVisible(true);
			accountIDBox.setVisible(true);
			depositHeader.setVisible(true);
			depositBox.setVisible(true);
			
			// Hide post event labels
			successDepositLabel.setVisible(false);
			title1.setVisible(false);
			title2.setVisible(false);
			title3.setVisible(false);
			
		}
		
		// If button event name is equal to deposit
		if(eventName.equals("depositAccount")) {
			
			// Try to perform action
			try {
				
				// Get input from user
				ID = accountIDBox.getText();
				
				// Get deposit input from user and set to variable amt
				amt = (Double.parseDouble(depositBox.getText()));
				
				// Display result from transaction
				successDepositLabel.setVisible(true);
				title1.setVisible(true);
				title2.setVisible(true);
				title3.setVisible(true);
				
				// Perform transaction and change label to reflect result
				successDepositLabel.setText(easySave.transaction(1, ID, amt));
				accountLabel3.setText("         Success!");
				
				// hide input boxes
				accountIDHeader.setVisible(false);
				accountIDBox.setVisible(false);
				depositHeader.setVisible(false);
				depositBox.setVisible(false);
				errorLabel2.setVisible(false);
				
				// If account was not found
				if(successDepositLabel.getText()== "Account does not exist.") {
					
					// Reposition label to center
					successDepositLabel.setBounds(90, 32, 250, 146);
					
					// Hide info labels (only show "not exist" message)
					accountLabel3.setVisible(false);
					title1.setVisible(false);
					title2.setVisible(false);
					title3.setVisible(false);
					
					// After 1 second, revert panel back to before transaction was performed
					timer.schedule(new TimerTask() {
					    public void run() {
					    	
					    	successDepositLabel.setText("");
					    	
					    	accountIDBox.setText("");
							depositBox.setText("");
							accountLabel3.setText("Account information:");
							
							errorLabel2.setVisible(false);
							
							accountIDHeader.setVisible(true);
							accountIDBox.setVisible(true);
							depositHeader.setVisible(true);
							depositBox.setVisible(true);
							accountLabel3.setVisible(true);
							
							successDepositLabel.setVisible(false);
							title1.setVisible(false);
							title2.setVisible(false);
							title3.setVisible(false);
							
							successDepositLabel.setBounds(124, 32, 250, 146);
					    	
					    }
					}, 1000);
				}
				// If transaction was successful
				else {
					
					// Change button's action command to ensure user does not duplicate transaction 
					depositAccountButton.setActionCommand("stop");
				}
			}
			
			// Catch errors (such as incorrect format/ info provided)
			catch(Exception e1) {
				
				// Display error message
				errorLabel2.setVisible(true);
				
				// Hide after 1 second
				timer.schedule(new TimerTask() {
				    public void run() {
				    	errorLabel2.setVisible(false);
				    }
				    
				}, 1000);
				
			}
		}	
		
		//---------------------------------------------------------------------------------------
		// WITHDRAWAL PANEL ACTIONS:
		
		// If button event name equals withdrawal
		if (eventName.equals("withdrawal")) {
			
			// Set button's command back to original
			withdrawalAccountButton.setActionCommand("withdrawalAccount");
			
			// Hide main menu
			mainVisibility(false);
			
			// Show withdrawal panel
			withdrawalAccountPanel.setVisible(true);
			
			// Clear text box to prep for user input
			accountIDBox2.setText("");
			withdrawalBox.setText("");
			accountLabel4.setText("Account information:");
			
			// Ensure correct elements are displayed
			errorLabel3.setVisible(false);
			accountLabel4.setVisible(true);
			accountIDHeader2.setVisible(true);
			accountIDBox2.setVisible(true);
			withdrawalHeader.setVisible(true);
			withdrawalBox.setVisible(true);
			
			// Hide post event labels
			successWithdrawalLabel.setVisible(false);
			title12.setVisible(false);
			title22.setVisible(false);
			title32.setVisible(false);
			
		}
		
		// If button event name equals withdrawal account
		if(eventName.equals("withdrawalAccount")) {
			
			// Try to perform action
			try {
				
				// Get input from user
				ID = accountIDBox2.getText();
				
				// Get withdrawal amount from user
				amt = (Double.parseDouble(withdrawalBox.getText()));
				
				//Display success labels
				successWithdrawalLabel.setVisible(true);
				title12.setVisible(true);
				title22.setVisible(true);
				title32.setVisible(true);
				
				// Perform transaction + set success label to result
				successWithdrawalLabel.setText(easySave.transaction(2, ID, amt));
				accountLabel4.setText("         Success!");
				
				// Hide input elements
				accountIDHeader2.setVisible(false);
				accountIDBox2.setVisible(false);
				withdrawalHeader.setVisible(false);
				withdrawalBox.setVisible(false);
				errorLabel3.setVisible(false);
				
				// If transaction resulted in account not existing, or inadequate funds,
				if((successWithdrawalLabel.getText()== "Account does not exist.")|| 
				(successWithdrawalLabel.getText()== "Not enough funds in account.") ) {
					
					// hide info labels to isolate message
					successWithdrawalLabel.setBounds(80, 32, 250, 146);
					accountLabel4.setVisible(false);
					title12.setVisible(false);
					title22.setVisible(false);
					title32.setVisible(false);
					
					// After 1 second, revert panel back to before transaction
					timer.schedule(new TimerTask() {
					    public void run() {
					    	
					    	successWithdrawalLabel.setText("");
					    	
					    	accountIDBox2.setText("");
							withdrawalBox.setText("");
							accountLabel4.setText("Account information:");
							
							errorLabel3.setVisible(false);
							
							accountIDHeader2.setVisible(true);
							accountIDBox2.setVisible(true);
							withdrawalHeader.setVisible(true);
							withdrawalBox.setVisible(true);
							accountLabel4.setVisible(true);
							
							successWithdrawalLabel.setVisible(false);
							title12.setVisible(false);
							title22.setVisible(false);
							title32.setVisible(false);
							
							successWithdrawalLabel.setBounds(124, 32, 250, 146);
					    }
					}, 1000);
				}
				
				// If transaction was successful, change button's action command to prevent duplicate withdrawals
				else {
					withdrawalAccountButton.setActionCommand("stop");
				}
				
			}
			// Catch errors (such as incorrect format/ info provided)
			catch(Exception e1) {
				
				// Show error message
				errorLabel3.setVisible(true);
				
				// Hide after 1 second
				timer.schedule(new TimerTask() {
				    public void run() {
				    	errorLabel3.setVisible(false);
				    }
				}, 1000);
			}
		}	
		
		//---------------------------------------------------------------------------------------
		// BALANCE PANEL ACTIONS:
		
		// If button event name equals balance
		if (eventName.equals("balance")) {
			
			// Hide main menu
			mainVisibility(false);
			
			// Clear text boxes + show balance panel
			balanceAccountPanel.setVisible(true);
			balanceInfoPanel.setVisible(false);
			accountBalanceBox.setText("");
			
		}
		
		// If button event name equals check balance
		if(eventName.equals("checkBalance")) {
			
			// Get input from user
			ID = accountBalanceBox.getText();
			
			// Check account balance + set label to reflect result
			successBalanceLabel.setText(easySave.checkBalance(ID));
			
			// Display result panel
			balanceInfoPanel.setVisible(true);
			title12_1.setVisible(true);
			title22_1.setVisible(true);
			title32_1.setVisible(true);
			accountBalanceBox.setText("");
			successBalanceLabel.setBounds(83, 8, 211, 82);
			
			// If account was not found, hide info labels to isolate message
			if(successBalanceLabel.getText()== "Account does not exist.") {
				successBalanceLabel.setBounds(63, 8, 211, 82);
				title12_1.setVisible(false);
				title22_1.setVisible(false);
				title32_1.setVisible(false);
			}	
		}
	}
}

