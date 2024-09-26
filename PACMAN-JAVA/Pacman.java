import java.awt.Graphics2D;

public class Pacman  {
   
	public int speed_pacman;
    public boolean isdead; // is pacman died ? 
    public int pacman_x, pacman_y, pacman_dx, pacman_dy;
    public Game gm;
    public Pacman(Game temp) {
    	this.gm = temp;
    	this.speed_pacman = 4;
    	this.isdead = false;
    }

	
	
	
	
	
	 void movePacman() {
      	int position;
      	short ch;
      	if(pacman_x%gm.blockSize == 0 && pacman_y % gm.blockSize == 0) {  // pacman bir kare üzerindeyse
      		position = pacman_x/gm.blockSize + gm.num_blocks * (int) (pacman_y/ gm.blockSize);
      		ch = gm.screen_data[position]; // screendeki yeri sayýsal veri olarak 16 23 24 gibi
      		if((ch & 16) != 0) { // beyaz noktanýn yenme durumunda beyaz noktanýn silinmesi
      			gm.screen_data[position] = (short)(ch&15);
      			gm.score++;
      		}
      		if(gm.key_dx != 0 || gm.key_dy != 0) {
      			if(!((gm.key_dx == -1 && gm.key_dy == 0 &&(ch & 1)!= 0) 
      				|| (gm.key_dx == 1 && gm.key_dy == 0 &&(ch & 4) != 0)
      				||(gm.key_dx == 0 && gm.key_dy == -1 && (ch & 2) != 0)
      				||(gm.key_dx == 0 && gm.key_dy == 1 && (ch & 8) != 0))) {
      				pacman_dx = gm.key_dx;
      				pacman_dy = gm.key_dy;
      			}
      		}
      		
      		if	((pacman_dx == -1 && pacman_dy == 0 && (ch & 1) != 0) 
      			||(pacman_dx == 1 && pacman_dy == 0 && (ch & 4) != 0)
					||(pacman_dx == 0 && pacman_dy == -1 && (ch & 2) != 0)
					||(pacman_dx == 0 && pacman_dy == 1 && (ch & 8) != 0)){
      			pacman_dx = 0;
      			pacman_dy = 0;
      			            			            			
      		}
      	} 
      	pacman_x = pacman_x + speed_pacman * pacman_dx;
      	pacman_y = pacman_y + speed_pacman * pacman_dy;

      	
      }
	 public void drawPacman(Graphics2D graphics) {
	      	if(gm.key_dx == -1) {
	      		graphics.drawImage(gm.load.left, pacman_x,pacman_y,gm);
	      	}
	      	else if(gm.key_dx == 1) {
	      		graphics.drawImage(gm.load.right, pacman_x,pacman_y,gm);
	      	}
	      	else if(gm.key_dy == -1) {
	      		graphics.drawImage(gm.load.up, pacman_x,pacman_y,gm);
	      	}
	      	else{
	      		graphics.drawImage(gm.load.down, pacman_x,pacman_y,gm);
	      	}
	      }
	
	
	
	
	
	
	
	
	
	
}
