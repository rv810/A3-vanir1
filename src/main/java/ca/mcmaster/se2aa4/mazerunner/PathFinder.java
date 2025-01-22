package ca.mcmaster.se2aa4.mazerunner;
public class PathFinder {
    Maze maze = new Maze();
    String[][] maze_arr = maze.getMaze();
    int[] dimensions = maze.getDimensions();
    private int[] position;
    private int[] start_position;
    private int[] end_position;

    protected PathFinder(Maze maze) {
        this.maze = maze;
    }

    protected void findStart() {
        for (int i=0; i<dimensions[0]; i++) {
            if (maze_arr[i][0] == "PASS" || maze_arr[i][0].contains("\n") ) {
                start_position = new int[]{i, 0};
            }
        }
    }

    protected void findFinish() {
        for (int i=0; i<dimensions[0]; i++) {
            if (maze_arr[i][dimensions[1]] == "PASS") {
                end_position = new int[]{i, dimensions[1]};
            }
        }
    }
}