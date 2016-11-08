package ImageReaderAI;

import java.awt.Color;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import com.reaganmcf.SwiftyJava.*;
//This is a comment

public class ImageReaderAI extends SwiftyJava{
	static BufferedImage image;
	int mazeValue[][];
	boolean hasStart = false;
		
	public ImageReaderAI() throws IOException{	
		//Get image
		File file= new File("maze.jpg");
		image = ImageIO.read(file);

		//Loops through each pixel in image
		int side = image.getHeight();
		
		mazeValue = new int[side][side];
		
		for(int x=0; x<side; x++){
			for(int y=0; y<side; y++){
				getRedGreenBlue(x, y, side);
			}
		}
		//finding the beginning and end of the maze
		for(int x=0; x<side; x++){
			for(int y=0; y<side; y++){
				if(mazeValue[x][y]==1){
					if((x == 0) || (y == 0) || (x == side-1) || (y == side-1)){
						if(hasStart == false){
							hasStart = true;
							mazeValue[x][y] = 2;
						}else{
							mazeValue[x][y] = 3;
						}	
					}
				}
			}
		}
		//mazeValue int is the multidimensional array
	}

    public void getRedGreenBlue(int x, int y, int side)
    {
    	  // Getting pixel color by position x and y 
    	Color color = new Color(image.getRGB(x,y), true); 
    	  int  red   = color.getRed();
    	  int  green = color.getGreen();
    	  int  blue  =  color.getBlue();
    	  //This works for some reason
    	  if(red  > 240 && blue > 240 && green > 240){
    		  mazeValue[y][x] = 1;
    	  } else{
    		  mazeValue[y][x] = 0;
    	  }
    	  
    		  
    }
}