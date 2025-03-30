package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FindPathCommand implements Command {
    Maze maze;
    Direction startingSide;
    private static final Logger logger = LogManager.getLogger();

    public FindPathCommand(Maze m, Direction side) {
        this.maze = m;
        this.startingSide = side;
    }

    public void execute() {
        PathFinderFactory pathFactory = new RightHandPathFinderFactory();
        PathFinder findPath = pathFactory.createPathFinder(maze, startingSide);
        String path = findPath.FindPath();

        if (path.isEmpty()) {
            logger.warn("PATH NOT COMPUTED");
        }

        else if (path.equals("No way out")) {
            logger.warn("NO WAY OUT");
        }

        else {
            System.out.println("Path: "+ path);
        }
    }
}
