package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class PathChecker extends Path {
    protected String path;
    protected int directionIndex;
    private static final Logger logger = LogManager.getLogger();
    

    protected PathChecker(Maze maze, Direction startingSide, String input_path) {
        super(maze, startingSide);

        this.path = input_path.replaceAll("\\s", "").trim(); //removes all whitespaces in input path
    }

    protected String toCanonical(String path) {
        StringBuilder converted_path = new StringBuilder();

        for (int i=0; i<path.length(); i++) {
            if (path.charAt(i) > 47 && path.charAt(i) < 58) {
                for (int j=0; j<(path.charAt(i)-'0'); j++) {
                    converted_path.append(path.charAt(i+1));
                }
                i++;
            }
            else {
                converted_path.append(path.charAt(i));
            }
        }
        return converted_path.toString();
    }

    protected boolean checkPath() {
        this.findWestOpening();
        this.findEastOpening();

        current_position = start_position;
        String can_move;

        for (int i=0; i<path.length(); i++) {
            if (path.charAt(i) > 47 && path.charAt(i) < 58) {
                path = this.toCanonical(path);
            }
        }

        try {
            for (int i=0; i<path.length(); i++) {
                if (path.charAt(i) == 'F') {
                    can_move = direction.checkInFront(maze_arr, current_position);
                    if (can_move.equals("pass")) {
                        current_position = direction.moveForward(current_position);
                    }
                    else {
                        return false;
                    } 
                }
                else if (path.charAt(i) == 'R') {
                    direction = direction.turnRight();
                }
                else if (path.charAt(i) == 'L') {
                    direction = direction.turnLeft();
                }
                else {
                    logger.warn("Not a valid direction");
                    break;
                }
            }
        } catch (Exception ArrayIndexOutOfBoundsException) { //If user continues past the exit, path is stil technically correct
            return false;
        }
        

        if (Arrays.equals(current_position, end_position)) {
            return true;
        }
        else {
            return false;
        }
    }
}
