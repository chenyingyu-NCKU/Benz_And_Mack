import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Button_1 {
	int x;
	int y;
	int width, height;
	String num;
	Rectangle hitBox;
	
	public Button_1(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		hitBox = new Rectangle(x, y, width, height);

	}
	public void drawWalls (Graphics semi) {
		Color mycolor = new Color(225, 216, 195);
		semi.setColor(mycolor);
		semi.fillArc(x, y, width, height, 0, 180);
		
	}
}
