package ca.mcmaster.se2aa4.mazerunner;

public interface PathFinderFactory {
    PathFinder createPathFinder(Maze maze, Direction startingSide);
}
