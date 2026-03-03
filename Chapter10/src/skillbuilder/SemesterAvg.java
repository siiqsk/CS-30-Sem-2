package skillbuilder;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class SemesterAvg implements ActionListener {

	private JFrame frmSemesterAverage;
	private JTextField grade1;
	private JTextField grade2;
	private JTextField grade3;
	private JLabel average;
	private JButton averageButton;
	DecimalFormat shorten = new DecimalFormat("#00.00");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SemesterAvg window = new SemesterAvg();
					window.frmSemesterAverage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SemesterAvg() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmSemesterAverage = new JFrame();
		frmSemesterAverage.setTitle("Semester Average");
		frmSemesterAverage.setBounds(100, 100, 450, 300);
		frmSemesterAverage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2,10,5));
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		frmSemesterAverage.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel text1 = new JLabel("Enter the first grade:");
		panel.add(text1);
		
		grade1 = new JTextField();
		panel.add(grade1);
		grade1.setColumns(10);
		
		JLabel text2 = new JLabel("Enter the second grade:");
		panel.add(text2);
		
		grade2 = new JTextField();
		panel.add(grade2);
		grade2.setColumns(10);
		
		JLabel text3 = new JLabel("Enter the third grade:");
		panel.add(text3);
		
		grade3 = new JTextField();
		panel.add(grade3);
		grade3.setColumns(10);
		
		averageButton = new JButton("Average");
		averageButton.setActionCommand("average");
		averageButton.addActionListener(this);
		panel.add(averageButton);
		
		average = new JLabel(" ");
		panel.add(average);
	}

	public void actionPerformed(ActionEvent e) {
		
		String eventName = e.getActionCommand();
		
		if(eventName.equals("average")) {
			
			double avgGrade;
			String g1 = grade1.getText();
			String g2 = grade2.getText();
			String g3 = grade3.getText();
			
			avgGrade = ((Double.parseDouble(g1) + Double.parseDouble(g2) + Double.parseDouble(g3))/3);

			average.setText(shorten.format(avgGrade));
			
			
		}
		
		
	}

}
