import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;



public class Level3Editable {

	public JFrame frame;
	
	//initializes these swing components as global so that they can be manipulated throughout
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
	private final JButton house1Button = new JButton("Deliver");
	private final JButton house2Button = new JButton("Deliver");
	private final JButton house3Button = new JButton("Deliver");
	private JTextField house1Textfield;
	private JTextField house2Textfield;
	private JTextField house3Textfield;
	private final JLabel lblAnswer = new JLabel("answer");
	private final JTextField answerTextfield = new JTextField();
	private final JLabel givenLabel = new JLabel("given amount");
	private final JTextField givenTextfield = new JTextField();
	private final JButton saveButton = new JButton("Save Problem");
	private final JTextArea messageTextarea = new JTextArea();
	
	
	
	public int h1, h2, h3, ans, giv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level3Editable window = new Level3Editable();
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
	public Level3Editable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		givenTextfield.setBounds(33, 72, 48, 28);
		givenTextfield.setColumns(10);
		answerTextfield.setBounds(576, 292, 48, 28);
		answerTextfield.setColumns(10);
		frame = new JFrame();
		frame.setBounds(100, 100, 649, 496);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//sets total to total value, and initializes the initial equation
		
		lblAnswer.setBounds(576, 275, 48, 16);
		frame.getContentPane().add(lblAnswer);
		frame.getContentPane().add(answerTextfield);
		
		//the initialization of the graphical labels that are displayed
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
		
		//resets the level but increments fails, so if you choose to reset the level you are essentially failing it
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				house1Textfield.setText("");
				house2Textfield.setText("");
				house3Textfield.setText("");
				answerTextfield.setText("");
				givenTextfield.setText("");
				
				messageTextarea.setText("Fill out the given amount to subtract from, the answer you want them to find, and the specific values of the 3 variables that lead to the answer.");
			}
		});
		resetButton.setBounds(496, 0, 117, 29);
		frame.getContentPane().add(resetButton);
		
		//disposes the frame making the map visible again
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//update student table fails here
				frame.dispose();
			}
		});
		cancelButton.setBounds(496, 30, 117, 29);
		frame.getContentPane().add(cancelButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Total", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(13, -2, 433, 58);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		totalLabel.setBounds(6, 18, 421, 34);
		panel.add(totalLabel);
		house1Button.setEnabled(false);
		
		//the house buttons manipulate the equation, and the total value
		house1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		house1Button.setBounds(174, 418, 78, 29);
		frame.getContentPane().add(house1Button);
		house2Button.setEnabled(false);
		house2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		house2Button.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		house2Button.setBounds(355, 346, 53, 14);
		frame.getContentPane().add(house2Button);
		house3Button.setEnabled(false);
		house3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		house3Button.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		house3Button.setBounds(423, 332, 48, 14);
		frame.getContentPane().add(house3Button);
		
		final JLabel houseLabel = new JLabel("kids");
		houseLabel.setBounds(185, 331, 48, 29);
		frame.getContentPane().add(houseLabel);
		
		final JLabel house2Label = new JLabel("kids");
		house2Label.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		house2Label.setBounds(359, 292, 38, 29);
		frame.getContentPane().add(house2Label);
		
		final JLabel house3Label = new JLabel("kids");
		house3Label.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		house3Label.setBounds(433, 298, 38, 29);
		frame.getContentPane().add(house3Label);
		
		house1Textfield = new JTextField();
		house1Textfield.setBounds(173, 309, 48, 28);
		frame.getContentPane().add(house1Textfield);
		house1Textfield.setColumns(10);
		
		house2Textfield = new JTextField();
		house2Textfield.setBounds(349, 269, 48, 28);
		frame.getContentPane().add(house2Textfield);
		house2Textfield.setColumns(10);
		
		house3Textfield = new JTextField();
		house3Textfield.setBounds(420, 280, 48, 28);
		frame.getContentPane().add(house3Textfield);
		house3Textfield.setColumns(10);
		
		givenLabel.setBounds(13, 54, 86, 16);
		frame.getContentPane().add(givenLabel);
		frame.getContentPane().add(givenTextfield);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(house1Textfield.getText().equals("") || house2Textfield.getText().equals("") || house3Textfield.getText().equals("") || answerTextfield.getText().equals("") || givenTextfield.getText().equals("")){
					System.out.println("textfields are not filled in");
					messageTextarea.setText("not all of the required textfields are filled in, please make sure you fill all of them in to continue");
					
				}
				else{
					h1 = Integer.parseInt(house1Textfield.getText());
					h2 = Integer.parseInt(house2Textfield.getText());
					h3 = Integer.parseInt(house3Textfield.getText());
				
					ans = Integer.parseInt(answerTextfield.getText());
					giv = Integer.parseInt(givenTextfield.getText());
				
				
					if(giv - h1 == ans || giv - h2 == ans || giv - h3 == ans || giv - h1 - h2 == ans || giv - h1 - h3 == ans || giv - h2 - h3 == ans || giv - h1 - h2 -h3 == ans){
						if(giv - h1 == ans){
							totalLabel.setText(giv + " - " + h1 + " = " + ans);
						}
						if(giv - h2 == ans){
							totalLabel.setText(giv + " - " + h2 + " = " + ans);
						}
						if(giv - h3 == ans){
							totalLabel.setText(giv + " - " + h3 + " = " + ans);
						}
						if(giv - h1 - h2 == ans){
							totalLabel.setText(giv + " - " + h1 + " - " + h2 + " = " + ans);
						}
						if(giv - h1 - h3 == ans){
							totalLabel.setText(giv + " - " + h1 + " - " + h3 + " = " + ans);
						}
						if(giv - h2 - h3 == ans){
							totalLabel.setText(giv + " - " + h1 + " - " + h2 + " = " + ans);
						}
						if(giv - h1 - h2 - h3 == ans){
							totalLabel.setText(giv + " - " + h1 + " - " + h2 + " - " + h3 + " = " + ans);
						}
						messageTextarea.setText("Problem saved, fill out the textfields again to save another problem, or click cancel to go back to the teacher dashboard.");
						String query = "INSERT INTO Level3Sub VALUES( 0," + h1 + ", " + h2 + ", " + h3 + ", " + ans + ", " + giv + ")";
						System.out.println(query);
					}
					else{
						messageTextarea.setText("An answer doesn't exist to your problem, make sure that there's a solution so that your students can complete the level!");
						System.out.println("an answer does not exist");
					}
				}
			}
		});
		
		saveButton.setBounds(496, 71, 117, 29);
		frame.getContentPane().add(saveButton);
		
		messageTextarea.setWrapStyleWord(true);
		messageTextarea.setLineWrap(true);
		messageTextarea.setText("Fill out the given amount to subtract from, the answer you want them to find, and the specific values of the 3 variables that lead to the answer.");
		messageTextarea.setBounds(151, 78, 257, 72);
		frame.getContentPane().add(messageTextarea);

		JLabel bgLabel = new JLabel("");
		bgLabel.setIcon(new ImageIcon("images/Winter-landscapes-3.jpg"));
		bgLabel.setBounds(-6, 0, 649, 474);
		frame.getContentPane().add(bgLabel);

	}
}
