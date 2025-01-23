package ca.mcmaster.se2aa4.mazerunner;
public class PathFinder {
    Maze maze;
    String[][] maze_arr;
    int[] dimensions;
    private int[] current_position;
    private int[] start_position;
    private int[] end_position;

    protected PathFinder(Maze maze) {
        this.maze = maze;
        maze_arr = maze.getMaze();
        dimensions = maze.getDimensions();
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

    protected String move() {
        current_position = start_position;
        int counter = 0;

        if (maze_arr[current_position[0]][current_position[1]] == null) {
            for (int i=0; i<dimensions[1]-1; i++) {
                counter++;
            }
        }

        return Integer.toString(counter)+'F';
    }
}