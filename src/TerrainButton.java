import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class TerrainButton extends JButton {
	private static final int SIZE = 50;//sets box to be 50 pixles
	//constants are in all caps
	
	//attribues
	//clicked or not clicked
	//position,row and column, 
	//what it is bomb
	//what is surrounding it
	//flagged or not flagged
	
	private int row;
	private int col;
	private boolean isBomb = false;
	private boolean isClicked = false;
	private int nexToBombs = 0; // make sure you recalculate this value
	private boolean isFlagged = false;
	
	//Methods
	//getters and setters
	
	public TerrainButton(int r, int c) {//consturctor
		row = r;
		col = c;
		
		Dimension size = new Dimension(SIZE, SIZE);
		setPreferredSize(size);
	}
	//get collums and rows
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	//Determine if a box is a bomb
	
	public boolean hasBomb() {
		return isBomb;
	}
	public void setBomb() {//makes the thing a bomb
		isBomb = true;
	}
	public boolean beenClicked() {//checks if clicked
		return isClicked;
	}
	public void click() {//checks if button is clicked, may have to add more stuff later
		isClicked = true;
		//System.out.println(row + " and " + col + " has been clicked!");
		if (isBomb) {
			setBackground(Color.RED);
		}else {
			setBackground(Color.black);
		}
	}
	
}
