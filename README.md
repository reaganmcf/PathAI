# PathAI

A unique approach to solving mazes in Java utilizing rudimentary artificial intelligence.

## How PathAI Works
PathAI solves mazes by using the following steps
* The original **worker** finds the first intersection of the maze
* **Workers** are then sent in each available direction of the intersection, with additional instantiation of **workers** if the original statement is met
* An *ArrayList* of coordinates is then printed to the console

## What is a *worker*?
A worker is the term for each instance of the *PathAISplit* class created by PathAI. Every time PathAI runs into an intersection, it creates a new worker that goes to all areas until it does one of 3 things.

* Hits a dead end
* Runs into another intersection
* Finds the end point

For each of these results, one of the following will happen:

* If the worker hits a dead end, then nothing happens
* If the worker finds the end point, it tells the parent worker the path it found
* If it runs into another intersection, it creates sub workers for each open direction

All of the workers send the pathway data (in form of *ArrayLists*) to their parent workers. in recursion until it reaches the origin worker.

## Usage

PathAI works through the following steps

* Create ImageReaderAI Object
* Get Maze Array From ImageReaderAI Object
* Reference PathAIMaze Instance 
* Call PathAIMaze's setMaze() Method
* Create new PathAI Object

First, we want to create a new ImageReaderAI Object, passing in our maze image

```
ImageReaderAI imageAI = new ImageReaderAI(File file);
```
*Note: you pass in the maze image as file* 

Second, we want to get the maze array from the ImageReaderAI Object
 
```
int[][] mazeArray = imageAI.getMazeArray();
```

Third, we want to create a reference to a PathAIMaze instance, but we can't create a new object because it is a singleton class

```
PathAIMaze maze = PathAIMaze.getInstance( );
```

Then, we want to call the setMaze() method, passing in the image of our maze

```
maze.setMaze(mazeArray);
```

Finally, we want to create the PathAIObject

```
PathAI pathAI = new PathAI(maze);
```


## Authors

* Reagan McFarland - *PathAI* - [Reagan's Github Page](https://github.com/ReaganMcF1059)
* Robbie Sunbury - *ImageReaderAI* - [Robbie's Github Page](https://github.com/Sunrobbie)
