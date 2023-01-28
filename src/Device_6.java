import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Device_6 {

	int x;
	int y;
	int width, height;

	Rectangle hitBox;
	
	public Device_6(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		hitBox = new Rectangle(x, y, width, height);
	
	}
	public void drawWalls (Graphics2D cube) {
		Color myclor = new Color(158, 214, 233);
		cube.setColor(myclor);
		cube.fillRect(x,  y,  width, height);
	}

}
