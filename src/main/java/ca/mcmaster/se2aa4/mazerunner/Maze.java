package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze {
    private static final Logger logger = LogManager.getLogger();
    private String[][] maze;
    private int[] dimensions;
    String file;

    protected Maze(String fileName) {
        this.file = fileName;
    }

    protected void findDimensions () {
        try {    
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            int rows = 0;
            int cols = 0;

            while ((line = reader.readLine()) != null) {
                rows++;
                cols = line.length();
            }

            dimensions = new int[]{rows, cols};

        } catch (Exception e) {
            logger.warn("/!\\ An error has occured /!\\"); 
        }
    }

    protected void createMaze () {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            int current_row = 0;
            this.findDimensions();

            maze = new String[dimensions[0]][dimensions[1]];

            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < dimensions[1]; idx++) {
                    if (idx < line.length()) {
                        if (line.charAt(idx) == '#') {
                            maze[current_row][idx] = "WALL";
                            System.out.print("WALL ");
                        } else if (line.charAt(idx) == ' ') {
                            maze[current_row][idx] = "PASS";
                            System.out.print("PASS ");
                        }
                    }
                    else {
                        maze[current_row][idx] = "PASS";
                        System.out.print("PASS ");
                    }
                    
                }
                System.out.print(System.lineSeparator());
                current_row++;
            }

        } catch (Exception e) {
            logger.warn("/!\\ An error has occured /!\\"); 
        }
    }

    protected int[] getDimensions() {
        return dimensions;
    }

    protected String[][] getMaze() {
        return maze;
    }
}
