package ca.mcmaster.se2aa4.mazerunner;
public class PathChecker {
    Maze maze;
    String[][] maze_arr;
    int[] dimensions;
    String path;
    private int[] current_position;
    private int[] start_position;
    private int[] end_position;

    protected PathChecker(Maze maze, String input_path) {
        this.maze = maze;
        maze_arr = maze.getMaze();
        dimensions = maze.getDimensions();
        this.path = input_path;
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

    protected boolean checkPath() {
        current_position = start_position;
        int current_row = current_position[0];
        int current_col = current_position[1];
        boolean valid_path = true;

        for (int i=0; i<Character.getNumericValue(path.charAt(0)); i++) {
            if (path.charAt(1) == 'F') {
                if (maze_arr[current_row][current_col+1] == "PASS" || maze_arr[current_row][current_col+1] == null) {
                    valid_path = true;
                    current_col++;
                }
                else {
                    valid_path = false;
                    break;
                }
            }

            if (current_row == end_position[0] && current_col == end_position[1]) {
                valid_path = true;
            }
            else {
                valid_path = false;
            }

        }
        return valid_path;
    }
}
