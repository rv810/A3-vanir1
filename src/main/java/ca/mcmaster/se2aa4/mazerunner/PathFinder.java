package ca.mcmaster.se2aa4.mazerunner;
public class PathFinder {
    Maze maze = new Maze();
    String[][] maze_arr = maze.getMaze();

    protected PathFinder(Maze maze) {
        this.maze = maze;
    }

    protected int[] findStart() {
        int[] position = new int[2];
        int[] dimensions = maze.getDimensions();

        for (int i=0; i<dimensions[0]; i++) {
            if (maze_arr[i][0] == "PASS") {
                position = new int[]{i, 0};
            }
        }
        return position;
    }
}