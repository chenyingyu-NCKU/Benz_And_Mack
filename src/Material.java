import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
public class Material extends MainGame {
	
	public static boolean mackDevice1 = false;
	public static boolean benzDevice1 = false;
	public static boolean mackDevice3 = false;
	public static boolean benzDevice3 = false;
	public static boolean mackDevice6 = false;
	public static boolean benzDevice6 = false;

	protected int x,y,width,height;
	protected Image image;
	protected boolean moveLeft,moveRight,moveUP;
	protected Rectangle hit;
	Panel panel;
	protected double xSpeed,ySpeed;
	protected void set(Panel panel) {}
	public Image getImage() {
		return image;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void mackD1() {
		mackDevice1 = true;
	}
	public void leaveMackD1() {
		mackDevice1 = false;
	}
	public void benzD1() {
		benzDevice1 = true;
	}
	public void leaveBenzD1() {
		benzDevice1 = false;
	}
	public void mackD3() {
		mackDevice3 = true;
	}
	public void leaveMackD3() {
		mackDevice3 = false;
	}
	public void benzD3() {
		benzDevice3 = true;
	}
	public void leaveBenzD3() {
		benzDevice3 = false;
	}
	public void mackD6() {
		mackDevice6 = true;
	}
	public void leaveMackD6() {
		mackDevice6 = false;
	}
	public void benzD6() {
		benzDevice6 = true;
	}
	public void leaveBenzD6() {
		benzDevice6 = false;
	}
	 
}
