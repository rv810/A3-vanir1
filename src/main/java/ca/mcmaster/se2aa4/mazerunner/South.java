package ca.mcmaster.se2aa4.mazerunner;

public class South extends Compass {

    @Override
    public int[] Forward(int[] position) {
        int row = position[0];
        int col = position[1];
        int[] new_position = {row+1, col};
        return new_position;
    }

    @Override
    public String checkForward(String[][] maze, int[] position) {
        int row = position[0];
        int col = position[1];

        if (maze[row][col-1].equals("WALL") && maze[row+1][col].equals("PASS")) {
            return "Forward";
        }
        return "Turn";
    }

    @Override
    public String checkRight(String[][] maze, int[] position) {
        int row = position[0];
        int col = position[1];

        if (maze[row+1][col].equals("WALL") && maze[row][col+1].equals("WALL")) {
            return "West";
        }
        return "Other way";
    }

    @Override
    public String checkLeft(String[][] maze, int[] position) {
        int row = position[0];
        int col = position[1];

        if (maze[row+1][col].equals("WALL") && maze[row][col-1].equals("WALL")) {
            return "East";
        }

        return "";
    }
}
