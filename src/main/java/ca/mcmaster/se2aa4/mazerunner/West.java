package ca.mcmaster.se2aa4.mazerunner;

public class West extends Compass{

    @Override
    public int[] moveForward(int[] position) {
        int row = position[0];
        int col = position[1];

        int[] new_position = {row, col-1};
        return new_position;
    }

    @Override
    public String checkInFront(String[][] maze, int[] position) {
        int row = position[0];
        int col = position[1];

        if (maze[row][col-1].equals("PASS")) {
            return "pass";
        }
        return "wall";
    }

    @Override
    public String checkForward(String[][] maze, int[] position) {
        int row = position[0];
        int col = position[1];

        if (maze[row-1][col].equals("WALL") && maze[row][col-1].equals("PASS")) {
            return "Forward";
        }
        return "Check left";
    }

    @Override
    public String checkLeft(String[][] maze, int[] position) {
        int row = position[0];
        int col = position[1];
        if (maze[row][col-1].equals("WALL") && (maze[row-1][col].equals("WALL"))) {
            return "South";
        }
        return "Check right";
    }

    @Override
    public String checkRight(String[][] maze, int[] position) {
        int row = position[0];
        int col = position[1];
        if (maze[row-1][col].equals("PASS")) {
            return "North";
        }
        return "No way out";
    }

    @Override
    public Compass turnLeft() {
        return new South();
    }

    @Override
    public Compass turnRight() {
        return new North();
    }
}