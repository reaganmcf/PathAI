package AIFrame;


public class PathAI {
	
	PathAIMaze maze;
	
	//Used to reference the current point in the maze, starting point
	//and the ending point
	PathAICoordinate startingPoint;
	PathAICoordinate currentPoint;
	PathAICoordinate endPoint;
	PathAICoordinate lastIntersection;
	
	PathAICoordinate[] fastestPath;
	
	public PathAI(PathAIMaze maze) {
		//set maze object here so we can reference it
		this.maze = maze;
		
		this.startingPoint = maze.startingPoint;
		
		startAI();
	}
	
	private void startAI() {
		
		
	}
	
	
	
}
	