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
import javax.swing.JTextArea;

public class LocalBank implements ActionListener{

	String ID;
	Double amt;
	
	JFrame frmLocalbank;
	
	JPanel mainPanel, buttonPanel, newAccountPanel, accountPanel, deletePanel, 
	depositAccountPanel,deleteAccountPanel, depositPanel, withdrawalAccountPanel,
	withdrawalPanel, balanceAccountPanel, balanceInfoPanel,balancePanel ;

	
	JButton withdrawalButton,addAccountButton, depositButton, removeAccountButton,
	balanceButton, createAccountButton, returnButton, returnButton2, depositAccountButton,
	returnButton3, deleteAccountButton, withdrawalAccountButton, returnButton4,
	balanceAccountButton, returnButton_1;
	
	JLabel welcomeHeader, bankHeader, laceBacking, selectionHeader, pearl1, pearl2,
	lastNameLabel, balanceLabel, accountLabel, firstNameLabel, addAccountHeader, errorLabel,
	successLabel, accountIDLabel, depositHeader, depositAccountHeader, accountLabel3, 
	accountIDHeader, errorLabel2, successDepositLabel, withdrawalAccountHeader, accountLabel4,
	accountIDHeader2, withdrawalHeader, errorLabel3, successWithdrawalLabel, title12,title22,
	title32, accountLabel_1_1, successBalanceLabel,title1,title2,title3,balanceAccountHeader, 
	accountIDLabel2,title12_1, title22_1, title32_1 ;
	
	JTextField firstNameBox, lastNameBox, balanceBox, accountIDBox2, withdrawalBox,accountIDBox, 
	depositBox, accountBalanceBox;
	
	private JLabel deleteAccountHeader;
	private JLabel accountLabel2;
	private JLabel accountIDheader;
	private JTextField deleteAccountBox;
	private JLabel accountDeletedText;
	
	Bank easySave = new Bank();
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLocalbank = new JFrame();
		frmLocalbank.setTitle("LocalBankGUI");
		frmLocalbank.setBounds(100, 100, 450, 435);
		frmLocalbank.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new JPanel();
		mainPanel.setForeground(new Color(0, 0, 0));
		mainPanel.setBackground(new Color(243, 248, 255));
		frmLocalbank.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
		
		welcomeHeader = new JLabel("welcome to:");
		welcomeHeader.setForeground(new Color(58, 71, 96));
		welcomeHeader.setFont(new Font("Devanagari MT", Font.PLAIN, 16));
		welcomeHeader.setBounds(186, 21, 83, 16);
		mainPanel.add(welcomeHeader);
		
		bankHeader = new JLabel("Your Local Bank.");
		bankHeader.setFont(new Font("Snell Roundhand", Font.PLAIN, 35));
		bankHeader.setBounds(106, 82, 277, 41);
		mainPanel.add(bankHeader);
		
		laceBacking = new JLabel("");
		laceBacking.setIcon(new ImageIcon(LocalBank.class.getResource("/Mastery/lace.png")));
		laceBacking.setBounds(40, 43, 366, 126);
		mainPanel.add(laceBacking);
		
		selectionHeader = new JLabel("Please select an option to get started:");
		selectionHeader.setForeground(new Color(86, 97, 140));
		selectionHeader.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		selectionHeader.setBounds(102, 181, 255, 26);
		mainPanel.add(selectionHeader);
		
		buttonPanel = new JPanel();
		buttonPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		buttonPanel.setBackground(new Color(193, 205, 217));
		buttonPanel.setBounds(40, 212, 366, 148);
		mainPanel.add(buttonPanel);
		buttonPanel.setLayout(null);
		
		withdrawalButton = new JButton("Withdrawal");
		withdrawalButton.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		withdrawalButton.setFocusPainted(false);
		withdrawalButton.setBounds(6, 6, 117, 64);
		withdrawalButton.setActionCommand("withdrawal");
		withdrawalButton.addActionListener(this);
		buttonPanel.add(withdrawalButton);
		
		addAccountButton = new JButton("Add Account");
		addAccountButton.setFont(new Font("Devanagari MT", Font.ITALIC, 14));
		addAccountButton.setFocusPainted(false);
		addAccountButton.setBounds(66, 71, 117, 71);
		addAccountButton.setActionCommand("addAccount");
		addAccountButton.addActionListener(this);
		buttonPanel.add(addAccountButton);
		
		depositButton = new JButton("Deposit");
		depositButton.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		depositButton.setFocusPainted(false);
		depositButton.setBounds(124, 6, 117, 64);
		depositButton.setActionCommand("deposit");
		depositButton.addActionListener(this);
		buttonPanel.add(depositButton);
		
