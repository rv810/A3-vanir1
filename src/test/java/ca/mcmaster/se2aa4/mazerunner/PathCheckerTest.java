package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PathCheckerTest {
    @Test
    public void testToCanonical() {
        Maze maze = new Maze("tiny.maz.txt");
        maze.createMaze();
        String factorizedPath = "5F 2L 2F R 2F R 2F 2L 2F R 2F R 3F";
        PathChecker path = new PathChecker(maze, Direction.WEST, factorizedPath);

        assertEquals("FFFFF LL FF R FF R FF LL FF R FF R FFF", path.toCanonical(factorizedPath));
    }
}
