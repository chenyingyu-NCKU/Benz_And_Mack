import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class Panel extends JPanel implements ActionListener{
	
	ArrayList<Wall> walls = new ArrayList<>();	
	ArrayList<BlackWater> bw = new ArrayList<>();
	ArrayList<OrangeWater> ow = new ArrayList<>();
	ArrayList<GreenWater> gw = new ArrayList<>();
	ArrayList<BenzJewel> bj1 = new ArrayList<>();
	ArrayList<BenzJewel> bj2 = new ArrayList<>();
	ArrayList<BenzJewel> bj3 = new ArrayList<>();
	ArrayList<BenzJewel> bj4 = new ArrayList<>();
	ArrayList<BenzJewel> bj5 = new ArrayList<>();
	ArrayList<MackJewel> mj1 = new ArrayList<>();
	ArrayList<MackJewel> mj2 = new ArrayList<>();
	ArrayList<MackJewel> mj3 = new ArrayList<>();
	ArrayList<MackJewel> mj4 = new ArrayList<>();
	ArrayList<MackJewel> mj5 = new ArrayList<>();
	ArrayList<MackDoor> md = new ArrayList<>();
	ArrayList<BenzDoor> bd = new ArrayList<>();
	ArrayList<Device_1> d1 = new ArrayList<>();
	ArrayList<Button_1> b1_1 = new ArrayList<>();
	ArrayList<Button_1> b1_2 = new ArrayList<>();
	ArrayList<Device_2> d2 = new ArrayList<>();
	ArrayList<Button_2> b2 = new ArrayList<>();
	ArrayList<Device_3> d3 = new ArrayList<>();
	ArrayList<Button_3> b3 = new ArrayList<>();
	ArrayList<Device_4> d4 = new ArrayList<>();
	ArrayList<Button_4> b4 = new ArrayList<>();
	ArrayList<Device_5> d5 = new ArrayList<>();
	ArrayList<Button_5> b5 = new ArrayList<>();
	ArrayList<Device_6> d6 = new ArrayList<>();
	ArrayList<Button_6> b6 = new ArrayList<>();

	private Material benz,mack,background;
	
	public Panel(Material benz,Material mack,Material background) {
		this.benz = benz;
		this.mack = mack;
		this.background = background;
		Panel panel = this;
		makeWalls();
		makeGreenWater();makeBlackWater();makeOrangeWater();
		makeBenzJewel1();makeBenzJewel2();makeBenzJewel3();makeBenzJewel4();makeBenzJewel5();
		makeMackJewel1();makeMackJewel2();makeMackJewel3();makeMackJewel4();makeMackJewel5();
		makeMackDoor();makeBenzDoor();
		makedevice1();makebutton1_1();makebutton1_2();
		makedevice2();makebutton2();
		makedevice3();makebutton3();
		makedevice4();makebutton4();
		makedevice5();makebutton5();
		makedevice6();makebutton6();

		
		Timer gameTimer = new Timer();
		gameTimer.schedule(new TimerTask() {
			public void run() {
			benz.set(panel);
			mack.set(panel);
			repaint();
		}
		},0,5);//5millisecond
		
	}
	private void makebutton6() {
		b6.add(new Button_6(850, 200, 30, 20));
		
	}
	private void makedevice6() {
		d6.add(new Device_6(30, 490, 90, 20));
		
	}
	private void makebutton5() {
		b5.add(new Button_5(50, 620, 30, 20));
		
	}
	private void makedevice5() {
		d5.add(new Device_5(820, 100, 20, 110));
		
	}
	private void makebutton4() {
		b4.add(new Button_4(725,280, 30, 20));
		
	}
	private void makedevice4() {
		d4.add(new Device_4(370, 180, 20, 110));
		
	}
	private void makebutton3() {
		b3.add(new Button_3(330, 280, 30,20));
		
	}
	private void makedevice3() {
		d3.add(new Device_3(500, 150, 80, 20));
		
	}
	private void makebutton2() {
		b2.add(new Button_2(300, 620, 30, 20));
		
	}
	private void makedevice2() {
		d2.add(new Device_2(800, 380, 20, 110));
		
	}
	private void makebutton1_1() {
		b1_1.add(new Button_1(830, 760, 30, 20));
	}
	private void makebutton1_2() {
		b1_2.add(new Button_1(760, 620, 30, 20));
	}
	private void makedevice1() {
		d1.add(new Device_1(900, 550, 70, 20));
		
	}
	private void makeMackDoor() {
		md.add(new MackDoor(900, 120, 70, 90));
		
	}
	private void makeBenzDoor() {
		bd.add(new BenzDoor(140, 120, 70, 90));
		
	}
	private void makeBenzJewel1() {
		bj1.add(new BenzJewel(465, 680, 30, 30));
	}
	private void makeBenzJewel2() {
		bj2.add(new BenzJewel(465, 455, 30, 30));
	}
	private void makeBenzJewel3() {
		bj3.add(new BenzJewel(850, 400, 30, 30));
	}
	private void makeBenzJewel4() {	
		bj4.add(new BenzJewel(925, 260, 30, 30));
	}
	private void makeBenzJewel5() {
		bj5.add(new BenzJewel(180, 320, 30, 30));
	}
	private void makeMackJewel1() {
		mj1.add(new MackJewel(345, 680, 30, 30));
	}
	private void makeMackJewel2() {
		mj2.add(new MackJewel(495, 455, 30, 30));
	}
	private void makeMackJewel3() {
		mj3.add(new MackJewel(135, 400, 30, 30));
	}
	private void makeMackJewel4() {	
		mj4.add(new MackJewel(895, 260, 30, 30));
	}
	private void makeMackJewel5() {
		mj5.add(new MackJewel(330, 230, 30, 30));
	}
	private void makeGreenWater() {
		for(int i = 630; i < 780; i+=30)
			gw.add(new GreenWater(i, 770, 30, 15));
		for(int i = 420; i < 570; i+=30)
			gw.add(new GreenWater(i, 630, 30, 15));
	}

	private void makeOrangeWater() {
		for(int i = 450; i < 510; i+=30)
			ow.add(new OrangeWater(i, 770, 30, 15));
		for(int i = 630; i < 780; i+=30)
			ow.add(new OrangeWater(i, 490, 30, 15));
		for(int i = 450; i < 630; i+=30)
			ow.add(new OrangeWater(i, 350, 30, 15));
	}

	private void makeBlackWater() {
		for(int i = 330; i < 390; i+=30)
			bw.add(new BlackWater(i, 770, 30, 15));
		for(int i = 120; i < 180; i+=30)
			bw.add(new BlackWater(i, 630, 30, 15));
		for(int i = 180; i < 240; i+=30)
			bw.add(new BlackWater(i, 490, 30, 15));
		for(int i = 300; i < 360; i+=30)
			bw.add(new BlackWater(i, 490, 30, 15));
	}

	public void makeWalls() {
		for(int i = 0; i < 330; i+=30)           //floor 1
			walls.add(new Wall(i, 770, 30, 30)); 
		for(int i = 330; i < 390; i+=30) 
			walls.add(new Wall(i, 785, 30, 15));
		for(int i = 390; i < 450; i+=30)          
			walls.add(new Wall(i, 770, 30, 30)); 
		for(int i = 450; i < 510; i+=30) 
			walls.add(new Wall(i, 785, 30, 15));
		for(int i = 510; i < 630; i+=30)         
			walls.add(new Wall(i, 770, 30, 30)); 
		for(int i = 630; i < 780; i+=30) 
			walls.add(new Wall(i, 785, 30, 15));
		for(int i = 780; i < 990; i+=30)       
			walls.add(new Wall(i, 770, 30, 30)); 
		
		
		for(int i = 0; i < 990; i+=30)           //roof
			walls.add(new Wall(i, 70, 30, 30));
		
		
		for(int i = 675; i < 735; i+=30)        //floor 1.5
			walls.add(new Wall(i, 710, 30,30));
		
		for(int i = 0; i < 120; i+=30)          //floor 2
			walls.add(new Wall(i, 630, 30, 30)); 
		for(int i = 120; i < 180; i+=30)
			walls.add(new Wall(i, 645, 30, 15));
		for(int i = 180; i < 420; i+=30)         
			walls.add(new Wall(i, 630, 30, 30));
		for(int i = 420; i < 570; i+=30)
			walls.add(new Wall(i, 645, 30, 15));
		for(int i = 570; i < 840; i+=30)        
			walls.add(new Wall(i, 630, 30, 30)); 
		for(int i = 470; i < 520; i+=30)         //floor 2.5
			walls.add(new Wall(i, 570, 30, 30)); 
		
		for(int i = 120; i < 180; i+=30)         //floor 3
			walls.add(new Wall(i, 490, 30, 30)); 
		for(int i = 180; i < 240; i+=30)
			walls.add(new Wall(i, 505, 30, 15));
		for(int i = 240; i < 300; i+=30)          
			walls.add(new Wall(i, 490, 30, 30)); 
		for(int i = 300; i < 360; i+=30)
			walls.add(new Wall(i, 505, 30, 15));
		for(int i = 360; i < 420; i+=30)          
			walls.add(new Wall(i, 490, 30, 30)); 
		for(int i = 570; i < 630; i+=30)          
			walls.add(new Wall(i, 490, 30, 30)); 
		for(int i = 630; i < 780; i+=30)
			walls.add(new Wall(i, 505, 30, 15));
		for(int i = 780; i < 990; i+=30)          
			walls.add(new Wall(i, 490, 30, 30)); 
		for(int i = 675; i < 735; i+=30)         //floor 3.5
			walls.add(new Wall(i, 430, 30, 30)); 
		for(int i = 920; i < 990; i+=30)          
			walls.add(new Wall(i, 430, 30, 30)); 
		
	    for(int i = 120; i < 450; i+=30)         //floor 4
			walls.add(new Wall(i, 350, 30, 30)); 
	    for(int i = 450; i < 630; i+=30)
			walls.add(new Wall(i, 365, 30, 15));
	    for(int i = 630; i < 870; i+=30)         
			walls.add(new Wall(i, 350, 30, 30)); 
	    for(int i = 300; i < 390; i+=30)         //floor 4.5
			walls.add(new Wall(i, 290, 30, 30)); 
	    for(int i = 710; i < 770; i+=30)         
			walls.add(new Wall(i, 290, 30, 30)); 
	    

	    for(int i = 120; i < 240; i+=30)          //floor 5
	  		walls.add(new Wall(i, 210, 30, 30)); 
	    for(int i = 820; i < 990; i+=30)         
	  		walls.add(new Wall(i, 210, 30, 30)); 
		
		for(int i = 70; i <= 770; i+=30)        //left
			walls.add(new Wall(0, i, 30, 30)); 
		for(int i = 70; i <= 800; i+=30)        //right
			walls.add(new Wall(970, i, 30, 30));
		for(int i = 210; i < 350; i+=30)         //wall 1
			walls.add(new Wall(120, i, 30, 30));
		for(int i = 100; i < 210; i+=30)         //wall 2
			walls.add(new Wall(210, i, 30, 30));
		for(int i = 100; i < 290; i+=30)         //wall 3
			walls.add(new Wall(300, i, 30, 30));
		
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D cube = (Graphics2D) g;
		Graphics2D semi = (Graphics2D) g;
		g.drawImage(background.getImage(),background.getX(),background.getY(),background.getWidth(),background.getHeight(),null);
		for(MackDoor mackdoor: md) mackdoor.drawDoors(cube);
		for(BenzDoor benzdoor: bd) benzdoor.drawDoors(cube);
		
		for(Button_1 button1: b1_1) button1.drawWalls(semi);
		for(Button_1 button1: b1_2) button1.drawWalls(semi);
		for(Button_2 button1: b2) button1.drawWalls(semi);
		for(Button_3 button1: b3) button1.drawWalls(semi);
		for(Button_4 button1: b4) button1.drawWalls(semi);
		for(Button_5 button1: b5) button1.drawWalls(semi);
		for(Button_6 button1: b6) button1.drawWalls(semi);
		
		g.drawImage(benz.getImage(),benz.getX(),benz.getY(),benz.getWidth(),benz.getHeight(),null);
		g.drawImage(mack.getImage(),mack.getX(),mack.getY(),mack.getWidth(),mack.getHeight(),null);

		
		for(BlackWater black: bw) black.drawWalls(cube);
		for(OrangeWater orange: ow) orange.drawWalls(cube);
		for(GreenWater green: gw) green.drawWalls(cube);
		for(Device_1 device1: d1) device1.drawWalls(cube);
		for(Device_2 device1: d2) device1.drawWalls(cube);
		for(Device_3 device1: d3) device1.drawWalls(cube);
		for(Device_4 device1: d4) device1.drawWalls(cube);
		for(Device_5 device1: d5) device1.drawWalls(cube);
		for(Device_6 device1: d6) device1.drawWalls(cube);
		for(Wall wall: walls) wall.drawWalls(cube);
		
	
		Graphics2D circle = (Graphics2D) g;
		for(BenzJewel bjewel: bj1) bjewel.drawWalls(circle);
		for(BenzJewel bjewel: bj2) bjewel.drawWalls(circle);
		for(BenzJewel bjewel: bj3) bjewel.drawWalls(circle);
		for(BenzJewel bjewel: bj4) bjewel.drawWalls(circle);
		for(BenzJewel bjewel: bj5) bjewel.drawWalls(circle);
		
		for(MackJewel mjewel: mj1) mjewel.drawWalls(circle);
		for(MackJewel mjewel: mj2) mjewel.drawWalls(circle);
		for(MackJewel mjewel: mj3) mjewel.drawWalls(circle);
		for(MackJewel mjewel: mj4) mjewel.drawWalls(circle);
		for(MackJewel mjewel: mj5) mjewel.drawWalls(circle);
		
	}
	
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_A:
				benz.moveLeft = true;break;
			case KeyEvent.VK_D:
				benz.moveRight = true;break;
			case KeyEvent.VK_W:
				benz.moveUP = true;break;
			case KeyEvent.VK_LEFT:
				mack.moveLeft = true;break;
			case KeyEvent.VK_RIGHT:
				mack.moveRight = true;break;
			case KeyEvent.VK_UP:
				mack.moveUP = true;break;
		}
			
	}
	public void keyRealeased(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_A:
				benz.moveLeft = false;break;
			case KeyEvent.VK_D:
				benz.moveRight = false;break;
			case KeyEvent.VK_W:
				benz.moveUP = false;break;
			case KeyEvent.VK_LEFT:
				mack.moveLeft = false;break;
			case KeyEvent.VK_RIGHT:
				mack.moveRight = false;break;
			case KeyEvent.VK_UP:
				mack.moveUP = false;break;
		}
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
