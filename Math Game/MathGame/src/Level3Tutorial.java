import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.border.BevelBorder;

//import Level2Tutorial.backtomapbuttonhandler;


public class Level3Tutorial
{

	private JFrame frame;
	private JLabel monsterplace;
	private JLabel littleguy;
	private JTextPane total;
	private JButton congratulationsbutton;
	private JPanel congratulationspanel;
	private JTextArea congratulationstext;
	private JTextArea piratetext;
	private JTextArea littleguytext;
	private JTextArea monstertext;
	private JTextArea confusingexplanation;
	private JTextArea totalexplanation;
	private JButton submitbutton;
	private JLabel pirate;
	private JLabel monster2;
	private JLabel monster1;
	private JPanel welcomepanel;
	private JTextArea txtrWelcomeToThe;
	private JButton welcomeokbutton;
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
					Level3Tutorial window = new Level3Tutorial();
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
	public Level3Tutorial()
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
		totalpanel.setBounds(0, 376, 491, 55);
		frame.getContentPane().add(totalpanel);
		totalpanel.setLayout(null);
		
		total = new JTextPane();
		total.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		total.setToolTipText("");
		total.setText("000");
		total.setBounds(207, 11, 42, 33);
		totalpanel.add(total);
		
		welcomepanel = new JPanel();
		welcomepanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		welcomepanel.setBounds(246, 114, 200, 163);
		frame.getContentPane().add(welcomepanel);
		welcomepanel.setLayout(null);
		welcomepanel.setVisible(true);
		
		txtrWelcomeToThe = new JTextArea();
		txtrWelcomeToThe.setWrapStyleWord(true);
		txtrWelcomeToThe.setLineWrap(true);
		txtrWelcomeToThe.setText("Welcome to the last level of the tutorial, the placeholder level! in this section, we will learn how to complete placeholder levels. Are you ready?");
		txtrWelcomeToThe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtrWelcomeToThe.setBounds(10, 8, 180, 110);
		welcomepanel.add(txtrWelcomeToThe);
		txtrWelcomeToThe.setVisible(true);
		
		welcomeokbutton = new JButton("OK!");
		welcomeokbutton.setBounds(55, 129, 89, 23);
		welcomepanel.add(welcomeokbutton);
		welcomeokbutton.setVisible(true);
		welcomeokbutton.addActionListener(new okbuttonhandler());
		
		congratulationspanel = new JPanel();
		congratulationspanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		congratulationspanel.setBounds(186, 74, 260, 178);
		frame.getContentPane().add(congratulationspanel);
		congratulationspanel.setLayout(null);
		congratulationspanel.setVisible(false);
		
		congratulationstext = new JTextArea();
		congratulationstext.setText("Congratulations! You just completed the last level of the tutorial! Are you ready to continue on to the rest of the game and tackle even harder math problems? Click the continue button below to return to the map.");
		congratulationstext.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		congratulationstext.setWrapStyleWord(true);
		congratulationstext.setLineWrap(true);
		congratulationstext.setBounds(10, 9, 240, 124);
		congratulationspanel.add(congratulationstext);
		congratulationstext.setVisible(false);
		
		congratulationsbutton = new JButton("Continue");
		congratulationsbutton.setBounds(78, 144, 89, 23);
		congratulationspanel.add(congratulationsbutton);
		congratulationsbutton.setVisible(false);
		congratulationsbutton.addActionListener(new backtomapbuttonhandler());
		
		JButton reset = new JButton("Reset");
		reset.setBounds(492, 376, 132, 25);
		frame.getContentPane().add(reset);
		reset.addActionListener(new resetbuttonhandler());
		
		JButton backtomap = new JButton("Back to Map");
		backtomap.setBounds(492, 401, 132, 29);
		frame.getContentPane().add(backtomap);
		backtomap.addActionListener(new backtomapbuttonhandler());
		
		JButton backbutton = new JButton("back");
		backbutton.setBounds(293, 352, 67, 23);
		frame.getContentPane().add(backbutton);
		backbutton.addActionListener(new resetbuttonhandler());
		
		JButton nextbutton = new JButton("next");
		nextbutton.setBounds(362, 352, 67, 23);
		frame.getContentPane().add(nextbutton);
		
		piratetext = new JTextArea();
		piratetext.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		piratetext.setText("Yar, these monsters are confusing...");
		piratetext.setBounds(420, 222, 194, 20);
		frame.getContentPane().add(piratetext);
		piratetext.setVisible(false);
		
		littleguytext = new JTextArea();
		littleguytext.setText("bah bah?");
		littleguytext.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		littleguytext.setBounds(444, 307, 58, 22);
		frame.getContentPane().add(littleguytext);
		littleguytext.setVisible(false);
		
		monstertext = new JTextArea();
		monstertext.setLineWrap(true);
		monstertext.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		monstertext.setText("I'm the hundreds place, she's the ones place, put our kid in the tens place to complete the family");
		monstertext.setBounds(81, 37, 269, 39);
		frame.getContentPane().add(monstertext);
		monstertext.setVisible(false);
		
