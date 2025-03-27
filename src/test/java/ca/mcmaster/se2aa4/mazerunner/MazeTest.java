package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MazeTest {
    Maze maze = new Maze("./examples/tiny.maz.txt");

    @Test
    public void testMazeDimensions() {
        assertArrayEquals(new int[]{7, 7}, maze.getDimensions());
    }
}
