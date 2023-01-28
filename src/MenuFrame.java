import javax.swing.JFrame;

public class MenuFrame extends JFrame{
	
	public MenuFrame() {
		
	this.setTitle("BenzAndMack Menu");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(500,500);
	this.setResizable(false);
	MenuPanel menuPanel = new MenuPanel();
	this.add(menuPanel);
	}
	
	private static final long serialVersionUID = 1L;
	
}
