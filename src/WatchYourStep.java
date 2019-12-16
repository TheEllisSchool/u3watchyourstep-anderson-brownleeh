import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class WatchYourStep extends JFrame{//inheirts from JFrame
	//JFrame is lets the class know that you will have a window, allows you to use add functions and stuff
	
	private static final int GRIDSIZE = 10;
	
	//creates all the buttons
	private TerrainButton [] [] terrain = new TerrainButton [GRIDSIZE][GRIDSIZE];
	private static final int NUMBEROFBOMBS = 10;

	public WatchYourStep(){	//default constuctor for window
		
		initGUI();//sets up graphic user interface
		
		setBombs();
		
		setTitle("Minesweeper");//sets us window
		setSize(200, 100); //pixels
		setResizable(true);
		pack();//take everything in the window and make it fit, will override setSize bc it is later in the code, ussally want to use this
		setLocationRelativeTo(null); //centers on screen, do this after packing but before visible
		//null is the center
			
		setVisible(true);//need to be able to see it
		setDefaultCloseOperation(EXIT_ON_CLOSE);//allows you to close the program
		

	}
	//sets up the stuff in the window
	public void initGUI(){
		Font titleFont = new Font("Arial", Font.BOLD, 32);
		JLabel titleLabel = new JLabel("Watch Your Step");
		titleLabel.setFont(titleFont);
		add(titleLabel, BorderLayout.PAGE_START);//adds the object to the window
		titleLabel.setHorizontalAlignment(JLabel.CENTER); //left or right
		titleLabel.setForeground(Color.green);//sets the word color
		titleLabel.setBackground(Color.BLACK);//sets the background color
		titleLabel.setOpaque(true);//allows you to no see through the background
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(GRIDSIZE, GRIDSIZE));
		add(centerPanel, BorderLayout.CENTER);
		
		//TerrainButton testButton = new TerrainButton(0,0); // add the buttons
		//centerPanel.add(testButton);
		
		for (int r=0; r<GRIDSIZE; r++) {//puts all of the buttons in
			for (int c=0; c<GRIDSIZE; c++) {
				terrain[r][c] = new TerrainButton(r,c);
				//we need to make an action listener for each one
				terrain[r][c].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TerrainButton button = (TerrainButton) e.getSource();
						int row = button.getRow();
						int col = button.getCol();
						terrain[row][col].click();
					}
				});
				centerPanel.add(terrain[r][c]);
			}
		}	
	}
//sets the bombs
	public void setBombs () {
		Random rand = new Random();
		int pickRow;
		int pickCol;
		for (int i=0; i< NUMBEROFBOMBS; i++) {
			do {
				pickRow = rand.nextInt(GRIDSIZE);
				pickCol = rand.nextInt(GRIDSIZE);
			}while(terrain[pickRow][pickCol].hasBomb());//makes sure that if there is already a bomb is is false
			terrain[pickRow][pickCol].setBomb();//actually sets the spot
			}
		}

	public static void main(String[] args) {//sets up a window
		try {
            String className = UIManager.getCrossPlatformLookAndFeelClassName();//sets it to be like the window of the machine it is on
            UIManager.setLookAndFeel(className);
        } catch ( Exception e) {}
        
        EventQueue.invokeLater(new Runnable (){
            @Override
            public void run() {
                new WatchYourStep();//calling functionn
            }   
        });

	}

}
