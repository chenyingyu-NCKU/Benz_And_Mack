import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MenuPanel extends JPanel{
	
	private BufferedImage image;
	
	private static final long serialVersionUID = 1L;

	public MenuPanel() {
		try {                
	          image = ImageIO.read(new File("src/Sources/menuB.jpg"));
	       } catch (IOException ex) {
	            
	       }
	}
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
	}
}
