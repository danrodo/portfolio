import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TutorialWorldMap {

	JFrame frame;
	private int progression;
	private JTextArea txtrWelcomeToThe;
	private JButton okbuttonwelcome;
	private JPanel welcomepanel;
	private JButton btnLogout;
	private JButton additionlevelbutton;
	private JButton subtractionlevelbutton;
	private JButton placeholderlevelbutton;
	private JTextPane welcomesection;
	private JTextPane currentunlockedlevelsection;
	private JLabel lblNewLabel;
	private JButton nextMap;
	private JButton backMap;
	private JTextArea backnextbuttontext;
	private JTextArea donetext;
	private JTextArea welcometext;
	private JTextArea currentunlockedleveltext;
	private JTextArea levelstext;
	private JTextArea logouttext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TutorialWorldMap window = new TutorialWorldMap();
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
	public TutorialWorldMap() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		progression = 0;

		frame = new JFrame();
		frame.setBounds(100, 100, 640, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnMap = new JButton("Done");
		btnMap.setBounds(546, 393, 69, 23);
		btnMap.setVisible(true);
		frame.getContentPane().add(btnMap);
		btnMap.addActionListener(new donebuttonhandler());

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(498, 5, 117, 29);
		frame.getContentPane().add(btnLogout);
		btnLogout.setVisible(false);

		additionlevelbutton = new JButton("Addition");
		additionlevelbutton.setBounds(435, 85, 89, 23);
		frame.getContentPane().add(additionlevelbutton);
		additionlevelbutton.setVisible(false);
		additionlevelbutton.addActionListener(new additionbuttonhandler());

		subtractionlevelbutton = new JButton("Subtraction");
		subtractionlevelbutton.setBounds(471, 280, 110, 23);
		frame.getContentPane().add(subtractionlevelbutton);
		subtractionlevelbutton.setVisible(false);
		subtractionlevelbutton
				.addActionListener(new subtractionbuttonhandler());

		placeholderlevelbutton = new JButton("Placeholder");
		placeholderlevelbutton.setBounds(188, 253, 115, 23);
		frame.getContentPane().add(placeholderlevelbutton);
		placeholderlevelbutton.setVisible(false);
		placeholderlevelbutton
				.addActionListener(new placeholderbuttonhandler());

		welcomesection = new JTextPane();
		welcomesection.setText("Welcome:");
		welcomesection.setBounds(10, 5, 110, 20);
		frame.getContentPane().add(welcomesection);
		welcomesection.setVisible(false);

		currentunlockedlevelsection = new JTextPane();
		currentunlockedlevelsection.setText("Current Unlocked Level:Addition");
		currentunlockedlevelsection.setBounds(214, 5, 230, 20);
		frame.getContentPane().add(currentunlockedlevelsection);
		currentunlockedlevelsection.setVisible(false);

		nextMap = new JButton("Next");
		nextMap.setBounds(214, 393, 89, 23);
		frame.getContentPane().add(nextMap);
		nextMap.setVisible(false);
		nextMap.addActionListener(new nextMapButtonHandler());

		backMap = new JButton("Back");
		backMap.setBounds(112, 393, 89, 23);
		frame.getContentPane().add(backMap);
		backMap.setVisible(false);
		backMap.addActionListener(new backMapButtonHandler());

		welcometext = new JTextArea();
		welcometext.setBounds(6, 35, 195, 155);
		frame.getContentPane().add(welcometext);
		welcometext.setTabSize(0);
		welcometext.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		welcometext
				.setText("This area up here is where the game shows who's playing it. We wouldn't want someone else to play your game and then not get credit for completing the levels now would we? Make sure your name is up here when you start playing.");
		welcometext.setWrapStyleWord(true);
		welcometext.setLineWrap(true);
		welcometext.setVisible(false);

		backnextbuttontext = new JTextArea();
		backnextbuttontext.setBounds(56, 287, 250, 95);
		frame.getContentPane().add(backnextbuttontext);
		backnextbuttontext.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		backnextbuttontext.setWrapStyleWord(true);
		backnextbuttontext.setLineWrap(true);
		backnextbuttontext
				.setText("Over here we have our \"next\" and \"back\" buttons. When you're ready to see the next part of the tutorial, click \"next\". If you didn't catch something and want to see it again, click \"back\"");
		backnextbuttontext.setVisible(false);

		levelstext = new JTextArea();
		levelstext.setBounds(248, 116, 259, 126);
		frame.getContentPane().add(levelstext);
		levelstext.setWrapStyleWord(true);
		levelstext.setLineWrap(true);
		levelstext.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		levelstext
				.setText("And finally, this is a level. You play the levels to progress throught the game.  Since this is the tutorial, there are only 3 levels, but they will teach you everything you need to know. Are you ready to play? click on one of the levels to start!");
		levelstext.setVisible(false);

		logouttext = new JTextArea();
		logouttext.setBounds(458, 45, 156, 144);
		frame.getContentPane().add(logouttext);
		logouttext.setWrapStyleWord(true);
		logouttext.setLineWrap(true);
		logouttext.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		logouttext
				.setText("Above is the logout button. When you're done playing the game for now, you can save your progress by logging out. Once you have logged out, you can do something else");
		logouttext.setVisible(false);

		donetext = new JTextArea();
		donetext.setBounds(387, 304, 204, 78);
		frame.getContentPane().add(donetext);
		donetext.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		donetext.setWrapStyleWord(true);
		donetext.setLineWrap(true);
		donetext.setText("If at any time you wish to go back to the main game, click this done button to exit the tutorial");
		donetext.setVisible(false);

		currentunlockedleveltext = new JTextArea();
		currentunlockedleveltext.setBounds(214, 36, 211, 123);
		frame.getContentPane().add(currentunlockedleveltext);
		currentunlockedleveltext.setFont(new Font("Times New Roman",
				Font.PLAIN, 15));
		currentunlockedleveltext.setWrapStyleWord(true);
		currentunlockedleveltext.setLineWrap(true);
		currentunlockedleveltext
				.setText("The area above shows the current level that you've just unlocked. As you progress further, you unlock more levels to play. If a level has recently been unlocked, you should probably play it.");
		currentunlockedleveltext.setVisible(false);

		welcomepanel = new JPanel();
		welcomepanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		welcomepanel.setBounds(248, 143, 167, 144);
		frame.getContentPane().add(welcomepanel);
		welcomepanel.setLayout(null);

		txtrWelcomeToThe = new JTextArea();
		txtrWelcomeToThe.setBounds(10, 11, 147, 89);
		welcomepanel.add(txtrWelcomeToThe);
		txtrWelcomeToThe.setWrapStyleWord(true);
		txtrWelcomeToThe.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtrWelcomeToThe
				.setText("Welcome to the tutorial! The first area we are going to learn about is the map, are you ready to learn?");
		txtrWelcomeToThe.setLineWrap(true);

		okbuttonwelcome = new JButton("OK");
		okbuttonwelcome.setBounds(21, 103, 120, 30);
		welcomepanel.add(okbuttonwelcome);
		okbuttonwelcome.addActionListener(new okbuttonhandler());

		lblNewLabel = new JLabel("map");
		lblNewLabel.setIcon(new ImageIcon("images/worldmap2.jpg"));
		lblNewLabel.setBounds(0, 0, 625, 429);
		frame.getContentPane().add(lblNewLabel);

	}

	public class donebuttonhandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
		}

	}

	public class okbuttonhandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			txtrWelcomeToThe.setVisible(false);
			okbuttonwelcome.setVisible(false);
			welcomepanel.setVisible(false);
			btnLogout.setVisible(true);
			additionlevelbutton.setVisible(true);
			welcomesection.setVisible(true);
			currentunlockedlevelsection.setVisible(true);
			backMap.setVisible(true);
			nextMap.setVisible(true);
			backnextbuttontext.setVisible(true);
			progression++;
		}

	}

	public class additionbuttonhandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (progression == 7) {
				Level1Tutorial jes = new Level1Tutorial();
				subtractionlevelbutton.setVisible(true);
				currentunlockedlevelsection
						.setText("Current Unlocked Level:Subtraction");
				progression++;
			}
		}
	}

	public class subtractionbuttonhandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (progression == 8) {
				Level2Tutorial ned = new Level2Tutorial();
				placeholderlevelbutton.setVisible(true);
				currentunlockedlevelsection
						.setText("Current Unlocked Level:Placeholder");
				progression++;
			}

		}
	}

	public class placeholderbuttonhandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (progression == 9) {
				Level3Tutorial grah = new Level3Tutorial();
				progression++;
			}
		}
	}

	public class nextMapButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println(progression);
			if (progression == 0) {
				backnextbuttontext.setVisible(true);

				txtrWelcomeToThe.setVisible(false);
				okbuttonwelcome.setVisible(false);
				welcomepanel.setVisible(false);
				placeholderlevelbutton.setVisible(true);
				progression++;
				// System.out.println(progression);
			} else if (progression == 1) {
				backnextbuttontext.setVisible(false);
				donetext.setVisible(true);
				progression++;
				// System.out.println(progression);
			} else if (progression == 2) {
				donetext.setVisible(false);
				welcometext.setVisible(true);
				progression++;
				// System.out.println(progression);
			} else if (progression == 3) {
				currentunlockedleveltext.setVisible(true);
				welcometext.setVisible(false);
				progression++;
			} else if (progression == 4) {
				logouttext.setVisible(true);
				currentunlockedleveltext.setVisible(false);
				additionlevelbutton.setVisible(false);
				progression++;

			} else if (progression == 5) {
				levelstext.setVisible(true);
				logouttext.setVisible(false);
				additionlevelbutton.setVisible(true);
				progression++;
			} else if (progression == 6) {
				levelstext.setVisible(false);
				progression++;
			}

		}
	}

	public class backMapButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (progression == 1) {
				txtrWelcomeToThe.setVisible(true);
				okbuttonwelcome.setVisible(true);
				welcomepanel.setVisible(true);

				backnextbuttontext.setVisible(false);
				placeholderlevelbutton.setVisible(false);
				progression--;
			} else if (progression == 2) {
				backnextbuttontext.setVisible(true);
				donetext.setVisible(false);
				progression--;
			} else if (progression == 3) {
				donetext.setVisible(true);
				welcometext.setVisible(false);
				progression--;
			} else if (progression == 4) {
				currentunlockedleveltext.setVisible(false);
				welcometext.setVisible(true);
				progression--;

			} else if (progression == 5) {
				logouttext.setVisible(false);
				currentunlockedleveltext.setVisible(true);
				additionlevelbutton.setVisible(true);
				progression--;

			}
		}
	}
}
