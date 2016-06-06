import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

import javax.swing.*;

import java.awt.Font;

public class Level1 {
	private int total = 0;
	private int fails = 0;
	String username;
	JPanel levelComBorder = new JPanel();
	JPanel levelComPanel = new JPanel();

	public int lid, npc1, npc2, npc3, npc4;
	Connection connection = sqliteConnection.dbConnector();
	{
		try {
			String query = "select * from Level1 order by rand() limit 1";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				lid = rs.getInt("LID");
				npc1 = rs.getInt("NPC1");
				npc2 = rs.getInt("NPC2");
				npc3 = rs.getInt("NPC3");
				npc4 = rs.getInt("NPC4");
			}
			System.out.println(npc1 + " " + npc2 + " " + npc3 + " " + npc4);
			rs.close();
			pst.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	private boolean button1Clicked = false;
	private boolean button2Clicked = false;
	private boolean button3Clicked = false;

	private String equation = "0";

	JTextPane txtpnGiveMe = new JTextPane();
	private JLabel totalLabel = new JLabel("");

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level1 window = new Level1("AHenley");
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
	public Level1(String UserName) {
		username = UserName;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 640, 487);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		levelComBorder.setVisible(false);
		levelComPanel.setVisible(false);

		levelComBorder.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Nice Job!",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		levelComBorder.setBounds(104, 49, 292, 261);
		frame.getContentPane().add(levelComBorder);
		levelComBorder.setLayout(null);

		levelComPanel.setBounds(6, 18, 137, 237);
		levelComBorder.add(levelComPanel);

		JTextArea txtrWellDoneClick = new JTextArea();
		txtrWellDoneClick.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		txtrWellDoneClick.setWrapStyleWord(true);
		txtrWellDoneClick.setLineWrap(true);
		txtrWellDoneClick
		.setText("Well done!, click continue to get back to the map.");
		levelComPanel.add(txtrWellDoneClick);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("images/star-icon.png"));
		label.setBounds(155, 18, 131, 180);
		levelComBorder.add(label);

