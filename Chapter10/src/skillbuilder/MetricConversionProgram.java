package skillbuilder;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

public class MetricConversionProgram {

	private JFrame frmMetricConversion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MetricConversionProgram window = new MetricConversionProgram();
					window.frmMetricConversion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MetricConversionProgram() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMetricConversion = new JFrame();
		frmMetricConversion.setTitle("Metric Conversion");
		frmMetricConversion.setBounds(100, 100, 393, 164);
		
		
		JPanel panel = new JPanel();
		frmMetricConversion.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select a conversion type:");
		lblNewLabel.setBounds(21, 19, 265, 16);
		panel.add(lblNewLabel);
		
		JLabel answer = new JLabel("1 inch = 2.54 centimeters");
		answer.setBounds(21, 80, 265, 16);
		panel.add(answer);
		
		JComboBox Unit = new JComboBox();
		Unit.setModel(new DefaultComboBoxModel(new String[] {"inches to centemeters", "feet to meters", "gallon to liters", "pounds to kilograms" }));
		Unit.setBounds(16, 19, 354, 77);
		panel.add(Unit);
		
		Unit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){
				JComboBox comboBox = (JComboBox)e.getSource();
				String Unit = (String)comboBox.getSelectedItem();
				
				if (Unit == "inches to centemeters") {
					
					answer.setText("1 inch = 2.54 centimeters");
					
				} else if (Unit == "feet to meters") {
					
					answer.setText("1 foot = 0.3048 meters");
					
				} else if (Unit == "gallon to liters") {
					
					answer.setText("1 gallon = 4.5461 liters");
					
				} else if (Unit == "pounds to kilograms") {
					
					answer.setText("1 pound = 0.4536 kilograms");
				}
				
				
			}
			
		});
	
		
		
	}
}
