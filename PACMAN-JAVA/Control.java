
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Control extends KeyAdapter {
	Game x;
    public  Control(Game g) {
    	this.x  = g;
    } 
public void keyPressed(KeyEvent e) {
	
				int key = e.getKeyCode();	 
        		   		
        		if(x.isgamerunning) {
        			if(key == KeyEvent.VK_LEFT) {
        				x.key_dx = -1;
        				x.key_dy = 0;
        			}
        			else if(key == KeyEvent.VK_UP) {
        				x.key_dx = 0;
        				x.key_dy = -1;
        			}
        			else if(key == KeyEvent.VK_DOWN) {
        				x.key_dx = 0;
        				x.key_dy = 1;
        			}
        			else if(key == KeyEvent.VK_RIGHT) {
        				x.key_dx = 1;
        				x.key_dy = 0;
        			}	            		
        			else if(key == KeyEvent.VK_SPACE && x.sayac.isRunning()) { // space'ye basýlýrsa oyun yeniden baþlatýr
        				x.setIsgamerunning(false);            					            					            					            				            				
        			}
        		}
        			else {
        				if(key == KeyEvent.VK_SPACE) {
        					x.isgamerunning = true;
        					x.startGame(x.candegeri);
        				}
        			}	            		
        		
				}

    


}