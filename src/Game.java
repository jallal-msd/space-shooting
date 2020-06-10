import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Game extends JPanel implements Runnable{

	
	public static final int WIDTH = 200;
	public static final int HEIGHT = 150;
	public static final int SCALE =3;
	public static final String NAME ="Space War";
	
	
	private JFrame frame;
	boolean running = false;
	
	
	BufferedImage image = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
	ImageIcon ship = new ImageIcon("C:\\Users\\jalla\\Downloads\\ship.png") ;
	
	
	//health bar
	int health = 200;
	
	




	GameObjects p,r ,b;
	Controller c ;
	
	keyInput input ;
	int x = 0 ;
	int  y = 0 ;
	
	//keep track of rocks
	int enemy = 1;
	int enemy_killed = 0 ;
	
	//LinkedList
	LinkedList<bullets> bls ;
	LinkedList<Rocks> rs ;
	
	
	Game(){
		setMinimumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		setMaximumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		
		frame = new JFrame(NAME);
		
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(new BorderLayout());
	    frame.add(this,BorderLayout.CENTER);
	    frame.pack();
	    
	    
	    frame.setFocusable(true);
	    frame.requestFocus();
	    frame.setResizable(false);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	
	
	
	}
	public synchronized void start() {
		running = true;
		 new Thread(this).start();;
		
		
	}
	public synchronized void stop() {
	running = false;
	
	
	
	}
	
	public void init() {
		

			
		p = new ship("MainPlayer", 250,400,this,c);
		
		c = new Controller(this);
		c.addEnemies(enemy);
		
		
		bls = c.getBullets();
		rs = c.getrRocks();
	
	}
	
	
	
	
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		frame.addKeyListener(new keyInput(this)) ;
		
		
		
		long lastLoopTime = System.nanoTime();
		final int Targetfps= 60;
		// 1sec = 1*9 nanosec
		final long optimalTime = 1000000000   / Targetfps ;
		
		int frames = 0 ;
		int ticks = 0 ;
		
		long lastTimer = System.currentTimeMillis();
		double delta = 0 ;
		
		init();
		while (running) {
			
			long now = System.nanoTime();
			long period = now-lastLoopTime;
			lastLoopTime = now;
			 delta += period / (double)optimalTime;
			
			
			//update fps and ticks
			while (delta >= 1) {
				ticks++;
				tick();
				delta -= 1 ;
			}
			frames ++ ; 
			render();
		while(System.currentTimeMillis() - lastTimer >=1000 )	{
			
			lastTimer += 1000;
			System.out.println(frames +" .."+ ticks);
			frames = 0 ; 
			ticks = 0 ;
			
		}
		
		}
	}

	
		void render() {
			
		
			
			
		
			BufferStrategy bs = frame.getBufferStrategy();
			if(bs == null) {
				
				frame.createBufferStrategy(3);
				return;
			}
			
			Graphics g = bs.getDrawGraphics();
			Graphics g2 = bs.getDrawGraphics();		
			Graphics g3 = bs.getDrawGraphics();
			
			
			
			
			g.setColor(Color.black);
			g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
			
			//health bar
		  // g.setColor(Color.gray);
			//g.fillRect(5, 5, 200, 20);
			
			//g.setColor(Color.green);
		//	g.drawRect(5, 5, health, 20);
			
			//g.setColor(Color.white);
			//g.fillRect(0, 0, 202, 21);
			
			
			
			
			
			///
			
			
			p.render((Graphics2D) g2);
		
			
			
			c.render((Graphics2D)g2);
			
			
			g.dispose();
			g2.dispose();
			g3.dispose();
			
			bs.show();
		
	}
		private void tick() {
		
			
			p.tick();
			c.tick();	
			
			
			if(enemy_killed >= enemy) {
				
				enemy +=1;
				enemy_killed = 0 ;
				c.addEnemies(enemy);
			}
			
			
				
			
		
	}
		
		
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int key = e.getKeyCode();
			
		
		
			if(key == KeyEvent.VK_RIGHT) {
				
				
				p.setX(p.getX()+ 10);
				
			}
         
            if(key == KeyEvent.VK_LEFT) {
	
            	
            	p.setX(p.getX()- 10);
	
                            }
            
            	if(key == KeyEvent.VK_SPACE) {
	
            	
            	c.addBullet(new bullets("redbullet",p.getX()+20,p.getY(),this,c));
	
                            }
            	
            	
            	//to restart the game when u lose
            	if(key == KeyEvent.VK_R) {
            		
            		
            			
            			System.out.println("ok");
            		
            		
            	}
		}


		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
		
		public int getEnemy() {
			return enemy;
		}
		public void setEnemy(int enemy) {
			this.enemy = enemy;
		}
		public int getEnemy_killed() {
			return enemy_killed;
		}
		public void setEnemy_killed(int enemy_killed) {
			this.enemy_killed = enemy_killed;
		}
		
		
		
		public static void main(String[] args) {
		new Game().start();
		}
}
