package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PathTest {
    Maze maze = new Maze("./examples/tiny.maz.txt");

    @Test
    public void testWestOpening_StartWestSide() {
        maze.createMaze();
        Path testPath = new Path(maze, Direction.WEST);
        testPath.findWestOpening();

        assertArrayEquals(new int[]{5, 0}, testPath.getStartPosition());
        assertEquals(Direction.EAST, testPath.getDirection());
    }

    @Test
    public void testWestOpening_StartEastSide() {
        maze.createMaze();
        Path testPath = new Path(maze, Direction.EAST);
        testPath.findWestOpening();

        assertArrayEquals(new int[]{5, 0}, testPath.getEndPosition());
        assertEquals(Direction.WEST, testPath.getDirection());
    }

    @Test
    public void testEastOpening_StartEastSide() {
        maze.createMaze();
        Path testPath = new Path(maze, Direction.EAST);
        testPath.findEastOpening();

        assertArrayEquals(new int[]{1, 6}, testPath.getStartPosition());
        assertEquals(Direction.WEST, testPath.getDirection());
    }

    @Test
    public void testEastOpening_StartWestSide() {
        maze.createMaze();
        Path testPath = new Path(maze, Direction.WEST);
        testPath.findEastOpening();

        assertArrayEquals(new int[]{1, 6}, testPath.getEndPosition());
        assertEquals(Direction.EAST, testPath.getDirection());
    }
}