		removeAccountButton = new JButton("Remove Account");
		removeAccountButton.setFont(new Font("Devanagari MT", Font.ITALIC, 13));
		removeAccountButton.setFocusPainted(false);
		removeAccountButton.setBounds(184, 71, 117, 71);
		removeAccountButton.setActionCommand("removeAccount");
		removeAccountButton.addActionListener(this);
		buttonPanel.add(removeAccountButton);
		
		balanceButton = new JButton("Check Balance");
		balanceButton.setFont(new Font("Devanagari MT", Font.ITALIC, 14));
		balanceButton.setFocusPainted(false);
		balanceButton.setBounds(243, 6, 117, 64);
		balanceButton.setActionCommand("balance");
		balanceButton.addActionListener(this);
		buttonPanel.add(balanceButton);
		
		pearl1 = new JLabel("");
		pearl1.setIcon(new ImageIcon(LocalBank.class.getResource("/Mastery/pearl.png")));
		pearl1.setBounds(6, 71, 61, 60);
		buttonPanel.add(pearl1);
		
		pearl2 = new JLabel("");
		pearl2.setIcon(new ImageIcon(LocalBank.class.getResource("/Mastery/pearl.png")));
		pearl2.setBounds(305, 71, 61, 60);
		buttonPanel.add(pearl2);
		
		//---------------------------------------------------------------------------------------
		
		newAccountPanel = new JPanel();
		newAccountPanel.setBorder(new LineBorder(new Color(97, 106, 138), 1, true));
		newAccountPanel.setBackground(new Color(254, 255, 255));
		newAccountPanel.setBounds(20, 17, 410, 368);
		mainPanel.add(newAccountPanel);
		newAccountPanel.setLayout(null);
		newAccountPanel.setVisible(false);
		
		addAccountHeader = new JLabel("────୨ৎ Create New Account: ୨ৎ────");
		addAccountHeader.setForeground(new Color(88, 102, 129));
		addAccountHeader.setFont(new Font("Snell Roundhand", Font.PLAIN, 23));
		addAccountHeader.setBounds(34, 16, 353, 22);
		newAccountPanel.add(addAccountHeader);
		
		accountPanel = new JPanel();
		accountPanel.setBackground(new Color(240, 245, 252));
		accountPanel.setBounds(23, 56, 364, 238);
		newAccountPanel.add(accountPanel);
		accountPanel.setLayout(null);
		
		accountLabel = new JLabel("Account Information:");
		accountLabel.setForeground(new Color(121, 136, 153));
		accountLabel.setFont(new Font("Devanagari MT", Font.PLAIN, 15));
		accountLabel.setBounds(18, 6, 137, 26);
		accountPanel.add(accountLabel);
		
		firstNameLabel = new JLabel("First name:");
		firstNameLabel.setForeground(new Color(54, 59, 67));
		firstNameLabel.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		firstNameLabel.setBounds(18, 32, 76, 26);
		accountPanel.add(firstNameLabel);
		
		firstNameBox = new JTextField();
		firstNameBox.setFont(new Font("Devanagari MT", Font.PLAIN, 13));
		firstNameBox.setBounds(18, 56, 327, 36);
		accountPanel.add(firstNameBox);
		firstNameBox.setColumns(10);
		
		lastNameBox = new JTextField();
		lastNameBox.setFont(new Font("Devanagari MT", Font.PLAIN, 13));
		lastNameBox.setColumns(10);
		lastNameBox.setBounds(18, 125, 327, 36);
		accountPanel.add(lastNameBox);
		
		lastNameLabel = new JLabel("Last name:");
		lastNameLabel.setForeground(new Color(54, 59, 67));
		lastNameLabel.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		lastNameLabel.setBounds(18, 100, 76, 26);
		accountPanel.add(lastNameLabel);
		
		balanceBox = new JTextField();
		balanceBox.setFont(new Font("Devanagari MT", Font.PLAIN, 13));
		balanceBox.setColumns(10);
		balanceBox.setBounds(18, 188, 327, 36);
		accountPanel.add(balanceBox);
		
		balanceLabel = new JLabel("Beginning Balance ($):");
		balanceLabel.setForeground(new Color(54, 59, 67));
		balanceLabel.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		balanceLabel.setBounds(18, 164, 178, 26);
		accountPanel.add(balanceLabel);
		
