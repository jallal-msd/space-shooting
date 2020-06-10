import java.util.LinkedList;

public class Physics {
	
	
	public static boolean collision(bullets bl , LinkedList<Rocks> ro) {
		
		
		
		for(int i = 0 ; i<ro.size();i++) {
			
			if(bl.getBounds().intersects(ro.get(i).getBounds())) {
				
				return true;
			}
			
		}
		
		
		return false;
		
	
	}
	
	
public static boolean collisionShip(ship Ship , LinkedList<Rocks> ro) {
		
		
		
		for(int i = 0 ; i<ro.size();i++) {
			
			if(Ship.getBounds().intersects(ro.get(i).getBounds())) {
				
				return true;
			}
			
		}
		
		
		return false;
		
	
	}
	
	
public static boolean collisionb(Rocks ro , LinkedList<bullets> bl) {
		
		
		
		for(int i = 0 ; i<bl.size();i++) {
			
			if(ro.getBounds().intersects(bl.get(i).getBounds())) {
				
				return true;
			}
			
		}
		
		
		return false;
		
	
	}

}