		JButton btnContinue = new JButton("continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				WorldMap window = new WorldMap(username);
				window.frame.setVisible(true);
			}
		});
		btnContinue.setBounds(169, 226, 117, 29);
		levelComBorder.add(btnContinue);

		txtpnGiveMe.setEditable(false);
		txtpnGiveMe.setText("Give me " + npc4
				+ " coins to pass through to the mountains");
		txtpnGiveMe.setBounds(532, 234, 101, 70);
		frame.getContentPane().add(txtpnGiveMe);

		JButton resetButton = new JButton("reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total = 0;
				button1Clicked = false;
				button2Clicked = false;
				button3Clicked = false;
				equation = "0";
				totalLabel.setText(equation);
				txtpnGiveMe.setText("Give me " + npc4
						+ " coins to pass through to the mountains");

				fails++;
			}
		});
		resetButton.setBounds(532, 398, 109, 37);
		frame.getContentPane().add(resetButton);

		JButton mapButton = new JButton("back to map");
		mapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				WorldMap window = new WorldMap(username);
				window.frame.setVisible(true);
			}
		});
		mapButton.setBounds(532, 431, 109, 37);
		frame.getContentPane().add(mapButton);
		mapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();// in future add some actions to feed the
				// database and reinitialize main map.
			}
		});

		JPanel totalBorder = new JPanel();
		totalBorder.setBackground(Color.LIGHT_GRAY);
		totalBorder.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Total",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		totalBorder.setBounds(0, 398, 529, 70);
		frame.getContentPane().add(totalBorder);
		totalBorder.setLayout(null);

		totalLabel.setBounds(6, 18, 517, 48);
		totalBorder.add(totalLabel);

		JButton btnNewButton = new JButton("Give");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int finalVal = npc4;
				equation = equation + " = " + total;
				if (total == finalVal) {
					totalLabel.setText(equation);
					System.out.println("right answer");
					System.out.println("fails = " + fails);
					txtpnGiveMe.setText("good job! now you can pass through to the mountains");
					equation = "0";
					total = 0;

					try {

						String queryMap = "select Level from Student where UName='"+ username + "'";
						PreparedStatement pst = connection.prepareStatement(queryMap);
						ResultSet rs = pst.executeQuery();
						
						int userLevel = 0;
						while (rs.next()){
							 userLevel = rs.getInt("Level");
						}
						rs.close();
						pst.close();

						if (userLevel < 2) {
							Statement stmt = connection.createStatement();
							String queryUpdate = "UPDATE Student SET Level=2 WHERE UName='"+ username + "'";
							stmt.execute(queryUpdate);

							stmt.close();
						}
	
							String entry="INSERT INTO Problem values( 0,'"+username+"', 'GGagne', 1, "+fails+")";
							java.sql.Statement pst_prob=connection.createStatement();
							pst_prob.executeUpdate(entry);
							pst_prob.close();


					} catch (Exception p) {
						JOptionPane.showMessageDialog(null, p);
						System.exit(1);
					}
					

					levelComBorder.setVisible(true);
					levelComPanel.setVisible(true);

				} else {
					System.out.println("wrong answer, try again");
					total = 0;
					button1Clicked = false;
					button2Clicked = false;
					button3Clicked = false;
					fails++;
					totalLabel.setText(equation);
					txtpnGiveMe.setText("This is the wrong amount, try again");
					equation = "0";
				}
			}
		});
		btnNewButton.setBounds(482, 326, 64, 29);
		frame.getContentPane().add(btnNewButton);

		JLabel gateKepperLabel = new JLabel("");
		gateKepperLabel.setIcon(new ImageIcon("images/King-icon.png"));
		gateKepperLabel.setBounds(482, 260, 75, 70);
		frame.getContentPane().add(gateKepperLabel);

		JLabel takeLabel1 = new JLabel("");
		takeLabel1.setIcon(new ImageIcon("images/Leprechaun-icon.png"));
		takeLabel1.setBounds(118, 270, 48, 70);
		frame.getContentPane().add(takeLabel1);

		JButton takeButton1 = new JButton("take");
		takeButton1.setBounds(110, 326, 70, 29);
		frame.getContentPane().add(takeButton1);
		takeButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int coinVal6 = npc1;
				if (button1Clicked == false) {
					total = total + coinVal6;
					button1Clicked = true;
					System.out.println(total);
					equation = equation + " + " + coinVal6;
					totalLabel.setText(equation);
				}

			}
		});

		JLabel takeButton2 = new JLabel("");
		takeButton2.setIcon(new ImageIcon("images/Man-icon.png"));
		takeButton2.setBounds(286, 260, 70, 70);
		frame.getContentPane().add(takeButton2);

		JButton btnNewButton_1 = new JButton("take");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int coinVal = npc2;
				if (button2Clicked == false) {
					total = total + coinVal;
					button2Clicked = true;
					System.out.println(total);

					equation = equation + " + " + coinVal;
					totalLabel.setText(equation);
				}
			}
		});
		btnNewButton_1.setBounds(286, 315, 70, 29);
		frame.getContentPane().add(btnNewButton_1);

		JLabel takeLabel3 = new JLabel("");
		takeLabel3.setIcon(new ImageIcon("images/Teacher-icon.png"));
		takeLabel3.setBounds(348, 175, 48, 58);
		frame.getContentPane().add(takeLabel3);

		JButton takeButton3 = new JButton("take");
		takeButton3.setBounds(348, 226, 70, 29);
		frame.getContentPane().add(takeButton3);
		takeButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int coinVal = npc3;
				if (button3Clicked == false) {
					total = total + coinVal;
					button3Clicked = true;
					System.out.println(total);

					equation = equation + " + " + coinVal;
					totalLabel.setText(equation);
				}
			}
		});

		JPanel panel = new JPanel();
		panel.setBounds(310, 164, 129, 16);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel coinsLabel4 = new JLabel("I'll give you " + npc3 + " coins");
		coinsLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		coinsLabel4.setBounds(0, 0, 140, 16);
		panel.add(coinsLabel4);
		coinsLabel4.setBackground(Color.WHITE);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(246, 253, 129, 16);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel coinsLabel5 = new JLabel("Take these " + npc2 + " coins");
		coinsLabel5.setBounds(0, 0, 140, 19);
		panel_1.add(coinsLabel5);
		coinsLabel5.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(81, 263, 129, 16);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel coinsLabel6 = new JLabel("I'll pitch in " + npc1 + " coins");
		coinsLabel6.setBounds(0, 0, 129, 16);
		panel_2.add(coinsLabel6);
		coinsLabel6.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel backGroundLabel = new JLabel("");
		backGroundLabel.setIcon(new ImageIcon("images/backgroundl1.jpg"));
		backGroundLabel.setBounds(0, 0, 641, 468);
		frame.getContentPane().add(backGroundLabel);

	}
}
