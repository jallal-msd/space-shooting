import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class GameObjects {

	int posx, posy, x,y,speed;
	String name;
	static keyInput inputs;
	
	
	GameObjects(String name,int x,int y,keyInput inputs ){
	this.name = name;
	this.x = x;
	this.y = y ;
	this.inputs = inputs;
		
	}
	
	
	
	public GameObjects() {
		// TODO Auto-generated constructor stub
	}



	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void render(Graphics2D g ) {
		
	//	g.drawImage(ship.getImage(), x,y,50	,50,null);
		
	}
	
	public void tick() {
		
		
	}
	
	
	
	
	
}
