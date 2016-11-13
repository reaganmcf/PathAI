package AIFrame;

import java.util.ArrayList;
import com.reaganmcf.SwiftyJava.*;

public class PathAISplit extends SwiftyJava{
	
	//pair is the PathAIPair from where we are splitting FROM, and dir is the Direction in which we 
	//are splitting FROM
	
	
	//instance of maze for split method
	private PathAIMaze maze = PathAIMaze.getInstance();
	
	//used during the split method
	private PathAIPair currPoint;
	private ArrayList<PathAIPair> currPath = new ArrayList<PathAIPair>();
	private PathAIDirections lastDir;
	private boolean didReachEnd = false;
	
	
	//this is what is returned, as there can be more than 1 path
	//if this instance of PathAISplit calls more PathAISplit
	private ArrayList<ArrayList<PathAIPair>> allSuccessfulPaths = new ArrayList<ArrayList<PathAIPair>>();
	
	public PathAISplit(PathAIPair pair, PathAIDirections movementDir, PathAICoordinate endPoint) {
		
		
		currPoint = pair;
		lastDir = movementDir;
		
		
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
				didReachEnd = false;
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
		}else{
			//if we did reach the end, that add the path to the allSuccessfulPaths array
			allSuccessfulPaths.add(currPath);
		}
	}
	
	//getters and setters
	
	public ArrayList<ArrayList<PathAIPair>> getAllSuccessfulPaths() {
		return this.allSuccessfulPaths;
	}
	
	//helper methods
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
}