package ca.mcmaster.se2aa4.mazerunner;

public class PathFinderFactory {
    Maze maze;
    Direction startingSide;
    public PathFinderFactory(Maze m, Direction start) {
        this.maze = m;
        this.startingSide = start;
    }

    public PathFinder getPathFinder(String finderType) {
        if (finderType == null) {
            return null;
        }
        if (finderType.equalsIgnoreCase("RIGHT HAND")) {
            return new RightHandPathFinder(maze, startingSide);
        }
        return null;
    }
}
