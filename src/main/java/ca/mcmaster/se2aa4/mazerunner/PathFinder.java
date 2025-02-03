package ca.mcmaster.se2aa4.mazerunner;

import java.util.HashMap;

public abstract class PathFinder extends Path{
    HashMap<String, Integer> directionIndices = new HashMap<>();

    PathFinder(Maze maze) {
        super(maze);

        directionIndices.put("North", 0);
        directionIndices.put("East", 1);
        directionIndices.put("South", 2);
        directionIndices.put("West", 3);

        direction = directions.get("East");
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

    protected abstract String move();
}