package ca.mcmaster.se2aa4.mazerunner;

public class Path {
    protected Maze maze;
    protected String[][] maze_arr;
    protected int[] dimensions;
    protected int[] current_position;
    protected int[] start_position;
    protected int[] end_position;
    protected Direction direction;
    protected Direction startingSide;

    protected Path(Maze maze, Direction startingSide) {
        this.maze = maze;
        maze_arr = maze.getMaze();
        dimensions = maze.getDimensions();
        this.startingSide = startingSide;
    }

    protected void findWestOpening() {
        for (int i=0; i<dimensions[0]; i++) {
            if ("PASS".equals(maze_arr[i][0]) || maze_arr[i][0] == null ) {
                if (startingSide == Direction.WEST) {
                    start_position = new int[]{i, 0};
                    direction = Direction.EAST;
                }
                else {
                    end_position = new int[]{i, 0};
                    direction = Direction.WEST;
                }
            }
        }
    }

    protected void findEastOpening() {
        for (int i=0; i<dimensions[0]; i++) {
            if ("PASS".equals(maze_arr[i][dimensions[1]-1]) || maze_arr[i][dimensions[1]-1] == null) {
                if (startingSide == Direction.EAST) {
                    start_position = new int[]{i, dimensions[1]-1};
                    direction = Direction.WEST;
                }
                else {
                    end_position = new int[]{i, dimensions[1]-1};
                    direction = Direction.EAST;
                }
            }
        }
    }

    //For testing
    public int[] getStartPosition() {
        return start_position;
    }

    public int[] getEndPosition() {
        return end_position;
    }

    public Direction getDirection() {
        return direction;
    }
}