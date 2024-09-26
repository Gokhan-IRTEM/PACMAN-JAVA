
public class Level {

	public short[] difficulty;
	public String levelname;
	public Level(String s) {
		if(s.equalsIgnoreCase("easy")) {
			this.levelname = "EASY";
			this.difficulty = new short[]{
			   	
				19,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,22,
			   	17,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,20,
				17,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,20,
				17,16,16,16,24,24,24,24,16,16,24,24,24,24,16,16,16,20,
				17,16,16,20, 0, 0, 0, 0,17,20, 0, 0, 0, 0,17,16,16,20,
				17,16,16,20, 0,19,18,18,16,16,18,18,22, 0,17,16,16,20,
				17,16,16,20, 0,17,16,16,16,16,16,16,20, 0,17,16,16,20,
				17,16,16,20, 0,17,16,16,16,16,16,16,20, 0,17,16,16,20,
				17,16,16,16,18,16,16,16,16,16,16,16,16,18,16,16,16,20,
				17,16,16,16,24,16,16,16,16,16,16,16,16,24,16,16,16,20,
				17,16,16,20, 0,17,16,16,16,16,16,16,20, 0,17,16,16,20,
				17,16,16,20, 0,17,16,16,16,16,16,16,20, 0,17,16,16,20,
				17,16,16,20, 0,25,24,24,16,16,24,24,28, 0,17,16,16,20,
				17,16,16,20, 0, 0, 0, 0,17,20, 0, 0, 0, 0,17,16,16,20,
				17,16,16,16,18,18,18,18,16,16,18,18,18,18,16,16,16,20,
				17,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,20,
				17,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,20,
				25,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,24,28


			  	            			};
	
							}
		else if(s.equalsIgnoreCase("medium")) {
			this.levelname = "MEDIUM";
			this.difficulty = new short[] 	{
            	    19,18,18,18,18,18,18,22, 0, 0,19,18,18,18,18,18,18,22,
            	    17,16,24,24,24,24,16,20, 0, 0,17,16,24,24,24,24,16,20,
            	    17,20, 0, 0, 0, 0,17,20, 0, 0,17,20, 0, 0, 0, 0,17,20,
            	    17,20, 0, 0, 0, 0,17,20, 0, 0,17,20, 0, 0, 0, 0,17,20,
            	    17,20, 0, 0,19,18,16,16,18,18,16,16,18,22, 0, 0,17,20,
            	    17,20, 0, 0,17,16,24,24,24,24,24,24,16,20, 0, 0,17,20, // 104
            	    17,20, 0, 0,17,20, 0, 0, 0, 0, 0, 0,17,20, 0, 0,17,20,
            	    17,20, 0, 0,17,20, 0, 0, 0, 0, 0, 0,17,20, 0, 0,17,20,
            	    17,16,18,18,16,16,18,18,18,18,18,18,16,16,18,18,16,20,
            	    17,16,24,24,16,16,24,24,24,24,24,24,16,16,24,24,16,20,
            	    17,20, 0, 0,17,20, 0, 0, 0, 0, 0, 0,17,20, 0, 0,17,20,
            	    17,20, 0, 0,17,20, 0, 0, 0, 0, 0, 0,17,20, 0, 0,17,20,
            	    17,20, 0, 0,17,16,18,18,18,18,18,18,16,20, 0, 0,17,20,
            	    17,20, 0, 0,25,24,16,16,24,24,16,16,24,28, 0, 0,17,20,
            	    17,20, 0, 0, 0, 0,17,20, 0, 0,17,20, 0, 0 ,0, 0,17,20,
            	    17,20, 0, 0, 0, 0,17,20, 0, 0,17,20, 0, 0 ,0, 0,17,20,
            	    17,16,18,18,18,18,16,20, 0, 0,17,16,18,18,18,18,16,20,
            	    25,24,24,24,24,24,24,28, 0, 0,25,24,24,24,24,24,24,28


            	};
					
			
		}
		else if(s.equalsIgnoreCase("hard")) {// hard map
			this.difficulty = new short[] 	{
					19,26,26,26,26,18,26,26,26,26,26,26,26,18,26,26,26,22,
					21,0 , 0, 0, 0,21 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,21 ,0,0, 0, 21,
				   	21,0,19,18,18,16,18,18,18,18,18,18,18,16,18,22, 0, 21,
					21,0,17,16,24,24,24,24,16,16,24,24,24,24,16,20, 0, 21,
					21,0,17,20, 0, 0, 0, 0,17,20, 0, 0, 0, 0,17,20, 0, 21,
					21,0,17,20, 0,19,26,18,16,16,18,26,22, 0,17,20, 0, 21,
					21,0,17,20, 0,21,0 ,17,24,24,20,0 ,21, 0,17,20, 0, 21,
					21,0,17,20, 0,17,18,28,0, 0, 25,18,20, 0,17,16, 26, 20,
					17,26,16,16,18,16,20,0,0, 0, 0,17,20,  0,17,20, 0, 21,
					21,0,17,16,24,16,20,0 ,0, 0, 0,17, 16,26,16,20, 0, 21,
					21,0,17,20, 0,17,24,22,0, 0, 19,24,20, 0,17,20, 0, 21,
					21,0,17,20, 0,21,0 ,17,18,18,20,0 ,21, 0,17,20, 0, 21,
					21,0,17,20, 0,25,26,24,16,16,24,26,28, 0,17,20, 0, 21,
					17,26,16,20, 0, 0, 0, 0,17,20, 0, 0, 0, 0,17,20, 0, 21,
					21,0,17,16,18,18,18,18,16,16,18,18,18,18,16,20, 0, 21,
					21,0,25,24,24,16,24,24,24,24,24,24,24,24, 16,28, 0, 21,
					21,0 ,0 ,0 ,0 ,21 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0,21 ,0 ,0, 21,
					25,26,26,26,26,24,26,26,26,26,26,26,26,26,24,26,26,28

            	};		
		
	}
	}

	/*
 	0 = blue block				4 = right border				FOR EXAMPLE for 19 in the level_data it is the left top block so,
 	1 = left border				8 = bottom border				it(19) is equal to 
 	2 = top border				16 = white dots					1(left border) + 2(top border) + 16(white dot) = 19							
 */
}
