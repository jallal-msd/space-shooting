import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Random;

public class Controller {
	
	LinkedList<bullets> Bullets = new LinkedList<bullets>();
	LinkedList<Rocks> rocks = new LinkedList<Rocks>();
	
	
	bullets tempBullet;
	Rocks tempRock;


		Game game;
		Random r = new Random();
		
		
		Controller(Game game){
			
			this.game=game;
			
			
			//addRock(new Rocks("rock",50,20,this,game));
			//addRock(new Rocks("rock",20,20,this,game));
			//addRock(new Rocks("rock2",400,20,this,game));
			
			
		
		}
	
		
		public void addEnemies(int enemy_count) {
			
			for(int i =0 ; i<=enemy_count; i++) {
				
				addRock(new Rocks("rock3",r.nextInt(640),20,this,game));
			}
			
			
		}
	public void render(Graphics2D g) {
		for(int i =0 ; i<Bullets.size();i++) {
			tempBullet = Bullets.get(i);
			
			tempBullet.render(g);
			
			
		}
		for(int i =0 ; i<rocks.size();i++) {
			tempRock =rocks.get(i);
			
			tempRock.render(g);
			
			
		}
		
		
	}
	public void tick() {
		
		for(int i =0 ; i<Bullets.size();i++) {
			tempBullet = Bullets.get(i);
			
			tempBullet.tick();
			
	}
		for(int i =0 ; i<rocks.size();i++) {
			tempRock =rocks.get(i);
			
			tempRock.tick();
		
		
	}
		
		
	}
	
	
	public void addBullet(bullets b) {
		Bullets.add(b);
		
	}
	public void removebullet(bullets b) 
	{
		Bullets.remove(b);
	
	}
	
	public void addRock(Rocks b) {
		rocks.add(b);
		
	}
	public void removeRock(Rocks b) 
	{
		rocks.remove(b);
	
	}
	
	
	public LinkedList<bullets> getBullets(){
		return Bullets;
		
		
	}
	public LinkedList<Rocks> getrRocks(){
		return rocks;
		
		
	}
}
