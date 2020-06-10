import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class ship extends GameObjects {
	
	
	
	
//	ImageIcon ship = new ImageIcon("C:\\Users\\jalla\\Downloads\\ship.png");
	ImageIcon ship = new ImageIcon(".//Resources//ship.png");
	
	static keyInput inputs;
	int x , y ;
	Game game ;
	Controller c ;
	boolean Destroyed = false;
	

	ship(String name, int x, int y, Game game,Controller c ) {
		super(name, x, y,inputs);
		this.x = x;
		this.y=y;
		this.game = game;
		this.c = c ;
		
		//this.inputs = inputs;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		this.x = x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		this.y = y;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		super.render(g);
		g.drawImage(ship.getImage(), x,y,50	,50,null);
		
		
		if(Destroyed) {
			
		//	LinkedList<Rocks> ro = c.getrRocks();
			
		//	for(int i = 0 ; i<ro.size();i++) {
				
			//	Rocks rock = ro.get(i);
			//	rock.setY(0);
			//	}
			
			g.setColor(Color.WHITE);
			g.drawString("GameOver press R to restart", 200, 200);
		}
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		super.tick(); 
		
		if(x > game.WIDTH * game.SCALE -10) {
			
			this.x = game.WIDTH * game.SCALE -10;
		}
			if(this.x <= 0 +5) {
			
			this.x = 5;
		}
		
		//x = x+1;
			 Destroyed = false;
		if(Physics.collisionShip(this, game.rs)) {
			
		 Destroyed = true;
	}
		
		
	}
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,32 , 32);
	}

}
