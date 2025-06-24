package application;


import domain.model.Grid;
import domain.model.GridWidth;
import domain.model.GridLength;
import domain.model.Instructions;
import domain.model.Orientation;
import domain.model.Position;
import domain.model.Robot;

import java.util.ArrayList;
import java.util.List;

/**
 * Command Handler to execute DTO given by Infrastructure Layer
 * */
public class CleanCommandHandler {

    public List<String> execute(CleanCommandDTO cleanCommandDTO) {

        List<String> results = new ArrayList<>();

        // Creating new Grid with dimensions given
        Grid grid = new Grid(
                new GridWidth(cleanCommandDTO.gridWidth),
                new GridLength(cleanCommandDTO.gridLength)
        );

        // For each DTO with Robot capabilities, first create a new Robot
        // with the Position, Orientation and Grid to validate movement and bounds;
        // then execute its instructions; and finally get the result report after
        // moving Robot over Grid
        for (CleanCommandDTO.RobotDTO robotAndInstruction : cleanCommandDTO.robotsAndInstructions) {

            Position robotPosition = new Position(robotAndInstruction.positionX, robotAndInstruction.positionY);
            Orientation orientation = Orientation.valueOf(robotAndInstruction.orientation);
            Robot robot = new Robot(robotPosition, orientation, grid);

            // Create a list of Instructions from characters read from
            // input lines
            List<Instructions> instructionsList = new ArrayList<>();
            for (char instruction : robotAndInstruction.instructions) {
                instructionsList.add(Instructions.fromChar(instruction));
            }

            robot.executeInstructions(instructionsList);

            results.add(robot.report());
        }
        return results;
    }

    /**
     * Main Command DTO class to execute instructions from input file
     * */
    public static class CleanCommandDTO {

        public final int gridWidth;
        public final int gridLength;
        public final List<RobotDTO> robotsAndInstructions;

        public CleanCommandDTO(int gridWidth, int gridLength, List<RobotDTO> robotsAndInstructions) {
            this.gridWidth = gridWidth;
            this.gridLength = gridLength;
            this.robotsAndInstructions = robotsAndInstructions;
        }

        /**
         * Robot DTO class to represent Robots and their capabilities
         * */
        public static class RobotDTO {
            public final int positionX;
            public final int positionY;
            public final String orientation;
            public final char[] instructions;

            public RobotDTO(int positionX, int positionY, String orientation, char[] instructions) {
                this.positionX = positionX;
                this.positionY = positionY;
                this.orientation = orientation;
                this.instructions = instructions;
            }
        }
    }
}
