
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class GreenWater{
	
	int x;
	int y;
	int width, height;
	
	Rectangle hitBox;
	
	public GreenWater(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		hitBox = new Rectangle(x, y, width, height);
	}
	public void drawWalls (Graphics2D cube) {
		Color myclor = new Color(155, 205, 155);
		cube.setColor(myclor);
		cube.fillRect(x,  y,  width, height);
	}
}