package ca.mcmaster.se2aa4.mazerunner;

public class East extends Compass {
    public int[] Forward(int[] position) {
        int[] new_position = {position[0]+1, position[1]};
        return new_position;
    }

    public String Right() {
        return "South";
    }

    public String Left() {
        return "North";
    }
}
