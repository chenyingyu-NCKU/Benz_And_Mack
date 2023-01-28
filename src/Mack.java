import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Mack extends Material{
	
	private boolean mj1Contract = false;
	private boolean mj2Contract = false;
	private boolean mj3Contract = false;
	private boolean mj4Contract = false;
	private boolean mj5Contract = false;
	private int collect = 0;
	public Mack() {
		this.image = new ImageIcon("src/Sources/Mack.png").getImage();
		this.width = 30;
		this.height = 30;
		this.x = 30;
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
		if(xSpeed>3)xSpeed = 3;
		if(xSpeed<-3)xSpeed = -3;
		
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
				this.x = hit.x;
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
				x = 35;
				y = 740;
			}
		}
		//black water
		for(BlackWater black: panel.bw) {
			if(hit.intersects(black.hitBox)) {
				x = 35;
				y = 740;
			}
		}
		//jewel
		for(MackJewel mj1: panel.mj1) {
			if(hit.intersects(mj1.hitBox))
				mj1Contract = true;
		}
		for(MackJewel mj2: panel.mj2) {
			if(hit.intersects(mj2.hitBox))
				mj2Contract = true;
		}
		for(MackJewel mj3: panel.mj3) {
			if(hit.intersects(mj3.hitBox))
				mj3Contract = true;
		}
		for(MackJewel mj4: panel.mj4) {
			if(hit.intersects(mj4.hitBox))
				mj4Contract = true;
		}
		for(MackJewel mj5: panel.mj5) {
			if(hit.intersects(mj5.hitBox))
				mj5Contract = true;
		}
		if(mj1Contract == true) {
			panel.mj1.remove(0);
			collect++;
			mj1Contract = false;
		} else if(mj2Contract == true) {
			panel.mj2.remove(0);
			collect++;
			mj2Contract = false;
		} else if(mj3Contract == true) {
			panel.mj3.remove(0);
			collect++;
			mj3Contract = false;
		} else if(mj4Contract == true) {
			panel.mj4.remove(0);
			collect++;
			mj4Contract = false;
		} else if(mj5Contract == true) {
			panel.mj5.remove(0);
			collect++;
			mj5Contract = false;
		}
		// Device_1
		for (Button_1 b1_1: panel.b1_1) {
			for (Button_1 b1_2: panel.b1_2 ) {
				for (Device_1 d1: panel.d1) {
					if(hit.intersects(b1_1.hitBox) || hit.intersects(b1_2.hitBox)) {
						mackD1();
					} else {
						leaveMackD1();
					} 
					if (mackDevice1 == true || benzDevice1 == true) {
						if( d1.y < 710) {
							d1.y += 1;
							d1.hitBox.y+=1;
						}
					} else {
						if( d1.y > 550) {
							d1.y -= 1;
							d1.hitBox.y-=1;
						}
					}
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
				if(hit.intersects(b3.hitBox)) {
					mackD3();
				} else {
					leaveMackD3();
				} 
				if (mackDevice3 == true || benzDevice3 == true) {
					if( d3.y < 280) {
						d3.y += 1;
						d3.hitBox.y+=1;
					}
				} else {
					if( d3.y > 150) {
						d3.y -= 1;
						d3.hitBox.y-=1;
					}
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
			for (Device_6 d6: panel.d6) {
				if(hit.intersects(b6.hitBox)) {
					mackD6();
				} else {
					leaveMackD6();
				} 
				if (mackDevice6 == true || benzDevice6 == true) {
					if( d6.y > 240) {
						d6.y -= 1;
						d6.hitBox.y-=1;
					}
				} else {
					if( d6.y < 490) {
						d6.y += 1;
						d6.hitBox.y+=1;
					}
				}
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
		for(MackDoor md: panel.md) {
			if(hit.intersects(md.hitBox)&&collect==5) {
				mEnd();
				int j = judgeEnd();
				if(j > 0) {
					x = 40;
					y = 740;
				}
			}else {
				mNotEnd();
			}
		}

	}
}
