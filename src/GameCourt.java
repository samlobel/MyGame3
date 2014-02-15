/**
 * CIS 120 HW10
 * (c) University of Pennsylvania
 * @version 2.0, Mar 2013
 */

import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * GameCourt
 * 
 * This class holds the primary game logic of how different objects 
 * interact with one another.  Take time to understand how the timer 
 * interacts with the different methods and how it repaints the GUI 
 * on every tick().
 *
 */
@SuppressWarnings("serial")
public class GameCourt extends JPanel {

	// the state of the game logic
	
	public boolean playing = false;  // whether the game is running
	private JLabel status;       // Current status text (i.e. Running...)
	
	

	

	// Game constants
	public static final int COURT_WIDTH = 300;
	public static final int COURT_HEIGHT = 600;
	public static final int SQUARE_VELOCITY = 4;
	// Update interval for timer in milliseconds 
	public static final int INTERVAL = 35; 
	public int TIME_IN_SONG;
	public int END_TIME;
	public LinkedList<Piece> PIECES_ON_BOARD;
	public LinkedList<Integer> PLACEHOLDER;
	public LinkedList<Piece> PLACEHOLDER_2;
	public int score;
	public int high_score;
	public String hit_miss;
	
	public AudioClip song;
	public boolean click_caught;
	public int multiplier;
	
	BottomPicture left;
	BottomPicture right;
	BottomPicture up;
	BottomPicture down;
	public int appear;
	
	public int dif;
	
	public final int milliseconds_per_beat = 880;
	public int beat_on;
	
	public int miss;
	public int none;
	public int good;
	public int great;
	public int perfect;
	

