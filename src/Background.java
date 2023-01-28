import javax.swing.ImageIcon;

public class Background extends Material{

	public Background() {
		this.image = new ImageIcon("src/Sources/gameBackground.jpg").getImage();
		this.width = 1000;
		this.height = 800;
	}
}