		errorLabel = new JLabel("Information is invalid.");
		errorLabel.setFont(new Font("Devanagari MT", Font.PLAIN, 13));
		errorLabel.setBounds(180, 8, 178, 16);
		errorLabel.setForeground(new Color(201, 133, 153));
		accountPanel.add(errorLabel);
		errorLabel.setVisible(false);
		
		successLabel = new JLabel("୨ৎ Account successfully created! ୨ৎ");
		successLabel.setForeground(new Color(88, 102, 129));
		successLabel.setFont(new Font("Snell Roundhand", Font.PLAIN, 23));
		successLabel.setBounds(28, 44, 353, 44);
		accountPanel.add(successLabel);
		successLabel.setVisible(false);
		
		accountIDLabel = new JLabel("");
		accountIDLabel.setForeground(new Color(65, 75, 98));
		accountIDLabel.setFont(new Font("Devanagari MT", Font.PLAIN, 28));
		accountIDLabel.setBounds(56, 88, 252, 94);
		accountPanel.add(accountIDLabel);
		accountIDLabel.setVisible(false);
		
		
		createAccountButton = new JButton("Create Account");
		createAccountButton.setForeground(new Color(46, 51, 64));
		createAccountButton.setFont(new Font("Devanagari MT", Font.ITALIC, 19));
		createAccountButton.setFocusPainted(false);
		createAccountButton.setBounds(23, 300, 197, 50);
		createAccountButton.setActionCommand("createAccount");
		createAccountButton.addActionListener(this);
		newAccountPanel.add(createAccountButton);
		
		returnButton = new JButton("Main Menu");
		returnButton.setForeground(new Color(91, 105, 130));
		returnButton.setFont(new Font("Devanagari MT", Font.ITALIC, 19));
		returnButton.setFocusPainted(false);
		returnButton.setBounds(224, 300, 163, 50);
		returnButton.setActionCommand("return");
		returnButton.addActionListener(this);
		newAccountPanel.add(returnButton);
		
		//---------------------------------------------------------------------------------------
		
		deleteAccountPanel = new JPanel();
		deleteAccountPanel.setBorder(new LineBorder(new Color(97, 106, 138), 1, true));
		deleteAccountPanel.setBackground(new Color(254, 255, 255));
		deleteAccountPanel.setBounds(20, 17, 410, 368);
		mainPanel.add(deleteAccountPanel);
		deleteAccountPanel.setLayout(null);
		deleteAccountPanel.setVisible(false);
		
		deleteAccountHeader = new JLabel("────୨ৎ Delete Exisiting Account: ୨ৎ────");
		deleteAccountHeader.setForeground(new Color(88, 102, 129));
		deleteAccountHeader.setFont(new Font("Snell Roundhand", Font.PLAIN, 23));
		deleteAccountHeader.setBounds(19, 17, 373, 33);
		deleteAccountPanel.add(deleteAccountHeader);
		
		deletePanel = new JPanel();
		deletePanel.setBackground(new Color(240, 245, 252));
		deletePanel.setBounds(29, 62, 353, 192);
		deleteAccountPanel.add(deletePanel);
		deletePanel.setLayout(null);
		
		accountLabel2 = new JLabel("Account Information:");
		accountLabel2.setForeground(new Color(121, 136, 153));
		accountLabel2.setFont(new Font("Devanagari MT", Font.PLAIN, 15));
		accountLabel2.setBounds(103, 6, 137, 26);
		deletePanel.add(accountLabel2);
		
		accountIDheader = new JLabel("Enter Account ID:");
		accountIDheader.setForeground(new Color(54, 59, 67));
		accountIDheader.setFont(new Font("Devanagari MT", Font.ITALIC, 19));
		accountIDheader.setBounds(20, 41, 176, 26);
		deletePanel.add(accountIDheader);
		
		deleteAccountBox = new JTextField();
		deleteAccountBox.setFont(new Font("Devanagari MT", Font.PLAIN, 20));
		deleteAccountBox.setColumns(10);
		deleteAccountBox.setBounds(20, 79, 309, 62);
		deletePanel.add(deleteAccountBox);
		
		accountDeletedText = new JLabel("");
		accountDeletedText.setForeground(new Color(54, 59, 67));
		accountDeletedText.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		accountDeletedText.setBounds(91, 153, 167, 26);
		deletePanel.add(accountDeletedText);
		
		deleteAccountButton = new JButton("Delete Account");
		deleteAccountButton.setFont(new Font("Devanagari MT", Font.ITALIC, 20));
		deleteAccountButton.setFocusPainted(false);
		deleteAccountButton.setActionCommand("deleteAccount");
		deleteAccountButton.addActionListener(this);
		deleteAccountButton.setBounds(28, 266, 213, 71);
		deleteAccountPanel.add(deleteAccountButton);
		
