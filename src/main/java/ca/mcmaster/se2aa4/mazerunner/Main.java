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
            if (cmd.hasOption("i")) {

                logger.info("** Starting Maze Runner");
    
                logger.info("**** Reading the maze from file " + args[1]);
        
                Maze maze = new Maze(args[1]);
                maze.createMaze();
    
                maze.displayMaze();
    
                logger.info("**** Computing path");
    
                PathFinder findPath = new PathFinder(maze);
    
                findPath.findStart();
                findPath.findFinish();
    
                String path = findPath.move();
    
                if (path.isEmpty()) {
                    logger.warn("PATH NOT COMPUTED");
                }
    
                else {
                    System.out.println("Path: "+ path);
                }
                
                logger.info("** End of MazeRunner");
            }

        } catch (ParseException e) {
            System.out.println("Error parsing arguments: " + e.getMessage());
            formatter.printHelp("CommandLineApp", options);
        }    
    }
}
