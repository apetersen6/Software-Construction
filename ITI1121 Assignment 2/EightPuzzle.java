import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class EightPuzzle extends JFrame implements ActionListener{

	private Board board;
	
	public EightPuzzle(){
	
		super("EightPuzzle");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
	
		board = new Board(); //creates a new board centered in the JFrame
		add(board, BorderLayout.CENTER);
	
		JButton button = new JButton("Start New Game"); //creates a JButton to start new games
		button.setFocusPainted(false);
		button.addActionListener(this);
	
		JPanel control = new JPanel(); //creates the JPanel where the button goes
		control.setBackground(Color.WHITE);
		control.add(button);
		add(control, BorderLayout.SOUTH);
	
		pack();
		setResizable(false); //make it so that the JFrame can't be resized
		setVisible(true); //makes EightPuzzle visible
	}
	
	public void actionPerformed(ActionEvent e) {
		board.init(); //initializes a new game when the "Start New Game" button is pressed
	}
	
	public static void main(String[] args){
		new EightPuzzle(); //opens up the application
		StudentInfo.display(); //displays student information
	}

}
