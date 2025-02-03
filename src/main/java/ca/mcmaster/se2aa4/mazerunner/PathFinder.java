package ca.mcmaster.se2aa4.mazerunner;

public abstract class PathFinder extends Path{
    PathFinder(Maze maze, String startingSide) {
        super(maze, startingSide);
    }

    protected String factorizedPath(StringBuilder path) {
        StringBuilder factorizedPath = new StringBuilder();
        int i = 0;

        while (i<path.length()) {
            int counter = 0;
            char currentChar = path.charAt(i);

            while (i<path.length() && path.charAt(i) == currentChar) {
                counter++;
                i++;
            }
            if (counter > 1) {
                factorizedPath.append(counter).append(currentChar).append(" ");
            }
            else {
                factorizedPath.append(currentChar).append(" ");
            }
        }
        return factorizedPath.toString();
    }

    protected abstract String FindPath();
}