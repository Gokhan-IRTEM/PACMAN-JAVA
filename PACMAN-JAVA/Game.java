
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Game extends JPanel implements ActionListener {


	  private Dimension dim;  // height and width 
      private final Font skoryazi = new Font("Arial", Font.BOLD,14); // oyundaki textlerin fontu
      public boolean isgamerunning = false; // oyunun runlayýp runlmaadaýðýný kontrol eder
      public int blockSize = 24; // blok büyüklüðü
      public int num_blocks = 18; // yükseklik veya geniþligin içericeði blok miktarý
      public int screenSize = blockSize * num_blocks;
      public int lives, score;
      public int candegeri;
      Level level;	
	  public boolean finished = false;      
      public int key_dx, key_dy; // TAdapter extends KeyAdapter{} cursor klavye kontrol etmek için	            
      public final int valid_speeds[] = {1,2,3,4,6}; // alýnabilen speed valueleri    
      public final int maxSpeed = 6; // maksimum speed
      public int currentSpeed = 3;
      public short[] screen_data;
      public Timer sayac;	            
      public  short level_data[];
      public Loadimg load = new Loadimg();
      public int numofdot;
      public int areaofmap = 18*18;
      Pacman pac = new Pacman(this);
      Ghost blue = new Ghost(this,"C:/Users/merta/Desktop/p_images/blue.gif");
      Ghost red = new Ghost(this,"C:/Users/merta/Desktop/p_images/red.gif");
      Ghost orange = new Ghost(this,"C:/Users/merta/Desktop/p_images/ghost.gif");
      Ghost purple = new Ghost(this,"C:/Users/merta/Desktop/p_images/purple.gif");
      ArrayList<Ghost> ghosts = new ArrayList<Ghost>();
      


      
      
      public int getBlockSize() {
		return blockSize;
	}
	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}
	public Game(String s) { // oyun zorlugu için parametre
		ghosts.add(blue);
		ghosts.add(red);
		ghosts.add(purple);
		ghosts.add(orange);
	
		
      	if(s.equalsIgnoreCase("easy")) {
      		level = new Level("easy");
      		this.level_data = level.difficulty;	            			
      	}	            		
      	else if(s.equalsIgnoreCase("medium")) {
      			level = new Level("medium");
      		this.level_data = level.difficulty;  			            		
      	}	
      	else if(s.equalsIgnoreCase("hard")) {
 			level = new Level("hard");
 		this.level_data = level.difficulty;  		
     	}
      	
      	
      	gameVariables();// variablelarý tanýmlar
      	addKeyListener(new Control(this)); // ok tuþlarýný kontrol etmek için controller
      	setFocusable(true);	            	
      	startGame(lives); // oyunu baþlatýr	            	
      }	            	       
		public void gameVariables() { // variablelarý tanýmlar
		 	screen_data = new short[18*18];
	       	dim =new Dimension(500,500);
	    	for(int s = 0; s<ghosts.size(); s++) {
	       	ghosts.get(s).ghost_x = 4;
	    	ghosts.get(s).ghost_y = 4;
	    	ghosts.get(s).ghost_dx = 5;
	    	ghosts.get(s).ghost_dy = 5;
	    	ghosts.get(s).dx = new int [4];
	    	ghosts.get(s).dy =  new int [4];
	    	}
      	sayac = new Timer(40,this); // FPS
      	sayac.start();	
      }
      
      private void playGame(Graphics2D graphics) {
      	if(pac.isdead) {
      		death();

      	}
      	else {
      		pac.movePacman();
      		pac.drawPacman(graphics);
      		for(int i = 0; i<ghosts.size();i++) {
      		ghosts.get(i).moveGhosts(graphics);
      		}
      		dotcheck();	         // beyaz noktalarýn bitip bitmediðini kontrol eder    		
      	}	            	
      }	            	            
      public void showIntroScreen(Graphics2D g) { // intro yazýmýz
      	String s = "Press 'SPACE' To start ";
      	g.setColor(Color.MAGENTA);
      	g.drawString(s, screenSize/3, 150);
      }	            
      public void drawScore(Graphics2D g) { // skor ve caný gösteriyo
      	g.setFont(skoryazi);
      	g.setColor(Color.cyan);
      	String skor = "Score:" + score;
      	g.drawString(skor, screenSize/2 + 96,screenSize+16 );
      	
      	for(int i = 0; i<lives;i++) {
      		g.drawImage(load.can, i*28+8, screenSize+1,this);
      	}	            		            	
      }
      
      public void checkmap() {  // kaç tane engel olduðunu bulur ve bunu mapin alanýndan çýkararak kaç tane BEYAZ NOKTA oldugunu bulur
      	int numofobs = 0;
      	for(int i = 0 ; i< 18*18;i++) {
      		int k = screen_data[i];	            		
      		if(k == 0) {
      			numofobs++;	            			
      		}	            		
      	}
      	numofdot = 18*18-numofobs;
      }
      public void dotcheck() {  // beyaz noktalarýn sayýsý skourumuza eþitse oyunu durdurur
      	
      	if(numofdot == score) {
      		isgamerunning = false;
      		finished = true;
      		
      		
      		
      	}
      }	
      public void showEndingScreen(Graphics2D g) { // oyun bitince cýkacak olan yazý
      	String f = "Congratulations you succesfully finished '" + level.levelname + "' level !";
      			
      	g.setFont(skoryazi);
      	g.setColor(Color.magenta);
      	g.drawString(f, screenSize/15 ,150 );
      	
      	String k = "Press 'SPACE' to play again! ";
      	g.setColor(Color.MAGENTA);
      	g.drawString(k, screenSize/3-20, 220);
      }
      private void death() {
      	this.lives--;
      	if(lives == 0) {
      		isgamerunning = false;	            			            			            		
      	}
      	nextLevel();
      }	            

      
     
      
      public void drawMap(Graphics2D g) {
      	short i = 0;
      	int x,y;
      	
      	for(y = 0 ; y< screenSize; y+= blockSize) {
      		for(x = 0; x<screenSize; x+= blockSize) {
      			
      			g.setColor(Color.blue.darker()); //  ENGELLERÝN RENGÝ
      			g.setStroke(new BasicStroke(5)); //
      			
      			if(level_data[i] == 0) {
      				g.fillRect(x, y, blockSize, blockSize);
      			}
      			if((screen_data[i] & 1) !=  0) {
      				g.drawLine(x, y, x, y+blockSize-1);
      			}
      			if((screen_data[i] & 2) !=  0) {
      				g.drawLine(x, y, x+blockSize-1, y);
      			}
      			if((screen_data[i] & 4) !=  0) {
      				g.drawLine(x+blockSize-1, y, x+blockSize-1, y+blockSize-1);
      			}
      			if((screen_data[i] & 8) !=  0) {
      				g.drawLine(x, y+ blockSize -1, x+blockSize-1, y+blockSize-1);
      			}
      			if((screen_data[i] & 16) !=  0) {
      				g.setColor(Color.WHITE); // yemlerin rengi
      				g.fillOval(x+10, y+10, 6, 6);
      			}
      			i++;
      		}
      		
      	}
      	
      }
  
   
   
      public void startGame(int canlar2) { // oyun baþlatýr
      	this.lives = canlar2;
      	this.candegeri = canlar2;
      	score = 0;
      	gameLevel();
      	checkmap();
      }
      private void gameLevel() { 
      	int i;
      	for(i = 0; i<num_blocks*num_blocks;i++) {
      		screen_data[i] = level_data[i];
      	}
      	nextLevel();
      }
      
      private void nextLevel() { 
      	int dx = 1;
      	int random;
      	for(int i = 0; i< this.ghosts.size();i++) {
      		ghosts.get(i).ghost_y = 4 * blockSize; //  Ghostlarýn baþlangýç yeri
      		ghosts.get(i).ghost_x = 8 * blockSize;
      		ghosts.get(i).ghost_dy = 0;
      		ghosts.get(i).ghost_dx = dx;
      		dx = -dx;
      		
      		random =  (int)(Math.random()*(currentSpeed+1));
      		if(random > currentSpeed) {
      			random = currentSpeed;
      		}
      		ghosts.get(i).setGhost_speed(valid_speeds[random]);
      		
      		
      	}
      	pac.pacman_x = 11* blockSize; // PACMANÝN BAÞLANGIC YERÝ
      	pac.pacman_y = 8*blockSize;
      	pac.pacman_dx = 0;  // move direction resetliyor
      	pac.pacman_dy = 0;
      	key_dx = 0;		// kontrolleri resetliyor
      	key_dy = 0;
      	pac.isdead = false;
      }
      
      
      
      public void paintComponent(Graphics g) {
      	super.paintComponent(g);
      	
      	
      	Graphics2D graphics = (Graphics2D) g;
      	graphics.setColor(Color.black); // BACKGROUND COLOR
      	graphics.fillRect(0,0, dim.width,dim.height);
      	
      	drawMap(graphics);
      	drawScore(graphics);
      	
      	if(isgamerunning) {
      		playGame(graphics);
      	}
      	else if(!isgamerunning && finished) {
      		showEndingScreen(graphics);
      		Toolkit.getDefaultToolkit().sync();
          	graphics.dispose();
      	}
      	else {
      	
      		showIntroScreen(graphics);
      	}
      	Toolkit.getDefaultToolkit().sync();
      	graphics.dispose();
      }
      
      // buradan sonrasý getter setter...
      
      
      public int getScreenSize() {
			return screenSize;
		}


		public int getKey_dx() {
			return key_dx;
		}
		public void setKey_dx(int key_dx) {
			this.key_dx = key_dx;
		}
		public int getKey_dy() {
			return key_dy;
		}
		public void setKey_dy(int key_dy) {
			this.key_dy = key_dy;
		}
		public void setScreenSize(int screenSize) {
			this.screenSize = screenSize;
		}


		public short[] getScreen_data() {
			return screen_data;
		}


		public void setScreen_data(short[] screen_data) {
			this.screen_data = screen_data;
		}


		public boolean isIsgamerunning() {
			return isgamerunning;
		}

		public void setIsgamerunning(boolean isgamerunning) {
			this.isgamerunning = isgamerunning;
		}

		

		public int getLives() {
			return lives;
		}

		public void setLives(int lives) {
			this.lives = lives;
		}

	

		public int getCurrentSpeed() {
			return currentSpeed;
		}

		public void setCurrentSpeed(int currentSpeed) {
			this.currentSpeed = currentSpeed;
		}

		

		public short[] getLevel_data() {
			return level_data;
		}
	     public Dimension getDim() {
				return dim;
			}


			public void setDim(Dimension dim) {
				this.dim = dim;
			}


		

		
      public void actionPerformed(ActionEvent e) {
                  repaint();
      		}
}
