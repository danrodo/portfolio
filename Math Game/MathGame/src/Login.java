import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login<E> {

	JFrame frame;
	String name[] = new String[40], tName[] = new String[10], password,
			firstName, lastName, teacher, tPassword;
	int level, tID;
	// Queries database for list of student and teacher usernames.
	Connection connection = sqliteConnection.dbConnector();
	{
		try {
			String query = "select UName from Student";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			int i = 0;

			while (rs.next()) {
				name[i] = rs.getString("UName");
				// password[i]=rs.getString("SPW");
				// firstAndLast = firstAndLast + " " + rs.getString("LName");
				// name[i]=firstAndLast;
				// firstAndLast=null;
				// System.out.println(name[i]);
				i++;

			}
			rs.close();
			pst.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

		try {
			String query2 = "select TUName from Teacher";
			PreparedStatement pst2 = connection.prepareStatement(query2);
			ResultSet rs2 = pst2.executeQuery();
			int i = 0;

			while (rs2.next()) {
				tName[i] = rs2.getString("TUName");
				// password[i]=rs.getString("SPW");
				// firstAndLast = firstAndLast + " " + rs.getString("LName");
				// name[i]=firstAndLast;
				// firstAndLast=null;
				// System.out.println(name[i]);
				i++;

			}
			rs2.close();
			pst2.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	String username = name[0], tUName = tName[0];
	public JComboBox<E> box;
	private JPasswordField passwordField;
	private JComboBox<E> tbox;
	private JPasswordField TPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// System.out.println("select SPW from Student where UName='" + username
		// + "'");
		JButton btnNewButton = new JButton("Student Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query1 = "select * from Student where UName='"
							+ username + "'";
					PreparedStatement pst2 = connection
							.prepareStatement(query1);
					ResultSet rs = pst2.executeQuery();
					while (rs.next()) {
						password = rs.getString("SPW");
						level = rs.getInt("Level");
						firstName = rs.getString("FName");
						lastName = rs.getString("LName");
					}
					char[] input = passwordField.getPassword();
					String in = new String(input);
					System.out.println(in);
					rs.close();
					pst2.close();

					if (in.equals(password)) {
						// JOptionPane.showMessageDialog(null,
						// "You are now logged in " + firstName
						// +"!","Welcome!",JOptionPane.PLAIN_MESSAGE);
						WorldMap window = new WorldMap(level, username,
								firstName + " " + lastName);
						window.frame.setVisible(true);

					} else {
						JOptionPane
								.showMessageDialog(
										null,
										"This is the wrong password for "
												+ username
												+ ". Please enter the correct password or select the correct username.");
						System.out.println(input);
						System.out.println(password);

					}

					passwordField.setText("");
					// System.out.println(username+password+",");
					// JOptionPane.showMessageDialog(null, "Login successful.");

				} catch (Exception p) {
					JOptionPane.showMessageDialog(null, p);
					System.exit(1);
				}
			}

			private Object toString(char[] input) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		btnNewButton.setBounds(12, 132, 160, 29);
		frame.getContentPane().add(btnNewButton);
		/*
		 * 50 textField = new JTextField(); textField.setBounds(12, 43, 161,
		 * 28); frame.getContentPane().add(textField); textField.setColumns(10);
		 */
		box = new JComboBox(name);
		box.setBounds(12, 40, 161, 28);
		frame.getContentPane().add(box);
		// box.setEditable(true);
		box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username = (String) box.getSelectedItem();
				System.out.println(username);
			}
		});

		passwordField = new JPasswordField();
		passwordField.setText("");
		passwordField.setBounds(12, 100, 161, 28);
		frame.getContentPane().add(passwordField);

		// System.out.println(password);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(45, 73, 75, 15);
		frame.getContentPane().add(lblPassword);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(43, 20, 77, 15);
		frame.getContentPane().add(lblUsername);

		JButton btnTeacher = new JButton("Teacher Login");
		btnTeacher.setBounds(245, 132, 140, 29);
		frame.getContentPane().add(btnTeacher);
		btnTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query1 = "select * from Teacher where TUName='"
							+ tUName + "'";
					PreparedStatement pst2 = connection
							.prepareStatement(query1);
					ResultSet rs = pst2.executeQuery();
					while (rs.next()) {
						tID = rs.getInt("TID");
						tPassword = rs.getString("PassWord");
						teacher = rs.getString("Name");
					}
					char[] tinput = TPasswordField.getPassword();
					String tin = new String(tinput);
					System.out.println(tin);
					rs.close();
					pst2.close();

					if (tin.equals(tPassword)) {
						// JOptionPane.showMessageDialog(null,
						// "You are now logged in " + tUName
						// +"!","Welcome!",JOptionPane.PLAIN_MESSAGE);
						AddStudent window = new AddStudent(tID, teacher);
						window.frame.setVisible(true);

					} else {
						JOptionPane
								.showMessageDialog(
										null,
										"This is the wrong password for "
												+ tUName
												+ ". Please enter the correct password or select the correct username.");
						System.out.println(tinput);
						System.out.println(tPassword);

					}

					// System.out.println(username+password+",");
					// JOptionPane.showMessageDialog(null, "Login successful.");

				} catch (Exception p) {
					JOptionPane.showMessageDialog(null, p);
					System.exit(1);
				}
				TPasswordField.setText("");
			}

			private Object toString(char[] input) {
				// TODO Auto-generated method stub
				return null;
			}
		});

		JLabel labelTeacherName = new JLabel("Teacher Username:");
		labelTeacherName.setBounds(245, 20, 138, 15);
		frame.getContentPane().add(labelTeacherName);

		tbox = new JComboBox(tName);
		tbox.setBounds(245, 40, 140, 29);
		frame.getContentPane().add(tbox);
		tbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tUName = (String) tbox.getSelectedItem();
				System.out.println(tUName);
			}
		});
		JLabel lblTeacherPassword = new JLabel("Teacher Password:");
		lblTeacherPassword.setBounds(245, 73, 136, 15);
		frame.getContentPane().add(lblTeacherPassword);

		TPasswordField = new JPasswordField();
		TPasswordField.setBounds(245, 100, 140, 28);
		frame.getContentPane().add(TPasswordField);

		JButton btnNewButton_1 = new JButton("New Teacher");
		btnNewButton_1.setBounds(245, 167, 140, 29);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewTeacher window = new NewTeacher();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});

		JButton btnClose = new JButton("Close");
		btnClose.setBounds(245, 210, 140, 25);
		frame.getContentPane().add(btnClose);
		
		JButton btnNewStudent = new JButton("New Student");
		btnNewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewStudent window = new NewStudent();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewStudent.setBounds(30, 194, 117, 29);
		frame.getContentPane().add(btnNewStudent);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();// in future add some actions to feed the
								// database and reinitialize main map.
			}
		});
	}
}
