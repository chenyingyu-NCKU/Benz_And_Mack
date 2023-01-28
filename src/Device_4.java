import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Device_4 {

	int x;
	int y;
	int width, height;
	
	Rectangle hitBox;

	public Device_4(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		hitBox = new Rectangle(x, y, width, height);
	
	}
	public void drawWalls (Graphics2D cube) {
		Color myclor = new Color(222, 129, 143);
		cube.setColor(myclor);
		cube.fillRect(x,  y,  width, height);
		
		cube.setColor(Color.white);
		cube.fillRect(x+5, y+5, width-10, height-10);
	}

}
