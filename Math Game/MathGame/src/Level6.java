import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextArea;

import java.awt.Font;
import java.sql.*;

public class Level6 {

	JFrame frame;

	String username;
	private int fails = 0;
	private boolean switch1 = false;
	private boolean switch2 = false;
	private boolean switch3 = false;

	private int buttonVal = 0;

	// set these values to the values in the database
	// the code below is fully functioning
	private boolean switch1Answer = false;
	private boolean switch2Answer = false;
	private boolean switch3Answer = false;
	private int buttonAnswer = 0;

	private int s1, s2, s3;

	Connection connection = sqliteConnection.dbConnector();
	{
		try {
			String query = "select * from Level6 order by rand() limit 1";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				buttonAnswer = rs.getInt("butVal");
				s1 = rs.getInt("switch1Val");
				s2 = rs.getInt("switch2Val");
				s3 = rs.getInt("switch3Val");
			}
			System.out
					.println(buttonAnswer + ", " + s1 + ", " + s2 + ", " + s3);
			rs.close();
			ps.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			System.exit(0);
		}
	}

	private int gkSwitch1 = 0;
	private int gkSwitch2 = 0;
	private int gkButton = 0;

	JButton btn1Red = new JButton("");
	JButton btn1Blue = new JButton("");
	JButton btn2Red = new JButton("");
	JButton btn2Blue = new JButton("");
	JButton btn3Red = new JButton("");
	JButton btn3Blue = new JButton("");

	private final JLabel robotLabel = new JLabel("");
	private final JButton switch1Off = new JButton("");
	private final JButton switch2Off = new JButton("");
	private final JButton switch3Off = new JButton("");
	private final JButton switch1On = new JButton("");
	private final JButton switch2On = new JButton("");
	private final JButton switch3On = new JButton("");

	private final JPanel levelComPanel = new JPanel();
	private final JPanel levelComBorder = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level6 window = new Level6("AHenley");
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
	public Level6(String UserName) {
		username = UserName;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		levelComBorder.setVisible(false);

		if (s1 == 0) {
			switch1Answer = false;
		}
		if (s1 == 1) {
			switch1Answer = true;
		}
		if (s2 == 0) {
			switch2Answer = false;
		}
		if (s2 == 1) {
			switch2Answer = true;
		}
		if (s3 == 0) {
			switch3Answer = false;
		}
		if (s3 == 1) {
			switch3Answer = true;
		}

		if (switch1Answer == true && switch2Answer == true
				&& switch3Answer == false) {
			gkSwitch1 = 100;
			gkSwitch2 = 10;
		}
		if (switch1Answer == true && switch2Answer == false
				&& switch3Answer == true) {
			gkSwitch1 = 100;
			gkSwitch2 = 1;
		}
		if (switch1Answer == false && switch2Answer == true
				&& switch3Answer == true) {
			gkSwitch1 = 10;
			gkSwitch2 = 1;
		}
		if (buttonAnswer == 1) {
			gkButton = 100;
		}
		if (buttonAnswer == 2) {
			gkButton = 10;
		}
		if (buttonAnswer == 3) {
			gkButton = 1;
		}

		frame = new JFrame();
		frame.setBounds(100, 100, 641, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		levelComBorder.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Congradulations!",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		levelComBorder.setBounds(117, 42, 343, 372);

		frame.getContentPane().add(levelComBorder);
		levelComBorder.setLayout(null);
		levelComPanel.setBounds(6, 18, 188, 348);
		levelComBorder.add(levelComPanel);

		JTextArea txtrAwesomeJobClick = new JTextArea();
		txtrAwesomeJobClick.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtrAwesomeJobClick.setWrapStyleWord(true);
		txtrAwesomeJobClick.setLineWrap(true);
		txtrAwesomeJobClick
				.setText("Awesome job! Click continue to get back to the map so you can play the final level.");
		levelComPanel.add(txtrAwesomeJobClick);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("images/star-icon.png"));
		label.setBounds(206, 48, 131, 177);
		levelComBorder.add(label);

		JButton btnContinue = new JButton("continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// update student DB info here
				frame.dispose();
				WorldMap window = new WorldMap(username);
				window.frame.setVisible(true);
			}
		});
		btnContinue.setBounds(209, 325, 117, 29);
		levelComBorder.add(btnContinue);

		btn1Red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonVal = 3;
				btn1Blue.setVisible(true);
				btn1Red.setVisible(false);
				btn2Red.setVisible(true);
				btn3Red.setVisible(true);

				System.out.println(buttonVal);
			}
		});

		btn1Red.setIcon(new ImageIcon("images/Button-Blank-Red-icon.png"));
		btn1Red.setBounds(109, 317, 25, 25);
		frame.getContentPane().add(btn1Red);
		btn1Blue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonVal = 0;
				btn1Blue.setVisible(false);
				btn1Red.setVisible(true);

				System.out.println(buttonVal);
			}
		});

		btn1Blue.setIcon(new ImageIcon("images/Button-Blank-Blue-icon.png"));
		btn1Blue.setBounds(109, 317, 25, 25);
		frame.getContentPane().add(btn1Blue);
		btn2Red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonVal = 2;
				btn2Red.setVisible(false);
				btn2Blue.setVisible(true);
				btn1Red.setVisible(true);
				btn3Red.setVisible(true);

				System.out.println(buttonVal);
			}
		});

		btn2Red.setIcon(new ImageIcon("images/Button-Blank-Red-icon.png"));
		btn2Red.setBounds(135, 317, 25, 25);
		frame.getContentPane().add(btn2Red);
		btn2Blue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonVal = 0;
				btn2Blue.setVisible(false);
				btn2Red.setVisible(true);

				System.out.println(buttonVal);
			}
		});

		btn2Blue.setIcon(new ImageIcon("images/Button-Blank-Blue-icon.png"));
		btn2Blue.setBounds(135, 317, 25, 25);
		frame.getContentPane().add(btn2Blue);
		btn3Red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonVal = 1;
				btn3Red.setVisible(false);
				btn3Blue.setVisible(true);
				btn1Red.setVisible(true);
				btn2Red.setVisible(true);

				System.out.println(buttonVal);
			}
		});

		btn3Red.setIcon(new ImageIcon("images/Button-Blank-Red-icon.png"));
		btn3Red.setBounds(162, 317, 25, 25);
		frame.getContentPane().add(btn3Red);
		btn3Blue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonVal = 0;
				btn3Red.setVisible(true);
				btn3Blue.setVisible(false);

				System.out.println(buttonVal);
			}
		});

		btn3Blue.setIcon(new ImageIcon("images/Button-Blank-Blue-icon.png"));
		btn3Blue.setBounds(162, 317, 25, 25);
		frame.getContentPane().add(btn3Blue);

		robotLabel.setIcon(new ImageIcon("images/Robot-icon (1).png"));
		robotLabel.setBounds(199, 240, 255, 238);
		frame.getContentPane().add(robotLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), "Total", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		panel.setBounds(0, -2, 470, 66);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel totalLabel = new JLabel("");
		totalLabel.setBounds(6, 18, 462, 39);
		panel.add(totalLabel);

		JButton submitButton = new JButton("submit");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (switch1 == switch1Answer && switch2 == switch2Answer
						&& switch3 == switch3Answer
						&& buttonVal == buttonAnswer) {
					levelComBorder.setVisible(true);
					System.out.println("Level Complete");

					try {

						String queryMap = "select Level from Student where UName='"
								+ username + "'";
						PreparedStatement pst = connection
								.prepareStatement(queryMap);
						ResultSet rs = pst.executeQuery();
						int userLevel = 0;
						while(rs.next()){
							userLevel= rs.getInt("Level");
						}

						rs.close();
						pst.close();

						if (userLevel < 7) {
							Statement stmt = connection.createStatement();
							String queryUpdate = "UPDATE Student SET Level=7 WHERE UName='"
									+ username + "'";
							stmt.execute(queryUpdate);

							stmt.close();
						}
						String entry="INSERT INTO Problem values( 0,'"+username+"', 'GGagne', 6, "+fails+")";
						java.sql.Statement pst_prob=connection.createStatement();
						pst_prob.executeUpdate(entry);
						pst_prob.close();
					} catch (Exception p) {
						JOptionPane.showMessageDialog(null, p);
						System.exit(1);
					}
				} else {
					System.out.println("fail");
					fails++;
				}
			}
		});
		submitButton.setBounds(524, 449, 117, 29);
		frame.getContentPane().add(submitButton);

		JButton resetButton = new JButton("reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fails++;
				switch1Off.setVisible(true);
				switch1On.setVisible(false);
				switch2Off.setVisible(true);
				switch2On.setVisible(false);
				switch3Off.setVisible(true);
				switch3On.setVisible(false);

				btn1Blue.setVisible(false);
				btn2Blue.setVisible(false);
				btn3Blue.setVisible(false);
				btn1Red.setVisible(true);
				btn2Red.setVisible(true);
				btn3Red.setVisible(true);

				buttonVal = 0;
				switch1 = false;
				switch2 = false;
				switch3 = false;
			}
		});
		resetButton.setBounds(511, 6, 130, 25);
		frame.getContentPane().add(resetButton);

		JButton mapButton = new JButton("back to map");
		mapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				WorldMap window = new WorldMap(username);
				window.frame.setVisible(true);
			}
		});
		mapButton.setBounds(511, 32, 130, 29);
		frame.getContentPane().add(mapButton);
		switch1Off.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch1 = true;
				switch1Off.setVisible(false);
				switch1On.setVisible(true);

				System.out.println(switch1 + ", " + switch2 + ", " + switch3);
			}
		});

		switch1Off.setIcon(new ImageIcon(
				"images/ui-slider-vertical-100-icon.png"));
		switch1Off.setBounds(482, 339, 19, 34);
		frame.getContentPane().add(switch1Off);
		switch2Off.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch2 = true;
				switch2Off.setVisible(false);
				switch2On.setVisible(true);

				System.out.println(switch1 + ", " + switch2 + ", " + switch3);
			}
		});

		switch2Off.setIcon(new ImageIcon(
				"images/ui-slider-vertical-100-icon.png"));
		switch2Off.setBounds(497, 339, 19, 34);
		frame.getContentPane().add(switch2Off);
		switch3Off.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch3 = true;
				switch3Off.setVisible(false);
				switch3On.setVisible(true);

				System.out.println(switch1 + ", " + switch2 + ", " + switch3);
			}
		});

		switch3Off.setIcon(new ImageIcon(
				"images/ui-slider-vertical-100-icon.png"));
		switch3Off.setBounds(511, 339, 19, 34);
		frame.getContentPane().add(switch3Off);
		switch1On.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch1 = false;
				switch1On.setVisible(false);
				switch1Off.setVisible(true);

				System.out.println(switch1 + ", " + switch2 + ", " + switch3);
			}
		});

		switch1On.setIcon(new ImageIcon("images/ui-slider-vertical-icon.png"));
		switch1On.setBounds(482, 339, 19, 34);
		frame.getContentPane().add(switch1On);
		switch2On.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch2 = false;
				switch2On.setVisible(false);
				switch2Off.setVisible(true);

				System.out.println(switch1 + ", " + switch2 + ", " + switch3);
			}
		});

		switch2On.setIcon(new ImageIcon("images/ui-slider-vertical-icon.png"));
		switch2On.setBounds(497, 339, 19, 34);
		frame.getContentPane().add(switch2On);
		switch3On.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch3 = false;
				switch3On.setVisible(false);
				switch3Off.setVisible(true);

				System.out.println(switch1 + ", " + switch2 + ", " + switch3);
			}
		});

		switch3On.setIcon(new ImageIcon("images/ui-slider-vertical-icon.png"));
		switch3On.setBounds(511, 339, 19, 34);
		frame.getContentPane().add(switch3On);

		JTextArea gkTextArea = new JTextArea();
		gkTextArea.setText("I need you to flip the switch in " + gkSwitch1
				+ " place, and the switch in the " + gkSwitch2
				+ " place, then push the button to my left in the " + gkButton
				+ " place.");
		gkTextArea.setWrapStyleWord(true);
		gkTextArea.setLineWrap(true);
		gkTextArea.setBounds(176, 147, 154, 112);
		frame.getContentPane().add(gkTextArea);

		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setBounds(0, 0, 641, 478);
		frame.getContentPane().add(backgroundLabel);
		backgroundLabel.setIcon(new ImageIcon("images/level6BackGround.jpg"));

	}
}
