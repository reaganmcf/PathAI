package AIFrame;


public class PathAICoordinate { 
	
	private int latitude = 0;
	private int longitude = 0;
	private PathAIMazeValue mazeValue;
	
	public PathAICoordinate(int latitude, int longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	//getters and setters
	public int getLat() {
		return this.latitude;
	}
	
	public int getLong() {
		return this.longitude;
	}
	
	public PathAIMazeValue getMazeValue() {
		return this.mazeValue;
	}
	
	public void setMazeValue(PathAIMazeValue mazeVal) {
		this.mazeValue = mazeVal;
	}
}
