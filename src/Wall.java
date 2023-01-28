import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Wall {
	int x;
	int y;
	int width, height;
	
	Rectangle hitBox;
	
	public Wall(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		hitBox = new Rectangle(x, y, width, height);
	}
	public void drawWalls (Graphics2D cube) {
		cube.setColor(Color.LIGHT_GRAY);
		cube.drawRect(x, y, width, height);
		cube.setColor(Color.WHITE);
		cube.fillRect(x+1,  y+1,  width-2, height-2);
	}
}
