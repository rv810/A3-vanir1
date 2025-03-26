package ca.mcmaster.se2aa4.mazerunner;

public enum Direction {    
    NORTH {
        @Override
        public int[] moveForward(int[] position) {
            return new int[]{position[0] - 1, position[1]};
        }
    },
    EAST {
        @Override
        public int[] moveForward(int[] position) {
            return new int[]{position[0], position[1] + 1};
        }
    },
    SOUTH {
        @Override
        public int[] moveForward(int[] position) {
            return new int[]{position[0] + 1, position[1]};
        }
    },
    WEST {
        @Override
        public int[] moveForward(int[] position) {
            return new int[]{position[0], position[1] - 1};
        }
    };

    // Abstract method for each direction
    public abstract int[] moveForward(int[] position);

    // For turning right return next direction in enum order
    public Direction turnRight() {
        return values()[(this.ordinal() + 1) % values().length];
    }

    // For turning left return previous direction in enum order
    public Direction turnLeft() {
        return values()[(this.ordinal() - 1 + values().length) % values().length];
    }

    // Use moveForward method to check if space in front in maze is okay to move to
    public String checkInFront(String[][] maze, int[] position) {
        int[] inFront = moveForward(position);
        int row = inFront[0];
        int col = inFront[1];

        if (maze[row][col].equals("PASS")) {
            return "pass";
        }
        return "wall";
    }

    public String checkForward(String[][] maze, int[] position) {
        int[] newPos = moveForward(position); // Move in forward direction
        int row = newPos[0];
        int col = newPos[1];
    
        if (maze[row][col].equals("PASS")) {
            return "Forward";
        }
        return "Check left";
    }

    public String checkRight(String[][] maze, int[] position) {
        Direction rightDirection = turnRight(); // Get the right direction
        int[] rightPos = rightDirection.moveForward(position); // Move in that direction
        int row = rightPos[0];
        int col = rightPos[1];
    
        if (maze[row][col].equals("PASS")) {
            return rightDirection.name();
        }
        return "No way out";
    }
    
    public String checkLeft(String[][] maze, int[] position) {
        Direction leftDirection = turnLeft(); // Get the left direction
        int[] leftPos = leftDirection.moveForward(position); // Move in that direction
        int row = leftPos[0];
        int col = leftPos[1];
    
        if (maze[row][col].equals("PASS")) {
            return leftDirection.name();
        }
        return "Check right";
    }
    
}
