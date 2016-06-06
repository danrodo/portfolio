import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Level5 {

	JFrame frame;
	JLabel childPos1 = new JLabel("");
	JLabel childPos2 = new JLabel("");
	JLabel childMonsterLabel = new JLabel("");
	JTextArea gkTextArea = new JTextArea();
	JLabel positionLabel = new JLabel("");

	String username;
	private int fails = 0;
	private int ans = 0;
	private int position = 0;
	private int lid3, mom, dad;
	private String Mom = null, Dad = null;
	Connection connection = sqliteConnection.dbConnector();
	{
		try {
			String query = "select * from Level3 order by rand() limit 1";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				lid3 = rs.getInt("LID3");
				mom = rs.getInt("Mom");
				dad = rs.getInt("Dad");
			}
			if (mom == 1) {
				ans = 1;
				Mom = "ones";
				Dad = "tens";
			} else {
				ans = 2;
				Mom = "tens";
				Dad = "hundreds";
			}

			System.out.println(lid3 + " " + mom + " " + dad);
			rs.close();
			pst.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			System.exit(0);
		}
	}

	JPanel levelComPanel = new JPanel();
	JPanel levelComBorder = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level5 window = new Level5("AHenley");
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
	public Level5(String UserName) {
		username = UserName;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 500);
		// frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		levelComBorder.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Level Complete",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		levelComBorder.setBounds(104, 66, 310, 267);
		frame.getContentPane().add(levelComBorder);
		levelComBorder.setLayout(null);
		levelComPanel.setBounds(6, 18, 122, 243);
		levelComBorder.add(levelComPanel);

		levelComBorder.setVisible(false);
		levelComPanel.setVisible(false);

		JTextArea txtrNiceJobYou = new JTextArea();
		txtrNiceJobYou.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		txtrNiceJobYou.setLineWrap(true);
		txtrNiceJobYou.setWrapStyleWord(true);
		txtrNiceJobYou
				.setText("Nice Job! You found the little monsters parents, click continue to move on.");
		levelComPanel.add(txtrNiceJobYou);

		JButton btnContinue = new JButton("continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// insert info into student table
				frame.dispose();
				WorldMap window = new WorldMap(username);
				window.frame.setVisible(true);
			}
		});
		btnContinue.setBounds(159, 232, 117, 29);
		levelComBorder.add(btnContinue);

		JLabel starLabel = new JLabel("");
		starLabel.setIcon(new ImageIcon("images/star-icon.png"));
		starLabel.setBounds(148, 18, 128, 202);
		levelComBorder.add(starLabel);

		childPos1.setEnabled(false);
		childPos1.setIcon(new ImageIcon("images/Purple-Monster-icon.png"));
		childPos1.setBounds(233, 384, 48, 48);
		frame.getContentPane().add(childPos1);

		JButton btnPlace1 = new JButton("place");
		btnPlace1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				childPos1.setEnabled(true);
				childPos2.setEnabled(false);
				childMonsterLabel.setEnabled(false);
				positionLabel.setText("00.0");

				position = 1;
			}
		});
		btnPlace1.setBounds(221, 430, 70, 29);
		frame.getContentPane().add(btnPlace1);

		childPos2.setEnabled(false);
		childPos2.setIcon(new ImageIcon("images/Purple-Monster-icon.png"));
		childPos2.setBounds(110, 363, 48, 48);
		frame.getContentPane().add(childPos2);

		JButton btnPlace2 = new JButton("place");
		btnPlace2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				childPos2.setEnabled(true);
				childPos1.setEnabled(false);
				childMonsterLabel.setEnabled(false);
				positionLabel.setText("0.00");

				position = 2;
			}
		});
		btnPlace2.setBounds(98, 411, 70, 29);
		frame.getContentPane().add(btnPlace2);

		JLabel monster1Label = new JLabel("");
		monster1Label.setIcon(new ImageIcon("images/Green-Monster-icon.png"));
		monster1Label.setBounds(6, 283, 121, 128);
		frame.getContentPane().add(monster1Label);

		JLabel monster2Label = new JLabel("");
		monster2Label.setIcon(new ImageIcon("images/Blue-Monster-icon.png"));
		monster2Label.setBounds(133, 304, 126, 128);
		frame.getContentPane().add(monster2Label);

		JLabel monster3Label = new JLabel("");
		monster3Label.setIcon(new ImageIcon("images/Orange-Monster-icon.png"));
		monster3Label.setBounds(245, 304, 121, 128);
		frame.getContentPane().add(monster3Label);

		childMonsterLabel.setIcon(new ImageIcon(
				"images/Purple-Monster-icon.png"));
		childMonsterLabel.setBounds(586, 424, 48, 48);
		frame.getContentPane().add(childMonsterLabel);

		JLabel gatekeeperLabel = new JLabel("");
		gatekeeperLabel.setIcon(new ImageIcon("images/Mermaid-icon.png"));
		gatekeeperLabel.setBounds(499, 363, 95, 96);
		frame.getContentPane().add(gatekeeperLabel);

		JPanel gkPanel = new JPanel();
		gkPanel.setBounds(427, 146, 137, 218);
		frame.getContentPane().add(gkPanel);

		gkTextArea.setWrapStyleWord(true);
		gkTextArea.setLineWrap(true);
		gkTextArea
				.setText("Can you help me return this little monster to his parents? I cant remember which two are his parents, but he remembers his mom being in the "
						+ Mom
						+ " place, and his dad being in the "
						+ Dad
						+ " place.");
		gkPanel.add(gkTextArea);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), "position", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 506, 62);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		positionLabel.setText("000.");
		positionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		positionLabel.setForeground(new Color(0, 0, 0));
		positionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		positionLabel.setBounds(6, 18, 494, 38);
		panel.add(positionLabel);

		JButton btnReset = new JButton("reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				position = 0;
				childPos2.setEnabled(false);
				childPos1.setEnabled(false);
				childMonsterLabel.setEnabled(true);
				positionLabel.setText("000.");
				gkTextArea
						.setText("Can you help me return this little monster to his parents? I cant remember which two are his parents, but he remembers his mom being in the "
								+ Mom
								+ " place, and his dad being in the "
								+ Dad + " place.");
				fails += 1;

				levelComBorder.setVisible(false);
				levelComPanel.setVisible(false);

			}
		});
		btnReset.setBounds(512, 6, 117, 29);
		frame.getContentPane().add(btnReset);

		JButton btnBackToMap = new JButton("back to map");
		btnBackToMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();// in future add some actions to feed the
								// database and reinitialize main map.
				WorldMap window = new WorldMap(username);
				window.frame.setVisible(true);
			}
		});
		btnBackToMap.setBounds(512, 29, 117, 29);
		frame.getContentPane().add(btnBackToMap);

		JButton btnSubmit = new JButton("submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (position == 0) {
					gkTextArea
							.setText("Use the place buttons to choose where to put this little guy.");
				} else if (position != ans) {
					gkTextArea
							.setText("One of those isnt his parents, keep trying!");
					fails += 1;
				} else if (position == ans) {
					gkTextArea.setText("You found his parents! Great job.");
					System.out.println("complete, fails = " + fails);

					try {

						String queryMap = "select Level from Student where UName='"
								+ username + "'";
						PreparedStatement pst = connection
								.prepareStatement(queryMap);
						ResultSet rs = pst.executeQuery();
						int userLevel = 0;
						while(rs.next()){
							userLevel = rs.getInt("Level");
						}

						rs.close();
						pst.close();

						if (userLevel < 6) {
							Statement stmt = connection.createStatement();
							String queryUpdate = "UPDATE Student SET Level=6 WHERE UName='"
									+ username + "'";
							stmt.execute(queryUpdate);

							stmt.close();
						}

						String entry="INSERT INTO Problem values( 0,'"+username+"', 'GGagne', 5, "+fails+")";
						java.sql.Statement pst_prob=connection.createStatement();
						pst_prob.executeUpdate(entry);
						pst_prob.close();
						
					} catch (Exception p) {
						JOptionPane.showMessageDialog(null, p);
						System.exit(1);
					}

					levelComBorder.setVisible(true);
					levelComPanel.setVisible(true);
				}
			}
		});
		btnSubmit.setBackground(Color.WHITE);
		btnSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		btnSubmit.setBounds(0, 62, 137, 48);
		frame.getContentPane().add(btnSubmit);

		JLabel bgLabel = new JLabel("");
		bgLabel.setBounds(0, 0, 640, 478);
		frame.getContentPane().add(bgLabel);
		bgLabel.setIcon(new ImageIcon("images/level5BG.jpg"));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(110, 84, 298, 243);
		frame.getContentPane().add(panel_1);

	}
}
