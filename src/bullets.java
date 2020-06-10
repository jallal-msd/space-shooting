import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class bullets  extends GameObjects{
	
	
	private int x ,y ;
	ImageIcon bullet = new ImageIcon(".//Resources//bullet.png");
	Game game ;
	Controller c ;

	bullets(String name, int x, int y, Game game,Controller c ) {
		super(name, x, y, inputs);
		this.x = x ;
		this.y = y;
		this.game = game;
		this.c= c;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		this.x =x; 
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		this.y=y;
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
		g.drawImage(bullet.getImage(), x,y,10,10,null);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		y -=5;
		
		if(Physics.collision(this, game.rs)) {
		//	c.removebullet(this);
			//System.out.println("Collision ");
			
		}
		if(y <= 0 ) {
			c.removebullet(this);
			
		}
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,32 , 32);
	}

}
