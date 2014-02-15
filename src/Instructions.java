/**
 * CIS 120 HW10
 * (c) University of Pennsylvania
 * @version 2.0, Mar 2013
 */

// imports necessary libraries for Java swing
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/** 
 * Game
 * Main class that specifies the frame and widgets of the GUI
 */
public class Instructions implements Runnable {
    public void run(){
    	
        // NOTE : recall that the 'final' keyword notes inmutability
		  // even for local variables. 

        // Top-level frame in which game components live
		  // Be sure to change "TOP LEVEL FRAME" to the name of your game
        final JFrame frame = new JFrame("DANCE DANCE REVOLUTION");
        frame.setLocation(400,200);
        frame.setBackground(Color.GREEN);
        
		  // Status panel
        final JPanel status_panel = new JPanel();
        frame.add(status_panel, BorderLayout.NORTH);
        final JLabel DDR = new JLabel("DANCE DANCE REVOLUTION");
        status_panel.setBackground(Color.GREEN);
		DDR.setFont(DDR.getFont().deriveFont(16.0f));
		DDR.setForeground(Color.RED);
        status_panel.add(DDR);
        
        
        final JPanel start_menu = new JPanel();
        frame.add(start_menu, BorderLayout.EAST);
        final JButton level_chooser = new JButton("Choose Level");
        start_menu.setBackground(Color.GREEN);
        start_menu.add(level_chooser);
        level_chooser.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		LevelSelector l = new LevelSelector();
        		frame.dispose();
        		l.run();
        		
        	}
        });
        
        final JPanel back_button = new JPanel();
        frame.add(back_button, BorderLayout.WEST);
        final JButton back = new JButton("Back to Menu");
        back_button.setBackground(Color.GREEN);
        back_button.add(back);
        
        back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Game g = new Game();
        		frame.dispose();
        		g.run();
        	}
        });
        
        
        final JPanel instruction_text = new JPanel();
        frame.add(instruction_text, BorderLayout.CENTER);
        instruction_text.setBackground(Color.GREEN);
        
        final JTextArea text = new JTextArea("" +
        		" This is a game based upon the arcade game DDR. As the song \n" +
        		" begins to play, your goal is to hit the corresponding arrow keys \n" +
        		" when the falling arrows are directly on top of their stationary \n" +
        		" counterparts. The reset button at the top of the game restarts \n" +
        		" the song and peices, the back button returns to the main menu. \n" +
        		" The closer you hit the corresponding arrow key to the correct \n" +
        		" location, the more points you get. Hitting an arrow too far from \n" +
        		" the correct location subtracts points from your score. After each  \n" +
        		" click, a text box appears under the pressed arrow which displays \n" +
        		" the accuracy of the attempt. Hitting multiple arrows in a row builds \n" +
        		" your multiplier, which maxes out at X10.   \n" +
        		" There are three diffuiculty levels: easy, medium, and hard. Each has \n" +
        		" keys randomly generated which are on tempo with the song, but at \n" +
        		" varying frequency depending on the difficulty." +
        		"    ", 5, 5);
        text.setFont(text.getFont().deriveFont(16.0f));
        text.setEditable(false);
        instruction_text.add(text);
        
        
        

        // Main playing area

        // Reset button
        final JPanel control_panel = new JPanel();
        frame.add(control_panel, BorderLayout.SOUTH);

        // Note here that when we add an action listener to the reset
        // button, we define it as an anonymous inner class that is 
        // an instance of ActionListener with its actionPerformed() 
        // method overridden. When the button is pressed,
        // actionPerformed() will be called.
        
        


        // Put the frame on the screen
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Start game
    }

    /*
     * Main method run to start and run the game
     * Initializes the GUI elements specified in Game and runs it
     * NOTE: Do NOT delete! You MUST include this in the final submission of your game.
     */
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Instructions());
    }
}
