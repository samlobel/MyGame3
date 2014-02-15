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


/*
public class Game implements Runnable {
    public void run(){
        // NOTE : recall that the 'final' keyword notes inmutability
		  // even for local variables. 

        // Top-level frame in which game components live
		  // Be sure to change "TOP LEVEL FRAME" to the name of your game
        final JFrame frame = new JFrame("TOP LEVEL FRAME");
        frame.setLocation(300,300);

		  // Status panel
        final JPanel status_panel = new JPanel();
        frame.add(status_panel, BorderLayout.SOUTH);
        final JLabel status = new JLabel("Running...");
        status_panel.add(status);

        // Main playing area
        final GameCourt court = new GameCourt(status);    
        frame.add(court, BorderLayout.CENTER);

        // Reset button
        final JPanel control_panel = new JPanel();
        frame.add(control_panel, BorderLayout.NORTH);

        // Note here that when we add an action listener to the reset
        // button, we define it as an anonymous inner class that is 
        // an instance of ActionListener with its actionPerformed() 
        // method overridden. When the button is pressed,
        // actionPerformed() will be called.
        final JButton reset = new JButton("Reset");
        reset.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    court.reset();
                }
            });
        control_panel.add(reset);

        // Put the frame on the screen
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Start game
        court.reset();
    }
    
    
    
    */

    /*
     * Main method run to start and run the game
     * Initializes the GUI elements specified in Game and runs it
     * NOTE: Do NOT delete! You MUST include this in the final submission of your game.
     */


/*
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Game());
    }
}

*/


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
public class Game implements Runnable {
    public void run(){
        // NOTE : recall that the 'final' keyword notes inmutability
		  // even for local variables. 

        // Top-level frame in which game components live
		  // Be sure to change "TOP LEVEL FRAME" to the name of your game
        final JFrame frame = new JFrame("DANCE DANCE REVOLUTION");
        frame.setLocation(400,200);

        
		  // Status panel
        final JPanel status_panel = new JPanel();
        status_panel.setBackground(Color.GREEN);
        frame.add(status_panel, BorderLayout.NORTH);
        final JLabel DDR = new JLabel("DANCE DANCE REVOLUTION");
        status_panel.add(DDR);
        
        final JPanel start_menu = new JPanel();
        start_menu.setBackground(Color.GREEN);
        frame.add(start_menu, BorderLayout.EAST);
        final JButton level_chooser = new JButton("Choose Level");
        start_menu.add(level_chooser);
        level_chooser.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		LevelSelector l = new LevelSelector();
        		l.run();
        		frame.dispose();
        		
        	}
        });
        
        final ImageIcon image = new ImageIcon("main_screen.png");
        JLabel image_holder = new JLabel(image);
        frame.add(image_holder, BorderLayout.CENTER);

        
        final JPanel instruction_menu = new JPanel();
        instruction_menu.setBackground(Color.GREEN);
        frame.add(instruction_menu, BorderLayout.WEST);
        final JButton instructions = new JButton("Instructions");
        instruction_menu.add(instructions);
        
        instructions.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Instructions i = new Instructions();
        		i.run();
        		frame.dispose();
        	}
        });
        

        // Main playing area

        // Reset button
        final JPanel control_panel = new JPanel();
        control_panel.setBackground(Color.GREEN);
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
        SwingUtilities.invokeLater(new Game());
    }
}


