import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class Keyboard extends KeyAdapter {

	Panel panel;
	public Keyboard(Panel panel) {
		this.panel = panel;
	}

	public void keyPressed(KeyEvent e) {
		panel.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		panel.keyRealeased(e);
	}
}
