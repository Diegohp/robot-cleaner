package com.robotcleaner.infrastructure;

import com.robotcleaner.application.CleanCommandHandler;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller to read instructions from file and execute a Command DTO
 * */
public class RobotController {

    private final CleanCommandHandler cleanCommandHandler;

    public RobotController(CleanCommandHandler cleanCommandHandler) {
        this.cleanCommandHandler = cleanCommandHandler;
    }

    public List<String> executeClean(final String filePath) {

        // Getting the all the information lines from file input
        List<String> inputLines = readLines(filePath);

        // Getting the grid size dimensions, Width and Length,
        // as the first line of input clean instructions
        String[] gridSize = inputLines.get(0).split(" ");
        int gridWidth = Integer.parseInt(gridSize[0]);
        int gridLength = Integer.parseInt(gridSize[1]);

        // Creating the list of DTOs for Robots
        List<CleanCommandHandler.CleanCommandDTO.RobotDTO> robots = new ArrayList<>();

        for (int i = 1; i < inputLines.size(); i += 2) {
            // Reading robot data from input lines
            String[] robotData = inputLines.get(i).split(" ");
            // Starting with current position with first and second characters
            int positionX = Integer.parseInt(robotData[0]);
            int positionY = Integer.parseInt(robotData[1]);
            // Then getting orientation as the third character
            String orientation = robotData[2];

            // Finally getting robot movement instructions from input second line
            char[] instructions = inputLines.get(i + 1).toCharArray();

            // Adding the new DTO for a single Robot to the list
            robots.add(new CleanCommandHandler.CleanCommandDTO.RobotDTO(
                    positionX, positionY, orientation, instructions)
            );
        }

        // At the end, executing the Command Handler using a Command DTO
        // with grid dimensions and list of Robots parameters and instructions
        return cleanCommandHandler.execute(
                new CleanCommandHandler.CleanCommandDTO(gridWidth, gridLength, robots)
        );
    }

    public List<String> readLines(final String filePath) {
        try {
            return Files.readAllLines(Paths.get(ClassLoader.getSystemResource(filePath).toURI()));
        } catch (IOException | URISyntaxException | NullPointerException e) {
            throw new RuntimeException("Failed to read instruction file\n", e);
        }
    }
}
