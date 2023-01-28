import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Benz extends Material{
	
	private boolean bj1Contract = false;
	private boolean bj2Contract = false;
	private boolean bj3Contract = false;
	private boolean bj4Contract = false;
	private boolean bj5Contract = false;
	private int collect = 0;
	public Benz() {
		this.image = new ImageIcon("src/Sources/Benz.png").getImage();
		this.width = 30;
		this.height = 30;
		this.x = 80;
		this.y = 740;
		this.collect = 0;
		this.hit = new Rectangle(x, y, width, height);
		
	}
	public void set(Panel panel) {
		this.panel = panel;
		if(moveLeft && moveRight || !moveLeft && !moveRight)xSpeed *= 0.8;
		else if(moveLeft && !moveRight) xSpeed--;
		else if(!moveLeft && moveRight) xSpeed++;
		//prevent sliding
		if(xSpeed>0 && xSpeed<0.75)xSpeed = 0;
		if(xSpeed<0 && xSpeed>-0.75)xSpeed = 0;
		//prevent too fast
		if(xSpeed>2)xSpeed = 2;
		if(xSpeed<-2)xSpeed = -2;
		if(moveUP) {
			hit.y ++;//make sure on ground
			for(Wall wall : panel.walls) {
				if(wall.hitBox.intersects(hit)) {
					ySpeed = -8;
				}
			}
			for(Device_1 d1: panel.d1) {
				if(d1.hitBox.intersects(hit)) {
					ySpeed = -8;
				}
			}
			for(Device_3 d3: panel.d3) {
				if(d3.hitBox.intersects(hit)) {
					ySpeed = -8;
				}
			}
			for(Device_6 d6: panel.d6) {
				if(d6.hitBox.intersects(hit)) {
					ySpeed = -8;
				}
			}
			hit.y --;
		}
		ySpeed += 0.3;//gravity
		
		//horizontal collision
		hit.x += xSpeed;
		for(Wall wall: panel.walls) {
			if(hit.intersects(wall.hitBox)) {
				hit.x -= xSpeed;
				while(!wall.hitBox.intersects(hit)) {
					hit.x += Math.signum(xSpeed);
				}//keep moving until touches wall
				hit.x -= Math.signum(xSpeed);
				xSpeed = 0;
				x = hit.x;
			}
		}
		//vertical
		hit.y += ySpeed;
		for(Wall wall: panel.walls) {
			if(hit.intersects(wall.hitBox)) {
				hit.y -= ySpeed;
				while(!wall.hitBox.intersects(hit)) {
					//keep moving until touches wall
					hit.y += Math.signum(ySpeed);
				}
				hit.y -= Math.signum(ySpeed);
				ySpeed = 0;
				y = hit.y;
			
			}
		}
		//green water
		for(GreenWater green: panel.gw) {
			if(hit.intersects(green.hitBox)) {
				x = 80;
				y = 740;
			}
		}
		//orange water
		for(OrangeWater orange: panel.ow) {
			if(hit.intersects(orange.hitBox)) {
				x = 80;
				y = 740;
			}
		}
		
		//jewel
		for(BenzJewel bj1: panel.bj1) {
			if(hit.intersects(bj1.hitBox))
				bj1Contract = true;
			
		}
		for(BenzJewel bj2: panel.bj2) {
			if(hit.intersects(bj2.hitBox))
				bj2Contract = true;
		}
		for(BenzJewel bj3: panel.bj3) {
			if(hit.intersects(bj3.hitBox))
				bj3Contract = true;
		}
		for(BenzJewel bj4: panel.bj4) {
			if(hit.intersects(bj4.hitBox))
				bj4Contract = true;
		}
		for(BenzJewel bj5: panel.bj5) {
			if(hit.intersects(bj5.hitBox))
				bj5Contract = true;
		}
		if(bj1Contract == true) {
			panel.bj1.remove(0);
			collect++;
			bj1Contract = false;
		} else if(bj2Contract == true) {
			panel.bj2.remove(0);
			collect++;
			bj2Contract = false;
		} else if(bj3Contract == true) {
			panel.bj3.remove(0);
			collect++;
			bj3Contract = false;
		} else if(bj4Contract == true) {
			panel.bj4.remove(0);
			collect++;
			bj4Contract = false;
		} else if(bj5Contract == true) {
			panel.bj5.remove(0);
			collect++;
			bj5Contract = false;
		}
		// Device_1
		for (Button_1 b1_1: panel.b1_1) {
			for (Button_1 b1_2: panel.b1_2) {
				if(hit.intersects(b1_1.hitBox) || hit.intersects(b1_2.hitBox)) {
					benzD1();
				} else {
					leaveBenzD1();
				} 
			}
		}

		for(Device_1 d1: panel.d1) {
			if(hit.intersects(d1.hitBox)) {
				hit.y -= ySpeed;
				while(!d1.hitBox.intersects(hit)) {
					//keep moving until touches
					hit.y += Math.signum(ySpeed);
				}
				hit.y -= Math.signum(ySpeed);
				ySpeed = 0;
				y = hit.y;
			}
		}
		// Device_2
		for (Button_2 b2: panel.b2) {
			if (hit.intersects(b2.hitBox) ) {
				for (Device_2 d2: panel.d2) {
						if(d2.y < 490) {
							d2.y += 1;
							d2.hitBox.y+=1;
					}
				} 
			}
		}
	
		for(Device_2 d2: panel.d2) {
			if(hit.intersects(d2.hitBox)) {
				hit.x -= xSpeed;
				while(!d2.hitBox.intersects(hit)) {
					hit.x += Math.signum(xSpeed);
				}//keep moving until touches wall
				hit.x -= Math.signum(xSpeed);
				xSpeed = 0;
				this.x = hit.x;
			}
		}
		// Device_3
		for (Button_3 b3: panel.b3) {
			for (Device_3 d3: panel.d3) {
				if(hit.intersects(b3.hitBox) ) {
					benzD3();
				} else {
					leaveBenzD3();
				} 
			}
		}
		for(Device_3 d3: panel.d3) {
			if(hit.intersects(d3.hitBox)) {
				hit.y -= ySpeed;
				while(!d3.hitBox.intersects(hit)) {
					//keep moving until touches
					hit.y += Math.signum(ySpeed);
				}
				hit.y -= Math.signum(ySpeed);
				ySpeed = 0;
				y = hit.y;
			}
		}
		// Device_4
		for (Button_4 b4: panel.b4) {
			if (hit.intersects(b4.hitBox) ) {
				for (Device_4 d4: panel.d4) {
					if(d4.y > 70) {
						d4.y -= 1;
						d4.hitBox.y-=1;
					}
				} 
			}
		}

		for(Device_4 d4: panel.d4) {
			if(hit.intersects(d4.hitBox)) {
				hit.x -= xSpeed;
				while(!d4.hitBox.intersects(hit)) {
					hit.x += Math.signum(xSpeed);
				}//keep moving until touches wall
				hit.x -= Math.signum(xSpeed);
				xSpeed = 0;
				this.x = hit.x;
			}
		}
		// Device_5 
		for (Button_5 b5: panel.b5) {
			if (hit.intersects(b5.hitBox) ) {
				for (Device_5 d5: panel.d5) {
						if(d5.x > 720) {
							d5.x -= 1;
							d5.hitBox.x-=1;
					}
				} 
			}
		}
	
		for(Device_5 d5: panel.d5) {
			if(hit.intersects(d5.hitBox)) {
				hit.x -= xSpeed;
				while(!d5.hitBox.intersects(hit)) {
					hit.x += Math.signum(xSpeed);
				}//keep moving until touches wall
				hit.x -= Math.signum(xSpeed);
				xSpeed = 0;
				this.x = hit.x;
			}
		}
		// Device_6
		for (Button_6 b6: panel.b6) {
			if(hit.intersects(b6.hitBox)) {
				benzD6();
			} else {
				leaveBenzD6();
			} 
		}
		for(Device_6 d6: panel.d6) {
			if(hit.intersects(d6.hitBox)) {
				hit.y -= ySpeed;
				while(!d6.hitBox.intersects(hit)) {
					//keep moving until touches
					hit.y += Math.signum(ySpeed);
				}
				hit.y -= Math.signum(ySpeed);
				ySpeed = 0;
				y = hit.y;
			}
		}
		x += xSpeed;
		y += ySpeed;
		hit.x = x;
		hit.y = y;
		
		// Contract Door
		for(BenzDoor bd: panel.bd) {
			if(hit.intersects(bd.hitBox)&&collect==5) {
				bEnd();
				int j = judgeEnd();
				if(j > 0) {
					x = 80;
					y = 740;
				}
			}else {
				bNotEnd();
			}
		}

	}
}
