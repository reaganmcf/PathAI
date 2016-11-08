package AIFrame;

import java.util.ArrayList;

public class PathAIPair {
	
	private PathAICoordinate coordinate;
	private ArrayList<PathAIDirections> dirs;
	
	public PathAIPair(PathAICoordinate coord, ArrayList dirs) {
	
		this.coordinate = coord;
		this.dirs = dirs;
	
	}
	
	public void deleteDirection(PathAIDirections dir) {
		dirs.remove(dir);
	}
	
	public ArrayList getDirections() {
		return this.dirs;
	}
	
	public PathAICoordinate getCoordinate() {
		return this.coordinate;
	}
	
}
