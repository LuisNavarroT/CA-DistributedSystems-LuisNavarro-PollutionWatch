package grpc.service1;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class GUIserv1 {

	public JFrame frame;
	private JTextField textOxigenLevel;
	private JTextField textOxigenValue;
	private JTextField textTempValue;
	private JTextField textPhValue;
	private JTextField textRiverName;
	private JTextArea textResponseRiverControl ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIserv1 window = new GUIserv1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public GUIserv1() {
		


		
		initialize();
	}
	
		
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("River Water Control GUI");
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		
		frame.getContentPane().setLayout(bl);
		//panel 1
		JPanel panel_service_1 = new JPanel();
		frame.getContentPane().add(panel_service_1);
		panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		//panel 2
		JPanel panel_service_2 = new JPanel();
		frame.getContentPane().add(panel_service_2);
		panel_service_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_2 = new JLabel("Oxigen level");
		panel_service_2.add(lblNewLabel_2);
		
		textOxigenLevel = new JTextField();
		panel_service_2.add(textOxigenLevel);
		textOxigenLevel.setColumns(10);
		//panel 3
		JPanel panel_service_3 = new JPanel();
		frame.getContentPane().add(panel_service_3);
		panel_service_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3 = new JLabel("River Name");
		panel_service_3.add(lblNewLabel_3);
		
		textRiverName = new JTextField();
		panel_service_3.add(textRiverName);
		textRiverName.setColumns(10);
		//panel 4
		JPanel panel_service_4 = new JPanel();
		frame.getContentPane().add(panel_service_4);
		panel_service_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_4 = new JLabel("Oxigen value");
		panel_service_4.add(lblNewLabel_4);
		
		textOxigenValue = new JTextField();
		panel_service_4.add(textOxigenValue);
		textOxigenValue.setColumns(10);
		//panel 5
		JPanel panel_service_5 = new JPanel();
		frame.getContentPane().add(panel_service_5);
		panel_service_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_5 = new JLabel("Temperature value");
		panel_service_5.add(lblNewLabel_5);
		
		textTempValue = new JTextField();
		panel_service_5.add(textTempValue);
		textTempValue.setColumns(10);
		//panel 6
		JPanel panel_service_6 = new JPanel();
		frame.getContentPane().add(panel_service_6);
		panel_service_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_6 = new JLabel("Ph value");
		panel_service_6.add(lblNewLabel_6);
		
		textPhValue = new JTextField();
		panel_service_6.add(textPhValue);
		textPhValue.setColumns(10);
		//
		
		
		final JComboBox comboOperation = new JComboBox();
		comboOperation.setModel(new DefaultComboBoxModel(new String[] {"rpc1-oxigenLevel", "rpc2-manyValues", "rpc3-manyReadings"}));
		panel_service_1.add(comboOperation);
	
		
		JButton btnCalculate = new JButton("Send");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				float num1 = Float.parseFloat(textOxigenLevel.getText());
				float num2 = Float.parseFloat(textOxigenValue.getText());
				float num3 = Float.parseFloat(textTempValue.getText());
				float num4 = Float.parseFloat(textPhValue.getText());
				String name = textRiverName.getText();
				
				int index = comboOperation.getSelectedIndex();
				
				if (index == 0) {
					if(num1>=6.5 && num1<=8) {
						name="Result of Test: The river is HEALTY";
					}else {
						name="Result of Test: The river is UNHEALTY";
					}
				}
				if (index == 1) { 
					textResponseRiverControl.append("Result of Subtraction" + String.valueOf(num1 - num2)); 
					}
				if (index == 2) {
					textResponseRiverControl.append("Result of Multiplication" + String.valueOf(num1 * num2)); 
					}
				
			}
		});
		panel_service_1.add(btnCalculate);
		
		textResponseRiverControl = new JTextArea(3, 20);
		textResponseRiverControl .setLineWrap(true);
		textResponseRiverControl.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textResponseRiverControl);
		
		//textResponse.setSize(new Dimension(15, 30));
		JPanel panel_service_7 = new JPanel();
		JLabel lblNewLabel_7 = new JLabel("Server Response");
		panel_service_7.add(lblNewLabel_7);
		frame.getContentPane().add(panel_service_7);
		panel_service_7.add(scrollPane);
		
		
		JPanel panel_service_8 = new JPanel();
		frame.getContentPane().add(panel_service_8);
		
		JPanel panel_service_9 = new JPanel();
		frame.getContentPane().add(panel_service_9);
		
		
		
	}

}
