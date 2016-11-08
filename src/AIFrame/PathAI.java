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
	//It stores PathAIPair, which is a custom object that stores a
	//Coordinate and it's PathAIDirections ArrayList that can be used
	//eff. in the stack
	ArrayList<PathAIPair> intersectionStack = new ArrayList<PathAIPair>();
	
	
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
				
				//check to see if currPoint is anz	 intersection
				if(maze.isIntersection(currentPoint)) {
					intersectionStack.add(new PathAIPair(startingPoint, startingPoint.getIntersectionDirections()));
				}
			}
			
			print(intersectionStack.remove(intersectionStack.size()));
		
		}
		
		
	}
	
	
	
}
	