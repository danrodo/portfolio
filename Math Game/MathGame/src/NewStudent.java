import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class NewStudent {
	Connection connection = sqliteConnection.dbConnector();
	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	String fname, lname, passWord, tuserName;
	private JTextField textField1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewStudent window = new NewStudent();
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
	public NewStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 618, 439);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblLName = new JLabel("Last Name");
		lblLName.setBounds(169, 27, 70, 15);
		frame.getContentPane().add(lblLName);

		JLabel lblFName = new JLabel("First Name");
		lblFName.setBounds(21, 27, 70, 15);
		frame.getContentPane().add(lblFName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(448, 27, 70, 15);
		frame.getContentPane().add(lblPassword);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(302, 27, 77, 15);
		frame.getContentPane().add(lblUserName);

		textField = new JTextField();
		textField.setBounds(21, 54, 114, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField1 = new JTextField();
		textField1.setBounds(21, 54, 114, 19);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		textField1 = new JTextField();
		textField1.setColumns(10);
		textField1.setBounds(165, 52, 114, 19);
		frame.getContentPane().add(textField1);

		textField_1 = new JTextField();
		textField_1.setBounds(446, 54, 114, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(302, 54, 114, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(256, 198, 83, 25);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fname = textField.getText();
				lname = textField1.getText();
				passWord = textField_1.getText();
				tuserName = textField_2.getText();

				try {
					String query1 = "Insert Into Student values( 0,'" + fname + "','" + lname + "','" + passWord + "', 1, '"+ tuserName+"', 1)";
					java.sql.Statement pst3 = null;
					pst3 = connection.createStatement();

					pst3.executeUpdate(query1);
					pst3.close();
					Login window = new Login();
					window.frame.setVisible(true);
					frame.dispose();

				} catch (Exception p) {
					JOptionPane.showMessageDialog(null, p);
					System.exit(1);
				}

			}
		});
	}
}