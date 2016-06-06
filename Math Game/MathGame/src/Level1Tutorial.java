import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import java.awt.Font;


public class Level1Tutorial
{

	private JFrame frame;
	
	private JPanel welcomepanel;
	private JPanel congratulationspanel;
	
	private JLabel guy2;
	private JLabel totallabel;
	private JLabel gatekeeper;
	private JLabel guy1;

	private JButton guy2button;
	private JButton guy1button;
	private JButton welcomepanelokbutton;
	private JButton gatekeeperbutton;
	private JButton backbutton;
	private JButton nextbutton;
	private JButton continuecongratulationsbutton;
	
	private JTextArea welcometext;
	private JTextArea guy2text;
	private JTextArea guy1text;
	private JTextArea gatekeepertext;
	private JTextArea eightcoins;
	private JTextArea congratulationstext;
	private JTextArea dragonexplanationtext;
	private JTextArea guysexplanationtextone;
	private JTextArea ninjahasappeared;
	private JTextArea sevencoins;
	private JTextArea totalexplanation;
	private JTextArea resetbacktomapexplanation;

	private int place;
	
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
					Level1Tutorial window = new Level1Tutorial();
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
	public Level1Tutorial()
	{
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		place = 0;
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton reset = new JButton("Reset");
		reset.setBounds(492, 376, 132, 25);
		frame.getContentPane().add(reset);
		reset.addActionListener(new resetbuttonhandler());
		
		JButton backtomap = new JButton("Back to Map");
		backtomap.setBounds(492, 401, 132, 29);
		frame.getContentPane().add(backtomap);
		backtomap.addActionListener(new backtomapbuttonhandler());
		
		gatekeeperbutton = new JButton("give");
		gatekeeperbutton.setBounds(430, 222, 61, 23);
		frame.getContentPane().add(gatekeeperbutton);
		gatekeeperbutton.setVisible(false);
		gatekeeperbutton.addActionListener(new givebuttonhandler());
		
		backbutton = new JButton("back");
		backbutton.setBounds(294, 0, 67, 23);
		frame.getContentPane().add(backbutton);
		backbutton.addActionListener(new backbuttonhandler());
		
		nextbutton = new JButton("next");
		nextbutton.setBounds(363, 0, 67, 23);
		frame.getContentPane().add(nextbutton);
		nextbutton.addActionListener(new nextbuttonhandler());
		
		gatekeepertext = new JTextArea();
		gatekeepertext.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		gatekeepertext.setText("grrr, I want 15 coins or I won't let you pass");
		gatekeepertext.setBounds(377, 140, 237, 25);
		frame.getContentPane().add(gatekeepertext);
		gatekeepertext.setVisible(false);
		
		guy1text = new JTextArea();
		guy1text.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		guy1text.setText("oh no! I only have 7 coins!");
		guy1text.setBounds(37, 257, 152, 22);
		frame.getContentPane().add(guy1text);
		guy1text.setVisible(false);
		
		guy2text = new JTextArea();
		guy2text.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		guy2text.setText("oh no! I only have 8 coins!");
		guy2text.setBounds(135, 38, 152, 22);
		frame.getContentPane().add(guy2text);
		guy2text.setVisible(false);
		
		welcomepanel = new JPanel();
		welcomepanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		welcomepanel.setBounds(228, 157, 192, 179);
		frame.getContentPane().add(welcomepanel);
		welcomepanel.setLayout(null);
		
		welcomepanelokbutton = new JButton("Start");
		welcomepanelokbutton.setBounds(55, 145, 81, 23);
		welcomepanel.add(welcomepanelokbutton);
		welcomepanelokbutton.addActionListener(new welcomeokbuttonhandler());
		
		welcometext = new JTextArea();
		welcometext.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		welcometext.setWrapStyleWord(true);
		welcometext.setLineWrap(true);
		welcometext.setText("Welcome to the addition level! in this exciting level of the tutorial I will be showing you the basics of how addition levels work. Are you ready to start?");
		welcometext.setBounds(10, 11, 172, 123);
		welcomepanel.add(welcometext);
		
		guy1button = new JButton("take");
		guy1button.setBounds(82, 332, 61, 23);
		frame.getContentPane().add(guy1button);
		guy1button.setVisible(false);
		guy1button.addActionListener(new takesevenbuttonhandler());
		
		guy2button = new JButton("take");
		guy2button.setBounds(177, 111, 61, 23);
		frame.getContentPane().add(guy2button);
		guy2button.setVisible(false);
		guy2button.addActionListener(new takeeightbuttonhandler());
		
		eightcoins = new JTextArea();
		eightcoins.setText("Great job! do you see how the total now reads \"0+7+8\"? this equals 15! Yay! We got 15 coins! now these two travelers can get past the dragon. Click the \"give\" button underneath the dragon to give him the coins you've collected. ");
		eightcoins.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		eightcoins.setWrapStyleWord(true);
		eightcoins.setLineWrap(true);
		eightcoins.setBounds(10, 241, 237, 124);
		frame.getContentPane().add(eightcoins);
		eightcoins.setVisible(false);
		
		congratulationspanel = new JPanel();
		congratulationspanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		congratulationspanel.setBounds(213, 140, 192, 139);
		frame.getContentPane().add(congratulationspanel);
		congratulationspanel.setLayout(null);
		congratulationspanel.setVisible(false);
		
		continuecongratulationsbutton = new JButton("Continue");
		continuecongratulationsbutton.setBounds(55, 105, 89, 23);
		congratulationspanel.add(continuecongratulationsbutton);
		continuecongratulationsbutton.setVisible(false);
		continuecongratulationsbutton.addActionListener(new backtomapbuttonhandler());
		
		congratulationstext = new JTextArea();
		congratulationstext.setText("Congratulations! You've just completed the first level! Click the \"Continue\" button below to return to the map.");
		congratulationstext.setBounds(10, 11, 172, 91);
		congratulationspanel.add(congratulationstext);
		congratulationstext.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		congratulationstext.setWrapStyleWord(true);
		congratulationstext.setLineWrap(true);
		congratulationstext.setVisible(false);
		
		JPanel totalpanel = new JPanel();
		totalpanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Total", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		totalpanel.setBounds(0, 376, 491, 55);
		frame.getContentPane().add(totalpanel);
		totalpanel.setLayout(null);
		
		totallabel = new JLabel("New label");
		totallabel.setBounds(10, 11, 471, 33);
		totallabel.setText("");
		totalpanel.add(totallabel);
		
		dragonexplanationtext = new JTextArea();
		dragonexplanationtext.setBounds(400, 49, 158, 72);
		frame.getContentPane().add(dragonexplanationtext);
		dragonexplanationtext.setWrapStyleWord(true);
		dragonexplanationtext.setLineWrap(true);
		dragonexplanationtext.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		dragonexplanationtext.setText("oh no! this mean scary dragon won't let these two travelers pass unless they give him 15 coins! ");
		dragonexplanationtext.setVisible(false);
		
		guysexplanationtextone = new JTextArea();
		guysexplanationtextone.setBounds(50, 170, 180, 81);
		frame.getContentPane().add(guysexplanationtextone);
		guysexplanationtextone.setWrapStyleWord(true);
		guysexplanationtextone.setLineWrap(true);
		guysexplanationtextone.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		guysexplanationtextone.setText("Well, its a good start. Do you see how this man has 7 coins? Go ahead and click on the \"take\" button below him");
		guysexplanationtextone.setVisible(false);
		
		resetbacktomapexplanation = new JTextArea();
		resetbacktomapexplanation.setText("these two buttons are the \"back to map\" button and the \"reset\" button. If you don't think you got the equation right, or if you got it wrong and you want to try again, click this button to start over. If you can't do this level, and want to try a different one, click \"back to map\" to go back to the main map. ");
		resetbacktomapexplanation.setWrapStyleWord(true);
		resetbacktomapexplanation.setLineWrap(true);
		resetbacktomapexplanation.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		resetbacktomapexplanation.setBounds(308, 255, 306, 110);
		frame.getContentPane().add(resetbacktomapexplanation);
		resetbacktomapexplanation.setVisible(false);
		
		sevencoins = new JTextArea();
		sevencoins.setText("Great job! do you see how the total now displays \"0+7\"? you're building your equation and helping these people out at the same time. Lets see if anyone else has some more coins they can give. Click the \"next\" button to continue the tutorial");
		sevencoins.setWrapStyleWord(true);
		sevencoins.setLineWrap(true);
		sevencoins.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		sevencoins.setBounds(23, 271, 289, 94);
		frame.getContentPane().add(sevencoins);
		sevencoins.setVisible(false);
		
		totalexplanation = new JTextArea();
		totalexplanation.setText("This is the total area where you can see your equation being built in real time. Shall we see how this works? Click next to continue.");
		totalexplanation.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		totalexplanation.setWrapStyleWord(true);
		totalexplanation.setLineWrap(true);
		totalexplanation.setBounds(10, 271, 170, 94);
		frame.getContentPane().add(totalexplanation);
		totalexplanation.setVisible(false);
		
		ninjahasappeared = new JTextArea();
		ninjahasappeared.setBounds(37, 138, 300, 81);
		frame.getContentPane().add(ninjahasappeared);
		ninjahasappeared.setText("Oh look! We're in luck! A ninja has appeared and he has 8 coins. 7+8 = 15, which is exactly how many we need to pass! Click the \"take\" button to take the coins from the ninja to add to our total.");
		ninjahasappeared.setWrapStyleWord(true);
		ninjahasappeared.setLineWrap(true);
		ninjahasappeared.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ninjahasappeared.setVisible(false);
		
		gatekeeper = new JLabel("New label");
		gatekeeper.setIcon(new ImageIcon("images/Dragon-icon.png"));
		gatekeeper.setBounds(430, 170, 46, 55);
		frame.getContentPane().add(gatekeeper);
		gatekeeper.setVisible(false);
		
		guy2 = new JLabel("New label");
		guy2.setIcon(new ImageIcon("images/Ninja-icon.png"));
		guy2.setBounds(177, 62, 46, 47);
		frame.getContentPane().add(guy2);
		guy2.setVisible(false);
		
		guy1 = new JLabel("New label");
		guy1.setIcon(new ImageIcon("images/Knight-icon.png"));
		guy1.setBounds(82, 281, 55, 55);
		frame.getContentPane().add(guy1);
		guy1.setVisible(false);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("images/forestlevel.jpg"));
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
	
