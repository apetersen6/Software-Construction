import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.border.Border;


public class Cell extends JButton {

	private int row, column;
	private static final ImageIcon[] icons = new ImageIcon[9]; //array of image icons used for each cell
	private int id;
	
	public Cell(Board board, int row, int column) {
		
		this.row = row;
		this.column = column;
		setBackground(Color.WHITE);
		
		Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		setBorder(emptyBorder);
		setBorderPainted(false);
		addActionListener(board); //adds an action listener for the board to interact with cells
		
		 String strId = Integer.toString(id); //sets the default icon based on the id of the cell
		 icons[id] = new ImageIcon(Cell.class.getResource("/data/img-0"+ strId + ".png"));
		 setIcon(icons[id]);
	}
	
	public int getId(){ //returns the id of the cell
		return this.id;
	}
	
	public void setId(int id){ //sets the id of a cell which changes the image of that cell accordingly
		this.id = id;
		String strId = Integer.toString(id);
		icons[id] = new ImageIcon(Cell.class.getResource("/data/img-0"+ strId + ".png"));
		this.setIcon(icons[id]);		
	}
	
	public int getRow(){ //returns the row of the cell
		return this.row;
	}
	
	public int getColumn(){ //returns the column of the cell
		return this.column;
	}
	
	public String toString(){ //toString() method
		String temp = "img-0" + Integer.toString(this.getId()) + ".png";
	
		return temp;
	}
}
