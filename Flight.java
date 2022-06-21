/**
 * Uses object arraylist to sort information and output
 * 
 * modified     20220520
 * date         20220516
 * @filename    Flight.java
 * @author      Oscar Lam
 * @version     1.0
 * @see         Unit 2 activity 7
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Flight extends JFrame {
	
	FlightEvent Flight = new FlightEvent(this);
	
	JTextField txtFirst = new JTextField();
	JTextField txtLast = new JTextField();
	JTextField txtOne = new JTextField();
	JTextField txtTwo = new JTextField();
	JTextField txtThree = new JTextField();
	JTextField txtFour = new JTextField();
	JTextField txtId = new JTextField();
	JTextField txtSize = new JTextField();
	JTextArea taOutput = new JTextArea();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Flight frame = new Flight();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Flight() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 463, 565);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Airline Points ");
		lblTitle.setBounds(173, 24, 106, 14);
		panel.add(lblTitle);
		
		JLabel lblFirst = new JLabel("First Name: ");
		lblFirst.setBounds(32, 74, 78, 14);
		panel.add(lblFirst);
		
		txtFirst.setBounds(108, 71, 106, 20);
		panel.add(txtFirst);
		txtFirst.setColumns(10);
		
		JLabel lblLast = new JLabel("Last Name:");
		lblLast.setBounds(247, 74, 72, 14);
		panel.add(lblLast);
		
		txtLast.setBounds(320, 71, 106, 20);
		panel.add(txtLast);
		txtLast.setColumns(10);
		
		JLabel lblOne = new JLabel("Week 1:");
		lblOne.setBounds(32, 156, 48, 14);
		panel.add(lblOne);
		
		txtOne.setBounds(90, 153, 59, 20);
		panel.add(txtOne);
		txtOne.setColumns(10);
		
		JLabel lblTwo = new JLabel("Week 2:");
		lblTwo.setBounds(32, 187, 48, 14);
		panel.add(lblTwo);
		
		txtTwo.setBounds(90, 184, 59, 20);
		panel.add(txtTwo);
		txtTwo.setColumns(10);
		
		JLabel lblThree = new JLabel("Week 3:");
		lblThree.setBounds(32, 218, 48, 14);
		panel.add(lblThree);
		
		txtThree.setBounds(90, 215, 59, 20);
		panel.add(txtThree);
		txtThree.setColumns(10);
		
		JLabel lblFour = new JLabel("Week 4:");
		lblFour.setBounds(32, 249, 48, 14);
		panel.add(lblFour);
		
		txtFour.setBounds(90, 246, 59, 20);
		panel.add(txtFour);
		txtFour.setColumns(10);
		
		JLabel lblId = new JLabel("ID #:");
		lblId.setBounds(32, 114, 48, 14);
		panel.add(lblId);
		
		txtId.setBounds(90, 111, 78, 20);
		panel.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblSize = new JLabel("List size: ");
		lblSize.setBounds(234, 249, 66, 14);
		panel.add(lblSize);
		txtSize.setText("0");
		txtSize.setEditable(false);
		
		txtSize.setBounds(297, 246, 49, 20);
		panel.add(txtSize);
		txtSize.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(234, 133, 91, 23);
		panel.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(330, 133, 91, 23);
		panel.add(btnRemove);
		
		JButton btnPoints = new JButton("Total Points");
		btnPoints.setBounds(260, 201, 124, 23);
		panel.add(btnPoints);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(330, 167, 91, 23);
		panel.add(btnUpdate);
		taOutput.setEditable(false);
		
		taOutput.setBounds(9, -12, 223, 156);
		panel.add(taOutput);
		
		JScrollPane scrollPane = new JScrollPane(taOutput);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(32, 274, 394, 280);
		panel.add(scrollPane);
		
		JButton btnList = new JButton("List");
		btnList.setBounds(234, 167, 91, 23);
		panel.add(btnList);
		
		btnAdd.addActionListener(Flight);
		btnRemove.addActionListener(Flight);
		btnUpdate.addActionListener(Flight);
		btnPoints.addActionListener(Flight);
		btnList.addActionListener(Flight);
	}
}
