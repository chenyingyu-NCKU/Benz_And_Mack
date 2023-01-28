
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class BlackWater{
	
	int x;
	int y;
	int width, height;
	
	Rectangle hitBox;
	
	public BlackWater(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		hitBox = new Rectangle(x, y, width, height);
	}
	public void drawWalls (Graphics2D cube) {
		Color mycolor = new Color(50, 50, 50);
		cube.setColor(mycolor);
		cube.fillRect(x,  y,  width, height);
	}
}