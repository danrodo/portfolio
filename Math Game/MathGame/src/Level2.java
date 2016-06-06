import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Font;

public class Level2 {

	JFrame frame;
	private int total = 0;
	private int fails = 0;
	String username;
	public int lid2, npC1, npC2, npC3, npC4, npC5, gatekeeper2;
	Connection connection = sqliteConnection.dbConnector();
	{
		try {
			String query = "select * from Level2 order by rand() limit 1";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				lid2 = rs.getInt("LID2");
				npC1 = rs.getInt("NPC1");
				npC2 = rs.getInt("NPC2");
				npC3 = rs.getInt("NPC3");
				npC4 = rs.getInt("NPC4");
				npC5 = rs.getInt("NPC5");
				gatekeeper2 = rs.getInt("NPC6");
			}
			System.out.println(npC1 + " " + npC2 + " " + npC3 + " " + npC4
					+ " " + npC5 + " " + gatekeeper2);
			rs.close();
			pst.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	private String equation = "0";

	private boolean button1Clicked = false;
	private boolean button2Clicked = false;
	private boolean button3Clicked = false;
	private boolean button4Clicked = false;
	private boolean button5Clicked = false;

	private JLabel totalLabel = new JLabel("");
	JTextArea gatkeeperTextfield = new JTextArea();
	JPanel levelComBorder = new JPanel();
	JPanel levelComPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level2 window = new Level2("AHenley");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Level2(String UserName) {
		username = UserName;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 499);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		levelComBorder.setVisible(false);
		levelComPanel.setVisible(false);

		levelComBorder.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Nice Job!",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		levelComBorder.setBounds(133, 68, 301, 304);
		frame.getContentPane().add(levelComBorder);
		levelComBorder.setLayout(null);

		levelComPanel.setBounds(6, 18, 147, 280);
		levelComBorder.add(levelComPanel);

		JTextArea txtrWellDoneYou = new JTextArea();
		txtrWellDoneYou.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		txtrWellDoneYou.setWrapStyleWord(true);
		txtrWellDoneYou.setLineWrap(true);
		txtrWellDoneYou
				.setText("Well done! you finished level 2, click continue to keep going!");
		levelComPanel.add(txtrWellDoneYou);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("images/star-icon.png"));
		label.setBounds(161, 20, 134, 233);
		levelComBorder.add(label);

