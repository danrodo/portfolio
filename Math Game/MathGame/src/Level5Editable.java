import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class Level5Editable {

	JFrame frame;
	JLabel childPos1 = new JLabel("");
	JLabel childPos2 = new JLabel("");
	JLabel childMonsterLabel = new JLabel("");
	JLabel positionLabel = new JLabel("");
	private JLabel TotalLabel;

	boolean place1 = false;
	boolean place2 = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level5Editable window = new Level5Editable();
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
	public Level5Editable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 661, 511);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel TotalPanel = new JPanel();
		TotalPanel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Total",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		TotalPanel.setBounds(0, 0, 499, 76);
		frame.getContentPane().add(TotalPanel);
		TotalPanel.setLayout(null);

		childPos1.setEnabled(false);
		childPos1.setIcon(new ImageIcon("images/Purple-Monster-icon.png"));
		childPos1.setBounds(233, 384, 48, 48);
		frame.getContentPane().add(childPos1);

		childPos2.setEnabled(false);
		childPos2.setIcon(new ImageIcon("images/Purple-Monster-icon.png"));
		childPos2.setBounds(110, 363, 48, 48);
		frame.getContentPane().add(childPos2);

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

		childMonsterLabel.setIcon(new ImageIcon("images/Purple-Monster-icon.png"));
		childMonsterLabel.setBounds(586, 424, 48, 48);
		frame.getContentPane().add(childMonsterLabel);

		JLabel gatekeeperLabel = new JLabel("");
		gatekeeperLabel.setIcon(new ImageIcon("images/Mermaid-icon.png"));
		gatekeeperLabel.setBounds(499, 363, 95, 96);
		frame.getContentPane().add(gatekeeperLabel);

		TotalLabel = new JLabel("");
		TotalLabel.setBounds(10, 11, 479, 54);
		TotalPanel.add(TotalLabel);

		JButton ResetButton = new JButton("Reset");
		ResetButton.setBounds(502, 0, 138, 36);
		frame.getContentPane().add(ResetButton);

		JButton Position1Button = new JButton("Here");
		Position1Button.setBounds(99, 422, 65, 23);
		frame.getContentPane().add(Position1Button);
		Position1Button.addActionListener(new place2ButtonHandler());

		JButton Position2Button = new JButton("Here");
		Position2Button.setBounds(230, 436, 65, 23);
		frame.getContentPane().add(Position2Button);
		Position2Button.addActionListener(new place1ButtonHandler());

		JButton SubmitButton = new JButton("Submit");
		SubmitButton.setBounds(484, 125, 72, 23);
		frame.getContentPane().add(SubmitButton);
		SubmitButton.addActionListener(new submitButtonHandler());

		JLabel Background = new JLabel("New label");
		Background.setIcon(new ImageIcon("images/level5BG.jpg"));
		Background.setBounds(0, 0, 641, 470);
		frame.getContentPane().add(Background);
	}

	public class place2ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			childMonsterLabel.setVisible(false);
			childPos2.setEnabled(true);
			childPos1.setEnabled(false);
			place1 = false;
			place2 = true;
		}
	}

	public class place1ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			childMonsterLabel.setVisible(false);
			childPos1.setEnabled(true);
			childPos2.setEnabled(false);
			place1 = true;
			place2 = false;
		}
	}

	public class submitButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (place1 = true) {
				TotalLabel.setText("00.0");
			} else {
				TotalLabel.setText("0.00");
			}

		}
	}
}
