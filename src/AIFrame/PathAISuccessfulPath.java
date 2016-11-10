package AIFrame;

import java.util.ArrayList;

public class PathAISuccessfulPath {

	String identifier;
	ArrayList<PathAIPair> path = new ArrayList<PathAIPair>();
	
	public PathAISuccessfulPath(String identifier, ArrayList<PathAIPair> path) {
		this.identifier = identifier;
		this.path = path;
	}
	
	//getters
	public String getIdentifier() {
		return this.identifier;
	}
	
	public ArrayList<PathAIPair> getPath() {
		return this.path;
	}
	
	public String getPathAsString() {
		String temp = "";
		for(PathAIPair pair : path) {
			if(temp.length() == 0) {
				temp += pair.getCoordinate().getLat() + "," + pair.getCoordinate().getLong();
			}else{
				temp += " -> " + pair.getCoordinate().getLat() + "," + pair.getCoordinate().getLong();
			}
		}
		return temp;
	}
}
