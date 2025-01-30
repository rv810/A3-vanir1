package ca.mcmaster.se2aa4.mazerunner;

public class West {
    public int[] Forward(int[] position) {
        int[] new_position = {position[0]-1, position[1]};
        return new_position;
    }

    public String Right() {
        return "North";
    }

    public String Left() {
        return "South";
    }
}
