package ca.mcmaster.se2aa4.mazerunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class PathChecker {
    Maze maze;
    String[][] maze_arr;
    int[] dimensions;
    String path;
    private int[] current_position;
    private int[] start_position;
    private int[] end_position;
    Compass direction;
    int directionIndex;
    HashMap<String, Compass> directions = new HashMap<>();
    HashMap<Integer, String> directionIndices = new HashMap<>();

    protected PathChecker(Maze maze, String input_path) {
        this.maze = maze;
        maze_arr = maze.getMaze();
        dimensions = maze.getDimensions();
        this.path = input_path;

        directions.put("East", new East());
        directions.put("North", new North());
        directions.put("South", new South());
        directions.put("West", new West());

        directionIndices.put(0, "North");
        directionIndices.put(1, "East");
        directionIndices.put(2, "South");
        directionIndices.put(3, "West");

        direction = directions.get("East");
        directionIndex = 1;
    }

    protected void findStart() {
        for (int i=0; i<dimensions[0]; i++) {
            if (maze_arr[i][0] == "PASS" || maze_arr[i][0] == null ) {
                start_position = new int[]{i, 0};
            }
        }
    }

    protected void findFinish() {
        for (int i=0; i<dimensions[0]; i++) {
            if (maze_arr[i][dimensions[1]-1] == "PASS" || maze_arr[i][dimensions[1]-1] == null) {
                end_position = new int[]{i, dimensions[1]-1};
            }
        }
    }

    protected String toCanonical(String path) {
        StringBuilder converted_path = new StringBuilder();

        path = path.replaceAll("\\s+","").trim();
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
        current_position = start_position;
        String can_move;
        String new_direction;

        for (int i=0; i<path.length(); i++) {
            if (path.charAt(i) > 47 && path.charAt(i) < 58) {
                path = this.toCanonical(path);
            }
        }

        for (int i=0; i<path.length(); i++) {
            if (path.charAt(i) == 'F') {
                can_move = direction.checkForward(maze_arr, current_position);
                if (can_move.equals("pass")) {
                    current_position = direction.Forward(current_position);
                }
                else {
                    return false;
                } 
            }
            else if (path.charAt(i) == 'R') {
                directionIndex = (directionIndex+5) % 4;
                new_direction = directionIndices.get(directionIndex);
                direction = directions.get(new_direction);
                can_move = direction.checkForward(maze_arr, current_position);
            }
            else if (path.charAt(i) == 'L') {
                directionIndex = (directionIndex+3) % 4;
                new_direction = directionIndices.get(directionIndex);
                direction = directions.get(new_direction);
            }
        }

        if (Arrays.equals(current_position, end_position)) {
            return true;
        }
        else {
            return false;
        }
    }
}
