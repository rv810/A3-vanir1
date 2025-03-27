package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RightHandPathFinderTest {
    Maze maze = new Maze("./examples/tiny.maz.txt");
    RightHandPathFinder finder = new RightHandPathFinder(maze, Direction.WEST);

    @Test
    public void pathFinderTest() {
        maze.createMaze();
        assertEquals("5F 2L 2F R 2F R 2F 2L 2F R 2F R 3F", finder.FindPath());
    }
}
