import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Rocks extends GameObjects{
	
	
	
	public  int x ;
	public  int y;
	
	Random r = new Random();
	
	
	
	
	Game game ;
	Controller c ;
	//Random r = new Random();
	
	
	ImageIcon rock = new ImageIcon(".//Resources//rocks.png");

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		this.x=x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		this.y= y ;
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
		
		
		
		g.drawImage(rock.getImage(),x, y, 32, 32, null );
		
	
		}
	

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
		y += 1;
		if(y > game.HEIGHT * game.SCALE) {
			 
			y =-10;
			x = r.nextInt(640);
		}
		

			for(int i = 0  ; i< game.bls.size(); i++) {
				
				bullets tempBullet = game.bls.get(i);
				if(Physics.collisionb(this, game.bls)) {
					c.removebullet(tempBullet);
					c.removeRock(this);
					
					
					game.setEnemy_killed(game.getEnemy_killed()+1);
				;
					
				}
			}
			
			
			
		}
	

	Rocks(String name, int x , int y, Controller c , Game game) {
	
		super(name, x, y, inputs);
		
		this.x =  x;
		this.y = y ;
		
		this.game = game ;
		this.c = c ;
		
		
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,32 , 32);
	}

}
