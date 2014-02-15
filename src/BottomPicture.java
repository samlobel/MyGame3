import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



public class BottomPicture extends GameObj{
	
	private BufferedImage img;


	public BottomPicture(int xpos, int courtWidth, int courtHeight, String imageName) {
		super(0, 0, xpos, 500, 50, 50, courtWidth, courtHeight);
		
		try {
			if (img == null) {
				img = ImageIO.read(new File(imageName));
			}
		} catch (IOException e) {
			System.out.println("Internal Error:" + e.getMessage());
		}
	}
	
	public void draw(Graphics g){
		 g.drawImage(img, pos_x, pos_y, width, height, null); 
	}
	
}
