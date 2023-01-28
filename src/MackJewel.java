import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
public class MackJewel {
	int x;
	int y;
	int width, height;
	String num;
	Rectangle hitBox;
	
	public MackJewel(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		hitBox = new Rectangle(x, y, width, height);

	}
	public void drawWalls (Graphics circle) {//need to change color and location
		Color mycolor = new Color(236, 189, 122);
		circle.setColor(mycolor);
		circle.fillOval(x, y, 30, 30);

	}
}