		returnButton2 = new JButton("Main Menu");
		returnButton2.setForeground(new Color(91, 105, 130));
		returnButton2.setFont(new Font("Devanagari MT", Font.ITALIC, 19));
		returnButton2.setFocusPainted(false);
		returnButton2.setBounds(247, 266, 144, 71);
		returnButton2.setActionCommand("return");
		returnButton2.addActionListener(this);
		deleteAccountPanel.add(returnButton2);
		
//---------------------------------------------------------------------------------------
		depositAccountPanel = new JPanel();
		depositAccountPanel.setBorder(new LineBorder(new Color(97, 106, 138), 1, true));
		depositAccountPanel.setBackground(new Color(254, 255, 255));
		depositAccountPanel.setBounds(20, 17, 410, 368);
		mainPanel.add(depositAccountPanel);
		depositAccountPanel.setLayout(null);
		depositAccountPanel.setVisible(false);
		
		depositAccountHeader = new JLabel("────୨ৎ Deposit To Account: ୨ৎ────");
		depositAccountHeader.setForeground(new Color(88, 102, 129));
		depositAccountHeader.setFont(new Font("Snell Roundhand", Font.PLAIN, 23));
		depositAccountHeader.setBounds(31, 21, 353, 22);
		depositAccountPanel.add(depositAccountHeader);
		
		depositPanel = new JPanel();
		depositPanel.setBackground(new Color(240, 245, 252));
		depositPanel.setBounds(31, 70, 353, 216);
		depositAccountPanel.add(depositPanel);
		depositPanel.setLayout(null);
		
		accountLabel3 = new JLabel("Account Information:");
		accountLabel3.setForeground(new Color(121, 136, 153));
		accountLabel3.setFont(new Font("Devanagari MT", Font.PLAIN, 15));
		accountLabel3.setBounds(103, 6, 137, 26);
		depositPanel.add(accountLabel3);
		
		accountIDHeader = new JLabel("Account ID:");
		accountIDHeader.setForeground(new Color(54, 59, 67));
		accountIDHeader.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		accountIDHeader.setBounds(20, 38, 103, 26);
		depositPanel.add(accountIDHeader);
		
		accountIDBox = new JTextField();
		accountIDBox.setFont(new Font("Devanagari MT", Font.PLAIN, 13));
		accountIDBox.setColumns(10);
		accountIDBox.setBounds(20, 63, 311, 36);
		depositPanel.add(accountIDBox);
		
		depositBox = new JTextField();
		depositBox.setFont(new Font("Devanagari MT", Font.PLAIN, 13));
		depositBox.setColumns(10);
		depositBox.setBounds(20, 142, 311, 36);
		depositPanel.add(depositBox);
		
		depositHeader = new JLabel("Deposit Amount ($):");
		depositHeader.setForeground(new Color(54, 59, 67));
		depositHeader.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		depositHeader.setBounds(20, 117, 176, 26);
		depositPanel.add(depositHeader);
		
		errorLabel2 = new JLabel("Information provided is invalid.");
		errorLabel2.setFont(new Font("Devanagari MT", Font.PLAIN, 13));
		errorLabel2.setBounds(83, 190, 204, 16);
		depositPanel.add(errorLabel2);
		errorLabel2.setForeground(new Color(201, 133, 153));
		errorLabel2.setVisible(false);
		
		successDepositLabel = new JLabel("");
		successDepositLabel.setForeground(new Color(66, 70, 79));
		successDepositLabel.setFont(new Font("Devanagari MT", Font.PLAIN, 17));
		successDepositLabel.setBounds(124, 32, 250, 146);
		depositPanel.add(successDepositLabel);
		
		title1 = new JLabel("Account ID:");
		title1.setForeground(new Color(115, 121, 136));
		title1.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		title1.setBounds(33, 67, 93, 26);
		depositPanel.add(title1);
		
		title2 = new JLabel("Name:");
		title2.setForeground(new Color(115, 121, 136));
		title2.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		title2.setBounds(70, 95, 51, 26);
		depositPanel.add(title2);
		
