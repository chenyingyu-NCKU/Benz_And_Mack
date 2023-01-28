import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MainGame {

	public static boolean mackEnd = false;
	public static boolean benzEnd = false;
	public static Frame gameframe;
	public static void main(String[] args) throws InterruptedException{
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	//how big your screen is
		
		JButton startButton = new JButton("Start");
		startButton.setOpaque(true);
		startButton.setBackground(Color.WHITE);
		startButton.setBounds(200,200,90,50);//x,y,size
		MenuFrame menu = new MenuFrame();
		menu.setVisible(true);
		menu.setLocation((int)(screenSize.getWidth()/2 - menu.getSize().getWidth()/2), 
				(int)(screenSize.getHeight()/2 - menu.getSize().getHeight()/2));//where the screen appears
		menu.add(startButton);
		menu.getContentPane().setLayout(null);
		
		JButton retryButton = new JButton("Retry");
		retryButton.setOpaque(true);
		retryButton.setBackground(Color.WHITE);
		retryButton.setBounds(200,200,90,50);//x,y,size
		EndFrame end = new EndFrame();
		end.setVisible(true);
		end.setVisible(false);
		end.setLocation((int)(screenSize.getWidth()/2 - end.getSize().getWidth()/2), 
				(int)(screenSize.getHeight()/2 - end.getSize().getHeight()/2));
		end.add(retryButton);
		end.getContentPane().setLayout(null);
		
		
		startButton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					gameframe = new Frame();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				gameframe.setLocation((int)(screenSize.getWidth()/2 - gameframe.getSize().getWidth()/2), 
						(int)(screenSize.getHeight()/2 - gameframe.getSize().getHeight()/2));
				
				gameframe.setVisible(true);
				menu.setVisible(false);
				
			}	
		});
		
		retryButton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gameframe.dispose();
				menu.setVisible(true);
				end.setVisible(false);
				mackEnd = false;
				benzEnd = false;
			}	
		});
		
		
		while(true) {
			System.out.printf("");
			if(mackEnd == true && benzEnd == true) {
				gameframe.setVisible(false);
				menu.setVisible(false);
				end.setVisible(true);
				mackEnd = false;
				benzEnd = false;
			}
		}
	}
	
	public void mEnd() {
		mackEnd = true;
	}
	public void mNotEnd() {
		mackEnd = false;
	}
	public void bEnd() {
		benzEnd = true;
	}
	public void bNotEnd() {
		benzEnd = false;
	}
	public int judgeEnd() {
		if(mackEnd == true && benzEnd == true) {
			return 1;
		}else {
			return 0;
		}
		
	}

	
}
