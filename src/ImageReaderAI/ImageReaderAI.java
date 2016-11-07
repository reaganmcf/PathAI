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
		System.out.println(image.getHeight());
		System.out.println(image.getWidth());
		int width = image.getWidth();
		int height = image.getHeight();
		
		mazeValue = new int[width][height];
		
		for(int x=0; x<width; x++){
			for(int y=0; y<height; y++){
				getRedGreenBlue(x, y, width, height);
			}
		}
		
		for(int x=0; x<width; x++){
			for(int y=0; x==height; y+=height){
				if(mazeValue[x][y] == 1){
					if(hasStart == false){
						hasStart = true;
						mazeValue[x][y] = 2;
					}else{
						mazeValue[x][y] = 3;
					}
				}
			}
		}
		
		for(int y=0; y<width; y++){
			for(int x=0; x==width; x+=width){
				if(mazeValue[x][y] == 1){
					if(hasStart == false){
						hasStart = true;
						mazeValue[x][y] = 2;
					}else{
						mazeValue[x][y] = 3;
					}
				}
			}
		}
		
		for(int x=0; x<width; x++){
			for(int y=0; y<height; y++){
				System.out.print(mazeValue[x][y]);
			}
			print("");
		}
		
	}

    public void getRedGreenBlue(int x, int y, int width, int height)
    {
    	  // Getting pixel color by position x and y 
    	Color color = new Color(image.getRGB(x,y), true); 
    	  int  red   = color.getRed();
    	  int  green = color.getGreen();
    	  int  blue  =  color.getBlue();
    	  if(red  > 240 && blue > 240 && green > 240){
    		  mazeValue[x][y] = 1;
    	  } else{
    		  mazeValue[x][y] = 0;
    	  }
    	  
    		  
    }
}