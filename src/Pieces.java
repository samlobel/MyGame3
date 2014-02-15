
public class Pieces {
	public int SIZE = 50;
	public int INIT_POS_X;
	public int INIT_POS_Y = 100;
	public int INIT_VEL_X = 0;
	public int INIT_VEL_Y = 3;
	public Direction dir;
	public static final String img_left = "left_arrow.png";
	public static final String img_right = "right_arrow.png";
	public static final String img_up = "up_arrow.png";
	public static final String img_down = "down_arrow.png";
	public String image;
	
	
	
	
	
	public Pieces(Direction d) {
		if (d==Direction.LEFT) {INIT_POS_X = 20; dir = Direction.LEFT; image = img_left;}
		if (d==Direction.DOWN) {INIT_POS_X = 80; dir = Direction.DOWN; image = img_down;}
		if (d==Direction.UP) {INIT_POS_X = 140; dir = Direction.UP; image = img_up;}
		if (d==Direction.RIGHT) {INIT_POS_X = 200; dir = Direction.RIGHT; image = img_right;}
		
		
		
	}

}