		JButton btnContinue = new JButton("continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				WorldMap window = new WorldMap(username);
				window.frame.setVisible(true);
			}
		});
		btnContinue.setBounds(171, 269, 117, 29);
		levelComBorder.add(btnContinue);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Total",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_1.setBounds(0, 412, 525, 61);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		totalLabel.setBounds(6, 18, 502, 37);
		panel_1.add(totalLabel);

		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total = 0;
				button1Clicked = false;
				button2Clicked = false;
				button3Clicked = false;
				button4Clicked = false;
				button5Clicked = false;

				fails++;
				equation = "0";
				totalLabel.setText(equation);
			}
		});
		resetButton.setBounds(523, 407, 117, 29);
		frame.getContentPane().add(resetButton);

		JButton mapButton = new JButton("Back to map");
		mapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();

			}
		});
		mapButton.setBounds(523, 432, 117, 29);
		frame.getContentPane().add(mapButton);
		mapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				WorldMap window = new WorldMap(username);
				window.frame.setVisible(true);
			}
		});

		JLabel gateKeeperLabel = new JLabel("");
		gateKeeperLabel.setIcon(new ImageIcon("images/Santa-icon.png"));
		gateKeeperLabel.setBounds(0, 283, 70, 83);
		frame.getContentPane().add(gateKeeperLabel);

		JButton gateKeeperButton = new JButton("give");
		gateKeeperButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int finalVal = gatekeeper2;
				equation = equation + " = " + total;
				totalLabel.setText(equation);
				if (total == finalVal) {
					System.out.println("level complete: number of fails- "
							+ fails);
					gatkeeperTextfield
							.setText("That is the perfect amount of bells!");
					equation = "0";

					try {

						String queryMap = "select Level from Student where UName='"
								+ username + "'";
						PreparedStatement pst = connection.prepareStatement(queryMap);
						ResultSet rs = pst.executeQuery();
						
						int userLevel = 0;
						while(rs.next()){
							userLevel = rs.getInt("Level");
						}
						rs.close();
						pst.close();

						if (userLevel < 3) {
							Statement stmt = connection.createStatement();
							String queryUpdate = "UPDATE Student SET Level=3 WHERE UName='"
									+ username + "'";
							stmt.execute(queryUpdate);

							stmt.close();
						}
						
						String entry="INSERT INTO Problem values( 0,'"+username+"', 'GGagne', 2, "+fails+")";
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
					System.out.println("level failed");
					gatkeeperTextfield
							.setText("This is the wrong amount, try again");
					equation = "0";
					fails++;
					total = 0;
					button1Clicked = false;
					button2Clicked = false;
					button3Clicked = false;
					button4Clicked = false;
					button5Clicked = false;
				}
			}
		});
		gateKeeperButton.setBounds(0, 353, 70, 29);
		frame.getContentPane().add(gateKeeperButton);

		JLabel npc1 = new JLabel("");
		npc1.setIcon(new ImageIcon("images/Snowman-icon.png"));
		npc1.setBounds(532, 311, 70, 71);
		frame.getContentPane().add(npc1);

		JButton npc1Button = new JButton("Take");
		npc1Button.setBounds(532, 374, 70, 29);
		frame.getContentPane().add(npc1Button);
		npc1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bellVal = npC1;
				if (button1Clicked == false) {
					total = total + bellVal;
					button1Clicked = true;

					equation = equation + " + " + bellVal;
					totalLabel.setText(equation);
					System.out.println(total);
				}
			}
		});

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(473, 297, 161, 16);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		JLabel npc1Text = new JLabel("I've got " + npC1 + " bells to spare");
		npc1Text.setHorizontalAlignment(SwingConstants.CENTER);
		npc1Text.setBounds(0, 0, 155, 16);
		panel_4.add(npc1Text);

		JLabel npc2 = new JLabel("");
		npc2.setIcon(new ImageIcon("images/Ninja-icon.png"));
		npc2.setBounds(273, 321, 48, 61);
		frame.getContentPane().add(npc2);

		JButton noc2Button = new JButton("Take");
		noc2Button.setBounds(273, 374, 70, 29);
		frame.getContentPane().add(noc2Button);
		noc2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bellVal = npC2;
				if (button2Clicked == false) {
					total = total + bellVal;
					button2Clicked = true;

					equation = equation + " + " + bellVal;
					totalLabel.setText(equation);
					System.out.println(total);
				}
			}
		});

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(218, 311, 161, 16);
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);

		JLabel npc2Text = new JLabel("Take these " + npC2 + " silent bells!");
		npc2Text.setBounds(0, 0, 161, 16);
		panel_5.add(npc2Text);
		npc2Text.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel npc3 = new JLabel("");
		npc3.setIcon(new ImageIcon("images/Firefighter-icon.png"));
		npc3.setBounds(391, 283, 57, 61);
		frame.getContentPane().add(npc3);

		JButton npc3Button = new JButton("Take");
		npc3Button.setBounds(391, 337, 70, 29);
		frame.getContentPane().add(npc3Button);
		npc3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bellVal = npC3;
				if (button3Clicked == false) {
					total = total + bellVal;
					button3Clicked = true;

					equation = equation + " + " + bellVal;
					totalLabel.setText(equation);
					System.out.println(total);
				}
			}
		});

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(317, 269, 212, 16);
		frame.getContentPane().add(panel_6);
		panel_6.setLayout(null);

		JLabel npc3Text = new JLabel("Here's " + npC3
				+ " bells if you need them");
		npc3Text.setBounds(0, 0, 212, 16);
		panel_6.add(npc3Text);
		npc3Text.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel npc4 = new JLabel("");
		npc4.setIcon(new ImageIcon("images/Dragon-icon.png"));
		npc4.setBounds(151, 114, 48, 53);
		frame.getContentPane().add(npc4);

		JButton npc4Button = new JButton("Take");
		npc4Button.setBounds(146, 160, 70, 29);
		frame.getContentPane().add(npc4Button);
		npc4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bellVal = npC4;
				if (button4Clicked == false) {
					total = total + bellVal;
					button4Clicked = true;

					equation = equation + " + " + bellVal;
					totalLabel.setText(equation);
					System.out.println(total);
				}
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(88, 98, 181, 16);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel npc4Text = new JLabel("I suppose i can give you " + npC4
				+ " ...");
		npc4Text.setHorizontalAlignment(SwingConstants.CENTER);
		npc4Text.setBounds(0, 0, 208, 16);
		panel_2.add(npc4Text);

		JLabel npc5 = new JLabel("");
		npc5.setIcon(new ImageIcon("images/Knight-icon.png"));
		npc5.setBounds(273, 170, 57, 53);
		frame.getContentPane().add(npc5);

		JButton npc5Button = new JButton("Take");
		npc5Button.setBounds(273, 212, 70, 29);
		frame.getContentPane().add(npc5Button);
		npc5Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bellVal = npC5;
				if (button5Clicked == false) {
					total = total + bellVal;
					button5Clicked = true;

					equation = equation + " + " + bellVal;
					totalLabel.setText(equation);
					System.out.println(total);
				}
			}
		});

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(226, 151, 145, 16);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JLabel npc5Text = new JLabel("Please, take " + npC5 + " of mine");
		npc5Text.setBounds(0, 0, 145, 16);
		panel_3.add(npc5Text);
		npc5Text.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel = new JPanel();
		panel.setBounds(18, 208, 110, 91);
		frame.getContentPane().add(panel);

		gatkeeperTextfield.setWrapStyleWord(true);
		gatkeeperTextfield.setLineWrap(true);
		gatkeeperTextfield.setColumns(6);
		gatkeeperTextfield.setTabSize(4);
		gatkeeperTextfield
				.setText("Find me "
						+ gatekeeper2
						+ " bells, and I'll let your borrow my sleigh to get to the ocean");
		gatkeeperTextfield.setRows(6);
		panel.add(gatkeeperTextfield);

		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(new ImageIcon("images/level2Background.jpg"));
		backgroundLabel.setBounds(0, 0, 640, 475);
		frame.getContentPane().add(backgroundLabel);

	}
}
