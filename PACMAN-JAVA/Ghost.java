import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Ghost {

    public int[] dx, dy; // ghostlarýn pozisyonlarý data changeleri galiba ?? 
    public int ghost_x,ghost_y,ghost_dx,ghost_dy  ; // determines num and position of ghosts
    public int ghost_speed;
    public Game l;
    public Image color;
    
	
	public Ghost(Game temp,String colorpath) {
		this.l = temp;
		this.color = new ImageIcon(colorpath).getImage();
	}
	
	
	  public void moveGhosts(Graphics g) {
	      	int p;
	      	int c;
	      
	      		if(ghost_x % l.blockSize == 0 && ghost_y % l.blockSize == 0) { // ghostun blok baþýna hareket etmesini saðlar, 1 blokta bir kez saða sola yukarý aþaðý gidebiliyor.
	      			p = this.ghost_x / l.blockSize + l.num_blocks * (this.ghost_y / l.blockSize); 			// 1 sol kenar, 2 üst kenar, 4 sað kenar, 8 alt kenar
	      			c = 0; // x ghostun duvara çarpma sayýsý
	      			
	      			
	      			if((l.screen_data[p] & 1) == 0 && this.ghost_dx != 1) { // sol kenara çarptýysa saða dönsün
	      				dx[c] = -1;
	      				dy[c] = 0;
	      				c++;
	      			}
	      			if((l.screen_data[p] & 2) ==0 && this.ghost_dy != 1) { // üst kenara çarptýysa aþaðý dönsün
	      				dx[c] = 0;
	      				dy[c] = -1;
	      				c++;
	      			}
	      			if((l.screen_data[p] & 4) ==0 && this.ghost_dx != -1) { // sað kenarsa sola dönsün
	      				dx[c] = 1;
	      				dy[c] = 0;
	      				c++;
	      			}
	      			if((l.screen_data[p] & 8) ==0 && this.ghost_dy != -1) { // alt kenarsa yukarý dönsün
	      				dx[c] = 0;
	      				dy[c] = 1;
	      				c++;
	      			}
	      			
	      			
	      			if(c == 0) { 			
	      					this.ghost_dx = -this.ghost_dx;
	      					 this.ghost_dy = -this.ghost_dy;	
	      			}
	      			else {
	      				c = (int) (Math.random()*c);
	      				if(c > 3) {
	      					c = 3;
	      				}
	      				this.ghost_dx = dx[c];
	      				this.ghost_dy = dy[c];

	      			}
	      		}
	      		this.ghost_x = this.ghost_x + (this.ghost_dx * this.ghost_speed); // ghost hareketi x ekseni
	      		this.ghost_y = this.ghost_y + (this.ghost_dy * this.ghost_speed); // ghost hareketi y ekseni
	      		drawGhost(g, this.ghost_x , this.ghost_y);
	      		if(l.pac.pacman_x > (this.ghost_x - 12) && (l.pac.pacman_x < this.ghost_x+12)
	      			&& l.pac.pacman_y > (this.ghost_y-12) && l.pac.pacman_y < (this.ghost_y+12)
	      			&& l.isgamerunning) {
	      			l.pac.isdead = true;
	      				
	      			
	      		}

	      		
	      	
	      	
	      }
  


	public double getGhost_speed() {
		return ghost_speed;
	}


	public void setGhost_speed(int ghost_speed) {
		this.ghost_speed = ghost_speed;
	}


	public void drawGhost(Graphics g, int x,int y) {
      	g.drawImage(this.color, x, y, l);
      	
      }


}
