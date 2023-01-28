import javax.swing.JFrame;

public class EndFrame extends JFrame{
	public EndFrame() {
		
		this.setTitle("BenzAndMack End");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setResizable(false);
		EndPanel endPanel = new EndPanel();
		this.add(endPanel);
		}
	private static final long serialVersionUID = 1L;

}
