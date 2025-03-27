package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DirectionTest {

    @Test
    public void testTurnRight() {
        assertEquals(Direction.EAST, Direction.NORTH.turnRight());
        assertEquals(Direction.SOUTH, Direction.EAST.turnRight());
        assertEquals(Direction.WEST, Direction.SOUTH.turnRight());
        assertEquals(Direction.NORTH, Direction.WEST.turnRight());
    }

    @Test
    public void testTurnLeft() {
        assertEquals(Direction.WEST, Direction.NORTH.turnLeft());
        assertEquals(Direction.NORTH, Direction.EAST.turnLeft());
        assertEquals(Direction.EAST, Direction.SOUTH.turnLeft());
        assertEquals(Direction.SOUTH, Direction.WEST.turnLeft());
    }

    @Test
    public void testMoveForward() {
        int[] startPosition = {2, 2};

        assertArrayEquals(new int[]{1, 2}, Direction.NORTH.moveForward(startPosition));
        assertArrayEquals(new int[]{2, 3}, Direction.EAST.moveForward(startPosition));
        assertArrayEquals(new int[]{3, 2}, Direction.SOUTH.moveForward(startPosition));
        assertArrayEquals(new int[]{2, 1}, Direction.WEST.moveForward(startPosition));
    }
}

