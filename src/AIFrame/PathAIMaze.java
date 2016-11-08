package AIFrame;

import java.awt.Image;

public class PathAIMaze {
	
	int mazeHeight = 0;
	int mazeWidth = 0;
	
	PathAICoordinate[][] mazeCoordinates;
	
	public PathAICoordinate startingPoint;
	public PathAICoordinate endPoint;
	
	//Data Type to store the maze
	public PathAIMaze(Image img) {
		
	}
		
	public PathAIMaze(int[][] arr) {
		
		//check to make sure 'arr' is square by dimensions
		for(int k = 0; k < arr.length; k++) {
			if(arr[k].length != arr.length) {
				//this means that at least one of the rows in the array is not the same
				//length as the width of the array; meaning the array is not square
				throw new RuntimeException("[PathAI] - Maze | ArrayNotSquareInSize - The array that was passed in to make a PathAIMaze object is not square in dimensions");
			}
		}
		
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
					mazeCoordinates[i][j].setMazeValue(PathAIMazeValue.Wall);
					break;
				case 1:
					//this means that the current point being scanned is an point that can be 
					//moved to throughout the maze, a point in a maze path
					mazeCoordinates[i][j].setMazeValue(PathAIMazeValue.Walkable);
					break;
				case 2:
					//means the current point being scanned is the starting point
					//since it is announced with value "2" representing the start
					//position
					mazeCoordinates[i][j].setMazeValue(PathAIMazeValue.StartingPosition);
					startingPoint = mazeCoordinates[i][j];
					break;
				case 3:
					//means the current point being scanned is the ending point
					//since it is announced with a value "3" representing the end
					//position
					mazeCoordinates[i][j].setMazeValue(PathAIMazeValue.EndingPosition);
					endPoint = mazeCoordinates[i][j];
				}
				
			}
		}
		
		//it needs to loop through all of the coordinates again
		//AFTER all of the coordinates have been placed inside the array
		//to check if they are a valid intersection and add the valid 
		//intersection directions to their corresponding arrays
		for(int k = 0; k < arr[0].length; k++) {
			for(int l = 0; l < arr[0].length; l++) {
				//run this here since isIntersection sets the coordinates
				//intersection directions and 
				this.isIntersection(mazeCoordinates[k][l]);
			}
		}
	}
	
	
	public PathAICoordinate getCoordinateFromDirection(PathAICoordinate currCoord, PathAIDirections dir) {
		
		switch(dir) {
		case North:
			return mazeCoordinates[currCoord.getLat() - 1][currCoord.getLong()];
		case South:
			return mazeCoordinates[currCoord.getLat() + 1][currCoord.getLong()];
		case West:
			return mazeCoordinates[currCoord.getLat()][currCoord.getLong() - 1];
		case East:
			return mazeCoordinates[currCoord.getLat()][currCoord.getLong() + 1];
		default:
			//this has to be hear because java will show an error saying that there is no return statment
			return null;
		}
		
		
	}
	
	public boolean isIntersection(PathAICoordinate currCoord) {
		
		//set the coord's lat and long to local variables so its easier to read
		//and understand this code
		int coordLat = currCoord.getLat();
		int coordLong = currCoord.getLong();
		
		int totalOpenSpacesNear = 0;
		//0 X 0
		//X C X		
		//0 X 0
		//our current position is 'C', and we are trying to see if there are atleast 2 'X' points
		//next to it. If there are, return true; else, return false
		for(int i = 0; i < 4; i++) {
			switch(i) {
			case 0:
				//North 'X'
				//check if 'X' even exists. Notice how we add +1 to coordLat instead of -1, this is because
				//of how arrays are formatted. the further DOWN you go in an array, the larger the number
				//instead of traditional x-y graphs that show the further DOWn you go, the SMALLER the number
				
				//For any statements that we add the second if statement onto, this is beacuse
				//we want to avoid ArrayIndexOutOfBounds error
				if(coordLat - 1 <= mazeHeight - 1 && coordLat - 1 >= 0) {
					if(mazeCoordinates[coordLat - 1][coordLong].getMazeValue() != PathAIMazeValue.Wall) {
						//if the mazeValue of the current PathAICoordinate is not .Wall
						//then register it as an open space AND add the direction of the open space in relation
						//of the coordinate original coordinate. 
						mazeCoordinates[coordLat][coordLong].addIntersectionDirection(PathAIDirections.North);
						totalOpenSpacesNear++;
					}
				}
				break;
			case 1:
				//West 'X'
				//check if 'X' even exists, if it does then it gets in the if statement
				
				//For any statements that we add the second if statement onto, this is because
				//we want to avoid ArrayIndexOutOfBounds error
				if(coordLong - 1 <= mazeWidth - 1 && coordLong - 1 >= 0) {
					if(mazeCoordinates[coordLat][coordLong - 1].getMazeValue() != PathAIMazeValue.Wall) {
						//if the mazeValue of the current PathAICoordinate is not .Wall
						//then register it as an open space AND add the direction of the open space in relation
						//of the coordinate original coordinate. 
						
						mazeCoordinates[coordLat][coordLong].addIntersectionDirection(PathAIDirections.West);
						totalOpenSpacesNear++;
					}
				}
				break;
			case 2:
				//East 'X'
				//check if 'X' even exists, if it does then it gets in the if 
				//statement
				if(coordLong + 1 <= mazeWidth - 1) {
					if(mazeCoordinates[coordLat][coordLong + 1].getMazeValue() != PathAIMazeValue.Wall) {
						//if the mazeValue of the current PathAICoordinate is not .Wall
						//then register it as an open space AND add the direction of the open space in relation
						//of the coordinate original coordinate. 

						mazeCoordinates[coordLat][coordLong].addIntersectionDirection(PathAIDirections.East);
						totalOpenSpacesNear++;
					}
				}
				break;
			case 3:
				//South 'X'
				//check if 'X' even exists, if it does then it gets in the if 
				//statement; Notice how we add +1 to coordLat instead of -1, this is because
				//of how arrays are formatted. the further DOWN you go in an array, the larger the number
				//instead of traditional x-y graphs that show the further DOWn you go, the SMALLER the number
				if(coordLat + 1 <= mazeHeight - 1) {
					if(mazeCoordinates[coordLat + 1][coordLong].getMazeValue() != PathAIMazeValue.Wall) {
						//if the mazeValue of the current PathAICoordinate is not .Wall
						//then register it as an open space AND add the direction of the open space in relation
						//of the coordinate original coordinate. 
						
						mazeCoordinates[coordLat][coordLong].addIntersectionDirection(PathAIDirections.South);
						totalOpenSpacesNear++;
					}
				}
				break;
			}
			
		}
		
		return (totalOpenSpacesNear >= 2);

	}
	
	
	//getters and setters
	
	public int getMazeLength() {
		return this.mazeHeight;
	}
	
	public int getMazeWidth() {
		return this.mazeWidth;
	}	
}
