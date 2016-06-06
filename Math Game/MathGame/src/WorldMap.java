import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WorldMap {

	JFrame frame;

	Connection connectionMap = sqliteConnection.dbConnector();
	static int userLevel;
	String MapUserName;
	String displayName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorldMap window = new WorldMap("AHenley");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the application.
	 */
	public WorldMap(int level1, String UserName, String disName) {
		userLevel = level1;
		MapUserName = UserName;
		displayName = disName;
		initialize();
	}

	public WorldMap(String UserName) {
		MapUserName = UserName;

		try {
			String query1 = "select * from Student where UName='" + MapUserName
					+ "'";
			PreparedStatement pst2 = connectionMap.prepareStatement(query1);
			ResultSet rs = pst2.executeQuery();
			while (rs.next()) {
				userLevel = rs.getInt("Level");
				displayName = rs.getString("FName");
				displayName += " " + rs.getString("LName");
			}
			rs.close();
			pst2.close();
		} catch (Exception p) {
			JOptionPane.showMessageDialog(null, p);
			System.exit(1);
		}

		initialize();
	}

	/*
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		/*
		 * Init GUI
		 */
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 675);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnLevel_1 = new JButton("Level 1");
		btnLevel_1.setBounds(58, 146, 83, 25);
		frame.getContentPane().add(btnLevel_1);
		btnLevel_1.setEnabled(false);
		btnLevel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					Level1 window = new Level1(MapUserName);
					window.frame.setVisible(true);
				} catch (Exception j) {
					j.printStackTrace();
				}
			}
		});

		JButton btnLevel_2 = new JButton("Level 2");
		btnLevel_2.setBounds(254, 103, 83, 25);
		frame.getContentPane().add(btnLevel_2);
		btnLevel_2.setEnabled(false);
		btnLevel_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Do SQL inserts here for student, add fails and update what
				// level they're on
				try {
					frame.dispose();
					Level2 window = new Level2(MapUserName);
					window.frame.setVisible(true);
				} catch (Exception k) {
					k.printStackTrace();
				}
				// frame.dispose();
			}
		});

		JButton btnLevel_3 = new JButton("Level 3");
		btnLevel_3.setBounds(636, 116, 83, 25);
		frame.getContentPane().add(btnLevel_3);
		btnLevel_3.setEnabled(false);
		btnLevel_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					Level3 window = new Level3(MapUserName);
					window.frame.setVisible(true);
				} catch (Exception l) {
					l.printStackTrace();
				}

			}
		});

		JButton btnLevel_4 = new JButton("Level 4");
		btnLevel_4.setBounds(421, 219, 83, 25);
		frame.getContentPane().add(btnLevel_4);
		btnLevel_4.setEnabled(false);
		btnLevel_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					Level4 window = new Level4(MapUserName);
					window.frame.setVisible(true);
				} catch (Exception m) {
					m.printStackTrace();
				}
			}
		});

		JButton btnLevel_5 = new JButton("Level 5");
		btnLevel_5.setBounds(254, 312, 83, 25);
		frame.getContentPane().add(btnLevel_5);
		btnLevel_5.setEnabled(false);
		btnLevel_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					Level5 window = new Level5(MapUserName);
					window.frame.setVisible(true);
				} catch (Exception l) {
					l.printStackTrace();
				}

			}
		});

		JButton btnLevel_6 = new JButton("Level 6");
		btnLevel_6.setBounds(58, 517, 83, 25);
		frame.getContentPane().add(btnLevel_6);
		btnLevel_6.setEnabled(false);
		btnLevel_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					Level6 window = new Level6(MapUserName);
					window.frame.setVisible(true);
				} catch (Exception j) {
					j.printStackTrace();
				}
				// frame.dispose();
			}
		});

		JButton btnLevel_7 = new JButton("Level 7");
		btnLevel_7.setBounds(509, 424, 83, 25);
		frame.getContentPane().add(btnLevel_7);
		btnLevel_7.setEnabled(false);
		btnLevel_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					Level7 window7 = new Level7(MapUserName);
					window7.frame.setVisible(true);
				} catch (Exception l) {
					l.printStackTrace();
				}

			}
		});

		JLabel lblwelcome = new JLabel("Welcome: " + displayName);
		lblwelcome.setBounds(31, 0, 300, 15);
		frame.getContentPane().add(lblwelcome);

		if (userLevel <= 7) {
			JLabel lblCurrentUnlockedLevel = new JLabel(
					"Current Unlocked Level: " + userLevel);
			lblCurrentUnlockedLevel.setBounds(354, 4, 181, 15);
			frame.getContentPane().add(lblCurrentUnlockedLevel);
		} else {
			JLabel lblCurrentUnlockedLevel = new JLabel(
					"Current Unlocked Level: ALL");
			lblCurrentUnlockedLevel.setBounds(354, 4, 181, 15);
			frame.getContentPane().add(lblCurrentUnlockedLevel);
		}

		JButton btnTutorial = new JButton("Tutorial");
		btnTutorial.setBounds(572, 0, 89, 23);
		frame.getContentPane().add(btnTutorial);
		btnTutorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TutorialWorldMap window = new TutorialWorldMap();
					window.frame.setVisible(true);
				} catch (Exception n) {
					n.printStackTrace();
				}
			}
		});

		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(666, 0, 117, 23);
		frame.getContentPane().add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o) {
				frame.dispose();// in future add some actions to feed the
								// database and reinitialize main map.
			}
		});

		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setBounds(0, 0, 783, 671);
		backgroundLabel.setIcon(new ImageIcon("images/WorldMap.jpg"));
		frame.getContentPane().add(backgroundLabel);

		/*
		 * Init Levels
		 */
		try {
			String queryMap = "select Level from Student where UName='"
					+ MapUserName + "'";
			PreparedStatement pstMap = connectionMap.prepareStatement(queryMap);
			ResultSet rsMap = pstMap.executeQuery();

			while (rsMap.next()) {
				userLevel = rsMap.getInt("Level");
			}
			rsMap.close();
			pstMap.close();

		} catch (Exception p) {
			JOptionPane.showMessageDialog(null, p);
			System.exit(1);
		}

		// JOptionPane.showMessageDialog(null, "level: " + userLevel);

		if (userLevel >= 1) {
			btnLevel_1.setEnabled(true);
		}
		if (userLevel >= 2) {
			btnLevel_2.setEnabled(true);
		}
		if (userLevel >= 3) {
			btnLevel_3.setEnabled(true);
		}
		if (userLevel >= 4) {
			btnLevel_4.setEnabled(true);
		}
		if (userLevel >= 5) {
			btnLevel_5.setEnabled(true);
		}
		if (userLevel >= 6) {
			btnLevel_6.setEnabled(true);
		}
		if (userLevel >= 7) {
			btnLevel_7.setEnabled(true);
		}

	}
}
