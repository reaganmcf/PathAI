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
			frog(path.getIdentifier() + "| " +path.getPathAsString());
		}
		
	}
	
	private void startAI() {
	
		//if there is no currentPoint, then make the starting point the current point
		//and add it to the stack
		if(currentPoint == null) {
			currentPoint = new PathAIPair(startingPoint, startingPoint.getIntersectionDirections());
		}
		
		
		boolean isRunning = true;
		while(isRunning) {
			
			if(currentPoint.getDirections().size() <= 2) {
			//if the point has only 1 other space to go, then it goes into this if
				
				if(currentPoint.getCoordinate() != endPoint) {
					
					//make sure to delete the direction that we just came from
					if(currentPoint.getCoordinate() != startingPoint && currentPoint.getCoordinate() != endPoint) {
						currentPoint.deleteDirection(this.getOppositeDirection(lastMovementDirection));
					}
					
					//make temp variables so the code is easier to read
					PathAIDirections[] temp1 = currentPoint.getDirectionsAsNonDynamicArray();
					PathAICoordinate temp = this.maze.getCoordinateFromDirection(currentPoint.getCoordinate(), temp1[0]);
					
					//if it is startingPoint or we have not reached an intersection yet, we want to set
					//t he lastMovementDirection
					if(currentPoint.getCoordinate() == startingPoint || intersectionStack.size() == 0) {
						lastMovementDirection = temp1[0];
						startPointToFirstIntersection.add(currentPoint);
					}
					
					//update currentPoint
					currentPoint = new PathAIPair(temp, temp.getIntersectionDirections());
					
				}else{
					
					//if it gets here, then that means currPoint is the endPoint, which in that case stop
					//running the AI, create a new PathAISuccessfulPath and add endPoint to it (since the ArrayList
					//does not include the endPoint
					
					startPointToFirstIntersection.add(new PathAIPair(endPoint, endPoint.getIntersectionDirections()));
					String ident = "Path_" + (successfulPaths.size() + 1);
					this.successfulPaths.add(new PathAISuccessfulPath(ident, startPointToFirstIntersection));
					isRunning = false;
				}
				
			}else if(currentPoint.getDirections().size() >= 3) {
				//if the currentPoint is an intersection
				
				//add currentPoint to the top of intersectionStack
				intersectionStack.add(currentPoint);
				
				//make sure to delete the opposite of lastMovement fromcurrentPoint's 
				//directions ArrayList
				currentPoint.deleteDirection(this.getOppositeDirection(lastMovementDirection));
				
				//split for each direction
				for(PathAIDirections dir :	currentPoint.getDirectionsAsNonDynamicArray()) {
					//temp to make code readable
					
					print("Dir passed in : " + dir.toString());
					
					PathAICoordinate temp = this.maze.getCoordinateFromDirection(currentPoint.getCoordinate(), dir);
					ArrayList<PathAIPair> currSplitInstance = split(new PathAIPair(temp, temp.getIntersectionDirections()), dir);
					
					printArrayList(currSplitInstance);
					print("---------");
					
					//if the instance reached the end of the maze, create a new PathAISuccessfulPath, and 
					//add it to the successfulPaths ArrayList
					if(currSplitInstance.get(currSplitInstance.size() - 1).getCoordinate() == endPoint) {
						ArrayList<PathAIPair> tempSuccessPath = new ArrayList<PathAIPair>();
						tempSuccessPath.addAll(startPointToFirstIntersection);
						tempSuccessPath.add(currentPoint);
						tempSuccessPath.addAll(currSplitInstance);
						
						this.successfulPaths.add(new PathAISuccessfulPath("Path_" + (successfulPaths.size() + 1), tempSuccessPath));
					}
				}
				isRunning = false;
			}
		}
	}
	
	public ArrayList<PathAIPair> split(PathAIPair pair, PathAIDirections movementDir) {
		//whenever we reach an intersection in the maze, we want to split a new track
		//for each intersection direction besides the one where it just came from
		
		//we create new variables for currPoint, startingPathToFirstIntersection, and lastMovement
		//Direction because we don't want to mess with the other ones
		PathAIPair currPoint = pair;
		ArrayList<PathAIPair> currPath = new ArrayList<PathAIPair>();
		PathAIDirections lastDir = movementDir;
		
		//used to check if it reached the endPoint
		boolean didReachEnd = false;
		
		while(currPoint.getDirections().size() <= 2) {
			if(currPoint.getCoordinate() != endPoint && currPoint.getDirections().size() > 1) {
				//make sure to delete the direction that we just came from
				
				currPoint.deleteDirection(this.getOppositeDirection(lastDir));
				
				//make temp variables so the code is easier to read
				PathAIDirections[] temp1 = currPoint.getDirectionsAsNonDynamicArray();
				PathAICoordinate temp = this.maze.getCoordinateFromDirection(currPoint.getCoordinate(), temp1[0]);
				
				print("currently moving to :" + lastDir.toString());
				//update lastDir, and add currPoint to currPath;
				lastDir = temp1[0];
				currPath.add(currPoint);
				
				//update currentPoint
				currPoint = new PathAIPair(temp, temp.getIntersectionDirections());
			
			}else if(currPoint.getCoordinate() != endPoint) {
				//it  reaches here if it is a dead end point
				break;
			}else if(currPoint.getCoordinate() == endPoint){
				//if it gets here, then that means that currPoint is endPoint, so we want to
				//add endPoint to the array and break 
				currPath.add(new PathAIPair(endPoint, endPoint.getIntersectionDirections()));
				didReachEnd = true;
				break;
			}
		}
		
		//currPoint = currPath.get(currPath.size() - 1);
		if(!didReachEnd) {
			print(currPoint.getCoordinate().getLat() + "," + currPoint.getCoordinate().getLong());
			//check to see if the reason it didn't end is because it hit another intersection
			if(currPoint.getDirections().size() > 2) {
				print("reached an intersection");
			}else{
				print("reached dead end");
			}
			
		}
		//we return the arraylist here, it will contain endPoint if it reached there
		return currPath;
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
	
	public void printArrayList(ArrayList<PathAIPair> arr) {
		String temp = "";
		for(int i = 0; i < arr.size(); i++) {
			temp += "(" + arr.get(i).getCoordinate().getLat() + "," + arr.get(i).getCoordinate().getLong() + ")";
		}
		
		print(temp);
	}
	
}
	