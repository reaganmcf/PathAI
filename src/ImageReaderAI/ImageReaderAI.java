package ImageReaderAI;

import java.awt.Color;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
//This is a comment

public class ImageReaderAI {
	static BufferedImage image;
		
	public ImageReaderAI() throws IOException{	
		//Get image
		File file= new File("maze.jpg");
		image = ImageIO.read(file);

		//Loops through each pixel in image
		System.out.println(image.getHeight());
		System.out.println(image.getWidth());
		int width = image.getWidth();
		int height = image.getHeight();
		
		for(int x=0; x<width; x++){
			for(int y=0; y<height; y++){
				System.out.println(x + ", " + y);
				getRedGreenBlue(x, y);
			}
		}
		System.out.println("end");
	}

    public void getRedGreenBlue(int x, int y)
    {
    	  // Getting pixel color by position x and y 
    	Color color = new Color(image.getRGB(x,y), true); 
    	  int  red   = color.getRed();
    	  int  green = color.getGreen();
    	  int  blue  =  color.getBlue();
    	  System.out.println("Red Color value = "+ red);
    	  System.out.println("Green Color value = "+ green);
    	  System.out.println("Blue Color value = "+ blue);
    }
}