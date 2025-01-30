package ca.mcmaster.se2aa4.mazerunner;

abstract class Compass {
    public abstract int[] Forward(int[] position);
    public abstract String Right();
    public abstract String Left();
}