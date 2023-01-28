import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class BenzDoor {
	int x;
	int y;
	int width, height;
	
	Rectangle hitBox;
	
	public BenzDoor(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		hitBox = new Rectangle(x, y, width, height);
	}
	public void drawDoors (Graphics2D cube) {
		Color myclor = new Color(50, 50, 50);
		cube.setColor(myclor);
		cube.drawRect(x, y, width, height);
		cube.fillRect(x, y, width, height);
		
		Color myclor2 = new Color(245, 245, 245);
		cube.setColor(myclor2);
		cube.drawRect(x+5, y+5, width-10, height-10);
		
		cube.drawString("Benz", x+21, y+50);
	}
}
