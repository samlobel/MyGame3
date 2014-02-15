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
public class LevelSelector implements Runnable {
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
        status_panel.setBackground(Color.GREEN);
        frame.add(status_panel, BorderLayout.NORTH);
        final JLabel DDR = new JLabel("DANCE DANCE REVOLUTION");
        DDR.setBackground(Color.GREEN);
		DDR.setFont(DDR.getFont().deriveFont(16.0f));
		DDR.setForeground(Color.RED);
        status_panel.add(DDR);
        
        
        
        final JPanel blank = new JPanel();
        blank.setBackground(Color.GREEN);
        frame.add(blank, BorderLayout.SOUTH);
        final JLabel blanker = new JLabel("");
        blanker.setBackground(Color.GREEN);
        blank.add(blanker);
        
        final ImageIcon image = new ImageIcon("main_screen.png");
        JLabel image_holder = new JLabel(image);
        frame.add(image_holder, BorderLayout.CENTER);
        
        final JPanel games = new JPanel();
        games.setBackground(Color.GREEN);
        games.setLayout(new GridLayout(3,1));
        frame.add(games, BorderLayout.EAST);
        
        final JButton sandstorm_easy = new JButton("SandStorm, Easy");
        games.add(sandstorm_easy);
        sandstorm_easy.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Game3 g = new Game3();

        		g.difficulty = 1;
        		frame.dispose();
        		g.run();
        	}
        });
        
        final JButton sandstorm_medium = new JButton("SandStorm, Medium");
        games.add(sandstorm_medium);
        sandstorm_medium.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Game3 g = new Game3();
        		g.difficulty = 2;
        		frame.dispose();
        		g.run();
        	}
        });
        
        final JButton sandstorm_hard = new JButton("SandStorm, Hard");
        games.add(sandstorm_hard);
        sandstorm_hard.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Game3 g = new Game3();
        		g.difficulty = 4;
        		g.run();
        		frame.dispose();
        	}
        });
        
        
        final JPanel back_menu = new JPanel();
        back_menu.setBackground(Color.GREEN);
        frame.add(back_menu, BorderLayout.WEST);
        final JButton back = new JButton("Back to Menu");
        back_menu.add(back);
        
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        		Game g = new Game();
        		g.run();
        		frame.dispose();
            }
        });
        

        // Main playing area


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
        SwingUtilities.invokeLater(new LevelSelector());
    }
}
