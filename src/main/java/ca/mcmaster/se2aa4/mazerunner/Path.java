package ca.mcmaster.se2aa4.mazerunner;

import java.util.HashMap;

public class Path {
    Maze maze;
    String[][] maze_arr;
    int[] dimensions;
    int[] current_position;
    int[] start_position;
    int[] end_position;
    Compass direction;
    HashMap<String, Compass> directions = new HashMap<>();

    Path(Maze maze) {
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
}
