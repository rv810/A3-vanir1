package ca.mcmaster.se2aa4.mazerunner;
public class Player {
    private int[] position;

    protected Player(int[] current_position) {
        this.position = current_position;
    }

    protected int[] getPosition() {
        return position;
    }

    protected void setPosition(int[] new_position) {
        position = new_position;
    }

    protected void Move(String direction) {
        if (direction == "F") {
            position[1]++;
        }

        if (direction == "R") {
            position[0]++;
        }

        if (direction == "F") {
            position[0]--;
        }
    }
}
