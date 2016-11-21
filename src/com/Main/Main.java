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
		PathAIMaze maze = PathAIMaze.getInstance( );
		maze.setMaze(new ImageReaderAI().getMazeArray());
		PathAI pathAI = new PathAI(maze);
		print("PathAI solved the maze in " + pathAI.getSolvingTime());
		
	}
	
	public int[][] testMaze() {
		int[][] arr = {
			{0,0,0,2,0,0,0,0,0},
			{0,0,0,1,0,0,0,1,0},
			{0,1,0,1,1,1,0,1,0},
			{0,1,0,1,0,1,0,1,0},
			{1,1,1,1,0,1,1,1,0},
			{1,0,0,1,1,0,1,0,0},
			{1,1,0,1,0,1,1,1,0},
			{0,1,1,1,1,1,0,1,0},
			{1,1,0,0,0,0,0,3,0}
		};
		
		//refer to ColorToIntValKey.txt to see which int values represent
		//which type of value
		
		return arr;
	}
	
}
