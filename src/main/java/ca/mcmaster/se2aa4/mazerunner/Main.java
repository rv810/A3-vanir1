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

                    PathChecker checkPath = new PathChecker(maze, inputPath);

                    checkPath.findStart();
                    checkPath.findFinish();

                    boolean is_valid = checkPath.checkPath();

                    if (is_valid) {
                        System.out.println("correct path");
                    }
                    else {
                        System.out.println("incorrect path");
                    }
                }

                else {
                    logger.info("**** Computing path");
        
                    PathFinder findPath = new RightHandPathFinder(maze);
        
                    findPath.findStart();
                    findPath.findFinish();
        
                    String path = findPath.move();
        
                    if (path.isEmpty()) {
                        logger.warn("PATH NOT COMPUTED");
                    }

                    else if (path.equals("No way out")) {
                        logger.warn("NO WAY OUT");
                    }
        
                    else {
                        System.out.println("Path: "+ path);
                    }
                    
                    logger.info("** End of MazeRunner");
                }
            }
        } catch (ParseException e) {
            logger.warn("Error parsing arguments: " + e.getMessage());
            formatter.printHelp("CommandLineApp", options);
        }    
    }
}