	public GameCourt(JLabel status, int difficulty){
		
		dif = difficulty;
		beat_on = 0;
		//just a way to make the list		
		multiplier = 3;
		appear = 0;
		
		miss = 0;
		none = 0;
		good = 0;
		great = 0;
		perfect = 0;
		high_score = 0;
		
			
		
		
		PIECES_ON_BOARD = new LinkedList<Piece>();
		PLACEHOLDER_2 = new LinkedList<Piece>();
		

		TIME_IN_SONG = 0;
		END_TIME = 448000;
		score = 0;
		hit_miss = "";
		
		this.setFont(this.getFont().deriveFont(16.0f));
				


		
		
		//Playing the song

		
		
		// creates border around the court area, JComponent method
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        // The timer is an object which triggers an action periodically
        // with the given INTERVAL. One registers an ActionListener with
        // this timer, whose actionPerformed() method will be called 
        // each time the timer triggers. We define a helper method
        // called tick() that actually does everything that should
        // be done in a single timestep.
		Timer timer = new Timer(INTERVAL, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tick();
			}
		});
		timer.start(); // MAKE SURE TO START THE TIMER!

		// Enable keyboard focus on the court area
		// When this component has the keyboard focus, key
		// events will be handled by its key listener.
		setFocusable(true);

		// this key listener allows the square to move as long
		// as an arrow key is pressed, by changing the square's
		// velocity accordingly. (The tick method below actually 
		// moves the square.)
		addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					// I want to iterate over the list of objects on the board,
					// and if any of them are in left, call a series of commands about
					// their positions. I want four zones: Miss, okay, good, great.
					// I want to do the same thing for all of these
					
					for(Piece p: PIECES_ON_BOARD) {
						if(p.direc == Direction.LEFT) {
							if(p.pos_y > 450) {
								if(p.pos_y < 470) {
									hit_miss = "MISS!";
									multiplier = 3;
									miss++;
								}
								else if(p.pos_y < 490) {
									hit_miss = "GOOD!";
									score = score + (20 * (multiplier / 3));
									multiplier++;
									multiplier = Math.min(multiplier, 30);
									good++;
								}
								else if(p.pos_y < 498) {
									hit_miss = "GREAT!";
									score = score + (50 * (multiplier / 3));
									multiplier++;
									multiplier = Math.min(multiplier, 30);
									great++;
								}
								else if(p.pos_y < 503) {
									hit_miss = "PERFECT!";
									score = score + (100 * (multiplier / 3));
									multiplier++;
									multiplier = Math.min(multiplier, 30);
									perfect++;
								}
								else if(p.pos_y < 510) {
									hit_miss = "GREAT!";
									score = score + (50 * (multiplier / 3));
									multiplier++;
									multiplier = Math.min(multiplier, 30);
									great++;
									}
								else if(p.pos_y < 530) {
									hit_miss = "GOOD!";
									score = score + (20 * (multiplier / 3));
									multiplier++;
									multiplier = Math.min(multiplier, 30);
									good++;
									}
								else if(p.pos_y < 550) {
									hit_miss = "MISS!";
									multiplier = 3;
									miss++;
								}
								p.BEEN_CLICKED = true;
								click_caught = true;
								break;
							}
						}
					}
					if (click_caught == false) {
						hit_miss = "NONE";
						multiplier = 3;
						score = score - 50;
						score = Math.max(0, score);
						none++;
						
					}
					appear = 20;
					
				}
				else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
					for(Piece p: PIECES_ON_BOARD) {
						if(p.direc == Direction.RIGHT) {
							if(p.pos_y > 450) {
								if(p.pos_y < 470) {
									hit_miss = "MISS!";
									multiplier = 3;
									miss++;
								}
								else if(p.pos_y < 490) {
									hit_miss = "GOOD!";
									score = score + (20 * (multiplier / 3));
									multiplier++;
									multiplier = Math.min(multiplier, 30);
									good++;
								}
								else if(p.pos_y < 498) {
									hit_miss = "GREAT!";
									score = score + (50 * (multiplier / 3));
									multiplier++;
									multiplier = Math.min(multiplier, 30);
									great++;
								}
								else if(p.pos_y < 503) {
									hit_miss = "PERFECT!";
									score = score + (100 * (multiplier / 3));
									multiplier++;
									multiplier = Math.min(multiplier, 30);
									perfect++;
								}
								else if(p.pos_y < 510) {
									hit_miss = "GREAT!";
									score = score + (50 * (multiplier / 3));
									multiplier++;
									multiplier = Math.min(multiplier, 30);
									great++;
									}
								else if(p.pos_y < 530) {
									hit_miss = "GOOD!";
									score = score + (20 * (multiplier / 3));
									multiplier++;
									multiplier = Math.min(multiplier, 30);
									good++;
									}
								else if(p.pos_y < 550) {
									hit_miss = "MISS!";
									multiplier = 3;
									miss++;
									
								}
								p.BEEN_CLICKED = true;
								click_caught = true;
								break;
							}
							
						}
					}
					if (click_caught == false) {
						hit_miss = "NONE";
						score = score - 20;
						score = Math.max(0, score);
						multiplier = 3;
						none++;
						
					}
					appear = 200;

				}
					
				else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					for(Piece p: PIECES_ON_BOARD) {
						if(p.direc == Direction.DOWN) {
							if(p.pos_y > 450) {
								if(p.pos_y < 470) {
									hit_miss = "MISS!";
									multiplier = 3;
									miss++;
								}
								else if(p.pos_y < 490) {
									hit_miss = "GOOD!";
									score = score + (20 * (multiplier / 3));
									multiplier++;
									multiplier = Math.min(multiplier, 30);
									good++;
								}
								else if(p.pos_y < 498) {
									hit_miss = "GREAT!";
									score = score + (50 * (multiplier / 3));
									multiplier++;
									multiplier = Math.min(multiplier, 30);
									great++;
								}
								else if(p.pos_y < 503) {
									hit_miss = "PERFECT!";
									score = score + (100 * (multiplier / 3));
									multiplier++;
									multiplier = Math.min(multiplier, 30);
									perfect++;
								}
								else if(p.pos_y < 510) {
									hit_miss = "GREAT!";
									score = score + (50 * (multiplier / 3));
									multiplier++;
									multiplier = Math.min(multiplier, 30);
									great++;
									}
								else if(p.pos_y < 530) {
									hit_miss = "GOOD!";
									score = score + (20 * (multiplier / 3));
									multiplier++;
									multiplier = Math.min(multiplier, 30);
									good++;
									}
								else if(p.pos_y < 550) {
									hit_miss = "MISS!";
									multiplier = 3;
									multiplier = Math.min(multiplier, 30);
									miss++;
								}
								p.BEEN_CLICKED = true;
								click_caught = true;
								break;
								}
							
						}
					}
					if (click_caught == false) {
						hit_miss = "NONE";
						score = score - 20;
						score = Math.max(0, score);
						multiplier = 3;
						none++;
						
					}
					appear = 80;					
				}
				else if (e.getKeyCode() == KeyEvent.VK_UP){
					for(Piece p: PIECES_ON_BOARD) {
						if(p.direc == Direction.UP) {
							if(p.pos_y > 450) {
								if(p.pos_y < 470) {
									hit_miss = "MISS!";
									multiplier = 3;
									miss++;
								}
								else if(p.pos_y < 490) {
									hit_miss = "GOOD!";
									score = score + (20 * (multiplier / 3));
									multiplier++;
									multiplier = Math.min(multiplier, 30);
									good++;
								}
								else if(p.pos_y < 498) {
									hit_miss = "GREAT!";
									score = score + (50 * (multiplier / 3));
									multiplier++;
									multiplier = Math.min(multiplier, 30);
									great++;
								}
								else if(p.pos_y < 503) {
									hit_miss = "PERFECT!";
									score = score + (100 * (multiplier / 3));
									multiplier++;
									multiplier = Math.min(multiplier, 30);
									perfect++;
								}
								else if(p.pos_y < 510) {
									hit_miss = "GREAT!";
									score = score + (50 * (multiplier / 3));
									multiplier++;
									multiplier = Math.min(multiplier, 30);
									great++;
								}
								else if(p.pos_y < 530) {
									hit_miss = "GOOD!";
									score = score + (20 * (multiplier / 3));
									multiplier++;
									multiplier = Math.min(multiplier, 30);
									good++;
									}
								else if(p.pos_y < 550) {
									hit_miss = "MISS!";
									multiplier = 3;
									miss++;
								}
								p.BEEN_CLICKED = true;
								click_caught = true;
								break;
							}
							
						}
						
					}
					if (click_caught == false) {
						hit_miss = "NONE";
						score = score - 20;
						score = Math.max(0, score);
						multiplier = 3;
						none++;
						
					}
					appear = 140;
				}
				for(Piece p: PIECES_ON_BOARD) {
					if(p.BEEN_CLICKED == true) {PLACEHOLDER_2.add(p);}				}
				for(Piece p: PLACEHOLDER_2) {
					PIECES_ON_BOARD.remove(p); //Same as above.
				}
				PLACEHOLDER_2.clear();
				click_caught = false;
				
			}

		});

		this.status = status;
		}

	/** (Re-)set the state of the game to its initial state.
	 */

	
	
	public void reset() {


		left = new BottomPicture(20, COURT_WIDTH, COURT_HEIGHT, "left_arrow.png");
		down= new BottomPicture(80, COURT_WIDTH, COURT_HEIGHT, "down_arrow.png");
		up = new BottomPicture(140, COURT_WIDTH, COURT_HEIGHT, "up_arrow.png");
		right = new BottomPicture(200, COURT_WIDTH, COURT_HEIGHT, "right_arrow.png");
		
		song.stop();
		try{
		song = StdAudio.play("Sandstorm-DaRude.wav");
		}
		catch(Exception e) {
			System.out.println("couldn't find file");
		}
		click_caught = false;
		
		miss = 0;
		good = 0;
		great = 0;
		perfect = 0;
		none = 0;

		score = 0;
		hit_miss = "";
		PIECES_ON_BOARD.clear();
		

		multiplier = 3;

		playing = true;
		TIME_IN_SONG = 0;
		beat_on = 0;
		status.setText("Running...");

		// Make sure that this component has the keyboard focus
		requestFocusInWindow();
	}

    /**
     * This method is called every time the timer defined
     * in the constructor triggers.
     */
	void tick(){
		if (playing) {
			//advances the time step by one;
			TIME_IN_SONG = TIME_IN_SONG + INTERVAL;
			// I want to iterate over the map PIECES_TO_COME now. I'll check to see if any of them are
			// less than TIME_IN_SONG, and if they are, remove them and put them on the
			// list PIECES_ON_BOARD.
			
			if(TIME_IN_SONG <= (END_TIME - 8000)) {
			if(beat_on*milliseconds_per_beat / dif < TIME_IN_SONG){
				PIECES_ON_BOARD.add(Generator.generate());
				beat_on++;
			}
			}


			
			
			// Then, I want to iterate over the PIECES_ON_BOARD list, and call .move on each of them.
			// Also, if the piece's y  + the velocity is more than max_y,
			// it should be removed from the tree, and there maybe should be something that happens.
			
			//check later to see if it's right
			for(Piece p: PIECES_ON_BOARD) {
				p.move();
				if(p.pos_y + p.v_y >= p.max_y) {
					
					PLACEHOLDER_2.add(p);
					score = score - 20;
					score = Math.max(0, score);
					hit_miss = "MISS!";
					multiplier = 3;
					none++;
					
				}
			}
			high_score = Math.max(score, high_score);
			for(Piece p: PLACEHOLDER_2) {
				PIECES_ON_BOARD.remove(p); //Same as above.
			}
			PLACEHOLDER_2.clear();
			
			// advance the square and snitch in their
			// current direction.
			
			//This is the end condition:
			if(TIME_IN_SONG >= END_TIME) {playing = false; status.setText("Good Game");
			song.stop();}
			

		
			// check for the game end conditions
			
			// update the display
			repaint();
			
		} 
	}

	@Override 
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		// Here, I want to iterate over my PIECES_ON_BOARD, and draw each of them.
		
		left.draw(g);
		right.draw(g);
		up.draw(g);
		down.draw(g);
		
		for(Piece p: PIECES_ON_BOARD) {
			p.draw(g);
		}
		
		g.drawString(Integer.toString(score), 210, 20);
		g.drawString(Integer.toString(high_score), 20, 20);
		g.drawString(hit_miss, appear, 570);
		g.drawString("MULTI:", 210, 70);
		g.drawString("X", 210, 95);
		
		g.drawString(Integer.toString(multiplier / 3), 230, 95);
		
		g.drawString("NONE: ", 20, 50);
		g.drawString("MISS: ", 120, 50);
		g.drawString("GOOD: ", 20, 70);
		g.drawString("GREAT: ", 120, 70);
		g.drawString("PERFECT: ", 20, 90);
		
		g.drawString(Integer.toString(none), 75, 50);
		g.drawString(Integer.toString(miss), 175, 50);
		g.drawString(Integer.toString(good), 75, 70);
		g.drawString(Integer.toString(great), 183, 70);
		g.drawString(Integer.toString(perfect), 100, 90);
		



		
		
		
		
		
	}

	@Override
	public Dimension getPreferredSize(){
		return new Dimension(COURT_WIDTH,COURT_HEIGHT);
	}
}
