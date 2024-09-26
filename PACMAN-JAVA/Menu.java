

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Menu extends JFrame implements ActionListener {

	Game g;

	JFrame f=new JFrame("Pacman");  
	JButton easy=new JButton("E A S Y");
	JButton medium = new JButton("M E D I U M");
	JButton hard = new JButton("H A R D");
	JButton exit = new JButton("E X I T");


	
	

	public static void main(String[] args) {  
		
	    Menu x = new Menu();		
		
		Music musicObject = new Music();
		musicObject.playMusic("C:\\Users\\merta\\Desktop\\music.wav");
	
		
	  
	    
	    
	}  

	public Menu()  {
		this.easy.setBounds(230,150,350,50);  
		this.medium.setBounds(230,225, 350, 50);
		this.hard.setBounds(230, 300, 350, 50);
		this.exit.setBounds(230, 450, 350, 50);
		this.easy.setBackground(Color.cyan);
		this.easy.setForeground(Color.yellow.darker());
		this.exit.setBackground(Color.darkGray);
		this.exit.setForeground(Color.white.darker());
		exit.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		easy.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		this.medium.setBackground(Color.pink);
		this.medium.setForeground(Color.yellow.darker());
		medium.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		this.hard.setBackground(Color.RED);
		this.hard.setForeground(Color.yellow.darker());
		hard.setFont(new Font("Times New Roman", Font.PLAIN, 40));
	    this.f.add(medium);
	    this.f.add(easy);  
	    this.f.add(hard);
	    this.f.add(exit);
	    this.easy.addActionListener(this);
	    this.medium.addActionListener(this);
	    this.hard.addActionListener(this);
	    this.exit.addActionListener(this);
	    this.f.setSize(800,800);  
	    this.f.setLayout(null);  
	    JLabel background=new JLabel(new ImageIcon("C:\\Users\\merta\\Desktop\\p_images\\Pbg.png"));
	    background.setSize(800,800);
	    background.setVisible(true);
	    background.setLayout(new FlowLayout());
	    this.f.getContentPane().add(background);
	    this.f.setVisible(true);
	    this.f.setLocationRelativeTo(null);
	    this.f.setResizable(false);
	    this.f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	   

	    
	    

	   
	    
	    	
	    



	}

	public void actionPerformed(ActionEvent e){  
			
		 
			if(e.getSource() == easy) {
				g = new Game("easy");
				g.startGame(4);
				Driver pac = new Driver(g);
				
				
				pac.setVisible(true);
				
				pac.setTitle("Pacman");
				pac.setSize(448,500);
				pac.setResizable(false);
				pac.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				pac.setLocationRelativeTo(null);
				
				
			}
			else if (e.getSource() == medium) {
				g = new Game("medium");
				g.startGame(3); // ilk parametre can ikinci parametre ghostsayisi
				Driver pac = new Driver(g);	
				pac.setVisible(true);
				pac.setTitle("Pacman");
				pac.setSize(448,500);
				pac.setResizable(false);
				pac.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
				pac.setLocationRelativeTo(null);
			}
			else if (e.getSource() == hard) {
				g = new Game("hard");
				g.startGame(2);			
				Driver pac = new Driver(g);	
				pac.setVisible(true);
				pac.setTitle("Pacman");
				pac.setSize(448,500);
				pac.setResizable(false);
				pac.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
				pac.setLocationRelativeTo(null);
				
				
			
			}
			else if (e.getSource() == exit) {
				System.exit(0);
			
			
			}
			
			
	}


	
	
}
