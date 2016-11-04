package ImageReaderAI;

import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
//This is a comment

public class ImageReaderAI {
		static byte[] pixels;
		static BufferedImage image;
		
	public ImageReaderAI() throws IOException{	
		//Get image
		File file= new File("maze.jpg");
		BufferedImage image = ImageIO.read(file);

		//Loops through each pixel in image
		System.out.println(image.getHeight());
		int width = image.getWidth();
		int height = image.getHeight();
		
		for(int x=0; x==width; x++){
			for(int y=0; y==height; y++){
				System.out.println(x + ", " + y);
				System.out.println(image.getRGB(x, y));
			}
		}
		System.out.println("end");
	}

    public void getRGB(int x, int y)
    {
    	  // Getting pixel color by position x and y 
    	  int clr=  image.getRGB(x,y); 
    	  int  red   = (clr & 0x00ff0000) >> 16;
    	  int  green = (clr & 0x0000ff00) >> 8;
    	  int  blue  =  clr & 0x000000ff;
    	  System.out.println("Red Color value = "+ red);
    	  System.out.println("Green Color value = "+ green);
    	  System.out.println("Blue Color value = "+ blue);
    	  
    }
}
