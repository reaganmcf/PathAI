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
		
		PathAIPair test = new PathAIPair(startingPoint, startingPoint.getIntersectionDirections());
		cycle(test.getDirections().get(1));
		
		//startAI();
	}
	
	private void startAI() {
	
		if(currentPoint == null) {
			currentPoint = startingPoint;
		}
		
		boolean isRunning = true;
		while(isRunning) {
			//add the current point to the stack
			intersectionStack.add(new PathAIPair(currentPoint, currentPoint.getIntersectionDirections()));
			
			if(this.maze.isIntersection(getTopMostStackItem().getCoordinate()) == true || this.currentPoint == this.startingPoint) {
				for(int i = 0; i < getTopMostStackItem().getDirections().size() - 1; i++) {
					this.cycle(this.getTopMostStackItem().getDirections().get(i));
				}
			}
		}
		

	}
	
	public void cycle(Object obj) {
		if(obj == PathAIDirections.North) {
			frog("isNorth");
		}else if(obj == PathAIDirections.East) {
			frog("isEast");
		}else if(obj == PathAIDirections.South) {
			frog("isSouth");
		}else if(obj == PathAIDirections.West) {
			frog("isWest");
		}
		
	}
	
	//helper method
	public PathAIPair getTopMostStackItem() {
		return this.intersectionStack.get(this.intersectionStack.size() - 1);
	}
	
	
	
}
	