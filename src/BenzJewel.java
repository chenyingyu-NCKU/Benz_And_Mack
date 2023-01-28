import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BenzJewel {
	
	int x;
	int y;
	int width, height;
	String num;
	Rectangle hitBox;
	
	public BenzJewel(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		hitBox = new Rectangle(x, y, width, height);

	}
	public void drawWalls (Graphics circle) {
		Color mycolor = new Color(50, 50, 50);
		circle.setColor(mycolor);
		circle.fillOval(x, y, 30, 30);
	}
}

