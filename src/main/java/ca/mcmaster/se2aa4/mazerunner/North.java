package ca.mcmaster.se2aa4.mazerunner;

public class North extends Compass {

    public int[] Forward(int[] position) {
        int[] new_position = {position[0], position[1]+1};
        return new_position;
    }

    public String Right() {
        return "East";
    }

    public String Left() {
        return "West";
    }
}
