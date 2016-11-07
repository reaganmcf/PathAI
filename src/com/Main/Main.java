package com.Main;

import java.io.IOException;
import com.reaganmcf.SwiftyJava.*;
import AIFrame.*;

public class Main extends SwiftyJava{
	
	public static void main(String[] args) throws IOException{
		Main m = new Main();
		m.go();
	}
	
	public void go() throws IOException {
		//ImageReaderAI imgReader = new ImageReaderAI();
		PathAIMaze pathAIMaze = new PathAIMaze(testMaze());
		PathAI pathAI = new PathAI(pathAIMaze);

		
		//frog(pathAIMaze.isIntersection(pathAIMaze.startingPoint));
		//System.out.println(pathAIMaze.startingPoint.getIntersectionDirections());
		
		print(pathAIMaze.getCoordinateFromDirection(pathAIMaze.startingPoint, PathAIDirections.West).getMazeValue());
		
	}
	
	public int[][] testMaze() {
		int[][] arr = {
			{0,3,0,0,0},
			{0,1,1,1,0},
			{0,0,0,1,0},
			{0,0,0,1,0},
			{0,0,1,2,0}
		};
		
		//refer to ColorToIntValKey.txt to see which int values represent
		//which type of value
		
		return arr;
	}
	
}
