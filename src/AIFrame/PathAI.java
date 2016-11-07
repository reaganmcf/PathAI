package AIFrame;


public class PathAI{
	
	PathAIMaze maze;
	
	
	//Used to reference the current point in the maze, starting point
	//and the ending point
	PathAICoordinate startingPoint;
	PathAICoordinate currentPoint;
	PathAICoordinate endPoint;
	PathAICoordinate lastIntersection;
	
	//this is used to store all of the paths that the AI found. The fastest path will be the 
	//array of coordinates that is the smallest in size (the smallest moves made).
	PathAICoordinate[][] successfulPaths;
	
	
	public PathAI(PathAIMaze maze) {
		//set maze object here so we can reference it
		this.maze = maze;
		
		this.startingPoint = maze.startingPoint;
		
		//startAI();
	}
	
	private void startAI() {
		boolean isRunning = true;
		while(isRunning) {
			
			//if there is no current point to be on (meaning this is the first recursion) then set
			//the current point to the maze's starting position
			if(currentPoint == null) {
				currentPoint = startingPoint;
			}
			
			
			
		}
		
		
	}
	
	
	
}
	