		title3 = new JLabel("Balance:");
		title3.setForeground(new Color(115, 121, 136));
		title3.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		title3.setBounds(58, 120, 93, 26);
		depositPanel.add(title3);
		
		
		depositAccountButton = new JButton("Deposit to Account");
		depositAccountButton.setForeground(new Color(46, 51, 64));
		depositAccountButton.setFont(new Font("Devanagari MT", Font.ITALIC, 19));
		depositAccountButton.setFocusPainted(false);
		depositAccountButton.setActionCommand("depositAccount");
		depositAccountButton.addActionListener(this);
		depositAccountButton.setBounds(30, 298, 190, 50);
		depositAccountPanel.add(depositAccountButton);
		
		returnButton3 = new JButton("Main Menu");
		returnButton3.setForeground(new Color(91, 105, 130));
		returnButton3.setFont(new Font("Devanagari MT", Font.ITALIC, 19));
		returnButton3.setFocusPainted(false);
		returnButton3.setActionCommand("return");
		returnButton3.addActionListener(this);
		returnButton3.setBounds(221, 298, 163, 50);
		depositAccountPanel.add(returnButton3);
		
		//---------------------------------------------------------------------------------------
		
		withdrawalAccountPanel = new JPanel();
		withdrawalAccountPanel.setBorder(new LineBorder(new Color(97, 106, 138), 1, true));
		withdrawalAccountPanel.setBackground(new Color(254, 255, 255));
		withdrawalAccountPanel.setBounds(20, 17, 410, 368);
		mainPanel.add(withdrawalAccountPanel);
		withdrawalAccountPanel.setLayout(null);
		withdrawalAccountPanel.setVisible(false);
		
		withdrawalAccountHeader = new JLabel("────୨ৎ Withdrawal from Account: ୨ৎ────");
		withdrawalAccountHeader.setForeground(new Color(88, 102, 129));
		withdrawalAccountHeader.setFont(new Font("Snell Roundhand", Font.PLAIN, 23));
		withdrawalAccountHeader.setBounds(31, 21, 353, 22);
		withdrawalAccountPanel.add(withdrawalAccountHeader);
		
		withdrawalPanel = new JPanel();
		withdrawalPanel.setBackground(new Color(240, 245, 252));
		withdrawalPanel.setBounds(31, 70, 353, 216);
		withdrawalAccountPanel.add(withdrawalPanel);
		withdrawalPanel.setLayout(null);
		
		accountLabel4 = new JLabel("Account Information:");
		accountLabel4.setForeground(new Color(121, 136, 153));
		accountLabel4.setFont(new Font("Devanagari MT", Font.PLAIN, 15));
		accountLabel4.setBounds(103, 6, 137, 26);
		withdrawalPanel.add(accountLabel4);
		
		accountIDHeader2 = new JLabel("Account ID:");
		accountIDHeader2.setForeground(new Color(54, 59, 67));
		accountIDHeader2.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		accountIDHeader2.setBounds(20, 38, 103, 26);
		withdrawalPanel.add(accountIDHeader2);
		
		accountIDBox2 = new JTextField();
		accountIDBox2.setFont(new Font("Devanagari MT", Font.PLAIN, 13));
		accountIDBox2.setColumns(10);
		accountIDBox2.setBounds(20, 63, 311, 36);
		withdrawalPanel.add(accountIDBox2);
		
		withdrawalBox = new JTextField();
		withdrawalBox.setFont(new Font("Devanagari MT", Font.PLAIN, 13));
		withdrawalBox.setColumns(10);
		withdrawalBox.setBounds(20, 142, 311, 36);
		withdrawalPanel.add(withdrawalBox);
		
		withdrawalHeader = new JLabel("Withdrawal Amount ($):");
		withdrawalHeader.setForeground(new Color(54, 59, 67));
		withdrawalHeader.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		withdrawalHeader.setBounds(20, 117, 176, 26);
		withdrawalPanel.add(withdrawalHeader);
		
		errorLabel3 = new JLabel("Information provided is invalid.");
		errorLabel3.setFont(new Font("Devanagari MT", Font.PLAIN, 13));
		errorLabel3.setBounds(83, 190, 204, 16);
		withdrawalPanel.add(errorLabel3);
		errorLabel3.setForeground(new Color(201, 133, 153));
		errorLabel3.setVisible(false);
		
		successWithdrawalLabel = new JLabel("");
		successWithdrawalLabel.setForeground(new Color(66, 70, 79));
		successWithdrawalLabel.setFont(new Font("Devanagari MT", Font.PLAIN, 17));
		successWithdrawalLabel.setBounds(124, 32, 250, 146);
		withdrawalPanel.add(successWithdrawalLabel);
		
		title12 = new JLabel("Account ID:");
		title12.setForeground(new Color(115, 121, 136));
		title12.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		title12.setBounds(33, 67, 93, 26);
		withdrawalPanel.add(title12);
		
