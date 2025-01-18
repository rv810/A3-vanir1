package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze {
    private static final Logger logger = LogManager.getLogger();
    private String[][] maze;
    private int[] dimensions;

    protected int[] getDimensions (String fileName) {
        try {    
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
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

        return dimensions;
    }

    protected void createMaze (String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int current_row = 0;
            maze = new String[dimensions[0]][dimensions[1]];

            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        maze[current_row][idx] = "WALL";
                    } else if (line.charAt(idx) == ' ') {
                        maze[current_row][idx] = "PASS";
                    }
                }
                System.out.print(System.lineSeparator());
                current_row++;
            }

        } catch (Exception e) {
            logger.warn("/!\\ An error has occured /!\\"); 
        }
    }

    protected void displayMaze() {
        for (String[] row : maze) {
            for (String str : row) {
              System.out.print(str);
            }
            System.out.println();
        }
    }

    protected int[] getDimensions() {
        return dimensions;
    }

    protected String[][] getMaze() {
        return maze;
    }
}
