package ca.mcmaster.se2aa4.mazerunner;

import java.util.Arrays;

public class RightHandPathFinder extends PathFinder {
    RightHandPathFinder(Maze maze, Direction startingSide) {
        super(maze, startingSide);
    }

    protected String FindPath() {
        StringBuilder path = new StringBuilder();
        String factorizedPath;
        String forward;
        String new_direction;

        this.findWestOpening();
        this.findEastOpening();
        current_position = new int[]{start_position[0], start_position[1]};


        while (!Arrays.equals(current_position, end_position)) {
            new_direction = direction.checkForward(maze_arr, current_position);

            if (new_direction.equals("Forward")) {
                current_position = direction.moveForward(current_position);
                path.append("F");
            }

            else {
                new_direction = direction.checkLeft(maze_arr, current_position);
                if (new_direction.equals("Check right")) {
                    new_direction = direction.checkRight(maze_arr, current_position);
                    if (new_direction.equals("No way out")) {
                        return "No way out";
                    }
                    direction = direction.turnRight();
                    path.append("R");
                }
                else {
                    direction = direction.turnLeft();
                    path.append("L");
                }

                forward = direction.checkInFront(maze_arr, current_position);
                if (forward.equals("pass")) {
                    current_position = direction.moveForward(current_position);
                    path.append("F");
                } 
            }
        }

        factorizedPath = factorizedPath(path);
        return factorizedPath;
    }
}