		title22 = new JLabel("Name:");
		title22.setForeground(new Color(115, 121, 136));
		title22.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		title22.setBounds(70, 95, 51, 26);
		withdrawalPanel.add(title22);
		
		title32 = new JLabel("Balance:");
		title32.setForeground(new Color(115, 121, 136));
		title32.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		title32.setBounds(58, 120, 93, 26);
		withdrawalPanel.add(title32);
		
		
		withdrawalAccountButton = new JButton("Withdrawal From Account");
		withdrawalAccountButton.setForeground(new Color(46, 51, 64));
		withdrawalAccountButton.setFont(new Font("Devanagari MT", Font.ITALIC, 15));
		withdrawalAccountButton.setFocusPainted(false);
		withdrawalAccountButton.setActionCommand("withdrawalAccount");
		withdrawalAccountButton.addActionListener(this);
		withdrawalAccountButton.setBounds(30, 298, 190, 50);
		withdrawalAccountPanel.add(withdrawalAccountButton);
		
		returnButton4 = new JButton("Main Menu");
		returnButton4.setForeground(new Color(91, 105, 130));
		returnButton4.setFont(new Font("Devanagari MT", Font.ITALIC, 19));
		returnButton4.setFocusPainted(false);
		returnButton4.setActionCommand("return");
		returnButton4.addActionListener(this);
		returnButton4.setBounds(221, 298, 163, 50);
		withdrawalAccountPanel.add(returnButton4);
		
		//---------------------------------------------------------------------------------------

		balanceAccountPanel = new JPanel();
		balanceAccountPanel.setBorder(new LineBorder(new Color(97, 106, 138), 1, true));
		balanceAccountPanel.setBackground(new Color(254, 255, 255));
		balanceAccountPanel.setBounds(20, 17, 410, 368);
		mainPanel.add(balanceAccountPanel);
		balanceAccountPanel.setLayout(null);
		
		balanceAccountHeader = new JLabel("───୨ৎ Check Account Balance: ୨ৎ────");
		balanceAccountHeader.setForeground(new Color(88, 102, 129));
		balanceAccountHeader.setFont(new Font("Snell Roundhand", Font.PLAIN, 23));
		balanceAccountHeader.setBounds(31, 21, 353, 22);
		balanceAccountPanel.add(balanceAccountHeader);
		
		balancePanel = new JPanel();
		balancePanel.setBackground(new Color(240, 245, 252));
		balancePanel.setBounds(31, 66, 353, 219);
		balanceAccountPanel.add(balancePanel);
		balancePanel.setLayout(null);
		
		accountIDLabel2 = new JLabel("Account ID:");
		accountIDLabel2.setForeground(new Color(54, 59, 67));
		accountIDLabel2.setFont(new Font("Devanagari MT", Font.ITALIC, 16));
		accountIDLabel2.setBounds(16, 31, 311, 26);
		balancePanel.add(accountIDLabel2);
		
		accountBalanceBox = new JTextField();
		accountBalanceBox.setFont(new Font("Devanagari MT", Font.PLAIN, 13));
		accountBalanceBox.setColumns(10);
		accountBalanceBox.setBounds(16, 58, 311, 37);
		balancePanel.add(accountBalanceBox);
		
		accountLabel_1_1 = new JLabel("Account Information:");
		accountLabel_1_1.setForeground(new Color(121, 136, 153));
		accountLabel_1_1.setFont(new Font("Devanagari MT", Font.PLAIN, 15));
		accountLabel_1_1.setBounds(98, 6, 137, 26);
		balancePanel.add(accountLabel_1_1);
		
		balanceInfoPanel = new JPanel();
		balanceInfoPanel.setBackground(new Color(255, 255, 255));
		balanceInfoPanel.setBounds(23, 107, 300, 94);
		balancePanel.add(balanceInfoPanel);
		balanceInfoPanel.setLayout(null);
		
		successBalanceLabel = new JLabel("");
		successBalanceLabel.setForeground(new Color(66, 70, 79));
		successBalanceLabel.setFont(new Font("Devanagari MT", Font.PLAIN, 16));
		successBalanceLabel.setBounds(83, 11, 211, 77);
		balanceInfoPanel.add(successBalanceLabel);
		
		title12_1 = new JLabel("Account ID:");
		title12_1.setForeground(new Color(115, 121, 136));
		title12_1.setFont(new Font("Devanagari MT", Font.ITALIC, 14));
		title12_1.setBounds(6, 11, 93, 26);
		balanceInfoPanel.add(title12_1);
		
