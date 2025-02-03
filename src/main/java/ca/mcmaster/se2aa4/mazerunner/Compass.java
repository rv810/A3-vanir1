package ca.mcmaster.se2aa4.mazerunner;

abstract class Compass {
    abstract int[] Forward(int[] position);
    abstract String checkForward(String[][] maze, int[] position);
    abstract String Move(String[][] maze, int[] position);
}