package domain.model;

import java.util.List;

public class Robot {
    private Position position;
    private Orientation orientation;
    private final Grid grid;

    /**
     * Constructor for Robot class. Each robot receives the Grid object
     * to check the Grid Bounds on the received instructions, given
     * by the Position and Orientation objects.
     * */
    public Robot(Position position, Orientation orientation, Grid grid) {
        this.position = position;
        this.orientation = orientation;
        this.grid = grid;
    }

    /**
     * Method to execute instructions for a specific Robot,
     * considering the orientation given, and if the instruction
     * is itself an actual movement.
     * */
    public void executeInstructions(List<Instructions> instructions) {
        for (Instructions instruction : instructions) {
            switch (instruction) {
                case L -> orientation = orientation.turnLeft();
                case R -> orientation = orientation.turnRight();
                case M -> {
                    Position newPos = position.move(orientation);
                    // If position provided is out of Grid bounds,
                    // then we assume that Robot remains in last
                    // position provided
                    if (grid.isWithinGridBounds(newPos)) {
                        position = newPos;
                    }
                }
            }
        }
    }

    /**
     * Method to return the final position and orientation
     * for a Robot after executing all the instructions.
     * */
    public String report() {
        return position + " " + orientation;
    }
}
