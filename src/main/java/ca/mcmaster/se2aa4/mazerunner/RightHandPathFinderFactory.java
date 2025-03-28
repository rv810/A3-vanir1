package ca.mcmaster.se2aa4.mazerunner;

public class RightHandPathFinderFactory implements PathFinderFactory {
    public PathFinder createPathFinder(Maze maze, Direction startingSide) {
        return new RightHandPathFinder(maze, startingSide);
    }
}
