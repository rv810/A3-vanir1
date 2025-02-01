package ca.mcmaster.se2aa4.mazerunner;

abstract class Compass {
    abstract int[] Forward(int[] position);
    abstract String checkForward(String[][] maze, int[] position);
    abstract String checkRight(String[][] maze, int[] position);
    abstract String checkLeft(String[][] maze, int[] position);
}