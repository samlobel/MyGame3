
public class Generator {
	public static Piece generate() {
		Piece p;
		int x = (int) (Math.random()*4);
		if(x < 1) {
			p = new Piece(new Pieces(Direction.LEFT), 300, 600);
			return p;
		}
		else if(x < 2) {
			p = new Piece(new Pieces(Direction.UP), 300, 600);
			return p;
		}
		else if(x < 3) {
			p = new Piece(new Pieces(Direction.DOWN), 300, 600);
			return p;
		}
		else if(x < 4) {
			p = new Piece(new Pieces(Direction.RIGHT), 300, 600);
			return p;
		}
		
		return null;
		
	}

}
