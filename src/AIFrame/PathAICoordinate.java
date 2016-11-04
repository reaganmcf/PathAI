package AIFrame;


public class PathAICoordinate { 
	
	private int latitude = 0;
	private int longitude = 0;
	private int mazeValue = 0;
	
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
	
	public int getMazeValue() {
		return this.mazeValue;
	}
	
	public void setMazeValue(int mazeVal) {
		this.mazeValue = mazeVal;
	}
}
