package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.CommandLine;

public class Main {

    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("i", true, "find the path");
        options.addOption("p", true, "input a path");

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();

        Direction startingSide = Direction.WEST; //Change this to East to start from the East side of the maze

        RemoteControl remote = new RemoteControl();

        try {
            CommandLine cmd = parser.parse(options, args);
            logger.info("** Starting Maze Runner");
            logger.info("**** Reading the maze from file " + args[1]);
    
            Maze maze = new Maze(args[1]);
            maze.createMaze();

            if (cmd.hasOption("i")) {
                if (cmd.hasOption("p")) {
                    logger.info("**** Checking if path is correct");

                    StringBuilder remainingArgs = new StringBuilder();
                    for (int i = 3; i < args.length; i++) {
                        remainingArgs.append(args[i]).append(" ");
                    }
                    String inputPath = remainingArgs.toString();

                    CheckPathCommand checkPath = new CheckPathCommand(maze, startingSide, inputPath);
                    remote.setCommand(checkPath);
                    remote.PathOperation();
                }

                else {
                    logger.info("**** Computing path");
        
                    FindPathCommand findPath = new FindPathCommand(maze, startingSide);
                    remote.setCommand(findPath);
                    remote.PathOperation();
                    
                    logger.info("** End of MazeRunner");
                }
            }
        } catch (ParseException e) {
            logger.warn("Error parsing arguments: " + e.getMessage());
            formatter.printHelp("CommandLineApp", options);
        }    
    }
}
