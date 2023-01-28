import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Button_2 {
	int x;
	int y;
	int width, height;
	String num;
	Rectangle hitBox;
	
	public Button_2(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		hitBox = new Rectangle(x, y, width, height);

	}
	public void drawWalls (Graphics semi) {
		Color mycolor = new Color(212, 179, 241);
		semi.setColor(mycolor);
		semi.fillArc(x, y, width, height, 0, 180);
		

		semi.setColor(Color.white);
		semi.fillArc(x+5, y+5, width-10, height-10, 0, 180);

	}
}
