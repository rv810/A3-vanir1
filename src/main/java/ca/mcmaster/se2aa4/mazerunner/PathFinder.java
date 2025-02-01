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
    Map<String, Compass> directions = new HashMap<>();

    protected PathFinder(Maze maze) {
        this.maze = maze;
        maze_arr = maze.getMaze();
        dimensions = maze.getDimensions();

        directions.put("East", new East());
        directions.put("North", new North());
        directions.put("South", new South());
        directions.put("West", new West());

        direction = directions.get("East");
    }

    protected void findStart() {
        for (int i=0; i<dimensions[0]; i++) {
            if (maze_arr[i][0].equals("PASS") || maze_arr[i][0] == null ) {
                start_position = new int[]{i, 0};
            }
        }
    }

    protected void findFinish() {
        for (int i=0; i<dimensions[0]; i++) {
            if (maze_arr[i][dimensions[1]-1].equals("PASS") || maze_arr[i][dimensions[1]-1] == null) {
                end_position = new int[]{i, dimensions[1]-1};
            }
        }
    }

    protected String move() {
        int F_counter = 0;
        String path = "";
        int col = start_position[1];
        int row = start_position[0];
        current_position = new int[]{row, col};
        System.out.println("Starting x and y: " + row + col);
        String new_direction;

        if (maze_arr[row][col] == null) {
            for (int i=0; i<dimensions[1]-1; i++) {
                F_counter++;
            }
            path = path + (F_counter + "F");
            return path;
        }

        while (!Arrays.equals(current_position, end_position)) {
            new_direction = direction.checkForward(maze_arr, current_position);

            if (new_direction.equals("Forward")) {
                current_position = direction.Forward(current_position);
                F_counter++;
            }

            else if (new_direction.equals("Turn")) {
                new_direction = direction.checkRight(maze_arr, current_position);
                System.out.println("New direction: " + new_direction);
                if (new_direction.equals("Other way")) {
                    new_direction = direction.checkLeft(maze_arr, current_position);
                    System.out.println("New direction: " + new_direction);
                    path = path + (F_counter + "F L ");
                    F_counter = 0;
                }
                else {
                    path = path + (F_counter + "F R ");
                    F_counter = 0;
                }
                direction = directions.get(new_direction);
            }
            System.out.println("x: " + current_position[0] + " y: " + current_position[1]);
        }
        return path;
    }
}