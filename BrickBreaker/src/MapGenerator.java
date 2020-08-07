import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class MapGenerator {

	public int map[][]; // array / matrix
	public int brickWidth;
	public int brickHeight;

	// create this image array 
	public MapGenerator(int row, int col) {
		map = new int[row][col];
		for(int i= 0; i < map.length;i++) {
			for(int j=0; j< map[0].length;j++) {
				map[i][j]=1;
			}
		}
		// set brick width and height
		brickWidth = 540/col;
		brickHeight = 150/row;
	}

	// creating the graphics 
	public void draw(Graphics2D g) {

		// create for loops 
		for(int i= 0; i < map.length;i++) {
			for(int j=0; j< map[0].length;j++) {
				// set color of each postion of mark 
				if(map[i][j] >0 ) {
					g.setColor(Color.black);
					g.fillRect(j*brickWidth+80,i*brickHeight+50, brickWidth, brickHeight);
					// brick are divided by stroke function
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.white);
					g.drawRect(j*brickWidth+80, i*brickHeight+50,brickWidth,brickHeight);

				}
			}
		}
	}
	public void setBrickValue(int value, int row, int col) {
		map[row][col] = value;
	}

}
