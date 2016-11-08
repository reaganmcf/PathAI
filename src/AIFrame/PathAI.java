package AIFrame;

import java.util.ArrayList;

import com.reaganmcf.SwiftyJava.SwiftyJava;

public class PathAI extends SwiftyJava {
	
	public PathAIMaze maze;
	
	//Used to reference the current point in the maze, starting point
	//and the ending point
	PathAICoordinate startingPoint;
	PathAICoordinate currentPoint;
	PathAICoordinate endPoint;
	
	//this is used to store all of the paths that the AI found. The fastest path will be the 
	//array of coordinates that is the smallest in size (the smallest moves made).
	PathAICoordinate[][] successfulPaths;
	
	//the way we keep track of the intersections run into by using a 
	//"Stack" method; First one it - last one out
	ArrayList<PathAICoordinate> intersectionStack = new ArrayList<PathAICoordinate>();
	
	
	public PathAI(PathAIMaze maze) {
		//set maze object here so we can reference it
		this.maze = maze;
		
		this.startingPoint = maze.startingPoint;
		this.endPoint = maze.endPoint;
		
		startAI();
	}
	
	private void startAI() {
	
		while(currentPoint == null && intersectionStack.size() > 0) {
			
			//if there is no current point (meaning also
			//if this is the first recursion of the array) then
			//set the current point to starting point
			if(currentPoint == null) {
				currentPoint = startingPoint;
				
				//check to see if currPoint is an intersection
				if(maze.isIntersection(currentPoint)) {
					intersectionStack.add(currentPoint);
				}
			}
			
			
		
		}
		
		
	}
	
	
	
}
	