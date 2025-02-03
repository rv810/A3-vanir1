package ca.mcmaster.se2aa4.mazerunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PathFinder {
    Maze maze;
    String[][] maze_arr;
    int[] dimensions;
    private int[] current_position;
    private int[] start_position;
    private int[] end_position;
    Compass direction;
    HashMap<String, Compass> directions = new HashMap<>();
    HashMap<String, Integer> directionIndices = new HashMap<>();

    protected PathFinder(Maze maze) {
        this.maze = maze;
        maze_arr = maze.getMaze();
        dimensions = maze.getDimensions();

        directions.put("East", new East());
        directions.put("North", new North());
        directions.put("South", new South());
        directions.put("West", new West());

        directionIndices.put("North", 0);
        directionIndices.put("East", 1);
        directionIndices.put("South", 2);
        directionIndices.put("West", 3);

        direction = directions.get("East");
    }

    protected void findStart() {
        for (int i=0; i<dimensions[0]; i++) {
            if ("PASS".equals(maze_arr[i][0]) || maze_arr[i][0] == null ) {
                start_position = new int[]{i, 0};
            }
        }
    }

    protected void findFinish() {
        for (int i=0; i<dimensions[0]; i++) {
            if ("PASS".equals(maze_arr[i][dimensions[1]-1]) || maze_arr[i][dimensions[1]-1] == null) {
                end_position = new int[]{i, dimensions[1]-1};
            }
        }
    }

    protected String factorizedPath(StringBuilder path) {
        StringBuilder factorizedPath = new StringBuilder();
        int i = 0;

        while (i<path.length()) {
            int counter = 0;
            char currentChar = path.charAt(i);

            while (i<path.length() && path.charAt(i) == currentChar) {
                counter++;
                i++;
            }
            factorizedPath.append(counter).append(currentChar).append(" ");
        }
        return factorizedPath.toString();
    }

    protected String move() {
        StringBuilder path = new StringBuilder();
        String factorizedPath;
        int col = start_position[1];
        int row = start_position[0];
        String forward;
        current_position = new int[]{row, col};
        String new_direction;

        while (!Arrays.equals(current_position, end_position)) {
            new_direction = direction.Move(maze_arr, current_position);

            if (new_direction.equals("Forward")) {
                current_position = direction.Forward(current_position);
                path.append("F");
            }

            else if (new_direction.equals("No way out")) {
                return "No way out";
            }

            else {
                int currentDirectionIndex = directionIndices.get(direction.getClass().getSimpleName());
                int newDirectionIndex = directionIndices.get(new_direction);

                if ((newDirectionIndex - currentDirectionIndex + 4) % 4 == 1) {
                    // Right turn (clockwise)
                    path.append("R");
                } else if ((currentDirectionIndex - newDirectionIndex + 4) % 4 == 1) {
                    // Left turn (counterclockwise)
                    path.append("L");
                }

                direction = directions.get(new_direction);
                forward = direction.checkForward(maze_arr, current_position);

                if (forward.equals("pass")) {
                    current_position = direction.Forward(current_position);
                    path.append("F");
                }
            }
        }

        factorizedPath = factorizedPath(path);
        return factorizedPath;
    }
}