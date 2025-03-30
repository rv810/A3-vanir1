package ca.mcmaster.se2aa4.mazerunner;

public class CheckPathCommand implements Command {
    Maze maze;
    Direction startingSide;
    String inputPath;

    protected CheckPathCommand(Maze m, Direction side, String path) {
        this.maze = m;
        this.startingSide = side;
        this.inputPath = path;
    }

    public void execute() {
        PathChecker checkPath = new PathChecker(maze, startingSide, inputPath);
        Boolean is_valid = checkPath.checkPath();
        
        if (is_valid) {
            System.out.println("correct path");
        }
        else {
            System.out.println("incorrect path");
        }
    }
}
