# PathAI

A interesting and fast approach to solving mazes with Java.

## How the AI Works
The way the AI works is in the following steps
* Get path to first intersection
* Send out **workers** to each direction the intersection can go to
* Print out the path's the AI found.

## What is a *worker*?
The worker is what we reference each instance created by the AI. Every time the AI runs into an intersection, it creates a new **worker** that goes to all areas until it does one of 3 things.

* Hits a dead end.
* Runs into another intersection.
* Finds the end point.

For each of these results, one of the following happen.

* If the worker hits a dead end, then nothing happens. 
* If the finds the end point, it tells the original instance the path it found. 
* If it runs into another intersection, it creates new workers for each direction it can go.

All of the workers send their data (in form of array's storing the path they took) to their parent instances, and the parent instances to the PathAI class if they have reached an endpoint. If they have, then print them all.

## Usage
PathAI is still currently in development, but you can watch the repository for updates to see when it is finished.

PathAI works through the following steps

* Create ImageReaderAI Object
* Reference PathAIMaze Instance 
* Call PathAIMaze's setMaze() Method
* Create new PathAI Object

First, we want to create a new ImageReaderAI Object, passing in our maze image

```
ImageIcon icon = new ImageIcon("mazeImage.png");
Image image = icon.getImage();
```

Second, we want to create a reference to a PathAIMaze instance, but we can't create a new object because it is a singleton class

```
PathAIMaze maze = PathAIMaze.getInstance( );
```

Then, we want to call the setMaze() method, passing in the image of our maze

```
maze.setMaze(image);
```

Finally, we want to create the PathAIObject

```
PathAI pathAI = new PathAI(maze);
```


## Authors

* Reagan McFarland - *PathAI* - [Reagan's Github Page](https://github.com/ReaganMcF1059)
* Robbie Sunbury - *ImageReaderAI* - [Robbie's Github Page](https://github.com/Sunrobbie)
