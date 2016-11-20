package com.Main;

import java.io.IOException;
import com.reaganmcf.SwiftyJava.*;
import AIFrame.*;
import ImageReaderAI.ImageReaderAI;

public class Main extends SwiftyJava{
	
	
	public static void main(String[] args) throws IOException{
		Main m = new Main();
		m.go();
	}
	
	public void go() throws IOException {
		ImageReaderAI imgReader = new ImageReaderAI();
		PathAIMaze maze = PathAIMaze.getInstance( );
		maze.setMaze(testMaze());
		PathAI pathAI = new PathAI(maze);
		
		
		//frog(pathAI.startingPoint.isIntersection(pathAIMaze.startingPoint));
		//System.out.println(pathAIMaze.startingPoint.getIntersectionDirections());
		
		//print(pathAIMaze.getCoordinateFromDirection(pathAIMaze.startingPoint, PathAIDirections.West).getMazeValue());
		
		
	}
	
	public int[][] testMaze() {
		int[][] arr = {
			{3,1,1,1,1,0},
			{1,0,1,0,1,0},
			{1,1,1,1,1,0},
			{0,0,1,0,1,0},
			{0,0,1,1,1,0},
			{0,0,0,1,2,0}
		};
		
		//refer to ColorToIntValKey.txt to see which int values represent
		//which type of value
		
		return arr;
	}
	
}
