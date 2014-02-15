import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Piece extends GameObj {
	

	public static final int SIZE = 50;       
	public static final int INIT_POS_X_LEFT = 170;
	public static final int INIT_POS_X_RIGHT = 170;
	public static final int INIT_POS_X_UP = 170;
	public static final int INIT_POS_X_DOWN = 170;
	
	public static final int INIT_POS_Y = 100; 
	public static final int INIT_VEL_X = 0;
	public static final int INIT_VEL_Y = 3;
	public final Direction direc;
	
	
	public boolean BEEN_CLICKED;
	private BufferedImage img;


	

	public Piece(Pieces p, int courtWidth, int courtHeight) {
		super(p.INIT_VEL_X, p.INIT_VEL_Y, p.INIT_POS_X, p.INIT_POS_Y,
				p.SIZE, p.SIZE, courtWidth, courtHeight);
		direc = p.dir; BEEN_CLICKED = false;
		
		try {
			if (img == null) {
				img = ImageIO.read(new File(p.image));
			}
		} catch (IOException e) {
			System.out.println("Internal Error:" + e.getMessage());
		}
		
		

		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics g){
		 g.drawImage(img, pos_x, pos_y, width, height, null); 
	}
	
	
	

}
