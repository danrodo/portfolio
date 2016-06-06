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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Level6Editable {

	JFrame frame;

	private String query;
	Connection connection = sqliteConnection.dbConnector();
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

	private int gkSwitch1 = 0;
	private int gkSwitch2 = 0;
	private int gkButton = 0;

	JButton btn1Red = new JButton("");
	JButton btn1Blue = new JButton("");
	JButton btn2Red = new JButton("");
	JButton btn2Blue = new JButton("");
	JButton btn3Red = new JButton("");
	JButton btn3Blue = new JButton("");

	JTextArea instructionTextarea = new JTextArea();

	private final JLabel robotLabel = new JLabel("");
	private final JButton switch1Off = new JButton("");
	private final JButton switch2Off = new JButton("");
	private final JButton switch3Off = new JButton("");
	private final JButton switch1On = new JButton("");
	private final JButton switch2On = new JButton("");
	private final JButton switch3On = new JButton("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level6Editable window = new Level6Editable();
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
	public Level6Editable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 641, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

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

		JButton saveButton = new JButton("save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (buttonVal == 0
						|| (switch1 == false && switch2 == false && switch3 == false)) {
					instructionTextarea
							.setText("Please select 1 button and two switches to save the problem.");
				} else {
					// execute query
					int s1, s2, s3;
					if (switch1 == true) {
						s1 = 1;
					} else {
						s1 = 0;
					}
					if (switch2 == true) {
						s2 = 1;
					} else {
						s2 = 0;
					}
					if (switch3 == true) {
						s3 = 1;
					} else {
						s3 = 0;
					}

					try {
						query = "INSERT INTO Level6 VALUES( 0," + buttonVal
								+ ", " + s1 + ", " + s2 + ", " + s3 + ")";
						instructionTextarea
								.setText("Problem saved, change the problem and click save again to create a new problem, or click cancel to go back.");
						PreparedStatement ps = connection.prepareStatement(query);
						ps.executeUpdate();
						System.out.println(query);
					} catch (Exception e3) {
						JOptionPane.showMessageDialog(null, e);
						System.exit(0);
					}

				}
			}
		});
		saveButton.setBounds(524, 449, 117, 29);
		frame.getContentPane().add(saveButton);

		JButton resetButton = new JButton("reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

				instructionTextarea
						.setText("Select two of the switches to the right, and one of the buttons to the left for the problem.");
			}
		});
		resetButton.setBounds(511, 6, 130, 25);
		frame.getContentPane().add(resetButton);

		JButton cancelButton = new JButton("cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		cancelButton.setBounds(511, 32, 130, 29);
		frame.getContentPane().add(cancelButton);
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

		instructionTextarea.setWrapStyleWord(true);
		instructionTextarea.setLineWrap(true);
		instructionTextarea
				.setText("Select two of the switches to the right, and one of the buttons to the left for the problem.");
		instructionTextarea.setBounds(181, 112, 152, 94);
		frame.getContentPane().add(instructionTextarea);

		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setBounds(0, 0, 641, 478);
		frame.getContentPane().add(backgroundLabel);
		backgroundLabel.setIcon(new ImageIcon("images/level6BackGround.jpg"));

	}
}
