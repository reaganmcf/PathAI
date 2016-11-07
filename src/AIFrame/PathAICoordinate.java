package AIFrame;

import java.util.ArrayList;

public class PathAICoordinate { 
	
	//latitude is for y 
	//longitude is for x
	private int latitude = 0;
	private int longitude = 0;
	
	private PathAIMazeValue mazeValue;
	
	//this is used to store the direction of the open spaces are in relation to the current
	//coordinate if it happens to be an intersection
	private ArrayList<PathAIDirections> intersectionsDirections = new ArrayList<PathAIDirections>();
	
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
	
	//used only if the coordinate is an intersection
	public ArrayList getIntersectionDirections() {
		return this.intersectionsDirections;
	}
	
	public void addIntersectionDirection(PathAIDirections dir) {
		this.intersectionsDirections.add(dir);
	}
}
