import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
public class TicTac implements ActionListener{
	//checks random turns of 'x' and 'o'
	Random random=new Random();
	JFrame frame=new JFrame();
	//panel to hold title
	JPanel Title_panel=new JPanel();
	//panel to hold buttons
	JPanel Button_panel=new JPanel();
	JLabel Text_field=new JLabel();
	//Array of buttons
	//9->b'coz we require exactly 9 buttons
	JButton[] Button= new JButton[9];
	boolean player1Turn;
	//constructor
	TicTac(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		Text_field.setBackground(new Color(25,25,25));
		Text_field.setForeground(new Color(25,255,0));
		Text_field.setFont(new Font("Ink Free",Font.BOLD,75));
		Text_field.setHorizontalAlignment(JLabel.CENTER);
		Text_field.setText("Tic-Tac-Toe");
		Text_field.setOpaque(true);
		
		Title_panel.setLayout(new BorderLayout());
		Title_panel.setBounds(0,0,800,100); //(xPos,yPos,width,Height);
		
		Button_panel.setLayout(new GridLayout(3,3));
		Button_panel.setBackground(new Color(150,150,150));
		
		//designing all the buttons
		for(int i=0;i<9;i++) {
			Button[i]=new JButton();
			//add current button ->button panel
			Button_panel.add(Button[i]);
			//sets the font
			Button[i].setFont(new Font("MV Boli",Font.BOLD,120));
			Button[i].setFocusable(false);
			Button[i].addActionListener(this);
			
		}
		// add text_field->titlePanel
		Title_panel.add(Text_field);
		
		//add titlePanel->frame
		frame.add(Title_panel,BorderLayout.NORTH);//NORTH-adds to the top;
		
		frame.add(Button_panel);
		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 for(int i=0;i<9;i++) {
			 if(e.getSource()==Button[i]) {
				 if(player1Turn) {
					 if(Button[i].getText()=="") {
						 Button[i].setForeground(new Color(255,0,0));//sets red color
						 //set text at particular cell
						 Button[i].setText("X");
						 //flip player1Turn to false;
						 player1Turn=false;
						 //set text field to o'turn
						 Text_field.setText("o-turn");
						 check();
					 }
				 }
				 else {
					 if(Button[i].getText()=="") {
						 Button[i].setForeground(new Color(0,0,255));//sets red color
						 //set text at particular cell
						 Button[i].setText("O");
						 //flip player1Turn to false;
						 player1Turn=true;
						 //set text field to o'turn
						 Text_field.setText("x-turn");
						 check();
					 }
				 }
			 }
		 }
		
	}
	//who's turn will be first.whether it's->'x' or 'o'
	public void firstTurn() {
		try {
			//if we want title for some time
			//and then x-turn and o-turn
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//get the 2 numbers i.e 0 and 1
		//if 0->x'turn
		//if 1->o'turn
		if(random.nextInt(2)==0) {
			player1Turn=true;
			Text_field.setText("X-turn");
		}
		else {
			player1Turn=false;
			Text_field.setText("O-turn");
		}
	}
	//it check who wins
	public void check() {
		//check for x wins
		if((Button[0].getText()=="X") &&
		   (Button[1].getText()=="X") && 
		   (Button[2].getText()=="X")) {
			xWins(0,1,2);
		}
		if((Button[3].getText()=="X") &&
		   (Button[4].getText()=="X") && 
		   (Button[5].getText()=="X")) {
			xWins(3,4,5);
		}
		if((Button[6].getText()=="X") &&
		   (Button[7].getText()=="X") && 
		   (Button[8].getText()=="X")) {
				xWins(6,7,8);
		}
		if((Button[0].getText()=="X") &&
		   (Button[3].getText()=="X") && 
		   (Button[6].getText()=="X")) {
				xWins(0,3,6);
		}
		if((Button[1].getText()=="X") &&				
			(Button[4].getText()=="X") && 
			(Button[7].getText()=="X")) {
				xWins(1,4,7);
		}
		if((Button[2].getText()=="X") &&				
			(Button[5].getText()=="X") && 
			(Button[8].getText()=="X")) {
					xWins(2,5,8);
		}
		if((Button[0].getText()=="X") &&				
				(Button[4].getText()=="X") && 
				(Button[8].getText()=="X")) {
						xWins(0,4,8);
		}
		if((Button[2].getText()=="X") &&				
			(Button[4].getText()=="X") && 
			(Button[6].getText()=="X")) {
			xWins(2,4,6);
		}
		
		//check for O-wins condition
		if((Button[0].getText()=="O") &&
				   (Button[1].getText()=="O") && 
				   (Button[2].getText()=="O")) {
					oWins(0,1,2);
				}
				if((Button[3].getText()=="O") &&
				   (Button[4].getText()=="O") && 
				   (Button[5].getText()=="O")) {
					oWins(3,4,5);
				}
				if((Button[6].getText()=="O") &&
				   (Button[7].getText()=="O") && 
				   (Button[8].getText()=="O")) {
						oWins(6,7,8);
				}
				if((Button[0].getText()=="O") &&
				   (Button[3].getText()=="O") && 
				   (Button[6].getText()=="O")) {
						oWins(0,3,6);
				}
				if((Button[1].getText()=="O") &&				
					(Button[4].getText()=="O") && 
					(Button[7].getText()=="O")) {
						oWins(1,4,7);
				}
				if((Button[2].getText()=="O") &&				
					(Button[5].getText()=="O") && 
					(Button[8].getText()=="O")) {
							oWins(2,5,8);
				}
				if((Button[0].getText()=="O") &&				
						(Button[4].getText()=="O") && 
						(Button[8].getText()=="O")) {
								oWins(0,4,8);
				}
				if((Button[2].getText()=="O") &&				
					(Button[4].getText()=="O") && 
					(Button[6].getText()=="O")) {
					oWins(2,4,6);
				}		 
			
			
		
		
	}
	
	public void xWins(int a,int b,int c) {
		Button[a].setBackground(Color.GREEN);
		Button[b].setBackground(Color.GREEN);
		Button[c].setBackground(Color.GREEN);
		for(int i=0;i<9;i++) {
			//once win make all other buttons to disable
			Button[i].setEnabled(false);
		}
		Text_field.setText("X Wins");
	}
	public void oWins(int a,int b,int c) {
		Button[a].setBackground(Color.GREEN);
		Button[b].setBackground(Color.GREEN);
		Button[c].setBackground(Color.GREEN);
		for(int i=0;i<9;i++) {
			//once win make all other buttons to disable
			Button[i].setEnabled(false);
		}
		Text_field.setText("O Wins");
	}
}
