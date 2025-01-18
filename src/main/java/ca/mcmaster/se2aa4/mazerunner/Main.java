package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        if (args[0] == "-i") {
            logger.info("** Starting Maze Runner");

            logger.info("**** Reading the maze from file " + args[1]);
            Maze maze = new Maze();
            maze.createMaze(args[1]);

            maze.displayMaze();

            logger.info("**** Computing path");
            logger.warn("PATH NOT COMPUTED");
            logger.info("** End of MazeRunner");
        }
    }
}
