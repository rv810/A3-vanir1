package ca.mcmaster.se2aa4.mazerunner;

public class South extends Compass {
    public int[] Forward(int[] position) {
        int[] new_position = {position[0], position[1]-1};
        return new_position;
    }

    public String Right() {
        return "West";
    }

    public String Left() {
        return "East";
    }
}