		confusingexplanation = new JTextArea();
		confusingexplanation.setText("Oh no! These monsters are confusing this pirate. They want their kid back, but they can't say it in the right way, can you help the pirate solve their riddle? ");
		confusingexplanation.setWrapStyleWord(true);
		confusingexplanation.setLineWrap(true);
		confusingexplanation.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		confusingexplanation.setBounds(367, 133, 247, 85);
		frame.getContentPane().add(confusingexplanation);
		confusingexplanation.setVisible(false);
		
		totalexplanation = new JTextArea();
		totalexplanation.setText("Great job! do you see how the text now reads \"0.0\"? the zero in the tens place got replaced by a dot, showing that you correctly placed the little monster in the right \"place\". Hit submit under the monsters to check your answer.");
		totalexplanation.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		totalexplanation.setWrapStyleWord(true);
		totalexplanation.setLineWrap(true);
		totalexplanation.setBounds(42, 263, 241, 112);
		frame.getContentPane().add(totalexplanation);
		totalexplanation.setVisible(false);
		
		submitbutton = new JButton("Submit");
		submitbutton.setBounds(173, 204, 89, 23);
		frame.getContentPane().add(submitbutton);
		submitbutton.setVisible(false);
		submitbutton.addActionListener(new submitbuttonhandler());
		
		monsterplace = new JLabel("New label");
		monsterplace.setIcon(new ImageIcon("images/Purple-Monster-icon.png"));
		monsterplace.setBounds(186, 74, 46, 128);
		frame.getContentPane().add(monsterplace);
		monsterplace.setEnabled(false);
		monsterplace.addMouseListener(new placeholderlistener());
		monsterplace.setVisible(false);
		
		pirate = new JLabel("New label");
		pirate.setIcon(new ImageIcon("images/Pirate-icon.png"));
		pirate.setBounds(492, 240, 122, 134);
		frame.getContentPane().add(pirate);
		pirate.setVisible(false);
		
		littleguy = new JLabel("New label");
		littleguy.setIcon(new ImageIcon("images/Purple-Monster-icon.png"));
		littleguy.setBounds(458, 320, 44, 55);
		frame.getContentPane().add(littleguy);
		littleguy.setVisible(false);
		
		monster2 = new JLabel("New label");
		monster2.setIcon(new ImageIcon("images/Green-Monster-icon.png"));
		monster2.setBounds(214, 74, 122, 128);
		frame.getContentPane().add(monster2);
		monster2.setVisible(false);
		
		monster1 = new JLabel("New label");
		monster1.setIcon(new ImageIcon("images/Blue-Monster-icon.png"));
		monster1.setBounds(81, 74, 132, 128);
		frame.getContentPane().add(monster1);
		monster1.setVisible(false);
		
		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon("images/bridge.jpg"));
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
	
	public class resetbuttonhandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(position<=2)
			{
			position=1;
			pirate.setVisible(true);
			monster1.setVisible(true);
			monster2.setVisible(true);
			littleguy.setVisible(true);
			monstertext.setVisible(true);
			piratetext.setVisible(true);
			littleguytext.setVisible(true);
			submitbutton.setVisible(true);
			confusingexplanation.setVisible(true);
			monsterplace.setVisible(true);
			monsterplace.setEnabled(false);
			totalexplanation.setVisible(false);
			total.setText("000");
			}
		}
	}
	
	public class okbuttonhandler implements ActionListener
	{
		@Override
		//mysql -p
		//jon9999
		//use jhallen_mathgame
		//ssh jhallen@mathgameadventure.com
		//while rs.next()
		public void actionPerformed(ActionEvent arg0)
		{
			welcomeokbutton.setVisible(false);
			txtrWelcomeToThe.setVisible(false);
			welcomepanel.setVisible(false);
			pirate.setVisible(true);
			monster1.setVisible(true);
			monster2.setVisible(true);
			littleguy.setVisible(true);
			monstertext.setVisible(true);
			piratetext.setVisible(true);
			littleguytext.setVisible(true);
			submitbutton.setVisible(true);
			confusingexplanation.setVisible(true);
			monsterplace.setVisible(true);
			position++;
		}
	}
	
	
	public class submitbuttonhandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			if(position==2)
			{
			totalexplanation.setVisible(false);
			congratulationspanel.setVisible(true);
			congratulationsbutton.setVisible(true);
			congratulationstext.setVisible(true);
			submitbutton.setVisible(false);
			position++;
			}
		}
	}

	public class placeholderlistener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent arg0)
		{
			if(position==1)
			{
			monsterplace.setEnabled(true);
			littleguy.setVisible(false);
			confusingexplanation.setVisible(false);
			littleguytext.setVisible(false);
			totalexplanation.setVisible(true);
			total.setText("0.0");
			position++;
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0)
		{
			// TODO Auto-generated method stub
			
		}
	}
}