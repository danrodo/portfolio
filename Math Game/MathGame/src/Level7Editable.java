import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JTextArea;


public class Level7Editable {
	
	JFrame frame;
	private String equation = "";
	
	private int val1 = 0;
	private int val2 = 0;
	private int val3 = 0;
	private int val4 = 0;
	private int val5 = 0;
	private int val6 = 0;
	private int val7 = 0;
	
	private String op1 = "";
	private String op2 = "";
	private String op3 = "";
	private String op4 = "";
	private String op5 = "";
	private String op6 = "";
	
	private int npc1Val = 0;
	private int npc2Val = 0;
	private int npc3Val = 0;
	private int npc4Val = 0;
	private int npc5Val = 0;
	private int npc6Val = 0;
	private int npc7Val = 0;
	private int npc8Val = 0;
	private int npc9Val = 0;

	
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	private JTextField tf6;
	private JTextField tf7;
	private JTextField chiefVal;
	private JTextField mouseVal;
	private JTextField horseVal;
	private JTextField rabbitVal;
	private JTextField eagleVal;
	private JTextField tigerVal;
	private JTextField snakeVal;
	private JTextField turtleVal;
	private JTextField indianVal;
	
	JCheckBox plus1 = new JCheckBox("+");
	JCheckBox minus1 = new JCheckBox("-");
	JCheckBox plus2 = new JCheckBox("+");
	JCheckBox minus2 = new JCheckBox("-");
	JCheckBox plus3 = new JCheckBox("+");
	JCheckBox minus3 = new JCheckBox("-");
	JCheckBox plus4 = new JCheckBox("+");
	JCheckBox minus4 = new JCheckBox("-");
	JCheckBox plus5 = new JCheckBox("+");
	JCheckBox minus5 = new JCheckBox("-");
	JCheckBox plus6 = new JCheckBox("+");
	JCheckBox minus6 = new JCheckBox("-");
	
