import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextPane;

//import Level1Tutorial.backtomapbuttonhandler;


public class Level2Tutorial
{

	private JFrame frame;

	private JPanel welcomepanel;
	private JPanel congratulationspanel;

	private JButton gatekeeperbutton;
	private JButton firewoodtakebutton;
	private JButton continuebutton;
	private JButton welcomebutton;
	
	private JTextArea guy1text;
	private JTextArea gatekeepertext;
	private JTextArea congratulationstext;
	private JTextArea equationupdateexplanation;
	private JTextArea subtractionexplanation;
	private JTextArea takeawayexplanation;
	private JTextArea welcometext;

	private JLabel totallabel;
	private JLabel firewood;
	private JLabel firewood2;
	private JLabel guy1;
	private JLabel guy2;
	private JLabel gatekeeper;
	
	private int position;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Level2Tutorial window = new Level2Tutorial();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Level2Tutorial()
	{
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		position = 0;
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel totalpanel = new JPanel();
		totalpanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Total", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		totalpanel.setBounds(0, 0, 491, 55);
		frame.getContentPane().add(totalpanel);
		totalpanel.setLayout(null);
		
		totallabel = new JLabel("");
		totallabel.setBounds(10, 11, 471, 33);
		totalpanel.add(totallabel);
		
		JButton reset = new JButton("Reset");
		reset.setBounds(492, 0, 132, 25);
		frame.getContentPane().add(reset);
		reset.addActionListener(new resetbuttonhandler());
		
		JButton backtomap = new JButton("Back to Map");
		backtomap.setBounds(492, 26, 132, 29);
		frame.getContentPane().add(backtomap);
		backtomap.addActionListener(new backtomapbuttonhandler());
		
		JButton backbutton = new JButton("back");
		backbutton.setBounds(302, 54, 67, 23);
		frame.getContentPane().add(backbutton);
		backbutton.addActionListener(new backbuttonhandler());
		
		JButton nextbutton = new JButton("next");
		nextbutton.setBounds(369, 54, 67, 23);
		frame.getContentPane().add(nextbutton);
		nextbutton.addActionListener(new nextbuttonhandler());
		
		welcomepanel = new JPanel();
		welcomepanel.setBounds(258, 120, 189, 134);
		frame.getContentPane().add(welcomepanel);
		welcomepanel.setLayout(null);
		
		welcometext = new JTextArea();
		welcometext.setText("Welcome to the subtraction level of the tutorial. In this level we will learn about how subtraction problems work in this game. Are you ready to start?");
		welcometext.setWrapStyleWord(true);
		welcometext.setLineWrap(true);
		welcometext.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		welcometext.setBounds(0, 0, 189, 98);
		welcomepanel.add(welcometext);
		
		welcomebutton = new JButton("ok");
		welcomebutton.setBounds(52, 109, 89, 23);
		welcomepanel.add(welcomebutton);
		welcomebutton.addActionListener(new okbuttonhandler());
		
		firewoodtakebutton = new JButton("discard");
		firewoodtakebutton.setBounds(150, 329, 80, 23);
		frame.getContentPane().add(firewoodtakebutton);
		firewoodtakebutton.setVisible(false);
		firewoodtakebutton.addActionListener(new discardbuttonhandler());
		
		gatekeeperbutton = new JButton("submit");
		gatekeeperbutton.setBounds(492, 342, 80, 23);
		frame.getContentPane().add(gatekeeperbutton);
		gatekeeperbutton.setVisible(false);
		gatekeeperbutton.addActionListener(new submitbuttonhandler());
		
		guy1text = new JTextArea();
		guy1text.setWrapStyleWord(true);
		guy1text.setLineWrap(true);
		guy1text.setText("Oh no! I gathered way too much firewood. I was only supposed to get 3 logs. How many do I discard?");
		guy1text.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		guy1text.setBounds(26, 211, 201, 55);
		frame.getContentPane().add(guy1text);
		guy1text.setVisible(false);
		
		gatekeepertext = new JTextArea();
		gatekeepertext.setText("You cannot pass until you have only 3 logs of firewood");
		gatekeepertext.setWrapStyleWord(true);
		gatekeepertext.setLineWrap(true);
		gatekeepertext.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		gatekeepertext.setBounds(487, 236, 127, 55);
		frame.getContentPane().add(gatekeepertext);
		gatekeepertext.setVisible(false);
		
		congratulationspanel = new JPanel();
		congratulationspanel.setBounds(258, 105, 195, 117);
		frame.getContentPane().add(congratulationspanel);
		congratulationspanel.setLayout(null);
		congratulationspanel.setVisible(false);
		
		congratulationstext = new JTextArea();
		congratulationstext.setText("Congratulations! you finished the subtraction level tutorial! click Continue below to return to the map.");
		congratulationstext.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		congratulationstext.setWrapStyleWord(true);
		congratulationstext.setLineWrap(true);
		congratulationstext.setBounds(0, 0, 195, 81);
		congratulationspanel.add(congratulationstext);
		congratulationstext.setVisible(false);
		
		continuebutton = new JButton("Continue");
		continuebutton.setBounds(51, 92, 89, 23);
		congratulationspanel.add(continuebutton);
		continuebutton.setVisible(false);
		continuebutton.addActionListener(new backtomapbuttonhandler());
		
		equationupdateexplanation = new JTextArea();
		equationupdateexplanation.setText("Great job! Do you see how the equation has been updated to show 6-3=3. Thats the correct number of logs! Click the submit button below the gatekeeper on the right to check and make sure we have the right number of logs to pass.");
		equationupdateexplanation.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		equationupdateexplanation.setLineWrap(true);
		equationupdateexplanation.setWrapStyleWord(true);
		equationupdateexplanation.setBounds(26, 64, 266, 84);
		frame.getContentPane().add(equationupdateexplanation);
		equationupdateexplanation.setVisible(false);
		
		subtractionexplanation = new JTextArea();
		subtractionexplanation.setWrapStyleWord(true);
		subtractionexplanation.setLineWrap(true);
		subtractionexplanation.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		subtractionexplanation.setText("In this level, instead of starting with 0 and adding to it, we have too much instead and we need to get rid of some! The man down below was sent to get firewood, but he returned with too much and now he can't get back to where he was without having the right amount, do you think we can help him? click next to continue with the tutorial");
		subtractionexplanation.setBounds(37, 66, 255, 134);
		frame.getContentPane().add(subtractionexplanation);
		subtractionexplanation.setVisible(false);
		
		takeawayexplanation = new JTextArea();
		takeawayexplanation.setText("It looks like this man has 6 logs of firewood, but he can only take 3. If we take away 3 logs, we have the equation 6-3=3, which is the maximum amount he's allowed to take. Click the discard button below the second pile of logs to discard them. ");
		takeawayexplanation.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		takeawayexplanation.setWrapStyleWord(true);
		takeawayexplanation.setLineWrap(true);
		takeawayexplanation.setBounds(237, 250, 245, 105);
		frame.getContentPane().add(takeawayexplanation);
		takeawayexplanation.setVisible(false);
		
		firewood = new JLabel("New label");
		firewood.setIcon(new ImageIcon("images/firewood.png"));
		firewood.setBounds(102, 268, 64, 64);
		frame.getContentPane().add(firewood);
		firewood.setVisible(false);
		
		firewood2 = new JLabel("New label");
		firewood2.setIcon(new ImageIcon("images/firewood.png"));
		firewood2.setBounds(163, 268, 64, 64);
		frame.getContentPane().add(firewood2);
		firewood2.setVisible(false);
		
		guy1 = new JLabel("New label");
		guy1.setIcon(new ImageIcon("images/Man-icon.png"));
		guy1.setBounds(37, 268, 46, 46);
		frame.getContentPane().add(guy1);
		guy1.setVisible(false);
		
		guy2 = new JLabel("New label");
		guy2.setIcon(new ImageIcon("images/Teacher-icon.png"));
		guy2.setBounds(502, 292, 46, 55);
		frame.getContentPane().add(guy2);
		guy2.setVisible(false);
		
		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon("images/forestlevel2.jpg"));
		background.setBounds(0, 0, 624, 431);
		frame.getContentPane().add(background);
		
		
	}
	
	public class backtomapbuttonhandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			frame.dispose();
		}
	}
	
	public class backbuttonhandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(position==2)
			{
				subtractionexplanation.setVisible(true);
				takeawayexplanation.setVisible(false);
				position--;
			}
			else if(position==3)
			{
				takeawayexplanation.setVisible(true);
				equationupdateexplanation.setVisible(false);
				firewood2.setVisible(true);
				firewoodtakebutton.setVisible(true);
				totallabel.setText("6-0=6");
				position--;
			}
		}
	}
	
	public class okbuttonhandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			firewood.setVisible(true);
			firewood2.setVisible(true);
			guy2.setVisible(true);
			guy1.setVisible(true);
			gatekeepertext.setVisible(true);
			guy1text.setVisible(true);
			subtractionexplanation.setVisible(true);
			welcomepanel.setVisible(false);
			welcometext.setVisible(false);
			welcomebutton.setVisible(false);
			firewoodtakebutton.setVisible(true);
			gatekeeperbutton.setVisible(true);
			totallabel.setText("6-0=6");
			position++;
		}
	}
	
	public class resetbuttonhandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(position<=3)
			{
			position=1;
			firewood.setVisible(true);
			firewood2.setVisible(true);
			guy2.setVisible(true);
			guy1.setVisible(true);
			gatekeepertext.setVisible(true);
			guy1text.setVisible(true);
			subtractionexplanation.setVisible(true);
			firewoodtakebutton.setVisible(true);
			gatekeeperbutton.setVisible(true);
			totallabel.setText("6-0=6");
			takeawayexplanation.setVisible(false);
			equationupdateexplanation.setVisible(false);
			}
		}
	}
	
	public class nextbuttonhandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(position==1)
			{
				subtractionexplanation.setVisible(false);
				takeawayexplanation.setVisible(true);
				position++;
			}
		}
	}
	
	public class submitbuttonhandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(position == 3)
			{
				equationupdateexplanation.setVisible(false);
				congratulationspanel.setVisible(true);
				congratulationstext.setVisible(true);
				continuebutton.setVisible(true);
				position++;
			}
		}
	}
	
	public class discardbuttonhandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(position == 2)
			{
				takeawayexplanation.setVisible(false);
				equationupdateexplanation.setVisible(true);
				firewood2.setVisible(false);
				firewoodtakebutton.setVisible(false);
				totallabel.setText("6-3=3");
				position++;
			}
		}
	}
}