	public class welcomeokbuttonhandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			welcomepanel.setVisible(false);
			welcomepanelokbutton.setVisible(true);
			welcometext.setVisible(false);
			resetbacktomapexplanation.setVisible(true);
			place++;
		}
	}
	
	public class backbuttonhandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(place==2)
			{
				resetbacktomapexplanation.setVisible(true);
				totalexplanation.setVisible(false);
				place--;
			}
			else if(place==3)
			{
				totalexplanation.setVisible(true);
				gatekeepertext.setVisible(false);
				gatekeeper.setVisible(false);
				dragonexplanationtext.setVisible(false);
				gatekeeperbutton.setVisible(false);
				guy1.setVisible(false);
				guy1button.setVisible(false);
				guy1text.setVisible(false);
				place--;
			}
			else if(place==4)
			{
				dragonexplanationtext.setVisible(true);
				guysexplanationtextone.setVisible(false);
				place--;
			}
			else if(place==5)
			{
				guysexplanationtextone.setVisible(true);
				sevencoins.setVisible(false);
				guy1button.setVisible(true);
				guy1.setVisible(true);
				guy1text.setVisible(true);
				totallabel.setText("");
				place--;
			}
			else if(place==6)
			{
				sevencoins.setVisible(true);
				guy1button.setVisible(false);
				guy1.setVisible(false);
				guy1text.setVisible(false);
				ninjahasappeared.setVisible(false);
				guy2.setVisible(false);
				guy2text.setVisible(false);
				guy2button.setVisible(false);
				place--;
			}
			else if(place==7)
			{
				eightcoins.setVisible(false);
				guy1button.setVisible(true);
				guy1.setVisible(true);
				guy1text.setVisible(true);
				guy1button.setVisible(true);
				ninjahasappeared.setVisible(true);
				totallabel.setText("0+7=");
				place--;
			}
		}
	}
	
	public class nextbuttonhandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(place == 1)
			{
				resetbacktomapexplanation.setVisible(false);
				totalexplanation.setVisible(true);
				place++;
			}
			else if(place==2)
			{
				totalexplanation.setVisible(false);
				gatekeepertext.setVisible(true);
				gatekeeper.setVisible(true);
				dragonexplanationtext.setVisible(true);
				gatekeeperbutton.setVisible(true);
				guy1.setVisible(true);
				guy1button.setVisible(true);
				guy1text.setVisible(true);
				place++;
			}
			else if(place==3)
			{
				dragonexplanationtext.setVisible(false);
				guysexplanationtextone.setVisible(true);
				place++;
			}
			else if(place==5)
			{
				sevencoins.setVisible(false);
				guy1button.setVisible(true);
				guy1.setVisible(true);
				guy1text.setVisible(true);
				ninjahasappeared.setVisible(true);
				guy2.setVisible(true);
				guy2text.setVisible(true);
				guy2button.setVisible(true);
				place++;
			}
			
		}
	}
	
	
	public class resetbuttonhandler implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			if(place<=8)
			{
				place=1;
				resetbacktomapexplanation.setVisible(true);
				sevencoins.setVisible(false);
				guy1button.setVisible(false);
				guy1.setVisible(false);
				guy1text.setVisible(false);
				ninjahasappeared.setVisible(false);
				guy2.setVisible(false);
				guy2text.setVisible(false);
				guy2button.setVisible(false);
				gatekeeper.setVisible(false);
				gatekeepertext.setVisible(false);
				gatekeeperbutton.setVisible(false);
				totalexplanation.setVisible(false);
				eightcoins.setVisible(false);
				dragonexplanationtext.setVisible(false);
				guysexplanationtextone.setVisible(false);
				totallabel.setText("");
			}
		}
	}
	
	public class takesevenbuttonhandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(place==4)
			{
			guysexplanationtextone.setVisible(false);
			sevencoins.setVisible(true);
			guy1button.setVisible(false);
			guy1.setVisible(false);
			guy1text.setVisible(false);
			totallabel.setText("0+7=");
			place++;
			}
		}
	}
	
	public class takeeightbuttonhandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(place==6)
			{
				eightcoins.setVisible(true);
				guy1button.setVisible(false);
				guy1.setVisible(false);
				guy1text.setVisible(false);
				guy1button.setVisible(false);
				ninjahasappeared.setVisible(false);
				totallabel.setText("0+7+8=15");
				place++;
			}
		}
	}
	
	public class givebuttonhandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(place==7)
			{
				eightcoins.setVisible(false);
				guy1button.setVisible(true);
				guy1text.setVisible(true);
				guy1.setVisible(true);
				congratulationspanel.setVisible(true);
				congratulationstext.setVisible(true);
				continuecongratulationsbutton.setVisible(true);
				gatekeepertext.setVisible(false);
				place++;
			}
		}
	}
}