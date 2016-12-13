import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener {

	public static final int rows = 3;
	public static final int columns = 3;
	private Cell[][] board;
	RandomPermutation p = new RandomPermutation(rows, columns);
	private int attempts = 0; //tracks the number of attempts

	public Board() {
		setBackground(Color.WHITE);
		setLayout(new GridLayout(rows, columns)); //creates a 3x3 grid
		setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));
		board = new Cell[rows][columns]; //creates a board of Cells

		for (int row = 0; row < rows; row++) { //initializes the board
			for (int column = 0; column < columns; column++) {
				board[row][column] = new Cell(this, row, column);
				add(board[row][column]);
			}
		}

	}
	
	public void init() { //initializes a new random board when the "Start New Game" button is pressed
		RandomPermutation p = new RandomPermutation(rows, columns);
		p.shuffle();
		attempts = 0;
		
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				board[i][j].setId(p.random[3*i+j]);
			}
		}
	}
	
	public void actionPerformed(ActionEvent e){ 

		int temp;
		
		//checks to see if the game is won and displays a message accordingly
		if(board[0][0].getId() == 1 && board[0][1].getId() == 2 && board[0][2].getId() == 3 && board[1][0].getId() == 4 &&
				board[1][1].getId() == 5 && board[1][2].getId() == 6 && board[2][0].getId() == 7 && board[2][1].getId() == 8 && board[2][2].getId() == 0){

			JOptionPane.showMessageDialog(null, "You have won after " + attempts + " attempts!");
			attempts = 0;
		}else //if the game isn't won it allows the user to slide the puzzle pieces
			if(e.getSource() instanceof Cell){
			Cell src = (Cell) e.getSource();
			attempts++;
			
			if(src.getId() != 0){
				
				if(src.getRow()-1 >=0 && this.board[src.getRow()-1][src.getColumn()].getId() == 0){
						temp = src.getId();
						src.setId(this.board[src.getRow()-1][src.getColumn()].getId());
						board[src.getRow()-1][src.getColumn()].setId(temp);
				}else 
					if(src.getRow()+1 <3 && this.board[src.getRow()+1][src.getColumn()].getId() == 0){
						temp = src.getId();
						src.setId(this.board[src.getRow()+1][src.getColumn()].getId());
						board[src.getRow()+1][src.getColumn()].setId(temp);
				}else 
					if(src.getColumn()-1 >=0 && this.board[src.getRow()][src.getColumn()-1].getId() == 0){
						temp = src.getId();
						src.setId(this.board[src.getRow()][src.getColumn()-1].getId());
						board[src.getRow()][src.getColumn()-1].setId(temp);
				}else 
					if(src.getColumn()+1 <3 && this.board[src.getRow()][src.getColumn()+1].getId() == 0){
						temp = src.getId();
						src.setId(this.board[src.getRow()][src.getColumn()+1].getId());
						board[src.getRow()][src.getColumn()+1].setId(temp);
				}
			}
		}
	}
	
	public String toString(){ //toString() method
		String temp = "";
		int lb = 0;
		
		for (int row = 0; row < rows; row++) {
		    for (int column = 0; column < columns; column++) {
		    	if(lb == 2){
		    		temp = temp + "[" + board[row][column].getId() + "] \n";
		    		lb = 0;
		    	}
		    	else{
		    		temp = temp + "[" + board[row][column].getId() + "]";
		    		lb++;
		    	}
		    }
		}
		
		return temp + "Number of moves is " + attempts;
	}
	
}