		title22_1 = new JLabel("Name:");
		title22_1.setForeground(new Color(115, 121, 136));
		title22_1.setFont(new Font("Devanagari MT", Font.ITALIC, 14));
		title22_1.setBounds(38, 35, 51, 26);
		balanceInfoPanel.add(title22_1);
		
		title32_1 = new JLabel("Balance:");
		title32_1.setForeground(new Color(115, 121, 136));
		title32_1.setFont(new Font("Devanagari MT", Font.ITALIC, 14));
		title32_1.setBounds(27, 62, 93, 26);
		balanceInfoPanel.add(title32_1);
		
		balanceAccountButton = new JButton("Check Balance");
		balanceAccountButton.setForeground(new Color(46, 51, 64));
		balanceAccountButton.setFont(new Font("Devanagari MT", Font.ITALIC, 19));
		balanceAccountButton.setFocusPainted(false);
		balanceAccountButton.setActionCommand("checkBalance");
		balanceAccountButton.addActionListener(this);
		balanceAccountButton.setBounds(31, 293, 197, 50);
		balanceAccountPanel.add(balanceAccountButton);
		
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
	
	public void actionPerformed(ActionEvent e) {
		
		String eventName = e.getActionCommand();
		
		if (eventName.equals("addAccount")) {
			mainVisibility(false);
			newAccountPanel.setVisible(true);
			
			createAccountButton.setActionCommand("createAccount");
			
			accountLabel.setVisible(true);
			firstNameLabel.setVisible(true);
			lastNameLabel.setVisible(true);
			balanceLabel.setVisible(true);
			firstNameBox.setVisible(true);
			lastNameBox.setVisible(true);
			balanceBox.setVisible(true);
			errorLabel.setVisible(false);
			
			firstNameBox.setText("");
			lastNameBox.setText("");
			balanceBox.setText(""); 
			
			successLabel.setVisible(false);
			accountIDLabel.setVisible(false);
		}
			
		if (eventName.equals("createAccount")) {
		
			try {
				errorLabel.setVisible(false);
				String firstName = firstNameBox.getText();
				String lastName = lastNameBox.getText();
				double balance = (Double.parseDouble(balanceBox.getText()));
				
				accountIDLabel.setText("Account ID: " + (easySave.addAccount(firstName, lastName, balance)));
			
				accountLabel.setVisible(false);
				firstNameLabel.setVisible(false);
				lastNameLabel.setVisible(false);
				balanceLabel.setVisible(false);
				firstNameBox.setVisible(false);
				lastNameBox.setVisible(false);
				balanceBox.setVisible(false);
				
				successLabel.setVisible(true);
				accountIDLabel.setVisible(true);
				
				createAccountButton.setActionCommand("stop");
				
			}
			catch(Exception e1){ 
				errorLabel.setVisible(true);	
				
				timer.schedule(new TimerTask() {
				    public void run() {
				    	errorLabel.setVisible(false);
				    }
				    
				}, 2000);
			}
		}
		
		if (eventName.equals("return")) {
			mainVisibility(true);
			newAccountPanel.setVisible(false);
			deleteAccountPanel.setVisible(false);
			depositAccountPanel.setVisible(false);
			withdrawalAccountPanel.setVisible(false);
			balanceAccountPanel.setVisible(false);
			
		}

		if (eventName.equals("removeAccount")) {
			mainVisibility(false);
			deleteAccountPanel.setVisible(true);
			deleteAccountBox.setText("");
			
		}
		
		if (eventName.equals("deleteAccount")) {
			ID = deleteAccountBox.getText();
			accountDeletedText.setText(easySave.deleteAccount(ID));
			deleteAccountBox.setText("");
			
			timer.schedule(new TimerTask() {
			    public void run() {
			    	accountDeletedText.setText("");
			    }
			    
			}, 1000);
			
		}
		//---------------------------------------------------------------------------------------
		
		if (eventName.equals("deposit")) {
			
			depositAccountButton.setActionCommand("depositAccount");
			
			mainVisibility(false);
			depositAccountPanel.setVisible(true);
			
			accountIDBox.setText("");
			depositBox.setText("");
			accountLabel3.setText("Account information:");
			
			errorLabel2.setVisible(false);
			
			accountLabel3.setVisible(true);
			accountIDHeader.setVisible(true);
			accountIDBox.setVisible(true);
			depositHeader.setVisible(true);
			depositBox.setVisible(true);
			
			successDepositLabel.setVisible(false);
			title1.setVisible(false);
			title2.setVisible(false);
			title3.setVisible(false);
			
		}
		
		if(eventName.equals("depositAccount")) {
			
			try {
				
				ID = accountIDBox.getText();
				
				amt = (Double.parseDouble(depositBox.getText()));
				
				successDepositLabel.setVisible(true);
				title1.setVisible(true);
				title2.setVisible(true);
				title3.setVisible(true);
				
				successDepositLabel.setText(easySave.transaction(1, ID, amt));
				
				accountLabel3.setText("         Success!");
				accountIDHeader.setVisible(false);
				accountIDBox.setVisible(false);
				depositHeader.setVisible(false);
				depositBox.setVisible(false);
				errorLabel2.setVisible(false);
				
				if(successDepositLabel.getText()== "Account does not exist.") {
					
					successDepositLabel.setBounds(90, 32, 250, 146);
					accountLabel3.setVisible(false);
					title1.setVisible(false);
					title2.setVisible(false);
					title3.setVisible(false);

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
				else {
					depositAccountButton.setActionCommand("stop");
				}
				
			}
			catch(Exception e1) {
				
				errorLabel2.setVisible(true);
				
				timer.schedule(new TimerTask() {
				    public void run() {
				    	errorLabel2.setVisible(false);
				    }
				    
				}, 1000);
				
			}
		}	
		
		//---------------------------------------------------------------------------------------
		
		if (eventName.equals("withdrawal")) {
			
			withdrawalAccountButton.setActionCommand("withdrawalAccount");
			
			mainVisibility(false);
			withdrawalAccountPanel.setVisible(true);
			
			accountIDBox2.setText("");
			withdrawalBox.setText("");
			accountLabel4.setText("Account information:");
			
			errorLabel3.setVisible(false);
			
			accountLabel4.setVisible(true);
			accountIDHeader2.setVisible(true);
			accountIDBox2.setVisible(true);
			withdrawalHeader.setVisible(true);
			withdrawalBox.setVisible(true);
			
			successWithdrawalLabel.setVisible(false);
			title12.setVisible(false);
			title22.setVisible(false);
			title32.setVisible(false);
			
		}
		
		if(eventName.equals("withdrawalAccount")) {
			
			try {
				
				ID = accountIDBox2.getText();
				
				amt = (Double.parseDouble(withdrawalBox.getText()));
				
				successWithdrawalLabel.setVisible(true);
				title12.setVisible(true);
				title22.setVisible(true);
				title32.setVisible(true);
				
				successWithdrawalLabel.setText(easySave.transaction(2, ID, amt));
				
				accountLabel4.setText("         Success!");
				accountIDHeader2.setVisible(false);
				accountIDBox2.setVisible(false);
				withdrawalHeader.setVisible(false);
				withdrawalBox.setVisible(false);
				errorLabel3.setVisible(false);
				
				if((successWithdrawalLabel.getText()== "Account does not exist.")|| 
				(successWithdrawalLabel.getText()== "Not enough funds in account.") ) {
					
					successWithdrawalLabel.setBounds(80, 32, 250, 146);
					accountLabel4.setVisible(false);
					title12.setVisible(false);
					title22.setVisible(false);
					title32.setVisible(false);

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
				else {
					withdrawalAccountButton.setActionCommand("stop");
				}
				
			}
			catch(Exception e1) {
				
				errorLabel3.setVisible(true);
				
				timer.schedule(new TimerTask() {
				    public void run() {
				    	errorLabel3.setVisible(false);
				    }
				    
				}, 1000);
				
			}
		}	
		

		//---------------------------------------------------------------------------------------
		
		if (eventName.equals("balance")) {
			
			mainVisibility(false);
			balanceAccountPanel.setVisible(true);
			balanceInfoPanel.setVisible(false);
			accountBalanceBox.setText("");
			
		}
		
		if(eventName.equals("checkBalance")) {
			
			ID = accountBalanceBox.getText();
			successBalanceLabel.setText(easySave.checkBalance(ID));
			balanceInfoPanel.setVisible(true);
			title12_1.setVisible(true);
			title22_1.setVisible(true);
			title32_1.setVisible(true);
			accountBalanceBox.setText("");
			successBalanceLabel.setBounds(83, 6, 211, 82);
			
			if(successBalanceLabel.getText()== "Account does not exist.") {
				successBalanceLabel.setBounds(63, 6, 211, 82);
				title12_1.setVisible(false);
				title22_1.setVisible(false);
				title32_1.setVisible(false);
			}
			
		}
		
	}
}

