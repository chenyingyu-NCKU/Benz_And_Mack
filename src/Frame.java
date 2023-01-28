
import javax.swing.JFrame;


public class Frame extends JFrame{

	private static final long serialVersionUID = 1L;

	public Frame() throws InterruptedException{
		
		this.setTitle("BenzAndMack");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,835);
		this.setResizable(false);
		
		Material benz = new Benz();
		Material mack = new Mack();
		Material background = new Background();
		Panel panel = new Panel(benz,mack,background);
		this.add(panel);
		this.setVisible(true);
		addKeyListener(new Keyboard(panel));
		
		
	}
}
