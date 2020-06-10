import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class keyInput extends KeyAdapter {
	
	Game game ;
	
	
	keyInput(Game game){
		
	//	game.addKeyListener(this);
	
		this.game= game;
		
		
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	
		//game.keyPressed(e);
		//if(e.getKeyCode() == KeyEvent.VK_A) {
			
			//System.out.println("workin");
		//}
		game.keyPressed(e);
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		game.keyReleased(e);
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	



}
