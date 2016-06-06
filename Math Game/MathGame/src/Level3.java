import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.*;

public class Level3 {

	JFrame frame;

	private String username;

	private int fails = 0;
	// keeps track of the total throughout, resets to the given total when level
	// is failed or reset
	private int total = 0;

	// next 5 vals must be synced to DB
	private int totalVal = 0;
	private int answerVal = 0;

	private int house1Val = 0;
	private int house2Val = 0;
	private int house3Val = 0;

	Connection connection = sqliteConnection.dbConnector();
	{
		try {
			String query = "select * from Level3Sub order by rand() limit 1";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				house1Val = rs.getInt("h1");
				house2Val = rs.getInt("h2");
				house3Val = rs.getInt("h3");
				totalVal = rs.getInt("giv");
				answerVal = rs.getInt("ans");
			}
			pst.close();
			rs.close();

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2);
			System.exit(0);
		}
	}

	// used to display the numerical equation
	private String equation = "";

	// initializes these swing components as global so that they can be
	// manipulated throughout
	JLabel totalLabel = new JLabel("");

	JLabel gift1Label = new JLabel("");
	JLabel gift2Label = new JLabel("");
	JLabel gift3Label = new JLabel("");
	JLabel gift4Label = new JLabel("");
	JLabel gift5Label = new JLabel("");
	JLabel gift6Label = new JLabel("");
	JLabel gift7Label = new JLabel("");
	JLabel gift8Label = new JLabel("");
	JLabel gift9Label = new JLabel("");
	JLabel gift10Label = new JLabel("");

	JTextArea gkTextArea = new JTextArea();

	private final JButton btnSubmit = new JButton("Submit");
	private final JButton house1Button = new JButton("Deliver");
	private final JButton house2Button = new JButton("Deliver");
	private final JButton house3Button = new JButton("Deliver");
	private final JButton tryAgainButton = new JButton("Try Again");

	JPanel levelComPanel = new JPanel();
	private final JPanel levelComBorder = new JPanel();
	private final JTextArea txtrNicelyDoneYouve = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level3 window = new Level3("AHenley");
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
	public Level3(String UserName) {
		username = UserName;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 649, 496);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		levelComBorder.setVisible(false);
		// sets total to total value, and initializes the initial equation
		total = totalVal;
		equation = equation + totalVal;
		totalLabel.setText(equation);
		levelComBorder.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Congrdulations!",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		levelComBorder.setBounds(129, 50, 362, 345);

		frame.getContentPane().add(levelComBorder);
		levelComBorder.setLayout(null);
		levelComPanel.setBounds(6, 18, 140, 321);
		levelComBorder.add(levelComPanel);
		txtrNicelyDoneYouve.setWrapStyleWord(true);
		txtrNicelyDoneYouve.setLineWrap(true);
		txtrNicelyDoneYouve.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		txtrNicelyDoneYouve
				.setText("Nicely done! You've completed level 3, click continue to move on.");

		levelComPanel.add(txtrNicelyDoneYouve);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("images/star-icon.png"));
		label.setBounds(193, 46, 128, 176);
		levelComBorder.add(label);

		JButton btnContinue = new JButton("continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// update student table here
				frame.dispose();
				WorldMap window = new WorldMap(username);
				window.frame.setVisible(true);
			}
		});
		btnContinue.setBounds(204, 310, 117, 29);
		levelComBorder.add(btnContinue);

		// the initialization of the graphical labels that are displayed
		gift8Label.setIcon(new ImageIcon("images/gift-blue-icon.png"));
		gift8Label.setBounds(390, 424, 38, 34);
		frame.getContentPane().add(gift8Label);

		JLabel gkLabel = new JLabel("");
		gkLabel.setIcon(new ImageIcon("images/santa-relax-summer-icon.png"));
		gkLabel.setBounds(496, 346, 153, 128);
		frame.getContentPane().add(gkLabel);

		gift2Label.setIcon(new ImageIcon("images/gift-green-icon.png"));
		gift2Label.setBounds(465, 418, 31, 34);
		frame.getContentPane().add(gift2Label);

		gift4Label.setIcon(new ImageIcon("images/gift-red-white-icon.png"));
		gift4Label.setBounds(440, 418, 31, 40);
		frame.getContentPane().add(gift4Label);

		gift3Label.setIcon(new ImageIcon("images/gift-red-icon.png"));
		gift3Label.setBounds(448, 386, 48, 48);
		frame.getContentPane().add(gift3Label);

		gift5Label.setIcon(new ImageIcon("images/gift-stars-icon.png"));
		gift5Label.setBounds(409, 418, 31, 38);
		frame.getContentPane().add(gift5Label);

		gift1Label.setIcon(new ImageIcon("images/gift-blue-icon.png"));
		gift1Label.setBounds(420, 401, 31, 34);
		frame.getContentPane().add(gift1Label);

		gkTextArea.setWrapStyleWord(true);
		gkTextArea.setLineWrap(true);
		gkTextArea
				.setText("Its been a long night, can you deliver some of these present so that we have "
						+ answerVal + " left for the last stop?");
		gkTextArea.setBounds(509, 238, 104, 122);
		frame.getContentPane().add(gkTextArea);

		gift6Label.setIcon(new ImageIcon("images/gift-green-icon.png"));
		gift6Label.setBounds(370, 418, 38, 34);
		frame.getContentPane().add(gift6Label);

		gift7Label.setIcon(new ImageIcon("images/gift-red-white-icon.png"));
		gift7Label.setBounds(390, 401, 38, 34);
		frame.getContentPane().add(gift7Label);

		gift9Label.setIcon(new ImageIcon("images/gift-stars-icon.png"));
		gift9Label.setBounds(359, 400, 38, 34);
		frame.getContentPane().add(gift9Label);

		gift10Label.setIcon(new ImageIcon("images/gift-red-icon.png"));
		gift10Label.setBounds(391, 372, 53, 48);
		frame.getContentPane().add(gift10Label);

		// resets the level but increments fails, so if you choose to reset the
		// level you are essentially failing it
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tryAgainButton.setVisible(false);
				btnSubmit.setVisible(true);

				fails++;
				total = totalVal;
				equation = "" + totalVal;
				totalLabel.setText(equation);
				gkTextArea
						.setText("Its been a long night, can you deliver some of these present so that we have "
								+ answerVal + " left for the last stop?");

				gift1Label.setVisible(true);
				gift2Label.setVisible(true);
				gift3Label.setVisible(true);
				gift4Label.setVisible(true);
				gift5Label.setVisible(true);
				gift6Label.setVisible(true);
				gift7Label.setVisible(true);
				gift8Label.setVisible(true);
				gift9Label.setVisible(true);
				gift10Label.setVisible(true);
			}
		});
		resetButton.setBounds(496, 0, 117, 29);
		frame.getContentPane().add(resetButton);

		// disposes the frame making the map visible again
		JButton backToMapBtn = new JButton("Back to Map");
		backToMapBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// update student table fails here
				frame.dispose();
				WorldMap window = new WorldMap(username);
				window.frame.setVisible(true);
			}
		});
		backToMapBtn.setBounds(496, 30, 117, 29);
		frame.getContentPane().add(backToMapBtn);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED,
				null, null), "Total", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		panel.setBounds(13, -2, 433, 58);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		totalLabel.setBounds(6, 18, 421, 34);
		panel.add(totalLabel);

		// checks if the total is equal to the desired answer, if not it changes
		// the GK text area to help
		// the student find the right answer, or if the answer is right it will
		// display the level complete frame
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equation = equation + " = " + total;
				totalLabel.setText(equation);
				if (total != answerVal) {
					btnSubmit.setVisible(false);
					tryAgainButton.setVisible(true);
					fails++;
					System.out.println("level failed");
					fails++;
					if (total < answerVal) {
						gkTextArea
								.setText("You gave out to many presents, we wont have enough for the last house!");
					}
					if (total > answerVal) {
						gkTextArea
								.setText("We still have a few more presents to give out! Try delivering them again.");
					}
				} else if (total == answerVal) {
					levelComBorder.setVisible(true);
					System.out.println("level complete: " + fails);

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

						if (userLevel < 4) {
							Statement stmt = connection.createStatement();
							String queryUpdate = "UPDATE Student SET Level=4 WHERE UName='"
									+ username + "'";
							stmt.execute(queryUpdate);

							stmt.close();
						}
						
						String entry="INSERT INTO Problem values( 0,'"+username+"', 'GGagne', 3, "+fails+")";
						java.sql.Statement pst_prob=connection.createStatement();
						pst_prob.executeUpdate(entry);
						pst_prob.close();
					} catch (Exception p) {
						JOptionPane.showMessageDialog(null, p);
						System.exit(1);
					}
				}
			}
		});

		btnSubmit.setBounds(6, 54, 117, 29);
		frame.getContentPane().add(btnSubmit);

		// the house buttons manipulate the equation, and the total value
		house1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equation = equation + " - " + house1Val;
				totalLabel.setText(equation);
				total = total - house1Val;
			}
		});

		house1Button.setBounds(174, 418, 78, 29);
		frame.getContentPane().add(house1Button);
		house2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equation = equation + " - " + house2Val;
				totalLabel.setText(equation);
				total = total - house2Val;
			}
		});

		house2Button.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		house2Button.setBounds(355, 346, 53, 14);
		frame.getContentPane().add(house2Button);
		house3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equation = equation + " - " + house3Val;
				totalLabel.setText(equation);
				total = total - house3Val;
			}
		});

		house3Button.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		house3Button.setBounds(423, 332, 48, 14);
		frame.getContentPane().add(house3Button);

		// this button is displayed if the student gets the problem wrong, it
		// resets the equation and total val
		// I created this button so that the student would have the option to
		// reflect on the equation he got wrong
		// so that he/ she can get it right the next time
		tryAgainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equation = "" + totalVal;
				totalLabel.setText(equation);
				total = totalVal;

				gkTextArea
						.setText("Its been a long night, can you deliver some of these present so that we have "
								+ answerVal + " left for the last stop?");
				tryAgainButton.setVisible(false);
				btnSubmit.setVisible(true);
			}
		});

		tryAgainButton.setBounds(6, 54, 117, 29);
		frame.getContentPane().add(tryAgainButton);

		final JLabel houseLabel = new JLabel(house1Val + " kids");
		houseLabel.setBounds(185, 331, 48, 29);
		frame.getContentPane().add(houseLabel);

		final JLabel house2Label = new JLabel(house2Val + " kids");
		house2Label.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		house2Label.setBounds(359, 292, 38, 29);
		frame.getContentPane().add(house2Label);

		final JLabel house3Label = new JLabel(house3Val + " kids");
		house3Label.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		house3Label.setBounds(433, 298, 38, 29);
		frame.getContentPane().add(house3Label);

		JLabel bgLabel = new JLabel("");
		bgLabel.setIcon(new ImageIcon("images/Winter-landscapes-3.jpg"));
		bgLabel.setBounds(0, 0, 649, 474);
		frame.getContentPane().add(bgLabel);

	}
}
