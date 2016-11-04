package AIFrame;

import java.awt.Image;

public class PathAIMaze {
	
	int mazeHeight = 0;
	int mazeWidth = 0;
	
	PathAICoordinate[][] mazeCoordinates;
	
	PathAICoordinate startingPoint;
	PathAICoordinate endPoint;
	
	//Data Type to store the maze
	public PathAIMaze(Image img) {
		
	}
		
	public PathAIMaze(int[][] arr) {
		
		mazeCoordinates = new PathAICoordinate[arr[0].length][arr[0].length];
		mazeHeight = arr[0].length;
		mazeWidth = mazeHeight;
		
		for(int i = 0; i < arr[0].length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				mazeCoordinates[i][j] = new PathAICoordinate(i,j);
				
				switch(arr[i][j]) {
				case 0:
					//this means that the current point being scanned is a "wall" area that
					//cannot be moved to from the PathAI
					mazeCoordinates[i][j].setMazeValue(0);
					break;
				case 1:
					//this means that the current point being scanned is an point that can be 
					//moved to throughout the maze, a point in a maze path
					mazeCoordinates[i][j].setMazeValue(1);
					break;
				case 2:
					//means the current point being scanned is the starting point
					//since it is announced with value "2" representing the start
					//position
					mazeCoordinates[i][j].setMazeValue(2);
					startingPoint = mazeCoordinates[i][j];
					break;
				case 3:
					//means the current point being scanned is the ending point
					//since it is announced with a value "3" representing the end
					//position
					mazeCoordinates[i][j].setMazeValue(3);
					endPoint = mazeCoordinates[i][j];
				}
				
			}
		}
	}
	
	
	public boolean isIntersection(PathAICoordinate currCoord) {
		
		//set the coord's lat and long to local variables so its easier to read
		//and understand this code
		int coordLat = currCoord.getLat();
		int coordLong = currCoord.getLong();
		
		//0 X 0
		//X C X
		//0 X 0
		//our current position is 'C', and we are trying to see if there are atleast 2 'X' points
		//next to it. If there are, return true; else, return false
		for(int i = 0; i < 4; i++) {
			
			switch(i) {
			case 0:
				//North 'X'
				//check if 'X' even exists, if it does then it gets in the if
				//statement
		
				if(coordLat + 1 <= mazeHeight) {
		
				}
				
				break;
			case 1:
				//West 'X'
				
				
				//check if 'X' even exists, if it does then it gets in the if 
				//statement
				if(coordLong - 1 <= mazeWidth) {
					
				}
				break;
			case 2:
				//East 'X'
				
				//check if 'X' even exists, if it does then it gets in the if 
				//statement
				if(coordLong + 1 <= mazeWidth) {
					
				}
				
				break;
			case 3:
				//South 'X'
				
				//check if 'X' even exists, if it does then it gets in the if 
				//statement
				if(coordLat - 1 <= mazeHeight) {
					
				}
				
				break;
			}
			
		}
		
		return false;
	}
	
	
	//getters and setters
	
	public int getMazeLength() {
		return this.mazeHeight;
	}
	
	public int getMazeWidth() {
		return this.mazeWidth;
	}
	
	
}