	JTextArea instructionTextarea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level7Editable window = new Level7Editable();
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
	public Level7Editable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 803, 585);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel chiefLabel = new JLabel("");
		chiefLabel.setIcon(new ImageIcon("images/chief-icon.png"));
		chiefLabel.setBounds(51, 379, 118, 116);
		frame.getContentPane().add(chiefLabel);
		
		JLabel indianLabel = new JLabel("");
		indianLabel.setIcon(new ImageIcon("images/Indian-icon.png"));
		indianLabel.setBounds(631, 327, 118, 135);
		frame.getContentPane().add(indianLabel);
		
		JLabel eagleLabel = new JLabel("");
		eagleLabel.setIcon(new ImageIcon("images/Eagle-icon.png"));
		eagleLabel.setBounds(210, 132, 48, 57);
		frame.getContentPane().add(eagleLabel);
		
		JLabel horseLabel = new JLabel("");
		horseLabel.setIcon(new ImageIcon("images/Horse-icon.png"));
		horseLabel.setBounds(252, 347, 138, 123);
		frame.getContentPane().add(horseLabel);
		
		JLabel snakeLabel = new JLabel("");
		snakeLabel.setIcon(new ImageIcon("images/Snake-icon.png"));
		snakeLabel.setBounds(524, 408, 74, 48);
		frame.getContentPane().add(snakeLabel);
		
		JLabel mouseLabel = new JLabel("");
		mouseLabel.setIcon(new ImageIcon("images/Mouse-icon.png"));
		mouseLabel.setBounds(181, 465, 56, 48);
		frame.getContentPane().add(mouseLabel);
		
		JLabel turtleLabel = new JLabel("");
		turtleLabel.setIcon(new ImageIcon("images/Turtle-icon.png"));
		turtleLabel.setBounds(580, 347, 39, 32);
		frame.getContentPane().add(turtleLabel);
		
		JLabel rabbitLabel = new JLabel("");
		rabbitLabel.setIcon(new ImageIcon("images/Rabbit-icon.png"));
		rabbitLabel.setBounds(301, 315, 32, 32);
		frame.getContentPane().add(rabbitLabel);
		
		JLabel tigerLabel = new JLabel("");
		tigerLabel.setIcon(new ImageIcon("images/Tiger-icon.png"));
		tigerLabel.setBounds(510, 188, 39, 42);
		frame.getContentPane().add(tigerLabel);
		
		JPanel equationBorder = new JPanel();
		equationBorder.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Problem", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		equationBorder.setBounds(0, -1, 608, 84);
		frame.getContentPane().add(equationBorder);
		equationBorder.setLayout(null);
		
		tf1 = new JTextField();
		tf1.setBounds(6, 25, 50, 48);
		equationBorder.add(tf1);
		tf1.setColumns(10);
		
		
		plus1.setBounds(56, 25, 42, 23);
		equationBorder.add(plus1);
		
		
		minus1.setBounds(56, 50, 42, 23);
		equationBorder.add(minus1);
		
		tf2 = new JTextField();
		tf2.setBounds(98, 25, 50, 48);
		equationBorder.add(tf2);
		tf2.setColumns(10);
		
		
		plus2.setBounds(147, 25, 42, 23);
		equationBorder.add(plus2);
		
		
		minus2.setBounds(147, 50, 42, 23);
		equationBorder.add(minus2);
		
		tf3 = new JTextField();
		tf3.setBounds(186, 25, 50, 48);
		equationBorder.add(tf3);
		tf3.setColumns(10);
		
		
		plus3.setBounds(232, 25, 42, 23);
		equationBorder.add(plus3);
		
		
		minus3.setBounds(232, 50, 42, 23);
		equationBorder.add(minus3);
		
		tf4 = new JTextField();
		tf4.setBounds(271, 25, 50, 48);
		equationBorder.add(tf4);
		tf4.setColumns(10);
		
		
		plus4.setBounds(319, 25, 42, 23);
		equationBorder.add(plus4);
		
		
		minus4.setBounds(319, 50, 42, 23);
		equationBorder.add(minus4);
		
		tf5 = new JTextField();
		tf5.setBounds(360, 25, 50, 48);
		equationBorder.add(tf5);
		tf5.setColumns(10);
		
		
		plus5.setBounds(413, 25, 42, 23);
		equationBorder.add(plus5);
		
		
		minus5.setBounds(413, 50, 42, 23);
		equationBorder.add(minus5);
		
		tf6 = new JTextField();
		tf6.setColumns(10);
		tf6.setBounds(454, 25, 50, 48);
		equationBorder.add(tf6);
		
		
		plus6.setBounds(502, 25, 42, 23);
		equationBorder.add(plus6);
		
		
		minus6.setBounds(502, 50, 42, 23);
		equationBorder.add(minus6);
		
		tf7 = new JTextField();
		tf7.setBounds(544, 25, 50, 48);
		equationBorder.add(tf7);
		tf7.setColumns(10);
		
		chiefVal = new JTextField();
		chiefVal.setBounds(73, 495, 80, 28);
		frame.getContentPane().add(chiefVal);
		chiefVal.setColumns(10);
		
		mouseVal = new JTextField();
		mouseVal.setColumns(10);
		mouseVal.setBounds(178, 512, 64, 28);
		frame.getContentPane().add(mouseVal);
		
		horseVal = new JTextField();
		horseVal.setColumns(10);
		horseVal.setBounds(282, 465, 80, 28);
		frame.getContentPane().add(horseVal);
		
		rabbitVal = new JTextField();
		rabbitVal.setColumns(10);
		rabbitVal.setBounds(282, 287, 64, 28);
		frame.getContentPane().add(rabbitVal);
		
		eagleVal = new JTextField();
		eagleVal.setColumns(10);
		eagleVal.setBounds(197, 188, 80, 28);
		frame.getContentPane().add(eagleVal);
		
		tigerVal = new JTextField();
		tigerVal.setColumns(10);
		tigerVal.setBounds(499, 226, 56, 28);
		frame.getContentPane().add(tigerVal);
		
		snakeVal = new JTextField();
		snakeVal.setColumns(10);
		snakeVal.setBounds(524, 453, 80, 28);
		frame.getContentPane().add(snakeVal);
		
		turtleVal = new JTextField();
		turtleVal.setColumns(10);
		turtleVal.setBounds(570, 379, 56, 28);
		frame.getContentPane().add(turtleVal);
		
		indianVal = new JTextField();
		indianVal.setColumns(10);
		indianVal.setBounds(654, 453, 80, 28);
		frame.getContentPane().add(indianVal);
		
		JButton resetButton = new JButton("reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
				tf6.setText("");
				tf7.setText("");
				
				chiefVal.setText("");
				mouseVal.setText("");
				horseVal.setText("");
				rabbitVal.setText("");
				eagleVal.setText("");
				tigerVal.setText("");
				snakeVal.setText("");
				turtleVal.setText("");
				indianVal.setText("");
				
				plus1.setSelected(false);
				plus2.setSelected(false);
				plus3.setSelected(false);
				plus4.setSelected(false);
				plus5.setSelected(false);
				plus6.setSelected(false);
				
				minus1.setSelected(false);
				minus2.setSelected(false);
				minus3.setSelected(false);
				minus4.setSelected(false);
				minus5.setSelected(false);
				minus6.setSelected(false);
				
				instructionTextarea.setText("Fillout the problem above, and use the text fields below to hold the answer and other values for your student to choose from.");
			}
		});
		resetButton.setBounds(606, -1, 195, 42);
		frame.getContentPane().add(resetButton);
		
		JButton cancelButton = new JButton("cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		cancelButton.setBounds(606, 44, 195, 42);
		frame.getContentPane().add(cancelButton);
		
		JButton saveButton = new JButton("save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf1.getText().equals("") || tf2.getText().equals("") || tf3.getText().equals("") || tf4.getText().equals("") || tf5.getText().equals("") || tf6.getText().equals("") || tf7.getText().equals("") || chiefVal.getText().equals("") || mouseVal.getText().equals("") || horseVal.getText().equals("") || rabbitVal.getText().equals("") || eagleVal.getText().equals("") || tigerVal.getText().equals("") || snakeVal.getText().equals("") || turtleVal.getText().equals("") || indianVal.getText().equals("")){
					System.out.println("fill out the textfields");
					instructionTextarea.setText("Please fill in all of the text fields.");
				}
				else{
					val1 = Integer.parseInt(tf1.getText());
					val2 = Integer.parseInt(tf2.getText());
					val3 = Integer.parseInt(tf3.getText());
					val4 = Integer.parseInt(tf4.getText());
					val5 = Integer.parseInt(tf5.getText());
					val6 = Integer.parseInt(tf6.getText());
					val7 = Integer.parseInt(tf7.getText());
					
					npc1Val = Integer.parseInt(chiefVal.getText());
					npc2Val = Integer.parseInt(mouseVal.getText());
					npc3Val = Integer.parseInt(horseVal.getText());
					npc4Val = Integer.parseInt(rabbitVal.getText());
					npc5Val = Integer.parseInt(eagleVal.getText());
					npc6Val = Integer.parseInt(tigerVal.getText());
					npc7Val = Integer.parseInt(snakeVal.getText());
					npc8Val = Integer.parseInt(turtleVal.getText());
					npc9Val = Integer.parseInt(indianVal.getText());
					
					int[] array = {npc1Val, npc2Val, npc3Val, npc4Val, npc5Val, npc6Val, npc7Val, npc8Val, npc9Val};
					
					if(plus1.isSelected()){
						op1 = " + ";
					}
					if(minus1.isSelected()){
						op1 = " - ";
					}
					if(plus2.isSelected()){
						op2 = " + ";
					}
					if(minus2.isSelected()){
						op2 = " - ";
					}
					if(plus3.isSelected()){
						op3 = " + ";
					}
					if(minus3.isSelected()){
						op3 = " - ";
					}
					if(plus4.isSelected()){
						op4 = " + ";
					}
					if(minus4.isSelected()){
						op4 = " - ";
					}
					if(plus5.isSelected()){
						op5 = " + ";
					}
					if(minus5.isSelected()){
						op5 = " - ";
					}
					if(plus6.isSelected()){
						op6 = " + ";
					}
					if(minus6.isSelected()){
						op6 = " - ";
					}
					

					int total = val1;
					if(op1 == " + "){
						total = total + val2;
					}
					else{
						total = total - val2;
					}
					if(op2 == " + "){
						total = total + val3;
					}
					else{
						total = total - val3;
					}
					if(op3 == " + "){
						total = total + val4;
					}
					else{
						total = total - val4;
					}
					if(op4 == " + "){
						total = total + val5;
					}
					else{
						total = total - val5;
					}
					if(op5 == " + "){
						total = total + val6;
					}
					else{
						total = total - val6;
					}
					if(op6 == " + "){
						total = total + val7;
					}
					else{
						total = total - val7;
					}
					
					equation = val1 + op1 + val2 + op2 + val3 + op3 + val4 + op4 + val5 + op5 + val6 + op6 + val7; 
					System.out.println(equation + " = " + total);
					//insert statement here
					Connection connection = sqliteConnection.dbConnector();
					{
						try{
							String query = "INSERT INTO Level7 VALUES( 0," + equation + ", " + total + ", " + npc1Val + ", " + npc2Val + ", " + npc3Val + ", " + npc4Val + ", " + npc5Val + ", " + npc6Val + ", " + npc7Val + ", " + npc8Val + ", " + npc9Val + ")";
							instructionTextarea.setText("Problem saved, change the problem and click save again to create a new problem, or click cancel to go back.");
							PreparedStatement ps = connection.prepareStatement(query);
							
							ps.executeUpdate();
						}
						catch(Exception e3){
							JOptionPane.showMessageDialog(null, e);
							System.exit(0);
						}
					}
					
					for(int i = 0; i < array.length; i++){
						if(array[i] == total){
							//create statement
							instructionTextarea.setText("Problem saved, change the values and click save again to save another problem, or click cancel to go back");
							System.out.println("an answer exists");
							String statement = "INSERT INTO Level7 VALUES(0, " + '"' + equation + '"' + ", " + total + ", " + npc1Val + ", " + npc2Val + ", " + npc3Val + ", " + npc4Val + ", " + npc5Val + ", " + npc6Val + ", " + npc7Val + ", " + npc8Val + ", " + npc9Val + ")";
							System.out.println(statement);
							break;
						}
						else{
							System.out.println("no answer exists");
							instructionTextarea.setText("There is no answer to the math problem you entered, please double check the problem and make sure that the answer is represented below.");
						}
					}
				}
				
			}
		});
		saveButton.setBounds(0, 86, 152, 42);
		frame.getContentPane().add(saveButton);
		

		instructionTextarea.setWrapStyleWord(true);
		instructionTextarea.setLineWrap(true);
		instructionTextarea.setText("Fillout the problem above, and use the text fields below to hold the answer and other values for your student to choose from.");
		instructionTextarea.setBounds(282, 86, 327, 84);
		frame.getContentPane().add(instructionTextarea);
		
		JLabel bgLabel = new JLabel("");
		bgLabel.setIcon(new ImageIcon("images/level7Bg.jpg"));
		bgLabel.setBounds(0, 0, 801, 562);
		frame.getContentPane().add(bgLabel);
	}
}
