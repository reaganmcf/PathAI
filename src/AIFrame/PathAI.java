package AIFrame;

import java.util.ArrayList;

import com.reaganmcf.SwiftyJava.SwiftyJava;

public class PathAI extends SwiftyJava {
	
	public PathAIMaze maze;
	
	//Used to reference the current point in the maze, starting point
	//and the ending point
	PathAICoordinate startingPoint;
	PathAIPair currentPoint;
	PathAICoordinate endPoint;
	
	//this is used when solving the maze, the direction that the last coordinate
	//moved FROM to get to the current coordinate
	PathAIDirections lastMovementDirection;
	
	//this is used to store all of the paths that the AI found. The fastest path will be the 
	//array of coordinates that is the smallest in size (the smallest moves made).
	ArrayList<PathAISuccessfulPath> successfulPaths = new ArrayList<PathAISuccessfulPath>();
	
	//the way we keep track of the intersections run into by using a 
	//"Stack" method; First one it - last one out
	//It stores PathAIPair, which is a custom object that stores a
	//Coordinate and it's PathAIDirections ArrayList that can be used
	//eff. in the stack
	ArrayList<PathAIPair> intersectionStack = new ArrayList<PathAIPair>();
	
	//there is always atleast 1 point path that are the points startingPoint -> the first
	//intersection, so we set that here to reference when we call split() on the
	//intersections. Note : DOES NOT INCLUDE THE INTERSECTION PathAIPair
	ArrayList<PathAIPair> startPointToFirstIntersection = new ArrayList<PathAIPair>();
	
	public PathAI(PathAIMaze maze) {
		//set maze object here so we can reference it
		this.maze = maze;
		
		this.startingPoint = maze.startingPoint;
		this.endPoint = maze.endPoint;
		
		startAI();
		
		for(PathAISuccessfulPath path : successfulPaths) {
			frog(path.getPathAsString());
		}
	}
	
	private void startAI() {
	
		//if there is no currentPoint, then make the starting point the current point
		//and add it to the stack
		if(currentPoint == null) {
			currentPoint = new PathAIPair(startingPoint, startingPoint.getIntersectionDirections());
		}
		
		//currentPoint = new PathAIPair(this.maze.getCoordinateFromDirection(startingPoint, PathAIDirections.North),this.maze.getCoordinateFromDirection(startingPoint, PathAIDirections.North).getIntersectionDirections());
		//lastMovementDirection = PathAIDirections.North;
		
		boolean isRunning = true;
		while(isRunning) {
			
			if(currentPoint.getDirections().size() <= 2) {
			//if the point has only 1 other space to go, then it goes into this if
				
				if(currentPoint.getCoordinate() == startingPoint) {
					//if its the starting point, then lastMovementDirection = null, so we \
					//if else into 2 statements
					
					//do the same as what is in the else statement below, except do not remove 
					//anything from the coordinate's intersectionDirections ArrayList
					PathAIDirections[] temp1 = currentPoint.getDirectionsAsNonDynamicArray();
					PathAICoordinate temp = this.maze.getCoordinateFromDirection(currentPoint.getCoordinate(), temp1[0]);
					
					//since this only gets called once, add it to the startPointToFirstIntersection ArrayList
					startPointToFirstIntersection.add(currentPoint);
					
					//update currentPoint and update lastMovementDirection
					currentPoint = new PathAIPair(temp, temp.getIntersectionDirections());
					lastMovementDirection = temp1[0];
				}else if(currentPoint.getCoordinate() != endPoint) {
					//delete the lastMovementDirection from the PathAIPair's intersectionDirections
					//array list

					currentPoint.deleteDirection(this.getOppositeDirection(lastMovementDirection));
					//get the point to the only direction left in the currentPoint's
					//intersectionDirections ArrayList, and set that to current point
					
					//set temp variables so the code is way easier to read
					PathAIDirections[] temp1 = currentPoint.getDirectionsAsNonDynamicArray();
					PathAICoordinate temp = this.maze.getCoordinateFromDirection(currentPoint.getCoordinate(), temp1[0]);
					
					if(intersectionStack.size() == 0) {
						//if we have not reached an intersection, then the path from startingPoint
						//to the first intersection is still not finished, so add currentPoint to 
						//startPointToFirstIntersection array list
						startPointToFirstIntersection.add(currentPoint);
					}
					
					//update currentPoint
					currentPoint = new PathAIPair(temp, temp.getIntersectionDirections());
					
				}else{
					//if it gets here, then that means currPoint is the endPoint, which in that case stop
					//running the AI.
					String ident = "Path_" + successfulPaths.size() + 1;
					this.successfulPaths.add(new PathAISuccessfulPath(ident, startPointToFirstIntersection));
					isRunning = false;
				}
				
			}else if(maze.isIntersection(currentPoint.getCoordinate()) == true) {
				//read "split(PathAIPair pair)" for the comment explaining this
				
				//add currentPoint to the top of intersectionStack
				intersectionStack.add(currentPoint);
				
				isRunning = false;
			}
		}
	}
	
	public ArrayList<PathAIPair> split(PathAIPair pair) {
		//whenever we reach an intersection in the maze, we want to split a new track
		//for each intersection direction besides the one where it just came from
		
		
		return null;
	}
	
	//used to get the opposite of a direction passed in 
	public PathAIDirections getOppositeDirection(PathAIDirections dir) {
		switch(dir) {
		case North:
			return PathAIDirections.South;
		case South:
			return PathAIDirections.North;
		case East:
			return PathAIDirections.West;
		case West:
			return PathAIDirections.East;
		}
		
		//requires a return method even though the method will never reach here
		return PathAIDirections.North;
	}
	
	//helper method
	public PathAIPair getTopMostStackItem() {
		return this.intersectionStack.get(this.intersectionStack.size() - 1);
	}
	
	
	
}
	