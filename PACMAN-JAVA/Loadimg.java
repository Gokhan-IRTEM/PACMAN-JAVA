import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Loadimg {
  	Image down;
	Image up;
	Image left;
	Image right;
    Image can;
	

    public Loadimg() {
    	// resimleri yüklemek için pathleri girin...
      	down = new ImageIcon("C:/Users/merta/Desktop/p_images/down.gif").getImage();
    	up = new ImageIcon("C:/Users/merta/Desktop/p_images/up.gif").getImage();
        left = new ImageIcon("C:/Users/merta/Desktop/p_images/left.gif").getImage();
    	right = new ImageIcon("C:/Users/merta/Desktop/p_images/right.gif").getImage();
        can = new ImageIcon("C:/Users/merta/Desktop/p_images/heart.png").getImage(); 
    	
    }
    

    
}
